package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_lost_reg")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LostReg extends IdEntity {
						/**
	 * 轮次ID
	 */
	private Long detailId;
				/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 漏查处理情况
	 */
	private Integer ldwStatus;
				/**
	 * 处理措施
	 */
	private String ldwContent;
				/**
	 * 处理时间
	 */
	private java.util.Date ldwDate;
				/**
	 * 违约金
	 */
	private Double moneyh;
				/**
	 * 交款日期
	 */
	private java.util.Date payDate;
				/**
	 * 收款人
	 */
	private String cashier;
			
						@Column(name="DETAIL_ID")
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
				@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="LDW_STATUS")
	public Integer getLdwStatus() {
		return ldwStatus;
	}
	public void setLdwStatus(Integer ldwStatus) {
		this.ldwStatus = ldwStatus;
	}
				@Column(name="LDW_CONTENT")
	public String getLdwContent() {
		return ldwContent;
	}
	public void setLdwContent(String ldwContent) {
		this.ldwContent = ldwContent;
	}
				@Column(name="LDW_DATE")
	public java.util.Date getLdwDate() {
		return ldwDate;
	}
	public void setLdwDate(java.util.Date ldwDate) {
		this.ldwDate = ldwDate;
	}
				@Column(name="MONEYH")
	public Double getMoneyh() {
		return moneyh;
	}
	public void setMoneyh(Double moneyh) {
		this.moneyh = moneyh;
	}
				@Column(name="PAY_DATE")
	public java.util.Date getPayDate() {
		return payDate;
	}
	public void setPayDate(java.util.Date payDate) {
		this.payDate = payDate;
	}
				@Column(name="CASHIER")
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}