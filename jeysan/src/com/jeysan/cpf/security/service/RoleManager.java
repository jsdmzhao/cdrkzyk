package com.jeysan.cpf.security.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.security.dao.RoleDao;
import com.jeysan.cpf.security.dao.UserDao;
import com.jeysan.cpf.security.entity.Role;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class RoleManager {
	private static Logger logger = LoggerFactory.getLogger(RoleManager.class);
	
	private RoleDao roleDao;
	
	private UserDao userDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveRole(Role entity){
		roleDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteRole(Integer id){
		roleDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteRoles(Integer id){
		roleDao.batchExecute("delete com.jeysan.cpf.security.entity.Role where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteRoles(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteRoles(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Role getRole(Integer id){
		return roleDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Role> searchRole(final Page<Role> page,final List<PropertyFilter> filter){
		return roleDao.findPage(page, filter);
	}
	
	@Autowired
	public void setRoleDao(@Qualifier("roleDao4Js")RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Autowired
	public void setUserDao(@Qualifier("userDao4Js")UserDao userDao) {
		this.userDao = userDao;
	}
	@Transactional(readOnly = true)
	public List<Role> queryAllRoles(Integer userId,String userCode,String userName) {
		return roleDao.getAllRolesByUserId(userId, userCode,userName);
	}
	
	@Transactional(readOnly = true)
	public List<Role> getAllRoles(Integer userId,String userCode,String userName) {
		return roleDao.getAllRolesByUserId(userId, userCode,userName);
	}
	@Transactional(readOnly = true)
	public List<Role> getAllRoles(Integer userId,List<PropertyFilter> filters) {
		if(userId==null)
			return roleDao.getAll("roleCode",true);
		else{
			User user = userDao.get(userId);
			if(user!=null)
				return user.getRoleList();
		}
		return null;
	}
}