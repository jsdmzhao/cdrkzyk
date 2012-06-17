package com.jeysan.cpf.decision.dao;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.jeysan.cpf.decision.entity.Fixbasicquery1View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class Fixbasicquery1ViewDao extends HibernateDao<Fixbasicquery1View, Long> {
	
	public Page<Fixbasicquery1View> findPage4Repeat(final Page<Fixbasicquery1View> page,final String repeat){
		
		Assert.notNull(repeat,"查询参数为空！！");
		
		StringBuffer hql = new StringBuffer().append("from Fixbasicquery1View where 1=1 ");
		if(repeat.indexOf("1") > -1){
			hql.append("and nameh in (select nameh from Fixbasicquery1View group by nameh having count(nameh) > 1)");
		}
		if(repeat.indexOf("2") > -1){
			hql.append("and code in (select code from Fixbasicquery1View group by code having count(code) > 1)");
		}
		
		return findPage(page, hql.toString());
	}
}