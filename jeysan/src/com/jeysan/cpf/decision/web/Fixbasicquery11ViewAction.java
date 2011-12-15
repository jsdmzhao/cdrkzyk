package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery11View;
import com.jeysan.cpf.decision.service.Fixbasicquery11ViewManager;
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
public class Fixbasicquery11ViewAction extends PrintActionSupport<Fixbasicquery11View> {
	private Fixbasicquery11ViewManager fixbasicquery11ViewManager;
	private Page<Fixbasicquery11View> page = new Page<Fixbasicquery11View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery11ViewManager.searchFixbasicquery11View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery11ViewManager(Fixbasicquery11ViewManager fixbasicquery11ViewManager) {
		this.fixbasicquery11ViewManager = fixbasicquery11ViewManager;
	}
	public Page<Fixbasicquery11View> getPage() {
		return page;
	}
	
}
