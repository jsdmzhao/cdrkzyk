package com.jeysan.cpf.decision.entity;

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
@Table(name = "fhp_flowbasicquery14_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery14View extends IdExtEntity {
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 人员编码
	 */
	private String personCode;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 身份证号码
	 */
	private String code;
	/**
	 * 配偶姓名
	 */
	private String nameh2;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * 落实措施日期
	 */
	private java.util.Date opsDate;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 流入日期
	 */
	private java.util.Date inDate;
	/**
	 * 流入原因
	 */
	private Integer inCause;
	/**
	 * 注销日期
	 */
	private java.util.Date cancelDate;
	/**
	 * 流出日期
	 */
	private java.util.Date dateh;
	/**
	 * 注销类别
	 */
	private Integer cancelType;
	/**
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 流入地
	 */
	private String inAddress;
	/**
	 * 现居住地址
	 */
	private String address;
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 户口类被
	 */
	private Integer domicileType;

	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}

	@Column(name = "PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "SEX")
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAMEH2")
	public String getNameh2() {
		return nameh2;
	}

	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}

	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	@Column(name = "METHOD")
	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	@Column(name = "OPS_DATE")
	public java.util.Date getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(java.util.Date opsDate) {
		this.opsDate = opsDate;
	}

	@Column(name = "IN_DATE")
	public java.util.Date getInDate() {
		return inDate;
	}

	public void setInDate(java.util.Date inDate) {
		this.inDate = inDate;
	}

	@Column(name = "IN_CAUSE")
	public Integer getInCause() {
		return inCause;
	}

	public void setInCause(Integer inCause) {
		this.inCause = inCause;
	}

	@Column(name = "CANCEL_DATE")
	public java.util.Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	@Column(name = "DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}

	@Column(name = "CANCEL_TYPE")
	public Integer getCancelType() {
		return cancelType;
	}

	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
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
	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	
	@Column(name = "IN_ADDRESS")
	public String getInAddress() {
		return inAddress;
	}

	public void setInAddress(String inAddress) {
		this.inAddress = inAddress;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}