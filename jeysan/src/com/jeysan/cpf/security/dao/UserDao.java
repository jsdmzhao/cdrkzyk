package com.jeysan.cpf.security.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.security.entity.User;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component("userDao4Js")
public class UserDao extends HibernateDao<User, Integer> {
	
	public User findUserByOrgCodeAndUserCode(String orgCode,String userCode){
		List<User> userList = find("select u from com.jeysan.cpf.security.entity.User as u left join u.orgList as o where upper(u.userCode) = ? and upper(o.orgCode) = ?",userCode.toUpperCase(),orgCode.toUpperCase());
		if(userList!=null&&userList.size()>0)
			return userList.get(0);
		return null;
	}
	
}