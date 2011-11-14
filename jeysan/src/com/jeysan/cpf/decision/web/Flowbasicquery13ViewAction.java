package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery13View;
import com.jeysan.cpf.decision.service.Flowbasicquery13ViewManager;
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
public class Flowbasicquery13ViewAction extends PrintActionSupport<Flowbasicquery13View> {
	private Flowbasicquery13ViewManager flowbasicquery13ViewManager;
	private Page<Flowbasicquery13View> page = new Page<Flowbasicquery13View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery13ViewManager.searchFlowbasicquery13View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery13ViewManager(Flowbasicquery13ViewManager flowbasicquery13ViewManager) {
		this.flowbasicquery13ViewManager = flowbasicquery13ViewManager;
	}
	public Page<Flowbasicquery13View> getPage() {
		return page;
	}
	
}
