package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Flowbasicquery4View;
import com.jeysan.cpf.decision.service.Flowbasicquery4ViewManager;
import com.jeysan.cpf.util.Constants;
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
public class Flowbasicquery4ViewAction extends PrintActionSupport<Flowbasicquery4View> {
	private Flowbasicquery4ViewManager flowbasicquery4ViewManager;
	private Page<Flowbasicquery4View> page = new Page<Flowbasicquery4View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		String marray_childnum = StringUtils.trim(Struts2Utils.getParameter("marray_childnum"));
		if(StringUtils.equals(marray_childnum, "1")){
			filters.add(new PropertyFilter("NEQI_marryStatus",Constants.MARRY_STATUS.NO.toString()));
			filters.add(new PropertyFilter("EQL_childnum","0"));
		}else if(StringUtils.equals(marray_childnum, "2")){
			filters.add(new PropertyFilter("EQI_isAgree",Constants.IS_AGREE.AGREE.toString()));
		}
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = flowbasicquery4ViewManager.searchFlowbasicquery4View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFlowbasicquery4ViewManager(Flowbasicquery4ViewManager flowbasicquery4ViewManager) {
		this.flowbasicquery4ViewManager = flowbasicquery4ViewManager;
	}
	public Page<Flowbasicquery4View> getPage() {
		return page;
	}
	
}
