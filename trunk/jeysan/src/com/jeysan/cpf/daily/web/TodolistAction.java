package com.jeysan.cpf.daily.web;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.daily.entity.Todolist;
import com.jeysan.cpf.daily.service.TodolistManager;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.modules.action.CrudActionSupport;
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
@Namespace("/daily")
public class TodolistAction extends CrudActionSupport<Todolist> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private Todolist entity;
	private TodolistManager todolistManager;
	private Page<Todolist> page = new Page<Todolist>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				todolistManager.deleteTodolist(id);
				logger.debug("删除了待办事宜："+id);
			}else {
				todolistManager.deleteTodolists(ids);
				logger.debug("删除了很多待办事宜："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除待办事宜成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"待办事宜已经被关联,请先解除关联,删除失败":"删除待办事宜失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public String input() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		User user = (User)Struts2Utils.getRequest().getSession().getAttribute("_js_user");
		filters.add(new PropertyFilter("EQL_userId",user.getId()+""));
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page.setPageSize(-1);
		page.setAutoCount(false);
		page = todolistManager.searchTodolist(page, filters);
		List<Todolist> result = page.getResult();
		if(result!=null && result.size() > 0){
			StringBuilder strb = new StringBuilder();
			strb.append("<data>");
			for(Todolist todolist:result){
				strb.append("<event id=\"" ).append( todolist.getId() ).append( "\">")
				.append("<start_date><![CDATA[" ).append( DateUtil.convertDateToString(todolist.getStartTime()) ).append( "]]></start_date>")
				.append("<end_date><![CDATA[" ).append( DateUtil.convertDateToString(todolist.getEndTime()) ).append( "]]></end_date>")
				.append("<text><![CDATA[" ).append( todolist.getDetail() ).append( "]]></text>")
				.append("<details><![CDATA[" ).append( todolist.getDetail() ).append( "]]></details>")
				.append("</event>");
			}
			strb.append("</data>");
			//mv.addObject(strb);
			Struts2Utils.getResponse().setContentType("text/xml;charset=UTF-8");
			Struts2Utils.getResponse().getWriter().print(strb.toString());
		}
		return NONE;
	}
	@Override
	public String view() throws Exception {
		return VIEW;
	}
	@Override
	public String list() throws Exception {
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		/*if(id == null){
			entity = new Todolist();
		}else{
			entity = todolistManager.getTodolist(id);
		}*/
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			boolean isSave = false;
			try{
				entity = todolistManager.getTodolist(id);
				entity.setStartTime(new Date());
			}catch(Exception e){
				isSave = true;
			}
			if(isSave){
				entity = new Todolist();
				entity.setId(id);
			}
			entity.setStartTime(DateUtil.createTimestamp(Struts2Utils.getParameter("startTime")));
			entity.setEndTime(DateUtil.createTimestamp(Struts2Utils.getParameter("endTime")));
			//entity.setTitle(Struts2Utils.getParameter("title"));
			entity.setDetail(Struts2Utils.getParameter("title"));
			User user = (User)Struts2Utils.getRequest().getSession().getAttribute("_js_user");
			entity.setUserId(new Long(user.getId()));
			/*if(isSave)
				todolistManager.saveTodolistOnly(entity);
			else
				todolistManager.updateTodolistOnly(entity);*/
			todolistManager.saveTodolist(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存待办事宜成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改待办事宜成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存待办事宜失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Todolist getModel() {
		return entity;
	}
	@Autowired
	public void setTodolistManager(TodolistManager todolistManager) {
		this.todolistManager = todolistManager;
	}
	public Page<Todolist> getPage() {
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
