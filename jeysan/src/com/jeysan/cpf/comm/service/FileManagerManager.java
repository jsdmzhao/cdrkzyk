package com.jeysan.cpf.comm.service;

import java.io.File;
import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.comm.dao.FileManagerDao;
import com.jeysan.cpf.comm.entity.FileManager;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.file.FileUtils;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class FileManagerManager {
	private static Logger logger = LoggerFactory.getLogger(FileManagerManager.class);
	
	private FileManagerDao fileManagerDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveFileManager(FileManager entity){
		fileManagerDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveFileManagers(List<FileManager> entites){
		for(FileManager entity : entites)
			fileManagerDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteFileManager(Long id){
		fileManagerDao.delete(id);
	}
	public void deleteFileManager(FileManager entity){
		fileManagerDao.delete(entity);
	}
	public void deleteFileManagerIncludeFile(FileManager entity){
		if(StringUtils.isNotEmpty(entity.getFilePath())){
			File file = new File(FileUtils.getRealPath(Struts2Utils
					.getRequest(), entity.getFilePath()), entity
					.getNewName());
			if (file.exists())
				file.delete();
		}
		fileManagerDao.delete(entity);
	}
	public void deleteFileManagerByIds(String ids){
		if(StringUtils.isNotEmpty(ids)){
			FileManager fm = null;
			for(String fmId : StringUtils.split(ids,",")){
				fm = getFileManager(Long.parseLong(fmId));
				deleteFileManagerIncludeFile(fm);
			}
		}
	}
	public void updateFileManager2Valid(Long id){
		FileManager entity = getFileManager(id);
		if(entity.getFlag() == 0){
			entity.setFlag(1);
			saveFileManager(entity);
		}
	}
	public void updateFileManagers2Valid(String ids){
		if(StringUtils.isNotEmpty(ids)){
			for(String fmId : StringUtils.split(ids,",")){
				updateFileManager2Valid(Long.parseLong(fmId));
			}
		}
	}
	
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteFileManagers(Long id){
		fileManagerDao.batchExecute("delete FileManager where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteFileManagers(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteFileManagers(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public FileManager getFileManager(Long id){
		return fileManagerDao.get(id);
	}
	@Transactional(readOnly = true)
	public List<FileManager> queryFileManagersById(String ids){
		return fileManagerDao.find("from FileManager as fm where fm.id in ("+ids+")");
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<FileManager> searchFileManager(final Page<FileManager> page,final List<PropertyFilter> filter){
		return fileManagerDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFileManagerDao(FileManagerDao fileManagerDao) {
		this.fileManagerDao = fileManagerDao;
	}
	
	
}