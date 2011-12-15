package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery3View;
import com.jeysan.cpf.decision.service.Fixbasicquery3ViewManager;
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
@Result(name = "success", location = "fixbasicquery2view.jsp", type = "dispatcher")
public class Fixbasicquery3ViewAction extends PrintActionSupport<Fixbasicquery3View> {
	private Fixbasicquery3ViewManager fixbasicquery3ViewManager;
	private Page<Fixbasicquery3View> page = new Page<Fixbasicquery3View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery3ViewManager.searchFixbasicquery3View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery3ViewManager(Fixbasicquery3ViewManager fixbasicquery3ViewManager) {
		this.fixbasicquery3ViewManager = fixbasicquery3ViewManager;
	}
	public Page<Fixbasicquery3View> getPage() {
		return page;
	}
	
}
