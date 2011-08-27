package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.jeysan.cpf.bcmas.entity.DoubleCheck;
import com.jeysan.cpf.bcmas.entity.DoubleCheck2;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.entity.FertileWomanDcView;
import com.jeysan.cpf.bcmas.service.DoubleCheck2Manager;
import com.jeysan.cpf.bcmas.service.DoubleCheckManager;
import com.jeysan.cpf.bcmas.service.FertileWomanDcViewManager;
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
@Namespace("/bcmas")
public class DoubleCheckAction extends CrudActionSupport<FertileWomanDcView> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private String id;
	private String ids;
	private FertileWomanDcView entity;
	private DoubleCheckManager doubleCheckManager;
	private DoubleCheck2Manager doubleCheck2Manager;
	private FertileWomanDcViewManager fertileWomanDcViewManager;
	private Page<FertileWomanDcView> page = new Page<FertileWomanDcView>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(ids!=null){
				String[] id_arr = StringUtils.split(ids,",");
				String type = Struts2Utils.getParameter("type");
				DoubleCheck dc = null;
				List dcs = Lists.newArrayList();
				for(String id_str : id_arr){
					String[] id_arr_ = StringUtils.split(id_str,"_");
					String womanId = id_arr_[0];
					String dcId = id_arr_[1];
					if(StringUtils.isNotEmpty(womanId)){
						if(StringUtils.isNotEmpty(dcId))
							dc = doubleCheckManager.getDoubleCheckByFID(Long.parseLong(dcId),Long.parseLong(womanId));
					}
					if(dc == null)
						dc = new DoubleCheck();
					if(StringUtils.equals(type, "0"))
						dc.setTypeh(Constants.DC_TYPEH.NO_CHECK);
					else if(StringUtils.equals(type, "1"))
						dc.setTypeh(Constants.DC_TYPEH.FREE_CHECK);
					dcs.add(dc);
				}
				doubleCheckManager.saveDoubleChecks(dcs);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("操作成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage("操作失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public String input() throws Exception {
		//entity = fertileWomanDcViewManager.getFertileWomanDcView(id);
		//Struts2Utils.getRequest().setAttribute("entity",entity);
		Struts2Utils.getRequest().setAttribute("dcs", doubleCheck2Manager.getAllDoubleCheck());
		return INPUT;
	}
	@Override
	public String view() throws Exception {
		//entity = fertileWomanDcViewManager.getFertileWomanDcView(id);
		//Struts2Utils.getRequest().setAttribute("entity",entity);
		if(entity.getDcId() != null)
			Struts2Utils.getRequest().setAttribute("dc", doubleCheck2Manager.getDoubleCheck2(entity.getDcId()));
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
		page = fertileWomanDcViewManager.searchFertileWomanView(page, filters);
		Struts2Utils.getRequest().setAttribute("dcs", doubleCheck2Manager.getAllDoubleCheck());
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		String noPre = Struts2Utils.getParameter("noPre");
		if(StringUtils.equals(noPre, "yes"))
			return;
		if(id != null){
			/*String[] id_arr = StringUtils.split(id,"_");
			String womanId = id_arr[0];
			String dcId = id_arr[1];
			if(StringUtils.isNotEmpty(womanId)){
				if(StringUtils.isNotEmpty(dcId))
					entity = fertileWomanDcViewManager.getFertileWomanDcView(Long.parseLong(dcId),Long.parseLong(womanId));
				else
					entity = fertileWomanDcViewManager.getFertileWomanDcView(Long.parseLong(womanId));
			}*/
			entity = fertileWomanDcViewManager.getFertileWomanDcView(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			String[] id_arr = StringUtils.split(id,"_");
			String womanId = id_arr[0];
			
			DoubleCheck dc = null;
			String dcId = Struts2Utils.getParameter("dcId");
			if(StringUtils.isNotEmpty(dcId)){
				dc = doubleCheckManager.getDoubleCheckByFID(Long.parseLong(dcId), Long.parseLong(womanId));
				if(dc == null)
					dc = new DoubleCheck();
				FertileWoman fertileWoman = new FertileWoman();
				fertileWoman.setId(Long.parseLong(womanId));
				dc.setFertileWoman(fertileWoman);
				DoubleCheck2 dc2 = new DoubleCheck2();
				dc2.setId(Long.parseLong(dcId));
				dc.setDc2(dc2);
				String dcTypeh = Struts2Utils.getParameter("dcTypeh");
				if(StringUtils.isNotEmpty(dcTypeh))
					dc.setTypeh(Integer.parseInt(dcTypeh));
				dc.setCause(Struts2Utils.getParameter("cause"));
				dc.setStart(Struts2Utils.getParameter("start"));
				doubleCheckManager.saveDoubleCheck(dc);
				result4Json.setStatusCode("200");
				if(id == null){
					result4Json.setMessage("保存双查轮次成功");
					result4Json.setAction(Result4Json.SAVE);
				}else{
					result4Json.setMessage("修改双查轮次成功");
					result4Json.setAction(Result4Json.UPDATE);
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存双查轮次失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public FertileWomanDcView getModel() {
		return entity;
	}
	@Autowired
	public void setDoubleCheckManager(DoubleCheckManager doubleCheckManager) {
		this.doubleCheckManager = doubleCheckManager;
	}
	@Autowired
	public void setDoubleCheck2Manager(DoubleCheck2Manager doubleCheck2Manager) {
		this.doubleCheck2Manager = doubleCheck2Manager;
	}
	@Autowired
	public void setFertileWomanDcViewManager(
			FertileWomanDcViewManager fertileWomanDcViewManager) {
		this.fertileWomanDcViewManager = fertileWomanDcViewManager;
	}
	public Page<FertileWomanDcView> getPage() {
		return page;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}
	
	
}
