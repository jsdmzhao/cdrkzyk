<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/bcmas/fertilewoman.action">
	<input type="hidden" name="filter_LIKES_person.nameh" value="${param['filter_LIKES_person.nameh']}" />
	<input type="hidden" name="type" value="${param['type']}" />
	<input type="hidden" name="filter_EQD_createDate" value="${param['filter_EQD_createDate']}" />
	<input type="hidden" name="filter_EQS_code" value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/bcmas/fertilewoman.action?type=${param['type']}" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						姓名：<input type="text" name="filter_LIKES_person.nameh" value="${param['filter_LIKES_person.nameh']}"/>
					</td>
					<td>
						建卡日期：<input type="text" name="filter_EQD_createDate" class="date" readonly="true" value="${param['filter_EQD_createDate']}"/>
					</td>
					<td>
						编号：<input type="text" name="filter_EQS_code" value="${param['filter_EQS_code']}"/>
					</td>
					<td>
						区域：<input type="text" name="filter_EQS_area" value="${param['filter_EQS_area']}"/>
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
				<li><a class="add" href="${ctx}/bcmas/fertilewoman!input.action" target="navTab" rel="fertileWoman-input" title="添加育龄妇女"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/bcmas/fertilewoman!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_fertilewomanmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																																			<th width="80" orderField="person.nameh" class="orderFlag">姓名</th>
																														<th width="80" orderField="createDate" class="orderFlag">建卡日期</th>
																														<th width="80" orderField="code" class="orderFlag">妇女编码</th>
																														<th width="80" orderField="area" class="orderFlag">所属区域</th>
																				<th width="75" align="center">操作</th>
<th width="50" align="center">育妇详情</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.person.nameh}</td>
																																								<td><fmt:formatDate value="${a.createDate}" pattern="yyyy-MM-dd"/></td>
																																								<td>${a.code}</td>
																																								<td>${a.area}</td>
																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/bcmas/fertilewoman!view.action?id=${a.id}" target="navTab" title="查看育龄妇女信息" rel="fertileWoman-view"></a>
							<a class="btnEdit" href="${ctx}/bcmas/fertilewoman!input.action?id=${a.id}" target="navTab" title="修改育龄妇女信息" rel="fertileWoman-update"></a>
							<a class="btnDel" href="${ctx}/bcmas/fertilewoman!delete.action?id=${a.id}&result4Json.navTabId=nav_fertilewomanmanage" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td><td>
						<div style="width: 25px;">
							<a class="btnInfo" href="${ctx}/bcmas/fertilewoman!${param['type']}.action?id=${a.id}" target="navTab" title="育龄妇女详细信息" rel="fertileWomanFix"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>