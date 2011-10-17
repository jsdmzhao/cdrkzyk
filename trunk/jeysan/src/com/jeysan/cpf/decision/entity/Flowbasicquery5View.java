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
@Table(name = "fhp_flowbasicquery5_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery5View extends IdExtEntity {
	/**
	 * 流动人员编码
	 */
	private String personCode;
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 证件号码
	 */
	private String code;
	/**
	 * 流入日期
	 */
	private java.util.Date settleInDate;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 居住度
	 */
	private String address;
	/**
	 * 怀孕原因
	 */
	private String conceptCause;
	/**
	 * 变化如期
	 */
	private java.util.Date changeDate;
	/**
	 * 孕产结果
	 */
	private String matenalResult;
	/**
	 * 手术日期
	 */
	private java.util.Date endDate;
	/**
	 * 怀孕日期
	 */
	private java.util.Date conceptDate;
	/**
	 * 现孕状态
	 */
	private Integer currentConceptStatus;
	/**
	 * 流出日期
	 */
	private java.util.Date outDate;
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 户口类别
	 */
	private Integer domicileType;

	@Column(name = "PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
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

	@Column(name = "CONCEPT_CAUSE")
	public String getConceptCause() {
		return conceptCause;
	}

	public void setConceptCause(String conceptCause) {
		this.conceptCause = conceptCause;
	}

	@Column(name = "CHANGE_DATE")
	public java.util.Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(java.util.Date changeDate) {
		this.changeDate = changeDate;
	}

	@Column(name = "MATENAL_RESULT")
	public String getMatenalResult() {
		return matenalResult;
	}

	public void setMatenalResult(String matenalResult) {
		this.matenalResult = matenalResult;
	}

	@Column(name = "END_DATE")
	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "CURRENT_CONCEPT_STATUS")
	public Integer getCurrentConceptStatus() {
		return currentConceptStatus;
	}

	public void setCurrentConceptStatus(Integer currentConceptStatus) {
		this.currentConceptStatus = currentConceptStatus;
	}

	@Column(name = "OUT_DATE")
	public java.util.Date getOutDate() {
		return outDate;
	}

	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
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
	
	@Column(name = "CONCEPT_DATE")
	public java.util.Date getConceptDate() {
		return conceptDate;
	}

	public void setConceptDate(java.util.Date conceptDate) {
		this.conceptDate = conceptDate;
	}
	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}