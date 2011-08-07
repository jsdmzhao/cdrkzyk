﻿package com.jeysan.cpf.monitor.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.monitor.entity.MonitorSwitch;
import com.jeysan.cpf.monitor.service.MonitorSwitchManager;
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
@Namespace("/monitor")
public class MonitorSwitchAction extends CrudActionSupport<MonitorSwitch> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private MonitorSwitch entity;
	private MonitorSwitchManager monitorSwitchManager;
	private Page<MonitorSwitch> page = new Page<MonitorSwitch>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				monitorSwitchManager.deleteMonitorSwitch(id);
				logger.debug("删除了监控开关："+id);
			}else {
				monitorSwitchManager.deleteMonitorSwitchs(ids);
				logger.debug("删除了很多监控开关："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除监控开关成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"监控开关已经被关联,请先解除关联,删除失败":"删除监控开关失败");
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
		page = monitorSwitchManager.searchMonitorSwitch(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new MonitorSwitch();
		}else{
			entity = monitorSwitchManager.getMonitorSwitch(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			monitorSwitchManager.saveMonitorSwitch(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存监控开关成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改监控开关成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存监控开关失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public MonitorSwitch getModel() {
		return entity;
	}
	@Autowired
	public void setMonitorSwitchManager(MonitorSwitchManager monitorSwitchManager) {
		this.monitorSwitchManager = monitorSwitchManager;
	}
	public Page<MonitorSwitch> getPage() {
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
