package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery2View;
import com.jeysan.cpf.decision.service.Fixbasicquery2ViewManager;
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
public class Fixbasicquery2ViewAction extends PrintActionSupport<Fixbasicquery2View> {
	private Fixbasicquery2ViewManager fixbasicquery2ViewManager;
	private Page<Fixbasicquery2View> page = new Page<Fixbasicquery2View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery2ViewManager.searchFixbasicquery2View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery2ViewManager(Fixbasicquery2ViewManager fixbasicquery2ViewManager) {
		this.fixbasicquery2ViewManager = fixbasicquery2ViewManager;
	}
	public Page<Fixbasicquery2View> getPage() {
		return page;
	}
	
}
