﻿package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.DoubleCheckDetail;
import com.jeysan.cpf.bcmas.service.DoubleCheckDetailManager;
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
public class DoubleCheckDetailAction extends CrudActionSupport<DoubleCheckDetail> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private DoubleCheckDetail entity;
	private DoubleCheckDetailManager doubleCheckDetailManager;
	private Page<DoubleCheckDetail> page = new Page<DoubleCheckDetail>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				doubleCheckDetailManager.deleteDoubleCheckDetail(id);
				logger.debug("删除了双查轮次详情："+id);
			}else {
				doubleCheckDetailManager.deleteDoubleCheckDetails(ids);
				logger.debug("删除了很多双查轮次详情："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除双查轮次详情成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"双查轮次详情已经被关联,请先解除关联,删除失败":"删除双查轮次详情失败");
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
		page = doubleCheckDetailManager.searchDoubleCheckDetail(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new DoubleCheckDetail();
		}else{
			entity = doubleCheckDetailManager.getDoubleCheckDetail(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			doubleCheckDetailManager.saveDoubleCheckDetail(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存双查轮次详情成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改双查轮次详情成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存双查轮次详情失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public DoubleCheckDetail getModel() {
		return entity;
	}
	@Autowired
	public void setDoubleCheckDetailManager(DoubleCheckDetailManager doubleCheckDetailManager) {
		this.doubleCheckDetailManager = doubleCheckDetailManager;
	}
	public Page<DoubleCheckDetail> getPage() {
		return page;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}
	
	
}
