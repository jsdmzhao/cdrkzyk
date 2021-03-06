﻿package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery1View;
import com.jeysan.cpf.decision.service.Flowbasicquery1ViewManager;
import com.jeysan.modules.action.PrintActionSupport;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/decision")
public class Flowbasicquery1ViewAction extends PrintActionSupport<Flowbasicquery1View> {
	private Flowbasicquery1ViewManager flowbasicquery1ViewManager;
	private Page<Flowbasicquery1View> page = new Page<Flowbasicquery1View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery1ViewManager.searchFlowbasicquery1View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery1ViewManager(Flowbasicquery1ViewManager flowbasicquery1ViewManager) {
		this.flowbasicquery1ViewManager = flowbasicquery1ViewManager;
	}
	public Page<Flowbasicquery1View> getPage() {
		return page;
	}
	
}
