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
@Table(name = "fhp_fixbasicquery12_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery12View extends IdExtEntity {
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
	 * 婚姻状况
	 */
	private Integer marryStatus;
				/**
	 * 初婚日期
	 */
	private java.util.Date firstMarryDate;
				/**
	 * 联系电话
	 */
	private String tel;
				/**
	 * 政治面貌
	 */
	private Integer politicalStatus;
				/**
	 * 门牌号
	 */
	private String houseNo;
				/**
	 * 子女姓名
	 */
	private String nameh2;
				/**
	 * 子女性别
	 */
	private Integer sex;
				/**
	 * 孩次
	 */
	private Integer childIndex;
				/**
	 * 子女出生日期
	 */
	private java.util.Date birthday2;
				/**
	 * 政策内外
	 */
	private Integer policy;
				/**
	 * 政策外类型
	 */
	private Integer outType;
				/**
	 * 变化日期
	 */
	private java.util.Date changeDate;
				/**
	 * 变化原因
	 */
	private String changeCause;
				/**
	 * 血缘关系
	 */
	private String kinship;
				/**
	 * 上报日期
	 */
	private java.util.Date upDate;
				/**
	 * 丈夫姓名
	 */
	private String nameh3;
				/**
	 * 丈夫政治面貌
	 */
	private Integer politicalStatus2;
				/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	/**
	 * 是否漏报
	 */
	private Integer miss;
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
				@Column(name="MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}
	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}
				@Column(name="FIRST_MARRY_DATE")
	public java.util.Date getFirstMarryDate() {
		return firstMarryDate;
	}
	public void setFirstMarryDate(java.util.Date firstMarryDate) {
		this.firstMarryDate = firstMarryDate;
	}
				@Column(name="TEL")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
				@Column(name="POLITICAL_STATUS")
	public Integer getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
				@Column(name="HOUSE_NO")
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
				@Column(name="NAMEH2")
	public String getNameh2() {
		return nameh2;
	}
	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}
				@Column(name="sex")
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
				@Column(name="CHILD_INDEX")
	public Integer getChildIndex() {
		return childIndex;
	}
	public void setChildIndex(Integer childIndex) {
		this.childIndex = childIndex;
	}
				@Column(name="BIRTHDAY2")
	public java.util.Date getBirthday2() {
		return birthday2;
	}
	public void setBirthday2(java.util.Date birthday2) {
		this.birthday2 = birthday2;
	}
				@Column(name="POLICY")
	public Integer getPolicy() {
		return policy;
	}
	public void setPolicy(Integer policy) {
		this.policy = policy;
	}
				@Column(name="OUT_TYPE")
	public Integer getOutType() {
		return outType;
	}
	public void setOutType(Integer outType) {
		this.outType = outType;
	}
				@Column(name="CHANGE_DATE")
	public java.util.Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(java.util.Date changeDate) {
		this.changeDate = changeDate;
	}
				@Column(name="CHANGE_CAUSE")
	public String getChangeCause() {
		return changeCause;
	}
	public void setChangeCause(String changeCause) {
		this.changeCause = changeCause;
	}
				@Column(name="KINSHIP")
	public String getKinship() {
		return kinship;
	}
	public void setKinship(String kinship) {
		this.kinship = kinship;
	}
				@Column(name="UP_DATE")
	public java.util.Date getUpDate() {
		return upDate;
	}
	public void setUpDate(java.util.Date upDate) {
		this.upDate = upDate;
	}
				@Column(name="NAMEH3")
	public String getNameh3() {
		return nameh3;
	}
	public void setNameh3(String nameh3) {
		this.nameh3 = nameh3;
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
	@Column(name="miss")
	public Integer getMiss() {
		return miss;
	}
	public void setMiss(Integer miss) {
		this.miss = miss;
	}
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}