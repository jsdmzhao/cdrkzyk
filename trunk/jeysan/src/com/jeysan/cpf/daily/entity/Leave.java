package com.jeysan.cpf.daily.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.workflow.Id4WfEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "js_daily_leave")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Leave extends Id4WfEntity {
	/**
	 * LEAVE_NO
	 */
	private String leaveNo;
	/**
	 * LEAVE_EMPLOYEE_ID
	 */
	private Integer leaveEmployeeId;
	/**
	 * DATE_KT
	 */
	private java.util.Date dateKt;
	/**
	 * LEAVE_CAUSE
	 */
	private String leaveCause;
	/**
	 * LEAVE_START
	 */
	private java.util.Date leaveStart;
	/**
	 * LEAVE_END
	 */
	private java.util.Date leaveEnd;
	/**
	 * LEAVE_COUNT
	 */
	private Integer leaveCount;
	/**
	 * REMARK
	 */
	private String remark;
	/**
	 * DEPTOR
	 */
	private Integer deptor;
	/**
	 * DEPTOR_DATE
	 */
	private java.util.Date deptorDate;
	/**
	 * DEPTOR_CHECK
	 */
	private Integer deptorCheck;
	/**
	 * DEPTOR_OPINION
	 */
	private String deptorOpinion;
	/**
	 * BOSS_CHECK
	 */
	private Integer bossCheck;
	/**
	 * BOSS
	 */
	private Integer boss;
	/**
	 * BOSS_DATE
	 */
	private java.util.Date bossDate;
	/**
	 * BOSS_OPINION
	 */
	private String bossOpinion;

	@Column(name = "LEAVE_NO")
	public String getLeaveNo() {
		return leaveNo;
	}

	public void setLeaveNo(String leaveNo) {
		this.leaveNo = leaveNo;
	}

	@Column(name = "LEAVE_EMPLOYEE_ID")
	public Integer getLeaveEmployeeId() {
		return leaveEmployeeId;
	}

	public void setLeaveEmployeeId(Integer leaveEmployeeId) {
		this.leaveEmployeeId = leaveEmployeeId;
	}

	@Column(name = "DATE_KT")
	public java.util.Date getDateKt() {
		return dateKt;
	}

	public void setDateKt(java.util.Date dateKt) {
		this.dateKt = dateKt;
	}

	@Column(name = "LEAVE_CAUSE")
	public String getLeaveCause() {
		return leaveCause;
	}

	public void setLeaveCause(String leaveCause) {
		this.leaveCause = leaveCause;
	}

	@Column(name = "LEAVE_START")
	public java.util.Date getLeaveStart() {
		return leaveStart;
	}

	public void setLeaveStart(java.util.Date leaveStart) {
		this.leaveStart = leaveStart;
	}

	@Column(name = "LEAVE_END")
	public java.util.Date getLeaveEnd() {
		return leaveEnd;
	}

	public void setLeaveEnd(java.util.Date leaveEnd) {
		this.leaveEnd = leaveEnd;
	}

	@Column(name = "LEAVE_COUNT")
	public Integer getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(Integer leaveCount) {
		this.leaveCount = leaveCount;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "DEPTOR_CHECK")
	public Integer getDeptorCheck() {
		return deptorCheck;
	}

	public void setDeptorCheck(Integer deptorCheck) {
		this.deptorCheck = deptorCheck;
	}

	@Column(name = "DEPTOR_OPINION")
	public String getDeptorOpinion() {
		return deptorOpinion;
	}

	public void setDeptorOpinion(String deptorOpinion) {
		this.deptorOpinion = deptorOpinion;
	}

	@Column(name = "BOSS_CHECK")
	public Integer getBossCheck() {
		return bossCheck;
	}

	public void setBossCheck(Integer bossCheck) {
		this.bossCheck = bossCheck;
	}

	@Column(name = "BOSS_OPINION")
	public String getBossOpinion() {
		return bossOpinion;
	}

	public void setBossOpinion(String bossOpinion) {
		this.bossOpinion = bossOpinion;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
	@Column(name = "DEPTOR")
	public Integer getDeptor() {
		return deptor;
	}

	public void setDeptor(Integer deptor) {
		this.deptor = deptor;
	}
	@Column(name = "BOSS")
	public Integer getBoss() {
		return boss;
	}

	public void setBoss(Integer boss) {
		this.boss = boss;
	}
	@Column(name = "DEPTOR_DATE")
	public java.util.Date getDeptorDate() {
		return deptorDate;
	}

	public void setDeptorDate(java.util.Date deptorDate) {
		this.deptorDate = deptorDate;
	}
	@Column(name = "BOSS_DATE")
	public java.util.Date getBossDate() {
		return bossDate;
	}

	public void setBossDate(java.util.Date bossDate) {
		this.bossDate = bossDate;
	}
	
	
}