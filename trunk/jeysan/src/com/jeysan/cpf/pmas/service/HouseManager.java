package com.jeysan.cpf.pmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.pmas.dao.HouseDao;
import com.jeysan.cpf.pmas.entity.House;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class HouseManager {
	private static Logger logger = LoggerFactory.getLogger(HouseManager.class);
	
	private HouseDao houseDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveHouse(House entity){
		houseDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveHouses(List<House> entites){
		for(House entity : entites)
			houseDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteHouse(Integer id){
		houseDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteHouses(Integer id){
		houseDao.batchExecute("delete House where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteHouses(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteHouses(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public House getHouse(Integer id){
		return houseDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<House> searchHouse(final Page<House> page,final List<PropertyFilter> filter){
		return houseDao.findPage(page, filter);
	}
	
	@Autowired
	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	
	
}