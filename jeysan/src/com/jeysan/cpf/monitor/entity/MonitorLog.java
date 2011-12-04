package com.jeysan.cpf.monitor.entity;

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
@Table(name = "fhp_monitor_log")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonitorLog extends IdExtEntity {
	/**
	 * 操作时间
	 */
	private java.util.Date operatTime;
	/**
	 * 操作人
	 */
	private Integer operator;
	/**
	 * 操作人IP
	 */
	private String operatIp;
	/**
	 * 操作内容
	 */
	private String content;
	/**
	 * 持续时间(S)
	 */
	private Integer lastTime;
	/**
	 * 影响行数
	 */
	private Integer effectRows;

	@Column(name = "OPERAT_TIME")
	public java.util.Date getOperatTime() {
		return operatTime;
	}

	public void setOperatTime(java.util.Date operatTime) {
		this.operatTime = operatTime;
	}

	@Column(name = "OPERATOR")
	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	@Column(name = "OPERAT_IP")
	public String getOperatIp() {
		return operatIp;
	}

	public void setOperatIp(String operatIp) {
		this.operatIp = operatIp;
	}

	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "LAST_TIME")
	public Integer getLastTime() {
		return lastTime;
	}

	public void setLastTime(Integer lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "EFFECT_ROWS")
	public Integer getEffectRows() {
		return effectRows;
	}

	public void setEffectRows(Integer effectRows) {
		this.effectRows = effectRows;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}