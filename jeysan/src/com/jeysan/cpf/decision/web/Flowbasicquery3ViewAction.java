package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery3View;
import com.jeysan.cpf.decision.service.Flowbasicquery3ViewManager;
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
public class Flowbasicquery3ViewAction extends PrintActionSupport<Flowbasicquery3View> {
	private Flowbasicquery3ViewManager flowbasicquery3ViewManager;
	private Page<Flowbasicquery3View> page = new Page<Flowbasicquery3View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		boolean flag = false;
		for(PropertyFilter filter : filters){
			if(StringUtils.equals(filter.getPropertyName(),"childIndex")){
				if(StringUtils.equals(filter.getMatchValue().toString(), "99")){
					flag = true;
					filters.remove(filter);
					break;
				}
			}
		}
		if(flag)
			filters.add(new PropertyFilter("GEI_childIndex","3"));
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery3ViewManager.searchFlowbasicquery3View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery3ViewManager(Flowbasicquery3ViewManager flowbasicquery3ViewManager) {
		this.flowbasicquery3ViewManager = flowbasicquery3ViewManager;
	}
	public Page<Flowbasicquery3View> getPage() {
		return page;
	}
	
}
