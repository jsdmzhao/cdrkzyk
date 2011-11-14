package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery15View;
import com.jeysan.cpf.decision.service.Flowbasicquery15ViewManager;
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
public class Flowbasicquery15ViewAction extends PrintActionSupport<Flowbasicquery15View> {
	private Flowbasicquery15ViewManager flowbasicquery15ViewManager;
	private Page<Flowbasicquery15View> page = new Page<Flowbasicquery15View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery15ViewManager.searchFlowbasicquery15View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery15ViewManager(Flowbasicquery15ViewManager flowbasicquery15ViewManager) {
		this.flowbasicquery15ViewManager = flowbasicquery15ViewManager;
	}
	public Page<Flowbasicquery15View> getPage() {
		return page;
	}
	
}
