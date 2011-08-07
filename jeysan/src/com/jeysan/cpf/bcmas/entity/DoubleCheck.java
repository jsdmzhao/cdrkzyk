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
@Table(name = "fhp_double_check")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DoubleCheck extends IdExtEntity {
						/**
	 * 每年双查次数
	 */
	private Integer count;
				/**
	 * 轮次起始年月
	 */
	private String start;
				/**
	 * 年度
	 */
	private Integer year;
				/**
	 * WOMAN_ID
	 */
	private Long womanId;
				/**
	 * 查环查孕类型
	 */
	private Integer typeh;
				/**
	 * 查环查孕类型原因
	 */
	private String cause;
			
						@Column(name="COUNT")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
				@Column(name="START")
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
				@Column(name="YEAR")
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
				@Column(name="WOMAN_ID")
	public Long getWomanId() {
		return womanId;
	}
	public void setWomanId(Long womanId) {
		this.womanId = womanId;
	}
				@Column(name="TYPEH")
	public Integer getTypeh() {
		return typeh;
	}
	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}
				@Column(name="CAUSE")
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}