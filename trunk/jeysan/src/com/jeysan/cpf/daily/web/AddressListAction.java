package com.jeysan.cpf.daily.web;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.daily.entity.AddressList;
import com.jeysan.cpf.daily.service.AddressListManager;
import com.jeysan.cpf.security.entity.User;
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
@Namespace("/daily")
public class AddressListAction extends PrintActionSupport<AddressList> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private AddressList entity;
	private AddressListManager addressListManager;
	private Page<AddressList> page = new Page<AddressList>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				addressListManager.deleteAddressList(id);
				logger.debug("删除了通讯录："+id);
			}else {
				addressListManager.deleteAddressLists(ids);
				logger.debug("删除了很多通讯录："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除通讯录成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"通讯录已经被关联,请先解除关联,删除失败":"删除通讯录失败");
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
		User user = (User)Struts2Utils.getRequest().getSession().getAttribute("_js_user");
		filters.add(new PropertyFilter("EQL_userId",user.getId()+""));
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = addressListManager.searchAddressList(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new AddressList();
		}else{
			entity = addressListManager.getAddressList(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			if(entity.getUserId() == null){
				User user = (User)Struts2Utils.getRequest().getSession().getAttribute("_js_user");
				entity.setUserId(new Long(user.getId()));
			}
			addressListManager.saveAddressList(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存通讯录成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改通讯录成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存通讯录失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public AddressList getModel() {
		return entity;
	}
	@Autowired
	public void setAddressListManager(AddressListManager addressListManager) {
		this.addressListManager = addressListManager;
	}
	public Page<AddressList> getPage() {
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
