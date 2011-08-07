package com.jeysan.cpf.bcmas.entity;

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
@Table(name = "fhp_bcs_cert")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BcsCert extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
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
	 * 经办人
	 */
	private String agent;
				/**
	 * 照片
	 */
	private String photo;
				/**
	 * 证件类型
	 */
	private Integer certType;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
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
				@Column(name="ISS_ORG_ADDRESS")
	public String getIssOrgAddress() {
		return issOrgAddress;
	}
	public void setIssOrgAddress(String issOrgAddress) {
		this.issOrgAddress = issOrgAddress;
	}
				@Column(name="CERT_CODE")
	public String getCertCode() {
		return certCode;
	}
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
				@Column(name="ZIP_CODE")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
				@Column(name="TEL")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
				@Column(name="AGENT")
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
				@Column(name="PHOTO")
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
				@Column(name="CERT_TYPE")
	public Integer getCertType() {
		return certType;
	}
	public void setCertType(Integer certType) {
		this.certType = certType;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}