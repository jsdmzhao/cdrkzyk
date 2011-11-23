package com.jeysan.cpf.daily.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.daily.entity.ReceiveMail;
import com.jeysan.cpf.daily.entity.RubbishMail;
import com.jeysan.cpf.daily.service.ReceiveMailManager;
import com.jeysan.cpf.daily.service.RubbishMailManager;
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
public class ReceiveMailAction extends CrudActionSupport<ReceiveMail> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private ReceiveMail entity;
	private ReceiveMailManager receiveMailManager;
	private RubbishMailManager rubbishMailManager;
	private Page<ReceiveMail> page = new Page<ReceiveMail>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				ReceiveMail rm = receiveMailManager.getReceiveMail(id);
				delete2rubbish(rm);
				receiveMailManager.deleteReceiveMail(rm);
				logger.debug("删除了邮件："+id);
			}else {
				if(StringUtils.isNotEmpty(ids)){
					ReceiveMail rm = null;
					for(String id_ : StringUtils.split(ids,",")){
						rm = receiveMailManager.getReceiveMail(Long.parseLong(id_));
						delete2rubbish(rm);
						receiveMailManager.deleteReceiveMail(rm);
					}
				}
				logger.debug("删除了很多邮件："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除邮件成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"邮件已经被关联,请先解除关联,删除失败":"删除邮件失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	private void delete2rubbish(ReceiveMail rm){
		RubbishMail rbm = new RubbishMail();
		rbm.setAttachment(rm.getAttachment());
		rbm.setContent(rm.getContent());
		rbm.setDateKt(rm.getDateKt());
		rbm.setIsRead(rm.getIsRead());
		rbm.setReceiveEmployeeIds(rm.getReceiveEmployeeIds());
		rbm.setSendEmployeeId(rm.getSendEmployeeId());
		rbm.setTitle(rm.getTitle());
		rbm.setStatus("1");//1正常 0 已经删除
		rbm.setParMailId(rm.getId());
		rbm.setSource("0");//0 来源于收件箱 1来源于发件箱 2来源于草稿箱
		rbm.setParMailId(rm.getParMailId());
		rubbishMailManager.saveRubbishMail(rbm);
	}
	@Override
	public String input() throws Exception {
		return INPUT;
	}
	@Override
	public String view() throws Exception {
		if(entity.getIsRead().intValue() != Constants.IsRead.YES){
			entity.setIsRead(Constants.IsRead.YES);
			receiveMailManager.saveReceiveMail(entity);
		}
		return VIEW;
	}
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		User user = (User)Struts2Utils.getRequest().getSession().getAttribute("_js_user");
		filters.add(new PropertyFilter("EQS_receiveEmployeeIds",user.getId()+""));
		String dateKt = Struts2Utils.getRequest().getParameter("dateKt");
		if(StringUtils.isNotEmpty(dateKt)){
			filters.add(new PropertyFilter("GED_dateKt",dateKt+" 00:00:00"));
			filters.add(new PropertyFilter("LED_dateKt",dateKt+" 23:59:59"));
		}
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("dateKt");
			page.setOrder(Page.DESC);
		}
		page = receiveMailManager.searchReceiveMail(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new ReceiveMail();
		}else{
			entity = receiveMailManager.getReceiveMail(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			receiveMailManager.saveReceiveMail(entity);
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
	public ReceiveMail getModel() {
		return entity;
	}
	@Autowired
	public void setReceiveMailManager(ReceiveMailManager receiveMailManager) {
		this.receiveMailManager = receiveMailManager;
	}
	@Autowired
	public void setRubbishMailManager(RubbishMailManager rubbishMailManager) {
		this.rubbishMailManager = rubbishMailManager;
	}
	public Page<ReceiveMail> getPage() {
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
