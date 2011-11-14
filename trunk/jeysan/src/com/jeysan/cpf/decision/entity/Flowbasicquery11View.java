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
@Table(name = "fhp_flowbasicquery11_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery11View extends IdExtEntity {
	/**
	 * 房屋编号
	 */
	private String houseCode;
	/**
	 * 公安牌号
	 */
	private String housePoliceNo;
	/**
	 * 房屋类型
	 */
	private Integer houseType;
	/**
	 * 房屋属性
	 */
	private Integer houseAtt;
	/**
	 * 居住人数
	 */
	private Integer personCount;
	/**
	 * 业主姓名
	 */
	private String nameh;
	/**
	 * 业主性别
	 */
	private Integer sex;
	/**
	 * 人员编号
	 */
	private String personCode;
	/**
	 * 身份证号码
	 */
	private String code;
	/**
	 * 流入日期
	 */
	private java.util.Date settleInDate;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 婚姻状态
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
	 * 落实措施日期
	 */
	private java.util.Date opsDate;
	/**
	 * 持证情况
	 */
	private Integer haveStatus;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	 * 所属区域
	 */
	private String area;

	@Column(name = "HOUSE_CODE")
	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	@Column(name = "HOUSE_POLICE_NO")
	public String getHousePoliceNo() {
		return housePoliceNo;
	}

	public void setHousePoliceNo(String housePoliceNo) {
		this.housePoliceNo = housePoliceNo;
	}

	@Column(name = "HOUSE_TYPE")
	public Integer getHouseType() {
		return houseType;
	}

	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}

	@Column(name = "HOUSE_ATT")
	public Integer getHouseAtt() {
		return houseAtt;
	}

	public void setHouseAtt(Integer houseAtt) {
		this.houseAtt = houseAtt;
	}

	@Column(name = "PERSON_COUNT")
	public Integer getPersonCount() {
		return personCount;
	}

	public void setPersonCount(Integer personCount) {
		this.personCount = personCount;
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

	@Column(name = "SETTLE_IN_DATE")
	public java.util.Date getSettleInDate() {
		return settleInDate;
	}

	public void setSettleInDate(java.util.Date settleInDate) {
		this.settleInDate = settleInDate;
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

	@Column(name = "OPS_DATE")
	public java.util.Date getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(java.util.Date opsDate) {
		this.opsDate = opsDate;
	}

	@Column(name = "HAVE_STATUS")
	public Integer getHaveStatus() {
		return haveStatus;
	}

	public void setHaveStatus(Integer haveStatus) {
		this.haveStatus = haveStatus;
	}

	@Column(name = "DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}

	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}