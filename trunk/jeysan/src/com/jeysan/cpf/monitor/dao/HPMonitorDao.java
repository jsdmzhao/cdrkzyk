package com.jeysan.cpf.monitor.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;

import com.jeysan.modules.orm.hibernate.HibernateDao;

@Component
public class HPMonitorDao extends HibernateDao {
	
	
	
	public List getListDoublecheckData()throws SQLException
	{
		String sql="select  w.CODE,n.NAMEH as NAMEH,S.NAMEH AS NAMEH2,wb.MARRY_STATUS,wc2.maxcount,b.job,wc.METHOD, wc.END_DATE,wc1.BIRTHDAY,b.ADDRESS from FHP_PERSON_BASIC b JOIN FHP_PERSON n on b.PERSON_ID=n.ID  LEFT JOIN FHP_SPOUSE s ON n.id=s.PERSON_ID  join FHP_FERTILE_WOMAN w on n.ID=W.PERSON_ID join FHP_WOMAN_BASIC wb on wb.WOMAN_ID=w.ID join FHP_WOMAN_CONTRACEPT wc on wc.WOMAN_ID=w.id left join FHP_WOMAN_CHILDREN wc1 on n.ID=wc1.PERSON_ID and wc1.CHILD_INDEX=1 left join (select count(1) maxcount,PERSON_ID from FHP_WOMAN_CHILDREN group by PERSON_ID) wc2 on n.ID=wc2.PERSON_ID where w.id in (select WOMAN_ID from FHP_DOUBLE_CHECK k)";
		return getDataList(sql);
	}
	
	public List getOverBirth()throws SQLException
	{
		String sql="SELECT 	fw. CODE, 	fp.NAMEH, 	'', 	fpb.ADDRESS, 	fwc.nn, 	fc.DATEH, 	fc.EDD, 	fpb.HOUSE_NUMBER FROM 	FHP_FIRST_CHILD_REG fc LEFT JOIN FHP_FERTILE_WOMAN fw ON fc.WOMAN_ID = fw.ID join FHP_PERSON fp on fw.PERSON_ID=fp.ID join FHP_PERSON_BASIC fpb on fp.ID=fpb.PERSON_ID left join (select PERSON_ID,COUNT(*) nn from FHP_WOMAN_CHILDREN group by PERSON_ID) fwc on fp.id=fwc.person_id WHERE DATEDIFF(CURDATE(),fc.DATEH)>210";
		return getDataList(sql);
	}
	
	public List getNoContraception()throws SQLException
	{
		String sql="SELECT 	fw. CODE, 	fp.NAMEH, 	fp.CODE, 	'未避孕', 	fwc.nn, 	fwc1.birthday, 	fpb.ADDRESS FROM 	FHP_FERTILE_WOMAN fw JOIN FHP_PERSON fp ON fw.PERSON_ID = fp.ID JOIN FHP_PERSON_BASIC fpb ON fp.ID = fpb.PERSON_ID LEFT JOIN( 	SELECT 		PERSON_ID, 		COUNT(*)nn 	FROM 		FHP_WOMAN_CHILDREN 	GROUP BY 		PERSON_ID )fwc ON fp.id = fwc.person_id LEFT JOIN( 	SELECT 		PERSON_ID, 		min(BIRTHDAY) as birthday 	FROM 		FHP_WOMAN_CHILDREN 	GROUP BY 		PERSON_ID )fwc1 ON fp.id = fwc1.person_id WHERE fw.ID not in(select t.WOMAN_ID from FHP_WOMAN_CONTRACEPT t)";
		return getDataList(sql);
	}
	
	
	public List getDataList(String sql)throws SQLException
	{
		return geDataList(sql,null);
	}

	public List geDataList(String sql,Vector param)throws SQLException {
		Connection con=SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
		PreparedStatement stm=con.prepareStatement(sql);
		if(param!=null)
		{
			setParam(stm, param);
		}
		ResultSet rs=stm.executeQuery();
		ResultSetMetaData rm=rs.getMetaData();
		int n=rm.getColumnCount();
		List l=new ArrayList();
		while(rs.next())
		{
			Object[] o=new Object[n];
			for(int i=0;i<n;i++)
			{
				o[i]=rs.getObject(i+1);
			}
			l.add(o);
			
		}
		
		return l;
	}
	
	public void setParam(PreparedStatement ps,Vector v) throws SQLException
	{
		for(int i=0;i<v.size();i++)
		{
			putPreparedStatement(ps, i, v.get(i));
		}
	}
	
	
	private void putPreparedStatement(PreparedStatement ps,int index,Object obj) throws SQLException{   
	    /*String*/  
	    if(obj instanceof String){   
	        ps.setString(index, obj.toString());   
	    }   
	    /*Integer*/  
	    if(obj instanceof Integer){   
	        ps.setInt(index, Integer.valueOf(obj.toString()));   
	    }   
	    /*Long*/  
	    if(obj instanceof Long){   
	        ps.setLong(index, Long.valueOf(obj.toString()));   
	    }   
	    /*Double*/  
	    if(obj instanceof Double){   
	        ps.setDouble(index, Double.valueOf(obj.toString()));   
	    }   
	    /*Date*/  
	    if(obj instanceof Date){
	    	ps.setDate(index, (Date)obj);
	    }   
	    if(obj instanceof BigDecimal){   
	        ps.setBigDecimal(index, BigDecimal.valueOf(Long.valueOf(obj.toString())));   
	    }   
	}   


}
