package com.jeysan.cpf.security.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.security.dao.DictDao;
import com.jeysan.cpf.security.entity.Dict;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DictManager {
	private static Logger logger = LoggerFactory.getLogger(DictManager.class);
	
	private DictDao dictDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDict(Dict entity){
		dictDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDict(Integer id){
		dictDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDicts(Integer id){
		dictDao.batchExecute("delete Dict where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDicts(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDicts(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Dict getDict(Integer id){
		return dictDao.get(id);
	}
	
	@Transactional(readOnly = true)
	public List<Dict> loadAllDicts(){
		return dictDao.getAll();
	}
	
	/**
	 * 编码查找
	 * @param dictCode
	 * @return
	 */
	@Transactional(readOnly = true)
	public Dict getDict(String dictCode){
		/*List<Dict> dicts =  dictDao.findBy("dictCode", dictCode);
		if(dicts!=null&&dicts.size()>0)
			return dicts.get(0);*/
		return dictDao.findUniqueBy("dictCode", dictCode);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Dict> searchDict(final Page<Dict> page,final List<PropertyFilter> filter){
		return dictDao.findPage(page, filter);
	}
	
	@Autowired
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}
	
	
}