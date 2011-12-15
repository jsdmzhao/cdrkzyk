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
@Table(name = "fhp_fixbasicquery1_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery1View extends IdExtEntity {
			/**
	 * 姓名
	 */
	private String nameh;
				/**
	 * 人员编号
	 */
	private String personCode;
				/**
	 * 证件号码
	 */
	private String code;
				/**
	 * 年龄
	 */
	private Integer age;
				/**
	 * 何地迁入
	 */
	private String settleInPlace;
				/**
	 * 迁入日期
	 */
	private java.util.Date settleInDate;
				/**
	 * 注销日期
	 */
	private java.util.Date cancelDate;
				/**
	 * 注销类别
	 */
	private Integer cancelType;
				/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
				/**
	 * 出生日期
	 */
	private java.util.Date birthday;
				/**
	 * 初婚日期
	 */
	private java.util.Date firstMarryDate;
				/**
	 * 门牌号码
	 */
	private String houseNo;
				/**
	 * 户口性质
	 */
	private Integer househodeKind;
				/**
	 * 职业
	 */
	private Integer job;
				/**
	 * 政治面貌
	 */
	private Integer politicalStatus;
				/**
	 * 避孕节育措施
	 */
	private Integer method;
				/**
	 * 建卡日期
	 */
	private java.util.Date createDate;
				/**
	 * 卡片状态
	 */
	private Integer cardStatus;
				/**
	 * 男孩数量
	 */
	private Long boynum;
				/**
	 * 女孩数量
	 */
	private Long girlnum;
				/**
	 * 配偶姓名
	 */
	private String nameh2;
				/**
	 * 配偶户籍地
	 */
	private String domicile;
				/**
	 * 配偶户口性质
	 */
	private Integer househodeKind2;
				/**
	 * 配偶政治面貌
	 */
	private Integer politicalStatus2;
				/**
	 * 配偶户口类别
	 */
	private Integer domicileType;
				/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 居住地址
	 */
	private String address;
			
			@Column(name="NAMEH")
	public String getNameh() {
		return nameh;
	}
	public void setNameh(String nameh) {
		this.nameh = nameh;
	}
				@Column(name="PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
				@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
				@Column(name="age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
				@Column(name="CANCEL_DATE")
	public java.util.Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}
				@Column(name="CANCEL_TYPE")
	public Integer getCancelType() {
		return cancelType;
	}
	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
	}
				@Column(name="MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}
	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}
				@Column(name="BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
				@Column(name="FIRST_MARRY_DATE")
	public java.util.Date getFirstMarryDate() {
		return firstMarryDate;
	}
	public void setFirstMarryDate(java.util.Date firstMarryDate) {
		this.firstMarryDate = firstMarryDate;
	}
				@Column(name="HOUSE_NO")
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
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
				@Column(name="POLITICAL_STATUS")
	public Integer getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
				@Column(name="METHOD")
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
				@Column(name="CREATE_DATE")
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
				@Column(name="CARD_STATUS")
	public Integer getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(Integer cardStatus) {
		this.cardStatus = cardStatus;
	}
				@Column(name="boynum")
	public Long getBoynum() {
		return boynum;
	}
	public void setBoynum(Long boynum) {
		this.boynum = boynum;
	}
				@Column(name="girlnum")
	public Long getGirlnum() {
		return girlnum;
	}
	public void setGirlnum(Long girlnum) {
		this.girlnum = girlnum;
	}
				@Column(name="NAMEH2")
	public String getNameh2() {
		return nameh2;
	}
	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}
				@Column(name="DOMICILE")
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
				@Column(name="HOUSEHODE_KIND2")
	public Integer getHousehodeKind2() {
		return househodeKind2;
	}
	public void setHousehodeKind2(Integer househodeKind2) {
		this.househodeKind2 = househodeKind2;
	}
				@Column(name="POLITICAL_STATUS2")
	public Integer getPoliticalStatus2() {
		return politicalStatus2;
	}
	public void setPoliticalStatus2(Integer politicalStatus2) {
		this.politicalStatus2 = politicalStatus2;
	}
				@Column(name="DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}
	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}
				@Column(name="area")
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
		@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}