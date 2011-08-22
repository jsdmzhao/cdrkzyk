<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/pmas/personin.action">
	<input type="hidden" name="filter_LIKES_person.nameh" value="${param['filter_LIKES_person.nameh']}" />
	<input type="hidden" name="filter_EQI_person.sex" value="${param['filter_EQI_person.sex']}" />
	<input type="hidden" name="filter_EQI_inCause" value="${param['filter_EQI_inCause']}" />
	<input type="hidden" name="filter_EQD_inDate" value="${param['filter_EQD_inDate']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/pmas/personin.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						姓名：<input type="text" name="filter_LIKES_person.nameh" value="${param['filter_LIKES_person.nameh']}"/>
					</td>
					<td>
						性别：<tags:js.dict.selector noRender="true" name="filter_EQI_person.sex" value="${param['filter_EQI_person.sex']}" dictCode="JS010"/>
					</td>
					<td>
						流入原因：<tags:js.dict.selector noRender="true" name="filter_EQI_inCause" value="${param['filter_EQI_inCause']}" dictCode="JS1042"/>
					</td>
					<td>
						流入日期：<input name="filter_EQD_inDate" type="text" class="date" readonly="true" value="${param['filter_EQD_inDate']}"/>
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
				<li><a class="add" href="${ctx}/pmas/personin!input.action" target="navTab" rel="personIn-input" title="添加人口流入"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/pmas/personin!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_personinmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																														<th width="80" orderField="person.sex" class="orderFlag">性别</th>
																														<th width="80" orderField="inCause" class="orderFlag">流入原因</th>
																														<th width="80" orderField="inType" class="orderFlag">流入类型</th>
																														<th width="80" orderField="inDate" class="orderFlag">流入日期</th>
																														<th width="120" orderField="inAddressCode" class="orderFlag">流入地编码</th>
																																																																																																				<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.person.nameh}</td>
																																								<td><tags:js.dict.getValue value="${a.person.sex}"/></td>
																																								<td><tags:js.dict.getValue value="${a.inCause}"/></td>
																																								<td><tags:js.dict.getValue value="${a.inType}"/></td>
																																								<td><fmt:formatDate value="${a.inDate}" pattern="yyyy-MM-dd"/></td>
																																								<td>${a.inAddressCode}</td>
																																																																																																									<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/pmas/personin!view.action?id=${a.id}" target="navTab" title="查看人口流入信息" rel="personIn-view"></a>
							<a class="btnEdit" href="${ctx}/pmas/personin!input.action?id=${a.id}" target="navTab" title="修改人口流入信息" rel="personIn-update"></a>
							<a class="btnDel" href="${ctx}/pmas/personin!delete.action?id=${a.id}&result4Json.navTabId=nav_personinmanage" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>