package com.jeysan.cpf.district.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;
import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_district_city")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value={"hibernateLazyInitializer"}) 
public class DistrictCity extends IdEntity {
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * PARENT_ID
	 */
	private DistrictProvince province;
	
	private List<DistrictCounty> countyList = Lists.newArrayList();

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@ManyToOne(optional=false)
	@JoinColumn(name = "PARENT_ID")
	@JsonIgnore
	public DistrictProvince getProvince() {
		return province;
	}

	public void setProvince(DistrictProvince province) {
		this.province = province;
	}
	
	@OneToMany(mappedBy="city",cascade={CascadeType.REFRESH})
    @OrderBy("id")
    @JsonIgnore
	public List<DistrictCounty> getCountyList() {
		return countyList;
	}

	public void setCountyList(List<DistrictCounty> countyList) {
		this.countyList = countyList;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}