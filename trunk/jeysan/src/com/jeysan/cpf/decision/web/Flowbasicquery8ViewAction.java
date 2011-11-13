package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery8View;
import com.jeysan.cpf.decision.service.Flowbasicquery8ViewManager;
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
public class Flowbasicquery8ViewAction extends PrintActionSupport<Flowbasicquery8View> {
	private Flowbasicquery8ViewManager flowbasicquery8ViewManager;
	private Page<Flowbasicquery8View> page = new Page<Flowbasicquery8View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery8ViewManager.searchFlowbasicquery8View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery8ViewManager(Flowbasicquery8ViewManager flowbasicquery8ViewManager) {
		this.flowbasicquery8ViewManager = flowbasicquery8ViewManager;
	}
	public Page<Flowbasicquery8View> getPage() {
		return page;
	}
	
}
