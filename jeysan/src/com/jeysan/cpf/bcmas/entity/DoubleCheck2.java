package com.jeysan.cpf.bcmas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;
import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 整体双查轮次
 */
@Entity
@Table(name = "fhp_double_check2")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DoubleCheck2 extends IdExtEntity {
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
	 * 轮次详情
	 */
	
	private List<DoubleCheckDetail> detailList = Lists.newArrayList();
	
	
	@OneToMany(mappedBy="doubleCheck2",cascade={CascadeType.REMOVE})
    @OrderBy("seq")
	public List<DoubleCheckDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<DoubleCheckDetail> detailList) {
		this.detailList = detailList;
	}

	@Column(name = "COUNT")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "START")
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "YEAR")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}