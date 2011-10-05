<%@ include file="/common/taglibs.jsp" %>
<%@ attribute name="rowIndex" type="java.lang.Integer" required="true" description="行的序号" %>
<%@ attribute name="rows" type="java.lang.Integer" required="true" description="总行数" %>
<%@ attribute name="columnIndex" type="java.lang.Integer" required="true" description="列的序号" %>
<%@ attribute name="columns" type="java.lang.Integer" required="true" description="总列数"%>
<%@ attribute name="cssNormal" type="java.lang.String" required="true" description="正常的样式"%>
<%@ attribute name="cssLastRow" type="java.lang.String" required="true" description="最后一行的样式"%>
<%@ attribute name="cssLastColumn" type="java.lang.String" required="true" description="最后一列的样式"%>
<c:if test="${rowIndex+1<rows}">
	<c:if test="${columnIndex+1<columns}">${cssNormal}</c:if>
	<c:if test="${columnIndex+1==columns}">${cssLastColumn}</c:if>
</c:if>
<c:if test="${rowIndex+1==rows}">
	<c:if test="${columnIndex+1<columns}">${cssLastRow}</c:if>
	<c:if test="${columnIndex+1==columns}">none</c:if>
</c:if>