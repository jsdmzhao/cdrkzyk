<%@ include file="/common/taglibs.jsp" %>
<%@tag import="com.jeysan.modules.utils.reflection.ReflectionUtils"%>
<%@ attribute name="obj" type="java.lang.Object" required="true" description="对象" %>
<%@ attribute name="property" type="java.lang.String" required="true" description="属性值" %>
<%@ attribute name="type" type="java.lang.String" required="true" description="对象属性类型" %>
<c:set var="value" value="<%=ReflectionUtils.getFieldValue(obj,property)%>"/>
<c:choose>
			<c:when test="${type=='dict'}"><tags:js.dict.getValue value="${value}"/></c:when>
			<c:when test="${type=='bool'}"><tags:js.yes.no.getValue value="${value}"/></c:when>
			<c:when test="${type=='date'}"><fmt:formatDate value="${value}" pattern="yyyy-MM-dd"/></c:when>
			<c:when test="${type=='time'}"><fmt:formatDate value="${value}" pattern="yyyy-MM-dd HH:mm:ss"/></c:when>
			<c:when test="${type=='money'}"><fmt:formatNumber value="${value}" type="currency" pattern="￥.00"/></c:when>
			<c:when test="${type=='number'}"><fmt:formatNumber value="${value}" pattern="#,#00.00"/></c:when>
			<c:when test="${type=='per'}"><fmt:formatNumber value="${value}" type="percent" pattern="#0.00%"/></c:when>
			<c:otherwise>${value}</c:otherwise>
</c:choose>