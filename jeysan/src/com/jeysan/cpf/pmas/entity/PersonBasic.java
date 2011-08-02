package com.jeysan.cpf.pmas.entity;

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
@Table(name = "fhp_person_basic")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PersonBasic extends IdEntity {
						/**
	 * PERSON_ID
	 */
	private Long personId;
				/**
	 * 性别
	 */
	private Integer sex;
				/**
	 * 年龄
	 */
	private Integer age;
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
	 * 民族
	 */
	private Integer native_;
				/**
	 * houseId
	 */
	private Long houseId;
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
	 * spouseId
	 */
	private Long spouseId;
				/**
	 * dbType
	 */
	private String dbType;
				/**
	 * 注销类别
	 */
	private Integer cancelType;
				/**
	 * 注销日期
	 */
	private java.util.Date cancelDate;
				/**
	 * 死亡（迁出）时间
	 */
	private java.util.Date dateh;
				/**
	 * 备注
	 */
	private String remark;
				/**
	 * 何地迁入(流入)
	 */
	private String settleInPlace;
				/**
	 * 迁入(流入)日期
	 */
	private java.util.Date settleInDate;
				/**
	 * 迁入(流入)原因
	 */
	private String settleInCause;
				/**
	 * 迁入(流入)类别
	 */
	private Integer settleInType;
				/**
	 * 户主姓名
	 */
	private String ownerName;
			
						@Column(name="PERSON_ID")
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
				@Column(name="SEX")
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
				@Column(name="AGE")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
				@Column(name="DOMICILE")
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
				@Column(name="DOMICILE_CODE")
	public String getDomicileCode() {
		return domicileCode;
	}
	public void setDomicileCode(String domicileCode) {
		this.domicileCode = domicileCode;
	}
				@Column(name="ZIP_CODE")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
				@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
				@Column(name="ADDRESS_TYPE")
	public Integer getAddressType() {
		return addressType;
	}
	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}
				@Column(name="ADDRESS_CODE")
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
				@Column(name="HOUSE_NUMBER")
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
				@Column(name="NATIVE")
	public Integer getNative() {
		return native_;
	}
	public void setNative(Integer native_) {
		this.native_ = native_;
	}
				@Column(name="HOUSE_ID")
	public Long getHouseId() {
		return houseId;
	}
	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}
				@Column(name="BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
				@Column(name="EDU")
	public Integer getEdu() {
		return edu;
	}
	public void setEdu(Integer edu) {
		this.edu = edu;
	}
				@Column(name="POLITICAL_STATUS")
	public Integer getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
				@Column(name="HOUSEHODE_KIND")
	public Integer getHousehodeKind() {
		return househodeKind;
	}
	public void setHousehodeKind(Integer househodeKind) {
		this.househodeKind = househodeKind;
	}
				@Column(name="JOB")
	public Integer getJob() {
		return job;
	}
	public void setJob(Integer job) {
		this.job = job;
	}
				@Column(name="IS_SINGLE")
	public Integer getIsSingle() {
		return isSingle;
	}
	public void setIsSingle(Integer isSingle) {
		this.isSingle = isSingle;
	}
				@Column(name="COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
				@Column(name="PHOTO")
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
				@Column(name="FINGERPRINT")
	public String getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
				@Column(name="TEL")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
				@Column(name="HAVE_STATUS")
	public Integer getHaveStatus() {
		return haveStatus;
	}
	public void setHaveStatus(Integer haveStatus) {
		this.haveStatus = haveStatus;
	}
				@Column(name="VALIDATE_STATUS")
	public Integer getValidateStatus() {
		return validateStatus;
	}
	public void setValidateStatus(Integer validateStatus) {
		this.validateStatus = validateStatus;
	}
				@Column(name="SPOUSE_ID")
	public Long getSpouseId() {
		return spouseId;
	}
	public void setSpouseId(Long spouseId) {
		this.spouseId = spouseId;
	}
				@Column(name="DB_TYPE")
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
				@Column(name="CANCEL_TYPE")
	public Integer getCancelType() {
		return cancelType;
	}
	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
	}
				@Column(name="CANCEL_DATE")
	public java.util.Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}
				@Column(name="DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}
	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}
				@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
				@Column(name="SETTLE_IN_PLACE")
	public String getSettleInPlace() {
		return settleInPlace;
	}
	public void setSettleInPlace(String settleInPlace) {
		this.settleInPlace = settleInPlace;
	}
				@Column(name="SETTLE_IN_DATE")
	public java.util.Date getSettleInDate() {
		return settleInDate;
	}
	public void setSettleInDate(java.util.Date settleInDate) {
		this.settleInDate = settleInDate;
	}
				@Column(name="SETTLE_IN_CAUSE")
	public String getSettleInCause() {
		return settleInCause;
	}
	public void setSettleInCause(String settleInCause) {
		this.settleInCause = settleInCause;
	}
				@Column(name="SETTLE_IN_TYPE")
	public Integer getSettleInType() {
		return settleInType;
	}
	public void setSettleInType(Integer settleInType) {
		this.settleInType = settleInType;
	}
				@Column(name="OWNER_NAME")
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}