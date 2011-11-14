package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery12View;
import com.jeysan.cpf.decision.service.Flowbasicquery12ViewManager;
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
public class Flowbasicquery12ViewAction extends PrintActionSupport<Flowbasicquery12View> {
	private Flowbasicquery12ViewManager flowbasicquery12ViewManager;
	private Page<Flowbasicquery12View> page = new Page<Flowbasicquery12View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery12ViewManager.searchFlowbasicquery12View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery12ViewManager(Flowbasicquery12ViewManager flowbasicquery12ViewManager) {
		this.flowbasicquery12ViewManager = flowbasicquery12ViewManager;
	}
	public Page<Flowbasicquery12View> getPage() {
		return page;
	}
	
}
