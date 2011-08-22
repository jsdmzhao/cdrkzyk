<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/bcmas/womansocialupbring!input.action?fertileWomanId=${param['filter_EQL_fertileWoman.id']}" target="navTab" rel="womanSocialUpbring-input" title="添加社会抚养费"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/bcmas/womansocialupbring!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_womansocialupbringmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
				<li><a class="icon" href="javascript:void(0);"><span>打印</span></a></li>
				<li><a class="icon" href="javascript:void(0);"><span>导出EXCEL</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="112">
			<thead>
				<tr>
					<th width="30" align="center"><input type="checkbox" class="checkboxCtrl" group="ids" /></th>
					<th width="30" align="center">序号</th>
																																			<th width="80">姓名</th>
																														<th width="80">妇女编码</th>
																														<th width="80">征收原因</th>
																														<th width="80" >应交金额</th>
																														<th width="80" >已交金额</th>
																														<th width="80" >是否缴清</th>
																														<th width="80" >缴交期限</th>
																																																																																																				<th width="80" align="center">操作</th>
<th width="50" align="center">缴费</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.fertileWoman.person.nameh}</td>
																																								<td>${a.fertileWoman.code}</td>
																																								<td>${a.cause}</td>
																																								<td>${a.totalMoney}</td>
																																								<td>${a.yetMoney}</td>
																																								<td><tags:js.yes.no.getValue value="${a.isPayup}"/></td>
																																								<td><fmt:formatDate value="${a.endDate}" pattern="yyyy-MM-dd"/></td>
																																																																																																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/bcmas/womansocialupbring!view.action?id=${a.id}" target="navTab" title="查看社会抚养费信息" rel="womanSocialUpbring-view"></a>
							<a class="btnEdit" href="${ctx}/bcmas/womansocialupbring!input.action?id=${a.id}" target="navTab" title="修改社会抚养费信息" rel="womanSocialUpbring-update"></a>
							<a class="btnDel" href="${ctx}/bcmas/womansocialupbring!delete.action?id=${a.id}&result4Json.navTabId=fertileWomanFix" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td><td>
						<c:if test="${a.isPayup==0}">
						<div style="width: 25px;">
							<a class="btnEdit" href="${ctx}/bcmas/womanupbringdetail!input.action?upbringId=${a.id}" target="navTab" title="缴费" rel="womanUpbringDetail-update"></a>
						</div>
						</c:if>
						<c:if test="${a.isPayup==1}">已缴清</c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>