<%@ include file="/common/taglibs.jsp" %>
<%@ tag import="org.springframework.context.ApplicationContext,
                 org.springframework.web.context.WebApplicationContext,
                 com.jeysan.cpf.district.service.DistrictProvinceManager,
                 org.apache.commons.lang.StringUtils" %>
<%@ attribute name="value"	type="java.lang.String"	required="true" description="值" %>
<%	
	if(StringUtils.isEmpty(value))
		return;
	try{
			String key = "area___"+value;
			String areaName  = (String)request.getAttribute(key);
			if(StringUtils.isEmpty(areaName)){
				ApplicationContext applicationContext=(ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				DistrictProvinceManager districtProvinceManager = applicationContext.getBean("districtProvinceManager",DistrictProvinceManager.class);
				areaName = districtProvinceManager.getAreaNameByCode(value);
				request.setAttribute(key,areaName);
			}
			if(StringUtils.isNotEmpty(areaName)){
				%><%=areaName%><%
			}
	}catch(Exception e){
		//e.printStackTrace();
	}
%>