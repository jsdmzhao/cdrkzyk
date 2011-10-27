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
@Table(name = "fhp_double_check_object")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DoubleCheckObject extends IdExtEntity {
	/**
	 * 轮次ID
	 */
	private Long dcId;
	/**
	 * 妇女ID
	 */
	private Long womanId;
	/**
	 * 是否个人
	 */
	private Integer issingle;
	/**
	 * 年度(主要针对个人)
	 */
	private Integer year;
	/**
	 * 本次双查总次数(主要针对个人)
	 */
	private Integer total;
	/**
	 * 轮次(主要针对个人)
	 */
	private Integer seq;
	/**
	 * 双查类型
	 */
	private Integer typeh;
	/**
	 * 双查类型原因
	 */
	private String cause;
	/**
	 * 双查起始年月(主要针对个人)
	 */
	private String start;
	/**
	 * 双查结束年月(主要针对个人)
	 */
	private String end;
	/**
	 * 双查状态
	 */
	private Integer dcStatus;
	/**
	 * 双查时间
	 */
	private java.util.Date dcDate;
	/**
	 * 查环结果
	 */
	private Integer dcResult1;
	/**
	 * 查孕结果
	 */
	private Integer dcResult2;
	/**
	 * 双查医院
	 */
	private String hospital;
	/**
	 * 医院类型
	 */
	private Integer hospitalType;
	/**
	 * 检查医生
	 */
	private String doctor;
	/**
	 * 备注
	 */
	private String remark;

	@Column(name = "DC_ID")
	public Long getDcId() {
		return dcId;
	}

	public void setDcId(Long dcId) {
		this.dcId = dcId;
	}

	@Column(name = "WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}

	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}

	@Column(name = "ISSINGLE")
	public Integer getIssingle() {
		return issingle;
	}

	public void setIssingle(Integer issingle) {
		this.issingle = issingle;
	}

	@Column(name = "YEAR")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(name = "TOTAL")
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Column(name = "SEQ")
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "TYPEH")
	public Integer getTypeh() {
		return typeh;
	}

	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}

	@Column(name = "CAUSE")
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Column(name = "START")
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "END")
	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Column(name = "DC_STATUS")
	public Integer getDcStatus() {
		return dcStatus;
	}

	public void setDcStatus(Integer dcStatus) {
		this.dcStatus = dcStatus;
	}

	@Column(name = "DC_DATE")
	public java.util.Date getDcDate() {
		return dcDate;
	}

	public void setDcDate(java.util.Date dcDate) {
		this.dcDate = dcDate;
	}

	@Column(name = "DC_RESULT1")
	public Integer getDcResult1() {
		return dcResult1;
	}

	public void setDcResult1(Integer dcResult1) {
		this.dcResult1 = dcResult1;
	}

	@Column(name = "DC_RESULT2")
	public Integer getDcResult2() {
		return dcResult2;
	}

	public void setDcResult2(Integer dcResult2) {
		this.dcResult2 = dcResult2;
	}

	@Column(name = "HOSPITAL")
	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Column(name = "HOSPITAL_TYPE")
	public Integer getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(Integer hospitalType) {
		this.hospitalType = hospitalType;
	}

	@Column(name = "DOCTOR")
	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
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