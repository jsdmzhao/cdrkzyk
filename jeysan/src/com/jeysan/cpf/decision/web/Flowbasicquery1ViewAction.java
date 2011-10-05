package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.decision.entity.Flowbasicquery1View;
import com.jeysan.cpf.decision.service.Flowbasicquery1ViewManager;
import com.jeysan.modules.action.PrintActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/decision")
public class Flowbasicquery1ViewAction extends PrintActionSupport<Flowbasicquery1View> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Flowbasicquery1View entity;
	private Flowbasicquery1ViewManager flowbasicquery1ViewManager;
	private Page<Flowbasicquery1View> page = new Page<Flowbasicquery1View>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				flowbasicquery1ViewManager.deleteFlowbasicquery1View(id);
				logger.debug("删除了PersionInBasicQuery："+id);
			}else {
				flowbasicquery1ViewManager.deleteFlowbasicquery1Views(ids);
				logger.debug("删除了很多PersionInBasicQuery："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除PersionInBasicQuery成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"PersionInBasicQuery已经被关联,请先解除关联,删除失败":"删除PersionInBasicQuery失败");
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
		page = flowbasicquery1ViewManager.searchFlowbasicquery1View(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Flowbasicquery1View();
		}else{
			//entity = flowbasicquery1ViewManager.getFlowbasicquery1View(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			flowbasicquery1ViewManager.saveFlowbasicquery1View(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存PersionInBasicQuery成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改PersionInBasicQuery成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存PersionInBasicQuery失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Flowbasicquery1View getModel() {
		return entity;
	}
	@Autowired
	public void setFlowbasicquery1ViewManager(Flowbasicquery1ViewManager flowbasicquery1ViewManager) {
		this.flowbasicquery1ViewManager = flowbasicquery1ViewManager;
	}
	public Page<Flowbasicquery1View> getPage() {
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
