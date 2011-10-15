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
@Entity
@Table(name = "js_auth_post")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Post extends IdEntity {
						/**
	 * 职务名称
	 */
	private String postName;
				/**
	 * 职务编码
	 */
	private String postCode;
				/**
	 * 是否有效
	 */
	private Integer postEnabled;
				/**
	 * 职责
	 */
	private String postContent;
	
	/**
	 * 人员
	 */
	private List<User> userList = Lists.newArrayList();
			
						@Column(name="POST_NAME")
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
				@Column(name="POST_CODE")
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
				@Column(name="POST_ENABLED")
	public Integer getPostEnabled() {
		return postEnabled;
	}
	public void setPostEnabled(Integer postEnabled) {
		this.postEnabled = postEnabled;
	}
				@Column(name="POST_CONTENT")
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	//多对多定义
	@ManyToMany
	//中间表定义,表名采用默认命名规则
	@JoinTable(name = "JS_AUTH_USER_POST", joinColumns = { @JoinColumn(name = "POST_ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
	//Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	//集合按id排序.
	@OrderBy("id")
	//集合中对象id的缓存.
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}		
	/**
	 * 同一职务下用户id字符串, 多个用户id用','分隔.
	 */
	//非持久化属性.
	@Transient
	@SuppressWarnings("unchecked")
	public List<Integer> getUserIds() {
		return ConvertUtils.convertElementPropertyToList(userList, "id");
	}
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}