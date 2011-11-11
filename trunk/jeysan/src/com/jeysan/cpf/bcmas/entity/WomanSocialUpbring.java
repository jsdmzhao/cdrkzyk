package com.jeysan.cpf.bcmas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;
import com.jeysan.modules.orm.hibernate.IdExtEntity;
import com.jeysan.modules.utils.math.MoneyUtil;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_woman_social_upbring")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanSocialUpbring extends IdExtEntity {
	/**
	 * WOMAN_ID
	 */
	private FertileWoman fertileWoman;
	/**
	 * 征收原因
	 */
	private String cause;
	/**
	 * 政策外生育日期
	 */
	private java.util.Date outDate;
	/**
	 * 应交金额
	 */
	private Double totalMoney;
	/**
	 * 已交金额
	 */
	private Double yetMoney;
	/**
	 * 是否分期
	 */
	private Integer isInstallment;
	/**
	 * 分期数
	 */
	private Integer installmentNum;
	
	/**
	 * 是否缴清
	 */
	private Integer isPayup;
	
	/**
	 * 缴交期限
	 */
	private java.util.Date endDate;
	/**
	 * 决定书编号
	 */
	private String lodCode;
	/**
	 * 决定书日期
	 */
	private java.util.Date lodDate;
	/**
	 * 征收机关
	 */
	private String lodOrg;
	/**
	 * 征收经办人
	 */
	private String lodCharger;
	/**
	 * 征收机关类型
	 */
	private Integer lodType;
	
	/**
	 * 缴交详情
	 */
	
	private List<WomanUpbringDetail> detailList = Lists.newArrayList();
	
	@OneToMany(mappedBy="upbring",cascade={CascadeType.REMOVE})
    @OrderBy("counth")
	public List<WomanUpbringDetail> getDetailList() {
		return detailList;
	}
	
	

	public void setDetailList(List<WomanUpbringDetail> detailList) {
		this.detailList = detailList;
	}



	@ManyToOne(optional=false)
	@JoinColumn(name = "WOMAN_ID")
	public FertileWoman getFertileWoman() {
		return fertileWoman;
	}

	public void setFertileWoman(FertileWoman fertileWoman) {
		this.fertileWoman = fertileWoman;
	}

	@Column(name = "CAUSE")
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Column(name = "OUT_DATE")
	public java.util.Date getOutDate() {
		return outDate;
	}

	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}

	@Column(name = "TOTAL_MONEY")
	public Double getTotalMoney() {
		return totalMoney;
	}
	
	@Transient
	public String getTotalMoneyStr() {
		if(totalMoney != null)
			return MoneyUtil.numToRMBStr(this.totalMoney);
		return "";
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

	@Column(name = "IS_INSTALLMENT")
	public Integer getIsInstallment() {
		return isInstallment;
	}

	public void setIsInstallment(Integer isInstallment) {
		this.isInstallment = isInstallment;
	}

	@Column(name = "END_DATE")
	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "LOD_CODE")
	public String getLodCode() {
		return lodCode;
	}

	public void setLodCode(String lodCode) {
		this.lodCode = lodCode;
	}

	@Column(name = "LOD_DATE")
	public java.util.Date getLodDate() {
		return lodDate;
	}

	public void setLodDate(java.util.Date lodDate) {
		this.lodDate = lodDate;
	}

	@Column(name = "LOD_ORG")
	public String getLodOrg() {
		return lodOrg;
	}

	public void setLodOrg(String lodOrg) {
		this.lodOrg = lodOrg;
	}

	@Column(name = "LOD_CHARGER")
	public String getLodCharger() {
		return lodCharger;
	}

	public void setLodCharger(String lodCharger) {
		this.lodCharger = lodCharger;
	}
	
	
	@Column(name = "IS_PAYUP")
	public Integer getIsPayup() {
		return isPayup;
	}



	public void setIsPayup(Integer isPayup) {
		this.isPayup = isPayup;
	}

	

	@Column(name = "INSTALLMENT_NUM")
	public Integer getInstallmentNum() {
		return installmentNum;
	}



	public void setInstallmentNum(Integer installmentNum) {
		this.installmentNum = installmentNum;
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