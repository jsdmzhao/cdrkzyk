package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_marry_cert")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MarryCert extends IdExtEntity {
	/**
	 * PERSON_ID
	 */
	private Person person;
	/**
	 * 发证机关
	 */
	private String issOrg;
	/**
	 * 发证日期
	 */
	private java.util.Date issDate;
	/**
	 * 发证机关地址
	 */
	private String issOrgAddress;
	/**
	 * 证书编号
	 */
	private String certCode;
	/**
	 * 邮政编码
	 */
	private String zipCode;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 有效期
	 */
	private java.util.Date validPeriod;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 结婚时间
	 */
	private java.util.Date marryDate;
	/**
	 * 所在乡（镇、街道）计生办电话
	 */
	private String fpoTel1;
	/**
	 * 配偶所在乡（镇、街道）计生办电话
	 */
	private String fpoTel2;
	/**
	 * 发证时已有子女数（男）
	 */
	private Integer beforeBoyCount;
	/**
	 * 发证时已有子女数（女）
	 */
	private Integer beforeGirlCount;
	/**
	 * 发证后生育子女数（男）
	 */
	private Integer afterBoyCount;
	/**
	 * 发证后生育子女数（女）
	 */
	private Integer afterGirlCount;
	/**
	 * 照片
	 */
	private String photo;
	/**
	 * 证书类型
	 */
	private Integer issType;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "ISS_ORG")
	public String getIssOrg() {
		return issOrg;
	}

	public void setIssOrg(String issOrg) {
		this.issOrg = issOrg;
	}

	@Column(name = "ISS_DATE")
	public java.util.Date getIssDate() {
		return issDate;
	}

	public void setIssDate(java.util.Date issDate) {
		this.issDate = issDate;
	}

	@Column(name = "ISS_ORG_ADDRESS")
	public String getIssOrgAddress() {
		return issOrgAddress;
	}

	public void setIssOrgAddress(String issOrgAddress) {
		this.issOrgAddress = issOrgAddress;
	}

	@Column(name = "CERT_CODE")
	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	@Column(name = "ZIP_CODE")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "TEL")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "VALID_PERIOD")
	public java.util.Date getValidPeriod() {
		return validPeriod;
	}

	public void setValidPeriod(java.util.Date validPeriod) {
		this.validPeriod = validPeriod;
	}

	@Column(name = "AGENT")
	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Column(name = "MARRY_DATE")
	public java.util.Date getMarryDate() {
		return marryDate;
	}

	public void setMarryDate(java.util.Date marryDate) {
		this.marryDate = marryDate;
	}

	@Column(name = "FPO_TEL1")
	public String getFpoTel1() {
		return fpoTel1;
	}

	public void setFpoTel1(String fpoTel1) {
		this.fpoTel1 = fpoTel1;
	}

	@Column(name = "FPO_TEL2")
	public String getFpoTel2() {
		return fpoTel2;
	}

	public void setFpoTel2(String fpoTel2) {
		this.fpoTel2 = fpoTel2;
	}

	@Column(name = "BEFORE_BOY_COUNT")
	public Integer getBeforeBoyCount() {
		return beforeBoyCount;
	}

	public void setBeforeBoyCount(Integer beforeBoyCount) {
		this.beforeBoyCount = beforeBoyCount;
	}

	@Column(name = "BEFORE_GIRL_COUNT")
	public Integer getBeforeGirlCount() {
		return beforeGirlCount;
	}

	public void setBeforeGirlCount(Integer beforeGirlCount) {
		this.beforeGirlCount = beforeGirlCount;
	}

	@Column(name = "AFTER_BOY_COUNT")
	public Integer getAfterBoyCount() {
		return afterBoyCount;
	}

	public void setAfterBoyCount(Integer afterBoyCount) {
		this.afterBoyCount = afterBoyCount;
	}

	@Column(name = "AFTER_GIRL_COUNT")
	public Integer getAfterGirlCount() {
		return afterGirlCount;
	}

	public void setAfterGirlCount(Integer afterGirlCount) {
		this.afterGirlCount = afterGirlCount;
	}

	@Column(name = "PHOTO")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	@Column(name = "ISS_TYPE")
	public Integer getIssType() {
		return issType;
	}

	public void setIssType(Integer issType) {
		this.issType = issType;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}