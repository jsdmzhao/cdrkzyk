package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery6View;
import com.jeysan.cpf.decision.service.Fixbasicquery6ViewManager;
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
public class Fixbasicquery6ViewAction extends PrintActionSupport<Fixbasicquery6View> {
	private Fixbasicquery6ViewManager fixbasicquery6ViewManager;
	private Page<Fixbasicquery6View> page = new Page<Fixbasicquery6View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery6ViewManager.searchFixbasicquery6View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery6ViewManager(Fixbasicquery6ViewManager fixbasicquery6ViewManager) {
		this.fixbasicquery6ViewManager = fixbasicquery6ViewManager;
	}
	public Page<Fixbasicquery6View> getPage() {
		return page;
	}
	
}
