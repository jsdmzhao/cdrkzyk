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
@Table(name = "fhp_woman_punish")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanPunish extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 处罚日期
	 */
	private java.util.Date punishDate;
				/**
	 * 处罚原因
	 */
	private String punishCause;
				/**
	 * 处罚经办人
	 */
	private String agent;
				/**
	 * 处罚金额
	 */
	private Double moneyh;
				/**
	 * 处罚次数
	 */
	private Integer count;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="PUNISH_DATE")
	public java.util.Date getPunishDate() {
		return punishDate;
	}
	public void setPunishDate(java.util.Date punishDate) {
		this.punishDate = punishDate;
	}
				@Column(name="PUNISH_CAUSE")
	public String getPunishCause() {
		return punishCause;
	}
	public void setPunishCause(String punishCause) {
		this.punishCause = punishCause;
	}
				@Column(name="AGENT")
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
				@Column(name="MONEYH")
	public Double getMoneyh() {
		return moneyh;
	}
	public void setMoneyh(Double moneyh) {
		this.moneyh = moneyh;
	}
				@Column(name="COUNT")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}