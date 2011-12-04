package com.jeysan.cpf.daily.web;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.comm.service.FileManagerManager;
import com.jeysan.cpf.daily.entity.Rule;
import com.jeysan.cpf.daily.service.RuleManager;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.modules.action.PrintActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/daily")
public class RuleAction extends PrintActionSupport<Rule> {
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Rule entity;
	private RuleManager ruleManager;
	private FileManagerManager fileManagerManager;
	private Page<Rule> page = new Page<Rule>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		String filter_EQI_typeh = StringUtils.trim(Struts2Utils.getRequest().getParameter("filter_EQI_typeh"));
		String title = null;
		if(StringUtils.equals(filter_EQI_typeh, "0"))
			title = "规章制度";
		else if(StringUtils.equals(filter_EQI_typeh, "0"))
			title = "法律法规";
		else if(StringUtils.equals(filter_EQI_typeh, "0"))
			title = "通知通报";
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				Rule rule = ruleManager.getRule(id);
				deleteRuleIncludeAttachment(rule);
				logger.debug("删除了"+title+"："+id);
			}else {
				if(StringUtils.isNotEmpty(ids)){
					Rule rule = null;
					for(String sid : StringUtils.split(ids,",")){
						rule = ruleManager.getRule(Long.parseLong(sid));
						deleteRuleIncludeAttachment(rule);
					}
				}
				logger.debug("删除了很多"+title+"："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除"+title+"成功");
			result4Json.setAction(Result4Json.DELETE);
			
			monitorLogManager.saveMonitorLog("删除"+title+"信息", System.currentTimeMillis()-t1_, id!=null?1:StringUtils.split(ids, ",").length);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?(title+"已经被关联,请先解除关联,删除失败"):("删除"+title+"失败"));
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	private void deleteRuleIncludeAttachment(Rule rule){
		String attachment = rule.getAttachment();
		ruleManager.deleteRule(rule);
		if(StringUtils.isNotEmpty(attachment)){
			fileManagerManager.deleteFileManagerByIds(attachment);
		}
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
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = ruleManager.searchRule(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Rule();
		}else{
			entity = ruleManager.getRule(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		String filter_EQI_typeh = StringUtils.trim(Struts2Utils.getRequest().getParameter("filter_EQI_typeh"));
		String title = null;
		if(StringUtils.equals(filter_EQI_typeh, "0"))
			title = "规章制度";
		else if(StringUtils.equals(filter_EQI_typeh, "0"))
			title = "法律法规";
		else if(StringUtils.equals(filter_EQI_typeh, "0"))
			title = "通知通报";
		try{
			long t1_ = System.currentTimeMillis();
			if(entity.getSendEmployeeId() == null){
				User user = (User)Struts2Utils.getRequest().getSession().getAttribute("_js_user");
				entity.setSendEmployeeId(new Long(user.getId()));
			}
			if(entity.getDateKt() == null)
				entity.setDateKt(new Date());
			ruleManager.saveRule(entity);
			fileManagerManager.updateFileManagers2Valid(entity.getAttachment());
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存"+title+"成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改"+title+"成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
			
			monitorLogManager.saveMonitorLog((id == null?"增加":"修改")+title+"信息", System.currentTimeMillis()-t1_, 1);

		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存"+title+"失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Rule getModel() {
		return entity;
	}
	@Autowired
	public void setRuleManager(RuleManager ruleManager) {
		this.ruleManager = ruleManager;
	}
	@Autowired
	public void setFileManagerManager(FileManagerManager fileManagerManager) {
		this.fileManagerManager = fileManagerManager;
	}
	public Page<Rule> getPage() {
		return page;
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
	
	
}
