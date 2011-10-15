package com.jeysan.cpf.security.service;

import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.security.dao.ResourceDao;
import com.jeysan.cpf.security.entity.Resource;
import com.jeysan.cpf.security.util.ResourceUtils;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class ResourceManager {
	private static Logger logger = LoggerFactory.getLogger(ResourceManager.class);
	
	private ResourceDao resourceDao;
	
	/**
	 * 增加
	 * @param entity
	 */
	public void saveResource(Resource entity){
		resourceDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteResource(Integer id){
		resourceDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteResources(Integer id){
		resourceDao.batchExecute("delete Resource where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteResources(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteResources(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Resource getResource(Integer id){
		return resourceDao.get(id);
	}
	
	/**
	 * 根据用户权限查找资源
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Map<Resource, List> getAllResources(Integer userId,List<Resource> filter){
		List<Resource> resources = resourceDao.getResourcesByUserId(userId);
		return ResourceUtils.reset2Map4ExistsResources(resources, filter);
	}
	/**
	 * 查找一级资源
	 * @return
	 */
	@Transactional(readOnly = true)
	public Map searchTopLevelResource(){
		return resourceDao.findTopLevelResource();
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Resource> searchResource(final Page<Resource> page,final List<PropertyFilter> filter){
		return resourceDao.findPage(page, filter);
	}
	
	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	
}