package com.jeysan.cpf.pmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "fhp_person_in")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PersonIn extends IdExtEntity {
	/**
	 * PERSON_ID
	 */
	private Person person;
	/**
	 * 流入原因
	 */
	private Integer inCause;
	/**
	 * 流入类型
	 */
	private Integer inType;
	/**
	 * 流入日期
	 */
	private java.util.Date inDate;
	/**
	 * 流入地编码
	 */
	private String inAddressCode;
	/**
	 * 流入地地址
	 */
	private String inAddress;
	/**
	 * 持证情况
	 */
	private Integer haveStatus;
	/**
	 * 夫妻是否共同流入
	 */
	private Integer isFamilyAllIn;
	/**
	 * SPOUSE_ID
	 */
	private Long spouseId;
	/**
	 * 配偶流入日期
	 */
	private java.util.Date spouseInDate;
	/**
	 * 配偶流出日期
	 */
	private java.util.Date spouseOutDate;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "IN_CAUSE")
	public Integer getInCause() {
		return inCause;
	}

	public void setInCause(Integer inCause) {
		this.inCause = inCause;
	}

	@Column(name = "IN_DATE")
	public java.util.Date getInDate() {
		return inDate;
	}

	public void setInDate(java.util.Date inDate) {
		this.inDate = inDate;
	}

	@Column(name = "IN_ADDRESS_CODE")
	public String getInAddressCode() {
		return inAddressCode;
	}

	public void setInAddressCode(String inAddressCode) {
		this.inAddressCode = inAddressCode;
	}

	@Column(name = "IN_ADDRESS")
	public String getInAddress() {
		return inAddress;
	}

	public void setInAddress(String inAddress) {
		this.inAddress = inAddress;
	}

	@Column(name = "HAVE_STATUS")
	public Integer getHaveStatus() {
		return haveStatus;
	}

	public void setHaveStatus(Integer haveStatus) {
		this.haveStatus = haveStatus;
	}

	@Column(name = "IS_FAMILY_ALL_IN")
	public Integer getIsFamilyAllIn() {
		return isFamilyAllIn;
	}

	public void setIsFamilyAllIn(Integer isFamilyAllIn) {
		this.isFamilyAllIn = isFamilyAllIn;
	}

	@Column(name = "SPOUSE_ID")
	public Long getSpouseId() {
		return spouseId;
	}

	public void setSpouseId(Long spouseId) {
		this.spouseId = spouseId;
	}

	@Column(name = "SPOUSE_IN_DATE")
	public java.util.Date getSpouseInDate() {
		return spouseInDate;
	}

	public void setSpouseInDate(java.util.Date spouseInDate) {
		this.spouseInDate = spouseInDate;
	}

	@Column(name = "SPOUSE_OUT_DATE")
	public java.util.Date getSpouseOutDate() {
		return spouseOutDate;
	}

	public void setSpouseOutDate(java.util.Date spouseOutDate) {
		this.spouseOutDate = spouseOutDate;
	}
	
	
	@Column(name = "IN_TYPE")
	public Integer getInType() {
		return inType;
	}

	public void setInType(Integer inType) {
		this.inType = inType;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}