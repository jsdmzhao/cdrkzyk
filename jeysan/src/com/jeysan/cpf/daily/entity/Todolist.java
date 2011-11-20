package com.jeysan.cpf.daily.entity;

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
@Table(name = "fhp_todolist")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Todolist extends IdExtEntity {
						/**
	 * USER_ID
	 */
	private Long userId;
				/**
	 * 开始时间
	 */
	private java.util.Date startTime;
				/**
	 * 结束时间
	 */
	private java.util.Date endTime;
				/**
	 * 标题
	 */
	private String title;
				/**
	 * 详情
	 */
	private String detail;
				/**
	 * 状态
	 */
	private Integer status;
				/**
	 * 备忘
	 */
	private String remark;
			
						@Column(name="USER_ID")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
				@Column(name="START_TIME")
	public java.util.Date getStartTime() {
		return startTime;
	}
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
				@Column(name="END_TIME")
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
				@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
				@Column(name="DETAIL")
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
				@Column(name="STATUS")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
				@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}