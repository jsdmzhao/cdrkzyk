package com.jeysan.cpf.security.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.jeysan.cpf.security.entity.Post;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class PostDao extends HibernateDao<Post, Integer> {

	public List<Post> getAllPostsByUserId(Integer userId , String postCode,String postName){
		StringBuilder sb = new StringBuilder();
		Map values = Maps.newHashMap();
		if(userId == null){
			sb.append("select r from com.jeysan.cpf.security.entity.Post r where r.postEnabled = 1 ");
		}else{
			sb.append("select distinct r from com.jeysan.cpf.security.entity.Post u left join u.postList as r where r.postEnabled = 1 and u.id = :userId ");
			values.put("userId", userId);
		}
		if(StringUtils.isNotEmpty(postCode)){
			sb.append(" and r.postCode like :postCode ");
			values.put("postCode", "%"+postCode+"%");
		}
		if(StringUtils.isNotEmpty(postName)){
			sb.append(" and r.postName like :postName ");
			values.put("postName", "%"+postName+"%");
		}
		sb.append(" order by r.postCode ");
		return find(sb.toString(),values);
	}

}