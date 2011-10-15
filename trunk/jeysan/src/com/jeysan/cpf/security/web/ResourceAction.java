package com.jeysan.cpf.security.web;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.security.entity.Resource;
import com.jeysan.cpf.security.service.ResourceManager;
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
@Namespace("/security")
public class ResourceAction extends CrudActionSupport<Resource> {
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private Resource entity;
	private ResourceManager resourceManager;
	private Page<Resource> page = new Page<Resource>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private Map topLevelResource;
	@Override
	public String delete() throws Exception {
		try {
			if(id!=null){
				resourceManager.deleteResource(id);
				logger.debug("删除了资源："+id);
			}else {
				resourceManager.deleteResources(ids);
				logger.debug("删除了很多资源："+ids.toString());
			}
			//addActionMessage("删除资源成功");
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除资源成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"资源已经被关联,请先解除关联,删除失败":"删除资源失败");
			//throw new ServiceException(e);
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public String input() throws Exception {
		topLevelResource = resourceManager.searchTopLevelResource();
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
		//logger.debug("pageNo:"+Struts2Utils.getRequest().getParameter("pageNo"));
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = resourceManager.searchResource(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Resource();
		}else{
			entity = resourceManager.getResource(id);
		}
	}
	@Override
	public String save() throws Exception {
		try{
			String parentId = Struts2Utils.getParameter("parentId");
			if(StringUtils.isNotEmpty(parentId)){
				Resource parent = new Resource();
				parent.setId(Integer.parseInt(parentId));
				entity.setParent(parent);
			}
			resourceManager.saveResource(entity);
			//addActionMessage("保存资源成功");
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存资源成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改资源成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				/*entity = new Resource();
				DataBeanUtil.copyProperty(entity, Struts2Utils.getRequest());
				entity.setId(null);
				save();*/
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存资源失败");
				//throw new ServiceException(e);
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Resource getModel() {
		return entity;
	}
	@Autowired
	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}
	public Page<Resource> getPage() {
		return page;
	}
	
	public Map getTopLevelResource() {
		return topLevelResource;
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
