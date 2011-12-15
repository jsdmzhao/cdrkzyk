package com.jeysan.cpf.decision.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.decision.entity.Fixbasicquery1View;
import com.jeysan.cpf.decision.service.Fixbasicquery1ViewManager;
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
public class Fixbasicquery1ViewAction extends PrintActionSupport<Fixbasicquery1View> {
	private Fixbasicquery1ViewManager fixbasicquery1ViewManager;
	private String repeat;
	private Page<Fixbasicquery1View> page = new Page<Fixbasicquery1View>(DEFAULT_PAGE_SIZE);
	
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}	
		String p_type = Struts2Utils.getRequest().getParameter("p_type");
		//重复查找
		if("11".equals(p_type)){
			if(StringUtils.isEmpty(repeat))
				repeat = "1";
			page = fixbasicquery1ViewManager.searchFixbasicquery1View4Repeat(page, repeat);
		}else{
			page = fixbasicquery1ViewManager.searchFixbasicquery1View(page, filters);
		}
		return SUCCESS;
	}
	
	public String list_repeat() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = fixbasicquery1ViewManager.searchFixbasicquery1View(page, filters);
		return SUCCESS;
	}
	
	@Autowired
	public void setFixbasicquery1ViewManager(Fixbasicquery1ViewManager fixbasicquery1ViewManager) {
		this.fixbasicquery1ViewManager = fixbasicquery1ViewManager;
	}
	public Page<Fixbasicquery1View> getPage() {
		return page;
	}

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}
	
	
}
