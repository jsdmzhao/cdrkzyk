package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.entity.FirstChildReg;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.bcmas.service.FirstChildRegManager;
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
public class FirstChildRegAction extends PrintActionSupport<FirstChildReg> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private FirstChildReg entity;
	private FirstChildRegManager firstChildRegManager;
	private FertileWomanManager fertileWomanManager;
	private SpouseManager spouseManager;
	private Page<FirstChildReg> page = new Page<FirstChildReg>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				firstChildRegManager.deleteFirstChildReg(id);
				logger.debug("删除了一孩登记："+id);
			}else {
				firstChildRegManager.deleteFirstChildRegs(ids);
				logger.debug("删除了很多一孩登记："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除一孩登记成功");
			result4Json.setAction(Result4Json.DELETE);
			monitorLogManager.saveMonitorLog("删除一孩登记信息", System.currentTimeMillis()-t1_, id!=null?1:StringUtils.split(ids, ",").length);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"一孩登记已经被关联,请先解除关联,删除失败":"删除一孩登记失败");
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
		page = firstChildRegManager.searchFirstChildReg(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new FirstChildReg();
			String fertileWomanId = Struts2Utils.getParameter("fertileWomanId");
			if(StringUtils.isNotEmpty(fertileWomanId))
				Struts2Utils.getRequest().setAttribute("fertileWoman", fertileWomanManager.getFertileWoman(Long.parseLong(fertileWomanId)));
		}else{
			entity = firstChildRegManager.getFirstChildReg(id);
			if(entity != null){
				Long personId = entity.getFertileWoman().getPerson().getId();
				Struts2Utils.getRequest().setAttribute("spouse", spouseManager.getSpouseByPersonId(personId));
			}
		}
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
				firstChildRegManager.saveFirstChildReg(entity);
				
				fertileWoman.setRegisterType(com.jeysan.cpf.util.Constants.RegisterType.YES);
				fertileWomanManager.saveFertileWoman(fertileWoman);
				
				result4Json.setStatusCode("200");
			}
			if(id == null){
				result4Json.setMessage("保存一孩登记成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改一孩登记成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
			monitorLogManager.saveMonitorLog((id == null?"增加":"修改")+"一孩登记信息", System.currentTimeMillis()-t1_, 1);

		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存一孩登记失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public FirstChildReg getModel() {
		return entity;
	}
	@Autowired
	public void setFirstChildRegManager(FirstChildRegManager firstChildRegManager) {
		this.firstChildRegManager = firstChildRegManager;
	}
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	@Autowired
	public void setSpouseManager(SpouseManager spouseManager) {
		this.spouseManager = spouseManager;
	}
	public Page<FirstChildReg> getPage() {
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
