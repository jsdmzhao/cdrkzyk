package com.jeysan.cpf.monitor.entity;

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
@Table(name = "fhp_monitor_switch")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonitorSwitch extends IdExtEntity {
						/**
	 * 监控类别
	 */
	private Integer monitorType;
				/**
	 * 是否打开
	 */
	private Integer switch_;
			
						@Column(name="MONITOR_TYPE")
	public Integer getMonitorType() {
		return monitorType;
	}
	public void setMonitorType(Integer monitorType) {
		this.monitorType = monitorType;
	}
				@Column(name="SWITCH")
	public Integer getSwitch() {
		return switch_;
	}
	public void setSwitch(Integer switch_) {
		this.switch_ = switch_;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}