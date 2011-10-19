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
@Table(name = "fhp_flowbasicquery7_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery7View extends IdExtEntity {

	/**
	 * 流动人口编号
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
	 * 流入日期
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
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * 落实日期
	 */
	private java.util.Date opsDate;
	/**
	 * 未避孕原因
	 */
	private String noCause;
	/**
	 * 手术医院地址
	 */
	private String hospitalAddress;
	/**
	 * 补救措施
	 */
	private Integer repairMethod;
	/**
	 * 补救措施时间
	 */
	private java.util.Date repairDate;
	/**
	 * 补救措施地点
	 */
	private String repairAddress;
	/**
	 * 最小孩出生日期
	 */
	private java.util.Date birthday2;
	/**
	 * 子女数
	 */
	private Long childnum;
	/**
	 * 配偶姓名
	 */
	private String nameh2;
	/**
	 * 怀孕日期
	 */
	private java.util.Date conceptDate;
	/**
	 * 怀孕原因
	 */
	private String conceptCause;
	/**
	 * 怀孕结果
	 */
	private String conceptResult;
	/**
	 * 现孕状态
	 */
	private Integer currentConceptStatus;
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	 * 避孕节育未落实措施类型
	 */
	private Integer noMethodType;
	/**
	 * 补救措施未落实措施类型
	 */
	private Integer noRepairMethodType;

	@Column(name = "PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@Column(name = "TEL")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	@Column(name = "NO_CAUSE")
	public String getNoCause() {
		return noCause;
	}

	public void setNoCause(String noCause) {
		this.noCause = noCause;
	}

	@Column(name = "HOSPITAL_ADDRESS")
	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	@Column(name = "REPAIR_METHOD")
	public Integer getRepairMethod() {
		return repairMethod;
	}

	public void setRepairMethod(Integer repairMethod) {
		this.repairMethod = repairMethod;
	}

	@Column(name = "REPAIR_DATE")
	public java.util.Date getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(java.util.Date repairDate) {
		this.repairDate = repairDate;
	}

	@Column(name = "REPAIR_ADDRESS")
	public String getRepairAddress() {
		return repairAddress;
	}

	public void setRepairAddress(String repairAddress) {
		this.repairAddress = repairAddress;
	}

	@Column(name = "BIRTHDAY2")
	public java.util.Date getBirthday2() {
		return birthday2;
	}

	public void setBirthday2(java.util.Date birthday2) {
		this.birthday2 = birthday2;
	}

	@Column(name = "childnum")
	public Long getChildnum() {
		return childnum;
	}

	public void setChildnum(Long childnum) {
		this.childnum = childnum;
	}

	@Column(name = "nameh2")
	public String getNameh2() {
		return nameh2;
	}

	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}

	@Column(name = "CONCEPT_DATE")
	public java.util.Date getConceptDate() {
		return conceptDate;
	}

	public void setConceptDate(java.util.Date conceptDate) {
		this.conceptDate = conceptDate;
	}

	@Column(name = "CONCEPT_CAUSE")
	public String getConceptCause() {
		return conceptCause;
	}

	public void setConceptCause(String conceptCause) {
		this.conceptCause = conceptCause;
	}

	@Column(name = "CONCEPT_RESULT")
	public String getConceptResult() {
		return conceptResult;
	}

	public void setConceptResult(String conceptResult) {
		this.conceptResult = conceptResult;
	}

	@Column(name = "CURRENT_CONCEPT_STATUS")
	public Integer getCurrentConceptStatus() {
		return currentConceptStatus;
	}

	public void setCurrentConceptStatus(Integer currentConceptStatus) {
		this.currentConceptStatus = currentConceptStatus;
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
	
	@Column(name="NO_METHOD_TYPE")
	public Integer getNoMethodType() {
		return noMethodType;
	}

	public void setNoMethodType(Integer noMethodType) {
		this.noMethodType = noMethodType;
	}
	@Column(name="NO_REPAIR_METHOD_TYPE")
	public Integer getNoRepairMethodType() {
		return noRepairMethodType;
	}

	public void setNoRepairMethodType(Integer noRepairMethodType) {
		this.noRepairMethodType = noRepairMethodType;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}