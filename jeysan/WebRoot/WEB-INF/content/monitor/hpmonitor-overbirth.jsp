<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/monitor/monitorlog.action">
	<input type="hidden" name="filter_EQI_id" value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">


		
		<table class="table" width="100%" layouth="50">
			<thead>
				<tr>
					
					<th width="50" align="center">序号</th>
					<th width="100" orderField="operatTime" class="orderFlag">妇女编码</th>
					<th width="100" orderField="operator" class="orderFlag">姓名</th>
					<th width="100" orderField="operatIp" class="orderFlag">婚嫁与统计</th>
					<th width="100" orderField="content" class="orderFlag">现居住地</th>
					<th width="150" orderField="lastTime" class="orderFlag">现家庭子女数</th>
					<th width="120" orderField="effectRows" class="orderFlag">怀孕时间</th>
					<th width="150" orderField="effectRows" class="orderFlag">预产期</th>
					<th width="150" orderField="effectRows" class="orderFlag">门牌号码</th>
				
				</tr>
					</thead>
					
				<c:forEach items="${list }" var="dlist" varStatus="num">
				<tr>
				<td>
				<c:out value="${num.index }"></c:out></td>
				<td><c:out value="${dlist[0] }"></c:out></td>
				<td><c:out value="${dlist[1] }"></c:out></td>
				<td><c:out value="${dlist[2] }"></c:out></td>
				<td><c:out value="${dlist[3] }"></c:out></td>
				<td>
				<c:if test="${empty dlist[4]}">0</c:if>
				<c:out value="${dlist[4] }"></c:out>
				</td>
				<td><c:out value="${dlist[5] }"></c:out></td>
				<td><c:out value="${dlist[6] }"></c:out></td>
				<td><c:out value="${dlist[7] }"></c:out></td>
				</tr>
	
				</c:forEach>
		
			
								
		</table>
	<div class="panelBar">
			<ul class="toolBar" dir="rtl">
				
				<li><a class="icon" href="javascript:void(0);"><span>汇总</span></a></li>
				<li><a class="icon" href="javascript:void(0);"><span>导出EXCEL</span></a></li>
				<li><a class="icon" href="javascript:void(0);"><span>打印</span></a></li>
				<li><a class="icon" href="javascript:void(0);"><span>返回</span></a></li>
			</ul>
		</div>
		<%@ include file="/common/page-foot.jsp"  %>

</div>