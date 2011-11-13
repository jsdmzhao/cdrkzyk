package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery10View;
import com.jeysan.cpf.decision.service.Flowbasicquery10ViewManager;
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
public class Flowbasicquery10ViewAction extends PrintActionSupport<Flowbasicquery10View> {
	private Flowbasicquery10ViewManager flowbasicquery10ViewManager;
	private Page<Flowbasicquery10View> page = new Page<Flowbasicquery10View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery10ViewManager.searchFlowbasicquery10View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery10ViewManager(Flowbasicquery10ViewManager flowbasicquery10ViewManager) {
		this.flowbasicquery10ViewManager = flowbasicquery10ViewManager;
	}
	public Page<Flowbasicquery10View> getPage() {
		return page;
	}
	
}
