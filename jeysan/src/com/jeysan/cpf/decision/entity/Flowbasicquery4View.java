package com.jeysan.cpf.decision.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_flowbasicquery4_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery4View extends IdExtEntity {

	/**
	 * 流动人口编号
	 */
	private String personCode;
	/**
	 * 证件号码
	 */
	private String code;
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 初婚日期
	 */
	private java.util.Date firstMarryDate;
	/**
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 居住地
	 */
	private String address;
	/**
	 * 子女数
	 */
	private Long childnum;
	/**
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * 变化原因
	 */
	private String changeCause;
	/**
	 * 落实日期
	 */
	private java.util.Date opsDate;
	/**
	 * 配偶姓名
	 */
	private String nameh2;
	/**
	 * 是否同意
	 */
	private Integer isAgree;
	/**
	 * 所属地区
	 */
	private String area;
	/**
	 * 户口性质
	 */
	private Integer domicileType;

	@Column(name = "PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}

	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	@Column(name = "FIRST_MARRY_DATE")
	public java.util.Date getFirstMarryDate() {
		return firstMarryDate;
	}

	public void setFirstMarryDate(java.util.Date firstMarryDate) {
		this.firstMarryDate = firstMarryDate;
	}

	@Column(name = "DOMICILE")
	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "childnum")
	public Long getChildnum() {
		return childnum;
	}

	public void setChildnum(Long childnum) {
		this.childnum = childnum;
	}

	@Column(name = "METHOD")
	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	@Column(name = "CHANGE_CAUSE")
	public String getChangeCause() {
		return changeCause;
	}

	public void setChangeCause(String changeCause) {
		this.changeCause = changeCause;
	}

	@Column(name = "OPS_DATE")
	public java.util.Date getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(java.util.Date opsDate) {
		this.opsDate = opsDate;
	}

	@Column(name = "nameh2")
	public String getNameh2() {
		return nameh2;
	}

	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}

	@Column(name = "IS_AGREE")
	public Integer getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}

	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}