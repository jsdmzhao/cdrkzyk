package com.jeysan.modules.utils;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class CollectionUtil {
	public static <T> void putValue(Map<T, List> result,T key,T value,List<T> filter){
		if(key == null)
			return;
		if(!result.containsKey(key)){
			result.put(key, Lists.newArrayList());
		}
		if(filter==null||!filter.contains(value))
			if(!result.get(key).contains(value))
				result.get(key).add(value);
	}
}
