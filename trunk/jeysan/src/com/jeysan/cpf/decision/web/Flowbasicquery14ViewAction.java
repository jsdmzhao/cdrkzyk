package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery14View;
import com.jeysan.cpf.decision.service.Flowbasicquery14ViewManager;
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
public class Flowbasicquery14ViewAction extends PrintActionSupport<Flowbasicquery14View> {
	private Flowbasicquery14ViewManager flowbasicquery14ViewManager;
	private Page<Flowbasicquery14View> page = new Page<Flowbasicquery14View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery14ViewManager.searchFlowbasicquery14View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery14ViewManager(Flowbasicquery14ViewManager flowbasicquery14ViewManager) {
		this.flowbasicquery14ViewManager = flowbasicquery14ViewManager;
	}
	public Page<Flowbasicquery14View> getPage() {
		return page;
	}
	
}
