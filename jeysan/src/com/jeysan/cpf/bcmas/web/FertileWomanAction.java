package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.h2.util.StringUtils;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.bcmas.service.WomanBasicManager;
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
@Namespace("/bcmas")
@Results( { @Result(name = "detail", location = "fertilewomandetail.jsp", type = "dispatcher"),
	@Result(name = "fertileWoman4lookup", location = "fertilewoman4lookup.jsp", type = "dispatcher")})
public class FertileWomanAction extends PrintActionSupport<FertileWoman> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private FertileWoman entity;
	private FertileWomanManager fertileWomanManager;
	private WomanBasicManager womanBasicManager;
	private Page<FertileWoman> page = new Page<FertileWoman>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				fertileWomanManager.deleteFertileWoman(id);
				logger.debug("删除了育龄妇女："+id);
			}else {
				fertileWomanManager.deleteFertileWomans(ids);
				logger.debug("删除了很多育龄妇女："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除育龄妇女成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"育龄妇女已经被关联,请先解除关联,删除失败":"删除育龄妇女失败");
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
		PropertyFilter pf = null;
		String type = Struts2Utils.getParameter("type");
		if(StringUtils.equals(type, "fix")){
			pf = new PropertyFilter("EQI_typeh","663");
		}else if(StringUtils.equals(type, "flow")){
			pf = new PropertyFilter("EQI_typeh","664");
		}
		filters.add(pf);
		
		//String registerType = Struts2Utils.getParameter("registerType");
		
		page = fertileWomanManager.searchFertileWoman(page, filters);
		return SUCCESS;
	}
	public String list4lookup() throws Exception {
		list();
		return "fertileWoman4lookup";
	}
	public String fix() throws Exception {
		return "detail";
	}
	public String flow() throws Exception {
		return "detail";
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new FertileWoman();
		}else{
			entity = fertileWomanManager.getFertileWoman(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			fertileWomanManager.saveFertileWoman(entity);
			entity.getWomanBasic().setFertileWoman(entity);
			womanBasicManager.saveWomanBasic(entity.getWomanBasic());
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存育龄妇女成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改育龄妇女成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存育龄妇女失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public FertileWoman getModel() {
		return entity;
	}
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	@Autowired
	public void setWomanBasicManager(WomanBasicManager womanBasicManager) {
		this.womanBasicManager = womanBasicManager;
	}
	public Page<FertileWoman> getPage() {
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
