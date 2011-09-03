package com.jeysan.cpf.monitor.web;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jeysan.cpf.monitor.service.HPMonitorManager;
import com.jeysan.cpf.pmas.entity.House;
import com.jeysan.cpf.pmas.service.HouseManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/monitor")
public class HPMonitorAction extends CrudActionSupport<House> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826212472390477005L;
	private Long id;
	private String ids;
	private HPMonitorManager hpMonitorManager;
	private Result4Json result4Json;
	@Override
	public String delete() throws Exception {
		
		return NONE;
	}
	@Override
	public String input() throws Exception {
		return INPUT;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 *  auth严敏2011-9-3 下午08:20:34
	 */
	public String viewdoublecheck() throws Exception
	{

		List list=hpMonitorManager.getListDoublecheckData();
		Struts2Utils.getRequest().setAttribute("list", list);
		return "doublecheck";
	}
	

	/**
	 * 
	 * @return
	 * @throws Exception
	 *  auth严敏2011-9-3 下午08:22:02
	 */
	public String viewoverbirth() throws Exception
	{

		List list=hpMonitorManager.getOverBirth();
		Struts2Utils.getRequest().setAttribute("list", list);
		return "overbirth";
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 *  auth严敏2011-9-3 下午08:22:06
	 */
	public String getNoContraception()throws SQLException
	{
		List list=hpMonitorManager.getNoContraception();
		Struts2Utils.getRequest().setAttribute("list", list);
		return "nocontraception";
	}
	
	/**
	 * 
	 * @return
	 *  auth严敏2011-9-3 下午08:22:11
	 */
	public HPMonitorManager getHpMonitorManager() {
		return hpMonitorManager;
	}
	
	@Autowired
	public void setHpMonitorManager(HPMonitorManager hpMonitorManager) {
		this.hpMonitorManager = hpMonitorManager;
	}
	
	public House getModel() {
		// TODO 自动生成方法存根
		return null;
	}
	
	@Override
	public String list() throws Exception {
		// TODO 自动生成方法存根
		return null;
	}
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO 自动生成方法存根
		
	}
	
	@Override
	public String save() throws Exception {
		// TODO 自动生成方法存根
		return null;
	}
	
	@Override
	public String view() throws Exception {
		// TODO 自动生成方法存根
		return null;
	}
	
	
	
	
	
}
