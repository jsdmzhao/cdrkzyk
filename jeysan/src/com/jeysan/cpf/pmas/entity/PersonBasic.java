package com.jeysan.cpf.pmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_person_basic")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PersonBasic extends IdExtEntity {
	/**
	 * PERSON_ID
	 */
	private Person person;
	/**
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 户籍地编码
	 */
	private String domicileCode;
	/**
	 * 户籍地门牌号码
	 */
	private String domicileHouseNo;
	/**
	 * 户籍地房号
	 */
	private String domicileRoomNo;
	/**
	 * 户籍地邮编
	 */
	private String domicileZipCode;
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
	 * 现居住地门牌号码
	 */
	private String houseNo;
	/**
	 * 现居住地房号
	 */
	private String roomNo;
	/**
	 * 户籍地邮编
	 */
	private String zipCode;
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
	 * 备注
	 */
	private String remark;
	/**
	 * 户主姓名
	 */
	private String ownerName;
	/**
	 * 与户主关系
	 */
	private Integer relation;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 初婚日期
	 */
	private java.util.Date firstMarryDate;
	/**
	 * 国籍
	 */
	private Integer nationality;
	/**
	 * 村民小组
	 */
	private Long villagerTeamId;
	/**
	 * 户编码
	 */
	private String houseHoldCode;
	/**
	 * 父亲姓名
	 */
	private String father;
	/**
	 * 父亲身份证
	 */
	private String fatherCode;
	/**
	 * 母亲姓名
	 */
	private String mother;
	/**
	 * 母亲身份证
	 */
	private String motherCode;


	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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

	@Column(name = "DOMICILE_HOUSE_NO")
	public String getDomicileHouseNo() {
		return domicileHouseNo;
	}

	public void setDomicileHouseNo(String domicileHouseNo) {
		this.domicileHouseNo = domicileHouseNo;
	}

	@Column(name = "DOMICILE_ROOM_NO")
	public String getDomicileRoomNo() {
		return domicileRoomNo;
	}

	public void setDomicileRoomNo(String domicileRoomNo) {
		this.domicileRoomNo = domicileRoomNo;
	}

	@Column(name = "DOMICILE_ZIP_CODE")
	public String getDomicileZipCode() {
		return domicileZipCode;
	}

	public void setDomicileZipCode(String domicileZipCode) {
		this.domicileZipCode = domicileZipCode;
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

	@Column(name = "HOUSE_NO")
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	@Column(name = "ROOM_NO")
	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "ZIP_CODE")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "NATIVE")
	public Integer getNative() {
		return native_;
	}

	public void setNative(Integer native_) {
		this.native_ = native_;
	}

	@Column(name = "HOUSE_ID")
	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
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

	@Column(name = "SPOUSE_ID")
	public Long getSpouseId() {
		return spouseId;
	}

	public void setSpouseId(Long spouseId) {
		this.spouseId = spouseId;
	}

	@Column(name = "DB_TYPE")
	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "OWNER_NAME")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name = "RELATION")
	public Integer getRelation() {
		return relation;
	}

	public void setRelation(Integer relation) {
		this.relation = relation;
	}

	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	@Column(name = "FIRST_MARRY_DATE")
	public java.util.Date getFirstMarryDate() {
		return firstMarryDate;
	}

	public void setFirstMarryDate(java.util.Date firstMarryDate) {
		this.firstMarryDate = firstMarryDate;
	}

	@Column(name = "NATIONALITY")
	public Integer getNationality() {
		return nationality;
	}

	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}

	@Column(name = "VILLAGER_TEAM_ID")
	public Long getVillagerTeamId() {
		return villagerTeamId;
	}

	public void setVillagerTeamId(Long villagerTeamId) {
		this.villagerTeamId = villagerTeamId;
	}

	@Column(name = "HOUSE_HOLD_CODE")
	public String getHouseHoldCode() {
		return houseHoldCode;
	}

	public void setHouseHoldCode(String houseHoldCode) {
		this.houseHoldCode = houseHoldCode;
	}

	@Column(name = "FATHER")
	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	@Column(name = "FATHER_CODE")
	public String getFatherCode() {
		return fatherCode;
	}

	public void setFatherCode(String fatherCode) {
		this.fatherCode = fatherCode;
	}

	@Column(name = "MOTHER")
	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	@Column(name = "MOTHER_CODE")
	public String getMotherCode() {
		return motherCode;
	}

	public void setMotherCode(String motherCode) {
		this.motherCode = motherCode;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}