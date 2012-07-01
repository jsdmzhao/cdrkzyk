package com.jeysan.cpf.pmas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_person")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person extends IdExtEntity {
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 性别
	 */
	private Integer sex;
	private String sexLabel;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 证件类型
	 */
	private Integer certType;
	private String certTypeLabel;
	/**
	 * 证件号码
	 */
	private String code;
	/**
	 * 人员类别
	 */
	private Integer kind;
	private String kindLabel;
	/**
	 * 人员编号
	 */
	private String personCode;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	private String domicileTypeLabel;
	/**
	 * 注销类别
	 */
	private Integer cancelType;
	private String cancelTypeLabel;
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
	private String settleInTypeLabel;
	/**
	 * 所属区域
	 */
	private String area;
	
	private PersonBasic personBasic = new PersonBasic();
	
	//private FertileWoman fertileWoman = new FertileWoman();
	
	/**
	 * 子女
	 */
	private List<WomanChildren> womanChildrenLst = Lists.newArrayList();

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
	public Integer getCertType() {
		return certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}
	
	@Column(name = "AREA")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@OneToOne(mappedBy = "person" ,cascade = { CascadeType.PERSIST, CascadeType.MERGE , CascadeType.REMOVE })
	public PersonBasic getPersonBasic() {
		return personBasic;
	}

	public void setPersonBasic(PersonBasic personBasic) {
		this.personBasic = personBasic;
	}
	
	
	/*@OneToOne(mappedBy = "person" ,cascade = { CascadeType.PERSIST, CascadeType.MERGE , CascadeType.REMOVE })
	public FertileWoman getFertileWoman() {
		return fertileWoman;
	}

	public void setFertileWoman(FertileWoman fertileWoman) {
		this.fertileWoman = fertileWoman;
	}*/

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="PERSON_ID")
    @OrderBy("childIndex")
	public List<WomanChildren> getWomanChildrenLst() {
		return womanChildrenLst;
	}

	public void setWomanChildrenLst(List<WomanChildren> womanChildrenLst) {
		this.womanChildrenLst = womanChildrenLst;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
	@Transient
	public String getSexLabel() {
		return sexLabel;
	}

	public void setSexLabel(String sexLabel) {
		this.sexLabel = sexLabel;
	}
	@Transient
	public String getCertTypeLabel() {
		return certTypeLabel;
	}

	public void setCertTypeLabel(String certTypeLabel) {
		this.certTypeLabel = certTypeLabel;
	}
	@Transient
	public String getKindLabel() {
		return kindLabel;
	}

	public void setKindLabel(String kindLabel) {
		this.kindLabel = kindLabel;
	}
	@Transient
	public String getDomicileTypeLabel() {
		return domicileTypeLabel;
	}

	public void setDomicileTypeLabel(String domicileTypeLabel) {
		this.domicileTypeLabel = domicileTypeLabel;
	}
	@Transient
	public String getCancelTypeLabel() {
		return cancelTypeLabel;
	}

	public void setCancelTypeLabel(String cancelTypeLabel) {
		this.cancelTypeLabel = cancelTypeLabel;
	}
	@Transient
	public String getSettleInTypeLabel() {
		return settleInTypeLabel;
	}

	public void setSettleInTypeLabel(String settleInTypeLabel) {
		this.settleInTypeLabel = settleInTypeLabel;
	}
	
	
	
}