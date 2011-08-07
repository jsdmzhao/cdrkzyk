<%@ include file="/common/taglibs.jsp" %>

<%@ attribute name="result" type="java.util.Map" required="true" description="键值对的集合" %>
<%@ attribute name="name" type="java.lang.String" required="true" description="组件名称" %>
<%@ attribute name="value"	type="java.lang.String"	required="false" description="值" %>
<%@ attribute name="onChange" type="java.lang.String" required="false"	description="监测事件" %>
<%@ attribute name="readOnly" type="java.lang.Boolean"	required="false" description="是否只读" %>
<%@ attribute	name="class1"	type="java.lang.String"	required="false"	description="样式" %>
<%@ attribute	name="noAll"	type="java.lang.Boolean"	required="false"	description="是否要‘请选择’，默认需要" %>
<%@ attribute	name="width"	type="java.lang.String"	required="false"	description="长度" %>
<%@ attribute	name="noRender"	type="java.lang.Boolean"	required="false"	description="是否需要用DWZ样式渲染,默认渲染" %>
<select style="width:<%=width==null?100:width%>px" class="<c:if test="${!noRender}">combox</c:if> <c:if test="${!empty(class1)}">${class1}</c:if>" name="${name}" value="${value}" <c:if test="${!empty(onChange)}">change="${onChange}"</c:if> <c:if test="${readOnly}">readOnly="readOnly"</c:if>>
	<c:if test="${!noAll}"><option value="">请选择</option></c:if>
	<c:forEach items="${result}" var="a" varStatus="b">
	<option value="${a.key}" <c:if test="${value==a.key}">selected="selected"</c:if>>${a.value}</option>
	</c:forEach>
</select>