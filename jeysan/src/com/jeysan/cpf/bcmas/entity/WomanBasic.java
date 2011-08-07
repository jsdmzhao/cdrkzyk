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
@Table(name = "fhp_woman_basic")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanBasic extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 婚姻状态
	 */
	private Integer marryStatus;
				/**
	 * 夫婚姻状态
	 */
	private Integer spouseMarryStatus;
				/**
	 * 初婚日期
	 */
	private java.util.Date firstMarryDate;
				/**
	 * 婚变日期
	 */
	private java.util.Date marryCryDate;
				/**
	 * 领光荣证日期
	 */
	private java.util.Date getGrzDate;
				/**
	 * 安排二孩原因
	 */
	private String planChild2Cause;
				/**
	 * 安排二孩日期
	 */
	private java.util.Date planChild2Date;
				/**
	 * 安排再生原因
	 */
	private String planBear2Cause;
				/**
	 * 安排再生日期
	 */
	private java.util.Date planBear2Date;
				/**
	 * 领流动证类型
	 */
	private Integer getLdzType;
				/**
	 * 领流动证日期
	 */
	private java.util.Date getLdzDate;
				/**
	 * 健康状况
	 */
	private Integer healthStatus;
				/**
	 * 注销类型
	 */
	private Integer cancelType;
				/**
	 * 注销日期
	 */
	private java.util.Date cancelDate;
				/**
	 * 备注
	 */
	private String remark;
				/**
	 * 计生证明号
	 */
	private String certCode;
				/**
	 * 计生证有效期
	 */
	private java.util.Date certDate;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}
	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}
				@Column(name="SPOUSE_MARRY_STATUS")
	public Integer getSpouseMarryStatus() {
		return spouseMarryStatus;
	}
	public void setSpouseMarryStatus(Integer spouseMarryStatus) {
		this.spouseMarryStatus = spouseMarryStatus;
	}
				@Column(name="FIRST_MARRY_DATE")
	public java.util.Date getFirstMarryDate() {
		return firstMarryDate;
	}
	public void setFirstMarryDate(java.util.Date firstMarryDate) {
		this.firstMarryDate = firstMarryDate;
	}
				@Column(name="MARRY_CRY_DATE")
	public java.util.Date getMarryCryDate() {
		return marryCryDate;
	}
	public void setMarryCryDate(java.util.Date marryCryDate) {
		this.marryCryDate = marryCryDate;
	}
				@Column(name="GET_GRZ_DATE")
	public java.util.Date getGetGrzDate() {
		return getGrzDate;
	}
	public void setGetGrzDate(java.util.Date getGrzDate) {
		this.getGrzDate = getGrzDate;
	}
				@Column(name="PLAN_CHILD2_CAUSE")
	public String getPlanChild2Cause() {
		return planChild2Cause;
	}
	public void setPlanChild2Cause(String planChild2Cause) {
		this.planChild2Cause = planChild2Cause;
	}
				@Column(name="PLAN_CHILD2_DATE")
	public java.util.Date getPlanChild2Date() {
		return planChild2Date;
	}
	public void setPlanChild2Date(java.util.Date planChild2Date) {
		this.planChild2Date = planChild2Date;
	}
				@Column(name="PLAN_BEAR2_CAUSE")
	public String getPlanBear2Cause() {
		return planBear2Cause;
	}
	public void setPlanBear2Cause(String planBear2Cause) {
		this.planBear2Cause = planBear2Cause;
	}
				@Column(name="PLAN_BEAR2_DATE")
	public java.util.Date getPlanBear2Date() {
		return planBear2Date;
	}
	public void setPlanBear2Date(java.util.Date planBear2Date) {
		this.planBear2Date = planBear2Date;
	}
				@Column(name="GET_LDZ_TYPE")
	public Integer getGetLdzType() {
		return getLdzType;
	}
	public void setGetLdzType(Integer getLdzType) {
		this.getLdzType = getLdzType;
	}
				@Column(name="GET_LDZ_DATE")
	public java.util.Date getGetLdzDate() {
		return getLdzDate;
	}
	public void setGetLdzDate(java.util.Date getLdzDate) {
		this.getLdzDate = getLdzDate;
	}
				@Column(name="HEALTH_STATUS")
	public Integer getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(Integer healthStatus) {
		this.healthStatus = healthStatus;
	}
				@Column(name="CANCEL_TYPE")
	public Integer getCancelType() {
		return cancelType;
	}
	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
	}
				@Column(name="CANCEL_DATE")
	public java.util.Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}
				@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
				@Column(name="CERT_CODE")
	public String getCertCode() {
		return certCode;
	}
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
				@Column(name="CERT_DATE")
	public java.util.Date getCertDate() {
		return certDate;
	}
	public void setCertDate(java.util.Date certDate) {
		this.certDate = certDate;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}