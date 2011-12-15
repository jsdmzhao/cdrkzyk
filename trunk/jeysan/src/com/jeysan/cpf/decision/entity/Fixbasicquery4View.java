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
@Table(name = "fhp_fixbasicquery4_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery4View extends IdExtEntity {
			/**
	 * NAMEH
	 */
	private String nameh;
				/**
	 * PERSON_CODE
	 */
	private String personCode;
				/**
	 * CODE
	 */
	private String code;
				/**
	 * age
	 */
	private Integer age;
				/**
	 * minChildIndex
	 */
	private Long minchildindex;
				/**
	 * minBirthday
	 */
	private java.util.Date minbirthday;
				/**
	 * minSex
	 */
	private Long minsex;
				/**
	 * NAMEH2
	 */
	private String nameh2;
				/**
	 * DOMICILE
	 */
	private String domicile;
				/**
	 * TYPEH
	 */
	private String typeh;
				/**
	 * MONEYH
	 */
	private Double moneyh;
				/**
	 * DATEH
	 */
	private String dateh;
				/**
	 * DOMICILE_TYPE
	 */
	private Integer domicileType;
				/**
	 * area
	 */
	private String area;
			
			@Column(name="NAMEH")
	public String getNameh() {
		return nameh;
	}
	public void setNameh(String nameh) {
		this.nameh = nameh;
	}
				@Column(name="PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
				@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
				@Column(name="age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
				@Column(name="minchildindex")
	public Long getMinchildindex() {
		return minchildindex;
	}
	public void setMinchildindex(Long minchildindex) {
		this.minchildindex = minchildindex;
	}
				@Column(name="minbirthday")
	public java.util.Date getMinbirthday() {
		return minbirthday;
	}
	public void setMinbirthday(java.util.Date minbirthday) {
		this.minbirthday = minbirthday;
	}
				@Column(name="minsex")
	public Long getMinsex() {
		return minsex;
	}
	public void setMinsex(Long minsex) {
		this.minsex = minsex;
	}
				@Column(name="NAMEH2")
	public String getNameh2() {
		return nameh2;
	}
	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}
				@Column(name="DOMICILE")
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
				@Column(name="TYPEH")
	public String getTypeh() {
		return typeh;
	}
	public void setTypeh(String typeh) {
		this.typeh = typeh;
	}
				@Column(name="MONEYH")
	public Double getMoneyh() {
		return moneyh;
	}
	public void setMoneyh(Double moneyh) {
		this.moneyh = moneyh;
	}
				@Column(name="DATEH")
	public String getDateh() {
		return dateh;
	}
	public void setDateh(String dateh) {
		this.dateh = dateh;
	}
				@Column(name="DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}
	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}
				@Column(name="area")
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}