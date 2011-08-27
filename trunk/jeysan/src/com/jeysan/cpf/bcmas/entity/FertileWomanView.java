package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_fertile_woman_view")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class FertileWomanView extends IdExtEntity {
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
	 * 年龄
	 */
	private Integer age;
	/**
	 * 证件类型
	 */
	private Integer certType;
	/**
	 * 证件号码
	 */
	private String certCode;
	/**
	 * 人员类别
	 */
	private Integer kind;
	/**
	 * 户口类别
	 */
	private Integer domicileType;
	/**
	 * 审批结果
	 */
	private Integer isAgree;
	/**
	 * 记录状态
	 */
	private Integer recordType;
	/**
	 * 取环类型
	 */
	private Integer giTypeh;
	/**
	 * 取环ID
	 */
	private Integer giId;
	/**
	 * 计算出的取环类型
	 */
	private Integer giTypeh2;
	
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
	
	
	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name = "CERT_TYPE")
	public Integer getCertType() {
		return certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}
	@Column(name = "CERT_CODE")
	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
	@Column(name = "KIND")
	public Integer getKind() {
		return kind;
	}

	public void setKind(Integer kind) {
		this.kind = kind;
	}
	@Column(name = "DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}

	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}
	@Column(name = "IS_AGREE")
	public Integer getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}
	
	
	@Column(name = "RECORD_TYPE")
	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}
	@Column(name = "gi_typeh")
	public Integer getGiTypeh() {
		return giTypeh;
	}

	public void setGiTypeh(Integer giTypeh) {
		this.giTypeh = giTypeh;
	}
	@Column(name = "gi_id")
	public Integer getGiId() {
		return giId;
	}

	public void setGiId(Integer giId) {
		this.giId = giId;
	}
	@Transient
	public Integer getGiTypeh2() {
		if(age != null){
			if(age > 49)
				return Constants.GETIUD_TYPE.OLDAGE;
		}
		if(isAgree != null){
			if(isAgree.intValue() == Constants.IS_AGREE.AGREE.intValue())
				return Constants.GETIUD_TYPE.BIRTH2;
		}
		return null;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}