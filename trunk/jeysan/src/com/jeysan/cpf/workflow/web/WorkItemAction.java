package com.jeysan.cpf.workflow.web;

import org.apache.struts2.convention.annotation.Namespace;
import org.fireflow.engine.RuntimeContext;
import org.fireflow.engine.impl.WorkItem;
import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.workflow.service.WorkItemManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.action.DispatcherUtil;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.security.springsecurity.SpringSecurityUtils;
import com.jeysan.modules.security.springsecurity.SpringUser;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;
import com.jeysan.modules.workflow.WorkflowUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 黄静
 *
 */
@Namespace("/workflow")
public class WorkItemAction extends ActionSupport {
	private static final long serialVersionUID = -5765574624787711575L;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private String wiid;
	private WorkItemManager workItemManager;
	private RuntimeContext runtimeContext;
	private Page<WorkItem> page = new Page<WorkItem>(CrudActionSupport.DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private Integer type;
	
	public String list() throws Exception {
		//List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		SpringUser currentUser = (SpringUser)SpringSecurityUtils.getCurrentUser();
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("createdTime");
			page.setOrder(type==0?Page.ASC:Page.DESC);
		}
		if(type == 0)
			page = workItemManager.findTodoWorkItems(page, currentUser.getId_().toString());
		else if(type == 1)
			page = workItemManager.findHaveDoneWorkItems(page, currentUser.getId_().toString());
		return SUCCESS;
	}
	
	public String claim() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(StringUtils.isNotEmpty(wiid)){
				workItemManager.claimWorkItem(wiid);
				logger.debug("签收了申请："+wiid);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("签收申请成功");
			result4Json.setAction(Result4Json.UPDATE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage("签收申请失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	
	public String openform() throws Exception {
		boolean flag = false;
		String formUrl = null;
		try {
			formUrl = WorkflowUtil.getFormUri2(Struts2Utils.getRequest(), runtimeContext, wiid,type==0?"ViewFormUrl":"EditFormUrl");
			if(StringUtils.isNotEmpty(formUrl)){
				flag = true;
				DispatcherUtil.forward(formUrl);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if(flag)
			return null;
		else{
			if(result4Json == null)
				result4Json = new Result4Json();
			result4Json.setStatusCode("300");
			result4Json.setMessage("预处理申请失败：URL链接不存在："+formUrl);
			Struts2Utils.renderJson(result4Json);
			return NONE;
		}
	}
	
	public String complete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(StringUtils.isNotEmpty(wiid)){
				workItemManager.completeWorkItem(wiid);
				logger.debug("处理了申请："+wiid);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("处理申请成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage("处理申请失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}

	public String getWiid() {
		return wiid;
	}

	public void setWiid(String wiid) {
		this.wiid = wiid;
	}

	public Result4Json getResult4Json() {
		return result4Json;
	}

	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}

	public Page<WorkItem> getPage() {
		return page;
	}
	@Autowired
	public void setWorkItemManager(WorkItemManager workItemManager) {
		this.workItemManager = workItemManager;
	}
	@Autowired
	public void setRuntimeContext(RuntimeContext runtimeContext) {
		this.runtimeContext = runtimeContext;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}
	
}
