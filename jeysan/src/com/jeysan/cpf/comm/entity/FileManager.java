package com.jeysan.cpf.comm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.jeysan.modules.orm.hibernate.IdExtEntity;

@Entity
@Table(name = "FHP_DOC_FILE_MANAGER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FileManager extends IdExtEntity {
	/**
	 * 文件原名称
	 */
	private String orinName;
	/**
	 * 系统分配名称
	 */
	private String newName;
	/**
	 * 提交时间
	 */
	private java.util.Date handinTime;
	/**
	 * 提交人
	 */
	private String hander;
	/**
	 * 机构编码
	 */
	private String area;
	/**
	 * 文件大小
	 */
	private java.math.BigDecimal fileSize;
	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 文件类别
	 */
	private Integer fileType;
	/**
	 * 是否有效
	 */
	private Integer flag;
	
	@Column(name = "FLAG")
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Column(name = "ORIN_NAME")
	public String getOrinName() {
		return orinName;
	}

	public void setOrinName(String orinName) {
		this.orinName = orinName;
	}
	@Column(name = "NEW_NAME")
	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
	@Column(name = "HANDIN_TIME")
	public java.util.Date getHandinTime() {
		return handinTime;
	}

	public void setHandinTime(java.util.Date handinTime) {
		this.handinTime = handinTime;
	}
	@Column(name = "HANDER")
	public String getHander() {
		return hander;
	}

	public void setHander(String hander) {
		this.hander = hander;
	}
	@Column(name = "FILE_SIZE")
	public java.math.BigDecimal getFileSize() {
		return fileSize;
	}

	public void setFileSize(java.math.BigDecimal fileSize) {
		this.fileSize = fileSize;
	}
	@Column(name = "FILE_PATH")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Column(name = "FILE_TYPE")
	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	@Column(name = "AREA")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
