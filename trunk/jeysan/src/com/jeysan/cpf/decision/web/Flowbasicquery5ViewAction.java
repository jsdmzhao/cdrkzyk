package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery5View;
import com.jeysan.cpf.decision.service.Flowbasicquery5ViewManager;
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
public class Flowbasicquery5ViewAction extends PrintActionSupport<Flowbasicquery5View> {
	private Flowbasicquery5ViewManager flowbasicquery5ViewManager;
	private Page<Flowbasicquery5View> page = new Page<Flowbasicquery5View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery5ViewManager.searchFlowbasicquery5View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery5ViewManager(Flowbasicquery5ViewManager flowbasicquery5ViewManager) {
		this.flowbasicquery5ViewManager = flowbasicquery5ViewManager;
	}
	public Page<Flowbasicquery5View> getPage() {
		return page;
	}
	
}
