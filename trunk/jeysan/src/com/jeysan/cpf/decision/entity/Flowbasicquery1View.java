package com.jeysan.cpf.decision.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_flowbasicquery1_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@IdClass(Flow1ViewPK.class)
public class Flowbasicquery1View implements Serializable {
	/**
	 * 流动人口id
	 */
	private Long id;
	/**
	 * 流动人口编码
	 */
	private String personCode;
	/**
	 * 身份证
	 */
	private String code;
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
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 最近婚变日期
	 */
	private java.util.Date marryCryDate;
	/**
	 * 子女数
	 */
	private Long childnum;
	/**
	 * 流入原因
	 */
	private Integer inCause;
	/**
	 * 流入日期
	 */
	private java.util.Date inDate;
	/**
	 * 是否持证
	 */
	private Integer haveStatus2;
	/**
	 * 流入类型
	 */
	private Integer inType;
	/**
	 * 配偶流入日期
	 */
	private java.util.Date spouseInDate;
	/**
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * 配偶姓名
	 */
	private String nameh2;
	/**
	 * 配偶出生日期
	 */
	private java.util.Date birthday2;
	/**
	 * 配偶是否持证
	 */
	private Integer haveStatus;
	/**
	 * 是否共同流入
	 */
	private Integer isFamilyAllIn;
	/**
	 * 联系电话
	 */
	private String tel;
	/**
	 * DOMICILE
	 */
	private String domicile;
	/**
	 * DOMICILE_CODE
	 */
	private String domicileCode;
	/**
	 * ADDRESS
	 */
	private String address;
	/**
	 * ADDRESS_CODE
	 */
	private String addressCode;
	/**
	 * area
	 */
	private String area;
	/**
	 * DOMICILE_TYPE
	 */
	private Integer domicileType;
	
	
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "nameh")
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

	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	@Column(name = "MARRY_CRY_DATE")
	public java.util.Date getMarryCryDate() {
		return marryCryDate;
	}

	public void setMarryCryDate(java.util.Date marryCryDate) {
		this.marryCryDate = marryCryDate;
	}

	@Column(name = "childnum")
	public Long getChildnum() {
		return childnum;
	}

	public void setChildnum(Long childnum) {
		this.childnum = childnum;
	}

	@Id
	@Column(name = "IN_CAUSE")
	public Integer getInCause() {
		return inCause;
	}

	public void setInCause(Integer inCause) {
		this.inCause = inCause;
	}

	@Column(name = "IN_DATE")
	public java.util.Date getInDate() {
		return inDate;
	}

	public void setInDate(java.util.Date inDate) {
		this.inDate = inDate;
	}

	@Column(name = "HAVE_STATUS2")
	public Integer getHaveStatus2() {
		return haveStatus2;
	}

	public void setHaveStatus2(Integer haveStatus2) {
		this.haveStatus2 = haveStatus2;
	}

	@Column(name = "IN_TYPE")
	public Integer getInType() {
		return inType;
	}

	public void setInType(Integer inType) {
		this.inType = inType;
	}

	@Column(name = "SPOUSE_IN_DATE")
	public java.util.Date getSpouseInDate() {
		return spouseInDate;
	}

	public void setSpouseInDate(java.util.Date spouseInDate) {
		this.spouseInDate = spouseInDate;
	}

	@Column(name = "METHOD")
	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	@Column(name = "NAMEH2")
	public String getNameh2() {
		return nameh2;
	}

	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}

	@Column(name = "BIRTHDAY2")
	public java.util.Date getBirthday2() {
		return birthday2;
	}

	public void setBirthday2(java.util.Date birthday2) {
		this.birthday2 = birthday2;
	}

	@Column(name = "HAVE_STATUS")
	public Integer getHaveStatus() {
		return haveStatus;
	}

	public void setHaveStatus(Integer haveStatus) {
		this.haveStatus = haveStatus;
	}

	@Column(name = "IS_FAMILY_ALL_IN")
	public Integer getIsFamilyAllIn() {
		return isFamilyAllIn;
	}

	public void setIsFamilyAllIn(Integer isFamilyAllIn) {
		this.isFamilyAllIn = isFamilyAllIn;
	}

	@Column(name = "TEL")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "DOMICILE")
	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}

	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}
	
	
	@Column(name = "DOMICILE_CODE")
	public String getDomicileCode() {
		return domicileCode;
	}

	public void setDomicileCode(String domicileCode) {
		this.domicileCode = domicileCode;
	}
	@Column(name = "ADDRESS_CODE")
	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}