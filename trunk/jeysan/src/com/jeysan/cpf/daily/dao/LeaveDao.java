package com.jeysan.cpf.daily.dao;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.daily.entity.Leave;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class LeaveDao extends HibernateDao<Leave, Long> {
	
	public void updateState(Long id,Integer state){
		super.batchExecute("update Leave set wfState = ? where id = ?",state, id);
	}
	
	public void updateState(Long id,Integer state,String wfid){
		super.batchExecute("update Leave set wfState = ? , wfPiid = ? where id = ?",state, wfid , id);
	}
	
}