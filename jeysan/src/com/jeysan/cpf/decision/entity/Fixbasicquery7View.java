package com.jeysan.cpf.decision.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_fixbasicquery7_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery7View extends IdExtEntity {
			/**
	 * 姓名
	 */
	private String nameh;
				/**
	 * 育龄妇女编码
	 */
	private String personCode;
				/**
	 * 身份证号
	 */
	private String code;
				/**
	 * 年龄
	 */
	private Integer age;
				/**
	 * 出生日期
	 */
	private java.util.Date birthday;
				/**
	 * 户口性质
	 */
	private Integer househodeKind;
				/**
	 * 现居住地
	 */
	private String address;
				/**
	 * 户籍地
	 */
	private String domicile;
				/**
	 * 初婚日期
	 */
	private java.util.Date firstMarryDate;
				/**
	 * 男孩数
	 */
	private Long boynum;
				/**
	 * 女孩数
	 */
	private Long girlnum;
				/**
	 * 一孩性别
	 */
	private Long minsex;
				/**
	 * 一孩出生日期
	 */
	private java.util.Date minbirthday;
				/**
	 * 审批结果
	 */
	private Integer isAgree;
				/**
	 * 审批日期
	 */
	private java.util.Date checkDate;
				/**
	 * 丈夫身份证号
	 */
	private String code2;
				/**
	 * 生育合同日期
	 */
	private java.util.Date dateh;
				/**
	 * 停止避孕时间
	 */
	private java.util.Date noContraceptDate;
				/**
	 * 备注
	 */
	private String remark;
				/**
	 * 二孩计划日期
	 */
	private java.util.Date edd;
				/**
	 * 安排生育情况
	 */
	private Integer planType;
				/**
	 * 申请类型
	 */
	private Integer typeh;
				/**
	 * 是否再生二
	 */
	private Integer isSecond;
				/**
	 * 丈夫姓名
	 */
	private String nameh2;
				/**
	 * 丈夫户口性质
	 */
	private Integer househodeKind2;
				/**
	 * 丈夫出生日期
	 */
	private java.util.Date birthday2;
				/**
	 * 丈夫户籍地
	 */
	private String domicile2;
				/**
	 * 户口类型
	 */
	private Integer domicileType;
				/**
	 * area
	 */
	private String area;
			
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
				@Column(name="BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
				@Column(name="HOUSEHODE_KIND")
	public Integer getHousehodeKind() {
		return househodeKind;
	}
	public void setHousehodeKind(Integer househodeKind) {
		this.househodeKind = househodeKind;
	}
				@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
				@Column(name="DOMICILE")
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
				@Column(name="FIRST_MARRY_DATE")
	public java.util.Date getFirstMarryDate() {
		return firstMarryDate;
	}
	public void setFirstMarryDate(java.util.Date firstMarryDate) {
		this.firstMarryDate = firstMarryDate;
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
				@Column(name="minsex")
	public Long getMinsex() {
		return minsex;
	}
	public void setMinsex(Long minsex) {
		this.minsex = minsex;
	}
				@Column(name="minbirthday")
	public java.util.Date getMinbirthday() {
		return minbirthday;
	}
	public void setMinbirthday(java.util.Date minbirthday) {
		this.minbirthday = minbirthday;
	}
				@Column(name="IS_AGREE")
	public Integer getIsAgree() {
		return isAgree;
	}
	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}
				@Column(name="CHECK_DATE")
	public java.util.Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
	}
				@Column(name="CODE2")
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
				@Column(name="DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}
	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}
				@Column(name="NO_CONTRACEPT_DATE")
	public java.util.Date getNoContraceptDate() {
		return noContraceptDate;
	}
	public void setNoContraceptDate(java.util.Date noContraceptDate) {
		this.noContraceptDate = noContraceptDate;
	}
				@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
				@Column(name="EDD")
	public java.util.Date getEdd() {
		return edd;
	}
	public void setEdd(java.util.Date edd) {
		this.edd = edd;
	}
				@Column(name="PLAN_TYPE")
	public Integer getPlanType() {
		return planType;
	}
	public void setPlanType(Integer planType) {
		this.planType = planType;
	}
				@Column(name="TYPEH")
	public Integer getTypeh() {
		return typeh;
	}
	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}
				@Column(name="IS_SECOND")
	public Integer getIsSecond() {
		return isSecond;
	}
	public void setIsSecond(Integer isSecond) {
		this.isSecond = isSecond;
	}
				@Column(name="NAMEH2")
	public String getNameh2() {
		return nameh2;
	}
	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}
				@Column(name="HOUSEHODE_KIND2")
	public Integer getHousehodeKind2() {
		return househodeKind2;
	}
	public void setHousehodeKind2(Integer househodeKind2) {
		this.househodeKind2 = househodeKind2;
	}
				@Column(name="BIRTHDAY2")
	public java.util.Date getBirthday2() {
		return birthday2;
	}
	public void setBirthday2(java.util.Date birthday2) {
		this.birthday2 = birthday2;
	}
				@Column(name="DOMICILE2")
	public String getDomicile2() {
		return domicile2;
	}
	public void setDomicile2(String domicile2) {
		this.domicile2 = domicile2;
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
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}