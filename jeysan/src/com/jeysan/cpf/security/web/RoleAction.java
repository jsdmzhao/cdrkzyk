package com.jeysan.cpf.security.web;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.security.entity.Resource;
import com.jeysan.cpf.security.entity.Role;
import com.jeysan.cpf.security.service.ResourceManager;
import com.jeysan.cpf.security.service.RoleManager;
import com.jeysan.cpf.security.util.ResourceUtils;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.hibernate.HibernateUtils;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/security")
@Results( { @Result(name = "preAssignResources", location = "roleresource-input.jsp", type = "dispatcher")})
public class RoleAction extends CrudActionSupport<Role> {
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private Role entity;
	private RoleManager roleManager;
	private ResourceManager resourceManager;
	private Map<Resource,List> allResources;
	private Map<Resource,List> hasResources;
	private Page<Role> page = new Page<Role>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private List<Integer> checkedResourceIds; //页面中钩选的资源id列表
	@Override
	public String delete() throws Exception {
		try {
			if(id!=null){
				roleManager.deleteRole(id);
				logger.debug("删除了角色："+id);
			}else {
				roleManager.deleteRoles(ids);
				logger.debug("删除了很多角色："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除角色成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage("删除角色失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String preAssignResources() throws Exception{
		prepareModel();
		hasResources = ResourceUtils.reset2Map4ExistsResources(entity.getResourceList(), null);
		allResources = resourceManager.getAllResources(null,entity.getResourceList());
		return "preAssignResources";
	}
	
	public String saveAssignResources() throws Exception{
		boolean flag = false;
		try{
			prepareModel();
			HibernateUtils.mergeByCheckedIds(entity.getResourceList(), checkedResourceIds, Resource.class);
			roleManager.saveRole(entity);
			flag = true;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		if(result4Json == null)
			result4Json = new Result4Json();
		result4Json.setStatusCode(flag?"200":"300");
		result4Json.setMessage(flag?"分配资源成功":"分配资源失败");
		result4Json.setAction(Result4Json.SAVE);
		Struts2Utils.renderJson(result4Json);
		return "none";
	}
	@Override
	public String input() throws Exception {
		return INPUT;
	}
	@Override
	public String view() throws Exception {
		hasResources = ResourceUtils.reset2Map4ExistsResources(entity.getResourceList(), null);
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
		page = roleManager.searchRole(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Role();
		}else{
			entity = roleManager.getRole(id);
		}
	}
	@Override
	public String save() throws Exception {
		try{
			roleManager.saveRole(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存角色成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改角色成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存角色失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Role getModel() {
		return entity;
	}
	@Autowired
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}
	@Autowired
	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}
	
	public Map<Resource, List> getAllResources() {
		return allResources;
	}
	public Page<Role> getPage() {
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
	public void setCheckedResourceIds(List<Integer> checkedResourceIds) {
		this.checkedResourceIds = checkedResourceIds;
	}
	public Role getEntity() {
		return entity;
	}
	public Map<Resource, List> getHasResources() {
		return hasResources;
	}
	
	
}
