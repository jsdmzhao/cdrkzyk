package com.jeysan.cpf.pmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.service.PersonBasicManager;
import com.jeysan.cpf.pmas.service.PersonManager;
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
@Namespace("/pmas")
@Results( { @Result(name = "list4lookup", location = "person4lookup.jsp", type = "dispatcher")})
public class PersonAction extends CrudActionSupport<Person> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Person entity;
	private PersonManager personManager;
	private PersonBasicManager personBasicManager;
	private Page<Person> page = new Page<Person>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				personManager.deletePerson(id);
				logger.debug("删除了人员："+id);
			}else {
				personManager.deletePersons(ids);
				logger.debug("删除了很多人员："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除人员成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"人员已经被关联,请先解除关联,删除失败":"删除人员失败");
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
		page = personManager.searchPerson(page, filters);
		return SUCCESS;
	}
	public String list4lookup() throws Exception {
		list();
		return "list4lookup";
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Person();
		}else{
			entity = personManager.getPerson(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			personManager.savePerson(entity);
			entity.getPersonBasic().setPerson(entity);
			personBasicManager.savePersonBasic(entity.getPersonBasic());
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存人员成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改人员成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存人员失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Person getModel() {
		return entity;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	@Autowired
	public void setPersonBasicManager(PersonBasicManager personBasicManager) {
		this.personBasicManager = personBasicManager;
	}
	public Page<Person> getPage() {
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
