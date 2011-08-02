package com.jeysan.cpf.security.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.fireflow.engine.RuntimeContext;
import org.fireflow.engine.definition.WorkflowDefinition;
import org.fireflow.model.WorkflowProcess;
import org.fireflow.model.io.Dom4JFPDLParser;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.workflow.service.WorkFlowManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.JsonUtil;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.security.springsecurity.SpringSecurityUtils;
import com.jeysan.modules.security.springsecurity.SpringUser;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/security")
@Results( { @Result(name = "fileupload-result", location = "../main/fileupload-result.jsp", type = "dispatcher")})
public class WorkFlowAction extends CrudActionSupport<WorkflowDefinition> {
	private static final long serialVersionUID = -1826212472390477005L;
	private String id;
	private String ids;
	private WorkflowDefinition entity;
	private WorkFlowManager workFlowManager;
	private RuntimeContext runtimeContext;
	private Page<WorkflowDefinition> page = new Page<WorkflowDefinition>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private File upload;
	@Override
	public String delete() throws Exception {
		try {
			if(id!=null){
				workFlowManager.deleteWorkflowDefinition(id);
				logger.debug("删除了流程："+id);
			}else {
				workFlowManager.deleteWorkflowDefinitions(ids);
				logger.debug("删除了很多流程："+ids.toString());
			}
			//addActionMessage("删除流程成功");
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除流程成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			//addActionMessage("删除流程失败");
			result4Json.setStatusCode("300");
			result4Json.setMessage("删除流程失败");
			//throw new ServiceException(e);
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String updatestate() throws Exception {
		prepareModel();
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if((!entity.getState())&&StringUtils.isEmpty(entity.getPublishUser())){
				SpringUser currentUser = (SpringUser)SpringSecurityUtils.getCurrentUser();
				entity.setPublishUser(currentUser.getUsername_());
				entity.setPublishTime(runtimeContext.getCalendarService().getSysDate());
			}
			entity.setState(!entity.getState());
			workFlowManager.saveWorkflowDefinition(entity);
			result4Json.setStatusCode("200");
			result4Json.setMessage("操作成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setMessage("操作失败");
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
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//logger.debug("pageNo:"+Struts2Utils.getRequest().getParameter("pageNo"));
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = workFlowManager.searchWorkflowDefinition(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new WorkflowDefinition();
		}else{
			entity = workFlowManager.getWorkflowDefinition(id);
		}
	}
	@Override
	public String save() throws Exception {
		InputStream fis = null;
		try{
			//FileUploadUtils.uploadFileInStruts(upload, uploadFileName, FileUtils.getRealPath(Struts2Utils.getRequest(),"/test"));
			String state = Struts2Utils.getParameter("state");
			fis = new FileInputStream(upload);
			WorkflowProcess process = new Dom4JFPDLParser().parse(fis);
			SpringUser currentUser = (SpringUser)SpringSecurityUtils.getCurrentUser();
			entity.setWorkflowProcess(process);
			entity.setState(StringUtils.equals(state, "1")?true:false);
			entity.setUploadUser(currentUser.getId_().toString());
			entity.setUploadTime(runtimeContext.getCalendarService().getSysDate());
			if (entity.getState()){
				entity.setPublishUser(currentUser.getId_().toString());
				entity.setPublishTime(runtimeContext.getCalendarService().getSysDate());
			}
			workFlowManager.saveWorkflowDefinition(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存流程成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改流程成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
			//result4Json.setCallbackType("closeCurrent");
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存流程失败");
			}
			
		}finally{
			if(fis!=null)
				fis.close();
		}
		Struts2Utils.getRequest().setAttribute("result", JsonUtil.convertBean2JsonString(result4Json));
		return "fileupload-result";
	}
	@Override
	public WorkflowDefinition getModel() {
		return entity;
	}
	@Autowired
	public void setWorkflowManager(WorkFlowManager workFlowManager) {
		this.workFlowManager = workFlowManager;
	}
	@Autowired
	public void setRuntimeContext(RuntimeContext runtimeContext) {
		this.runtimeContext = runtimeContext;
	}
	public Page<WorkflowDefinition> getPage() {
		return page;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
}
