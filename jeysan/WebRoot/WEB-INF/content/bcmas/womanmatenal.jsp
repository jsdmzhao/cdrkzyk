<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/bcmas/womanmatenal!input.action?fertileWomanId=${param['filter_EQL_fertileWoman.id']}" target="navTab" rel="womanMatenal-input" title="添加孕产"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/bcmas/womanmatenal!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_womanmatenalmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																														<th width="80" >妇女编码</th>
																														<th width="120" >怀孕政策属性</th>
																														<th width="80" >怀孕日期</th>
																														<th width="80" >怀孕原因</th>
																														<th width="80" >怀孕结果</th>
																														<th width="80" >预产期</th>
																																																																																																																																																																																																								<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.fertileWoman.person.nameh}</td>
																																								<td>${a.fertileWoman.code}</td>
																																								<td><tags:js.dict.getValue value="${a.conceptPolicy}"/></td>
																																								<td><fmt:formatDate value="${a.conceptDate}" pattern="yyyy-MM-dd"/></td>
																																								<td>${a.conceptCause}</td>
																																								<td><tags:js.dict.getValue value="${a.conceptResult}"/></td></td>
																																								<td><fmt:formatDate value="${a.edd}" pattern="yyyy-MM-dd"/></td>
																																																																																																																																																																																																													<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/bcmas/womanmatenal!view.action?id=${a.id}" target="navTab" title="查看孕产信息" rel="womanMatenal-view"></a>
							<a class="btnEdit" href="${ctx}/bcmas/womanmatenal!input.action?id=${a.id}" target="navTab" title="修改孕产信息" rel="womanMatenal-update"></a>
							<a class="btnDel" href="${ctx}/bcmas/womanmatenal!delete.action?id=${a.id}&result4Json.navTabId=fertileWomanFix" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>