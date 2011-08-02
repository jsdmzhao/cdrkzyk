<%@ include file="/common/taglibs.jsp" %>
<%@ attribute name="collection"	type="java.util.Collection"	required="true"	description="集合" %>
<%@ attribute name="value"	type="java.lang.Object"	required="true"	description="值" %>
<jsp:doBody var="theBody"/>
<%
if(collection.contains(value)){
	%>${theBody}<%
}
%>