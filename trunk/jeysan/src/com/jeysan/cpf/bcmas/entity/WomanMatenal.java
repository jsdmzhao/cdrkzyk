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
@Table(name = "fhp_woman_matenal")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanMatenal extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 怀孕政策属性
	 */
	private Integer conceptPolicy;
				/**
	 * 怀孕日期
	 */
	private java.util.Date conceptDate;
				/**
	 * 怀孕原因
	 */
	private String conceptCause;
				/**
	 * 怀孕结果
	 */
	private String conceptResult;
				/**
	 * 预产期
	 */
	private java.util.Date edd;
				/**
	 * 妇女生产方式
	 */
	private Integer typeh;
				/**
	 * 手术医院地址
	 */
	private String hospitalAddress;
				/**
	 * 孕产结果
	 */
	private String matenalResult;
				/**
	 * 手术日期
	 */
	private java.util.Date endDate;
				/**
	 * 手术医院
	 */
	private String hospital;
				/**
	 * 手术医生
	 */
	private String doctor;
				/**
	 * 手术医院类型
	 */
	private Integer hospitalType;
				/**
	 * 变化日期
	 */
	private java.util.Date changeDate;
				/**
	 * 变化原因
	 */
	private String changeCause;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="CONCEPT_POLICY")
	public Integer getConceptPolicy() {
		return conceptPolicy;
	}
	public void setConceptPolicy(Integer conceptPolicy) {
		this.conceptPolicy = conceptPolicy;
	}
				@Column(name="CONCEPT_DATE")
	public java.util.Date getConceptDate() {
		return conceptDate;
	}
	public void setConceptDate(java.util.Date conceptDate) {
		this.conceptDate = conceptDate;
	}
				@Column(name="CONCEPT_CAUSE")
	public String getConceptCause() {
		return conceptCause;
	}
	public void setConceptCause(String conceptCause) {
		this.conceptCause = conceptCause;
	}
				@Column(name="CONCEPT_RESULT")
	public String getConceptResult() {
		return conceptResult;
	}
	public void setConceptResult(String conceptResult) {
		this.conceptResult = conceptResult;
	}
				@Column(name="EDD")
	public java.util.Date getEdd() {
		return edd;
	}
	public void setEdd(java.util.Date edd) {
		this.edd = edd;
	}
				@Column(name="TYPEH")
	public Integer getTypeh() {
		return typeh;
	}
	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}
				@Column(name="HOSPITAL_ADDRESS")
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
				@Column(name="MATENAL_RESULT")
	public String getMatenalResult() {
		return matenalResult;
	}
	public void setMatenalResult(String matenalResult) {
		this.matenalResult = matenalResult;
	}
				@Column(name="END_DATE")
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
				@Column(name="HOSPITAL")
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
				@Column(name="DOCTOR")
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
				@Column(name="HOSPITAL_TYPE")
	public Integer getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(Integer hospitalType) {
		this.hospitalType = hospitalType;
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
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}