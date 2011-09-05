package com.jeysan.cpf.datagather.build;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;


public class BaseImport {
	
    protected DataSource dataSource;
    protected Connection conn;
    
    public BaseImport(DataSource dataSource){	
    	this.dataSource = dataSource;
    }
    
    /**
     * 导入数据条数
     * @param result
     * @return
     */
    protected int getCount(int[] result){
		int sum = 0;
		for(int i : result){
			if(i > 0){
				sum += i;
			}
		}
		return sum;
	}
	
	public void run(Collection datas)throws SQLException{};
	
}
