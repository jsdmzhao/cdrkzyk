package com.jeysan.cpf.decision.entity;

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
@Table(name = "fhp_flowbasicquery12_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery12View extends IdExtEntity {
	/**
	 * 人员编号
	 */
	private String personCode;
	/**
	 * 身份证号码
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
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 户籍地编码
	 */
	private String domicileCode;
	/**
	 * 居住地
	 */
	private String address;
	/**
	 * 居住地编码
	 */
	private String addressCode;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 婚变日期
	 */
	private java.util.Date marryCryDate;
	/**
	 * 子女数
	 */
	private Long childnum;
	/**
	 * 最小孩出生日期
	 */
	private java.util.Date dateh;
	/**
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * 落实措施日期
	 */
	private java.util.Date opsDate;
	/**
	 * 流入日期
	 */
	private java.util.Date inDate;
	/**
	 * 持证情况
	 */
	private Integer haveStatus;
	/**
	 * 流入类型
	 */
	private Integer inType;
	/**
	 * 配偶姓名
	 */
	private String nameh2;
	/**
	 * 夫妻是否共同流入
	 */
	private Integer isFamilyAllIn;
	/**
	 * 计生证号码
	 */
	private String certCode;
	/**
	 * 验证日期
	 */
	private java.util.Date dateh2;
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 户口类别
	 */
	private Integer domicileType;

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

	@Column(name = "DOMICILE")
	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	@Column(name = "DOMICILE_CODE")
	public String getDomicileCode() {
		return domicileCode;
	}

	public void setDomicileCode(String domicileCode) {
		this.domicileCode = domicileCode;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "ADDRESS_CODE")
	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
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

	@Column(name = "dateh")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}

	@Column(name = "METHOD")
	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	@Column(name = "OPS_DATE")
	public java.util.Date getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(java.util.Date opsDate) {
		this.opsDate = opsDate;
	}

	@Column(name = "IN_DATE")
	public java.util.Date getInDate() {
		return inDate;
	}

	public void setInDate(java.util.Date inDate) {
		this.inDate = inDate;
	}

	@Column(name = "HAVE_STATUS")
	public Integer getHaveStatus() {
		return haveStatus;
	}

	public void setHaveStatus(Integer haveStatus) {
		this.haveStatus = haveStatus;
	}

	@Column(name = "IN_TYPE")
	public Integer getInType() {
		return inType;
	}

	public void setInType(Integer inType) {
		this.inType = inType;
	}

	@Column(name = "NAMEH2")
	public String getNameh2() {
		return nameh2;
	}

	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}

	@Column(name = "IS_FAMILY_ALL_IN")
	public Integer getIsFamilyAllIn() {
		return isFamilyAllIn;
	}

	public void setIsFamilyAllIn(Integer isFamilyAllIn) {
		this.isFamilyAllIn = isFamilyAllIn;
	}

	@Column(name = "CERT_CODE")
	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	@Column(name = "dateh2")
	public java.util.Date getDateh2() {
		return dateh2;
	}

	public void setDateh2(java.util.Date dateh2) {
		this.dateh2 = dateh2;
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

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}