package com.jeysan.cpf.daily.web;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.daily.entity.Leave;
import com.jeysan.cpf.daily.service.LeaveManager;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.security.springsecurity.SpringSecurityUtils;
import com.jeysan.modules.security.springsecurity.SpringUser;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;
import com.jeysan.modules.workflow.WorkFlowActionSupport;
import com.jeysan.modules.workflow.WorkflowState;

/**
 * @author 黄静
 *
 */
@Namespace("/daily")
@Results( { @Result(name = "form4wf", location = "leave-form4wf.jsp", type = "dispatcher"),
	@Result(name = "img4wf", location = "leave-img4wf.jsp", type = "dispatcher")})
public class LeaveAction extends WorkFlowActionSupport<Leave> {
	private static final long serialVersionUID = -1826212472390477005L;
	private String ids;
	private Leave entity;
	private LeaveManager leaveManager;
	private Page<Leave> page = new Page<Leave>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				leaveManager.deleteLeave(id);
				logger.debug("删除了请假申请："+id);
			}else {
				leaveManager.deleteLeaves(ids);
				logger.debug("删除了很多请假申请："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除请假申请成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"请假申请已经被关联,请先解除关联,删除失败":"删除请假申请失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public String input() throws Exception {
		return INPUT;
	}
	@Override
	public String view() throws Exception {
		return VIEW;
	}
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		SpringUser currentUser = (SpringUser)SpringSecurityUtils.getCurrentUser();
		PropertyFilter filter = new PropertyFilter("EQI_leaveEmployeeId", currentUser.getId_().toString());
		filters.add(filter);
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("dateKt");
			page.setOrder(Page.DESC);
		}
		page = leaveManager.searchLeave(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Leave();
		}else{
			entity = leaveManager.getLeave(id);
		}
	}
	/**
	 * 保存流程
	 */
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			SpringUser currentUser = (SpringUser)SpringSecurityUtils.getCurrentUser();
			entity.setDateKt(new Date());
			entity.setLeaveEmployeeId(currentUser.getId_());
			entity.setLeaveCount(DateUtil.dateDiff("DATE", new Timestamp(entity.getLeaveStart().getTime()), new Timestamp(entity.getLeaveEnd().getTime()))+1);
			entity.setWfState(WorkflowState.NOSUBMIT);
			entity.setWfLevel(0);
			leaveManager.saveLeave(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存请假申请成功");
				result4Json.setAction(Result4Json.SAVE);
				//result4Json.setAction(Result4Json.DELETE);
				//result4Json.setCallbackType("closeCurrent");
			}else{
				result4Json.setMessage("修改请假申请成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存请假申请失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	/**
	 * 提交流程
	 * @return
	 * @throws Exception
	 */
	public String submitWF() throws Exception {
		prepareModel();
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			entity.setWfLevel(1);
			leaveManager.saveLeave4WF(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("提交申请成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("提交申请成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
			result4Json.setCallbackType("forward");
			result4Json.setForwardUrl(Struts2Utils.getRequest().getContextPath()+"/daily/leave!view.action?id="+id);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("提交申请失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	/**
	 * 保存审批数据：部门经理审批、公司负责人审批
	 */
	@Override
	public String saveBizData() throws Exception{
		prepareModel();
		SpringUser currentUser = (SpringUser)SpringSecurityUtils.getCurrentUser();
		if(level == 2){
			String deptorCheck = Struts2Utils.getParameter("deptorCheck");
			if(StringUtils.isNotEmpty(deptorCheck))
				entity.setDeptorCheck(Integer.parseInt(deptorCheck));
			entity.setDeptorOpinion(Struts2Utils.getParameter("deptorOpinion"));
			entity.setDeptorDate(new Date());
			entity.setDeptor(currentUser.getId_());
		}else if(level == 3){
			String bossCheck = Struts2Utils.getParameter("bossCheck");
			if(StringUtils.isNotEmpty(bossCheck))
				entity.setBossCheck(Integer.parseInt(bossCheck));
			entity.setBossOpinion(Struts2Utils.getParameter("bossOpinion"));
			entity.setBossDate(new Date());
			entity.setBoss(currentUser.getId_());
		}
		if(result4Json == null)
			result4Json = new Result4Json();
		result4Json.setStatusCode("200");
		if(saveOrComplete == 0){
			try{
				leaveManager.saveLeave(entity);
				result4Json.setMessage("保存成功");
				result4Json.setAction(Result4Json.VIEW);//啥事都不干
			}catch(Exception e){
				logger.error(e.getMessage(), e);
				result4Json.setStatusCode("300");
				if(e instanceof ObjectNotFoundException){
					result4Json.setMessage("信息已被删除，请重新添加");
				}else{
					result4Json.setMessage("保存失败");
				}
				
			}
		}else if(saveOrComplete == 1)
			try{
				entity.setWfLevel(level);
				leaveManager.saveLeave(entity,wiid);
				result4Json.setMessage("处理申请成功");
				result4Json.setAction(Result4Json.SAVE);
				result4Json.setCallbackType("closeCurrent");
			}catch(Exception e){
				logger.error(e.getMessage(), e);
				result4Json.setCallbackType(null);
				result4Json.setStatusCode("300");
				if(e instanceof ObjectNotFoundException){
					result4Json.setMessage("信息已被删除，请重新添加");
				}else{
					result4Json.setMessage("处理申请失败");
				}
				
			}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Leave getModel() {
		return entity;
	}
	@Autowired
	public void setLeaveManager(LeaveManager leaveManager) {
		this.leaveManager = leaveManager;
	}
	public Page<Leave> getPage() {
		return page;
	}
	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
}
