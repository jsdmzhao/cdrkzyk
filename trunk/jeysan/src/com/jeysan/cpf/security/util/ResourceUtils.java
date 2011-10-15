package com.jeysan.cpf.security.util;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.jeysan.cpf.security.entity.Resource;
import com.jeysan.modules.utils.CollectionUtil;

public class ResourceUtils {
	public static Map<Resource,List> reset2Map4ExistsResources(List<Resource> resources,List<Resource> filter){
		if(resources==null||resources.size()==0)
			return null;
		Map<Resource,List> hasResources = Maps.newTreeMap(new Comparator<Resource>(){
			@Override
			public int compare(Resource o1, Resource o2) {
				return o1.getResourceIndex().compareTo(o2.getResourceIndex());
			}
		});
		for(Resource resource : resources){
			//菜单级别为1的加入map作文key,级别为2的加入map，作为value
			if(resource!=null&&resource.getResourceLevel() == 2){
				CollectionUtil.putValue(hasResources,resource.getParent()==null?resource:resource.getParent(),resource,filter);
			}
		}
		return hasResources;
	}
}
