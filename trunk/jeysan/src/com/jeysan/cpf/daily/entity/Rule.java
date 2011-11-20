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
@Table(name = "fhp_rule")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Rule extends IdExtEntity {
						/**
	 * 类别
	 */
	private Integer typeh;
				/**
	 * 标题
	 */
	private String title;
				/**
	 * 发布人
	 */
	private Long sendEmployeeId;
				/**
	 * 发布时间
	 */
	private java.util.Date dateKt;
				/**
	 * 级别
	 */
	private String levelKt;
				/**
	 * 内容
	 */
	private String content;
				/**
	 * 附件
	 */
	private String attachment;
				/**
	 * 备注
	 */
	private String remark;
			
						@Column(name="TYPEH")
	public Integer getTypeh() {
		return typeh;
	}
	public void setTypeh(Integer typeh) {
		this.typeh = typeh;
	}
				@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
				@Column(name="SEND_EMPLOYEE_ID")
	public Long getSendEmployeeId() {
		return sendEmployeeId;
	}
	public void setSendEmployeeId(Long sendEmployeeId) {
		this.sendEmployeeId = sendEmployeeId;
	}
				@Column(name="DATE_KT")
	public java.util.Date getDateKt() {
		return dateKt;
	}
	public void setDateKt(java.util.Date dateKt) {
		this.dateKt = dateKt;
	}
				@Column(name="LEVEL_KT")
	public String getLevelKt() {
		return levelKt;
	}
	public void setLevelKt(String levelKt) {
		this.levelKt = levelKt;
	}
				@Column(name="CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
				@Column(name="ATTACHMENT")
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
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