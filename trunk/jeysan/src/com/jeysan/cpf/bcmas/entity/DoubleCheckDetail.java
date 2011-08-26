package com.jeysan.cpf.bcmas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 查环查孕之整体双查轮次详情
 */
@Entity
@Table(name = "fhp_double_check_detail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DoubleCheckDetail extends IdExtEntity {
	/**
	 * 批次ID
	 */
	private DoubleCheck2 doubleCheck2;
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
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "DC_ID")
	public DoubleCheck2 getDoubleCheck2() {
		return doubleCheck2;
	}

	public void setDoubleCheck2(DoubleCheck2 doubleCheck2) {
		this.doubleCheck2 = doubleCheck2;
	}

	@Column(name = "SEQ")
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "START")
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "END")
	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}