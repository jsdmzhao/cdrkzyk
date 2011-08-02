package com.jeysan.cpf.pmas.dao;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class PersonDao extends HibernateDao<Person, Integer> {

}