package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.AssStatusView;
import com.jeysan.cpf.bcmas.entity.Assurance;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.service.AssStatusViewManager;
import com.jeysan.cpf.bcmas.service.AssuranceManager;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.util.Constants;
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
public class AssuranceAction extends CrudActionSupport<Assurance> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private Long fertileWomanId;
	private String ids;
	private Assurance entity;
	private AssuranceManager assuranceManager;
	private AssStatusViewManager assStatusViewManager;
	private FertileWomanManager fertileWomanManager;
	private Page<AssStatusView> page = new Page<AssStatusView>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(fertileWomanId!=null){
				assuranceManager.deleteAssurance(fertileWomanId);
				logger.debug("删除了保险保障："+fertileWomanId);
			}else {
				assuranceManager.deleteAssurances(ids);
				logger.debug("删除了很多保险保障："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除保险保障成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"保险保障已经被关联,请先解除关联,删除失败":"删除保险保障失败");
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
		page = assStatusViewManager.searchAssStatusView(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(fertileWomanId == null){
			entity = new Assurance();
		}else{
			entity = assuranceManager.getAssuranceByWomanId(fertileWomanId);
			Struts2Utils.getRequest().setAttribute("ass",assStatusViewManager.getAssStatusView(fertileWomanId));
		}
		if(entity == null && id!=null){
			entity = assuranceManager.getAssurance(id);
		}
		if(entity == null)
			entity = new Assurance();
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			String type = Struts2Utils.getParameter("type");
			String fertileWomanId = Struts2Utils.getParameter("fertileWomanId");
			FertileWoman fw = fertileWomanManager.getFertileWoman(Long.parseLong(fertileWomanId));
			if(StringUtils.equals(type, "0")){
				fw.setAssStatus(Constants.ASS_STATUS.YET_ASS);
				entity.setAssStatus(Constants.ASS_STATUS.YET_ASS);
				result4Json.setMessage("登记保险保障成功");
			}else if(StringUtils.equals(type, "1")){
				fw.setAssStatus(Constants.ASS_STATUS.CANCEL);
				entity.setAssStatus(Constants.ASS_STATUS.CANCEL);
				result4Json.setMessage("取消保险保障成功");
			}
			entity.setFertileWoman(fw);
			assuranceManager.saveAssurance(entity);
			fertileWomanManager.saveFertileWoman(fw);
			result4Json.setStatusCode("200");
			result4Json.setAction(Result4Json.UPDATE);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存保险保障失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Assurance getModel() {
		return entity;
	}
	@Autowired
	public void setAssuranceManager(AssuranceManager assuranceManager) {
		this.assuranceManager = assuranceManager;
	}
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	@Autowired
	public void setAssStatusViewManager(AssStatusViewManager assStatusViewManager) {
		this.assStatusViewManager = assStatusViewManager;
	}
	public Page<AssStatusView> getPage() {
		return page;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFertileWomanId(Long fertileWomanId) {
		this.fertileWomanId = fertileWomanId;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}
	
	
}
