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
@Table(name = "fhp_flowbasicquery2_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery2View extends IdExtEntity {
	/**
	 * 流动人口编码
	 */
	private String personCode;
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 证件号码
	 */
	private String code;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 子女数
	 */
	private Long childnum;
	/**
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * 流入地
	 */
	private String inAddress;
	/**
	 * 流出日期
	 */
	private java.util.Date outDate;
	/**
	 * 是否持证
	 */
	private Integer haveStatus;
	/**
	 * 流出类型
	 */
	private Integer outType;
	/**
	 * 夫妻是否共同流出
	 */
	private Integer isFamilyAllOut;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 所属地区
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

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	@Column(name = "childnum")
	public Long getChildnum() {
		return childnum;
	}

	public void setChildnum(Long childnum) {
		this.childnum = childnum;
	}

	@Column(name = "METHOD")
	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	@Column(name = "IN_ADDRESS")
	public String getInAddress() {
		return inAddress;
	}

	public void setInAddress(String inAddress) {
		this.inAddress = inAddress;
	}

	@Column(name = "OUT_DATE")
	public java.util.Date getOutDate() {
		return outDate;
	}

	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}

	@Column(name = "HAVE_STATUS")
	public Integer getHaveStatus() {
		return haveStatus;
	}

	public void setHaveStatus(Integer haveStatus) {
		this.haveStatus = haveStatus;
	}

	@Column(name = "OUT_TYPE")
	public Integer getOutType() {
		return outType;
	}

	public void setOutType(Integer outType) {
		this.outType = outType;
	}

	@Column(name = "IS_FAMILY_ALL_OUT")
	public Integer getIsFamilyAllOut() {
		return isFamilyAllOut;
	}

	public void setIsFamilyAllOut(Integer isFamilyAllOut) {
		this.isFamilyAllOut = isFamilyAllOut;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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