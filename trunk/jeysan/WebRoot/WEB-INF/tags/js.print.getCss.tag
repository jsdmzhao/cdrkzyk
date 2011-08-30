<%-- 
	JSP 扩展标签,得到打印样式
--%>
<%@ attribute name="index1"	type="java.lang.Integer" required="true" description="(int)值" %>
<%@ attribute name="index2" type="java.lang.Integer" required="true" description="(int)" %>
<%@ attribute name="replaceCss" type="java.lang.String" required="true" description="(String)"%>
<%@ attribute name="defaultCss" type="java.lang.String" required="true" description="(String)"%>
<%@ tag dynamic-attributes="dynamicAttributes" description="" %>
<%=index1.intValue()==index2?(replaceCss==""?"In1-td-bottom":replaceCss):(defaultCss==""?"In1-td-rightbottom":defaultCss)%>