<%@ include file="/common/taglibs.jsp" %>
<%@ attribute name="action"	type="java.lang.String"	required="false" description="必须的form的action" %>
<form id="pagerForm" method="post" action="${action}">
	<input type="hidden" id="pageNum" name="pageNo" value="${page.pageNo}" />
	<input type="hidden" id="numPerPage" name="pageSize" value="${page.pageSize}" />
	<input type="hidden" id="orderField" name="orderBy" value="${page.orderBy}" />
	<input type="hidden" id="orderDirection" name="order" value="${page.order}" />
	<jsp:doBody var="theBody"/> 
	${theBody}
</form>
<script>
$(function(){
	var orderBy_$ = $("th[orderField='${page.orderBy}']");
	if(orderBy_$){
		orderBy_$.removeClass();
		var newClass = '${page.order}';
		if(!orderBy_$.hasClass(newClass))
			orderBy_$.addClass(newClass);	
	}
});
</script>