package com.jeysan.cpf.pmas.web;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.entity.PersonOut;
import com.jeysan.cpf.pmas.service.PersonManager;
import com.jeysan.cpf.pmas.service.PersonOutManager;
import com.jeysan.cpf.util.Constants;
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
@Results( { @Result(name = "personoutquery", location = "personoutquery.jsp", type = "dispatcher")})
public class PersonOutAction extends PrintActionSupport<PersonOut> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private PersonOut entity;
	private PersonOutManager personOutManager;
	private PersonManager personManager;
	private Page<PersonOut> page = new Page<PersonOut>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				personOutManager.deletePersonOut(id);
				logger.debug("删除了人口流出："+id);
				monitorLogManager.saveMonitorLog("删除人口流出信息", System.currentTimeMillis()-t1_, 1);
			}else {
				personOutManager.deletePersonOuts(ids);
				logger.debug("删除了很多人口流出："+ids.toString());
				monitorLogManager.saveMonitorLog("删除人口流出信息", System.currentTimeMillis()-t1_, StringUtils.split(ids, ",").length);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除人口流出成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"人口流出已经被关联,请先解除关联,删除失败":"删除人口流出失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String personoutquery() throws Exception {
		list();
		return "personoutquery";
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
		setDataAuth(filters, "person.area");
		page = personOutManager.searchPersonOut(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new PersonOut();
		}else{
			entity = personOutManager.getPersonOut(id);
			/*person = personManager.getPerson(entity.getPersonId());
			Struts2Utils.getRequest().setAttribute("person", person);*/
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
			personOutManager.savePersonOut(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存人口流出成功");
				result4Json.setAction(Result4Json.SAVE);
				monitorLogManager.saveMonitorLog("增加人口流出信息", System.currentTimeMillis()-t1_, 1);
			}else{
				result4Json.setMessage("修改人口流出成功");
				result4Json.setAction(Result4Json.UPDATE);
				monitorLogManager.saveMonitorLog("修改人口流出信息", System.currentTimeMillis()-t1_, 1);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存人口流出失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String cancel() throws Exception {
		String personId = Struts2Utils.getParameter("personId");
		String type = Struts2Utils.getParameter("type");
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			Person person = personManager.getPerson(Long.parseLong(personId));
			result4Json.setStatusCode("200");
			result4Json.setAction(Result4Json.UPDATE);
			if(StringUtils.equals(type, "0")){
				person.setCancelType(Constants.CANCEL_TYPE.PERSON_OUT);
				person.setCancelDate(new Date());
				result4Json.setMessage("注销成功");
				monitorLogManager.saveMonitorLog("注销流出人员", System.currentTimeMillis()-t1_, 1);
			}else if(StringUtils.equals(type, "1")){
				person.setCancelType(673);
				person.setCancelDate(new Date());
				result4Json.setMessage("恢复注销成功");
				monitorLogManager.saveMonitorLog("恢复注销人员", System.currentTimeMillis()-t1_, 1);
			}
			personManager.savePerson(person);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("操作失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public PersonOut getModel() {
		return entity;
	}
	@Autowired
	public void setPersonOutManager(PersonOutManager personOutManager) {
		this.personOutManager = personOutManager;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	public Page<PersonOut> getPage() {
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
