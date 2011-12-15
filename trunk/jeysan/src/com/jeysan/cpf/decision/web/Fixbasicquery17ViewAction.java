package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery17View;
import com.jeysan.cpf.decision.service.Fixbasicquery17ViewManager;
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
public class Fixbasicquery17ViewAction extends PrintActionSupport<Fixbasicquery17View> {
	private Fixbasicquery17ViewManager fixbasicquery17ViewManager;
	private Page<Fixbasicquery17View> page = new Page<Fixbasicquery17View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery17ViewManager.searchFixbasicquery17View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery17ViewManager(Fixbasicquery17ViewManager fixbasicquery17ViewManager) {
		this.fixbasicquery17ViewManager = fixbasicquery17ViewManager;
	}
	public Page<Fixbasicquery17View> getPage() {
		return page;
	}
	
}
