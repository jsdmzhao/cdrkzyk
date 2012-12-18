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

import org.apache.commons.lang.builder.ToStringBuilder;
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
@Entity(name = "role4Js")
@Table(name = "js_auth_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends IdEntity {
	/**
	 * 角色编码
	 */
	private String roleCode;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色描述
	 */
	private String roleInfo;
	/**
	 * 是否启用
	 */
	private Integer roleEnable;
	/**
	 * 是否受限
	 */
	private Integer roleIslimited;
	/**
	 * 角色所拥有的资源
	 */
	private List<Resource> resourceList = Lists.newArrayList();

	@Column(name = "ROLE_CODE")
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Column(name = "ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "ROLE_ENABLE")
	public Integer getRoleEnable() {
		return roleEnable;
	}

	public void setRoleEnable(Integer roleEnable) {
		this.roleEnable = roleEnable;
	}
	@Column(name = "ROLE_ISLIMITED")
	public Integer getRoleIslimited() {
		return roleIslimited;
	}

	public void setRoleIslimited(Integer roleIslimited) {
		this.roleIslimited = roleIslimited;
	}

	@ManyToMany
	@JoinTable(name = "JS_AUTH_ROLE_RESOURCE", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "RESOURCE_ID") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Resource> getResourceList() {
		return resourceList;
	}
	
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	
	@Transient
	@SuppressWarnings("unchecked")
	public List<Integer> getResourceIds() {
		return ConvertUtils.convertElementPropertyToList(resourceList, "id");
	}
	@Column(name = "ROLE_INFO")
	public String getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}