package com.jeysan.cpf.security.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.security.entity.DictSub;
import com.jeysan.cpf.security.service.DictSubManager;
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
public class DictSubAction extends CrudActionSupport<DictSub> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private DictSub entity;
	private DictSubManager dictSubManager;
	private Page<DictSub> page = new Page<DictSub>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		try {
			if(id!=null){
				dictSubManager.deleteDictSub(id);
				logger.debug("删除了字典子项："+id);
			}else {
				dictSubManager.deleteDictSubs(ids);
				logger.debug("删除了很多字典子项："+ids.toString());
			}
			//addActionMessage("删除字典子项成功");
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除字典子项成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			//addActionMessage("删除字典子项失败");
			result4Json.setStatusCode("300");
			result4Json.setMessage("删除字典子项失败");
			//throw new ServiceException(e);
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
		//logger.debug("pageNo:"+Struts2Utils.getRequest().getParameter("pageNo"));
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = dictSubManager.searchDictSub(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new DictSub();
		}else{
			entity = dictSubManager.getDictSub(id);
		}
	}
	@Override
	public String save() throws Exception {
		try{
			//HibernateUtils.mergeByCheckedIds(entity.getRoleList(), checkedRoleIds, Role.class);
			dictSubManager.saveDictSub(entity);
			//addActionMessage("保存字典子项成功");
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存字典子项成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改字典子项成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				/*entity = new DictSub();
				DataBeanUtil.copyProperty(entity, Struts2Utils.getRequest());
				entity.setId(null);
				save();*/
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存字典子项失败");
				//throw new ServiceException(e);
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public DictSub getModel() {
		return entity;
	}
	@Autowired
	public void setDictSubManager(DictSubManager dictSubManager) {
		this.dictSubManager = dictSubManager;
	}
	public Page<DictSub> getPage() {
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
