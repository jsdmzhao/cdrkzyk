package com.jeysan.cpf.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 读取excel
 * 
 * @author gemstone
 * 
 */
public class ExcelReader {

	public static Sheet readExcel(String excelFileName, int index)throws BiffException, IOException {

		Workbook rwb = null;

		InputStream stream = new FileInputStream(excelFileName);
		rwb = Workbook.getWorkbook(stream);
		stream.close();
		
		return rwb.getSheet(index);

	}
	
	public static Sheet[] readExcel(String excelFileName)throws BiffException, IOException {
		
		Workbook rwb = null;
		
		InputStream stream = new FileInputStream(excelFileName);
		rwb = Workbook.getWorkbook(stream);
		stream.close();
		
		return rwb.getSheets();
	}

}
