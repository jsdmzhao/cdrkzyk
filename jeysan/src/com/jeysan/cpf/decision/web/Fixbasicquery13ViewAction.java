package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery13View;
import com.jeysan.cpf.decision.service.Fixbasicquery13ViewManager;
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
public class Fixbasicquery13ViewAction extends PrintActionSupport<Fixbasicquery13View> {
	private Fixbasicquery13ViewManager fixbasicquery13ViewManager;
	private Page<Fixbasicquery13View> page = new Page<Fixbasicquery13View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery13ViewManager.searchFixbasicquery13View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery13ViewManager(Fixbasicquery13ViewManager fixbasicquery13ViewManager) {
		this.fixbasicquery13ViewManager = fixbasicquery13ViewManager;
	}
	public Page<Fixbasicquery13View> getPage() {
		return page;
	}
	
}
