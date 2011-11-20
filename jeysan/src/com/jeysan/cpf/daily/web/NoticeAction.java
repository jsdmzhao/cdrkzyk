package com.jeysan.cpf.daily.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.daily.entity.Notice;
import com.jeysan.cpf.daily.service.NoticeManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/daily")
public class NoticeAction extends CrudActionSupport<Notice> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Notice entity;
	private NoticeManager noticeManager;
	private Page<Notice> page = new Page<Notice>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				noticeManager.deleteNotice(id);
				logger.debug("删除了fhp_notice："+id);
			}else {
				noticeManager.deleteNotices(ids);
				logger.debug("删除了很多fhp_notice："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除fhp_notice成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"fhp_notice已经被关联,请先解除关联,删除失败":"删除fhp_notice失败");
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
		page = noticeManager.searchNotice(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Notice();
		}else{
			entity = noticeManager.getNotice(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			noticeManager.saveNotice(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存fhp_notice成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改fhp_notice成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存fhp_notice失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Notice getModel() {
		return entity;
	}
	@Autowired
	public void setNoticeManager(NoticeManager noticeManager) {
		this.noticeManager = noticeManager;
	}
	public Page<Notice> getPage() {
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
