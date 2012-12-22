package com.jeysan.cpf.bcmas.web;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.DeathReg;
import com.jeysan.cpf.bcmas.service.DeathRegManager;
import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.service.PersonManager;
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
@Namespace("/bcmas")
public class DeathRegAction extends PrintActionSupport<DeathReg> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private DeathReg entity;
	private DeathRegManager deathRegManager;
	private PersonManager personManager;
	private Page<DeathReg> page = new Page<DeathReg>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				deathRegManager.deleteDeathReg(id);
				logger.debug("删除了死亡登记："+id);
			}else {
				deathRegManager.deleteDeathRegs(ids);
				logger.debug("删除了很多死亡登记："+ids.toString());
			}
			monitorLogManager.saveMonitorLog("删除死亡登记信息", System.currentTimeMillis()-t1_, id!=null?1:StringUtils.split(ids, ",").length);

			result4Json.setStatusCode("200");
			result4Json.setMessage("删除死亡登记成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"死亡登记已经被关联,请先解除关联,删除失败":"删除死亡登记失败");
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
		setDataAuth(filters, "person.area");
		page = deathRegManager.searchDeathReg(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new DeathReg();
		}else{
			entity = deathRegManager.getDeathReg(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			Person person = null;
			if(id == null){
				String personId = Struts2Utils.getParameter("master.dwz_personLookup.personId");
				person = personManager.getPerson(Long.parseLong(personId));
				person.setCancelType(Constants.CANCEL_TYPE.DEATH);
				person.setCancelDate(new Date());
				personManager.savePerson(person);
				entity.setPerson(person);
			}
			deathRegManager.saveDeathReg(entity);
			result4Json.setStatusCode("200");
			monitorLogManager.saveMonitorLog((id == null?"增加":"修改")+"死亡登记信息", System.currentTimeMillis()-t1_, 1);

			if(id == null){
				result4Json.setMessage("保存死亡登记成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改死亡登记成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存死亡登记失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public DeathReg getModel() {
		return entity;
	}
	@Autowired
	public void setDeathRegManager(DeathRegManager deathRegManager) {
		this.deathRegManager = deathRegManager;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	public Page<DeathReg> getPage() {
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
