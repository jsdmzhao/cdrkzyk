package com.jeysan.cpf.datagather.build;

import java.lang.reflect.Constructor;

import javax.sql.DataSource;

/** 
 * @author  gemstone	E-mail: xlsky0713@163.com
 * @version 2011-9-1 下午02:05:51 
 * description
 */
public class DataImportFactory {
	
	@SuppressWarnings("unchecked")
	public static BaseImport getImportInstance(DataSource dataSource,Class clazz){
		
		BaseImport bit = null;

		try {
			Constructor cons = clazz.getConstructor(DataSource.class);
			
			bit = (BaseImport)cons.newInstance(dataSource);
			
		} catch (Exception e) {
			throw new RuntimeException("数据导入类初始化失败！",e);
		} 

		return bit;
	}
	
}
