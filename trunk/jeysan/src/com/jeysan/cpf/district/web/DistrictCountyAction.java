package com.jeysan.cpf.district.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.district.entity.DistrictCounty;
import com.jeysan.cpf.district.entity.DistrictTown;
import com.jeysan.cpf.district.service.DistrictCountyManager;
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
public class DistrictCountyAction extends CrudActionSupport<DistrictCounty> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private DistrictCounty entity;
	private DistrictCountyManager districtCountyManager;
	private Page<DistrictCounty> page = new Page<DistrictCounty>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				districtCountyManager.deleteDistrictCounty(id);
				logger.debug("删除了区或县："+id);
			}else {
				districtCountyManager.deleteDistrictCountys(ids);
				logger.debug("删除了很多区或县："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除区或县成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"区或县已经被关联,请先解除关联,删除失败":"删除区或县失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String findSubs() throws Exception {
		prepareModel();
		if(entity != null){
			List<DistrictTown> countyList = entity.getTownList();
			if(countyList!=null&&countyList.size()>0){
				Struts2Utils.renderJson(countyList);
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
		page = districtCountyManager.searchDistrictCounty(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new DistrictCounty();
		}else{
			entity = districtCountyManager.getDistrictCounty(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			districtCountyManager.saveDistrictCounty(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存区或县成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改区或县成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存区或县失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public DistrictCounty getModel() {
		return entity;
	}
	@Autowired
	public void setDistrictCountyManager(DistrictCountyManager districtCountyManager) {
		this.districtCountyManager = districtCountyManager;
	}
	public Page<DistrictCounty> getPage() {
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
