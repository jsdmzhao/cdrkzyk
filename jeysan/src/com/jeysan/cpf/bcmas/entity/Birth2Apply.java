package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;
import com.jeysan.modules.utils.date.DateUtil;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_birth2_apply")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value={"hibernateLazyInitializer"}) 
public class Birth2Apply extends IdExtEntity {
	/**
	 * WOMAN_ID
	 */
	private FertileWoman fertileWoman;
	/**
	 * 申请日期
	 */
	private java.util.Date dateh;

	/**
	 * 申请类型
	 */
	private Integer typeh;
	/**
	 * 是否接受申请
	 */
	private Integer isAccept;
	/**
	 * 是否再生二孩
	 */
	private Integer isSecond;
	/**
	 * 审批状态
	 */
	private Integer checkType;
	/**
	 * 申请条件
	 */
	private String cond;
	/**
	 * 申请书编号
	 */
	private String code;
	/**
	 * 经办人
	 */
	private String agent;
	
	private Birth2Check birth2Check = new Birth2Check();
	
	
	@OneToOne(mappedBy = "birth2Apply" ,cascade = { CascadeType.PERSIST, CascadeType.MERGE , CascadeType.REMOVE })
	@JsonIgnore
	public Birth2Check getBirth2Check() {
		return birth2Check;
	}

	public void setBirth2Check(Birth2Check birth2Check) {
		this.birth2Check = birth2Check;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "WOMAN_ID")
	@JsonIgnore
	public FertileWoman getFertileWoman() {
		return fertileWoman;
	}

	public void setFertileWoman(FertileWoman fertileWoman) {
		this.fertileWoman = fertileWoman;
	}
	
	@Column(name = "DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}

	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}

	@Column(name = "TYPEH")
	public Integer getTypeh() {
		return typeh;
	}

	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}

	@Column(name = "IS_ACCEPT")
	public Integer getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}

	@Column(name = "IS_SECOND")
	public Integer getIsSecond() {
		return isSecond;
	}

	public void setIsSecond(Integer isSecond) {
		this.isSecond = isSecond;
	}

	@Column(name = "COND")
	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "AGENT")
	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	
	@Column(name = "CHECK_TYPE")
	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}
	
	
	@Transient
	public String getDatehLabel() {
		if(this.dateh != null)
			return DateUtil.convertDateToString(this.dateh,"yyyy-MM-dd");
		return null;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}