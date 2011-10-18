package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery7View;
import com.jeysan.cpf.decision.service.Flowbasicquery7ViewManager;
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
public class Flowbasicquery7ViewAction extends PrintActionSupport<Flowbasicquery7View> {
	private Flowbasicquery7ViewManager flowbasicquery7ViewManager;
	private Page<Flowbasicquery7View> page = new Page<Flowbasicquery7View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery7ViewManager.searchFlowbasicquery7View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery7ViewManager(Flowbasicquery7ViewManager flowbasicquery7ViewManager) {
		this.flowbasicquery7ViewManager = flowbasicquery7ViewManager;
	}
	public Page<Flowbasicquery7View> getPage() {
		return page;
	}
	
}
