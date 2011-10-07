package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.entity.FertileWomanView;
import com.jeysan.cpf.bcmas.entity.GetIud;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.bcmas.service.FertileWomanViewManager;
import com.jeysan.cpf.bcmas.service.GetIudManager;
import com.jeysan.cpf.util.Constants;
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
@Results( { @Result(name = "list2", location = "getiud2.jsp", type = "dispatcher")})
public class GetIudAction extends PrintActionSupport<GetIud> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private GetIud entity;
	private GetIudManager getIudManager;
	private FertileWomanManager fertileWomanManager;
	private FertileWomanViewManager fertileWomanViewManager;
	private Page<GetIud> page = new Page<GetIud>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				getIudManager.deleteGetIud(id);
				logger.debug("删除了取环："+id);
			}else {
				getIudManager.deleteGetIuds(ids);
				logger.debug("删除了很多取环："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除取环成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"取环已经被关联,请先解除关联,删除失败":"删除取环失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	/**
	 * 确定取环名单
	 * @return
	 * @throws Exception
	 */
	public String confirm() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			String typeh = Struts2Utils.getParameter("typeh");
			if(id!=null){
				GetIud iud = getIudManager.getGetIudByWomanId(id);
				if(iud == null)
					iud = new GetIud();
				FertileWoman fertileWoman = new FertileWoman();
				fertileWoman.setId(id);
				iud.setFertileWoman(fertileWoman);
				iud.setRecordType(Constants.RECORD_TYPE.HAS_LIST);
				iud.setTypeh(Integer.parseInt(typeh));
				getIudManager.saveGetIud(iud);
				logger.debug("确定名单："+id);
			}else {
				String[] id_types = StringUtils.split(ids,',');
				GetIud iud = null;
				FertileWoman fertileWoman = null;
				String[] its = null;
				Long id_ = null;
				for(String id_type : id_types){
					its = StringUtils.split(id_type,'_');
					id_ = Long.parseLong(its[0]);
					iud = getIudManager.getGetIudByWomanId(id_);
					if(iud == null)
						iud = new GetIud();
					fertileWoman = new FertileWoman();
					fertileWoman.setId(id_);
					iud.setFertileWoman(fertileWoman);
					iud.setRecordType(Constants.RECORD_TYPE.HAS_LIST);
					iud.setTypeh(Integer.parseInt(its[1]));
					getIudManager.saveGetIud(iud);
				}
				logger.debug("确定名单："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("确定名单成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage("确定名单失败");
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
		page = getIudManager.searchGetIud(page, filters);
		return SUCCESS;
	}
	public String list2() throws Exception {
		Page<FertileWomanView> page2 = new Page<FertileWomanView>(DEFAULT_PAGE_SIZE);
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page2, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page2.isOrderBySetted()) {
			page2.setOrderBy("id");
			page2.setOrder(Page.ASC);
		}
		page2 = fertileWomanViewManager.searchFertileWomanView(page2, filters);
		Struts2Utils.getRequest().setAttribute("page", page2);
		//用于打印
		if(checkPrint())
			return PRINT;
		
		return "list2";
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new GetIud();
			String fertileWomanId = Struts2Utils.getParameter("fertileWomanId");
			if(StringUtils.isNotEmpty(fertileWomanId))
				Struts2Utils.getRequest().setAttribute("fertileWoman", fertileWomanManager.getFertileWoman(Long.parseLong(fertileWomanId)));
		}else{
			entity = getIudManager.getGetIud(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			entity.setRecordType(Constants.RECORD_TYPE.HAS_REGISTER);
			getIudManager.saveGetIud(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存取环成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改取环成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存取环失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public GetIud getModel() {
		return entity;
	}
	@Autowired
	public void setGetIudManager(GetIudManager getIudManager) {
		this.getIudManager = getIudManager;
	}
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	@Autowired
	public void setFertileWomanViewManager(FertileWomanViewManager fertileWomanViewManager) {
		this.fertileWomanViewManager = fertileWomanViewManager;
	}
	public Page<GetIud> getPage() {
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
