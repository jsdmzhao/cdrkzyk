package com.jeysan.cpf.decision.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery1ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery1View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery1ViewManager {
	private static Logger logger = LoggerFactory.getLogger(Flowbasicquery1ViewManager.class);
	
	private Flowbasicquery1ViewDao flowbasicquery1ViewDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveFlowbasicquery1View(Flowbasicquery1View entity){
		flowbasicquery1ViewDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveFlowbasicquery1Views(List<Flowbasicquery1View> entites){
		for(Flowbasicquery1View entity : entites)
			flowbasicquery1ViewDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteFlowbasicquery1View(Long id){
		flowbasicquery1ViewDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteFlowbasicquery1Views(Long id){
		flowbasicquery1ViewDao.batchExecute("delete Flowbasicquery1View where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteFlowbasicquery1Views(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteFlowbasicquery1Views(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Flowbasicquery1View getFlowbasicquery1View(Integer id){
		//return flowbasicquery1ViewDao.get(id);
		return null;
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery1View> searchFlowbasicquery1View(final Page<Flowbasicquery1View> page,final List<PropertyFilter> filter){
		return flowbasicquery1ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery1ViewDao(Flowbasicquery1ViewDao flowbasicquery1ViewDao) {
		this.flowbasicquery1ViewDao = flowbasicquery1ViewDao;
	}
	
	
}