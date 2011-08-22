package com.jeysan.cpf.bcmas.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.google.common.collect.Lists;
import com.jeysan.cpf.bcmas.entity.WomanSocialUpbring;
import com.jeysan.cpf.bcmas.entity.WomanUpbringDetail;
import com.jeysan.cpf.bcmas.service.WomanSocialUpbringManager;
import com.jeysan.cpf.bcmas.service.WomanUpbringDetailManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.math.DoubleUtil;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/bcmas")
public class WomanUpbringDetailAction extends CrudActionSupport<WomanUpbringDetail> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private WomanUpbringDetail entity;
	private WomanUpbringDetailManager womanUpbringDetailManager;
	private WomanSocialUpbringManager womanSocialUpbringManager;
	private Page<WomanUpbringDetail> page = new Page<WomanUpbringDetail>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try {
			if(id!=null){
				womanUpbringDetailManager.deleteWomanUpbringDetail(id);
				logger.debug("删除了社会抚养费缴交："+id);
			}else {
				womanUpbringDetailManager.deleteWomanUpbringDetails(ids);
				logger.debug("删除了很多社会抚养费缴交："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除社会抚养费缴交成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage(e instanceof DataIntegrityViolationException?"社会抚养费缴交已经被关联,请先解除关联,删除失败":"删除社会抚养费缴交失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public String input() throws Exception {
		String upbringId = Struts2Utils.getParameter("upbringId");
		if(StringUtils.isNotEmpty(upbringId))
			Struts2Utils.getRequest().setAttribute("upbring", womanSocialUpbringManager.getWomanSocialUpbring(Long.parseLong(upbringId)));
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
		page = womanUpbringDetailManager.searchWomanUpbringDetail(page, filters);
		return SUCCESS;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new WomanUpbringDetail();
		}else{
			entity = womanUpbringDetailManager.getWomanUpbringDetail(id);
		}
	}
	/**
	 * 未分期时
	 */
	@Override
	public String save() throws Exception {
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			String upbringId = Struts2Utils.getParameter("upbringId");
			WomanSocialUpbring upbring =  womanSocialUpbringManager.getWomanSocialUpbring(Long.parseLong(upbringId));
			entity.setUpbring(upbring);
			womanUpbringDetailManager.saveWomanUpbringDetail(entity);
			result4Json.setStatusCode("200");
			
			if(id == null){
				upbring.setYetMoney(DoubleUtil.add(upbring.getYetMoney(),entity.getFactMoney()));
			}else{
				String factMoneyOld = Struts2Utils.getParameter("factMoneyOld");
				if(StringUtils.isNotEmpty(factMoneyOld))
					upbring.setYetMoney(DoubleUtil.sub(DoubleUtil.add(upbring.getYetMoney(),entity.getFactMoney()),Double.parseDouble(factMoneyOld)));
			}
			if(upbring.getYetMoney() == upbring.getTotalMoney())
				upbring.setIsPayup(1);
			else
				upbring.setIsPayup(0);
			
			womanSocialUpbringManager.saveWomanSocialUpbring(upbring);
			
			if(id == null){
				result4Json.setMessage("保存社会抚养费缴交成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改社会抚养费缴交成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存社会抚养费缴交失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	/**
	 * 分期时
	 * @return
	 * @throws Exception
	 */
	public String saveDetails() throws Exception{
		boolean flag = false;
		boolean isPayup = false;
		try {
			String[] detailIds = Struts2Utils.getParameterValues("detailId");
			Long detailId = null;
			if(detailIds!=null&&detailIds.length>0){
				List<WomanUpbringDetail> detailList = Lists.newArrayList();
				WomanSocialUpbring upbring = womanSocialUpbringManager.getWomanSocialUpbring(Long.parseLong(Struts2Utils.getParameter("upbringId")));
				if(upbring.getIsPayup() == 0){
					WomanUpbringDetail detail = null;
					String tmp = null;
					Double factMoneyTotal = 0d;
					for(int i=0;i<detailIds.length;i++){
						detailId = Long.parseLong(detailIds[i]);
						if(detailId==-1){
							detail = new WomanUpbringDetail();
							detail.setUpbring(upbring);
						}else{
							detail = womanUpbringDetailManager.getWomanUpbringDetail(detailId);
						}
						detail.setCounth(i+1);
						tmp = Struts2Utils.getParameter("moneyh_"+(i+1));
						if(StringUtils.isNotEmpty(tmp))
							detail.setMoneyh(Double.parseDouble(tmp));
						tmp = Struts2Utils.getParameter("factMoney_"+(i+1));
						if(StringUtils.isNotEmpty(tmp)){
							detail.setFactMoney(Double.parseDouble(tmp));
							factMoneyTotal += detail.getFactMoney();
						}
						tmp = Struts2Utils.getParameter("dateh_"+(i+1));
						if(StringUtils.isNotEmpty(tmp))
							detail.setDateh(DateUtil.createUtilDate(tmp));
						detail.setCharger(Struts2Utils.getParameter("charger_"+(i+1)));
						detail.setVoucherCode(Struts2Utils.getParameter("voucherCode_"+(i+1)));
						detailList.add(detail);
					}
					womanUpbringDetailManager.saveWomanUpbringDetail(detailList,upbring.getDetailList());
					//更新主表
					upbring.setYetMoney(factMoneyTotal);
					if(upbring.getYetMoney().doubleValue() == upbring.getTotalMoney().doubleValue())
						upbring.setIsPayup(1);
					else
						upbring.setIsPayup(0);
					womanSocialUpbringManager.saveWomanSocialUpbring(upbring);
					
					flag = true;
				}else if(upbring.getIsPayup() == 1){
					isPayup = true;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if(result4Json == null)
			result4Json = new Result4Json();
		result4Json.setStatusCode(flag?"200":"300");
		result4Json.setMessage(flag?"保存社会抚养费缴交成功":(isPayup?"费用已经缴清，不用再保存":"保存社会抚养费缴交失败"));
		result4Json.setAction(Result4Json.SAVE);
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public WomanUpbringDetail getModel() {
		return entity;
	}
	@Autowired
	public void setWomanUpbringDetailManager(WomanUpbringDetailManager womanUpbringDetailManager) {
		this.womanUpbringDetailManager = womanUpbringDetailManager;
	}
	@Autowired
	public void setWomanSocialUpbringManager(WomanSocialUpbringManager womanSocialUpbringManager) {
		this.womanSocialUpbringManager = womanSocialUpbringManager;
	}
	public Page<WomanUpbringDetail> getPage() {
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
