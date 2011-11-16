package com.jeysan.cpf.monitor.web;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.monitor.service.HPMonitorManager;
import com.jeysan.modules.action.PrintActionSupport;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/monitor")
@Results( {@Result(name = "t1", location = "t1.jsp", type = "dispatcher"),
	@Result(name = "t2", location = "t2.jsp", type = "dispatcher")})
public class HPMonitorAction extends PrintActionSupport {
	private static final long serialVersionUID = -1826212472390477005L;
	private HPMonitorManager hpMonitorManager;
	private Page page = new Page();

	public Page getPage() {
		return page;
	}
	
	@Autowired
	public void setHpMonitorManager(HPMonitorManager hpMonitorManager) {
		this.hpMonitorManager = hpMonitorManager;
	}


	@Override
	public String list() throws Exception {
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("PERSON_CODE");
			page.setOrder(Page.ASC);
		}
		String domicileType = Struts2Utils.getParameter("domicileType");
		String filter_EQS_area = Struts2Utils.getParameter("filter_EQS_area");
		page = this.hpMonitorManager.findDoubleCheckObjects(page,Integer.parseInt(domicileType),filter_EQS_area);
		return "t1";
	}
	
	public String findBirth2Applys() throws Exception {
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("PERSON_CODE");
			page.setOrder(Page.ASC);
		}
		String domicileType = Struts2Utils.getParameter("domicileType");
		String filter_EQS_area = Struts2Utils.getParameter("filter_EQS_area");
		String typeh = Struts2Utils.getParameter("typeh");
		page = this.hpMonitorManager.findBirth2Applys(page,Integer.parseInt(domicileType),StringUtils.isEmpty(typeh)?null:Integer.parseInt(typeh),filter_EQS_area);
		if(checkPrint())
			return PRINT;
		return "t2";
	}
	
	
	
	
}
