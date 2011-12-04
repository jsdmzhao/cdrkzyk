package com.jeysan.cpf.bcmas.web;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.MarryCert;
import com.jeysan.cpf.bcmas.service.MarryCertManager;
import com.jeysan.cpf.bcmas.service.WomanContraceptManager;
import com.jeysan.cpf.bcmas.service.WomanSocialUpbringManager;
import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.service.SpouseManager;
import com.jeysan.modules.action.PrintActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.file.FileUploadUtils;
import com.jeysan.modules.utils.file.FileUtils;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/bcmas")
@Results( {@Result(name = "view4print", location = "marrycert-view4print.jsp", type = "dispatcher")})
public class MarryCertAction extends PrintActionSupport<MarryCert> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private MarryCert entity;
	private MarryCertManager marryCertManager;
	private SpouseManager spouseManager;
	private WomanContraceptManager womanContraceptManager;
	private WomanSocialUpbringManager womanSocialUpbringManager;
	private Page<MarryCert> page = new Page<MarryCert>(DEFAULT_PAGE_SIZE);
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
				logger.debug("删除了婚育证明："+id);
			}else {
				for(String pid : StringUtils.split(ids, ","))
					deleteMarryCert(Long.parseLong(pid));
				logger.debug("删除了很多婚育证明："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除婚育证明成功");
			result4Json.setAction(Result4Json.DELETE);
			
			monitorLogManager.saveMonitorLog("删除婚育证明信息", System.currentTimeMillis()-t1_, id!=null?1:StringUtils.split(ids, ",").length);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"婚育证明已经被关联,请先解除关联,删除失败":"删除婚育证明失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	private void deleteMarryCert(Long pid){
		MarryCert p = marryCertManager.getMarryCert(pid);
		String photo_ = p.getPhoto();
		marryCertManager.deleteMarryCert(p);
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
			Struts2Utils.getRequest().setAttribute("spouse", spouseManager.getSpouseByPersonId(entity.getPerson().getId()));
			Struts2Utils.getRequest().setAttribute("wcs", womanContraceptManager.searchWomanContracepts(entity.getPerson().getId()));
			Struts2Utils.getRequest().setAttribute("wuds", womanSocialUpbringManager.searchWomanSocialUpbrings(entity.getPerson().getId()));
			return "view4print";
		}
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
		page = marryCertManager.searchMarryCert(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new MarryCert();
		}else{
			entity = marryCertManager.getMarryCert(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{

			long t1_ = System.currentTimeMillis();
			if(id == null){
				String personId = Struts2Utils.getParameter("master.dwz_personLookup.personId");
				if(StringUtils.isNotEmpty(personId)){
					Person person = new Person();
					person.setId(Long.parseLong(personId));
					entity.setPerson(person);
				}
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
			
			marryCertManager.saveMarryCert(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存婚育证明成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改婚育证明成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
			monitorLogManager.saveMonitorLog((id == null?"增加":"修改")+"婚育证明信息", System.currentTimeMillis()-t1_, 1);

		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存婚育证明失败");
			}
			
		}
		//Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public MarryCert getModel() {
		return entity;
	}
	@Autowired
	public void setMarryCertManager(MarryCertManager marryCertManager) {
		this.marryCertManager = marryCertManager;
	}
	@Autowired
	public void setSpouseManager(SpouseManager spouseManager) {
		this.spouseManager = spouseManager;
	}
	@Autowired
	public void setWomanContraceptManager(WomanContraceptManager womanContraceptManager) {
		this.womanContraceptManager = womanContraceptManager;
	}
	@Autowired
	public void setWomanSocialUpbringManager(WomanSocialUpbringManager womanSocialUpbringManager) {
		this.womanSocialUpbringManager = womanSocialUpbringManager;
	}
	public Page<MarryCert> getPage() {
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
