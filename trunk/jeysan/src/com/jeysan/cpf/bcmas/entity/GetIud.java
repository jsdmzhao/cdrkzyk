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
@Table(name = "fhp_get_iud")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GetIud extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 取环类型
	 */
	private Integer typeh;
				/**
	 * 取环时间
	 */
	private java.util.Date dateh;
				/**
	 * 手术医院
	 */
	private String hospital;
				/**
	 * 手术医院类型
	 */
	private Integer hospitalType;
				/**
	 * 手术医院地址
	 */
	private String hospitalAddress;
				/**
	 * 手术人
	 */
	private String doctor;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="TYPEH")
	public Integer getTypeh() {
		return typeh;
	}
	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}
				@Column(name="DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}
	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
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
				@Column(name="HOSPITAL_ADDRESS")
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
				@Column(name="DOCTOR")
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}