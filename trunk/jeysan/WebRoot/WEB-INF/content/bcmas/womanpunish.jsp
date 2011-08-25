<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/bcmas/womanpunish!input.action?fertileWomanId=${param['filter_EQL_fertileWoman.id']}" target="navTab" rel="womanPunish-input" title="添加行政处罚"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/bcmas/womanpunish!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_womanpunishmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																														<th width="80" >处罚日期</th>
																														<th width="80" >处罚原因</th>
																														<th width="80" >处罚经办人</th>
																														<th width="80" >处罚金额</th>
																														<th width="80" >处罚次数</th>
																				<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.fertileWoman.nameh}</td>
																																								<td>${a.fertileWoman.code}</td>
																																								<td><fmt:formatDate value="${a.punishDate}" pattern="yyyy-MM-dd"/></td>
																																								<td>${a.punishCause}</td>
																																								<td>${a.agent}</td>
																																								<td>${a.moneyh}</td>
																																								<td>${a.count}</td>
																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/bcmas/womanpunish!view.action?id=${a.id}" target="navTab" title="查看行政处罚信息" rel="womanPunish-view"></a>
							<a class="btnEdit" href="${ctx}/bcmas/womanpunish!input.action?id=${a.id}" target="navTab" title="修改行政处罚信息" rel="womanPunish-update"></a>
							<a class="btnDel" href="${ctx}/bcmas/womanpunish!delete.action?id=${a.id}&result4Json.navTabId=fertileWomanFix" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>