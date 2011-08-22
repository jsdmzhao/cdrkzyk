package com.jeysan.cpf.district.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.district.dao.DistrictVillageDao;
import com.jeysan.cpf.district.entity.DistrictVillage;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DistrictVillageManager {
	private static Logger logger = LoggerFactory.getLogger(DistrictVillageManager.class);
	
	private DistrictVillageDao districtVillageDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDistrictVillage(DistrictVillage entity){
		districtVillageDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDistrictVillages(List<DistrictVillage> entites){
		for(DistrictVillage entity : entites)
			districtVillageDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDistrictVillage(Integer id){
		districtVillageDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDistrictVillages(Integer id){
		districtVillageDao.batchExecute("delete DistrictVillage where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDistrictVillages(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDistrictVillages(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DistrictVillage getDistrictVillage(Integer id){
		return districtVillageDao.get(id);
	}
	@Transactional(readOnly = true)
	public DistrictVillage getDistrictVillage(String code){
		return districtVillageDao.findUniqueBy("code", code);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DistrictVillage> searchDistrictVillage(final Page<DistrictVillage> page,final List<PropertyFilter> filter){
		return districtVillageDao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public List<DistrictVillage> getAllByParentId(Integer parentId){
		return districtVillageDao.find(" from DistrictVillage where parentId = ? order by id ",parentId);
	}
	
	@Autowired
	public void setDistrictVillageDao(DistrictVillageDao districtVillageDao) {
		this.districtVillageDao = districtVillageDao;
	}
	
	
}