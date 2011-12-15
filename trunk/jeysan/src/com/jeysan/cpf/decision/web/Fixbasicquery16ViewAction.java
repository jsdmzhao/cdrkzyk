package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery16View;
import com.jeysan.cpf.decision.service.Fixbasicquery16ViewManager;
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
public class Fixbasicquery16ViewAction extends PrintActionSupport<Fixbasicquery16View> {
	private Fixbasicquery16ViewManager fixbasicquery16ViewManager;
	private Page<Fixbasicquery16View> page = new Page<Fixbasicquery16View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery16ViewManager.searchFixbasicquery16View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery16ViewManager(Fixbasicquery16ViewManager fixbasicquery16ViewManager) {
		this.fixbasicquery16ViewManager = fixbasicquery16ViewManager;
	}
	public Page<Fixbasicquery16View> getPage() {
		return page;
	}
	
}
