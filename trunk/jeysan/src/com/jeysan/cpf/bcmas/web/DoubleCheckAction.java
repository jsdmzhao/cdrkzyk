﻿package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.DoubleCheck;
import com.jeysan.cpf.bcmas.service.DoubleCheckManager;
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
public class DoubleCheckAction extends CrudActionSupport<DoubleCheck> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private DoubleCheck entity;
	private DoubleCheckManager doubleCheckManager;
	private Page<DoubleCheck> page = new Page<DoubleCheck>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				doubleCheckManager.deleteDoubleCheck(id);
				logger.debug("删除了双查轮次："+id);
			}else {
				doubleCheckManager.deleteDoubleChecks(ids);
				logger.debug("删除了很多双查轮次："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除双查轮次成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"双查轮次已经被关联,请先解除关联,删除失败":"删除双查轮次失败");
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
		page = doubleCheckManager.searchDoubleCheck(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new DoubleCheck();
		}else{
			entity = doubleCheckManager.getDoubleCheck(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			doubleCheckManager.saveDoubleCheck(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存双查轮次成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改双查轮次成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存双查轮次失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public DoubleCheck getModel() {
		return entity;
	}
	@Autowired
	public void setDoubleCheckManager(DoubleCheckManager doubleCheckManager) {
		this.doubleCheckManager = doubleCheckManager;
	}
	public Page<DoubleCheck> getPage() {
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
