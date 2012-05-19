package com.jeysan.cpf.datagather.web;

import java.io.File;

import jxl.Sheet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.datagather.service.BasicDataInManager;
import com.jeysan.cpf.monitor.service.MonitorWorkloadManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.cpf.util.ExcelReader;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author gemstone
 *
 */
@Namespace("/datagather")
public class BasicDataInAction extends ActionSupport {
	
	private static final long serialVersionUID = 6214215610817708297L;
	public Log logger = LogFactory.getLog(getClass());
	@Autowired
	private BasicDataInManager dataCollectManager;
	private File file;
	private MonitorWorkloadManager monitorWorkloadManager;
	private static final String SUCCESS_HTML = "{\"statusCode\":200,\"message\":\"数据导入成功！\"}";
	private static final String FAILUER_HTML = "{\"statusCode\":300,\"message\":\"数据导入失败！%s \"}";
	
	private void saveMonitorWorkLoad(int count , String remark){
		if(count > 0)
			monitorWorkloadManager.saveMonitorWorkload(Constants.WORK_TYPE.IMPORT, Constants.OPERATOR_TYPE.ADD, count,remark);
	}

	/**公安部门数据*/
	public String importPoliceData()throws Exception{
		try {
			Sheet[] sheets = ExcelReader.readExcel(file.getPath());
			int[] count = dataCollectManager.importPolicyData(sheets);
			saveMonitorWorkLoad(count[0], "公安部门 婴儿出生入户数据");
			saveMonitorWorkLoad(count[1], "公安部门 珠海市外 迁入数据");
			saveMonitorWorkLoad(count[2], "公安部门 珠海市内 迁入数据");
			saveMonitorWorkLoad(count[3], "公安部门 死亡人口数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**民政部门数据*/
	public String importCivilData()throws Exception{
		try {
			Sheet[] sheets = ExcelReader.readExcel(file.getPath());
			int count = dataCollectManager.importCivilData(sheets);	
			saveMonitorWorkLoad(count, "民政部门数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**医院相关数据*/
	public String importHospital()throws Exception{
		try {
			Sheet[] sheets = ExcelReader.readExcel(file.getPath());
			int count[] = dataCollectManager.importHospitalData(sheets);
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
	public String importGmcc()throws Exception{
		try {
			Sheet[] sheets = ExcelReader.readExcel(file.getPath());
			int count = dataCollectManager.importGmccData(sheets);	
			saveMonitorWorkLoad(count, "社会保险项目数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**教育电子数据*/
	public String importEdudata()throws Exception{
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
	public String importCompany()throws Exception{
		try {
			Sheet[] sheets = ExcelReader.readExcel(file.getPath());
			int count = dataCollectManager.importCompanyDataBcs(sheets);
			saveMonitorWorkLoad(count, "企业人员计划生育数据");
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
		}	
		return NONE;
	}
	
	/**防疫站 电子数据*/
	public String importEpistation()throws Exception{
		try {
			Sheet[] sheets = ExcelReader.readExcel(file.getPath());
			int count = dataCollectManager.importEpistationData(sheets);
			saveMonitorWorkLoad(count, "防疫站 电子数据");
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
	
	@Autowired
	public void setMonitorWorkloadManager(MonitorWorkloadManager monitorWorkloadManager) {
		this.monitorWorkloadManager = monitorWorkloadManager;
	}
	
	
}
