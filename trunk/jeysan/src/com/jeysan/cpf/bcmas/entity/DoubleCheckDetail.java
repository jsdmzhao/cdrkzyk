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
@Table(name = "fhp_double_check_detail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DoubleCheckDetail extends IdExtEntity {
						/**
	 * 批次ID
	 */
	private Long dcId;
				/**
	 * 轮次
	 */
	private Integer seq;
				/**
	 * 起始年月
	 */
	private String start;
				/**
	 * 结束年月
	 */
	private String end;
			
						@Column(name="DC_ID")
	public Long getDcId() {
		return dcId;
	}
	public void setDcId(Long dcId) {
		this.dcId = dcId;
	}
				@Column(name="SEQ")
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
				@Column(name="START")
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
				@Column(name="END")
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}