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
@Table(name = "fhp_death_reg")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DeathReg extends IdExtEntity {
						/**
	 * PERSON_ID
	 */
	private Long personId;
				/**
	 * 死亡日期
	 */
	private java.util.Date dateh;
				/**
	 * 死亡原因
	 */
	private String cause;
				/**
	 * 户主姓名
	 */
	private String nameh;
				/**
	 * 与户主关系
	 */
	private Integer relation;
				/**
	 * 原住址
	 */
	private String oldAddress;
				/**
	 * 备注
	 */
	private String remark;
			
						@Column(name="PERSON_ID")
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
				@Column(name="DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}
	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}
				@Column(name="CAUSE")
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
				@Column(name="NAMEH")
	public String getNameh() {
		return nameh;
	}
	public void setNameh(String nameh) {
		this.nameh = nameh;
	}
				@Column(name="RELATION")
	public Integer getRelation() {
		return relation;
	}
	public void setRelation(Integer relation) {
		this.relation = relation;
	}
				@Column(name="OLD_ADDRESS")
	public String getOldAddress() {
		return oldAddress;
	}
	public void setOldAddress(String oldAddress) {
		this.oldAddress = oldAddress;
	}
				@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}