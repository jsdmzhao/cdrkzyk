package com.jeysan.cpf.pmas.entity;

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
@Table(name = "fhp_villager_team")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VillagerTeam extends IdExtEntity {
						/**
	 * 行政区编码
	 */
	private String orgCode;
				/**
	 * 小组名称
	 */
	private String teamName;
				/**
	 * 小组序号
	 */
	private Integer teamIndex;
			
						@Column(name="ORG_CODE")
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
				@Column(name="TEAM_NAME")
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
				@Column(name="TEAM_INDEX")
	public Integer getTeamIndex() {
		return teamIndex;
	}
	public void setTeamIndex(Integer teamIndex) {
		this.teamIndex = teamIndex;
	}
			
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}