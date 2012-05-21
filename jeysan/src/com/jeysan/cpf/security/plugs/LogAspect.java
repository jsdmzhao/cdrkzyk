package com.jeysan.cpf.security.plugs;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.jeysan.cpf.security.entity.RunLog;

public class LogAspect  implements MethodInterceptor{
	private DataSource dataSource;;
	private List<String> excludeList;

	public List<String> getExcludeList() {
		return excludeList;
	}

	public void setExcludeList(List<String> excludeList) {
		this.excludeList = excludeList;
	}
	
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		Throwable ex = null;
		long start = System.currentTimeMillis();
		try {
			result = invocation.proceed();
		} catch (Throwable e) {
			ex = e;
		}
		boolean exclude = false;
		if (this.excludeList != null) {
			for (String ec : excludeList) {
				if(invocation.getMethod().getDeclaringClass().getName().startsWith(ec)){
					exclude = true;
					break;
				}
			}
		}
		if (!exclude){
			long end = System.currentTimeMillis();
			RunLog runLog = new RunLog();
			runLog.setBussClass(invocation.getMethod().getDeclaringClass().getName());
			runLog.setUpdateTime(new Date());
			runLog.setBussMethod(invocation.getMethod().getName());
			runLog.setLastTime(new Long(end-start).intValue());
			//runLogManager.saveRunLog(runLog);
		}
		if (ex != null) {
			throw ex;
		}
		return result;
	}
}
