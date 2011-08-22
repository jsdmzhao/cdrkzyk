﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageHeader">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/bcmas/womanbasic!input.action" target="navTab" rel="womanBasic-input" title="添加基础信息"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/bcmas/womanbasic!delete.action?ids={sid_xxx}&result4Json.navTabId=fertileWomanFix" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																																			<th width="80">WOMAN_ID</th>
																														<th width="80">婚姻状态</th>
																														<th width="80">夫婚姻状态</th>
																														<th width="80">初婚日期</th>
																														<th width="80">婚变日期</th>
																														<th width="80">领光荣证日期</th>
																																																																																																																																																																																																																																																																				<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.womanId}</td>
																																								<td>${a.marryStatus}</td>
																																								<td>${a.spouseMarryStatus}</td>
																																								<td><fmt:formatDate value="${a.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
																																								<td><fmt:formatDate value="${a.marryCryDate}" pattern="yyyy-MM-dd"/></td>
																																								<td><fmt:formatDate value="${a.getGrzDate}" pattern="yyyy-MM-dd"/></td>
																																																																																																																																																																																																																																																																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/bcmas/womanbasic!view.action?id=${a.id}" target="navTab" title="查看基础信息信息" rel="womanBasic-view"></a>
							<a class="btnEdit" href="${ctx}/bcmas/womanbasic!input.action?id=${a.id}" target="navTab" title="修改基础信息信息" rel="womanBasic-update"></a>
							<a class="btnDel" href="${ctx}/bcmas/womanbasic!delete.action?id=${a.id}&result4Json.navTabId=fertileWomanFix" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>