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

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_woman_five_period")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanFivePeriod extends IdExtEntity {
	/**
	 * WOMAN_ID
	 */
	private FertileWoman fertileWoman;
	/**
	 * 教育类型
	 */
	private String eduType;
	/**
	 * 教育日期
	 */
	private java.util.Date eduDate;
	/**
	 * 教育地点
	 */
	private String eduAddress;

	
	@ManyToOne(optional=false)
	@JoinColumn(name = "WOMAN_ID")
	public FertileWoman getFertileWoman() {
		return fertileWoman;
	}

	public void setFertileWoman(FertileWoman fertileWoman) {
		this.fertileWoman = fertileWoman;
	}

	@Column(name = "EDU_TYPE")
	public String getEduType() {
		return eduType;
	}

	public void setEduType(String eduType) {
		this.eduType = eduType;
	}

	@Column(name = "EDU_DATE")
	public java.util.Date getEduDate() {
		return eduDate;
	}

	public void setEduDate(java.util.Date eduDate) {
		this.eduDate = eduDate;
	}

	@Column(name = "EDU_ADDRESS")
	public String getEduAddress() {
		return eduAddress;
	}

	public void setEduAddress(String eduAddress) {
		this.eduAddress = eduAddress;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}