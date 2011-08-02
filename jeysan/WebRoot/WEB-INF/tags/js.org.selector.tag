<%@ include file="/common/taglibs.jsp" %>
<%@ attribute name="o1"	type="java.lang.String"	required="true"	description="隐藏字段" %>
<%@ attribute name="o1_v" type="java.lang.String" required="false" description="隐藏字段值" %>
<%@ attribute name="o2_v" type="java.lang.String" required="false" description="显示字段值" %>
<%@ attribute name="isRequired"	type="java.lang.Boolean" required="true" description="是否必须" %>
<%@ attribute name="size" type="java.lang.Integer"	required="false" description="长度" %>
<c:set var="o3" scope="page"><%=java.util.UUID.randomUUID()%></c:set>
<span id="${o3}">
<input id="${o1}" name="${o1}" type="hidden" value="${o1_v}"/>
<input id="_orgName_" name="_orgName_" <c:if test="${isRequired}">class="required"</c:if>  type="text" size="<%=size==null?27:size %>" value="${o2_v}" readonly="readonly" />
<a class="inputButton" href="${ctx}/security/org!preOrgSelect.action?o1=${o1}&o2=_orgName_&o3=${o3}" target="dialog" maxable=false title="选择所属机构" width="400" height="450">选择</a>
</span>