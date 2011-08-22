package com.jeysan.cpf.district.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "fhp_district_province")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DistrictProvince extends IdEntity {
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	
	private List<DistrictCity> cityList = Lists.newArrayList();

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
	
	
	@OneToMany(mappedBy="province",cascade={CascadeType.REFRESH})
    @OrderBy("id")
    @JsonIgnore
	public List<DistrictCity> getCityList() {
		return cityList;
	}

	public void setCityList(List<DistrictCity> cityList) {
		this.cityList = cityList;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}