package com.jeysan.cpf.comm.dao;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.comm.entity.FileManager;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class FileManagerDao extends HibernateDao<FileManager, Long> {

}