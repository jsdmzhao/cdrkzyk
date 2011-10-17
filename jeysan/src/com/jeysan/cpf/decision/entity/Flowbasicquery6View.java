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
@Table(name = "fhp_flowbasicquery6_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Flowbasicquery6View extends IdExtEntity {
	/**
	 * 流动人口编号
	 */
	private String personCode;
	/**
	 * 姓名
	 */
	private String nameh;
	/**
	 * 身份证号码
	 */
	private String code;
	/**
	 * 流入日期
	 */
	private java.util.Date settleInDate;
	/**
	 * 出生日期
	 */
	private java.util.Date birthday;
	/**
	 * 婚姻状况
	 */
	private Integer marryStatus;
	/**
	 * 征收机关类型
	 */
	private Integer lodType;
	/**
	 * 户籍地
	 */
	private String domicile;
	/**
	 * 居住地
	 */
	private String address;
	/**
	 * 联系方式
	 */
	private String tel;
	/**
	 * 子女数
	 */
	private Long childnum;
	/**
	 * 征收原因
	 */
	private String cause;
	/**
	 * 应缴金额
	 */
	private Double totalMoney;
	/**
	 * 已交金额
	 */
	private Double yetMoney;
	/**
	 * 流出日期
	 */
	private java.util.Date outDate;
	/**
	 * 未交金额
	 */
	private Double noMoney;
	/**
	 * 分期数
	 */
	private Integer installmentNum;
	/**
	 * 征收机关
	 */
	private String lodOrg;
	/**
	 * 首次缴款日期
	 */
	private java.util.Date datehFirst;
	/**
	 * 首次缴款金额
	 */
	private Double moneyhFirst;
	/**
	 * 二次缴款日期
	 */
	private java.util.Date datehSecond;
	/**
	 * 二次缴款金额
	 */
	private Double moneyhSecond;
	/**
	 * 三次缴款日期
	 */
	private java.util.Date datehThird;
	/**
	 * 三次缴款金额
	 */
	private Double moneyhThird;
	/**
	 * 配偶姓名
	 */
	private String nameh2;
	/**
	 * 配偶户籍地
	 */
	private String domicile2;
	/**
	 * 所属区域
	 */
	private String area;
	/**
	 * 户口类别
	 */
	private Integer domicileType;

	@Column(name = "PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "NAMEH")
	public String getNameh() {
		return nameh;
	}

	public void setNameh(String nameh) {
		this.nameh = nameh;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "SETTLE_IN_DATE")
	public java.util.Date getSettleInDate() {
		return settleInDate;
	}

	public void setSettleInDate(java.util.Date settleInDate) {
		this.settleInDate = settleInDate;
	}

	@Column(name = "BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	@Column(name = "DOMICILE")
	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "TEL")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "childnum")
	public Long getChildnum() {
		return childnum;
	}

	public void setChildnum(Long childnum) {
		this.childnum = childnum;
	}

	@Column(name = "CAUSE")
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Column(name = "TOTAL_MONEY")
	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Column(name = "YET_MONEY")
	public Double getYetMoney() {
		return yetMoney;
	}

	public void setYetMoney(Double yetMoney) {
		this.yetMoney = yetMoney;
	}

	@Column(name = "OUT_DATE")
	public java.util.Date getOutDate() {
		return outDate;
	}

	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}

	@Column(name = "no_money")
	public Double getNoMoney() {
		return noMoney;
	}

	public void setNoMoney(Double noMoney) {
		this.noMoney = noMoney;
	}

	@Column(name = "INSTALLMENT_NUM")
	public Integer getInstallmentNum() {
		return installmentNum;
	}

	public void setInstallmentNum(Integer installmentNum) {
		this.installmentNum = installmentNum;
	}

	@Column(name = "LOD_ORG")
	public String getLodOrg() {
		return lodOrg;
	}

	public void setLodOrg(String lodOrg) {
		this.lodOrg = lodOrg;
	}

	@Column(name = "dateh_first")
	public java.util.Date getDatehFirst() {
		return datehFirst;
	}

	public void setDatehFirst(java.util.Date datehFirst) {
		this.datehFirst = datehFirst;
	}

	@Column(name = "moneyh_first")
	public Double getMoneyhFirst() {
		return moneyhFirst;
	}

	public void setMoneyhFirst(Double moneyhFirst) {
		this.moneyhFirst = moneyhFirst;
	}

	@Column(name = "dateh_second")
	public java.util.Date getDatehSecond() {
		return datehSecond;
	}

	public void setDatehSecond(java.util.Date datehSecond) {
		this.datehSecond = datehSecond;
	}

	@Column(name = "moneyh_second")
	public Double getMoneyhSecond() {
		return moneyhSecond;
	}

	public void setMoneyhSecond(Double moneyhSecond) {
		this.moneyhSecond = moneyhSecond;
	}

	@Column(name = "dateh_third")
	public java.util.Date getDatehThird() {
		return datehThird;
	}

	public void setDatehThird(java.util.Date datehThird) {
		this.datehThird = datehThird;
	}

	@Column(name = "moneyh_third")
	public Double getMoneyhThird() {
		return moneyhThird;
	}

	public void setMoneyhThird(Double moneyhThird) {
		this.moneyhThird = moneyhThird;
	}

	@Column(name = "NAMEH2")
	public String getNameh2() {
		return nameh2;
	}

	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}

	@Column(name = "DOMICILE2")
	public String getDomicile2() {
		return domicile2;
	}

	public void setDomicile2(String domicile2) {
		this.domicile2 = domicile2;
	}

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
	
	
	@Column(name = "LOD_TYPE")
	public Integer getLodType() {
		return lodType;
	}

	public void setLodType(Integer lodType) {
		this.lodType = lodType;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}