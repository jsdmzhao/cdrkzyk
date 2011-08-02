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
@Table(name = "fhp_woman_upbring_detail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanUpbringDetail extends IdEntity {
						/**
	 * UPBRING_ID
	 */
	private Long upbringId;
				/**
	 * 缴款序号
	 */
	private Integer count;
				/**
	 * 本次应缴金额
	 */
	private Double moneyh;
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
			
						@Column(name="UPBRING_ID")
	public Long getUpbringId() {
		return upbringId;
	}
	public void setUpbringId(Long upbringId) {
		this.upbringId = upbringId;
	}
				@Column(name="COUNT")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
				@Column(name="MONEYH")
	public Double getMoneyh() {
		return moneyh;
	}
	public void setMoneyh(Double moneyh) {
		this.moneyh = moneyh;
	}
				@Column(name="CHARGER")
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
	}
				@Column(name="DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}
	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}
				@Column(name="VOUCHER_CODE")
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}