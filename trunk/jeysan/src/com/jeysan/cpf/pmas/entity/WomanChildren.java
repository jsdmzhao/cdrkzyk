package com.jeysan.cpf.pmas.entity;

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
@Table(name = "fhp_woman_children")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanChildren extends IdExtEntity {
	/**
	 * 人员ID
	 */
	private Person person;
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 出生地点
	 */
	private String birthAddress;
	/**
	 * 政策内外
	 */
	private Integer policy;
	/**
	 * 政策外类型
	 */
	private Integer outType;
	/**
	 * 孩次
	 */
	private Integer childIndex;
	/**
	 * 出生证号
	 */
	private String birthCert;
	/**
	 * 健康状况
	 */
	private Integer healthStatus;
	/**
	 * 血缘关系
	 */
	private String kinship;
	/**
	 * 变化日期
	 */
	private java.util.Date changeDate;
	/**
	 * 变化原因
	 */
	private String changeCause;
	/**
	 * 出生医院名称
	 */
	private String hospital;
	/**
	 * 出生医院类型
	 */
	private Integer hospitalType;
	/**
	 * 收养日期
	 */
	private java.util.Date adoptDate;
	/**
	 * 收养证号
	 */
	private String adoptCept;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}

	@Column(name = "SEX")
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "BIRTH_ADDRESS")
	public String getBirthAddress() {
		return birthAddress;
	}

	public void setBirthAddress(String birthAddress) {
		this.birthAddress = birthAddress;
	}

	@Column(name = "POLICY")
	public Integer getPolicy() {
		return policy;
	}

	public void setPolicy(Integer policy) {
		this.policy = policy;
	}

	@Column(name = "OUT_TYPE")
	public Integer getOutType() {
		return outType;
	}

	public void setOutType(Integer outType) {
		this.outType = outType;
	}

	@Column(name = "CHILD_INDEX")
	public Integer getChildIndex() {
		return childIndex;
	}

	public void setChildIndex(Integer childIndex) {
		this.childIndex = childIndex;
	}

	@Column(name = "BIRTH_CERT")
	public String getBirthCert() {
		return birthCert;
	}

	public void setBirthCert(String birthCert) {
		this.birthCert = birthCert;
	}

	@Column(name = "HEALTH_STATUS")
	public Integer getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(Integer healthStatus) {
		this.healthStatus = healthStatus;
	}

	@Column(name = "KINSHIP")
	public String getKinship() {
		return kinship;
	}

	public void setKinship(String kinship) {
		this.kinship = kinship;
	}

	@Column(name = "CHANGE_DATE")
	public java.util.Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(java.util.Date changeDate) {
		this.changeDate = changeDate;
	}

	@Column(name = "CHANGE_CAUSE")
	public String getChangeCause() {
		return changeCause;
	}

	public void setChangeCause(String changeCause) {
		this.changeCause = changeCause;
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

	@Column(name = "ADOPT_DATE")
	public java.util.Date getAdoptDate() {
		return adoptDate;
	}

	public void setAdoptDate(java.util.Date adoptDate) {
		this.adoptDate = adoptDate;
	}

	@Column(name = "ADOPT_CEPT")
	public String getAdoptCept() {
		return adoptCept;
	}

	public void setAdoptCept(String adoptCept) {
		this.adoptCept = adoptCept;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}