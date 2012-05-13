package com.jeysan.cpf.datagather.web;

import java.io.File;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.datagather.service.DataCheckManager;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author gemstone
 *
 */
@Namespace("/datagather")
public class DataCheckAction extends ActionSupport {
	
	public Log logger = LogFactory.getLog(getClass());
	@Autowired
	private DataCheckManager dataCheckManager;
	private File file;
	
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
	
	/**公安部门数据*/
	public String checkPoliceData()throws Exception{
		try {
			dataCheckManager.checkPolicyData();
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
			dataCheckManager.checkCivilData();		
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
			dataCheckManager.checkHospitalData();		
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
			dataCheckManager.checkGmccData();		
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
			dataCheckManager.checkCompanyDataBcs();		
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
			dataCheckManager.checkEpistationData();		
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML,e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	private void renderHtml(String content){
		Struts2Utils.renderHtml(content,new String[] {"encoding:GBK"});
	}
	
	
	
	
}
