package com.jeysan.cpf.dataexchange.web;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.dataexchange.service.XlsDataInManager;
import com.jeysan.cpf.monitor.service.MonitorWorkloadManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;
import com.jeysan.modules.utils.xls.ExcelUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author gemstone
 *
 */
@Namespace("/dataexchange")
public class XlsDataInAction extends ActionSupport {
	
	private static final long serialVersionUID = 6214215610817708297L;
	public Log logger = LogFactory.getLog(getClass());
	@Autowired
	private XlsDataInManager xlsDataInManager;
	private File file;
	private MonitorWorkloadManager monitorWorkloadManager;
	private static final String SUCCESS_HTML = "{\"statusCode\":200,\"message\":\"数据导入成功！\"}";
	private static final String FAILUER_HTML = "{\"statusCode\":300,\"message\":\"数据导入失败！%s \"}";
	
	private void saveMonitorWorkLoad(int count , String remark) throws Exception{
		if(count > 0)
			monitorWorkloadManager.saveMonitorWorkload(Constants.WORK_TYPE.IMPORT, Constants.OPERATOR_TYPE.ADD, count,remark);
	}

	/**全员数据导入*/
	public String importFullData()throws Exception{
		try {
			ExcelUtil util = new ExcelUtil(file.getPath());
			String[] sheetNames = util.getSheetNames();
			for(String sheetName : sheetNames){
				Map<Integer,List> map_fix = util.getSheet(sheetName);
				if(map_fix != null && map_fix.size() > 0){
					saveMonitorWorkLoad(xlsDataInManager.importFullData(map_fix), "全员数据导入，"+sheetName);
				}
			}
			//logger.debug(file.getPath());
			renderHtml(SUCCESS_HTML);	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);			
			renderHtml(String.format(FAILUER_HTML, e.getMessage().replaceAll("\"", "")));
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
