package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.TocCertDao;
import com.jeysan.cpf.bcmas.entity.TocCert;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class TocCertManager {
	private static Logger logger = LoggerFactory.getLogger(TocCertManager.class);
	
	private TocCertDao tocCertDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveTocCert(TocCert entity){
		tocCertDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveTocCerts(List<TocCert> entites){
		for(TocCert entity : entites)
			tocCertDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteTocCert(Long id){
		tocCertDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteTocCerts(Long id){
		tocCertDao.batchExecute("delete TocCert where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteTocCerts(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteTocCerts(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public TocCert getTocCert(Long id){
		return tocCertDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<TocCert> searchTocCert(final Page<TocCert> page,final List<PropertyFilter> filter){
		return tocCertDao.findPage(page, filter);
	}
	
	@Autowired
	public void setTocCertDao(TocCertDao tocCertDao) {
		this.tocCertDao = tocCertDao;
	}
	
	
}