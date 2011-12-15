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
@Table(name = "fhp_fixbasicquery15_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery15View extends IdExtEntity {
			/**
	 * 育龄妇女编码
	 */
	private String personCode;
				/**
	 * 姓名
	 */
	private String nameh;
				/**
	 * 身份证号码
	 */
	private String code;
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
	 * 户籍地
	 */
	private String domicile;
				/**
	 * 现居住地
	 */
	private String address;
				/**
	 * 联系电话
	 */
	private String tel;
				/**
	 * 户口性质
	 */
	private Integer househodeKind;
				/**
	 * 领流动证日期
	 */
	private java.util.Date issDate;
				/**
	 * 流动证类型
	 */
	private Integer issType;
				/**
	 * 证件编号
	 */
	private String certCode;
				/**
	 * 子女数
	 */
	private Long childnum;
				/**
	 * 男孩数
	 */
	private Long boynum;
				/**
	 * 女孩数
	 */
	private Long girlnum;
				/**
	 * 避孕节育方法
	 */
	private Integer method;
				/**
	 * 丈夫姓名
	 */
	private String nameh3;
				/**
	 * 丈夫户口性质
	 */
	private Integer househodeKind2;
				/**
	 * area
	 */
	private String area;
				/**
	 * 户籍类别
	 */
	private Integer domicileType;
			
			@Column(name="PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
				@Column(name="NAMEH")
	public String getNameh() {
		return nameh;
	}
	public void setNameh(String nameh) {
		this.nameh = nameh;
	}
				@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
				@Column(name="SEX")
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
				@Column(name="BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
				@Column(name="MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}
	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
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
				@Column(name="TEL")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
				@Column(name="HOUSEHODE_KIND")
	public Integer getHousehodeKind() {
		return househodeKind;
	}
	public void setHousehodeKind(Integer househodeKind) {
		this.househodeKind = househodeKind;
	}
				@Column(name="ISS_DATE")
	public java.util.Date getIssDate() {
		return issDate;
	}
	public void setIssDate(java.util.Date issDate) {
		this.issDate = issDate;
	}
				@Column(name="ISS_TYPE")
	public Integer getIssType() {
		return issType;
	}
	public void setIssType(Integer issType) {
		this.issType = issType;
	}
				@Column(name="CERT_CODE")
	public String getCertCode() {
		return certCode;
	}
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
				@Column(name="childnum")
	public Long getChildnum() {
		return childnum;
	}
	public void setChildnum(Long childnum) {
		this.childnum = childnum;
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
				@Column(name="METHOD")
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
				@Column(name="nameh3")
	public String getNameh3() {
		return nameh3;
	}
	public void setNameh3(String nameh3) {
		this.nameh3 = nameh3;
	}
				@Column(name="HOUSEHODE_KIND2")
	public Integer getHousehodeKind2() {
		return househodeKind2;
	}
	public void setHousehodeKind2(Integer househodeKind2) {
		this.househodeKind2 = househodeKind2;
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