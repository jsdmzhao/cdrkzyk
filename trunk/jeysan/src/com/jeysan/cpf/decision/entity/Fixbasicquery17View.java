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
@Table(name = "fhp_fixbasicquery17_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery17View extends IdExtEntity {
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
	 * 类型
	 */
	private Integer typeh;
				/**
	 * 服务证更换（废止）日期
	 */
	private java.util.Date dateh;
				/**
	 * 更换（废止）原因
	 */
	private Integer cause;
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
	 * 避孕节育措施
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
	 * DOMICILE_TYPE
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
				@Column(name="TYPEH")
	public Integer getTypeh() {
		return typeh;
	}
	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}
				@Column(name="DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}
	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}
				@Column(name="CAUSE")
	public Integer getCause() {
		return cause;
	}
	public void setCause(Integer cause) {
		this.cause = cause;
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