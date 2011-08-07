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
@Table(name = "fhp_woman_bear_assurance")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanBearAssurance extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 投保类型
	 */
	private String typeh;
				/**
	 * 投保年月
	 */
	private String dateh;
				/**
	 * 投保金额
	 */
	private Double moneyh;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="TYPEH")
	public String getTypeh() {
		return typeh;
	}
	public void setTypeh(String typeh) {
		this.typeh = typeh;
	}
				@Column(name="DATEH")
	public String getDateh() {
		return dateh;
	}
	public void setDateh(String dateh) {
		this.dateh = dateh;
	}
				@Column(name="MONEYH")
	public Double getMoneyh() {
		return moneyh;
	}
	public void setMoneyh(Double moneyh) {
		this.moneyh = moneyh;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}