package com.jeysan.cpf.daily.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.daily.entity.ReceiveMail;
import com.jeysan.cpf.daily.entity.RubbishMail;
import com.jeysan.cpf.daily.entity.SendMail;
import com.jeysan.cpf.daily.service.ReceiveMailManager;
import com.jeysan.cpf.daily.service.RubbishMailManager;
import com.jeysan.cpf.daily.service.SendMailManager;
import com.jeysan.cpf.security.entity.User;
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
public class RubbishMailAction extends CrudActionSupport<RubbishMail> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private RubbishMail entity;
	private RubbishMailManager rubbishMailManager;
	private ReceiveMailManager receiveMailManager;
	private SendMailManager sendMailManager;
	private Page<RubbishMail> page = new Page<RubbishMail>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			String type = StringUtils.trim(Struts2Utils.getParameter("type"));
			if(StringUtils.equals(type, "1")){
				if(id!=null){
					RubbishMail rm = rubbishMailManager.getRubbishMail(id);
					backFromRubbishMail(rm);
					rubbishMailManager.deleteRubbishMail(rm);
				}else if(StringUtils.isNotEmpty(ids)){
					RubbishMail rm = null;
					for(String id_ : StringUtils.split(ids,",")){
						rm = rubbishMailManager.getRubbishMail(Long.parseLong(id_));
						backFromRubbishMail(rm);
						rubbishMailManager.deleteRubbishMail(rm);
					}
				}
				result4Json.setMessage("还原邮件成功");
			}else{
				if(id!=null){
					RubbishMail rm = rubbishMailManager.getRubbishMail(id);
					rm.setStatus("0");
					rubbishMailManager.saveRubbishMail(rm);
					logger.debug("删除了邮件："+id);
				}else {
					if(StringUtils.isNotEmpty(ids)){
						RubbishMail rm = null;
						for(String id_ : StringUtils.split(ids,",")){
							rm = rubbishMailManager.getRubbishMail(Long.parseLong(id_));
							rm.setStatus("0");
							rubbishMailManager.saveRubbishMail(rm);
						}
					}
					logger.debug("删除了很多邮件："+ids.toString());
				}
				result4Json.setMessage("删除邮件成功");
			}
			result4Json.setStatusCode("200");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"邮件已经被关联,请先解除关联,操作失败":"操作失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	private void backFromRubbishMail(RubbishMail rbm){
		if(StringUtils.equals(rbm.getSource(),"0")){
			ReceiveMail rm = new ReceiveMail();
			rm.setAttachment(rbm.getAttachment());
			rm.setContent(rbm.getContent());
			rm.setDateKt(rbm.getDateKt());
			rm.setIsRead(rbm.getIsRead());
			rm.setReceiveEmployeeIds(rbm.getReceiveEmployeeIds());
			rm.setSendEmployeeId(rbm.getSendEmployeeId());
			rm.setTitle(rbm.getTitle());
			rm.setParMailId(rbm.getParMailId());
			receiveMailManager.saveReceiveMail(rm);
		}else{
			SendMail sm = new SendMail();
			sm.setStatus(rbm.getSource());
			sm.setAttachment(rbm.getAttachment());
			sm.setContent(rbm.getContent());
			sm.setDateKt(rbm.getDateKt());
			sm.setParMailId(rbm.getParMailId());
			sm.setReceiveEmployeeIds(rbm.getReceiveEmployeeIds());
			sm.setSendEmployeeId(rbm.getSendEmployeeId());
			sm.setTitle(rbm.getTitle());
			sendMailManager.saveSendMail(sm);
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
		User user = (User)Struts2Utils.getRequest().getSession().getAttribute("_js_user");
		filters.add(new PropertyFilter("EQL_sendEmployeeId",user.getId()+""));
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = rubbishMailManager.searchRubbishMail(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new RubbishMail();
		}else{
			entity = rubbishMailManager.getRubbishMail(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			rubbishMailManager.saveRubbishMail(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存邮件成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改邮件成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存邮件失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public RubbishMail getModel() {
		return entity;
	}
	@Autowired
	public void setRubbishMailManager(RubbishMailManager rubbishMailManager) {
		this.rubbishMailManager = rubbishMailManager;
	}
	@Autowired
	public void setReceiveMailManager(ReceiveMailManager receiveMailManager) {
		this.receiveMailManager = receiveMailManager;
	}
	@Autowired
	public void setSendMailManager(SendMailManager sendMailManager) {
		this.sendMailManager = sendMailManager;
	}
	public Page<RubbishMail> getPage() {
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
