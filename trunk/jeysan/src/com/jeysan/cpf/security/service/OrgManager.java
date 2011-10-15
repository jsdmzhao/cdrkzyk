/**
 * 
 */
package com.jeysan.cpf.security.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.security.dao.OrgDao;
import com.jeysan.cpf.security.entity.Org;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class OrgManager {
	private static Logger logger = LoggerFactory.getLogger(OrgManager.class);
	
	private OrgDao orgDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveOrg(Org entity){
		orgDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteOrg(Integer id){
		orgDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteOrgs(Integer id){
		orgDao.batchExecute("delete Org where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteOrgs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteOrgs(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Org getOrg(Integer id){
		return orgDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Org> searchOrg(final Page<Org> page,final List<PropertyFilter> filter){
		return orgDao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public List<Org> searchOrg(int level){
		return orgDao.findBy("levelNum", level);
	}
	
	@Autowired
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}
	
	
}
