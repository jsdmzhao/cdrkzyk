package com.jeysan.modules.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

import com.jeysan.modules.utils.encode.EncodeUtils;

public class ResourceBundleUtils {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("application");
	
	public static String getSValue(String key){
		return bundle.getString(key);
	}
	
	public static Integer getIValue(String key){
		String value = getSValue(key);
		if(StringUtils.isNotEmpty(value))
			return Integer.parseInt(value);
		return null;
	}
	
	public static Boolean getBValue(String key){
		String value = getSValue(key);
		if(StringUtils.isNotEmpty(value))
			return Boolean.parseBoolean(value);
		return null;
	}
	
	public static String[] getSAValue(String key,char seperator){
		String value = getSValue(key);
		if(StringUtils.isNotEmpty(value))
			return StringUtils.split(value, seperator);
		return null;
	}
	
	public static Integer[] getIAValue(String key,char seperator){
		String[] saValue = getSAValue(key,seperator);
		if(saValue != null){
			Integer[] iaValue = new Integer[saValue.length];
			for(int i=0;i<iaValue.length;i++)
				iaValue[i] = Integer.parseInt(saValue[i]);
			return iaValue;
		}
		return null;
	}
	
	/**
	 * @param argv
	 */
	public static void main(String[] argv){
		String title = ResourceBundleUtils.getSValue("platform.title");
		try {
			System.out.println(new String(title.getBytes("iso-8859-1"),"utf-8"));
			System.out.println(EncodeUtils.encode(title,"ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
