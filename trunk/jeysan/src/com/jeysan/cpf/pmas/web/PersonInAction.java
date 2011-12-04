package com.jeysan.cpf.pmas.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.pmas.entity.PersonIn;
import com.jeysan.cpf.pmas.service.PersonInManager;
import com.jeysan.cpf.pmas.service.PersonManager;
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
@Namespace("/pmas")
@Results( { @Result(name = "personinquery", location = "personinquery.jsp", type = "dispatcher")})
public class PersonInAction extends PrintActionSupport<PersonIn> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private PersonIn entity;
	private PersonInManager personInManager;
	private PersonManager personManager;
	private Page<PersonIn> page = new Page<PersonIn>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				personInManager.deletePersonIn(id);
				logger.debug("删除了人口流入："+id);
				monitorLogManager.saveMonitorLog("删除人口流入信息", System.currentTimeMillis()-t1_, 1);
			}else {
				personInManager.deletePersonIns(ids);
				logger.debug("删除了很多人口流入："+ids.toString());
				monitorLogManager.saveMonitorLog("删除人口流入信息", System.currentTimeMillis()-t1_, StringUtils.split(ids, ",").length);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除人口流入成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"人口流入已经被关联,请先解除关联,删除失败":"删除人口流入失败");
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
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = personInManager.searchPersonIn(page, filters);
		return SUCCESS;
	}
	public String personinquery() throws Exception {
		list();
		return "personinquery";
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new PersonIn();
		}else{
			entity = personInManager.getPersonIn(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			Long personId = Long.parseLong(Struts2Utils.getParameter("master.dwz_personLookup.personId"));
			entity.setPerson(personManager.getPerson(personId));
			personInManager.savePersonIn(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存人口流入成功");
				result4Json.setAction(Result4Json.SAVE);
				monitorLogManager.saveMonitorLog("增加人口流入信息", System.currentTimeMillis()-t1_, 1);
			}else{
				result4Json.setMessage("修改人口流入成功");
				result4Json.setAction(Result4Json.UPDATE);
				monitorLogManager.saveMonitorLog("修改人口流入信息", System.currentTimeMillis()-t1_, 1);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存人口流入失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public PersonIn getModel() {
		return entity;
	}
	@Autowired
	public void setPersonInManager(PersonInManager personInManager) {
		this.personInManager = personInManager;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	public Page<PersonIn> getPage() {
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
