package com.jeysan.cpf.district.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.district.entity.DistrictTown;
import com.jeysan.cpf.district.entity.DistrictVillage;
import com.jeysan.cpf.district.service.DistrictTownManager;
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
@Namespace("/district")
public class DistrictTownAction extends CrudActionSupport<DistrictTown> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private DistrictTown entity;
	private DistrictTownManager districtTownManager;
	private Page<DistrictTown> page = new Page<DistrictTown>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				districtTownManager.deleteDistrictTown(id);
				logger.debug("删除了镇或街道："+id);
			}else {
				districtTownManager.deleteDistrictTowns(ids);
				logger.debug("删除了很多镇或街道："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除镇或街道成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"镇或街道已经被关联,请先解除关联,删除失败":"删除镇或街道失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String findSubs() throws Exception {
		prepareModel();
		if(entity != null){
			List<DistrictVillage> villageList = entity.getVillageList();
			if(villageList!=null&&villageList.size()>0){
				Struts2Utils.renderJson(villageList);
			}
		}
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
		page = districtTownManager.searchDistrictTown(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new DistrictTown();
		}else{
			entity = districtTownManager.getDistrictTown(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			districtTownManager.saveDistrictTown(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存镇或街道成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改镇或街道成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存镇或街道失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public DistrictTown getModel() {
		return entity;
	}
	@Autowired
	public void setDistrictTownManager(DistrictTownManager districtTownManager) {
		this.districtTownManager = districtTownManager;
	}
	public Page<DistrictTown> getPage() {
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
