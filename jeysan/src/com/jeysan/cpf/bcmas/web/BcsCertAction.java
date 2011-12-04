package com.jeysan.cpf.bcmas.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
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
import com.jeysan.cpf.bcmas.entity.WomanAward;
import com.jeysan.cpf.bcmas.service.BcsCertChangeManager;
import com.jeysan.cpf.bcmas.service.BcsCertCheckManager;
import com.jeysan.cpf.bcmas.service.BcsCertManager;
import com.jeysan.cpf.bcmas.service.Birth2ApplyManager;
import com.jeysan.cpf.bcmas.service.DoubleCheckObjectManager;
import com.jeysan.cpf.bcmas.service.FirstChildRegManager;
import com.jeysan.cpf.bcmas.service.WomanAwardManager;
import com.jeysan.cpf.bcmas.service.WomanContraceptManager;
import com.jeysan.cpf.bcmas.service.WomanFivePeriodManager;
import com.jeysan.cpf.bcmas.service.WomanSocialUpbringManager;
import com.jeysan.cpf.pmas.entity.WomanChildren;
import com.jeysan.cpf.pmas.service.SpouseManager;
import com.jeysan.cpf.pmas.service.WomanChildrenManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.action.PrintActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.file.FileUploadUtils;
import com.jeysan.modules.utils.file.FileUtils;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/bcmas")
@Results( {@Result(name = "list4view", location = "bcscertcheck4view.jsp", type = "dispatcher"),
	@Result(name = "bcs4lookup", location = "bcscert4lookup.jsp", type = "dispatcher"),
	@Result(name = "view4print", location = "bcscert-view4print.jsp", type = "dispatcher")})
public class BcsCertAction extends PrintActionSupport<BcsCert> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private BcsCert entity;
	private BcsCertManager bcsCertManager;
	private SpouseManager spouseManager;
	private BcsCertChangeManager bcsCertChangeManager;
	private BcsCertCheckManager bcsCertCheckManager;
	private WomanChildrenManager womanChildrenManager;
	private WomanFivePeriodManager womanFivePeriodManager;
	private FirstChildRegManager firstChildRegManager;
	private Birth2ApplyManager birth2ApplyManager;
	private WomanContraceptManager womanContraceptManager;
	private WomanAwardManager womanAwardManager;
	private DoubleCheckObjectManager doubleCheckObjectManager;
	private WomanSocialUpbringManager womanSocialUpbringManager;
	private Page<BcsCert> page = new Page<BcsCert>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private File photo_;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				deleteMarryCert(id);
				logger.debug("删除了计划生育服务证："+id);
				monitorLogManager.saveMonitorLog("删除计划生育服务证信息", System.currentTimeMillis()-t1_, 1);
			}else {
				String[] cts = StringUtils.split(ids, ",");
				for(String pid : cts)
					deleteMarryCert(Long.parseLong(pid));
				logger.debug("删除了很多计划生育服务证："+ids.toString());
				monitorLogManager.saveMonitorLog("删除计划生育服务证信息", System.currentTimeMillis()-t1_, cts.length);
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
	private void deleteMarryCert(Long pid){
		BcsCert p = bcsCertManager.getBcsCert(pid);
		String photo_ = p.getPhoto();
		bcsCertManager.deleteBcsCert(p);
		if(StringUtils.isNotEmpty(photo_)){
			FileUtils.deleteFile(Struts2Utils.getRequest(), photo_);
		}
	}
	@Override
	public String input() throws Exception {
		return INPUT;
	}
	@Override
	public String view() throws Exception {
		String print = Struts2Utils.getParameter("print");
		if(StringUtils.isNotEmpty(print)&&Boolean.parseBoolean(print)){
			Long personId = entity.getFertileWoman().getPerson().getId();
			Struts2Utils.getRequest().setAttribute("spouse", spouseManager.getSpouseByPersonId(personId));
			List<WomanChildren> childs =  womanChildrenManager.findWomanChildsByPersonId(personId);
			List childs1 = new ArrayList() , childs2 = new ArrayList();
			for(WomanChildren sc : childs){
				if(StringUtils.equals(sc.getKinship(), Constants.KIND_SHIP.OWNER+"")){
					childs1.add(sc);
				}else
					childs2.add(sc);
			}
			Struts2Utils.getRequest().setAttribute("childs1", childs1);
			Struts2Utils.getRequest().setAttribute("childs2", childs2);
			Struts2Utils.getRequest().setAttribute("wfps", womanFivePeriodManager.findWomanFivePeriods(entity.getFertileWoman().getId()));
			Struts2Utils.getRequest().setAttribute("fcr", firstChildRegManager.getFirstChildRegByFertileWomanId(entity.getFertileWoman().getId()));
			Struts2Utils.getRequest().setAttribute("ba", birth2ApplyManager.getBirth2ApplyByWomanId(entity.getFertileWoman().getId()));
			Struts2Utils.getRequest().setAttribute("wcs", womanContraceptManager.searchWomanContracepts(personId));
			List<WomanAward> was = womanAwardManager.findWomanAwards(entity.getFertileWoman().getId());
			WomanAward was1 = null , was2 = null, was3 = null;
			for(WomanAward wa : was){
				if(wa.getTypeh().intValue() == Constants.WOMAN_AWARD.AWARD1){
					was1 = wa;
				}else if(wa.getTypeh().intValue() == Constants.WOMAN_AWARD.AWARD1){
					was2 = wa;
				}else
					was3 = wa;
			}
			Struts2Utils.getRequest().setAttribute("was1", was1);
			Struts2Utils.getRequest().setAttribute("was2", was2);
			Struts2Utils.getRequest().setAttribute("was3", was3);
			Struts2Utils.getRequest().setAttribute("wsu", womanSocialUpbringManager.getWomanSocialUpbringByFertileWomanId(entity.getFertileWoman().getId()));
			Struts2Utils.getRequest().setAttribute("dcos", doubleCheckObjectManager.findDoubleCheckObjects(entity.getFertileWoman().getId()));
			Struts2Utils.getRequest().setAttribute("bccs",bcsCertManager.findBcsCertChecks(id)); 
			return "view4print";
		}
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
			long t1_ = System.currentTimeMillis();
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
			monitorLogManager.saveMonitorLog((StringUtils.equals(type, "0")?"更换":"废止")+"计划生育服务证", System.currentTimeMillis()-t1_, 1);
		}
		return NONE;
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
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
					monitorLogManager.saveMonitorLog("查验计划生育服务证信息", System.currentTimeMillis()-t1_, 1);
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
					monitorLogManager.saveMonitorLog((StringUtils.equals(type, "0")?"更换":"废止")+"计划生育服务证", System.currentTimeMillis()-t1_, 1);
				}
			}else{
				String fertileWomanId = Struts2Utils.getParameter("master.dwz_fertileWomanLookup.fertileWomanId");
				if(StringUtils.isNotEmpty(fertileWomanId)){
					FertileWoman fertileWoman = new FertileWoman();
					fertileWoman.setId(Long.parseLong(fertileWomanId));
					entity.setFertileWoman(fertileWoman);
				}
				if(this.photo_ != null){
					if(id != null){
						String photo = entity.getPhoto();
						if(StringUtils.isNotEmpty(photo)){
							FileUtils.deleteFile(Struts2Utils.getRequest(), photo);
						}
					}
					String filePath = "/img/photo/";
					String fileName = RandomStringUtils.randomAlphanumeric(32)+"."+FileUtils.getFileExt(photo_);
					FileUploadUtils.uploadFileInStruts(photo_, fileName, FileUtils.getRealPath(Struts2Utils.getRequest(), filePath));
					entity.setPhoto(filePath+fileName);
				}
				entity.setCertType(Constants.CERT_TYPE.NORMAL);
				bcsCertManager.saveBcsCert(entity);
				monitorLogManager.saveMonitorLog("增加计划生育服务证信息", System.currentTimeMillis()-t1_, 1);
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
	@Autowired
	public void setSpouseManager(SpouseManager spouseManager) {
		this.spouseManager = spouseManager;
	}
	@Autowired
	public void setWomanChildrenManager(WomanChildrenManager womanChildrenManager) {
		this.womanChildrenManager = womanChildrenManager;
	}
	@Autowired
	public void setWomanFivePeriodManager(WomanFivePeriodManager womanFivePeriodManager) {
		this.womanFivePeriodManager = womanFivePeriodManager;
	}
	@Autowired
	public void setFirstChildRegManager(FirstChildRegManager firstChildRegManager) {
		this.firstChildRegManager = firstChildRegManager;
	}
	@Autowired
	public void setBirth2ApplyManager(Birth2ApplyManager birth2ApplyManager) {
		this.birth2ApplyManager = birth2ApplyManager;
	}
	@Autowired
	public void setWomanContraceptManager(WomanContraceptManager womanContraceptManager) {
		this.womanContraceptManager = womanContraceptManager;
	}
	@Autowired
	public void setWomanAwardManager(WomanAwardManager womanAwardManager) {
		this.womanAwardManager = womanAwardManager;
	}
	@Autowired
	public void setWomanSocialUpbringManager(WomanSocialUpbringManager womanSocialUpbringManager) {
		this.womanSocialUpbringManager = womanSocialUpbringManager;
	}
	@Autowired
	public void setDoubleCheckObjectManager(DoubleCheckObjectManager doubleCheckObjectManager) {
		this.doubleCheckObjectManager = doubleCheckObjectManager;
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
	
	public File getPhoto_() {
		return photo_;
	}
	public void setPhoto_(File photo_) {
		this.photo_ = photo_;
	}
	
}
