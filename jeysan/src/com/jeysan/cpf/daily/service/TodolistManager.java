package com.jeysan.cpf.daily.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.daily.dao.TodolistDao;
import com.jeysan.cpf.daily.entity.Todolist;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class TodolistManager {
	private static Logger logger = LoggerFactory.getLogger(TodolistManager.class);
	
	private TodolistDao todolistDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveTodolist(Todolist entity){
		todolistDao.save(entity);
	}
	public void saveTodolistOnly(Todolist entity){
		todolistDao.saveOnly(entity);
	}
	public void updateTodolistOnly(Todolist entity){
		todolistDao.updateOnly(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveTodolists(List<Todolist> entites){
		for(Todolist entity : entites)
			todolistDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteTodolist(Long id){
		todolistDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteTodolists(Long id){
		todolistDao.batchExecute("delete Todolist where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteTodolists(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteTodolists(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Todolist getTodolist(Long id){
		return todolistDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Todolist> searchTodolist(final Page<Todolist> page,final List<PropertyFilter> filter){
		return todolistDao.findPage(page, filter);
	}
	
	@Autowired
	public void setTodolistDao(TodolistDao todolistDao) {
		this.todolistDao = todolistDao;
	}
	
	
}