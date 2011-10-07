package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "fhp_first_child_reg")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FirstChildReg extends IdExtEntity {
	/**
	 * WOMAN_ID
	 */
	private FertileWoman fertileWoman;
	/**
	 * 登记日期
	 */
	private java.util.Date dateh;
	/**
	 * 是否再生一孩
	 */
	private Integer isSecond;
	/**
	 * 再生一孩条件
	 */
	private String cond;
	/**
	 * 部门意见
	 */
	private String deptOpt;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 合同签署日期
	 */
	private java.util.Date assignDate;
	/**
	 * 生育合同编号
	 */
	private String code;
	/**
	 * 一孩预产期
	 */
	private java.util.Date edd;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 孕产状态
	 */
	private Integer matenalStatus;

	@ManyToOne(optional = false)
	@JoinColumn(name = "WOMAN_ID")
	public FertileWoman getFertileWoman() {
		return fertileWoman;
	}

	public void setFertileWoman(FertileWoman fertileWoman) {
		this.fertileWoman = fertileWoman;
	}

	@Column(name = "DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}

	@Column(name = "IS_SECOND")
	public Integer getIsSecond() {
		return isSecond;
	}

	public void setIsSecond(Integer isSecond) {
		this.isSecond = isSecond;
	}

	@Column(name = "COND")
	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	@Column(name = "DEPT_OPT")
	public String getDeptOpt() {
		return deptOpt;
	}

	public void setDeptOpt(String deptOpt) {
		this.deptOpt = deptOpt;
	}

	@Column(name = "AGENT")
	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Column(name = "ASSIGN_DATE")
	public java.util.Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(java.util.Date assignDate) {
		this.assignDate = assignDate;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "EDD")
	public java.util.Date getEdd() {
		return edd;
	}

	public void setEdd(java.util.Date edd) {
		this.edd = edd;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Column(name = "MATENAL_STATUS")
	public Integer getMatenalStatus() {
		return matenalStatus;
	}

	public void setMatenalStatus(Integer matenalStatus) {
		this.matenalStatus = matenalStatus;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}