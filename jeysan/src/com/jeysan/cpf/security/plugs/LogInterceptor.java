package com.jeysan.cpf.security.plugs;

import java.sql.Connection;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.lang.xwork.ArrayUtils;
import org.apache.commons.lang.xwork.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeysan.modules.utils.sql.JdbcUtil;

@Aspect
@Component
public class LogInterceptor {
	
	private static final String SQL = "insert into JS_AUTH_RUN_LOG(UPDATE_TIME,BUSS_CLASS,BUSS_METHOD,LAST_TIME,REMARK) values (?,?,?,?,?)";
	
	private static final int limit = 10;
	
	private int record = 0;
	
	@Autowired
	private DataSource dataSource; 
	
	private Connection conn;
	
	@Pointcut("execution(public * com.jeysan.cpf.*.service.*Manager.*(..))")
	public void pointCut() {

		// System.out.println("yes...");
	}

	@Before("pointCut()")
	public void before() {

		// System.out.println("before method...");

	}

	@Around(value = "pointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		//System.out.println("before doAround......");
		Long time = System.currentTimeMillis();   
		Object obj = pjp.proceed();
		String className = pjp.getTarget().getClass().getName();
		String method = pjp.getSignature().getName();
		if(StringUtils.contains(className, "com.jeysan.cpf.security.service")||StringUtils.startsWith(method, "set"))
			return obj;
		time = System.currentTimeMillis() - time; 
		System.out.println(String.format("***********Class:%s,Method:%s,Spend:%s", className,method,time));
		
		/*RunLog runLog = new RunLog();
		runLog.setBussClass(className);
		runLog.setUpdateTime(new Date());
		runLog.setBussMethod(method);
		runLog.setLastTime(new Long(time).intValue());
		runLogManager.saveRunLog(runLog);
		*/
		if(conn == null)
			conn = dataSource.getConnection();
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		jdbcUtil.executePreparedStatementUpdate(SQL, new Object[]{new Date(),className,method,time.intValue(),ArrayUtils.toString(pjp.getArgs())});
		record++;
		if(record >= limit){
			conn.commit();
			record = 0;
		}
		return obj;
	}

}
