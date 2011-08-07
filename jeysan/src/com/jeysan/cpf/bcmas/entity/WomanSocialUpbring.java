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
@Table(name = "fhp_woman_social_upbring")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanSocialUpbring extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 征收原因
	 */
	private String cause;
				/**
	 * 政策外生育日期
	 */
	private java.util.Date outDate;
				/**
	 * 应交金额
	 */
	private Double totalMoney;
				/**
	 * 是否分期
	 */
	private Integer isInstallment;
				/**
	 * 缴交期限
	 */
	private java.util.Date endDate;
				/**
	 * 决定书编号
	 */
	private String lodCode;
				/**
	 * 决定书日期
	 */
	private java.util.Date lodDate;
				/**
	 * 征收机关
	 */
	private String lodOrg;
				/**
	 * 征收经办人
	 */
	private String lodCharger;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="CAUSE")
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
				@Column(name="OUT_DATE")
	public java.util.Date getOutDate() {
		return outDate;
	}
	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}
				@Column(name="TOTAL_MONEY")
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
				@Column(name="IS_INSTALLMENT")
	public Integer getIsInstallment() {
		return isInstallment;
	}
	public void setIsInstallment(Integer isInstallment) {
		this.isInstallment = isInstallment;
	}
				@Column(name="END_DATE")
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
				@Column(name="LOD_CODE")
	public String getLodCode() {
		return lodCode;
	}
	public void setLodCode(String lodCode) {
		this.lodCode = lodCode;
	}
				@Column(name="LOD_DATE")
	public java.util.Date getLodDate() {
		return lodDate;
	}
	public void setLodDate(java.util.Date lodDate) {
		this.lodDate = lodDate;
	}
				@Column(name="LOD_ORG")
	public String getLodOrg() {
		return lodOrg;
	}
	public void setLodOrg(String lodOrg) {
		this.lodOrg = lodOrg;
	}
				@Column(name="LOD_CHARGER")
	public String getLodCharger() {
		return lodCharger;
	}
	public void setLodCharger(String lodCharger) {
		this.lodCharger = lodCharger;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}