package com.jeysan.cpf.district.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.district.dao.DistrictCityDao;
import com.jeysan.cpf.district.entity.DistrictCity;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DistrictCityManager {
	private static Logger logger = LoggerFactory.getLogger(DistrictCityManager.class);
	
	private DistrictCityDao districtCityDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDistrictCity(DistrictCity entity){
		districtCityDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDistrictCitys(List<DistrictCity> entites){
		for(DistrictCity entity : entites)
			districtCityDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDistrictCity(Integer id){
		districtCityDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDistrictCitys(Integer id){
		districtCityDao.batchExecute("delete DistrictCity where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDistrictCitys(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDistrictCitys(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DistrictCity getDistrictCity(Integer id){
		return districtCityDao.get(id);
	}
	@Transactional(readOnly = true)
	public DistrictCity getDistrictCity(String code){
		return districtCityDao.findUniqueBy("code", code);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DistrictCity> searchDistrictCity(final Page<DistrictCity> page,final List<PropertyFilter> filter){
		return districtCityDao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public List<DistrictCity> getAllByParentId(Integer parentId){
		return districtCityDao.find(" from DistrictCity where parentId = ? order by id ",parentId);
	}
	
	@Autowired
	public void setDistrictCityDao(DistrictCityDao districtCityDao) {
		this.districtCityDao = districtCityDao;
	}
	
	
}