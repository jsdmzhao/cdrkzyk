package com.jeysan.cpf.pmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.pmas.dao.VillagerTeamDao;
import com.jeysan.cpf.pmas.entity.VillagerTeam;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class VillagerTeamManager {
	private static Logger logger = LoggerFactory.getLogger(VillagerTeamManager.class);
	
	private VillagerTeamDao villagerTeamDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveVillagerTeam(VillagerTeam entity){
		villagerTeamDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveVillagerTeams(List<VillagerTeam> entites){
		for(VillagerTeam entity : entites)
			villagerTeamDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteVillagerTeam(Integer id){
		villagerTeamDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteVillagerTeams(Integer id){
		villagerTeamDao.batchExecute("delete VillagerTeam where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteVillagerTeams(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteVillagerTeams(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public VillagerTeam getVillagerTeam(Integer id){
		return villagerTeamDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<VillagerTeam> searchVillagerTeam(final Page<VillagerTeam> page,final List<PropertyFilter> filter){
		return villagerTeamDao.findPage(page, filter);
	}
	
	@Autowired
	public void setVillagerTeamDao(VillagerTeamDao villagerTeamDao) {
		this.villagerTeamDao = villagerTeamDao;
	}
	
	
}