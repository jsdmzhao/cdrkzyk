﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/bcmas/womancontracept.action">
	<input type="hidden" name="filter_EQI_id" value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/bcmas/womancontracept.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						主键：<input type="text" name="filter_EQI_id" value="${param['filter_EQI_id']}"/>
					</td>
					<td>
						建档日期：<input type="text" class="date" readonly="true" />
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
					<li><a class="button" href="demo_page6.html" target="dialog" rel="dlg_page1" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/bcmas/womancontracept!input.action" target="navTab" rel="womanContracept-input" title="添加避孕"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/bcmas/womancontracept!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_womancontraceptmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
				<li><a class="icon" href="javascript:void(0);"><span>打印</span></a></li>
				<li><a class="icon" href="javascript:void(0);"><span>导出EXCEL</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="173">
			<thead>
				<tr>
					<th width="30" align="center"><input type="checkbox" class="checkboxCtrl" group="ids" /></th>
					<th width="30" align="center">序号</th>
																																			<th width="80" orderField="womanId" class="orderFlag">WOMAN_ID</th>
																														<th width="80" orderField="method" class="orderFlag">避孕节育措施</th>
																														<th width="80" orderField="hospitalType" class="orderFlag">手术医院类型</th>
																														<th width="80" orderField="doctor" class="orderFlag">手术医生</th>
																														<th width="80" orderField="hospital" class="orderFlag">手术医院</th>
																														<th width="80" orderField="opsDate" class="orderFlag">手术日期</th>
																																																																																																																																																																																																																																																<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.womanId}</td>
																																								<td>${a.method}</td>
																																								<td>${a.hospitalType}</td>
																																								<td>${a.doctor}</td>
																																								<td>${a.hospital}</td>
																																								<td><fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd"/></td>
																																																																																																																																																																																																																																																					<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/bcmas/womancontracept!view.action?id=${a.id}" target="navTab" title="查看避孕信息" rel="womanContracept-view"></a>
							<a class="btnEdit" href="${ctx}/bcmas/womancontracept!input.action?id=${a.id}" target="navTab" title="修改避孕信息" rel="womanContracept-update"></a>
							<a class="btnDel" href="${ctx}/bcmas/womancontracept!delete.action?id=${a.id}&result4Json.navTabId=nav_womancontraceptmanage" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>