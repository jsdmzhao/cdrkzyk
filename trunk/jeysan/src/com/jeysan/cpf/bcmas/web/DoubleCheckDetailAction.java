package com.jeysan.cpf.bcmas.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.bcmas.entity.DoubleCheck2;
import com.jeysan.cpf.bcmas.entity.DoubleCheckDetail;
import com.jeysan.cpf.bcmas.service.DoubleCheck2Manager;
import com.jeysan.cpf.bcmas.service.DoubleCheckDetailManager;
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
public class DoubleCheckDetailAction extends CrudActionSupport<DoubleCheck2> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private DoubleCheck2 entity;
	private DoubleCheck2Manager doubleCheck2Manager;
	private DoubleCheckDetailManager doubleCheckDetailManager;
	private Page<DoubleCheckDetail> page = new Page<DoubleCheckDetail>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				doubleCheckDetailManager.deleteDoubleCheckDetail(id);
				logger.debug("删除了双查轮次详情："+id);
			}else {
				doubleCheckDetailManager.deleteDoubleCheckDetails(ids);
				logger.debug("删除了很多双查轮次详情："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除双查轮次详情成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"双查轮次详情已经被关联,请先解除关联,删除失败":"删除双查轮次详情失败");
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
		page = doubleCheckDetailManager.searchDoubleCheckDetail(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		String year_ = Struts2Utils.getParameter("year");
		Integer year = null;
		if(StringUtils.isEmpty(year_)){
			Calendar ca = Calendar.getInstance();
			ca.setTime(new Date());
			year = ca.get(Calendar.YEAR);
		}else
			year = Integer.parseInt(year_);
		Struts2Utils.getRequest().setAttribute("year", year);
		entity = doubleCheck2Manager.getDoubleCheck2ByYear(year);
		if(entity == null)
			entity = new DoubleCheck2();
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			doubleCheck2Manager.saveDoubleCheck2(entity);
			String[] detail_starts = Struts2Utils.getParameterValues("detail_start");
			String[] detail_ends = Struts2Utils.getParameterValues("detail_end");
			DoubleCheckDetail dcd = null;
			for(int i = 0; i<detail_starts.length; i++){
				dcd = new DoubleCheckDetail();
				dcd.setDoubleCheck2(entity);
				dcd.setStart(detail_starts[i]);
				dcd.setEnd(detail_ends[i]);
				dcd.setSeq(i+1);
				doubleCheckDetailManager.saveDoubleCheckDetail(dcd);
			}
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存整体双查轮次成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改整体双查轮次成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存整体双查轮次失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public DoubleCheck2 getModel() {
		return entity;
	}
	@Autowired
	public void setDoubleCheckDetailManager(DoubleCheckDetailManager doubleCheckDetailManager) {
		this.doubleCheckDetailManager = doubleCheckDetailManager;
	}
	@Autowired
	public void setDoubleCheck2Manager(DoubleCheck2Manager doubleCheck2Manager) {
		this.doubleCheck2Manager = doubleCheck2Manager;
	}
	public Page<DoubleCheckDetail> getPage() {
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
