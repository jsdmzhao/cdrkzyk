package com.jeysan.cpf.daily.web;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.fireflow.engine.IWorkItem;
import org.fireflow.engine.impl.ProcessInstance;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.daily.entity.Leave;
import com.jeysan.cpf.daily.service.LeaveManager;
import com.jeysan.cpf.workflow.service.ProcessInstanceManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.security.springsecurity.SpringSecurityUtils;
import com.jeysan.modules.security.springsecurity.SpringUser;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 * 暂时无效，有待修改
 *
 */
@Namespace("/daily")
public class ProcessInstanceAction extends CrudActionSupport<ProcessInstance> {
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private ProcessInstance entity;
	private ProcessInstanceManager processInstanceManager;
	private Page<IWorkItem> page = new Page<IWorkItem>(DEFAULT_PAGE_SIZE);
	private List<IWorkItem> myTodoWorkitems = null;
	private List<IWorkItem> myHaveDoneWorkItems = null;
	String selectedWorkItemId = null;
	private Result4Json result4Json;
	private LeaveManager leaveManager;
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
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		//page = leaveManager.searchLeave(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		/*if(id == null){
			entity = new Leave();
		}else{
			entity = leaveManager.getLeave(id);
		}*/
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			SpringUser currentUser = (SpringUser)SpringSecurityUtils.getCurrentUser();
			/*entity.setDateKt(new Date());
			entity.setLeaveEmployeeId(currentUser.getId_());
			entity.setLeaveCount(DateUtil.dateDiff("DATE", new Timestamp(entity.getLeaveStart().getTime()), new Timestamp(entity.getLeaveEnd().getTime()))+1);
			leaveManager.saveLeave(entity);*/
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存请假申请成功");
				result4Json.setAction(Result4Json.SAVE);
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
	@Override
	public ProcessInstance getModel() {
		return entity;
	}
	public Page<Leave> getPage() {
		return null;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}
	public List<IWorkItem> getMyTodoWorkitems() {
		return myTodoWorkitems;
	}
	public List<IWorkItem> getMyHaveDoneWorkItems() {
		return myHaveDoneWorkItems;
	}
	@Autowired
	public void setProcessInstanceManager(ProcessInstanceManager processInstanceManager) {
		this.processInstanceManager = processInstanceManager;
	}
	@Autowired
	public void setLeaveManager(LeaveManager leaveManager) {
		this.leaveManager = leaveManager;
	}
	
}
