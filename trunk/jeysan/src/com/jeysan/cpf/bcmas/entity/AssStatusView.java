package com.jeysan.cpf.bcmas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_ass_view")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class AssStatusView extends IdExtEntity {
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 妇女类别
	 */
	private Integer typeh;
	/**
	 * 妇女编码
	 */
	private String code;
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 投保情况
	 */
	private Integer assStatus;
	/**
	 * 户口性质
	 */
	private Integer househodeKind;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 避孕节育措施
	 */
	private Integer method;
	/**
	 * NAMEH
	 */
	private String spNameh;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	
	private Integer boyCount;
	
	private Integer girlCount;
	
	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
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
	
	@Column(name = "HOUSEHODE_KIND")
	public Integer getHousehodeKind() {
		return househodeKind;
	}

	public void setHousehodeKind(Integer househodeKind) {
		this.househodeKind = househodeKind;
	}
	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}
	@Column(name = "METHOD")
	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}
	@Column(name = "sp_nameh")
	public String getSpNameh() {
		return spNameh;
	}

	public void setSpNameh(String spNameh) {
		this.spNameh = spNameh;
	}

	@Column(name = "ASS_STATUS")
	public Integer getAssStatus() {
		return assStatus;
	}

	public void setAssStatus(Integer assStatus) {
		this.assStatus = assStatus;
	}
	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	
	@Column(name = "boy_Count")
	public Integer getBoyCount() {
		return boyCount;
	}

	public void setBoyCount(Integer boyCount) {
		this.boyCount = boyCount;
	}
	@Column(name = "girl_Count")
	public Integer getGirlCount() {
		return girlCount;
	}

	public void setGirlCount(Integer girlCount) {
		this.girlCount = girlCount;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}