package com.jeysan.cpf.daily.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.comm.service.FileManagerManager;
import com.jeysan.cpf.daily.entity.Rule;
import com.jeysan.cpf.daily.service.RuleManager;
import com.jeysan.modules.action.CrudActionSupport;
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
public class RuleAction extends CrudActionSupport<Rule> {
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
		try {
			if(id!=null){
				Rule rule = ruleManager.getRule(id);
				deleteRuleIncludeAttachment(rule);
				logger.debug("删除了fhp_rule："+id);
			}else {
				if(StringUtils.isNotEmpty(ids)){
					Rule rule = null;
					for(String sid : StringUtils.split(ids,",")){
						rule = ruleManager.getRule(Long.parseLong(sid));
						deleteRuleIncludeAttachment(rule);
					}
				}
				logger.debug("删除了很多fhp_rule："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除fhp_rule成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"fhp_rule已经被关联,请先解除关联,删除失败":"删除fhp_rule失败");
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
		try{
			ruleManager.saveRule(entity);
			fileManagerManager.updateFileManagers2Valid(entity.getAttachment());
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存fhp_rule成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改fhp_rule成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存fhp_rule失败");
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
