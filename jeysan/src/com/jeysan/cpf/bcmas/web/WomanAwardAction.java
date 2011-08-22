package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.WomanAward;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.bcmas.service.WomanAwardManager;
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
@Namespace("/bcmas")
public class WomanAwardAction extends CrudActionSupport<WomanAward> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private WomanAward entity;
	private WomanAwardManager womanAwardManager;
	private FertileWomanManager fertileWomanManager;
	private Page<WomanAward> page = new Page<WomanAward>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				womanAwardManager.deleteWomanAward(id);
				logger.debug("删除了奖励信息："+id);
			}else {
				womanAwardManager.deleteWomanAwards(ids);
				logger.debug("删除了很多奖励信息："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除奖励信息成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"奖励信息已经被关联,请先解除关联,删除失败":"删除奖励信息失败");
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
		page.setPageSize(-1);
		page = womanAwardManager.searchWomanAward(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new WomanAward();
			String fertileWomanId = Struts2Utils.getParameter("fertileWomanId");
			if(StringUtils.isNotEmpty(fertileWomanId))
				Struts2Utils.getRequest().setAttribute("fertileWoman", fertileWomanManager.getFertileWoman(Long.parseLong(fertileWomanId)));
		}else{
			entity = womanAwardManager.getWomanAward(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			womanAwardManager.saveWomanAward(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存奖励信息成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改奖励信息成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存奖励信息失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public WomanAward getModel() {
		return entity;
	}
	@Autowired
	public void setWomanAwardManager(WomanAwardManager womanAwardManager) {
		this.womanAwardManager = womanAwardManager;
	}
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	public Page<WomanAward> getPage() {
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
