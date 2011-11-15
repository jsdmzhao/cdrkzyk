package com.jeysan.cpf.decision.web;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.service.Flowbasicquery13ViewManager;
import com.jeysan.cpf.security.service.DictManager;
import com.jeysan.modules.action.PrintActionSupport;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/decision")
public class Flowbasicquery13ViewAction extends PrintActionSupport {
	private Flowbasicquery13ViewManager flowbasicquery13ViewManager;
	private DictManager dictManager;
	
	@Override
	public String list() throws Exception {
		String areaLevel = Struts2Utils.getParameter("areaLevel");
		String filter_GED_dateh = Struts2Utils.getParameter("filter_GED_dateh");
		String filter_LED_dateh = Struts2Utils.getParameter("filter_LED_dateh");
		String filter_EQI_domicileType = Struts2Utils.getParameter("filter_EQI_domicileType");
		Integer areaLevelI = null;
		if(StringUtils.isNotEmpty(areaLevel))
			areaLevelI = Integer.parseInt(areaLevel);
		Date start = null,end = null;
		if(StringUtils.isNotEmpty(filter_GED_dateh)){
			start = DateUtil.createUtilDate(filter_GED_dateh + " 00:00:00");
		}
		if(StringUtils.isNotEmpty(filter_LED_dateh)){
			end = DateUtil.createUtilDate(filter_LED_dateh + " 23:59:59");
		}
		List result = flowbasicquery13ViewManager.searchFlowbasicquery13View4AutoPrint(Integer.parseInt(filter_EQI_domicileType), areaLevelI, start, end);
		Struts2Utils.getRequest().setAttribute("dict1", dictManager.getDict("JS1046"));
		Struts2Utils.getRequest().setAttribute("dict2", dictManager.getDict("JS1047"));
		Page page = new Page();
		page.setResult(result);
		Struts2Utils.getRequest().setAttribute("page", page);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery13ViewManager(Flowbasicquery13ViewManager flowbasicquery13ViewManager) {
		this.flowbasicquery13ViewManager = flowbasicquery13ViewManager;
	}
	@Autowired
	public void setDictManager(DictManager dictManager) {
		this.dictManager = dictManager;
	}

}
