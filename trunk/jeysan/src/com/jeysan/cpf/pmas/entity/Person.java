package com.jeysan.cpf.pmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_person")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person extends IdEntity {
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 证件类型
	 */
	private String certType;
	/**
	 * 证件号码
	 */
	private String code;
	/**
	 * 人员类别
	 */
	private Integer kind;
	/**
	 * 人员编号
	 */
	private String personCode;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	 * 注销类别
	 */
	private Integer cancelType;
	/**
	 * 注销日期
	 */
	private java.util.Date cancelDate;
	/**
	 * 死亡（迁出）时间
	 */
	private java.util.Date dateh;
	/**
	 * 何地迁入(流入)
	 */
	private String settleInPlace;
	/**
	 * 迁入(流入)日期
	 */
	private java.util.Date settleInDate;
	/**
	 * 迁入(流入)原因
	 */
	private String settleInCause;
	/**
	 * 迁入(流入)类别
	 */
	private Integer settleInType;
	
	private PersonBasic personBasic;

	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}
	@Column(name = "SEX")
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "KIND")
	public Integer getKind() {
		return kind;
	}

	public void setKind(Integer kind) {
		this.kind = kind;
	}

	@Column(name = "PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}

	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}

	@Column(name = "CANCEL_TYPE")
	public Integer getCancelType() {
		return cancelType;
	}

	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
	}

	@Column(name = "CANCEL_DATE")
	public java.util.Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	@Column(name = "DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}

	@Column(name = "SETTLE_IN_PLACE")
	public String getSettleInPlace() {
		return settleInPlace;
	}

	public void setSettleInPlace(String settleInPlace) {
		this.settleInPlace = settleInPlace;
	}

	@Column(name = "SETTLE_IN_DATE")
	public java.util.Date getSettleInDate() {
		return settleInDate;
	}

	public void setSettleInDate(java.util.Date settleInDate) {
		this.settleInDate = settleInDate;
	}

	@Column(name = "SETTLE_IN_CAUSE")
	public String getSettleInCause() {
		return settleInCause;
	}

	public void setSettleInCause(String settleInCause) {
		this.settleInCause = settleInCause;
	}

	@Column(name = "SETTLE_IN_TYPE")
	public Integer getSettleInType() {
		return settleInType;
	}

	public void setSettleInType(Integer settleInType) {
		this.settleInType = settleInType;
	}
	
	
	@Column(name = "CERT_TYPE")
	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	@OneToOne(mappedBy = "person" ,cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public PersonBasic getPersonBasic() {
		return personBasic;
	}

	public void setPersonBasic(PersonBasic personBasic) {
		this.personBasic = personBasic;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}