package com.jeysan.cpf.pmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.entity.Spouse;
import com.jeysan.cpf.pmas.service.PersonManager;
import com.jeysan.cpf.pmas.service.SpouseManager;
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
public class SpouseAction extends CrudActionSupport<Spouse> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Spouse entity;
	private SpouseManager spouseManager;
	private PersonManager personManager;
	private Page<Spouse> page = new Page<Spouse>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				spouseManager.deleteSpouse(id);
				logger.debug("删除了配偶表："+id);
			}else {
				spouseManager.deleteSpouses(ids);
				logger.debug("删除了很多配偶表："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除配偶表成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"配偶表已经被关联,请先解除关联,删除失败":"删除配偶表失败");
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
		page = spouseManager.searchSpouse(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			String personId = Struts2Utils.getParameter("personId");
			if(StringUtils.isNotEmpty(personId)){
				Long personIdL = Long.parseLong(personId);
				entity = spouseManager.getSpouseByPersonId(personIdL);
				if(entity == null)
					Struts2Utils.getRequest().setAttribute("person",personManager.getPerson(personIdL));
			}
			if(entity == null)
				entity = new Spouse();
		}else{
			entity = spouseManager.getSpouse(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			String personId = Struts2Utils.getParameter("personId");
			Person person = new Person();
			person.setId(Long.parseLong(personId));
			entity.setPerson(person);
			spouseManager.saveSpouse(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存配偶表成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改配偶表成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存配偶表失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Spouse getModel() {
		return entity;
	}
	@Autowired
	public void setSpouseManager(SpouseManager spouseManager) {
		this.spouseManager = spouseManager;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	public Page<Spouse> getPage() {
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
