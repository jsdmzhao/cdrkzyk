package com.jeysan.cpf.security.entity;

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
@Table(name = "js_auth_run_log")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RunLog extends IdExtEntity {
						/**
	 * 更新时间
	 */
	private java.util.Date updateTime;
				/**
	 * 业务名称
	 */
	private Integer bussName;
				/**
	 * 类
	 */
	private String bussClass;
				/**
	 * 方法
	 */
	private String bussMethod;
				/**
	 * 持续时间
	 */
	private Integer lastTime;
				/**
	 * 备注
	 */
	private String remark;
			
						@Column(name="UPDATE_TIME")
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
				@Column(name="BUSS_NAME")
	public Integer getBussName() {
		return bussName;
	}
	public void setBussName(Integer bussName) {
		this.bussName = bussName;
	}
				@Column(name="BUSS_CLASS")
	public String getBussClass() {
		return bussClass;
	}
	public void setBussClass(String bussClass) {
		this.bussClass = bussClass;
	}
				@Column(name="BUSS_METHOD")
	public String getBussMethod() {
		return bussMethod;
	}
	public void setBussMethod(String bussMethod) {
		this.bussMethod = bussMethod;
	}
				@Column(name="LAST_TIME")
	public Integer getLastTime() {
		return lastTime;
	}
	public void setLastTime(Integer lastTime) {
		this.lastTime = lastTime;
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