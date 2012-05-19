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
@Table(name = "fhp_monitor_workload")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonitorWorkload extends IdExtEntity {
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
	 * 工作类别
	 */
	private Integer workType;
	/**
	 * 工作量
	 */
	private Integer workLoad;
	/**
	 * 操作类型
	 */
	private Integer operatType;
	/**
	 * 所属区域
	 */
	private String orgCode;

	private String remark;

	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

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

	@Column(name = "WORK_TYPE")
	public Integer getWorkType() {
		return workType;
	}

	public void setWorkType(Integer workType) {
		this.workType = workType;
	}

	@Column(name = "WORK_LOAD")
	public Integer getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(Integer workLoad) {
		this.workLoad = workLoad;
	}

	@Column(name = "OPERAT_TYPE")
	public Integer getOperatType() {
		return operatType;
	}

	public void setOperatType(Integer operatType) {
		this.operatType = operatType;
	}

	@Column(name = "ORG_CODE")
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}