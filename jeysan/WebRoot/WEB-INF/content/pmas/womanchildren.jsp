<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/pmas/womanchildren!input.action?fertileWomanId=${param['filter_EQL_fertileWoman.id']}" target="navTab" rel="womanChildren-input" title="添加子女"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/pmas/womanchildren!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_womanchildrenmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
				<li><a class="icon" href="javascript:void(0);"><span>打印</span></a></li>
				<li><a class="icon" href="javascript:void(0);"><span>导出EXCEL</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center"><input type="checkbox" class="checkboxCtrl" group="ids" /></th>
					<th width="30" align="center">序号</th>
																																			<th width="80" orderField="personId" class="orderFlag">人员ID</th>
																														<th width="80" orderField="nameh" class="orderFlag">姓名</th>
																														<th width="80" orderField="sex" class="orderFlag">性别</th>
																														<th width="80" orderField="birthday" class="orderFlag">出生日期</th>
																														<th width="80" orderField="birthAddress" class="orderFlag">出生地点</th>
																														<th width="80" orderField="policy" class="orderFlag">政策内外</th>
																																																																																																																																																																																																																																																<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.personId}</td>
																																								<td>${a.nameh}</td>
																																								<td>${a.sex}</td>
																																								<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
																																								<td>${a.birthAddress}</td>
																																								<td>${a.policy}</td>
																																																																																																																																																																																																																																																					<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/pmas/womanchildren!view.action?id=${a.id}" target="navTab" title="查看子女信息" rel="womanChildren-view"></a>
							<a class="btnEdit" href="${ctx}/pmas/womanchildren!input.action?id=${a.id}" target="navTab" title="修改子女信息" rel="womanChildren-update"></a>
							<a class="btnDel" href="${ctx}/pmas/womanchildren!delete.action?id=${a.id}&result4Json.navTabId=fertileWomanFix" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>