package com.jeysan.cpf.pmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;
import com.jeysan.modules.utils.date.DateUtil;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_spouse")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value={"hibernateLazyInitializer"}) 
public class Spouse extends IdExtEntity {
	/**
	 * 配偶ID
	 */
	private Person person;
	/**
	 * NAMEH
	 */
	private String nameh;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 身份证号码
	 */
	private String code;
	/**
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 户籍地编码
	 */
	private String domicileCode;
	/**
	 * 户籍地邮编
	 */
	private String zipCode;
	/**
	 * 现居住地
	 */
	private String address;
	/**
	 * 居住地类型
	 */
	private Integer addressType;
	/**
	 * 现居住地编码
	 */
	private String addressCode;
	/**
	 * 门牌号码
	 */
	private String houseNumber;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	 * 民族
	 */
	private Integer native_;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 文化程度
	 */
	private Integer edu;
	/**
	 * 政治面貌
	 */
	private Integer politicalStatus;
	/**
	 * 户口性质
	 */
	private Integer househodeKind;
	/**
	 * 职业
	 */
	private Integer job;
	/**
	 * 是否独生
	 */
	private Integer isSingle;
	/**
	 * 工作单位
	 */
	private String company;
	/**
	 * 照片
	 */
	private String photo;
	/**
	 * 指纹
	 */
	private String fingerprint;
	/**
	 * 联系电话
	 */
	private String tel;
	/**
	 * 持证情况
	 */
	private Integer haveStatus;
	/**
	 * 验证情况
	 */
	private Integer validateStatus;
	/**
	 * 备注
	 */
	private String remark;
	
	private String domicileTypeLabel;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_ID")
	@JsonIgnore
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

	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@Column(name = "ZIP_CODE")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "ADDRESS_TYPE")
	public Integer getAddressType() {
		return addressType;
	}

	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}

	@Column(name = "ADDRESS_CODE")
	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	@Column(name = "HOUSE_NUMBER")
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Column(name = "DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}

	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}

	@Column(name = "NATIVE")
	public Integer getNative() {
		return native_;
	}

	public void setNative(Integer native_) {
		this.native_ = native_;
	}

	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "EDU")
	public Integer getEdu() {
		return edu;
	}

	public void setEdu(Integer edu) {
		this.edu = edu;
	}

	@Column(name = "POLITICAL_STATUS")
	public Integer getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	@Column(name = "HOUSEHODE_KIND")
	public Integer getHousehodeKind() {
		return househodeKind;
	}

	public void setHousehodeKind(Integer househodeKind) {
		this.househodeKind = househodeKind;
	}

	@Column(name = "JOB")
	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

	@Column(name = "IS_SINGLE")
	public Integer getIsSingle() {
		return isSingle;
	}

	public void setIsSingle(Integer isSingle) {
		this.isSingle = isSingle;
	}

	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "PHOTO")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "FINGERPRINT")
	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	@Column(name = "TEL")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "HAVE_STATUS")
	public Integer getHaveStatus() {
		return haveStatus;
	}

	public void setHaveStatus(Integer haveStatus) {
		this.haveStatus = haveStatus;
	}

	@Column(name = "VALIDATE_STATUS")
	public Integer getValidateStatus() {
		return validateStatus;
	}

	public void setValidateStatus(Integer validateStatus) {
		this.validateStatus = validateStatus;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Transient
	public String getDomicileTypeLabel() {
		return domicileTypeLabel;
	}

	public void setDomicileTypeLabel(String domicileTypeLabel) {
		this.domicileTypeLabel = domicileTypeLabel;
	}
	
	
	@Transient
	public String getBirthdayLabel() {
		if(birthday != null)
			return DateUtil.convertDateToString(this.birthday,"yyyy-MM-dd");
		return null;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}