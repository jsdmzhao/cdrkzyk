package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery7View;
import com.jeysan.cpf.decision.service.Fixbasicquery7ViewManager;
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
public class Fixbasicquery7ViewAction extends PrintActionSupport<Fixbasicquery7View> {
	private Fixbasicquery7ViewManager fixbasicquery7ViewManager;
	private Page<Fixbasicquery7View> page = new Page<Fixbasicquery7View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery7ViewManager.searchFixbasicquery7View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery7ViewManager(Fixbasicquery7ViewManager fixbasicquery7ViewManager) {
		this.fixbasicquery7ViewManager = fixbasicquery7ViewManager;
	}
	public Page<Fixbasicquery7View> getPage() {
		return page;
	}
	
}
