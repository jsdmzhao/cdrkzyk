package com.jeysan.cpf.bcmas.entity;

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
@Table(name = "fhp_birth2_apply")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Birth2Apply extends IdExtEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
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
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="DATEH")
	public java.util.Date getDateh() {
		return dateh;
	}
	public void setDateh(java.util.Date dateh) {
		this.dateh = dateh;
	}
				@Column(name="TYPEH")
	public Integer getTypeh() {
		return typeh;
	}
	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}
				@Column(name="IS_ACCEPT")
	public Integer getIsAccept() {
		return isAccept;
	}
	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}
				@Column(name="IS_SECOND")
	public Integer getIsSecond() {
		return isSecond;
	}
	public void setIsSecond(Integer isSecond) {
		this.isSecond = isSecond;
	}
				@Column(name="COND")
	public String getCond() {
		return cond;
	}
	public void setCond(String cond) {
		this.cond = cond;
	}
				@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
				@Column(name="AGENT")
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}