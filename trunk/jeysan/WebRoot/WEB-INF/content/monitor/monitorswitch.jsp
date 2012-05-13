<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/monitor/monitorswitch.action">
	<input type="hidden" name="filter_EQI_id" value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/monitor/monitorswitch.action" method="post">
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
				<li><a class="add" href="${ctx}/monitor/monitorswitch!input.action" target="navTab" rel="monitorSwitch-input" title="添加监控开关"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/monitor/monitorswitch!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_monitorswitchmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																																			<th width="80" orderField="monitorType" class="orderFlag">监控类别</th>
																														<th width="80" orderField="switch" class="orderFlag">是否打开</th>
																				<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.monitorType}</td>
																																								<td>${a.switch}</td>
																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/monitor/monitorswitch!view.action?id=${a.id}" target="navTab" title="查看监控开关信息" rel="monitorSwitch-view"></a>
							<a class="btnEdit" href="${ctx}/monitor/monitorswitch!input.action?id=${a.id}" target="navTab" title="修改监控开关信息" rel="monitorSwitch-update"></a>
							<a class="btnDel" href="${ctx}/monitor/monitorswitch!delete.action?id=${a.id}&result4Json.navTabId=nav_monitorswitchmanage" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>