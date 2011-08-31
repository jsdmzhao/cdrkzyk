package com.jeysan.cpf.bcmas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_bcs_cert_check")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BcsCertCheck extends IdExtEntity {
	/**
	 * 证书ID
	 */
	private BcsCert bcs;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 日期
	 */
	private java.util.Date dateh;
	/**
	 * 经办人
	 */
	private String agent;

	@ManyToOne(optional=false)
	@JoinColumn(name = "CERT_ID")
	public BcsCert getBcs() {
		return bcs;
	}
	
	public void setBcs(BcsCert bcs) {
		this.bcs = bcs;
	}

	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}

	@Column(name = "AGENT")
	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}