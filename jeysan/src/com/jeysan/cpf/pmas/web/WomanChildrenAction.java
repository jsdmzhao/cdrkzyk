package com.jeysan.cpf.pmas.web;

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

import com.jeysan.cpf.pmas.entity.WomanChildren;
import com.jeysan.cpf.pmas.service.PersonManager;
import com.jeysan.cpf.pmas.service.SpouseManager;
import com.jeysan.cpf.pmas.service.WomanChildrenManager;
import com.jeysan.cpf.security.service.DictSubManager;
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
@Results( { @Result(name = "multiplysubs", location = "womanchildren-subs.jsp", type = "dispatcher"),
	@Result(name = "simplesub", location = "womanchildren-view-sub.jsp", type = "dispatcher")})
public class WomanChildrenAction extends PrintActionSupport<WomanChildren> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private WomanChildren entity;
	private WomanChildrenManager womanChildrenManager;
	private PersonManager personManager;
	private SpouseManager spouseManager;
	private DictSubManager dictSubManager;
	private Page<WomanChildren> page = new Page<WomanChildren>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private File photo_;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				deleteWomanChildren(id);
				logger.debug("删除了子女："+id);
			}else {
				for(String pid : StringUtils.split(ids, ","))
					deleteWomanChildren(Long.parseLong(pid));
				logger.debug("删除了很多子女："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除子女成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"子女已经被关联,请先解除关联,删除失败":"删除子女失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	private void deleteWomanChildren(Long pid){
		WomanChildren p = womanChildrenManager.getWomanChildren(pid);
		String photo_ = p.getPhoto();
		womanChildrenManager.deleteWomanChildren(p);
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
		return VIEW;
	}
	public String multiplysubs() throws Exception {
		prepareModel();
		String personId = Struts2Utils.getParameter("personId");
		if(StringUtils.isNotEmpty(personId)){
			Long personIdL = Long.parseLong(personId);
			Struts2Utils.getRequest().setAttribute("spouse",spouseManager.getSpouseByPersonId(personIdL));
		}
		return "multiplysubs";
	}
	@Override
	public String list() throws Exception {
		prepareModel();
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = womanChildrenManager.searchWomanChildren(page, filters);
		return SUCCESS;
	}
	public String simplesub() throws Exception {
		prepareModel();
		Struts2Utils.getRequest().setAttribute("entity",entity);
		return "simplesub";
	}
	public String simplesub4ajax() throws Exception {
		String personId = Struts2Utils.getParameter("personId");
		if(StringUtils.isNotEmpty(personId)){
			WomanChildren children = womanChildrenManager.getWomanChildrenByPersonId(Long.parseLong(personId));
			if(children!=null){
				if(children.getSex() != null)
					children.setSexLabel(dictSubManager.getDictSub(children.getSex()).getSubName());
				if(children.getNative() != null)
					children.setNativeLabel(dictSubManager.getDictSub(children.getNative()).getSubName());
				if(children.getBirthday() != null)
					children.setBirthdayLabel(DateUtil.convertDateToString(children.getBirthday(),"yyyy-MM-dd"));
			}else
				children = new WomanChildren();
			
			Struts2Utils.renderJson(children);
		}
		return NONE;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new WomanChildren();
		}else{
			entity = womanChildrenManager.getWomanChildren(id);
		}
		String personId = Struts2Utils.getParameter("personId");
		if(StringUtils.isNotEmpty(personId)){
			Long personIdL = Long.parseLong(personId);
			Struts2Utils.getRequest().setAttribute("person",personManager.getPerson(personIdL));
			Struts2Utils.getRequest().setAttribute("spouse",spouseManager.getSpouseByPersonId(personIdL));
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
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
			womanChildrenManager.saveWomanChildren(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存子女成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改子女成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存子女失败");
			}
			
		}
		//Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public WomanChildren getModel() {
		return entity;
	}
	@Autowired
	public void setWomanChildrenManager(WomanChildrenManager womanChildrenManager) {
		this.womanChildrenManager = womanChildrenManager;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	@Autowired
	public void setSpouseManager(SpouseManager spouseManager) {
		this.spouseManager = spouseManager;
	}
	@Autowired
	public void setDictSubManager(DictSubManager dictSubManager) {
		this.dictSubManager = dictSubManager;
	}
	public Page<WomanChildren> getPage() {
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
