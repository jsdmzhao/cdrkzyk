package com.jeysan.cpf.district.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.district.dao.DistrictTownDao;
import com.jeysan.cpf.district.entity.DistrictTown;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DistrictTownManager {
	private static Logger logger = LoggerFactory.getLogger(DistrictTownManager.class);
	
	private DistrictTownDao districtTownDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDistrictTown(DistrictTown entity){
		districtTownDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDistrictTowns(List<DistrictTown> entites){
		for(DistrictTown entity : entites)
			districtTownDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDistrictTown(Integer id){
		districtTownDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDistrictTowns(Integer id){
		districtTownDao.batchExecute("delete DistrictTown where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDistrictTowns(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDistrictTowns(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DistrictTown getDistrictTown(Integer id){
		return districtTownDao.get(id);
	}
	@Transactional(readOnly = true)
	public DistrictTown getDistrictTown(String code){
		return districtTownDao.findUniqueBy("code", code);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DistrictTown> searchDistrictTown(final Page<DistrictTown> page,final List<PropertyFilter> filter){
		return districtTownDao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public List<DistrictTown> getAllByParentId(Integer parentId){
		return districtTownDao.find(" from DistrictTown where parentId = ? order by id ",parentId);
	}
	
	@Autowired
	public void setDistrictTownDao(DistrictTownDao districtTownDao) {
		this.districtTownDao = districtTownDao;
	}
	
	
}