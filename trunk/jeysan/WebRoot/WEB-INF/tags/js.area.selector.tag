<%@ include file="/common/taglibs.jsp"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="值"%>
<%@ attribute name="value" type="java.lang.String" required="false" description="编码值"%>
<%@ attribute name="valueLabel" type="java.lang.String" required="false" description="显示值"%>
<%@ attribute name="onChange" type="java.lang.String"	required="false" description="当值改变时的请求行为" %>
<%@ attribute name="id" type="java.lang.String" required="false" description="值"%>
<%@ attribute name="readonly" type="java.lang.Boolean" required="false" description="是否只读"%>
<%@ attribute name="size" type="java.lang.Integer" required="false" description="长度"%>
<c:if test="${empty id}">
	<c:set var="id" value="${name}"></c:set>
</c:if>
<input id="${id}_code_" name="${name}" type="hidden" value="${value}"/>
<input id="${id}_name_" size="${size==null?30:size}" type="text" <c:if test="${readonly}">readonly="readonly"</c:if> value="<c:if test="${not empty value}"><tags:js.area.getValue value="${value}"/></c:if><c:if test="${empty value}">${valueLabel}</c:if>" />
<a 
	href="${ctx}/district/districtvillage!areaselector.action?label4id=${id}_code_&label4name=${id}_name_&value=${value}&onChange=${onChange}"
	target="dialog" width="405" height="300">选择</a>
