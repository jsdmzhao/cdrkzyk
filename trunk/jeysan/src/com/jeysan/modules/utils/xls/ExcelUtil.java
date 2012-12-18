package com.jeysan.modules.utils.xls;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.WorkbookParser;

public class ExcelUtil {
	private Workbook wk = null;
	
	public ExcelUtil(String file){
		try {
			wk = WorkbookParser.getWorkbook(new File(file));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] getSheetNames(){
		return wk.getSheetNames();
	}
	
	public Map getSheet(String sheetName){
		Sheet sheet = wk.getSheet(sheetName);
		if(sheet == null)
			return null;
		int size = sheet.getColumns();
		Map<Integer,List> map = new HashMap<Integer,List>();
		Cell[] cells = null;
		for(int i = 0;i < size;i++){
			if(!map.containsKey(i)){
				map.put(i, new ArrayList());
			}
			cells = sheet.getColumn(i);
			for(Cell c : cells){
				map.get(i).add(c.getContents().trim());
			}
		}
		return map;
	}
	
	public static void main(String[] argv){
		ExcelUtil util = new ExcelUtil("E:\\projects\\personInfo_docs\\导出数据\\计划生育管理系统\\全员淇澳人员数据.xls");
		Map<Integer,List> map = util.getSheet("户籍人口");
		List<String> p0 = map.get(0);
		List<String> p5 = map.get(5);
		List<String> p6 = map.get(6);
		System.out.println(p0.size()+":"+p5.size()+":"+p6.size());
	}
	
}
