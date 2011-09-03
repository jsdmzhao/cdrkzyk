<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/monitor/monitorlog.action">
	<input type="hidden" name="filter_EQI_id" value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/monitor/monitorlog.action" method="post">
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
				<li><a class="add" href="${ctx}/monitor/monitorlog!input.action" target="navTab" rel="monitorLog-input" title="添加用户操作日志"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/monitor/monitorlog!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_monitorlogmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																																			<th width="80" orderField="operatTime" class="orderFlag">操作时间</th>
																														<th width="80" orderField="operator" class="orderFlag">操作人</th>
																														<th width="80" orderField="operatIp" class="orderFlag">操作人IP</th>
																														<th width="80" orderField="content" class="orderFlag">操作内容</th>
																														<th width="80" orderField="lastTime" class="orderFlag">持续时间(S)</th>
																														<th width="80" orderField="effectRows" class="orderFlag">影响行数</th>
																				<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>