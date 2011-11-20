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
@Table(name = "fhp_rubbish_mail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RubbishMail extends IdExtEntity {
						/**
	 * 发件人
	 */
	private Long sendEmployeeId;
				/**
	 * 收件人
	 */
	private String receiveEmployeeIds;
				/**
	 * 主题
	 */
	private String title;
				/**
	 * 附件
	 */
	private String attachment;
				/**
	 * 内容
	 */
	private String content;
				/**
	 * 状态
	 */
	private String status;
				/**
	 * 父邮件
	 */
	private Long parMailId;
				/**
	 * 时间
	 */
	private java.util.Date dateKt;
				/**
	 * 是否已读
	 */
	private String isRead;
				/**
	 * 来源
	 */
	private String source;
			
						@Column(name="SEND_EMPLOYEE_ID")
	public Long getSendEmployeeId() {
		return sendEmployeeId;
	}
	public void setSendEmployeeId(Long sendEmployeeId) {
		this.sendEmployeeId = sendEmployeeId;
	}
				@Column(name="RECEIVE_EMPLOYEE_IDS")
	public String getReceiveEmployeeIds() {
		return receiveEmployeeIds;
	}
	public void setReceiveEmployeeIds(String receiveEmployeeIds) {
		this.receiveEmployeeIds = receiveEmployeeIds;
	}
				@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
				@Column(name="ATTACHMENT")
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
				@Column(name="CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
				@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
				@Column(name="PAR_MAIL_ID")
	public Long getParMailId() {
		return parMailId;
	}
	public void setParMailId(Long parMailId) {
		this.parMailId = parMailId;
	}
				@Column(name="DATE_KT")
	public java.util.Date getDateKt() {
		return dateKt;
	}
	public void setDateKt(java.util.Date dateKt) {
		this.dateKt = dateKt;
	}
				@Column(name="IS_READ")
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
				@Column(name="SOURCE")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}