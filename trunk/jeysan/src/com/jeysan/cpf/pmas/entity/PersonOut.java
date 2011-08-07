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
@Table(name = "fhp_person_out")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PersonOut extends IdExtEntity {
	/**
	 * PERSON_ID
	 */
	private Person person;
	/**
	 * 流出原因
	 */
	private Integer outCause;
	/**
	 * 流出类型
	 */
	private Integer outType;
	/**
	 * 流出地编码
	 */
	private String outAddressCode;
	/**
	 * 流出地地址
	 */
	private String outAddress;
	/**
	 * 流出日期
	 */
	private java.util.Date outDate;
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
	 * 夫妻是否共同流出
	 */
	private Integer isFamilyAllOut;
	/**
	 * 备注
	 */
	private String remark;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "OUT_CAUSE")
	public Integer getOutCause() {
		return outCause;
	}

	public void setOutCause(Integer outCause) {
		this.outCause = outCause;
	}

	@Column(name = "OUT_ADDRESS_CODE")
	public String getOutAddressCode() {
		return outAddressCode;
	}

	public void setOutAddressCode(String outAddressCode) {
		this.outAddressCode = outAddressCode;
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

	@Column(name = "IS_FAMILY_ALL_OUT")
	public Integer getIsFamilyAllOut() {
		return isFamilyAllOut;
	}

	public void setIsFamilyAllOut(Integer isFamilyAllOut) {
		this.isFamilyAllOut = isFamilyAllOut;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "OUT_TYPE")
	public Integer getOutType() {
		return outType;
	}

	public void setOutType(Integer outType) {
		this.outType = outType;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}