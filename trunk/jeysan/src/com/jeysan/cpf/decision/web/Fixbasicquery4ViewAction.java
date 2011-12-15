package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery4View;
import com.jeysan.cpf.decision.service.Fixbasicquery4ViewManager;
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
public class Fixbasicquery4ViewAction extends PrintActionSupport<Fixbasicquery4View> {
	private Fixbasicquery4ViewManager fixbasicquery4ViewManager;
	private Page<Fixbasicquery4View> page = new Page<Fixbasicquery4View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery4ViewManager.searchFixbasicquery4View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery4ViewManager(Fixbasicquery4ViewManager fixbasicquery4ViewManager) {
		this.fixbasicquery4ViewManager = fixbasicquery4ViewManager;
	}
	public Page<Fixbasicquery4View> getPage() {
		return page;
	}
	
}
