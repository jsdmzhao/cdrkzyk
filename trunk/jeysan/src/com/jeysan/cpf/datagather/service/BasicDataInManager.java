package com.jeysan.cpf.datagather.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;

import com.jeysan.cpf.datagather.build.BaseImport;
import com.jeysan.cpf.datagather.build.CivilMarryRegImport;
import com.jeysan.cpf.datagather.build.CompanyBcsImport;
import com.jeysan.cpf.datagather.build.DataImportFactory;
import com.jeysan.cpf.datagather.build.GmccImport;
import com.jeysan.cpf.datagather.build.HospitalBirthImport;
import com.jeysan.cpf.datagather.build.HospitalEpipreImport;
import com.jeysan.cpf.datagather.build.HospitalEpistationImport;
import com.jeysan.cpf.datagather.build.HospitalFouropsImport;
import com.jeysan.cpf.datagather.build.HospitalPregtestImport;
import com.jeysan.cpf.datagather.build.PolicyBabyImport;
import com.jeysan.cpf.datagather.build.PolicyDeathImport;
import com.jeysan.cpf.datagather.build.PolicySettleInImport;
import com.jeysan.cpf.datagather.dao.BasicDataInDao;

/**
 * 
 * @author gemstone
 *
 */
@Component
public class BasicDataInManager {
	
	@Autowired
	private BasicDataInDao dataCollectDao;
	
	public void importPolicyData(Sheet[] sheets)throws SQLException{
		/**公安部门 婴儿出生入户数据*/
		importData(sheets[0], PolicyBabyImport.class);
		/**公安部门 珠海市外 市内迁入数据*/
		PolicySettleInImport.type = 1;
		importData(sheets[1], PolicySettleInImport.class);
		PolicySettleInImport.type = 2;
		importData(sheets[2], PolicySettleInImport.class);
		/**公安部门 死亡人口情况 数据*/
		importData(sheets[3], PolicyDeathImport.class);
		
	}
	
	public void importCivilData(Sheet[] sheets)throws SQLException{
		/**民政部门数据*/
		importData(sheets[0], CivilMarryRegImport.class);
		
	}
	
	public void importHospitalData(Sheet[] sheets)throws SQLException{
		/**医院 妇产科出生登记数据*/
		importData(sheets[0], HospitalBirthImport.class);
		/**医院 四术落实登记数据*/
		importData(sheets[1], HospitalFouropsImport.class);
		/**医院 孕前检查登记数据*/
		importData(sheets[2], HospitalPregtestImport.class);
		/**医院 防疫登记数据*/
		importData(sheets[3], HospitalEpipreImport.class);
	}
	
	public void importGmccData(Sheet[] sheets)throws SQLException{
		/**社保 社会保险项目数据*/
		importData(sheets[0], GmccImport.class);
	}
	
	public void importCompanyDataBcs(Sheet[] sheets)throws SQLException{
		/**企业 人员计划生育数据*/
		importData(sheets[0], CompanyBcsImport.class);
	}
	
	public void importEpistationData(Sheet[] sheets)throws SQLException{
		/**防疫站 电子数据*/
		importData(sheets[0], HospitalEpistationImport.class);
	}
	
	
	@SuppressWarnings("unchecked")
	private void importData(Sheet sheet,Class clazz)throws SQLException{	
		List<String[]> datas = new ArrayList<String[]>();
		BaseImport bit = DataImportFactory.getImportInstance(
				SessionFactoryUtils.getDataSource(dataCollectDao.getSessionFactory()),clazz);
		Cell cell = null;String content = null;String[] str = null;Boolean flag = null;
		try {
			int rows = sheet.getRows();
			for (int i = 0; i < rows; i++) {
				str = new String[sheet.getColumns()];		
				/**是否为空行*/
				flag = true;
				/**列数*/
				for (int j = 0; j < sheet.getColumns(); j++) {
					/**获取第i行，第j列的值*/
					cell = sheet.getCell(j, i);
					content = cell.getContents();
					if(StringUtils.isNotEmpty(content)) flag = false;
					str[j] = content;
				}
				/**空行忽略*/
				if(!flag) datas.add(str);
				/**每500条数据导入一次*/
				if(datas.size() == 500 || i == rows -1 ){
					bit.run(datas);
					datas.clear();
				}
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	
}