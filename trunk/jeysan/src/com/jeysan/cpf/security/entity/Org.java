package com.jeysan.cpf.security.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.google.common.collect.Lists;
import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "JS_AUTH_ORG")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Org extends IdEntity {
	/**
	 * 机构类型 1 平台 2 机构
	 */
	private Integer orgType;
	/**
	 * 机构编码
	 */
	private String orgCode;
	/**
	 * 父机构
	 */
	private Org parent;
	/**
	 * 机构全称
	 */
	private String orgName;
	/**
	 * 机构简称
	 */
	private String simpleName;
	/**
	 * 机构状态
	 */
	private Integer disabledStatus;
	/**
	 * 是否叶子节点(末节点) 1 是 0否
	 */
	private Integer isLeaf;
	/**
	 * 机构层级，从1开始
	 */
	private Integer levelNum;
	/**
	 * 机构人员
	 */
	private List<User> userList = Lists.newArrayList();
	/**
	 * 子机构
	 */
	private List<Org> orgList = Lists.newArrayList();
	
	@Column(name="ORG_TYPE")
	public Integer getOrgType() {
		return orgType;
	}
	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
	@Column(name="ORG_CODE")
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PARENT_ORG_ID")
	public Org getParent() {
		return parent;
	}
	public void setParent(Org parent) {
		this.parent = parent;
	}
	@Column(name="ORG_NAME")
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Column(name="SIMPLE_NAME")
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	@Column(name="DISABLED_STATUS")
	public Integer getDisabledStatus() {
		return disabledStatus;
	}
	public void setDisabledStatus(Integer disabledStatus) {
		this.disabledStatus = disabledStatus;
	}
	@Column(name="IS_LEAF")
	public Integer getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}
	@Column(name="LEVEL_NUM")
	public Integer getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(Integer levelNum) {
		this.levelNum = levelNum;
	}
	//多对多定义
	@ManyToMany
	//中间表定义,表名采用默认命名规则
	@JoinTable(name = "JS_AUTH_ORG_USER", joinColumns = { @JoinColumn(name = "ORG_ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
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
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="PARENT_ORG_ID")
    @OrderBy("orgCode")
	public List<Org> getOrgList() {
		return orgList;
	}
	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}
