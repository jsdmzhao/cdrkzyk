<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/bcmas/womanupbringdetail!input.action" target="navTab" rel="womanUpbringDetail-input" title="添加社会抚养费缴交"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/bcmas/womanupbringdetail!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_womanupbringdetailmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																																			<th width="80" orderField="upbringId" class="orderFlag">UPBRING_ID</th>
																														<th width="80" orderField="count" class="orderFlag">缴款序号</th>
																														<th width="80" orderField="moneyh" class="orderFlag">本次应缴金额</th>
																														<th width="80" orderField="charger" class="orderFlag">收款人</th>
																														<th width="80" orderField="dateh" class="orderFlag">交款日期</th>
																														<th width="80" orderField="voucherCode" class="orderFlag">收据编号</th>
																				<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.upbringId}</td>
																																								<td>${a.counth}</td>
																																								<td>${a.moneyh}</td>
																																								<td>${a.charger}</td>
																																								<td><fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/></td>
																																								<td>${a.voucherCode}</td>
																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/bcmas/womanupbringdetail!view.action?id=${a.id}" target="navTab" title="查看社会抚养费缴交信息" rel="womanUpbringDetail-view"></a>
							<a class="btnEdit" href="${ctx}/bcmas/womanupbringdetail!input.action?id=${a.id}" target="navTab" title="修改社会抚养费缴交信息" rel="womanUpbringDetail-update"></a>
							<a class="btnDel" href="${ctx}/bcmas/womanupbringdetail!delete.action?id=${a.id}&result4Json.navTabId=fertileWomanFix" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>