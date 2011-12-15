package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery8View;
import com.jeysan.cpf.decision.service.Fixbasicquery8ViewManager;
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
public class Fixbasicquery8ViewAction extends PrintActionSupport<Fixbasicquery8View> {
	private Fixbasicquery8ViewManager fixbasicquery8ViewManager;
	private Page<Fixbasicquery8View> page = new Page<Fixbasicquery8View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery8ViewManager.searchFixbasicquery8View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery8ViewManager(Fixbasicquery8ViewManager fixbasicquery8ViewManager) {
		this.fixbasicquery8ViewManager = fixbasicquery8ViewManager;
	}
	public Page<Fixbasicquery8View> getPage() {
		return page;
	}
	
}
