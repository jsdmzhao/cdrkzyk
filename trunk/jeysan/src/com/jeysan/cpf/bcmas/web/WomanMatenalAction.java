package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.WomanMatenal;
import com.jeysan.cpf.bcmas.service.WomanMatenalManager;
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
public class WomanMatenalAction extends CrudActionSupport<WomanMatenal> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private WomanMatenal entity;
	private WomanMatenalManager womanMatenalManager;
	private Page<WomanMatenal> page = new Page<WomanMatenal>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				womanMatenalManager.deleteWomanMatenal(id);
				logger.debug("删除了孕产："+id);
			}else {
				womanMatenalManager.deleteWomanMatenals(ids);
				logger.debug("删除了很多孕产："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除孕产成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"孕产已经被关联,请先解除关联,删除失败":"删除孕产失败");
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
		page = womanMatenalManager.searchWomanMatenal(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new WomanMatenal();
		}else{
			entity = womanMatenalManager.getWomanMatenal(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			womanMatenalManager.saveWomanMatenal(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存孕产成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改孕产成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存孕产失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public WomanMatenal getModel() {
		return entity;
	}
	@Autowired
	public void setWomanMatenalManager(WomanMatenalManager womanMatenalManager) {
		this.womanMatenalManager = womanMatenalManager;
	}
	public Page<WomanMatenal> getPage() {
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
