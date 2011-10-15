/**
 * 
 */
package com.jeysan.cpf.security.service.auth;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.jeysan.cpf.security.entity.Org;
import com.jeysan.cpf.security.entity.Resource;
import com.jeysan.cpf.security.entity.User;

/**
 * Spring Security 相关Service方法
 * 
 * @author shally
 *
 */
public interface ISecurityService {

	
	/**
	 * 通过用户名获得用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName);
	
	/**
	 * 通过用户编码和组织机构编码获得用户信息
	 * 
	 * @param orgCode
	 * @param userCode
	 * @return
	 */
	public User getUserByCode(String orgCode, String userCode);
	
	/**
	 * 通过组织机构编码获得组织机构信息
	 * 
	 * @param orgCode
	 * @return
	 */
	public Org getOrgByCode(String orgCode);

	/**
	 * 获得所有的resources
	 * 
	 * @return
	 */
	public List<Resource> findAllResources();

	
	/**
	 * 将UserDetails放入memCached中
	 * 
	 * @param username
	 */
	public void putUserDetailsInCache(String username);
	
	/**
	 * 将UserDetails放入memCached中
	 * 
	 * @param securityUser
	 */
	public void putUserDetailsInCache(User user);
	
	/**
	 * 将UserDetails放入memCached中
	 * 
	 * @param userDetails
	 */
	public void putUserDetailsInCache(UserDetails userDetails);
	
	/**
	 * 清空memCached中的UserDetails
	 * 
	 * @param username
	 */
	public void cleanUserDetailsCache(String username);
	
	/**
	 * 清空memCached中的UserDetails
	 * 
	 * @param orgCode
	 * @param userCode
	 */
	public void cleanUserDetailsCache(String orgCode, String userCode);
}
