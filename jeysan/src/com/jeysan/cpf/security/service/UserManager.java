package com.jeysan.cpf.security.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.security.dao.UserDao;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class UserManager {
	private static Logger logger = LoggerFactory.getLogger(UserManager.class);
	
	private UserDao userDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveUser(User entity){
		userDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteUser(Integer id){
		userDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteUsers(Integer id){
		userDao.batchExecute("delete User where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteUsers(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteUsers(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public User getUser(Integer id){
		return userDao.get(id);
	}
	/**
	 * 登录名查找
	 * @param userCode
	 * @return
	 */
	@Transactional(readOnly = true)
	public User getUser(String userCode){
		if(StringUtils.isEmpty(userCode))
			return null;
		List<User> userList =  userDao.findBy("userCode", userCode);
		if(userList!=null&&userList.size()>0)
			return userList.get(0);
		else 
			return null;
	}
	/**
	 * 机构、登录名查找
	 * @param orgCode
	 * @param userCode
	 * @return
	 */
	@Transactional(readOnly = true)
	public User getUser(String orgCode,String userCode){
		return userDao.findUserByOrgCodeAndUserCode(orgCode, userCode);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<User> searchUser(final Page<User> page,final List<PropertyFilter> filter){
		return userDao.findPage(page, filter);
	}
	
	@Autowired
	public void setUserDao(@Qualifier("userDao4Js")UserDao userDao) {
		this.userDao = userDao;
	}
	
	
}