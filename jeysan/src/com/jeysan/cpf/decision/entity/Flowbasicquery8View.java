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
@Table(name = "fhp_flowbasicquery8_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery8View extends IdExtEntity {
			/**
	 * 人员编号
	 */
	private String personCode;
				/**
	 * 姓名
	 */
	private String nameh;
				/**
	 * 证件号码
	 */
	private String code;
				/**
	 * 性别
	 */
	private Integer sex;
				/**
	 * 迁入日期
	 */
	private java.util.Date settleInDate;
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
	 * 居住地
	 */
	private String address;
				/**
	 * 联系电话
	 */
	private String tel;
				/**
	 * 计生证号
	 */
	private String certCode;
				/**
	 * 有效期
	 */
	private Integer validPeroid;
				/**
	 * 发证机关
	 */
	private String issOrg;
				/**
	 * 发证日期
	 */
	private java.util.Date issDate;
				/**
	 * 证件类型
	 */
	private Integer certType;
				/**
	 * 子女数
	 */
	private Long childnum;
				/**
	 * 验证日期
	 */
	private java.util.Date dateh;
				/**
	 * 配偶姓名
	 */
	private String nameh2;
				/**
	 * 持证状态
	 */
	private Integer haveStatus;
				/**
	 * 所属区域
	 */
	private String area;
				/**
	 * 户口类别
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
				@Column(name="SETTLE_IN_DATE")
	public java.util.Date getSettleInDate() {
		return settleInDate;
	}
	public void setSettleInDate(java.util.Date settleInDate) {
		this.settleInDate = settleInDate;
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
				@Column(name="CERT_CODE")
	public String getCertCode() {
		return certCode;
	}
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
				@Column(name="VALID_PEROID")
	public Integer getValidPeroid() {
		return validPeroid;
	}
	public void setValidPeroid(Integer validPeroid) {
		this.validPeroid = validPeroid;
	}
				@Column(name="ISS_ORG")
	public String getIssOrg() {
		return issOrg;
	}
	public void setIssOrg(String issOrg) {
		this.issOrg = issOrg;
	}
				@Column(name="ISS_DATE")
	public java.util.Date getIssDate() {
		return issDate;
	}
	public void setIssDate(java.util.Date issDate) {
		this.issDate = issDate;
	}
				@Column(name="CERT_TYPE")
	public Integer getCertType() {
		return certType;
	}
	public void setCertType(Integer certType) {
		this.certType = certType;
	}
				@Column(name="childnum")
	public Long getChildnum() {
		return childnum;
	}
	public void setChildnum(Long childnum) {
		this.childnum = childnum;
	}
				@Column(name="dateh")
	public java.util.Date getDateh() {
		return dateh;
	}
	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}
				@Column(name="nameh2")
	public String getNameh2() {
		return nameh2;
	}
	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}
				@Column(name="HAVE_STATUS")
	public Integer getHaveStatus() {
		return haveStatus;
	}
	public void setHaveStatus(Integer haveStatus) {
		this.haveStatus = haveStatus;
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