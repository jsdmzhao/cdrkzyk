package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery18View;
import com.jeysan.cpf.decision.service.Fixbasicquery18ViewManager;
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
public class Fixbasicquery18ViewAction extends PrintActionSupport<Fixbasicquery18View> {
	private Fixbasicquery18ViewManager fixbasicquery18ViewManager;
	private Page<Fixbasicquery18View> page = new Page<Fixbasicquery18View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery18ViewManager.searchFixbasicquery18View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery18ViewManager(Fixbasicquery18ViewManager fixbasicquery18ViewManager) {
		this.fixbasicquery18ViewManager = fixbasicquery18ViewManager;
	}
	public Page<Fixbasicquery18View> getPage() {
		return page;
	}
	
}
