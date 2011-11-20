<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/daily/rubbishmail.action">
	<input type="hidden" name="filter_EQI_id" value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/daily/rubbishmail.action" method="post">
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
				<li><a class="add" href="${ctx}/daily/rubbishmail!input.action" target="navTab" rel="rubbishMail-input" title="添加fhp_rubbish_mail"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/daily/rubbishmail!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_rubbishmailmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
				<li><a class="icon" href="javascript:void(0);"><span>打印</span></a></li>
				<li><a class="icon" href="javascript:void(0);"><span>导出EXCEL</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center"><input type="checkbox" class="checkboxCtrl" group="ids" title="全选"/></th>
					<th width="30" align="center">序号</th>
																																			<th width="80" orderField="sendEmployeeId" class="orderFlag">发件人</th>
																														<th width="80" orderField="receiveEmployeeIds" class="orderFlag">收件人</th>
																														<th width="80" orderField="title" class="orderFlag">主题</th>
																														<th width="80" orderField="attachment" class="orderFlag">附件</th>
																														<th width="80" orderField="content" class="orderFlag">内容</th>
																														<th width="80" orderField="status" class="orderFlag">状态</th>
																																																																																																				<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.sendEmployeeId}</td>
																																								<td>${a.receiveEmployeeIds}</td>
																																								<td>${a.title}</td>
																																								<td>${a.attachment}</td>
																																								<td>${a.content}</td>
																																								<td>${a.status}</td>
																																																																																																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/daily/rubbishmail!view.action?id=${a.id}" target="navTab" title="查看fhp_rubbish_mail信息" rel="rubbishMail-view"></a>
							<a class="btnEdit" href="${ctx}/daily/rubbishmail!input.action?id=${a.id}" target="navTab" title="修改fhp_rubbish_mail信息" rel="rubbishMail-update"></a>
							<a class="btnDel" href="${ctx}/daily/rubbishmail!delete.action?id=${a.id}&result4Json.navTabId=nav_rubbishmailmanage" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>