package com.jeysan.cpf.daily.web;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.daily.entity.ReceiveMail;
import com.jeysan.cpf.daily.entity.SendMail;
import com.jeysan.cpf.daily.service.ReceiveMailManager;
import com.jeysan.cpf.daily.service.SendMailManager;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.cpf.security.service.UserManager;
import com.jeysan.cpf.util.Constants;
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
public class SendMailAction extends CrudActionSupport<SendMail> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private SendMail entity;
	private SendMailManager sendMailManager;
	private UserManager userManager;
	private ReceiveMailManager receiveMailManager;
	private Page<SendMail> page = new Page<SendMail>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				sendMailManager.deleteSendMail(id);
				logger.debug("删除了fhp_send_mail："+id);
			}else {
				sendMailManager.deleteSendMails(ids);
				logger.debug("删除了很多fhp_send_mail："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除fhp_send_mail成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"fhp_send_mail已经被关联,请先解除关联,删除失败":"删除fhp_send_mail失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public String input() throws Exception {
		Struts2Utils.getRequest().setAttribute("users", userManager.loadAllUsers());
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
		page = sendMailManager.searchSendMail(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new SendMail();
		}else{
			entity = sendMailManager.getSendMail(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		String msg = null;
		try{
			if(entity.getSendEmployeeId() == null){
				User user = (User)Struts2Utils.getRequest().getSession().getAttribute("_js_user");
				entity.setSendEmployeeId(new Long(user.getId()));
			}
			entity.setDateKt(new Date());
			String send_type = StringUtils.trim(Struts2Utils.getParameter("send_type"));
			if(StringUtils.equals(send_type, "0")||StringUtils.equals(send_type, "1")){
				entity.setStatus("2");//草稿箱
				msg = "保存邮件";
			}

			if(StringUtils.equals(send_type, "0")||StringUtils.equals(send_type, "2")){
				entity.setStatus("1");//发件箱
				msg = "发送邮件";
			}
			//0 发送 1保存 2发送并保存
			if(StringUtils.equals(send_type, "0")||StringUtils.equals(send_type, "2")){
				String receiveEmployeeIds = entity.getReceiveEmployeeIds();
				ReceiveMail rm = null;
				for(String reid : StringUtils.split(receiveEmployeeIds, ",")){
					rm = new ReceiveMail();
					rm.setAttachment(entity.getAttachment());
					rm.setContent(entity.getContent());
					rm.setDateKt(entity.getDateKt());
					rm.setIsRead(Constants.IsRead.NO);//未读
					rm.setReceiveEmployeeIds(reid);
					rm.setSendEmployeeId(entity.getSendEmployeeId());
					rm.setTitle(entity.getTitle());
					rm.setStatus("0");
					receiveMailManager.saveReceiveMail(rm);
				}
			}
			sendMailManager.saveSendMail(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage(msg+"成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage(msg+"成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("邮件已被删除，请重新添加");
			}else{
				result4Json.setMessage(msg+"失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public SendMail getModel() {
		return entity;
	}
	@Autowired
	public void setSendMailManager(SendMailManager sendMailManager) {
		this.sendMailManager = sendMailManager;
	}
	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	@Autowired
	public void setReceiveMailManager(ReceiveMailManager receiveMailManager) {
		this.receiveMailManager = receiveMailManager;
	}
	public Page<SendMail> getPage() {
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
