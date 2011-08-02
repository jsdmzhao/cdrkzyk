package com.jeysan.cpf.bcmas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_woman_award")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WomanAward extends IdEntity {
						/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 奖励日期
	 */
	private java.util.Date awardDate;
				/**
	 * 奖励内容
	 */
	private String awardContent;
				/**
	 * 奖励经办人
	 */
	private String agent;
				/**
	 * 奖励类别
	 */
	private Integer typeh;
			
						@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="AWARD_DATE")
	public java.util.Date getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(java.util.Date awardDate) {
		this.awardDate = awardDate;
	}
				@Column(name="AWARD_CONTENT")
	public String getAwardContent() {
		return awardContent;
	}
	public void setAwardContent(String awardContent) {
		this.awardContent = awardContent;
	}
				@Column(name="AGENT")
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
				@Column(name="TYPEH")
	public Integer getTypeh() {
		return typeh;
	}
	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}