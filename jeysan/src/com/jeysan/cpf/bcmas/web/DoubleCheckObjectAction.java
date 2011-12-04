package com.jeysan.cpf.bcmas.web;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.DoubleCheck;
import com.jeysan.cpf.bcmas.entity.DoubleCheckObject;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.service.DoubleCheckManager;
import com.jeysan.cpf.bcmas.service.DoubleCheckObjectManager;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.action.PrintActionSupport;
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
@Results( {@Result(name = "list2", location = "doublecheckobject2.jsp", type = "dispatcher"),
	@Result(name = "input2", location = "doublecheckobject2-input.jsp", type = "dispatcher"),
	@Result(name = "list3", location = "doublecheckobject3.jsp", type = "dispatcher"),
	@Result(name = "input3", location = "doublecheckobject3-input.jsp", type = "dispatcher")})
public class DoubleCheckObjectAction extends PrintActionSupport<DoubleCheckObject> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private DoubleCheckObject entity;
	private DoubleCheckObjectManager doubleCheckObjectManager;
	private DoubleCheckManager doubleCheckManager;
	private FertileWomanManager fertileWomanManager;
	private Page page = new Page(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				deleteDC(id);
				logger.debug("删除了双查对象："+id);
			}else {
				for(String dcId : StringUtils.split(ids,","))
					deleteDC(Long.parseLong(dcId));
				logger.debug("删除了很多双查对象："+ids.toString());
			}
			monitorLogManager.saveMonitorLog("删除双查对象信息", System.currentTimeMillis()-t1_, id!=null?1:StringUtils.split(ids, ",").length);

			result4Json.setStatusCode("200");
			result4Json.setMessage("操作成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"对象已经被关联,请先解除关联,删除失败":"操作失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	
	public void getDoubleChecksByYear() throws Exception {
		try {
			String year = Struts2Utils.getRequest().getParameter("year");
			if(StringUtils.isNotEmpty(year)){
				List<DoubleCheck> dcs = this.doubleCheckManager.getDoubleChecksByYear(Integer.parseInt(year));
				Struts2Utils.renderJson(dcs);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private void deleteDC(Long dcId) throws Exception{
		String type = Struts2Utils.getRequest().getParameter("type");
		if(StringUtils.equals(type, "1")){
			doubleCheckObjectManager.deleteDoubleCheckObject(dcId);
		}else{
			DoubleCheckObject dco = this.doubleCheckObjectManager.getDoubleCheckObject(dcId);
			 if(StringUtils.equals(type, "2")){
				 dco.setDcDate(null);
				 dco.setDcResult1(null);
				 dco.setDcResult2(null);
				 dco.setHospital(null);
				 dco.setHospitalType(null);
				 dco.setDoctor(null);
				 dco.setRemark(null);
			 }else if(StringUtils.equals(type, "3")){
				 dco.setLdwContent(null);
				 dco.setLdwDate(null);
				 dco.setMoneyh(null);
				 dco.setPayDate(null);
				 dco.setCashier(null);
			 }
			 entity.setDcStatus(Constants.DC_STATUS.CONFIRMED);
			 doubleCheckObjectManager.saveDoubleCheckObject(dco);
		}
	}
	
	private DoubleCheckObject getDoubleCheckObject(DoubleCheck dc,FertileWoman fw){
		String check = Struts2Utils.getRequest().getParameter("check");
		DoubleCheckObject dco = new DoubleCheckObject();
		dco.setDcId(dc.getId());
		dco.setStart(dc.getStart());
		dco.setEnd(dc.getEnd());
		dco.setFertileWoman(fw);
		dco.setYear(dc.getYear());
		dco.setSeq(dc.getSeq());
		dco.setTotal(dc.getTotal());
		dco.setIssingle(1);
		if(StringUtils.equals(check, "no"))
			dco.setTypeh(Constants.DC_TYPEH.NO_CHECK);
		else if(StringUtils.equals(check, "free"))
			dco.setTypeh(Constants.DC_TYPEH.FREE_CHECK);
		else if(StringUtils.equals(check, "yes")){
			if(dc.getTotal() == 1)
				dco.setTypeh(Constants.DC_TYPEH.CHECK_1);
			else if(dc.getTotal() == 2)
				dco.setTypeh(Constants.DC_TYPEH.CHECK_2);
			else if(dc.getTotal() == 3)
				dco.setTypeh(Constants.DC_TYPEH.CHECK_3);
			else if(dc.getTotal() == 4)
				dco.setTypeh(Constants.DC_TYPEH.CHECK_4);
		}
		dco.setDcStatus(Constants.DC_STATUS.CONFIRMED);
		return dco;
	}
	/**
	 * 免查或者不查
	 * @return
	 * @throws Exception
	 */
	public String check() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			String year = Struts2Utils.getRequest().getParameter("filter_EQI_year");
			String seq = Struts2Utils.getRequest().getParameter("filter_EQI_seq");
				if(StringUtils.isNotEmpty(year)&&StringUtils.isNotEmpty(seq)){
					DoubleCheck dc = this.doubleCheckManager.getDoubleCheckByYear(Integer.parseInt(year), Integer.parseInt(seq));
					if(id!=null){
						FertileWoman fw = this.fertileWomanManager.getFertileWoman(id);
						DoubleCheckObject dco = getDoubleCheckObject(dc, fw);
						doubleCheckObjectManager.saveDoubleCheckObject(dco);
					}else {
						FertileWoman fw = null;
						DoubleCheckObject dco = null;
						for(String id : ids.split(",")){
							fw = this.fertileWomanManager.getFertileWoman(Long.parseLong(id));
							dco = getDoubleCheckObject(dc, fw);
							doubleCheckObjectManager.saveDoubleCheckObject(dco);
						}
					}
					result4Json.setStatusCode("200");
					result4Json.setMessage("操作成功");
					result4Json.setAction(Result4Json.DELETE);
					
					String check = Struts2Utils.getRequest().getParameter("check");
					String tips = null;
					if(StringUtils.equals(check, "no"))
						tips = "不查";
					else if(StringUtils.equals(check, "free"))
						tips = "免查";
					else if(StringUtils.equals(check, "yes")){
						tips = "应查";
					}
					monitorLogManager.saveMonitorLog("双查对象"+tips, System.currentTimeMillis()-t1_, id!=null?1:StringUtils.split(ids, ",").length);

				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				result4Json.setStatusCode("300");
				result4Json.setMessage("操作失败");
			}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public String input() throws Exception {
		entity = doubleCheckObjectManager.getDoubleCheckObject(id);
		List<DoubleCheck> dcs = this.doubleCheckManager.getDoubleChecksByYear(entity.getYear());
		DoubleCheck dc = this.doubleCheckManager.getDoubleCheck(entity.getDcId());
		Struts2Utils.getRequest().setAttribute("dc", dc);
		Struts2Utils.getRequest().setAttribute("dcs", dcs);
		return INPUT;
	}
	public String input2() throws Exception {
		input();
		return "input2";
	}
	public String input3() throws Exception {
		input();
		return "input3";
	}
	@Override
	public String view() throws Exception {
		input();
		return VIEW;
	}
	@Override
	public String list() throws Exception {
		String status = Struts2Utils.getRequest().getParameter("status");
		if(StringUtils.isNotEmpty(status)){
			DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
			//设置默认排序方式
			if (!page.isOrderBySetted()) {
				page.setOrderBy("id");
				page.setOrder(Page.ASC);
			}
			String filter_EQI_year = Struts2Utils.getRequest().getParameter("filter_EQI_year");
			String filter_EQI_seq = Struts2Utils.getRequest().getParameter("filter_EQI_seq");
			String filter_EQI_typeh = Struts2Utils.getRequest().getParameter("filter_EQI_typeh");
			if(StringUtils.equals(status, "0")){//未确定的
				if(StringUtils.isNotEmpty(filter_EQI_year)&&StringUtils.isNotEmpty(filter_EQI_seq)){
					String dcObjType = Struts2Utils.getRequest().getParameter("dcObjType");
					String area = Struts2Utils.getRequest().getParameter("fertileWoman.area");
					page = doubleCheckObjectManager.searchFertileWomanExtends(page, Integer.parseInt(filter_EQI_year), Integer.parseInt(filter_EQI_seq), StringUtils.isEmpty(dcObjType)?null:Long.parseLong(dcObjType), area);
				}
			}else if(StringUtils.equals(status, "1")){//确定的
				if(StringUtils.isNotEmpty(filter_EQI_year)){
					if(StringUtils.isNotEmpty(filter_EQI_seq)||StringUtils.isNotEmpty(filter_EQI_typeh)){
						List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
						DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
						page = doubleCheckObjectManager.searchDoubleCheckObject(page, filters);
					}
				}
			}
		}
		String filter_EQI_year = Struts2Utils.getRequest().getParameter("filter_EQI_year");
		if(StringUtils.isNotEmpty(filter_EQI_year)){
			Struts2Utils.getRequest().setAttribute("dcs", this.doubleCheckManager.getDoubleChecksByYear(Integer.parseInt(filter_EQI_year)));
		}
		return SUCCESS;
	}
	public String list2() throws Exception {
		String status = Struts2Utils.getRequest().getParameter("status");
		if(StringUtils.isNotEmpty(status)){
			List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
			if(StringUtils.equals(status, "0")){
				filters.add(new PropertyFilter("EQI_dcStatus",Constants.DC_STATUS.CONFIRMED+""));
				//filters.add(new PropertyFilter("NEQS_noMethodType",null));
			}else if(StringUtils.equals(status, "1")){
				filters.add(new PropertyFilter("EQI_dcStatus",Constants.DC_STATUS.CHECKED+""));
				//filters.add(new PropertyFilter("NEQS_noMethodType",null));
			}
			DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
			//设置默认排序方式
			if (!page.isOrderBySetted()) {
				page.setOrderBy("id");
				page.setOrder(Page.ASC);
			}
			page = doubleCheckObjectManager.searchDoubleCheckObject(page, filters);
		}
		if(checkPrint())
			return PRINT;
		String filter_EQI_year = Struts2Utils.getRequest().getParameter("filter_EQI_year");
		if(StringUtils.isNotEmpty(filter_EQI_year)){
			Struts2Utils.getRequest().setAttribute("dcs", this.doubleCheckManager.getDoubleChecksByYear(Integer.parseInt(filter_EQI_year)));
		}
		return "list2";
	}
	public String list3() throws Exception {
		String status = Struts2Utils.getRequest().getParameter("status");
		if(StringUtils.isNotEmpty(status)){
			List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
			if(StringUtils.equals(status, "0")){
				filters.add(new PropertyFilter("EQI_dcStatus",Constants.DC_STATUS.CONFIRMED+""));
				filters.add(new PropertyFilter("GTI_typeh",Constants.DC_TYPEH.NO_CHECK+""));
				filters.add(new PropertyFilter("LTI_typeh",Constants.DC_TYPEH.FREE_CHECK+""));
				filters.add(new PropertyFilter("LTS_end",DateUtil.convertDateToString(new Date(),"yyyy-MM")));
				//filters.add(new PropertyFilter("NEQS_noMethodType",null));
			}else if(StringUtils.equals(status, "1")){
				filters.add(new PropertyFilter("EQI_dcStatus",Constants.DC_STATUS.NO_CHECK+""));
				//filters.add(new PropertyFilter("NEQS_noMethodType",null));
			}
			DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
			//设置默认排序方式
			if (!page.isOrderBySetted()) {
				page.setOrderBy("id");
				page.setOrder(Page.ASC);
			}
			page = doubleCheckObjectManager.searchDoubleCheckObject(page, filters);
		}
		if(checkPrint())
			return PRINT;
		String filter_EQI_year = Struts2Utils.getRequest().getParameter("filter_EQI_year");
		if(StringUtils.isNotEmpty(filter_EQI_year)){
			Struts2Utils.getRequest().setAttribute("dcs", this.doubleCheckManager.getDoubleChecksByYear(Integer.parseInt(filter_EQI_year)));
		}
		return "list3";
	}
	@Override
	protected void prepareModel() throws Exception {
		/*if(id == null){
			entity = new DoubleCheckObject();
		}else{
			entity = doubleCheckObjectManager.getDoubleCheckObject(id);
		}*/
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			entity = doubleCheckObjectManager.getDoubleCheckObject(id);
			String issingle = Struts2Utils.getParameter("issingle");
			if(StringUtils.isNotEmpty(issingle))
				entity.setIssingle(Integer.parseInt(issingle));
			else
				entity.setIssingle(null);
			String typeh = Struts2Utils.getParameter("typeh");
			if(StringUtils.isNotEmpty(typeh))
				entity.setTypeh(Integer.parseInt(typeh));
			else
				entity.setTypeh(null);
			entity.setCause(Struts2Utils.getParameter("cause"));
			entity.setStart(Struts2Utils.getParameter("start"));
			entity.setEnd(Struts2Utils.getParameter("end"));
			doubleCheckObjectManager.saveDoubleCheckObject(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存双查对象成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改双查对象成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
			monitorLogManager.saveMonitorLog((id == null?"增加":"修改")+"双查对象信息", System.currentTimeMillis()-t1_, 1);

		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存双查对象失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String save2() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			entity = doubleCheckObjectManager.getDoubleCheckObject(id);
			String dcDate = Struts2Utils.getParameter("dcDate");
			if(StringUtils.isNotEmpty(dcDate))
				entity.setDcDate(DateUtil.createUtilDate(dcDate));
			else
				entity.setDcDate(null);
			String dcResult1 = Struts2Utils.getParameter("dcResult1");
			if(StringUtils.isNotEmpty(dcResult1))
				entity.setDcResult1(Integer.parseInt(dcResult1));
			else
				entity.setDcResult1(null);
			String dcResult2 = Struts2Utils.getParameter("dcResult2");
			if(StringUtils.isNotEmpty(dcResult2))
				entity.setDcResult2(Integer.parseInt(dcResult2));
			else
				entity.setDcResult2(null);
			entity.setHospital(Struts2Utils.getParameter("hospital"));
			String hospitalType = Struts2Utils.getParameter("hospitalType");
			if(StringUtils.isNotEmpty(hospitalType))
				entity.setHospitalType(Integer.parseInt(hospitalType));
			else
				entity.setHospitalType(null);
			entity.setDoctor(Struts2Utils.getParameter("doctor"));
			entity.setRemark(Struts2Utils.getParameter("remark"));
			entity.setDcStatus(Constants.DC_STATUS.CHECKED);
			
			doubleCheckObjectManager.saveDoubleCheckObject(entity);
			result4Json.setStatusCode("200");
			if(entity.getDcStatus().intValue() == Constants.DC_STATUS.CONFIRMED){
				result4Json.setMessage("登记双查信息成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改双查登记信息成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("登记双查信息失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String save3() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			entity = doubleCheckObjectManager.getDoubleCheckObject(id);
			entity.setLdwContent(Struts2Utils.getParameter("ldwContent"));
			String ldwDate = Struts2Utils.getParameter("ldwDate");
			if(StringUtils.isNotEmpty(ldwDate))
				entity.setLdwDate(DateUtil.createUtilDate(ldwDate));
			else
				entity.setLdwDate(null);
			String moneyh = Struts2Utils.getParameter("moneyh");
			if(StringUtils.isNotEmpty(moneyh))
				entity.setMoneyh(Double.parseDouble(moneyh));
			else
				entity.setMoneyh(null);
			String payDate = Struts2Utils.getParameter("payDate");
			if(StringUtils.isNotEmpty(payDate))
				entity.setPayDate(DateUtil.createUtilDate(payDate));
			else
				entity.setPayDate(null);
			entity.setCashier(Struts2Utils.getParameter("cashier"));
			entity.setDcStatus(Constants.DC_STATUS.NO_CHECK);
			doubleCheckObjectManager.saveDoubleCheckObject(entity);
			result4Json.setStatusCode("200");
			if(entity.getDcStatus().intValue() == Constants.DC_STATUS.CONFIRMED){
				result4Json.setMessage("保存双查漏查登记信息成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改双查漏查登记信息成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存双查漏查登记信息失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public DoubleCheckObject getModel() {
		return entity;
	}
	@Autowired
	public void setDoubleCheckObjectManager(DoubleCheckObjectManager doubleCheckObjectManager) {
		this.doubleCheckObjectManager = doubleCheckObjectManager;
	}
	@Autowired
	public void setDoubleCheckManager(DoubleCheckManager doubleCheckManager) {
		this.doubleCheckManager = doubleCheckManager;
	}
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	public Page getPage() {
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
