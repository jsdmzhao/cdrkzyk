package com.jeysan.cpf.district.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.district.dao.DistrictProvinceDao;
import com.jeysan.cpf.district.entity.DistrictCity;
import com.jeysan.cpf.district.entity.DistrictCounty;
import com.jeysan.cpf.district.entity.DistrictProvince;
import com.jeysan.cpf.district.entity.DistrictTown;
import com.jeysan.cpf.district.entity.DistrictVillage;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.orm.hibernate.IdEntity;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DistrictProvinceManager {
	private static Logger logger = LoggerFactory.getLogger(DistrictProvinceManager.class);
	
	private DistrictProvinceDao districtProvinceDao;
	private DistrictCityManager districtCityManager;
	private DistrictCountyManager districtCountyManager;
	private DistrictTownManager districtTownManager;
	private DistrictVillageManager districtVillageManager;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDistrictProvince(DistrictProvince entity){
		districtProvinceDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDistrictProvinces(List<DistrictProvince> entites){
		for(DistrictProvince entity : entites)
			districtProvinceDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDistrictProvince(Integer id){
		districtProvinceDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDistrictProvinces(Integer id){
		districtProvinceDao.batchExecute("delete DistrictProvince where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDistrictProvinces(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDistrictProvinces(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DistrictProvince getDistrictProvince(Integer id){
		return districtProvinceDao.get(id);
	}
	@Transactional(readOnly = true)
	public DistrictProvince getDistrictProvince(String code){
		return districtProvinceDao.findUniqueBy("code", code);
	}
	@Transactional(readOnly = true)
	public IdEntity getDistrictByCode(String code){
		if(StringUtils.isEmpty(code) || code.length() != 12)
			return null;
		String codel = code;
		if(codel.endsWith("000"))
			codel = codel.substring(0, 9);
		if(codel.endsWith("000"))
			codel = codel.substring(0, 6);
		if(codel.endsWith("00"))
			codel = codel.substring(0, 4);
		if(codel.endsWith("00"))
			codel = codel.substring(0, 2);
		if(codel.length() == 2)
			return getDistrictProvince(code);
		else if(codel.length() == 4)
			return districtCityManager.getDistrictCity(code);
		else if(codel.length() == 6)
			return districtCountyManager.getDistrictCounty(code);
		else if(codel.length() == 9)
			return districtTownManager.getDistrictTown(code);
		else if(codel.length() == 12)
			return districtVillageManager.getDistrictVillage(code);
		return null;
	}
	@Transactional(readOnly = true)
	public String getAreaNameByCode(String code){
		if(StringUtils.isEmpty(code) || code.length() != 12)
			return null;
		String codel = code;
		if(codel.endsWith("000"))
			codel = codel.substring(0, 9);
		if(codel.endsWith("000"))
			codel = codel.substring(0, 6);
		if(codel.endsWith("00"))
			codel = codel.substring(0, 4);
		if(codel.endsWith("00"))
			codel = codel.substring(0, 2);
		if(codel.length() == 2){
			DistrictProvince area = getDistrictProvince(code);
			if(area != null)
				return area.getName();
		}else if(codel.length() == 4){
			DistrictCity area = districtCityManager.getDistrictCity(code);
			if(area != null)
				return area.getName();
		}else if(codel.length() == 6){
			DistrictCounty area = districtCountyManager.getDistrictCounty(code);
			if(area != null)
				return area.getName();
		}else if(codel.length() == 9){
			DistrictTown area = districtTownManager.getDistrictTown(code);
			if(area != null)
				return area.getName();
		}else if(codel.length() == 12){
			DistrictVillage area = districtVillageManager.getDistrictVillage(code);
			if(area != null)
				return area.getName();
		}
		return null;
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DistrictProvince> searchDistrictProvince(final Page<DistrictProvince> page,final List<PropertyFilter> filter){
		return districtProvinceDao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public List<DistrictProvince> getAll(){
		return districtProvinceDao.find(" from DistrictProvince order by id ");
	}
	
	@Autowired
	public void setDistrictProvinceDao(DistrictProvinceDao districtProvinceDao) {
		this.districtProvinceDao = districtProvinceDao;
	}
	@Autowired
	public void setDistrictCityManager(DistrictCityManager districtCityManager) {
		this.districtCityManager = districtCityManager;
	}
	@Autowired
	public void setDistrictCountyManager(DistrictCountyManager districtCountyManager) {
		this.districtCountyManager = districtCountyManager;
	}
	@Autowired
	public void setDistrictTownManager(DistrictTownManager districtTownManager) {
		this.districtTownManager = districtTownManager;
	}
	@Autowired
	public void setDistrictVillageManager(DistrictVillageManager districtVillageManager) {
		this.districtVillageManager = districtVillageManager;
	}
	
	
	
	
}