package com.jeysan.cpf.security.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;
import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 * 
 */
@Entity
@Table(name = "js_auth_dict")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Dict extends IdEntity {
	/**
	 * 字典名称
	 */
	private String dictName;
	/**
	 * 字典编码
	 */
	private String dictCode;
	/**
	 * 字典状态
	 */
	private Integer dictStatus;
	/**
	 * 字典描述
	 */
	private String dictInfo;
	/**
	 * 是否可以修改
	 */
	private Integer canModified;
	/**
	 * 是否末级
	 */
	private Integer isLeaf;
	/**
	 * 父类字典
	 */
	private Dict parent;
	
	/**
	 * 字典子类
	 */
	
	private List<DictSub> dictSubList = Lists.newArrayList();

	@Column(name = "DICT_NAME")
	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	@Column(name = "DICT_CODE")
	public String getDictCode() {
		return dictCode;
	}
	@Column(name = "IS_LEAF")
	public Integer getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	@Column(name = "DICT_STATUS")
	public Integer getDictStatus() {
		return dictStatus;
	}

	public void setDictStatus(Integer dictStatus) {
		this.dictStatus = dictStatus;
	}

	@Column(name = "DICT_INFO")
	public String getDictInfo() {
		return dictInfo;
	}

	public void setDictInfo(String dictInfo) {
		this.dictInfo = dictInfo;
	}

	@Column(name = "CAN_MODIFIED")
	public Integer getCanModified() {
		return canModified;
	}

	public void setCanModified(Integer canModified) {
		this.canModified = canModified;
	}

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PARENT_ID")
	public Dict getParent() {
		return parent;
	}

	public void setParent(Dict parent) {
		this.parent = parent;
	}

	@OneToMany(mappedBy="dict",cascade={CascadeType.REMOVE})
    @OrderBy("subIndex")
	public List<DictSub> getDictSubList() {
		return dictSubList;
	}
	
	public void setDictSubList(List<DictSub> dictSubList) {
		this.dictSubList = dictSubList;
	}
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return null;
	}
}