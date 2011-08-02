package com.jeysan.cpf.security.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.security.entity.Resource;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class ResourceDao extends HibernateDao<Resource, Integer> {
	
	public List<Resource> getResourcesByUserId(Integer userId){
		if(userId == null)
			return getAll("resourceIndex",true);
		else{
			return find("select distinct c from com.jeysan.cpf.security.entity.User a left join a.roleList as b left join b.resourceList as c where b.roleEnable = 1 and a.id = ? order by c.resourceIndex",userId);
		}
	}

	public Map findTopLevelResource() {
		List<Object[]> topLevelResources = find("select id,resourceName from com.jeysan.cpf.security.entity.Resource where resourceLevel = 1");
		Map result = new HashMap();
		for(Object[] obj : topLevelResources){
			result.put(obj[0], obj[1]);
		}
		return result;
	}
	
}