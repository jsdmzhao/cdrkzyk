﻿package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.WomanBearAssurance;
import com.jeysan.cpf.bcmas.service.WomanBearAssuranceManager;
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
@Namespace("/bcmas")
public class WomanBearAssuranceAction extends CrudActionSupport<WomanBearAssurance> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private WomanBearAssurance entity;
	private WomanBearAssuranceManager womanBearAssuranceManager;
	private Page<WomanBearAssurance> page = new Page<WomanBearAssurance>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				womanBearAssuranceManager.deleteWomanBearAssurance(id);
				logger.debug("删除了计划生育保险："+id);
			}else {
				womanBearAssuranceManager.deleteWomanBearAssurances(ids);
				logger.debug("删除了很多计划生育保险："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除计划生育保险成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"计划生育保险已经被关联,请先解除关联,删除失败":"删除计划生育保险失败");
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
		page = womanBearAssuranceManager.searchWomanBearAssurance(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new WomanBearAssurance();
		}else{
			entity = womanBearAssuranceManager.getWomanBearAssurance(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			womanBearAssuranceManager.saveWomanBearAssurance(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存计划生育保险成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改计划生育保险成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存计划生育保险失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public WomanBearAssurance getModel() {
		return entity;
	}
	@Autowired
	public void setWomanBearAssuranceManager(WomanBearAssuranceManager womanBearAssuranceManager) {
		this.womanBearAssuranceManager = womanBearAssuranceManager;
	}
	public Page<WomanBearAssurance> getPage() {
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