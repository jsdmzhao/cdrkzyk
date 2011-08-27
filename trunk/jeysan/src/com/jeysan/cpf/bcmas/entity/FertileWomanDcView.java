package com.jeysan.cpf.bcmas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_fertile_woman_dc_view")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class FertileWomanDcView implements Serializable {
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 妇女类别
	 */
	private Integer typeh;
	/**
	 * 妇女编码
	 */
	private String code;
	/**
	 * 所属区域
	 */
	private String area;
	
	/**
	 * 婚姻状态
	 */
	private Integer marryStatus;
	/**
	 * 夫婚姻状态
	 */
	private Integer spouseMarryStatus;
	
	/**
	 * 轮次起始年月
	 */
	private String start;
	/**
	 * DC_ID
	 */
	private Long dcId;
	/**
	 * 查环查孕类型
	 */
	private Integer dcTypeh;
	/**
	 * 查环查孕类型原因
	 */
	private String cause;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 证件号码
	 */
	private String certCode;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	 * 职业
	 */
	private Integer job;
	/**
	 * 工作单位
	 */
	private String company;
	/**
	 * 户口性质
	 */
	private Integer househodeKind;
	/**
	 * 现居住地门牌号码
	 */
	private String houseNo;
	/**
	 * 男孩数
	 */
	private Integer boyCount;
	/**
	 * 女孩数
	 */
	private Integer girlCount;
	/**
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * 未避孕原因
	 */
	private String noCause;
	/**
	 * 手术日期
	 */
	private java.util.Date opsDate;
	/**
	 * 年份
	 */
	private Integer year;
	
	private String id;
	
	private String id_;
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "ID_")
	public String getId_() {
		return id_;
	}

	public void setId_(String id_) {
		this.id_ = id_;
	}
	
	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}

	@Column(name = "TYPEH")
	public Integer getTypeh() {
		return typeh;
	}

	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "AREA")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	@Column(name = "SPOUSE_MARRY_STATUS")
	public Integer getSpouseMarryStatus() {
		return spouseMarryStatus;
	}

	public void setSpouseMarryStatus(Integer spouseMarryStatus) {
		this.spouseMarryStatus = spouseMarryStatus;
	}

	@Column(name = "START")
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "DC_TYPEH")
	public Integer getDcTypeh() {
		return dcTypeh;
	}

	public void setDcTypeh(Integer dcTypeh) {
		this.dcTypeh = dcTypeh;
	}

	@Column(name = "CAUSE")
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
	
	@Column(name = "DC_ID")
	public Long getDcId() {
		return dcId;
	}

	public void setDcId(Long dcId) {
		this.dcId = dcId;
	}
	
	
	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name = "CERT_CODE")
	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
	@Column(name = "DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}

	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}
	
	
	@Column(name = "JOB")
	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}
	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	@Column(name = "HOUSEHODE_KIND")
	public Integer getHousehodeKind() {
		return househodeKind;
	}

	public void setHousehodeKind(Integer househodeKind) {
		this.househodeKind = househodeKind;
	}
	@Column(name = "HOUSE_NO")
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	
	
	@Column(name = "boy_count")
	public Integer getBoyCount() {
		return boyCount;
	}

	public void setBoyCount(Integer boyCount) {
		this.boyCount = boyCount;
	}
	@Column(name = "girl_count")
	public Integer getGirlCount() {
		return girlCount;
	}

	public void setGirlCount(Integer girlCount) {
		this.girlCount = girlCount;
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
	
	
	@Column(name = "YEAR")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}