package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.Birth2Check;
import com.jeysan.cpf.bcmas.service.Birth2CheckManager;
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
public class Birth2CheckAction extends CrudActionSupport<Birth2Check> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Birth2Check entity;
	private Birth2CheckManager birth2CheckManager;
	private Page<Birth2Check> page = new Page<Birth2Check>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				birth2CheckManager.deleteBirth2Check(id);
				logger.debug("删除了再生育审批："+id);
			}else {
				birth2CheckManager.deleteBirth2Checks(ids);
				logger.debug("删除了很多再生育审批："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除再生育审批成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"再生育审批已经被关联,请先解除关联,删除失败":"删除再生育审批失败");
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
		page = birth2CheckManager.searchBirth2Check(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Birth2Check();
		}else{
			entity = birth2CheckManager.getBirth2Check(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			birth2CheckManager.saveBirth2Check(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存再生育审批成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改再生育审批成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存再生育审批失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Birth2Check getModel() {
		return entity;
	}
	@Autowired
	public void setBirth2CheckManager(Birth2CheckManager birth2CheckManager) {
		this.birth2CheckManager = birth2CheckManager;
	}
	public Page<Birth2Check> getPage() {
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
