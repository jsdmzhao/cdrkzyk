package com.jeysan.cpf.district.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.district.dao.DistrictCountyDao;
import com.jeysan.cpf.district.entity.DistrictCounty;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DistrictCountyManager {
	private static Logger logger = LoggerFactory.getLogger(DistrictCountyManager.class);
	
	private DistrictCountyDao districtCountyDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDistrictCounty(DistrictCounty entity){
		districtCountyDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDistrictCountys(List<DistrictCounty> entites){
		for(DistrictCounty entity : entites)
			districtCountyDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDistrictCounty(Integer id){
		districtCountyDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDistrictCountys(Integer id){
		districtCountyDao.batchExecute("delete DistrictCounty where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDistrictCountys(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDistrictCountys(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DistrictCounty getDistrictCounty(Integer id){
		return districtCountyDao.get(id);
	}
	@Transactional(readOnly = true)
	public DistrictCounty getDistrictCounty(String code){
		return districtCountyDao.findUniqueBy("code", code);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DistrictCounty> searchDistrictCounty(final Page<DistrictCounty> page,final List<PropertyFilter> filter){
		return districtCountyDao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public List<DistrictCounty> getAllByParentId(Integer parentId){
		return districtCountyDao.find(" from DistrictCounty where parentId = ? order by id ",parentId);
	}
	
	@Autowired
	public void setDistrictCountyDao(DistrictCountyDao districtCountyDao) {
		this.districtCountyDao = districtCountyDao;
	}
	
	
}