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
@Table(name = "fhp_fixbasicquery10_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery10View extends IdExtEntity {
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
	 * 怀孕政策属性
	 */
	private Integer conceptPolicy;
				/**
	 * 孕产结果
	 */
	private String matenalResult;
				/**
	 * 孕产日期
	 */
	private java.util.Date endDate;
				/**
	 * 变化原因
	 */
	private String changeCause;
				/**
	 * 现孕状态
	 */
	private Integer currentConceptStatus;
				/**
	 * 避孕节育措施
	 */
	private Integer method;
				/**
	 * 补救措施
	 */
	private Integer repairMethod;
				/**
	 * 补救措施时间
	 */
	private java.util.Date repairDate;
				/**
	 * 男孩数
	 */
	private Long boynum;
				/**
	 * 女孩数
	 */
	private Long girlnum;
				/**
	 * 最小孩出生日期
	 */
	private java.util.Date minbirthday;
				/**
	 * 丈夫姓名
	 */
	private String nameh2;
				/**
	 * 户籍地
	 */
	private String domicile;
				/**
	 * 门牌号码
	 */
	private String houseNumber;
				/**
	 * 户口类别
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
				@Column(name="CONCEPT_POLICY")
	public Integer getConceptPolicy() {
		return conceptPolicy;
	}
	public void setConceptPolicy(Integer conceptPolicy) {
		this.conceptPolicy = conceptPolicy;
	}
				@Column(name="MATENAL_RESULT")
	public String getMatenalResult() {
		return matenalResult;
	}
	public void setMatenalResult(String matenalResult) {
		this.matenalResult = matenalResult;
	}
				@Column(name="END_DATE")
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
				@Column(name="CHANGE_CAUSE")
	public String getChangeCause() {
		return changeCause;
	}
	public void setChangeCause(String changeCause) {
		this.changeCause = changeCause;
	}
				@Column(name="CURRENT_CONCEPT_STATUS")
	public Integer getCurrentConceptStatus() {
		return currentConceptStatus;
	}
	public void setCurrentConceptStatus(Integer currentConceptStatus) {
		this.currentConceptStatus = currentConceptStatus;
	}
				@Column(name="METHOD")
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
				@Column(name="REPAIR_METHOD")
	public Integer getRepairMethod() {
		return repairMethod;
	}
	public void setRepairMethod(Integer repairMethod) {
		this.repairMethod = repairMethod;
	}
				@Column(name="REPAIR_DATE")
	public java.util.Date getRepairDate() {
		return repairDate;
	}
	public void setRepairDate(java.util.Date repairDate) {
		this.repairDate = repairDate;
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
				@Column(name="minbirthday")
	public java.util.Date getMinbirthday() {
		return minbirthday;
	}
	public void setMinbirthday(java.util.Date minbirthday) {
		this.minbirthday = minbirthday;
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
				@Column(name="HOUSE_NUMBER")
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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