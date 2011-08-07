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
@Table(name = "fhp_assurance")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Assurance extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 保险类型
	 */
	private Integer assType;
				/**
	 * 投保情况
	 */
	private Integer assStatus;
				/**
	 * 投保类型
	 */
	private Integer assKind;
				/**
	 * 投保日期
	 */
	private java.util.Date assDate;
				/**
	 * 被保险人
	 */
	private String insured;
				/**
	 * 投保人
	 */
	private String applicant;
				/**
	 * 保险收益人
	 */
	private String insurant;
				/**
	 * 投保金额
	 */
	private Double insuredAmount;
				/**
	 * 收款人
	 */
	private String cashier;
				/**
	 * 取消保险日期
	 */
	private java.util.Date cancelDate;
				/**
	 * 取消保险原因
	 */
	private String cancelCause;
				/**
	 * 退还金额
	 */
	private Double returnAmount;
				/**
	 * 退款人
	 */
	private String returner;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="ASS_TYPE")
	public Integer getAssType() {
		return assType;
	}
	public void setAssType(Integer assType) {
		this.assType = assType;
	}
				@Column(name="ASS_STATUS")
	public Integer getAssStatus() {
		return assStatus;
	}
	public void setAssStatus(Integer assStatus) {
		this.assStatus = assStatus;
	}
				@Column(name="ASS_KIND")
	public Integer getAssKind() {
		return assKind;
	}
	public void setAssKind(Integer assKind) {
		this.assKind = assKind;
	}
				@Column(name="ASS_DATE")
	public java.util.Date getAssDate() {
		return assDate;
	}
	public void setAssDate(java.util.Date assDate) {
		this.assDate = assDate;
	}
				@Column(name="INSURED")
	public String getInsured() {
		return insured;
	}
	public void setInsured(String insured) {
		this.insured = insured;
	}
				@Column(name="APPLICANT")
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
				@Column(name="INSURANT")
	public String getInsurant() {
		return insurant;
	}
	public void setInsurant(String insurant) {
		this.insurant = insurant;
	}
				@Column(name="INSURED_AMOUNT")
	public Double getInsuredAmount() {
		return insuredAmount;
	}
	public void setInsuredAmount(Double insuredAmount) {
		this.insuredAmount = insuredAmount;
	}
				@Column(name="CASHIER")
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
				@Column(name="CANCEL_DATE")
	public java.util.Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}
				@Column(name="CANCEL_CAUSE")
	public String getCancelCause() {
		return cancelCause;
	}
	public void setCancelCause(String cancelCause) {
		this.cancelCause = cancelCause;
	}
				@Column(name="RETURN_AMOUNT")
	public Double getReturnAmount() {
		return returnAmount;
	}
	public void setReturnAmount(Double returnAmount) {
		this.returnAmount = returnAmount;
	}
				@Column(name="RETURNER")
	public String getReturner() {
		return returner;
	}
	public void setReturner(String returner) {
		this.returner = returner;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}