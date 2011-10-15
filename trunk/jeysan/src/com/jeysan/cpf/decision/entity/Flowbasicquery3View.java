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
@Table(name = "fhp_flowbasicquery3_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery3View extends IdExtEntity {

	/**
	 * 流动人口编号
	 */
	private String personCode;
	/**
	 * 证件号码
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
	 * 流入日期
	 */
	private java.util.Date settleInDate;
	/**
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 居住地
	 */
	private String address;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 配偶姓名
	 */
	private String nameh2;
	/**
	 * 配偶户籍地
	 */
	private String domicile2;
	/**
	 * 子女数
	 */
	private Long childnum;
	/**
	 * 子女姓名
	 */
	private String nameh3;
	/**
	 * 行呗
	 */
	private Integer sex2;
	/**
	 * 孩次
	 */
	private Integer childIndex;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday2;
	/**
	 * 政策内外
	 */
	private Integer policy;
	/**
	 * 出生地点
	 */
	private String birthAddress;
	/**
	 * 血缘关系
	 */
	private String kinship;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 变化原因
	 */
	private String changeCause;
	/**
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * 落实时间
	 */
	private java.util.Date opsDate;
	/**
	 * 所属地区
	 */
	private String area;
	/**
	 * 户口性质
	 */
	private Integer domicileType;


	@Column(name = "PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@Column(name = "SETTLE_IN_DATE")
	public java.util.Date getSettleInDate() {
		return settleInDate;
	}

	public void setSettleInDate(java.util.Date settleInDate) {
		this.settleInDate = settleInDate;
	}

	@Column(name = "DOMICILE")
	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "NAMEH2")
	public String getNameh2() {
		return nameh2;
	}

	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}

	@Column(name = "DOMICILE2")
	public String getDomicile2() {
		return domicile2;
	}

	public void setDomicile2(String domicile2) {
		this.domicile2 = domicile2;
	}

	@Column(name = "childnum")
	public Long getChildnum() {
		return childnum;
	}

	public void setChildnum(Long childnum) {
		this.childnum = childnum;
	}

	@Column(name = "nameh3")
	public String getNameh3() {
		return nameh3;
	}

	public void setNameh3(String nameh3) {
		this.nameh3 = nameh3;
	}

	@Column(name = "sex2")
	public Integer getSex2() {
		return sex2;
	}

	public void setSex2(Integer sex2) {
		this.sex2 = sex2;
	}

	@Column(name = "CHILD_INDEX")
	public Integer getChildIndex() {
		return childIndex;
	}

	public void setChildIndex(Integer childIndex) {
		this.childIndex = childIndex;
	}

	@Column(name = "BIRTHDAY2")
	public java.util.Date getBirthday2() {
		return birthday2;
	}

	public void setBirthday2(java.util.Date birthday2) {
		this.birthday2 = birthday2;
	}

	@Column(name = "POLICY")
	public Integer getPolicy() {
		return policy;
	}

	public void setPolicy(Integer policy) {
		this.policy = policy;
	}

	@Column(name = "BIRTH_ADDRESS")
	public String getBirthAddress() {
		return birthAddress;
	}

	public void setBirthAddress(String birthAddress) {
		this.birthAddress = birthAddress;
	}

	@Column(name = "KINSHIP")
	public String getKinship() {
		return kinship;
	}

	public void setKinship(String kinship) {
		this.kinship = kinship;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "CHANGE_CAUSE")
	public String getChangeCause() {
		return changeCause;
	}

	public void setChangeCause(String changeCause) {
		this.changeCause = changeCause;
	}

	@Column(name = "METHOD")
	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	@Column(name = "OPS_DATE")
	public java.util.Date getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(java.util.Date opsDate) {
		this.opsDate = opsDate;
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