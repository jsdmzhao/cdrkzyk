package com.jeysan.cpf.daily.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.daily.dao.AddressListDao;
import com.jeysan.cpf.daily.entity.AddressList;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class AddressListManager {
	private static Logger logger = LoggerFactory.getLogger(AddressListManager.class);
	
	private AddressListDao addressListDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveAddressList(AddressList entity){
		addressListDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveAddressLists(List<AddressList> entites){
		for(AddressList entity : entites)
			addressListDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteAddressList(Long id){
		addressListDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteAddressLists(Long id){
		addressListDao.batchExecute("delete AddressList where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteAddressLists(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteAddressLists(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public AddressList getAddressList(Long id){
		return addressListDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<AddressList> searchAddressList(final Page<AddressList> page,final List<PropertyFilter> filter){
		return addressListDao.findPage(page, filter);
	}
	
	@Autowired
	public void setAddressListDao(AddressListDao addressListDao) {
		this.addressListDao = addressListDao;
	}
	
	
}