<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${ctx}/bcmas/womanbearassurance!input.action?fertileWomanId=${param['filter_EQL_fertileWoman.id']}" target="navTab" rel="womanBearAssurance-input" title="添加计划生育保险"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/bcmas/womanbearassurance!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_womanbearassurancemanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="112">
			<thead>
				<tr>
					<th width="30" align="center"><input type="checkbox" class="checkboxCtrl" group="ids" /></th>
					<th width="30" align="center">序号</th>
																																			<th width="80">姓名</th>
																														<th width="80" >妇女编码</th>
																														<th width="80" >投保类型</th>
																														<th width="80" >投保年月</th>
																														<th width="80" >投保金额</th>
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
																																								<td><tags:js.dict.getValue value="${a.typeh}"/></td>
																																								<td>${a.dateh}</td>
																																								<td>${a.moneyh}</td>
																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/bcmas/womanbearassurance!view.action?id=${a.id}" target="navTab" title="查看计划生育保险信息" rel="womanBearAssurance-view"></a>
							<a class="btnEdit" href="${ctx}/bcmas/womanbearassurance!input.action?id=${a.id}" target="navTab" title="修改计划生育保险信息" rel="womanBearAssurance-update"></a>
							<a class="btnDel" href="${ctx}/bcmas/womanbearassurance!delete.action?id=${a.id}&result4Json.navTabId=fertileWomanFix" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>