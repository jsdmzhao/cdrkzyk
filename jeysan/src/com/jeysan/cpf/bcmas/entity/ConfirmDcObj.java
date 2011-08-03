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
@Table(name = "fhp_confirm_dc_obj")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ConfirmDcObj extends IdEntity {
						/**
	 * 轮次ID
	 */
	private Long detailId;
				/**
	 * 对象种类
	 */
	private Integer objType;
				/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 双查情况
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
			
						@Column(name="DETAIL_ID")
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
				@Column(name="OBJ_TYPE")
	public Integer getObjType() {
		return objType;
	}
	public void setObjType(Integer objType) {
		this.objType = objType;
	}
				@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="DC_STATUS")
	public Integer getDcStatus() {
		return dcStatus;
	}
	public void setDcStatus(Integer dcStatus) {
		this.dcStatus = dcStatus;
	}
				@Column(name="DC_DATE")
	public java.util.Date getDcDate() {
		return dcDate;
	}
	public void setDcDate(java.util.Date dcDate) {
		this.dcDate = dcDate;
	}
				@Column(name="DC_RESULT1")
	public Integer getDcResult1() {
		return dcResult1;
	}
	public void setDcResult1(Integer dcResult1) {
		this.dcResult1 = dcResult1;
	}
				@Column(name="DC_RESULT2")
	public Integer getDcResult2() {
		return dcResult2;
	}
	public void setDcResult2(Integer dcResult2) {
		this.dcResult2 = dcResult2;
	}
				@Column(name="HOSPITAL")
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
				@Column(name="HOSPITAL_TYPE")
	public Integer getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(Integer hospitalType) {
		this.hospitalType = hospitalType;
	}
				@Column(name="DOCTOR")
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
				@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}