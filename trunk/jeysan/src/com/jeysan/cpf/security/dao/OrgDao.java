/**
 * 
 */
package com.jeysan.cpf.security.dao;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.security.entity.Org;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class OrgDao extends HibernateDao<Org, Integer> {

}
