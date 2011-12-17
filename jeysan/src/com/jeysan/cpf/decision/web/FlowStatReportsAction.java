package com.jeysan.cpf.decision.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.bcmas.entity.DoubleCheck;
import com.jeysan.cpf.decision.service.FlowStatReportsManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/decision")
@Results( {@Result(name = "list1", location = "flowstat1reports.jsp", type = "dispatcher"),
	@Result(name = "list2", location = "flowstat2reports.jsp", type = "dispatcher"),
	@Result(name = "list3", location = "flowstat3reports.jsp", type = "dispatcher"),
	@Result(name = "list4", location = "flowstat4reports.jsp", type = "dispatcher"),
	@Result(name = "list5", location = "flowstat5reports.jsp", type = "dispatcher"),
	@Result(name = "print1", location = "flowstat1reports_print.jsp", type = "dispatcher"),
	@Result(name = "print2", location = "flowstat2reports_print.jsp", type = "dispatcher"),
	@Result(name = "print3", location = "flowstat3reports_print.jsp", type = "dispatcher"),
	@Result(name = "print4", location = "flowstat4reports_print.jsp", type = "dispatcher"),
	@Result(name = "print5", location = "flowstat5reports_print.jsp", type = "dispatcher")})
public class FlowStatReportsAction extends CrudActionSupport {
	private FlowStatReportsManager flowStatReportsManager;
	private Page<DoubleCheck> page = new Page<DoubleCheck>(DEFAULT_PAGE_SIZE);
	
	@Autowired
	public void setFlowStatReportsManager(FlowStatReportsManager flowStatReportsManager) {
		this.flowStatReportsManager = flowStatReportsManager;
	}

	public Page getPage() {
		return page;
	}

	@Override
	public String list() throws Exception {
		String type = Struts2Utils.getParameter("type");
		if(StringUtils.isNotEmpty(type)){
			String filter_GED_startDate = Struts2Utils.getRequest().getParameter("filter_GED_startDate");
			String filter_LED_endDate = Struts2Utils.getRequest().getParameter("filter_LED_endDate");
			String filter_EQS_area = Struts2Utils.getRequest().getParameter("filter_EQS_area");
			if(StringUtils.isNotEmpty(filter_GED_startDate) && StringUtils.isNotEmpty(filter_LED_endDate)){
				String filter_EQI_domicileType =  Struts2Utils.getRequest().getParameter("filter_EQI_domicileType");
				Date start = DateUtil.createUtilDate(filter_GED_startDate+"-01");
				Date end = DateUtil.createUtilDate(filter_LED_endDate+"-31");
				Integer domicileType = Integer.parseInt(filter_EQI_domicileType);
				DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
				//设置默认排序方式
				if (!page.isOrderBySetted()) {
					page.setOrderBy("AREA");
					page.setOrder(Page.ASC);
				}
				List results = null;
				if(StringUtils.equals(type, "1"))
					results = this.flowStatReportsManager.findStat1Reports_4AutoPrint(page, start, end, filter_EQS_area,domicileType);
				else if(StringUtils.equals(type, "2"))
					results = this.flowStatReportsManager.findStat2Reports_4AutoPrint(page, start, end, filter_EQS_area,domicileType);
				else if(StringUtils.equals(type, "3"))
					results = this.flowStatReportsManager.findStat3Reports_4AutoPrint(page, start, end, filter_EQS_area,domicileType);
				else if(StringUtils.equals(type, "4"))
					results = this.flowStatReportsManager.findStat4Reports_4AutoPrint(page, start, end, filter_EQS_area,domicileType);
				else if(StringUtils.equals(type, "5"))
					results = this.flowStatReportsManager.findStat5Reports(page, start, end, filter_EQS_area,domicileType);
				Struts2Utils.getRequest().setAttribute("results", results);
			}
			if(checkPrint())
				return "print"+type;
			return "list"+type;
		}
		return SUCCESS;
	}
	
	private boolean checkPrint() throws Exception{
		String print = Struts2Utils.getParameter("print");
		if(StringUtils.equals("print", print)){
			String rule = Struts2Utils.getParameter("rule");
			List<Map> lst = Struts2Utils.formJson(rule, List.class);
			Struts2Utils.getRequest().setAttribute("heads", lst);
			return true;
		}
		return false;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String input() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String view() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
