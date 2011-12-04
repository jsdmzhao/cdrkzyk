﻿package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.WomanBasic;
import com.jeysan.cpf.bcmas.service.WomanBasicManager;
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
public class WomanBasicAction extends CrudActionSupport<WomanBasic> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private WomanBasic entity;
	private WomanBasicManager womanBasicManager;
	private Page<WomanBasic> page = new Page<WomanBasic>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				womanBasicManager.deleteWomanBasic(id);
				logger.debug("删除了基础信息："+id);
			}else {
				womanBasicManager.deleteWomanBasics(ids);
				logger.debug("删除了很多基础信息："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除基础信息成功");
			result4Json.setAction(Result4Json.DELETE);
			
			monitorLogManager.saveMonitorLog("删除育龄妇女基础信息", System.currentTimeMillis()-t1_, id!=null?1:StringUtils.split(ids, ",").length);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"基础信息已经被关联,请先解除关联,删除失败":"删除基础信息失败");
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
		page.setPageSize(-1);
		page = womanBasicManager.searchWomanBasic(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new WomanBasic();
		}else{
			entity = womanBasicManager.getWomanBasic(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			womanBasicManager.saveWomanBasic(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存基础信息成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改基础信息成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
			
			monitorLogManager.saveMonitorLog((id == null?"增加":"修改")+"育龄妇女基础信息信息", System.currentTimeMillis()-t1_, 1);

		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存基础信息失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public WomanBasic getModel() {
		return entity;
	}
	@Autowired
	public void setWomanBasicManager(WomanBasicManager womanBasicManager) {
		this.womanBasicManager = womanBasicManager;
	}
	public Page<WomanBasic> getPage() {
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
