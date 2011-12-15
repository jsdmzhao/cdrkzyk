package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery10View;
import com.jeysan.cpf.decision.service.Fixbasicquery10ViewManager;
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
public class Fixbasicquery10ViewAction extends PrintActionSupport<Fixbasicquery10View> {
	private Fixbasicquery10ViewManager fixbasicquery10ViewManager;
	private Page<Fixbasicquery10View> page = new Page<Fixbasicquery10View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery10ViewManager.searchFixbasicquery10View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery10ViewManager(Fixbasicquery10ViewManager fixbasicquery10ViewManager) {
		this.fixbasicquery10ViewManager = fixbasicquery10ViewManager;
	}
	public Page<Fixbasicquery10View> getPage() {
		return page;
	}
	
}
