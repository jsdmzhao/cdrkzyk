package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "FHP_BCS_CERT_CHANGE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BcsCertChange extends IdExtEntity {
	/**
	 * CERT_ID
	 */
	private Long certId;
	/**
	 * 原因
	 */
	private Integer cause;
	/**
	 * 日期
	 */
	private java.util.Date dateh;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 类型
	 */
	private Integer typeh;

	
	@Column(name = "CERT_ID")
	public Long getCertId() {
		return certId;
	}



	public void setCertId(Long certId) {
		this.certId = certId;
	}


	@Column(name = "CAUSE")
	public Integer getCause() {
		return cause;
	}



	public void setCause(Integer cause) {
		this.cause = cause;
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


	@Column(name = "TYPEH")
	public Integer getTypeh() {
		return typeh;
	}



	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}



	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}