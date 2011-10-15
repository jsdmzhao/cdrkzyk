package com.jeysan.cpf.security.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.security.dao.PostDao;
import com.jeysan.cpf.security.entity.Post;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class PostManager {
	private static Logger logger = LoggerFactory.getLogger(PostManager.class);
	
	private PostDao postDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void savePost(Post entity){
		postDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void savePosts(List<Post> entites){
		for(Post entity : entites)
			postDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deletePost(Integer id){
		postDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deletePosts(Integer id){
		postDao.batchExecute("delete Post where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deletePosts(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deletePosts(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Post getPost(Integer id){
		return postDao.get(id);
	}
	/**
	 * 职务编码查找
	 * @param postCode
	 * @return
	 */
	@Transactional(readOnly = true)
	public Post getPost(String postCode){
		List<Post> posts = queryAllPosts(null, postCode, null);
		if(posts!=null && posts.size() > 0)
			return posts.get(0);
		return null;
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Post> searchPost(final Page<Post> page,final List<PropertyFilter> filter){
		return postDao.findPage(page, filter);
	}
	
	@Autowired
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	@Transactional(readOnly = true)
	public List<Post> queryAllPosts(Integer userId,String postCode,String postName) {
		return postDao.getAllPostsByUserId(userId, postCode,postName);
	}
	
	
}