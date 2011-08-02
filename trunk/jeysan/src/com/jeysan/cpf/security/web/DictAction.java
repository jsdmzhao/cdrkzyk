package com.jeysan.cpf.security.web;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.jeysan.cpf.security.entity.Dict;
import com.jeysan.cpf.security.entity.DictSub;
import com.jeysan.cpf.security.service.DictManager;
import com.jeysan.cpf.security.service.DictSubManager;
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
@Namespace("/security")
@Results( { @Result(name = "dictsub-input", location = "dictsub-input.jsp", type = "dispatcher")})
public class DictAction extends CrudActionSupport<Dict> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private Dict entity;
	private DictManager dictManager;
	private DictSubManager dictSubManager;
	private Page<Dict> page = new Page<Dict>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		try {
			if(id!=null){
				dictManager.deleteDict(id);
				logger.debug("删除了字典："+id);
			}else {
				dictManager.deleteDicts(ids);
				logger.debug("删除了很多字典："+ids.toString());
			}
			//addActionMessage("删除字典成功");
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除字典成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			//addActionMessage("删除字典失败");
			result4Json.setStatusCode("300");
			result4Json.setMessage("删除字典失败");
			//throw new ServiceException(e);
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String preAddSubs() throws Exception{
		prepareModel();
		return "dictsub-input";
	}
	public String saveSubs() throws Exception{
		boolean flag = false;
		try {
			String[] subIds = Struts2Utils.getParameterValues("subId");
			Integer subId = null;
			if(subIds!=null&&subIds.length>0){
				List<DictSub> subList = Lists.newArrayList();
				entity = dictManager.getDict(id);
				//entity.getDictSubList().clear();
				//dictManager.saveDict(entity);
				DictSub sub = null;
				String subIndex_ = null;
				for(int i=0;i<subIds.length;i++){
					subId = Integer.parseInt(subIds[i]);
					if(subId==-1){
						sub = new DictSub();
						sub.setDict(entity);
					}else{
						sub = dictSubManager.getDictSub(subId);
					}
					sub.setSubColor(Struts2Utils.getParameter("subColor_"+(i+1)));
					sub.setSubName(Struts2Utils.getParameter("subName_"+(i+1)));
					sub.setSubCode(Struts2Utils.getParameter("subCode_"+(i+1)));
					subIndex_ = Struts2Utils.getParameter("subIndex_"+(i+1));
					if(StringUtils.isNotEmpty(subIndex_))
						sub.setSubIndex(Integer.parseInt(subIndex_));
					sub.setSubInfo(Struts2Utils.getParameter("subInfo_"+(i+1)));
					//entity.getDictSubList().add(sub);
					subList.add(sub);
				}
				//dictManager.saveDict(entity);
				dictSubManager.saveDictSubs(subList,entity.getDictSubList());
				flag = true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if(result4Json == null)
			result4Json = new Result4Json();
		result4Json.setStatusCode(flag?"200":"300");
		result4Json.setMessage(flag?"保存字典子项成功":"保存字典子项失败");
		result4Json.setAction(Result4Json.SAVE);
		Struts2Utils.renderJson(result4Json);
		return "none";
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
		//logger.debug("pageNo:"+Struts2Utils.getRequest().getParameter("pageNo"));
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = dictManager.searchDict(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new Dict();
		}else{
			entity = dictManager.getDict(id);
		}
	}
	@Override
	public String save() throws Exception {
		try{
			String parentId = Struts2Utils.getParameter("parentId");
			if(StringUtils.isNotEmpty(parentId)){
				Dict parent = new Dict();
				parent.setId(Integer.parseInt(parentId));
				entity.setParent(parent);
			}
			if(entity.getCanModified()==null)
				entity.setCanModified(0);
			dictManager.saveDict(entity);
			//addActionMessage("保存字典成功");
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存字典成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改字典成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				/*entity = new Dict();
				DataBeanUtil.copyProperty(entity, Struts2Utils.getRequest());
				entity.setId(null);
				save();*/
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存字典失败");
				//throw new ServiceException(e);
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public Dict getModel() {
		return entity;
	}
	@Autowired
	public void setDictManager(DictManager dictManager) {
		this.dictManager = dictManager;
	}
	@Autowired
	public void setDictSubManager(DictSubManager dictSubManager) {
		this.dictSubManager = dictSubManager;
	}
	public Page<Dict> getPage() {
		return page;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}
	public Dict getEntity() {
		return entity;
	}
	public void setEntity(Dict entity) {
		this.entity = entity;
	}
	
	
}
