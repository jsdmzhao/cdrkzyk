package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery19View;
import com.jeysan.cpf.decision.service.Fixbasicquery19ViewManager;
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
public class Fixbasicquery19ViewAction extends PrintActionSupport<Fixbasicquery19View> {
	private Fixbasicquery19ViewManager fixbasicquery19ViewManager;
	private Page<Fixbasicquery19View> page = new Page<Fixbasicquery19View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery19ViewManager.searchFixbasicquery19View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery19ViewManager(Fixbasicquery19ViewManager fixbasicquery19ViewManager) {
		this.fixbasicquery19ViewManager = fixbasicquery19ViewManager;
	}
	public Page<Fixbasicquery19View> getPage() {
		return page;
	}
	
}
