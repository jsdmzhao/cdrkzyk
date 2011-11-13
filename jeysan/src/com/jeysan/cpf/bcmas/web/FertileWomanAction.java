package com.jeysan.cpf.bcmas.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.entity.WomanFivePeriod;
import com.jeysan.cpf.bcmas.service.BcsCertManager;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.bcmas.service.WomanBasicManager;
import com.jeysan.cpf.bcmas.service.WomanBearAssuranceManager;
import com.jeysan.cpf.bcmas.service.WomanContraceptManager;
import com.jeysan.cpf.bcmas.service.WomanFivePeriodManager;
import com.jeysan.cpf.bcmas.service.WomanMatenalManager;
import com.jeysan.cpf.bcmas.service.WomanPunishManager;
import com.jeysan.cpf.bcmas.service.WomanSocialUpbringManager;
import com.jeysan.cpf.pmas.service.PersonInManager;
import com.jeysan.cpf.pmas.service.SpouseManager;
import com.jeysan.cpf.pmas.service.WomanChildrenManager;
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
	@Result(name = "fertileWoman4lookup", location = "fertilewoman4lookup.jsp", type = "dispatcher"),
	@Result(name = "fertileWoman4fixPrint", location = "fertilewoman4fixprint.jsp", type = "dispatcher"),
	@Result(name = "fertileWoman4flowPrint", location = "fertilewoman4flowprint.jsp", type = "dispatcher")})
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
	
	private BcsCertManager bcsCertManager;
	private SpouseManager spouseManager;
	private WomanChildrenManager womanChildrenManager;
	private WomanFivePeriodManager womanFivePeriodManager;
	private WomanContraceptManager womanContraceptManager;
	private WomanSocialUpbringManager womanSocialUpbringManager;
	private WomanBearAssuranceManager womanBearAssuranceManager;
	private WomanMatenalManager womanMatenalManager;
	private PersonInManager personInManager;
	private WomanPunishManager womanPunishManager;
	
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
		String print = Struts2Utils.getParameter("print");
		if(StringUtils.isNotEmpty(print)&&Boolean.parseBoolean(print)){
			prepareModel();
			Long personId = Long.parseLong(Struts2Utils.getParameter("personId"));
			Struts2Utils.getRequest().setAttribute("spouse", spouseManager.getSpouseByPersonId(personId));
			List<WomanFivePeriod> wfps = womanFivePeriodManager.findWomanFivePeriods(id);
			Map<String,WomanFivePeriod> wfp_map = new HashMap();
			for(WomanFivePeriod wfp : wfps)
				wfp_map.put("wfp"+wfp.getEduType(), wfp);
			Struts2Utils.getRequest().setAttribute("wfp_map",wfp_map);
			Struts2Utils.getRequest().setAttribute("wbas",womanBearAssuranceManager.findWomanBearAssurances(id));
			Struts2Utils.getRequest().setAttribute("wsu", womanSocialUpbringManager.getWomanSocialUpbringByFertileWomanId(id));
			Struts2Utils.getRequest().setAttribute("wms", womanMatenalManager.findWomanMatenals(id));
			Struts2Utils.getRequest().setAttribute("wcs", womanContraceptManager.searchWomanContracepts(personId));
			Struts2Utils.getRequest().setAttribute("childs", womanChildrenManager.findWomanChildsByPersonId(personId));
			return "fertileWoman4fixPrint";
		}
		return "detail";
	}
	public String flow() throws Exception {
		String print = Struts2Utils.getParameter("print");
		if(StringUtils.isNotEmpty(print)&&Boolean.parseBoolean(print)){
			prepareModel();
			Long personId = Long.parseLong(Struts2Utils.getParameter("personId"));
			Struts2Utils.getRequest().setAttribute("spouse", spouseManager.getSpouseByPersonId(personId));
			Struts2Utils.getRequest().setAttribute("pi", personInManager.getPersonInByPersonId(personId));
			Struts2Utils.getRequest().setAttribute("bc", this.bcsCertManager.getBcsCertByFertileWomanId(id));
			Struts2Utils.getRequest().setAttribute("wsu", womanSocialUpbringManager.getWomanSocialUpbringByFertileWomanId(id));
			Struts2Utils.getRequest().setAttribute("wms", womanMatenalManager.findWomanMatenals(id));
			Struts2Utils.getRequest().setAttribute("childs", womanChildrenManager.findWomanChildsByPersonId(personId));
			Struts2Utils.getRequest().setAttribute("wps", womanPunishManager.findWomanPunishs(id));
			return "fertileWoman4flowPrint";
		}
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
	@Autowired
	public void setBcsCertManager(BcsCertManager bcsCertManager) {
		this.bcsCertManager = bcsCertManager;
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
	public void setWomanContraceptManager(WomanContraceptManager womanContraceptManager) {
		this.womanContraceptManager = womanContraceptManager;
	}
	@Autowired
	public void setWomanSocialUpbringManager(WomanSocialUpbringManager womanSocialUpbringManager) {
		this.womanSocialUpbringManager = womanSocialUpbringManager;
	}
	@Autowired
	public void setWomanBearAssuranceManager(WomanBearAssuranceManager womanBearAssuranceManager) {
		this.womanBearAssuranceManager = womanBearAssuranceManager;
	}
	@Autowired
	public void setWomanMatenalManager(WomanMatenalManager womanMatenalManager) {
		this.womanMatenalManager = womanMatenalManager;
	}
	@Autowired
	public void setPersonInManager(PersonInManager personInManager) {
		this.personInManager = personInManager;
	}
	@Autowired
	public void setWomanPunishManager(WomanPunishManager womanPunishManager) {
		this.womanPunishManager = womanPunishManager;
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
