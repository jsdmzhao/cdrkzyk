package com.jeysan.cpf.security.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.google.common.collect.Lists;
import com.jeysan.modules.orm.hibernate.IdEntity;
import com.jeysan.modules.utils.reflection.ConvertUtils;

/**
 * @author 黄静
 * 
 */
@Entity(name = "user4Js")
@Table(name = "js_auth_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends IdEntity {
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户编码
	 */
	private String userCode;
	/**
	 * 所属机构
	 */
	private List<Org> orgList = Lists.newArrayList();
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 是否有效
	 */
	private Integer userEnabled;
	/**
	 * 用户角色
	 */
	private List<Role> roleList = Lists.newArrayList();
	/**
	 * 用户职务
	 */
	private List<Post> postList = Lists.newArrayList();

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_CODE")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	
	@ManyToMany
	@JoinTable(name = "JS_AUTH_ORG_USER", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ORG_ID") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Org> getOrgList() {
		return orgList;
	}
	
	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}

	@Column(name = "USER_PASSWORD")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "USER_ENABLED")
	public Integer getUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(Integer userEnabled) {
		this.userEnabled = userEnabled;
	}
	
	//多对多定义
	@ManyToMany
	//中间表定义,表名采用默认命名规则
	@JoinTable(name = "JS_AUTH_USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	//Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	//集合按id排序.
	@OrderBy("id")
	//集合中对象id的缓存.
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
	//多对多定义
	@ManyToMany
	//中间表定义,表名采用默认命名规则
	@JoinTable(name = "JS_AUTH_USER_POST", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "POST_ID") })
	//Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	//集合按id排序.
	@OrderBy("id")
	//集合中对象id的缓存.
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
	
	/**
	 * 用户拥有的角色id字符串, 多个角色id用','分隔.
	 */
	//非持久化属性.
	@Transient
	@SuppressWarnings("unchecked")
	public List<Integer> getRoleIds() {
		return ConvertUtils.convertElementPropertyToList(roleList, "id");
	}
	/**
	 * 用户拥有的职务id字符串, 多个职务id用','分隔.
	 */
	//非持久化属性.
	@Transient
	@SuppressWarnings("unchecked")
	public List<Integer> getPostIds() {
		return ConvertUtils.convertElementPropertyToList(postList, "id");
	}
	@Transient
	@SuppressWarnings("unchecked")
	public Org getOrg() {
		return orgList.size()>0?orgList.get(0):null;
	}
	
}