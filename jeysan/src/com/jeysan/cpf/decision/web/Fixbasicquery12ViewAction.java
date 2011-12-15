package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery12View;
import com.jeysan.cpf.decision.service.Fixbasicquery12ViewManager;
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
public class Fixbasicquery12ViewAction extends PrintActionSupport<Fixbasicquery12View> {
	private Fixbasicquery12ViewManager fixbasicquery12ViewManager;
	private Page<Fixbasicquery12View> page = new Page<Fixbasicquery12View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery12ViewManager.searchFixbasicquery12View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery12ViewManager(Fixbasicquery12ViewManager fixbasicquery12ViewManager) {
		this.fixbasicquery12ViewManager = fixbasicquery12ViewManager;
	}
	public Page<Fixbasicquery12View> getPage() {
		return page;
	}
	
}
