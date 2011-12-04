package com.jeysan.cpf.pmas.web;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.google.common.collect.Maps;
import com.jeysan.cpf.bcmas.entity.DeathReg;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.service.DeathRegManager;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.bcmas.service.WomanBasicManager;
import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.entity.PersonOut;
import com.jeysan.cpf.pmas.service.HouseManager;
import com.jeysan.cpf.pmas.service.PersonBasicManager;
import com.jeysan.cpf.pmas.service.PersonManager;
import com.jeysan.cpf.pmas.service.PersonOutManager;
import com.jeysan.cpf.pmas.service.VillagerTeamManager;
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
@Namespace("/pmas")
@Results( { @Result(name = "person4lookup", location = "person4lookup.jsp", type = "dispatcher"), 
	@Result(name = "person-cancel", location = "person-cancel.jsp", type = "dispatcher"), 
	@Result(name = "historydestroy", location = "historydestroy.jsp", type = "dispatcher")})
public class PersonAction extends PrintActionSupport<Person> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Person entity;
	private PersonManager personManager;
	private HouseManager houseManager;
	private PersonBasicManager personBasicManager;
	private PersonOutManager personOutManager;
	private VillagerTeamManager villagerTeamManager;
	private FertileWomanManager fertileWomanManager;
	private WomanBasicManager womanBasicManager;
	private DeathRegManager deathRegManager;
	private Page<Person> page = new Page<Person>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private File personBasic_photo;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				deletePerson(id);
				monitorLogManager.saveMonitorLog("删除人员信息", System.currentTimeMillis()-t1_, 1);
				logger.debug("删除了人员："+id);
			}else {
				String[] cts = StringUtils.split(ids, ",");
				for(String pid : cts)
					deletePerson(Long.parseLong(pid));
				monitorLogManager.saveMonitorLog("删除人员信息", System.currentTimeMillis()-t1_, cts.length);
				logger.debug("删除了很多人员："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除人员成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"人员已经被关联,请先解除关联,删除失败":"删除人员失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	private void deletePerson(Long pid){
		Person p = personManager.getPerson(pid);
		String photo = p.getPersonBasic().getPhoto();
		personManager.deletePerson(p);
		if(StringUtils.isNotEmpty(photo)){
			FileUtils.deleteFile(Struts2Utils.getRequest(), photo);
		}
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
		page = personManager.searchPerson(page, filters);
		return SUCCESS;
	}
	public String list4lookup() throws Exception {
		list();
		return "person4lookup";
	}
	/**
	 * 历史数据查询，用于数据销毁
	 * @return
	 * @throws Exception
	 */
	public String historydestroy() throws Exception {
		Map<String,Object> values = Maps.newHashMap();
		String tmp = Struts2Utils.getParameter("nameh");
		if(StringUtils.isNotEmpty(tmp))
			values.put("nameh", tmp);
		tmp = Struts2Utils.getParameter("sex");
		if(StringUtils.isNotEmpty(tmp))
			values.put("sex", Integer.parseInt(tmp));
		tmp = Struts2Utils.getParameter("code");
		if(StringUtils.isNotEmpty(tmp))
			values.put("code", tmp);
		tmp = Struts2Utils.getParameter("area");
		if(StringUtils.isNotEmpty(tmp))
			values.put("area", tmp);
		tmp = Struts2Utils.getParameter("kind");
		if(StringUtils.isNotEmpty(tmp))
			values.put("kind", Integer.parseInt(tmp));
		tmp = Struts2Utils.getParameter("personCode");
		if(StringUtils.isNotEmpty(tmp))
			values.put("personCode", tmp);
		tmp = Struts2Utils.getParameter("cancelType");
		if(StringUtils.isNotEmpty(tmp))
			values.put("cancelType", Integer.parseInt(tmp));
		
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = personManager.searchPerson(page, values);
		return "historydestroy";
	}
	/**
	 * 历史数据销毁
	 * @return
	 * @throws Exception
	 */
	public String destoryDo() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				personManager.deletePerson(id);
				logger.debug("删除了人员："+id);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("销毁人员历史数据成功成功");
			result4Json.setAction(Result4Json.DELETE);
			monitorLogManager.saveMonitorLog("销毁人员历史数据", System.currentTimeMillis()-t1_, 1);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"人员历史数据已经被关联,请先解除关联,删除失败":"删除人员历史数据失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String precancel() throws Exception {
		prepareModel();
		Struts2Utils.getRequest().setAttribute("person", entity);
		return "person-cancel";
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Person();
		}else{
			entity = personManager.getPerson(id);
			Long tmp = entity.getPersonBasic().getVillagerTeamId();
			if(tmp != null)
				Struts2Utils.getRequest().setAttribute("villagerteam", villagerTeamManager.getVillagerTeam(tmp));
			tmp = entity.getPersonBasic().getHouseId();
			if(tmp != null)
				Struts2Utils.getRequest().setAttribute("house", houseManager.getHouse(tmp));
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			if(id == null)
				entity.setCancelType(Constants.CANCEL_TYPE.NORMAL);
			String houseId = Struts2Utils.getParameter("master.dwz_houseLookup.houseId");
			if(StringUtils.isNotEmpty(houseId))
				entity.getPersonBasic().setHouseId(Long.parseLong(houseId));
			entity.setArea(entity.getPersonBasic().getAddressCode());
			if(this.personBasic_photo != null){
				if(id != null){
					String photo = entity.getPersonBasic().getPhoto();
					if(StringUtils.isNotEmpty(photo)){
						FileUtils.deleteFile(Struts2Utils.getRequest(), photo);
					}
				}
				String filePath = "/img/photo/";
				String fileName = RandomStringUtils.randomAlphanumeric(32)+"."+FileUtils.getFileExt(personBasic_photo);
				FileUploadUtils.uploadFileInStruts(personBasic_photo, fileName, FileUtils.getRealPath(Struts2Utils.getRequest(), filePath));
				entity.getPersonBasic().setPhoto(filePath+fileName);
			}
			personManager.savePerson(entity);
			entity.getPersonBasic().setPerson(entity);
			personBasicManager.savePersonBasic(entity.getPersonBasic());
			//同步到育妇表..................
			if(entity.getKind()==Constants.FW_KIND.FW){//育龄妇女
				FertileWoman fertileWoman = fertileWomanManager.getFertileWomanByPersonId(entity.getId());
				if(fertileWoman == null)
					fertileWoman = new FertileWoman();
				if(fertileWoman.getCreateDate() == null)
					fertileWoman.setCreateDate(new Date());
				fertileWoman.setTypeh(entity.getDomicileType());
				fertileWoman.setCode(entity.getPersonCode());
				fertileWoman.setNameh(entity.getNameh());
				fertileWoman.setRegisterType(com.jeysan.cpf.util.Constants.RegisterType.NO);
				fertileWoman.setBirth2Type(com.jeysan.cpf.util.Constants.Birth2Type.NO);
				fertileWoman.setAssStatus(com.jeysan.cpf.util.Constants.ASS_STATUS.NO_ASS);
				fertileWoman.setPerson(entity);
				//entity.setFertileWoman(fertileWoman);
				fertileWomanManager.saveFertileWoman(fertileWoman);
				if(entity.getPersonBasic().getMarryStatus() != null){
					fertileWoman.getWomanBasic().setMarryStatus(entity.getPersonBasic().getMarryStatus());
					fertileWoman.getWomanBasic().setFertileWoman(fertileWoman);
					fertileWoman.getWomanBasic().setMarryCryDate(entity.getPersonBasic().getMarryCryDate());
					womanBasicManager.saveWomanBasic(fertileWoman.getWomanBasic());
				}
			}else if(entity.getKind()==Constants.FW_KIND.NOT_FW){//非育龄妇女
				fertileWomanManager.deleteFertileWomanByPersonId(entity.getId());
			}
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存人员成功");
				result4Json.setAction(Result4Json.SAVE);
				monitorLogManager.saveMonitorLog("增加人员信息", System.currentTimeMillis()-t1_, 1);
			}else{
				result4Json.setMessage("修改人员成功");
				result4Json.setAction(Result4Json.UPDATE);
				monitorLogManager.saveMonitorLog("修改人员信息", System.currentTimeMillis()-t1_, 1);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存人员失败");
			}
			
		}
		//Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String cancel() throws Exception {
		String id = Struts2Utils.getParameter("id");
		String type = Struts2Utils.getParameter("type");
		String cancelType = Struts2Utils.getParameter("cancelType");
		String dateh = Struts2Utils.getParameter("dateh");
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			Person person = personManager.getPerson(Long.parseLong(id));
			if(StringUtils.isEmpty(cancelType))
				cancelType = Constants.CANCEL_TYPE.RENEW + "";
			person.setCancelType(Integer.parseInt(cancelType));
			person.setCancelDate(new Date());
			if(StringUtils.isNotEmpty(dateh))
				person.setDateh(DateUtil.createUtilDate(dateh));
			personManager.savePerson(person);
			
			if(StringUtils.equals(cancelType, Constants.CANCEL_TYPE.PERSON_OUT+"")){
				PersonOut personOut = new PersonOut();
				personOut.setPerson(person);
				personOut.setOutDate(person.getDateh());
				personOutManager.savePersonOut(personOut);
				monitorLogManager.saveMonitorLog("注销流出人员", System.currentTimeMillis()-t1_, 1);
			}else if(StringUtils.equals(cancelType, Constants.CANCEL_TYPE.DEATH+"")){
				DeathReg deathReg = new DeathReg();
				deathReg.setPerson(person);
				deathReg.setDateh(person.getDateh());
				deathRegManager.saveDeathReg(deathReg);
				monitorLogManager.saveMonitorLog("注销死亡人员", System.currentTimeMillis()-t1_, 1);
			}else if(StringUtils.equals(cancelType, Constants.CANCEL_TYPE.OLD_AGE+"")){
				monitorLogManager.saveMonitorLog("注销超龄人员", System.currentTimeMillis()-t1_, 1);
			}else if(StringUtils.equals(cancelType, Constants.CANCEL_TYPE.RENEW+"")){
				monitorLogManager.saveMonitorLog("恢复注销人员", System.currentTimeMillis()-t1_, 1);
			}
			result4Json.setStatusCode("200");
			result4Json.setAction(Result4Json.UPDATE);
			if(StringUtils.equals(type, "0")){
				result4Json.setMessage("注销成功");
			}else if(StringUtils.equals(type, "1")){
				result4Json.setMessage("恢复注销成功");
			}
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
	public Person getModel() {
		return entity;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	@Autowired
	public void setPersonBasicManager(PersonBasicManager personBasicManager) {
		this.personBasicManager = personBasicManager;
	}
	@Autowired
	public void setPersonOutManager(PersonOutManager personOutManager) {
		this.personOutManager = personOutManager;
	}
	@Autowired
	public void setVillagerTeamManager(VillagerTeamManager villagerTeamManager) {
		this.villagerTeamManager = villagerTeamManager;
	}
	@Autowired
	public void setHouseManager(HouseManager houseManager) {
		this.houseManager = houseManager;
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
	public void setDeathRegManager(DeathRegManager deathRegManager) {
		this.deathRegManager = deathRegManager;
	}
	public Page<Person> getPage() {
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
	public File getPersonBasic_photo() {
		return personBasic_photo;
	}
	public void setPersonBasic_photo(File personBasic_photo) {
		this.personBasic_photo = personBasic_photo;
	}
	
	
	
}
