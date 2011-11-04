package com.jeysan.cpf.bcmas.web;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.bcmas.entity.DoubleCheck;
import com.jeysan.cpf.bcmas.service.DoubleCheckManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/bcmas")
@Results( {@Result(name = "list1", location = "doublecheckstat1.jsp", type = "dispatcher"),
	@Result(name = "list2", location = "doublecheckstat2.jsp", type = "dispatcher"),
	@Result(name = "list3", location = "doublecheckstat3.jsp", type = "dispatcher"),
	@Result(name = "print1", location = "doublecheckstat1_print.jsp", type = "dispatcher"),
	@Result(name = "print2", location = "doublecheckstat2_print.jsp", type = "dispatcher"),
	@Result(name = "print3", location = "doublecheckstat3_print.jsp", type = "dispatcher")})
public class DoubleCheckStatAction extends CrudActionSupport {
	private DoubleCheckManager doubleCheckManager;
	private Page<DoubleCheck> page = new Page<DoubleCheck>(DEFAULT_PAGE_SIZE);
	
	@Autowired
	public void setDoubleCheckManager(DoubleCheckManager doubleCheckManager) {
		this.doubleCheckManager = doubleCheckManager;
	}

	public Page getPage() {
		return page;
	}

	@Override
	public String list() throws Exception {
		String type = Struts2Utils.getParameter("type");
		if(StringUtils.isNotEmpty(type)){
			String filter_EQI_year = Struts2Utils.getRequest().getParameter("filter_EQI_year");
			if(StringUtils.isNotEmpty(filter_EQI_year)){
				Struts2Utils.getRequest().setAttribute("dcs", this.doubleCheckManager.getDoubleChecksByYear(Integer.parseInt(filter_EQI_year)));
			}
			String status = Struts2Utils.getParameter("status");
			
			String filter_EQI_seq = Struts2Utils.getRequest().getParameter("filter_EQI_seq");
			String start = Struts2Utils.getParameter("start");
			String end = Struts2Utils.getParameter("end");
			
			//Map results = this.doubleCheckManager.searchDoubleCheck4Stat(status, filter_EQI_year, filter_EQI_seq, start, end);
			List results = null;
			if(StringUtils.equals(type, "1"))
				results = this.doubleCheckManager.searchDoubleCheck4Stat4AutoPrint(status, filter_EQI_year, filter_EQI_seq, start, end);
			else if(StringUtils.equals(type, "2"))
				results = this.doubleCheckManager.searchDoubleCheck4Stat2_4AutoPrint(status, filter_EQI_year, filter_EQI_seq, start, end);
			else if(StringUtils.equals(type, "3"))
				results = this.doubleCheckManager.searchDoubleCheck4Stat3_4AutoPrint(status, filter_EQI_year, filter_EQI_seq, start, end);
			
			Struts2Utils.getRequest().setAttribute("results", results);
			if(checkPrint())
				return "print"+type;
			//Struts2Utils.getRequest().setAttribute("villages",districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID));
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
