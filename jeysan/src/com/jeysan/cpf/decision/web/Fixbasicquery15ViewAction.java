package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery15View;
import com.jeysan.cpf.decision.service.Fixbasicquery15ViewManager;
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
public class Fixbasicquery15ViewAction extends PrintActionSupport<Fixbasicquery15View> {
	private Fixbasicquery15ViewManager fixbasicquery15ViewManager;
	private Page<Fixbasicquery15View> page = new Page<Fixbasicquery15View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery15ViewManager.searchFixbasicquery15View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery15ViewManager(Fixbasicquery15ViewManager fixbasicquery15ViewManager) {
		this.fixbasicquery15ViewManager = fixbasicquery15ViewManager;
	}
	public Page<Fixbasicquery15View> getPage() {
		return page;
	}
	
}
