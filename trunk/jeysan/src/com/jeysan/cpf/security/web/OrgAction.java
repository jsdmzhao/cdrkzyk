/**
 * 
 */
package com.jeysan.cpf.security.web;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.security.entity.Org;
import com.jeysan.cpf.security.service.OrgManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.RequestUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/security")
@Results( { @Result(name = "preOrgSelect", location = "orgselect.jsp", type = "dispatcher")})
public class OrgAction extends CrudActionSupport<Org> {
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private Org entity;
	private OrgManager orgManager;
	private Page<Org> page = new Page<Org>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private List<Org> level1OrgList ;
	@Override
	public String delete() throws Exception {
		try {
			if(id!=null){
				orgManager.deleteOrg(id);
				logger.debug("删除了机构："+id);
			}else {
				orgManager.deleteOrgs(ids);
				logger.debug("删除了很多机构："+ids.toString());
			}
			//addActionMessage("删除机构成功");
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除机构成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			//addActionMessage("删除机构失败");
			result4Json.setStatusCode("300");
			result4Json.setMessage("删除机构失败");
			//throw new ServiceException(e);
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	/**
	 * 通用：选择机构
	 * @return
	 * @throws Exception
	 */
	public String preOrgSelect() throws Exception {
		level1OrgList = orgManager.searchOrg(1);
		RequestUtil.setAttribute(Struts2Utils.getRequest(), "o1");
		RequestUtil.setAttribute(Struts2Utils.getRequest(), "o2");
		RequestUtil.setAttribute(Struts2Utils.getRequest(), "o3");
		return "preOrgSelect";
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
		//logger.debug("pageNo:"+Struts2Utils.getRequest().getParameter("pageNo"));
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = orgManager.searchOrg(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Org();
		}else{
			entity = orgManager.getOrg(id);
		}
	}
	@Override
	public String save() throws Exception {
		try{
			String parentId = Struts2Utils.getParameter("parentId");
			if(StringUtils.isNotEmpty(parentId)){
				Org parent = orgManager.getOrg(Integer.parseInt(parentId));
				entity.setParent(parent);
				entity.setLevelNum(parent.getLevelNum()+1);
			}else
				entity.setLevelNum(1);
			orgManager.saveOrg(entity);
			//addActionMessage("保存机构成功");
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存机构成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改机构成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				/*entity = new Org();
				DataBeanUtil.copyProperty(entity, Struts2Utils.getRequest());
				entity.setId(null);
				save();*/
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存机构失败");
				//throw new ServiceException(e);
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Org getModel() {
		return entity;
	}
	@Autowired
	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}
	public Page<Org> getPage() {
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
	public List<Org> getLevel1OrgList() {
		return level1OrgList;
	}
	
	
}
