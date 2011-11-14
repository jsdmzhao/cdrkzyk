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
@Table(name = "fhp_flowbasicquery13_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery13View extends IdExtEntity {
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	 * 人口数
	 */
	private Long personnum;
	/**
	 * 流入或流出类别
	 */
	private Integer arealevel;
	/**
	 * 日期
	 */
	private java.util.Date dateh;
	/**
	 * 流入或流出
	 */
	private Long inOutType;

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

	@Column(name = "personnum")
	public Long getPersonnum() {
		return personnum;
	}

	public void setPersonnum(Long personnum) {
		this.personnum = personnum;
	}

	@Column(name = "areaLevel")
	public Integer getArealevel() {
		return arealevel;
	}

	public void setArealevel(Integer arealevel) {
		this.arealevel = arealevel;
	}

	@Column(name = "dateh")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}

	@Column(name = "in_out_type")
	public Long getInOutType() {
		return inOutType;
	}

	public void setInOutType(Long inOutType) {
		this.inOutType = inOutType;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}