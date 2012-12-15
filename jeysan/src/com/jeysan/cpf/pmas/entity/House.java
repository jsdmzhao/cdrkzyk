package com.jeysan.cpf.pmas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_house")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class House extends IdExtEntity {
	/**
	 * 房屋编号
	 */
	private String houseCode;
	/**
	 * 房屋类型
	 */
	private Integer houseType;
	/**
	 * 房屋属性
	 */
	private Integer houseAtt;
	/**
	 * 公安牌号
	 */
	private String housePoliceNo;
	/**
	 * 间（套）数
	 */
	private Integer rooms;
	/**
	 * 房屋面积
	 */
	private Double area;
	/**
	 * 居住人数
	 */
	private Integer personCount;
	/**
	 * 房产证类型
	 */
	private Integer pocType;
	/**
	 * 详细地址
	 */
	private String detailAddress;
	/**
	 * 业主姓名
	 */
	private String ownerName;
	/**
	 * 业主身份证
	 */
	private String ownerCert;
	/**
	 * 业主性别
	 */
	private Integer ownerSex;
	/**
	 * 业主电话
	 */
	private String ownerTel;
	/**
	 * 业主居住地址
	 */
	private String ownerAddress;
	/**
	 * 业主工作单位
	 */
	private String ownerCompany;
	/**
	 * 代管人姓名
	 */
	private String agentName;
	/**
	 * 代管人身份证
	 */
	private String agentCert;
	/**
	 * 代管人性别
	 */
	private Integer agentSex;
	/**
	 * 代管人电话
	 */
	private String agentTel;
	/**
	 * 代管人居住地址
	 */
	private String agentAddress;
	/**
	 * 代管人工作单位
	 */
	private String agentCompany;
	/**
	 * 出住屋租赁许可证签证时间
	 */
	private java.util.Date rentPermitDate;
	/**
	 * 治安管理责任书签订时间
	 */
	private java.util.Date orderDate;
	/**
	 * 计生管理责任书签订时间
	 */
	private java.util.Date bcsDate;
	/**
	 * 对应地图ID
	 */
	private String gisId;

	@Column(name = "HOUSE_CODE")
	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	@Column(name = "HOUSE_TYPE")
	public Integer getHouseType() {
		return houseType;
	}

	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}

	@Column(name = "HOUSE_ATT")
	public Integer getHouseAtt() {
		return houseAtt;
	}

	public void setHouseAtt(Integer houseAtt) {
		this.houseAtt = houseAtt;
	}

	@Column(name = "HOUSE_POLICE_NO")
	public String getHousePoliceNo() {
		return housePoliceNo;
	}

	public void setHousePoliceNo(String housePoliceNo) {
		this.housePoliceNo = housePoliceNo;
	}

	@Column(name = "ROOMS")
	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	@Column(name = "AREA")
	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Column(name = "PERSON_COUNT")
	public Integer getPersonCount() {
		return personCount;
	}

	public void setPersonCount(Integer personCount) {
		this.personCount = personCount;
	}

	@Column(name = "POC_TYPE")
	public Integer getPocType() {
		return pocType;
	}

	public void setPocType(Integer pocType) {
		this.pocType = pocType;
	}

	@Column(name = "DETAIL_ADDRESS")
	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	@Column(name = "OWNER_NAME")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name = "OWNER_CERT")
	public String getOwnerCert() {
		return ownerCert;
	}

	public void setOwnerCert(String ownerCert) {
		this.ownerCert = ownerCert;
	}

	@Column(name = "OWNER_SEX")
	public Integer getOwnerSex() {
		return ownerSex;
	}

	public void setOwnerSex(Integer ownerSex) {
		this.ownerSex = ownerSex;
	}

	@Column(name = "OWNER_TEL")
	public String getOwnerTel() {
		return ownerTel;
	}

	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}

	@Column(name = "OWNER_ADDRESS")
	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	@Column(name = "OWNER_COMPANY")
	public String getOwnerCompany() {
		return ownerCompany;
	}

	public void setOwnerCompany(String ownerCompany) {
		this.ownerCompany = ownerCompany;
	}

	@Column(name = "AGENT_NAME")
	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	@Column(name = "AGENT_CERT")
	public String getAgentCert() {
		return agentCert;
	}

	public void setAgentCert(String agentCert) {
		this.agentCert = agentCert;
	}

	@Column(name = "AGENT_SEX")
	public Integer getAgentSex() {
		return agentSex;
	}

	public void setAgentSex(Integer agentSex) {
		this.agentSex = agentSex;
	}

	@Column(name = "AGENT_TEL")
	public String getAgentTel() {
		return agentTel;
	}

	public void setAgentTel(String agentTel) {
		this.agentTel = agentTel;
	}

	@Column(name = "AGENT_ADDRESS")
	public String getAgentAddress() {
		return agentAddress;
	}

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	@Column(name = "AGENT_COMPANY")
	public String getAgentCompany() {
		return agentCompany;
	}

	public void setAgentCompany(String agentCompany) {
		this.agentCompany = agentCompany;
	}

	@Column(name = "RENT_PERMIT_DATE")
	public java.util.Date getRentPermitDate() {
		return rentPermitDate;
	}

	public void setRentPermitDate(java.util.Date rentPermitDate) {
		this.rentPermitDate = rentPermitDate;
	}

	@Column(name = "ORDER_DATE")
	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "BCS_DATE")
	public java.util.Date getBcsDate() {
		return bcsDate;
	}

	public void setBcsDate(java.util.Date bcsDate) {
		this.bcsDate = bcsDate;
	}

	@Column(name = "GIS_ID")
	public String getGisId() {
		return gisId;
	}

	public void setGisId(String gisId) {
		this.gisId = gisId;
	}

	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
	
	private String houseTypeLabel;
	private String houseAttLabel;
	@Transient
	public String getHouseTypeLabel() {
		return houseTypeLabel;
	}

	public void setHouseTypeLabel(String houseTypeLabel) {
		this.houseTypeLabel = houseTypeLabel;
	}
	@Transient
	public String getHouseAttLabel() {
		return houseAttLabel;
	}

	public void setHouseAttLabel(String houseAttLabel) {
		this.houseAttLabel = houseAttLabel;
	}
	
	/**
	 * 所属区域
	 */
	private String area2;
	@Column(name = "AREA2")
	public String getArea2() {
		return area2;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}
	
	private String area2Label;
	@Column(name = "AREA2_LABEL")
	public String getArea2Label() {
		return area2Label;
	}

	public void setArea2Label(String area2Label) {
		this.area2Label = area2Label;
	}
	
}