<%@ include file="/common/taglibs.jsp" %>
<%@ tag import="org.apache.commons.lang.StringUtils"%>
<%@ attribute name="value"	type="java.lang.String"	required="true"	description="值" %>
<%=StringUtils.isEmpty(value)?"":(Integer.parseInt(value)==1?"是":"否")%>