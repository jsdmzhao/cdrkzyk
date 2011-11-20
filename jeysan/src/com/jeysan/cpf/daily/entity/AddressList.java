package com.jeysan.cpf.daily.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_address_list")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AddressList extends IdExtEntity {
	/**
	 * USER_ID
	 */
	private Long userId;
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 固话
	 */
	private String telPhone;
	/**
	 * 移动电话
	 */
	private String mobilePhone;
	/**
	 * 常用邮箱
	 */
	private String email;
	/**
	 * 单位
	 */
	private String company;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 分组
	 */
	private Integer grouph;
	/**
	 * 备注
	 */
	private String remark;

	@Column(name = "USER_ID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}

	@Column(name = "TEL_PHONE")
	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	@Column(name = "MOBILE_PHONE")
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "GROUPH")
	public Integer getGrouph() {
		return grouph;
	}

	public void setGrouph(Integer grouph) {
		this.grouph = grouph;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}