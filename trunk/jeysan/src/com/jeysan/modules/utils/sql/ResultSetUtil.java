package com.jeysan.modules.utils.sql;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


public class ResultSetUtil {
	public static Logger logger = Logger.getLogger(ResultSetUtil.class);
	
	public static List toList(ResultSet rs, Class clazz) {
		if(clazz == null)
			return toArrayList(rs);
		else
			return toObjectList(rs, clazz);
	}
	
	public static List toObjectList(ResultSet rs, Class clazz) {
		//long t1 = new Date().getTime();
		try {
			List lst = new ArrayList();
			ResultSetMetaData meta = rs.getMetaData();
			Object obj = null , value = null;;
			String methodName = null , key = null;
			Method method = null;
			Map<String,Method> methods_map = getMethods(clazz);
			while (rs.next()) {
				obj = clazz.newInstance();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					value = rs.getObject(i);
					key = meta.getColumnName(i).toLowerCase().replaceAll("_", "");
					methodName = "set" + key;
					method = methods_map.get(methodName.toLowerCase());
					if(method != null)
						method.invoke(obj, value); 
				}
				lst.add(obj);
			}
			return lst;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}finally{
			//long t2 = new Date().getTime();
			//logger.info("spend:"+(t2-t1)+"ms");
		}

	}
	
	public static Map<String,Method> getMethods(Class clazz){
		Method[] methods = clazz.getMethods();
		Map<String,Method> map = new HashMap<String,Method>();
		for(Method method : methods){
			if(method.getName().startsWith("set"))
				map.put(method.getName().toLowerCase(), method);
		}
		return map;
	}
	
	public static List toArrayList(ResultSet rs) {
		try {
			List lst = new ArrayList();
			ResultSetMetaData meta = rs.getMetaData();
			Object[] obj_arr = null;
			while (rs.next()) {
				obj_arr = new Object[meta.getColumnCount()];
				for (int i = 0; i < obj_arr.length; i++) {
					obj_arr[i] = rs.getObject(i+1);
				}
				lst.add(obj_arr);
			}
			return lst;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] argv){
		
	}
}
