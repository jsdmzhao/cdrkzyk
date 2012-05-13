package com.jeysan.cpf.pmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value={"hibernateLazyInitializer"}) 
public class WomanChildren extends IdExtEntity {
	/**
	 * 父母人员ID
	 */
	private Person person;
	/**
	 * 自己人员ID
	 */
	private Person personSelfIn;
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 性别
	 */
	private Integer sex;
	
	private String sexLabel;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	
	private String birthdayLabel;
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
	/**
	 * 民族
	 */
	private Integer native_;
	
	private String nativeLabel;
	/**
	 * 照片
	 */
	private String photo;
	/**
	 * 上报日期
	 */
	private java.util.Date upDate;
	/**
	 * 备注
	 */
	private String remark;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_ID")
	@JsonIgnore
	public Person getPerson() {
		return person;
	}
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_SELF_ID")
	@JsonIgnore
	public Person getPersonSelfIn() {
		return personSelfIn;
	}
	
	public void setPersonSelfIn(Person personSelfIn) {
		this.personSelfIn = personSelfIn;
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
	
	
	@Column(name = "NATIVE")
	public Integer getNative() {
		return native_;
	}

	public void setNative(Integer native_) {
		this.native_ = native_;
	}
	@Column(name = "PHOTO")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	@Transient
	public String getSexLabel() {
		return sexLabel;
	}

	public void setSexLabel(String sexLabel) {
		this.sexLabel = sexLabel;
	}
	@Transient
	public String getBirthdayLabel() {
		return birthdayLabel;
	}

	public void setBirthdayLabel(String birthdayLabel) {
		this.birthdayLabel = birthdayLabel;
	}
	@Transient
	public String getNativeLabel() {
		return nativeLabel;
	}

	public void setNativeLabel(String nativeLabel) {
		this.nativeLabel = nativeLabel;
	}
	
	
	@Column(name = "UP_DATE")
	public java.util.Date getUpDate() {
		return upDate;
	}

	public void setUpDate(java.util.Date upDate) {
		this.upDate = upDate;
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