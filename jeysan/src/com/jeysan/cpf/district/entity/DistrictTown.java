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
@Table(name = "fhp_district_town")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DistrictTown extends IdEntity {
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
	private DistrictCounty county;
	
	private List<DistrictVillage> villageList = Lists.newArrayList();

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
	public DistrictCounty getCounty() {
		return county;
	}

	public void setCounty(DistrictCounty county) {
		this.county = county;
	}

	
	@OneToMany(mappedBy="town",cascade={CascadeType.REFRESH})
    @OrderBy("id")
    @JsonIgnore
	public List<DistrictVillage> getVillageList() {
		return villageList;
	}

	public void setVillageList(List<DistrictVillage> villageList) {
		this.villageList = villageList;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}