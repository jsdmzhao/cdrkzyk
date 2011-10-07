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
import com.jeysan.cpf.pmas.entity.WomanChildren;
import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_toc_cert")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TocCert extends IdExtEntity {
	/**
	 * 人员ID
	 */
	private Person person;
	/**
	 * 子女ID
	 */
	private WomanChildren children;
	/**
	 * 发证机关
	 */
	private String issOrg;
	/**
	 * 发证日期
	 */
	private java.util.Date issDate;
	/**
	 * 证书编号
	 */
	private String certCode;
	/**
	 * 是否注销
	 */
	private Integer isCancel;
	/**
	 * 注销原因
	 */
	private String cancelCause;
	/**
	 * 注销日期
	 */
	private java.util.Date cancelDate;
	/**
	 * 独生证属性
	 */
	private Integer issAttr;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="CHILD_ID")
	public WomanChildren getChildren() {
		return children;
	}

	public void setChildren(WomanChildren children) {
		this.children = children;
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

	@Column(name = "CERT_CODE")
	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	@Column(name = "IS_CANCEL")
	public Integer getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}

	@Column(name = "CANCEL_CAUSE")
	public String getCancelCause() {
		return cancelCause;
	}

	public void setCancelCause(String cancelCause) {
		this.cancelCause = cancelCause;
	}

	@Column(name = "CANCEL_DATE")
	public java.util.Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	
	@Column(name = "ISS_ATTR")
	public Integer getIssAttr() {
		return issAttr;
	}

	public void setIssAttr(Integer issAttr) {
		this.issAttr = issAttr;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}