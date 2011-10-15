package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery2View;
import com.jeysan.cpf.decision.service.Flowbasicquery2ViewManager;
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
public class Flowbasicquery2ViewAction extends PrintActionSupport<Flowbasicquery2View> {
	private Flowbasicquery2ViewManager flowbasicquery2ViewManager;
	private Page<Flowbasicquery2View> page = new Page<Flowbasicquery2View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery2ViewManager.searchFlowbasicquery2View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery2ViewManager(Flowbasicquery2ViewManager flowbasicquery2ViewManager) {
		this.flowbasicquery2ViewManager = flowbasicquery2ViewManager;
	}
	public Page<Flowbasicquery2View> getPage() {
		return page;
	}
	
}
