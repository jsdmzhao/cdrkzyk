<%@ include file="/common/taglibs.jsp" %>
<%@ tag import="org.springframework.context.ApplicationContext,
                 org.springframework.web.context.WebApplicationContext,
                 com.jeysan.cpf.security.service.UserManager,
                 com.jeysan.cpf.security.entity.User,
                 org.apache.commons.beanutils.BeanUtils" %>
<%@ attribute name="value"	type="java.lang.Object" required="true" description="对象值" %>
<%@ attribute name="property" type="java.lang.String" required="true"	description="对象属性" %>

<%	
	
	if(value.equals('0'))
		return;
	String key = new StringBuilder().append("user_").append(value).append("_").append(property).toString();
	Object o = request.getAttribute(key);
	if(o==null){
		ApplicationContext  applicationContext=(ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		UserManager userManager = applicationContext.getBean("userManager",UserManager.class);
Integer v = Integer.parseInt(value.toString().trim());
User user = userManager.getUser(v);
		o = BeanUtils.getProperty(user, property);
		request.setAttribute(key,o);
	}
%>
<%=o%>
