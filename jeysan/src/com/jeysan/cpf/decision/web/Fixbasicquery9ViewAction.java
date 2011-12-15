package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery9View;
import com.jeysan.cpf.decision.service.Fixbasicquery9ViewManager;
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
public class Fixbasicquery9ViewAction extends PrintActionSupport<Fixbasicquery9View> {
	private Fixbasicquery9ViewManager fixbasicquery9ViewManager;
	private Page<Fixbasicquery9View> page = new Page<Fixbasicquery9View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery9ViewManager.searchFixbasicquery9View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery9ViewManager(Fixbasicquery9ViewManager fixbasicquery9ViewManager) {
		this.fixbasicquery9ViewManager = fixbasicquery9ViewManager;
	}
	public Page<Fixbasicquery9View> getPage() {
		return page;
	}
	
}
