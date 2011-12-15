package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery14View;
import com.jeysan.cpf.decision.service.Fixbasicquery14ViewManager;
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
public class Fixbasicquery14ViewAction extends PrintActionSupport<Fixbasicquery14View> {
	private Fixbasicquery14ViewManager fixbasicquery14ViewManager;
	private Page<Fixbasicquery14View> page = new Page<Fixbasicquery14View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery14ViewManager.searchFixbasicquery14View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery14ViewManager(Fixbasicquery14ViewManager fixbasicquery14ViewManager) {
		this.fixbasicquery14ViewManager = fixbasicquery14ViewManager;
	}
	public Page<Fixbasicquery14View> getPage() {
		return page;
	}
	
}
