package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_birth2_check")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Birth2Check extends IdExtEntity {
	/**
	 * APPLY_ID
	 */
	private Birth2Apply birth2Apply;
	/**
	 * 审批结果
	 */
	private Integer isAgree;
	/**
	 * 是否签订生育合同
	 */
	private Integer isAssign;
	/**
	 * 生育合同日期
	 */
	private java.util.Date dateh;
	/**
	 * 生育合同编号
	 */
	private String code;
	/**
	 * 二孩计划日期
	 */
	private java.util.Date edd;
	/**
	 * 部门意见
	 */
	private String deptOpt;
	/**
	 * 审批人
	 */
	private String checkor;
	/**
	 * 审批日期
	 */
	private java.util.Date checkDate;
	/**
	 * 备注
	 */
	private String remark;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="APPLY_ID")
	public Birth2Apply getBirth2Apply() {
		return birth2Apply;
	}

	public void setBirth2Apply(Birth2Apply birth2Apply) {
		this.birth2Apply = birth2Apply;
	}

	@Column(name = "IS_AGREE")
	public Integer getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}

	@Column(name = "IS_ASSIGN")
	public Integer getIsAssign() {
		return isAssign;
	}

	public void setIsAssign(Integer isAssign) {
		this.isAssign = isAssign;
	}

	@Column(name = "DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
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

	@Column(name = "DEPT_OPT")
	public String getDeptOpt() {
		return deptOpt;
	}

	public void setDeptOpt(String deptOpt) {
		this.deptOpt = deptOpt;
	}

	@Column(name = "CHECKOR")
	public String getCheckor() {
		return checkor;
	}

	public void setCheckor(String checkor) {
		this.checkor = checkor;
	}

	@Column(name = "CHECK_DATE")
	public java.util.Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}