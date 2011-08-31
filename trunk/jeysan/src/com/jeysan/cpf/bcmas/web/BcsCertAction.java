package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.BcsCert;
import com.jeysan.cpf.bcmas.entity.BcsCertChange;
import com.jeysan.cpf.bcmas.entity.BcsCertCheck;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.service.BcsCertChangeManager;
import com.jeysan.cpf.bcmas.service.BcsCertCheckManager;
import com.jeysan.cpf.bcmas.service.BcsCertManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/bcmas")
@Results( {@Result(name = "list4view", location = "bcscertcheck4view.jsp", type = "dispatcher"),
	@Result(name = "bcs4lookup", location = "bcscert4lookup.jsp", type = "dispatcher")})
public class BcsCertAction extends CrudActionSupport<BcsCert> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private BcsCert entity;
	private BcsCertManager bcsCertManager;
	private BcsCertChangeManager bcsCertChangeManager;
	private BcsCertCheckManager bcsCertCheckManager;
	private Page<BcsCert> page = new Page<BcsCert>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				bcsCertManager.deleteBcsCerts(id);
				logger.debug("删除了计划生育服务证："+id);
			}else {
				bcsCertManager.deleteBcsCerts(ids);
				logger.debug("删除了很多计划生育服务证："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除计划生育服务证成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"计划生育服务证已经被关联,请先解除关联,删除失败":"删除计划生育服务证失败");
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
	public String list4lookup() throws Exception {
		list();
		return "bcs4lookup";
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
		page = bcsCertManager.searchBcsCert(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new BcsCert();
		}else{
			entity = bcsCertManager.getBcsCert(id);
			Struts2Utils.getRequest().setAttribute("change", bcsCertChangeManager.getBcsCertChangeByCertId(id));
		}
	}
	/**
	 * 变更或者废止
	 * @return
	 * @throws Exception
	 */
	public String change() throws Exception {
		String type = Struts2Utils.getParameter("type");
		if(StringUtils.isNotEmpty(type)){
			BcsCertChange change = new BcsCertChange();
			change.setTypeh(Integer.parseInt(type));
			change.setCertId(entity.getId());
			change.setAgent(Struts2Utils.getParameter("change.agent"));
			String cause = Struts2Utils.getParameter("change.cause");
			if(StringUtils.isNotEmpty(cause))
				change.setCause(Integer.parseInt(cause));
			String dateh = Struts2Utils.getParameter("change.dateh");
			if(StringUtils.isNotEmpty(dateh))
				change.setDateh(DateUtil.createUtilDate(dateh));
			bcsCertChangeManager.saveBcsCertChange(change);
		}
		return NONE;
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			String type = Struts2Utils.getParameter("type");
			if(StringUtils.isNotEmpty(type)){
				if(StringUtils.equals(type, "2")){//查验
					BcsCertCheck check = new BcsCertCheck();
					check.setBcs(entity);
					check.setContent(Struts2Utils.getParameter("check.content"));
					check.setAgent(Struts2Utils.getParameter("check.agent"));
					String dateh = Struts2Utils.getParameter("check.dateh");
					if(StringUtils.isNotEmpty(dateh))
						check.setDateh(DateUtil.createUtilDate(dateh));
					bcsCertCheckManager.saveBcsCertCheck(check);
				}else{//换证 0 废止1
					BcsCertChange change = bcsCertChangeManager.getBcsCertChangeByCertId(id);
					if(change == null)
						change = new BcsCertChange();
					change.setTypeh(Integer.parseInt(type));
					change.setCertId(entity.getId());
					change.setAgent(Struts2Utils.getParameter("change.agent"));
					String cause = Struts2Utils.getParameter("change.cause");
					if(StringUtils.isNotEmpty(cause))
						change.setCause(Integer.parseInt(cause));
					String dateh = Struts2Utils.getParameter("change.dateh");
					if(StringUtils.isNotEmpty(dateh))
						change.setDateh(DateUtil.createUtilDate(dateh));
					bcsCertChangeManager.saveBcsCertChange(change);
					if(StringUtils.equals(type, "0"))
						entity.setCertType(Constants.CERT_TYPE.CHANGED);
					else if(StringUtils.equals(type, "1"))
						entity.setCertType(Constants.CERT_TYPE.CANCEL);
					bcsCertManager.saveBcsCert(entity);
				}
			}else{
				String fertileWomanId = Struts2Utils.getParameter("master.dwz_fertileWomanLookup.fertileWomanId");
				if(StringUtils.isNotEmpty(fertileWomanId)){
					FertileWoman fertileWoman = new FertileWoman();
					fertileWoman.setId(Long.parseLong(fertileWomanId));
					entity.setFertileWoman(fertileWoman);
				}
				entity.setCertType(Constants.CERT_TYPE.NORMAL);
				bcsCertManager.saveBcsCert(entity);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("操作成功");
			result4Json.setAction(Result4Json.UPDATE);
			
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("操作失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public BcsCert getModel() {
		return entity;
	}
	@Autowired
	public void setBcsCertManager(BcsCertManager bcsCertManager) {
		this.bcsCertManager = bcsCertManager;
	}
	@Autowired
	public void setBcsCertChangeManager(BcsCertChangeManager bcsCertChangeManager) {
		this.bcsCertChangeManager = bcsCertChangeManager;
	}
	@Autowired
	public void setBcsCertCheckManager(BcsCertCheckManager bcsCertCheckManager) {
		this.bcsCertCheckManager = bcsCertCheckManager;
	}
	public Page<BcsCert> getPage() {
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
