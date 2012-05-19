package com.jeysan.cpf.datagather.web;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.datagather.service.DataCheckManager;
import com.jeysan.cpf.monitor.service.MonitorWorkloadManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author gemstone
 *
 */
@Namespace("/datagather")
public class DataCheckAction extends ActionSupport {
	private MonitorWorkloadManager monitorWorkloadManager;
	public Log logger = LogFactory.getLog(getClass());
	@Autowired
	private DataCheckManager dataCheckManager;
	
	private static final String SUCCESS_HTML = "{\"callbackType\":\"forward\",\"statusCode\":200,\"message\":\"数据校验成功，已按规则自动入库！\"}";
	private static final String FAILUER_HTML = "{\"statusCode\":300,\"message\":\"数据校验失败！%s \"}";

	@Override
	public String execute() throws Exception {
		return list();
	}
	
	public String list() throws Exception {
		Map count_map = dataCheckManager.getNewDataCount();
		Struts2Utils.getRequest().setAttribute("cm", count_map);
		return SUCCESS;
	}
	
	private void saveMonitorWorkLoad(int[] count , String remark){
		if(count[0] > 0)
			monitorWorkloadManager.saveMonitorWorkload(Constants.WORK_TYPE.CHECK, Constants.OPERATOR_TYPE.ADD, count[0],remark);
		if(count[1] > 0)
			monitorWorkloadManager.saveMonitorWorkload(Constants.WORK_TYPE.CHECK, Constants.OPERATOR_TYPE.UPDATE, count[1],remark);
	
	}
	
	/**公安部门数据*/
	public String checkPoliceData()throws Exception{
		try {
			int[][] count = dataCheckManager.checkPolicyData();
			saveMonitorWorkLoad(count[0], "公安部门 婴儿出生入户数据");
			saveMonitorWorkLoad(count[1], "公安部门 迁入数据");
			saveMonitorWorkLoad(count[2], "公安部门 死亡人口数据");
			renderHtml(SUCCESS_HTML);
			return NONE;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**民政部门数据*/
	public String checkCivilData()throws Exception{
		try {
			int[] count = dataCheckManager.checkCivilData();
			saveMonitorWorkLoad(count, "民政部门数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**医院相关数据*/
	public String checkHospital()throws Exception{
		try {
			int[][] count = dataCheckManager.checkHospitalData();
			saveMonitorWorkLoad(count[0], "医院 妇产科出生登记数据");
			saveMonitorWorkLoad(count[1], "医院 四术落实登记数据");
			saveMonitorWorkLoad(count[2], "医院 孕前检查登记数据");
			saveMonitorWorkLoad(count[3], "医院 防疫登记数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**社会保险项目数据*/
	public String checkGmcc()throws Exception{
		try {
			int[] count = dataCheckManager.checkGmccData();
			saveMonitorWorkLoad(count, "社会保险项目数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**教育电子数据*/
	public String checkEdudata()throws Exception{
		try {
			//暂无
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**企业人员计划生育数据*/
	public String checkCompany()throws Exception{
		try {
			int[] count = dataCheckManager.checkCompanyDataBcs();
			saveMonitorWorkLoad(count, "企业人员计划生育数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**防疫站 电子数据*/
	public String checkEpistation()throws Exception{
		try {
			int[] count = dataCheckManager.checkEpistationData();
			saveMonitorWorkLoad(count, "防疫站 电子数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML,e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}

	private void renderHtml(String content){
		Struts2Utils.renderHtml(content,new String[] {"encoding:GBK"});
	}
	
	
	@Autowired
	public void setMonitorWorkloadManager(MonitorWorkloadManager monitorWorkloadManager) {
		this.monitorWorkloadManager = monitorWorkloadManager;
	}
	
}
