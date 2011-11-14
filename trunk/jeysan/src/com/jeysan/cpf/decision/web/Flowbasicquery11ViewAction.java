package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery11View;
import com.jeysan.cpf.decision.service.Flowbasicquery11ViewManager;
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
public class Flowbasicquery11ViewAction extends PrintActionSupport<Flowbasicquery11View> {
	private Flowbasicquery11ViewManager flowbasicquery11ViewManager;
	private Page<Flowbasicquery11View> page = new Page<Flowbasicquery11View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery11ViewManager.searchFlowbasicquery11View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery11ViewManager(Flowbasicquery11ViewManager flowbasicquery11ViewManager) {
		this.flowbasicquery11ViewManager = flowbasicquery11ViewManager;
	}
	public Page<Flowbasicquery11View> getPage() {
		return page;
	}
	
}
