﻿package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_fertile_woman")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FertileWoman extends IdExtEntity {
	/**
	 * PERSON_ID
	 */
	private Person person;
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 建卡日期
	 */
	private java.util.Date createDate;
	/**
	 * 妇女类别
	 */
	private Integer typeh;
	/**
	 * 一孩登记状态
	 */
	private Integer registerType;
	/**
	 * 再生育申请状态
	 */
	private Integer birth2Type;
	/**
	 * 保险状态
	 */
	private Integer assStatus;
	/**
	 * 卡片状态
	 */
	private Integer cardStatus;
	/**
	 * 妇女编码
	 */
	private String code;
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 备注
	 */
	private String remark;
	
	private WomanBasic womanBasic = new WomanBasic();

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}
	@Column(name = "CREATE_DATE")
	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "TYPEH")
	public Integer getTypeh() {
		return typeh;
	}

	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "AREA")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	@OneToOne(mappedBy = "fertileWoman" ,cascade = { CascadeType.PERSIST, CascadeType.MERGE , CascadeType.REMOVE })
	public WomanBasic getWomanBasic() {
		return womanBasic;
	}

	public void setWomanBasic(WomanBasic womanBasic) {
		this.womanBasic = womanBasic;
	}
	
	
	@Column(name = "REGISTER_TYPE")
	public Integer getRegisterType() {
		return registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}
	
	
	@Column(name = "BIRTH2_TYPE")
	public Integer getBirth2Type() {
		return birth2Type;
	}

	public void setBirth2Type(Integer birth2Type) {
		this.birth2Type = birth2Type;
	}
	
	
	@Column(name = "ASS_STATUS")
	public Integer getAssStatus() {
		return assStatus;
	}

	public void setAssStatus(Integer assStatus) {
		this.assStatus = assStatus;
	}
	
	
	@Column(name = "CARD_STATUS")
	public Integer getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(Integer cardStatus) {
		this.cardStatus = cardStatus;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}