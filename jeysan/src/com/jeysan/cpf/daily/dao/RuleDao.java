package com.jeysan.cpf.daily.dao;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.daily.entity.Rule;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class RuleDao extends HibernateDao<Rule, Long> {

}