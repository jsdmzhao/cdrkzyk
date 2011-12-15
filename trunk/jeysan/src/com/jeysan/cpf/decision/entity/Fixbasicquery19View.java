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
@Table(name = "fhp_fixbasicquery19_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery19View extends IdExtEntity {
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
	 * 户籍地
	 */
	private String domicile;
				/**
	 * 现居住地
	 */
	private String address;
				/**
	 * 出生日期
	 */
	private java.util.Date birthday;
				/**
	 * 户口性质
	 */
	private Integer househodeKind;
				/**
	 * 姓名
	 */
	private String nameh2;
				/**
	 * 户籍地
	 */
	private String domicile2;
				/**
	 * 户口性质
	 */
	private Integer househodeKind2;
				/**
	 * 发证日期
	 */
	private java.util.Date issDate;
				/**
	 * 发证机关地址
	 */
	private String issOrgAddress;
				/**
	 * area
	 */
	private String area;
				/**
	 * DOMICILE_TYPE
	 */
	private Integer domicileType;
			
			@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
				@Column(name="NAMEH")
	public String getNameh() {
		return nameh;
	}
	public void setNameh(String nameh) {
		this.nameh = nameh;
	}
				@Column(name="SEX")
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
				@Column(name="DOMICILE")
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
				@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
				@Column(name="NAMEH2")
	public String getNameh2() {
		return nameh2;
	}
	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}
				@Column(name="DOMICILE2")
	public String getDomicile2() {
		return domicile2;
	}
	public void setDomicile2(String domicile2) {
		this.domicile2 = domicile2;
	}
				@Column(name="HOUSEHODE_KIND2")
	public Integer getHousehodeKind2() {
		return househodeKind2;
	}
	public void setHousehodeKind2(Integer househodeKind2) {
		this.househodeKind2 = househodeKind2;
	}
				@Column(name="ISS_DATE")
	public java.util.Date getIssDate() {
		return issDate;
	}
	public void setIssDate(java.util.Date issDate) {
		this.issDate = issDate;
	}
				@Column(name="ISS_ORG_ADDRESS")
	public String getIssOrgAddress() {
		return issOrgAddress;
	}
	public void setIssOrgAddress(String issOrgAddress) {
		this.issOrgAddress = issOrgAddress;
	}
				@Column(name="area")
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
				@Column(name="DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}
	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}