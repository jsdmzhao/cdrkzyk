package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.Birth2Apply;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.service.Birth2ApplyManager;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.pmas.service.SpouseManager;
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
public class Birth2ApplyAction extends PrintActionSupport<Birth2Apply> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Birth2Apply entity;
	private Birth2ApplyManager birth2ApplyManager;
	private FertileWomanManager fertileWomanManager;
	private SpouseManager spouseManager;
	private Page<Birth2Apply> page = new Page<Birth2Apply>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				birth2ApplyManager.deleteBirth2Apply(id);
				logger.debug("删除了再生育申请："+id);
			}else {
				birth2ApplyManager.deleteBirth2Applys(ids);
				logger.debug("删除了很多再生育申请："+ids.toString());
			}
			monitorLogManager.saveMonitorLog("删除再生育申请信息", System.currentTimeMillis()-t1_, id!=null?1:StringUtils.split(ids, ",").length);
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
			String fertileWomanId = Struts2Utils.getParameter("fertileWomanId");
			if(StringUtils.isNotEmpty(fertileWomanId))
				Struts2Utils.getRequest().setAttribute("fertileWoman", fertileWomanManager.getFertileWoman(Long.parseLong(fertileWomanId)));
		}else{
			entity = birth2ApplyManager.getBirth2Apply(id);
			if(entity != null){
				Long personId = entity.getFertileWoman().getPerson().getId();
				Struts2Utils.getRequest().setAttribute("spouse", spouseManager.getSpouseByPersonId(personId));
			}
		}
	}
	public String findByWomanId() throws Exception {
		String fertileWomanId = Struts2Utils.getParameter("fertileWomanId");
		if(StringUtils.isNotEmpty(fertileWomanId)){
			Birth2Apply birth2Apply = birth2ApplyManager.getBirth2ApplyByWomanId(Long.parseLong(fertileWomanId));
			if(birth2Apply==null)
				birth2Apply = new Birth2Apply();
			
			Struts2Utils.renderJson(birth2Apply);
			
		}
		return NONE;
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			String fertileWomanId = Struts2Utils.getParameter("master.dwz_fertileWomanLookup.fertileWomanId");
			if(StringUtils.isNotEmpty(fertileWomanId)){
				FertileWoman fertileWoman = fertileWomanManager.getFertileWoman(Long.parseLong(fertileWomanId));
				entity.setFertileWoman(fertileWoman);
				if(entity.getCheckType() == null)
					entity.setCheckType(com.jeysan.cpf.util.Constants.CheckType.NO);
				birth2ApplyManager.saveBirth2Apply(entity);
				
				fertileWoman.setBirth2Type(com.jeysan.cpf.util.Constants.Birth2Type.YES);
				fertileWomanManager.saveFertileWoman(fertileWoman);
				
				result4Json.setStatusCode("200");
			}
			
			if(id == null){
				result4Json.setMessage("保存再生育申请成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改再生育申请成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
			monitorLogManager.saveMonitorLog((id == null?"增加":"修改")+"再生育申请信息", System.currentTimeMillis()-t1_, 1);
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
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	@Autowired
	public void setSpouseManager(SpouseManager spouseManager) {
		this.spouseManager = spouseManager;
	}
	public Page<Birth2Apply> getPage() {
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
