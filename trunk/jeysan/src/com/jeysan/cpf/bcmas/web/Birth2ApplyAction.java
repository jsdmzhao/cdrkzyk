package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.Birth2Apply;
import com.jeysan.cpf.bcmas.service.Birth2ApplyManager;
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
public class Birth2ApplyAction extends CrudActionSupport<Birth2Apply> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private Birth2Apply entity;
	private Birth2ApplyManager birth2ApplyManager;
	private Page<Birth2Apply> page = new Page<Birth2Apply>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				birth2ApplyManager.deleteBirth2Apply(id);
				logger.debug("删除了再生育申请："+id);
			}else {
				birth2ApplyManager.deleteBirth2Applys(ids);
				logger.debug("删除了很多再生育申请："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除再生育申请成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"再生育申请已经被关联,请先解除关联,删除失败":"删除再生育申请失败");
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
		page = birth2ApplyManager.searchBirth2Apply(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Birth2Apply();
		}else{
			entity = birth2ApplyManager.getBirth2Apply(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			birth2ApplyManager.saveBirth2Apply(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存再生育申请成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改再生育申请成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存再生育申请失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Birth2Apply getModel() {
		return entity;
	}
	@Autowired
	public void setBirth2ApplyManager(Birth2ApplyManager birth2ApplyManager) {
		this.birth2ApplyManager = birth2ApplyManager;
	}
	public Page<Birth2Apply> getPage() {
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
