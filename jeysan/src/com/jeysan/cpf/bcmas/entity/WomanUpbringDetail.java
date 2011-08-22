package com.jeysan.cpf.bcmas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_woman_upbring_detail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanUpbringDetail extends IdExtEntity {
	/**
	 * UPBRING_ID
	 */
	private WomanSocialUpbring upbring;
	/**
	 * 缴款序号
	 */
	private Integer counth;
	/**
	 * 本次应缴金额
	 */
	private Double moneyh;
	/**
	 * 实际缴纳金额
	 */
	private Double factMoney;
	/**
	 * 收款人
	 */
	private String charger;
	/**
	 * 交款日期
	 */
	private java.util.Date dateh;
	/**
	 * 收据编号
	 */
	private String voucherCode;

	@ManyToOne(optional = false)
	@JoinColumn(name = "UPBRING_ID")
	public WomanSocialUpbring getUpbring() {
		return upbring;
	}

	public void setUpbring(WomanSocialUpbring upbring) {
		this.upbring = upbring;
	}

	@Column(name = "COUNTH")
	public Integer getCounth() {
		return counth;
	}

	public void setCounth(Integer counth) {
		this.counth = counth;
	}

	@Column(name = "MONEYH")
	public Double getMoneyh() {
		return moneyh;
	}

	public void setMoneyh(Double moneyh) {
		this.moneyh = moneyh;
	}

	@Column(name = "CHARGER")
	public String getCharger() {
		return charger;
	}

	public void setCharger(String charger) {
		this.charger = charger;
	}

	@Column(name = "DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}

	@Column(name = "VOUCHER_CODE")
	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	
	
	@Column(name = "FACT_MONEY")
	public Double getFactMoney() {
		return factMoney;
	}

	public void setFactMoney(Double factMoney) {
		this.factMoney = factMoney;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}