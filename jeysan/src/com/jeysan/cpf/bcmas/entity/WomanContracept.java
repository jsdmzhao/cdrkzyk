package com.jeysan.cpf.bcmas.entity;

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
@Table(name = "fhp_woman_contracept")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanContracept extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 避孕节育措施
	 */
	private Integer method;
				/**
	 * 手术医院类型
	 */
	private Integer hospitalType;
				/**
	 * 手术医生
	 */
	private String doctor;
				/**
	 * 手术医院
	 */
	private String hospital;
				/**
	 * 手术日期
	 */
	private java.util.Date opsDate;
				/**
	 * 手术医院地址
	 */
	private String hospitalAddress;
				/**
	 * 未避孕原因
	 */
	private String noCause;
				/**
	 * 避孕终止日期
	 */
	private java.util.Date endDate;
				/**
	 * 变化日期
	 */
	private java.util.Date changeDate;
				/**
	 * 变化原因
	 */
	private String changeCause;
				/**
	 * 缓期原因
	 */
	private String delayCause;
				/**
	 * 缓期终止日期
	 */
	private java.util.Date delayEndCause;
				/**
	 * 缓期鉴定单位
	 */
	private String delayCompany;
				/**
	 * 缓期鉴定医生
	 */
	private String delayDoctor;
				/**
	 * 缓期鉴定日期
	 */
	private java.util.Date delayDate;
				/**
	 * 登记日期
	 */
	private java.util.Date regDate;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="METHOD")
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
				@Column(name="HOSPITAL_TYPE")
	public Integer getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(Integer hospitalType) {
		this.hospitalType = hospitalType;
	}
				@Column(name="DOCTOR")
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
				@Column(name="HOSPITAL")
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
				@Column(name="OPS_DATE")
	public java.util.Date getOpsDate() {
		return opsDate;
	}
	public void setOpsDate(java.util.Date opsDate) {
		this.opsDate = opsDate;
	}
				@Column(name="HOSPITAL_ADDRESS")
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
				@Column(name="NO_CAUSE")
	public String getNoCause() {
		return noCause;
	}
	public void setNoCause(String noCause) {
		this.noCause = noCause;
	}
				@Column(name="END_DATE")
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
				@Column(name="CHANGE_DATE")
	public java.util.Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(java.util.Date changeDate) {
		this.changeDate = changeDate;
	}
				@Column(name="CHANGE_CAUSE")
	public String getChangeCause() {
		return changeCause;
	}
	public void setChangeCause(String changeCause) {
		this.changeCause = changeCause;
	}
				@Column(name="DELAY_CAUSE")
	public String getDelayCause() {
		return delayCause;
	}
	public void setDelayCause(String delayCause) {
		this.delayCause = delayCause;
	}
				@Column(name="DELAY_END_CAUSE")
	public java.util.Date getDelayEndCause() {
		return delayEndCause;
	}
	public void setDelayEndCause(java.util.Date delayEndCause) {
		this.delayEndCause = delayEndCause;
	}
				@Column(name="DELAY_COMPANY")
	public String getDelayCompany() {
		return delayCompany;
	}
	public void setDelayCompany(String delayCompany) {
		this.delayCompany = delayCompany;
	}
				@Column(name="DELAY_DOCTOR")
	public String getDelayDoctor() {
		return delayDoctor;
	}
	public void setDelayDoctor(String delayDoctor) {
		this.delayDoctor = delayDoctor;
	}
				@Column(name="DELAY_DATE")
	public java.util.Date getDelayDate() {
		return delayDate;
	}
	public void setDelayDate(java.util.Date delayDate) {
		this.delayDate = delayDate;
	}
				@Column(name="REG_DATE")
	public java.util.Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}