package com.jeysan.cpf.bcmas.vo;

import com.jeysan.cpf.bcmas.entity.FertileWoman;

/**
 * @author 黄静
 * 
 */
public class FertileWomanExtends extends FertileWoman {
	/**
	 * 双查对象类型
	 */
	private Integer dcObjType;
	
	

	public Integer getDcObjType() {
		return dcObjType;
	}



	public void setDcObjType(Integer dcObjType) {
		this.dcObjType = dcObjType;
	}



	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this);
		return null;
	}
}