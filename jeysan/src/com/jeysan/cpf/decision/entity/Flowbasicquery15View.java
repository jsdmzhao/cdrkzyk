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
@Table(name = "fhp_flowbasicquery15_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery15View extends IdExtEntity {
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
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
	 * 流入日期
	 */
	private java.util.Date settleInDate;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 流出地址
	 */
	private String outAddress;
	/**
	 * 流出日期
	 */
	private java.util.Date outDate;
	/**
	 * 流出类别
	 */
	private Integer outType;
	/**
	 * 流出原因
	 */
	private Integer outCause;
	/**
	 * 注销日期
	 */
	private java.util.Date cancelDate;
	/**
	 * 注销类别
	 */
	private Integer cancelType;
	/**
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 居住地
	 */
	private String address;
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	 * 流入地
	 */
	private String inAddress;

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

	@Column(name = "SETTLE_IN_DATE")
	public java.util.Date getSettleInDate() {
		return settleInDate;
	}

	public void setSettleInDate(java.util.Date settleInDate) {
		this.settleInDate = settleInDate;
	}

	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	@Column(name = "OUT_ADDRESS")
	public String getOutAddress() {
		return outAddress;
	}

	public void setOutAddress(String outAddress) {
		this.outAddress = outAddress;
	}

	@Column(name = "OUT_DATE")
	public java.util.Date getOutDate() {
		return outDate;
	}

	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}

	@Column(name = "OUT_TYPE")
	public Integer getOutType() {
		return outType;
	}

	public void setOutType(Integer outType) {
		this.outType = outType;
	}

	@Column(name = "OUT_CAUSE")
	public Integer getOutCause() {
		return outCause;
	}

	public void setOutCause(Integer outCause) {
		this.outCause = outCause;
	}

	@Column(name = "CANCEL_DATE")
	public java.util.Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
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