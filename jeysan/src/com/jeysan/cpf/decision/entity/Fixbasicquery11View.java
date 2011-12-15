package com.jeysan.cpf.decision.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "fhp_fixbasicquery11_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fixbasicquery11View extends IdExtEntity {
			/**
	 * 姓名
	 */
	private String nameh;
				/**
	 * 妇女编码
	 */
	private String personCode;
				/**
	 * 身份证号
	 */
	private String code;
				/**
	 * 年龄
	 */
	private Integer age;
				/**
	 * 出生日期
	 */
	private java.util.Date birthday;
				/**
	 * 婚姻状态
	 */
	private Integer marryStatus;
				/**
	 * 最小孩出生日期
	 */
	private java.util.Date firstMarryDate;
				/**
	 * 联系电话
	 */
	private String tel;
				/**
	 * 避孕节育措施
	 */
	private Integer method;
				/**
	 * 落实措施时间
	 */
	private java.util.Date opsDate;
				/**
	 * 男孩数
	 */
	private Long boynum;
				/**
	 * 女孩数
	 */
	private Long girlnum;
				/**
	 * 最小孩出生日期
	 */
	private java.util.Date minbirthday;
				/**
	 * 对象种类
	 */
	private Integer objType;
				/**
	 * 双查时间
	 */
	private java.util.Date dcDate;
				/**
	 * 查环结果
	 */
	private Integer dcResult1;
				/**
	 * 查孕结果
	 */
	private Integer dcResult2;
				/**
	 * 双查医院
	 */
	private String hospital;
				/**
	 * 轮次
	 */
	private Integer seq;
				/**
	 * 年度
	 */
	private Integer year;
	/**
	 * 每年应双查次数
	 */
	private Integer count4dc2;
				/**
	 * 丈夫姓名
	 */
	private String nameh2;
				/**
	 * 户口类别
	 */
	private Integer domicileType;
				/**
	 * area
	 */
	private String area;
			
			@Column(name="NAMEH")
	public String getNameh() {
		return nameh;
	}
	public void setNameh(String nameh) {
		this.nameh = nameh;
	}
				@Column(name="PERSON_CODE")
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
				@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
				@Column(name="age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
				@Column(name="BIRTHDAY")
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
				@Column(name="MARRY_STATUS")
	public Integer getMarryStatus() {
		return marryStatus;
	}
	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}
				@Column(name="FIRST_MARRY_DATE")
	public java.util.Date getFirstMarryDate() {
		return firstMarryDate;
	}
	public void setFirstMarryDate(java.util.Date firstMarryDate) {
		this.firstMarryDate = firstMarryDate;
	}
				@Column(name="TEL")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
				@Column(name="METHOD")
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
				@Column(name="OPS_DATE")
	public java.util.Date getOpsDate() {
		return opsDate;
	}
	public void setOpsDate(java.util.Date opsDate) {
		this.opsDate = opsDate;
	}
				@Column(name="boynum")
	public Long getBoynum() {
		return boynum;
	}
	public void setBoynum(Long boynum) {
		this.boynum = boynum;
	}
				@Column(name="girlnum")
	public Long getGirlnum() {
		return girlnum;
	}
	public void setGirlnum(Long girlnum) {
		this.girlnum = girlnum;
	}
				@Column(name="minbirthday")
	public java.util.Date getMinbirthday() {
		return minbirthday;
	}
	public void setMinbirthday(java.util.Date minbirthday) {
		this.minbirthday = minbirthday;
	}
				@Column(name="OBJ_TYPE")
	public Integer getObjType() {
		return objType;
	}
	public void setObjType(Integer objType) {
		this.objType = objType;
	}
				@Column(name="DC_DATE")
	public java.util.Date getDcDate() {
		return dcDate;
	}
	public void setDcDate(java.util.Date dcDate) {
		this.dcDate = dcDate;
	}
				@Column(name="DC_RESULT1")
	public Integer getDcResult1() {
		return dcResult1;
	}
	public void setDcResult1(Integer dcResult1) {
		this.dcResult1 = dcResult1;
	}
				@Column(name="DC_RESULT2")
	public Integer getDcResult2() {
		return dcResult2;
	}
	public void setDcResult2(Integer dcResult2) {
		this.dcResult2 = dcResult2;
	}
				@Column(name="HOSPITAL")
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
				@Column(name="SEQ")
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
				@Column(name="YEAR")
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
				@Column(name="NAMEH2")
	public String getNameh2() {
		return nameh2;
	}
	public void setNameh2(String nameh2) {
		this.nameh2 = nameh2;
	}
	@Column(name="COUNT4DC2")		
	public Integer getCount4dc2() {
		return count4dc2;
	}
	public void setCount4dc2(Integer count4dc2) {
		this.count4dc2 = count4dc2;
	}
				@Column(name="DOMICILE_TYPE")
	public Integer getDomicileType() {
		return domicileType;
	}
	public void setDomicileType(Integer domicileType) {
		this.domicileType = domicileType;
	}
				@Column(name="area")
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
	
}