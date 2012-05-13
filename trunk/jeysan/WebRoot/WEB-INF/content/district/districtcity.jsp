<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/district/districtcity.action">
	<input type="hidden" name="filter_EQI_id" value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/district/districtcity.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						主键：<input type="text" name="filter_EQI_id" value="${param['filter_EQI_id']}"/>
					</td>
					<td>
						建档日期：<input type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" />
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/district/districtcity!input.action" target="navTab" rel="districtCity-input" title="添加市"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/district/districtcity!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_districtcitymanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																																			<th width="80" orderField="code" class="orderFlag">编码</th>
																														<th width="80" orderField="name" class="orderFlag">名称</th>
																														<th width="80" orderField="parentId" class="orderFlag">PARENT_ID</th>
																				<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.code}</td>
																																								<td>${a.name}</td>
																																								<td>${a.parentId}</td>
																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/district/districtcity!view.action?id=${a.id}" target="navTab" title="查看市信息" rel="districtCity-view"></a>
							<a class="btnEdit" href="${ctx}/district/districtcity!input.action?id=${a.id}" target="navTab" title="修改市信息" rel="districtCity-update"></a>
							<a class="btnDel" href="${ctx}/district/districtcity!delete.action?id=${a.id}&result4Json.navTabId=nav_districtcitymanage" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>