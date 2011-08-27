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
 * 个人双查轮次
 */
@Entity
@Table(name = "fhp_double_check")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DoubleCheck extends IdExtEntity {
	/**
	 * 轮次起始年月
	 */
	private String start;
	/**
	 * WOMAN_ID
	 */
	private FertileWoman fertileWoman;
	/**
	 * 查环查孕类型
	 */
	private Integer typeh;
	/**
	 * 查环查孕类型原因
	 */
	private String cause;
	/**
	 * 批次ID
	 */
	private DoubleCheck2 dc2;
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "DC_ID")
	public DoubleCheck2 getDc2() {
		return dc2;
	}

	public void setDc2(DoubleCheck2 dc2) {
		this.dc2 = dc2;
	}

	@Column(name = "START")
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}


	@ManyToOne(optional = false)
	@JoinColumn(name = "WOMAN_ID")
	public FertileWoman getFertileWoman() {
		return fertileWoman;
	}

	public void setFertileWoman(FertileWoman fertileWoman) {
		this.fertileWoman = fertileWoman;
	}

	@Column(name = "TYPEH")
	public Integer getTypeh() {
		return typeh;
	}

	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}

	@Column(name = "CAUSE")
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}