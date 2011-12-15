package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery5View;
import com.jeysan.cpf.decision.service.Fixbasicquery5ViewManager;
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
@Result(name = "success", location = "fixbasicquery4view.jsp", type = "dispatcher")
public class Fixbasicquery5ViewAction extends PrintActionSupport<Fixbasicquery5View> {
	private Fixbasicquery5ViewManager fixbasicquery5ViewManager;
	private Page<Fixbasicquery5View> page = new Page<Fixbasicquery5View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery5ViewManager.searchFixbasicquery5View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery5ViewManager(Fixbasicquery5ViewManager fixbasicquery5ViewManager) {
		this.fixbasicquery5ViewManager = fixbasicquery5ViewManager;
	}
	public Page<Fixbasicquery5View> getPage() {
		return page;
	}
	
}
