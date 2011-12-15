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
@Table(name = "fhp_fixbasicquery5_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery5View extends IdExtEntity {
			/**
	 * 妇女姓名
	 */
	private String nameh;
				/**
	 * 育龄妇女编码
	 */
	private String personCode;
				/**
	 * 身份证号
	 */
	private String code;
				/**
	 * 年龄
	 */
	private Integer age;
				/**
	 * 孩次
	 */
	private Long minchildindex;
				/**
	 * 最小孩出生日期
	 */
	private java.util.Date minbirthday;
				/**
	 * 最小孩性别
	 */
	private Long minsex;
				/**
	 * 丈夫姓名
	 */
	private String nameh2;
				/**
	 * 丈夫户籍地
	 */
	private String domicile;
				/**
	 * 丈夫户口
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