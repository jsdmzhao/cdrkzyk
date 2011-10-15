package com.jeysan.cpf.security.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "js_auth_resource")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Resource extends IdEntity {
	/**
	 * 资源编码
	 */
	private String resourceCode;
	/**
	 * 资源名称
	 */
	private String resourceName;
	/**
	 * 资源类型
	 */
	private Integer resourceType;
	/**
	 * 资源值
	 */
	private String resourceValue;
	/**
	 * 父资源
	 */
	private Resource parent;
	/**
	 * 资源序号
	 */
	private Integer resourceIndex;
	/**
	 * 资源层级
	 */
	private Integer resourceLevel;
	/**
	 * 对应实体名
	 */
	private String entityName;

	@Column(name = "RESOURCE_CODE")
	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	@Column(name = "RESOURCE_NAME")
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name = "RESOURCE_TYPE")
	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	@Column(name = "RESOURCE_VALUE")
	public String getResourceValue() {
		return resourceValue;
	}

	public void setResourceValue(String resourceValue) {
		this.resourceValue = resourceValue;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "RESOURCE_PARENT")
	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	@Column(name = "RESOURCE_INDEX")
	public Integer getResourceIndex() {
		return resourceIndex;
	}

	public void setResourceIndex(Integer resourceIndex) {
		this.resourceIndex = resourceIndex;
	}

	@Column(name = "RESOURCE_LEVEL")
	public Integer getResourceLevel() {
		return resourceLevel;
	}

	public void setResourceLevel(Integer resourceLevel) {
		this.resourceLevel = resourceLevel;
	}

	@Column(name = "ENTITY_NAME")
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}