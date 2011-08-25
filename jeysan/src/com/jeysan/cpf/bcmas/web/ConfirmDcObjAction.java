package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.ConfirmDcObj;
import com.jeysan.cpf.bcmas.service.ConfirmDcObjManager;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
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
public class ConfirmDcObjAction extends CrudActionSupport<ConfirmDcObj> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private ConfirmDcObj entity;
	private ConfirmDcObjManager confirmDcObjManager;
	private FertileWomanManager fertileWomanManager;
	private Page<ConfirmDcObj> page = new Page<ConfirmDcObj>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				confirmDcObjManager.deleteConfirmDcObj(id);
				logger.debug("删除了确定双查对象："+id);
			}else {
				confirmDcObjManager.deleteConfirmDcObjs(ids);
				logger.debug("删除了很多确定双查对象："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除确定双查对象成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"确定双查对象已经被关联,请先解除关联,删除失败":"删除确定双查对象失败");
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
		page = confirmDcObjManager.searchConfirmDcObj(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new ConfirmDcObj();
			String fertileWomanId = Struts2Utils.getParameter("fertileWomanId");
			if(StringUtils.isNotEmpty(fertileWomanId))
				Struts2Utils.getRequest().setAttribute("fertileWoman", fertileWomanManager.getFertileWoman(Long.parseLong(fertileWomanId)));
		}else{
			entity = confirmDcObjManager.getConfirmDcObj(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			confirmDcObjManager.saveConfirmDcObj(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存确定双查对象成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改确定双查对象成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存确定双查对象失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public ConfirmDcObj getModel() {
		return entity;
	}
	@Autowired
	public void setConfirmDcObjManager(ConfirmDcObjManager confirmDcObjManager) {
		this.confirmDcObjManager = confirmDcObjManager;
	}
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	public Page<ConfirmDcObj> getPage() {
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
