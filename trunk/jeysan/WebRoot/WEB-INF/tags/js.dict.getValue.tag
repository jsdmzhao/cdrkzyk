<%@ include file="/common/taglibs.jsp" %>
<%@ tag import="org.springframework.context.ApplicationContext,
                 org.springframework.web.context.WebApplicationContext,
                 com.jeysan.cpf.security.service.DictSubManager,
                 com.jeysan.cpf.security.entity.DictSub,
                 org.apache.commons.lang.StringUtils" %>
<%@ attribute name="value"	type="java.lang.String"	required="true"	description="值" %>
<%@ attribute name="isColor" type="java.lang.Boolean" required="false" description="是否着色" %>
<%	try{
		if(StringUtils.isNotEmpty(value)){
			String key = new StringBuilder().append("dict_").append(value).toString();
			DictSub dictSub = (DictSub)request.getAttribute(key);
			if(dictSub==null){
				ApplicationContext  applicationContext=(ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				DictSubManager dictSubManager = applicationContext.getBean("dictSubManager",DictSubManager.class);
				dictSub = dictSubManager.getDictSub(Integer.parseInt(value));
				request.setAttribute(key,dictSub);
			}
			if(dictSub!=null){
				if(isColor!=null&&isColor&&StringUtils.isNotEmpty(dictSub.getSubColor())){
					%><font color="<%=dictSub.getSubColor()%>"><%=dictSub.getSubName()%></font><%
				}else{
					%><%=dictSub.getSubName()%><%
				}
			}
		}
	}catch(Exception e){
		//e.printStackTrace();
	}
%>