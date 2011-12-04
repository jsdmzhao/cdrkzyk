package com.jeysan.cpf.pmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.pmas.entity.VillagerTeam;
import com.jeysan.cpf.pmas.service.VillagerTeamManager;
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
@Namespace("/pmas")
public class VillagerTeamAction extends PrintActionSupport<VillagerTeam> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private VillagerTeam entity;
	private VillagerTeamManager villagerTeamManager;
	private Page<VillagerTeam> page = new Page<VillagerTeam>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			long t1_ = System.currentTimeMillis();
			if(id!=null){
				villagerTeamManager.deleteVillagerTeam(id);
				logger.debug("删除了村民小组："+id);
				monitorLogManager.saveMonitorLog("删除村民小组信息", System.currentTimeMillis()-t1_, 1);
			}else {
				villagerTeamManager.deleteVillagerTeams(ids);
				logger.debug("删除了很多村民小组："+ids.toString());
				monitorLogManager.saveMonitorLog("删除村民小组信息", System.currentTimeMillis()-t1_, StringUtils.split(ids, ",").length);
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除村民小组成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"村民小组已经被关联,请先解除关联,删除失败":"删除村民小组失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String findByCode() throws Exception {
		String orgCode = Struts2Utils.getParameter("orgCode");
		if(StringUtils.isNotEmpty(orgCode)){
			List<VillagerTeam> vtList = villagerTeamManager.searchVillagerTeam(orgCode);
			if(vtList!=null&&vtList.size()>0){
				Struts2Utils.renderJson(vtList);
			}
		}
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
		page = villagerTeamManager.searchVillagerTeam(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new VillagerTeam();
		}else{
			entity = villagerTeamManager.getVillagerTeam(id);
		}
	}
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			long t1_ = System.currentTimeMillis();
			villagerTeamManager.saveVillagerTeam(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存村民小组成功");
				result4Json.setAction(Result4Json.SAVE);
				monitorLogManager.saveMonitorLog("增加村民小组信息", System.currentTimeMillis()-t1_, 1);
			}else{
				result4Json.setMessage("修改村民小组成功");
				result4Json.setAction(Result4Json.UPDATE);
				monitorLogManager.saveMonitorLog("修改村民小组信息", System.currentTimeMillis()-t1_, 1);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存村民小组失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public VillagerTeam getModel() {
		return entity;
	}
	@Autowired
	public void setVillagerTeamManager(VillagerTeamManager villagerTeamManager) {
		this.villagerTeamManager = villagerTeamManager;
	}
	public Page<VillagerTeam> getPage() {
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
