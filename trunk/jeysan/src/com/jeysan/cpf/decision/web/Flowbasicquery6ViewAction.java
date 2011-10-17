package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery6View;
import com.jeysan.cpf.decision.service.Flowbasicquery6ViewManager;
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
public class Flowbasicquery6ViewAction extends PrintActionSupport<Flowbasicquery6View> {
	private Flowbasicquery6ViewManager flowbasicquery6ViewManager;
	private Page<Flowbasicquery6View> page = new Page<Flowbasicquery6View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery6ViewManager.searchFlowbasicquery6View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery6ViewManager(Flowbasicquery6ViewManager flowbasicquery6ViewManager) {
		this.flowbasicquery6ViewManager = flowbasicquery6ViewManager;
	}
	public Page<Flowbasicquery6View> getPage() {
		return page;
	}
	
}
