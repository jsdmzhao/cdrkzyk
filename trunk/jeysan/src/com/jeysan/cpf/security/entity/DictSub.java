package com.jeysan.cpf.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "js_auth_dict_sub")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DictSub extends IdEntity {
	/**
	 * 所属字典
	 */
	private Dict dict;
	/**
	 * 子项名称
	 */
	private String subName;
	/**
	 * 子项编码
	 */
	private String subCode;
	/**
	 * 子项颜色
	 */
	private String subColor;
	/**
	 * 子项描述
	 */
	private String subInfo;
	/**
	 * 子项序号
	 */
	private Integer subIndex;

	@ManyToOne(optional=false)
	@JoinColumn(name = "DICT_ID")
	public Dict getDict() {
		return dict;
	}

	public void setDict(Dict dict) {
		this.dict = dict;
	}

	@Column(name = "SUB_NAME")
	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	@Column(name = "SUB_COLOR")
	public String getSubColor() {
		return subColor;
	}

	public void setSubColor(String subColor) {
		this.subColor = subColor;
	}

	@Column(name = "SUB_INFO")
	public String getSubInfo() {
		return subInfo;
	}

	public void setSubInfo(String subInfo) {
		this.subInfo = subInfo;
	}

	@Column(name = "SUB_INDEX")
	public Integer getSubIndex() {
		return subIndex;
	}

	public void setSubIndex(Integer subIndex) {
		this.subIndex = subIndex;
	}
	@Column(name = "SUB_CODE")
	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}