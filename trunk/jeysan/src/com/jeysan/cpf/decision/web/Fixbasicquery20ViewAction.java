package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery20View;
import com.jeysan.cpf.decision.service.Fixbasicquery20ViewManager;
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
public class Fixbasicquery20ViewAction extends PrintActionSupport<Fixbasicquery20View> {
	private Fixbasicquery20ViewManager fixbasicquery20ViewManager;
	private Page<Fixbasicquery20View> page = new Page<Fixbasicquery20View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery20ViewManager.searchFixbasicquery20View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery20ViewManager(Fixbasicquery20ViewManager fixbasicquery20ViewManager) {
		this.fixbasicquery20ViewManager = fixbasicquery20ViewManager;
	}
	public Page<Fixbasicquery20View> getPage() {
		return page;
	}
	
}
