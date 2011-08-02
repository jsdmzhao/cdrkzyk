package com.jeysan.cpf.security.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.jeysan.cpf.security.entity.Role;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component("roleDao4Js")
public class RoleDao extends HibernateDao<Role, Integer> {
	
	public List<Role> getAllRolesByUserId(Integer userId , String roleCode,String roleName){
		StringBuilder sb = new StringBuilder();
		Map values = Maps.newHashMap();
		if(userId == null){
			sb.append("select r from com.jeysan.cpf.security.entity.Role r where r.roleEnable = 1 ");
		}else{
			sb.append("select distinct r from com.jeysan.cpf.security.entity.User u left join u.roleList as r where r.roleEnable = 1 and u.id = :userId ");
			values.put("userId", userId);
		}
		if(StringUtils.isNotEmpty(roleCode)){
			sb.append(" and r.roleCode like :roleCode ");
			values.put("roleCode", "%"+roleCode+"%");
		}
		if(StringUtils.isNotEmpty(roleName)){
			sb.append(" and r.roleName like :roleName ");
			values.put("roleName", "%"+roleName+"%");
		}
		sb.append(" order by r.roleCode ");
		return find(sb.toString(),values);
	}
	
}