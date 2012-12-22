package com.jeysan.cpf.pmas.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.pmas.entity.House;
import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.service.HouseManager;
import com.jeysan.cpf.pmas.service.PersonManager;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.modules.action.PrintActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.encode.EscapeCode;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/pmas")
@Results( { @Result(name = "house4lookup", location = "house4lookup.jsp", type = "dispatcher"),
	@Result(name = "house4stat1", location = "house4stat1.jsp", type = "dispatcher"),
	@Result(name = "house4stat2", location = "house4stat2.jsp", type = "dispatcher")})
public class HouseAction extends PrintActionSupport<House> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private House entity;
	private HouseManager houseManager;
	private PersonManager personManager;
	private Page<House> page = new Page<House>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				houseManager.deleteHouse(id);
				logger.debug("删除了房屋："+id);
				monitorLogManager.saveMonitorLog("删除房屋信息信息", System.currentTimeMillis()-t1_, 1);
			}else {
				houseManager.deleteHouses(ids);
				logger.debug("删除了很多房屋："+ids.toString());
				monitorLogManager.saveMonitorLog("删除房屋信息信息", System.currentTimeMillis()-t1_, StringUtils.split(ids, ",").length);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除房屋成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"房屋已经被关联,请先解除关联,删除失败":"删除房屋失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String getPersonNumByHouseCode() throws Exception {
		String code = Struts2Utils.getParameter("code");
		//logger.debug("code.............."+code);
		Map result = personManager.queryPersonNumByHouseCode(code);
		/*Map result = new HashMap();
		result.put("totalNum", 1000);
		result.put("maleNum", 800);
		result.put("femaleNum", 200);
		result.put("fertileWomanNum", 150);
		result.put("notFertileWomanNum", 50);*/
		Struts2Utils.renderJson(result);
		return NONE;
	}
	public String getPersonListByHouseCode() throws Exception {
		String code = Struts2Utils.getParameter("code");
		List<Person> plist = personManager.queryPersonListByHouseCode(code);
		List<Person> result = new ArrayList<Person>();
		Person newP = null;
		for(Person p : plist){
			newP = new Person();
			newP.setNameh(p.getNameh());
			newP.setAge(p.getAge());
			newP.setArea(p.getArea());
			newP.setCertType(p.getCertType());
			newP.setCertTypeLabel(getDictLabel(p.getCancelType()));
			newP.setCode(p.getCode());
			newP.setKind(p.getKind());
			newP.setKindLabel(getDictLabel(p.getKind()));
			newP.setDomicileType(p.getDomicileType());
			newP.setDomicileTypeLabel(getDictLabel(p.getDomicileType()));
			newP.setPersonCode(p.getPersonCode());
			newP.setSex(p.getSex());
			newP.setSexLabel(getDictLabel(p.getSex()));
			//代ID
			newP.setSettleInCause(p.getId()+"");
			result.add(newP);
		}
		Struts2Utils.renderJson(result);
		return NONE;
	}
	public String getPersonNumByKeyword() throws Exception {
		String keyword = EscapeCode.unescape(Struts2Utils.getParameter("keyword"));
		String type = Struts2Utils.getParameter("type");
		if(StringUtils.isEmpty(type))
			type = "ownerName";
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("LIKES_"+type,keyword));
		//page.setPageSize(-1);
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = houseManager.searchHouse(page, filters);
		Struts2Utils.renderJson(page);
		return NONE;
	}
	public String list4lookup() throws Exception {
		list();
		return "house4lookup";
	}
	@Override
	public String input() throws Exception {
		return INPUT;
	}
	@Override
	public String view() throws Exception {
		return VIEW;
	}
	public String getHouseListByDistrictCode() throws Exception {
		list();
		List<House> hList = page.getResult();
		List<House> result = new ArrayList<House>();
		House newH = null;
		for(House p : hList){
			newH = new House();
			newH.setHouseCode(p.getHouseCode());
			newH.setHouseAtt(p.getHouseAtt());
			newH.setHouseType(p.getHouseType());
			newH.setOwnerName(p.getOwnerName());
			newH.setOwnerCert(p.getOwnerCert());
			newH.setHouseAttLabel(getDictLabel(p.getHouseAtt()));
			newH.setHouseTypeLabel(getDictLabel(p.getHouseType()));
			newH.setArea(p.getArea());
			newH.setDetailAddress(p.getDetailAddress());
			//代id
			newH.setOwnerCompany(p.getId()+"");
			result.add(newH);
		}
		page.setResult(result);
		Struts2Utils.renderJson(page);
		return NONE;
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
		
		setDataAuth(filters, "area2");
		
		page = houseManager.searchHouse(page, filters);
		String type = Struts2Utils.getParameter("type");
		if(StringUtils.isNotEmpty(type)){
			return "house4stat"+type;
		}
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new House();
		}else{
			entity = houseManager.getHouse(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			houseManager.saveHouse(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存房屋成功");
				result4Json.setAction(Result4Json.SAVE);
				monitorLogManager.saveMonitorLog("增加房屋信息", System.currentTimeMillis()-t1_, 1);
			}else{
				result4Json.setMessage("修改房屋成功");
				result4Json.setAction(Result4Json.UPDATE);
				monitorLogManager.saveMonitorLog("修改房屋信息", System.currentTimeMillis()-t1_, 1);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存房屋失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public House getModel() {
		return entity;
	}
	@Autowired
	public void setHouseManager(HouseManager houseManager) {
		this.houseManager = houseManager;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	public Page<House> getPage() {
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
