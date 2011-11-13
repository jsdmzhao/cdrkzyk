package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery9View;
import com.jeysan.cpf.decision.service.Flowbasicquery9ViewManager;
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
public class Flowbasicquery9ViewAction extends PrintActionSupport<Flowbasicquery9View> {
	private Flowbasicquery9ViewManager flowbasicquery9ViewManager;
	private Page<Flowbasicquery9View> page = new Page<Flowbasicquery9View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery9ViewManager.searchFlowbasicquery9View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery9ViewManager(Flowbasicquery9ViewManager flowbasicquery9ViewManager) {
		this.flowbasicquery9ViewManager = flowbasicquery9ViewManager;
	}
	public Page<Flowbasicquery9View> getPage() {
		return page;
	}
	
}
