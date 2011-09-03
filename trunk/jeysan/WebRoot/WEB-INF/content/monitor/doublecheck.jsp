﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/pmas/house.action">
	<input type="hidden" name="filter_EQS_houseCode" value="${param['filter_EQS_houseCode']}" />
	<input type="hidden" name="filter_EQI_houseType" value="${param['filter_EQI_houseType']}" />
	<input type="hidden" name="filter_EQI_houseAtt" value="${param['filter_EQI_houseAtt']}" />
	<input type="hidden" name="filter_LIKES_ownerName" value="${param['filter_LIKES_ownerName']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/pmas/house.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						房屋编号：<input type="text" name="filter_EQS_houseCode" value="${param['filter_EQS_houseCode']}"/>
					</td>
					<td>
						房屋类型：<tags:js.dict.selector noRender="true" name="filter_EQI_houseType" value="${param['filter_EQI_houseType']}" dictCode="JS1038"/>
					</td>
					<td>
						房屋属性：<tags:js.dict.selector noRender="true" name="filter_EQI_houseAtt" value="${param['filter_EQI_houseAtt']}" dictCode="JS1039"/>
					</td>
					<td>
						业主姓名：<input type="text" name="filter_LIKES_ownerName" value="${param['filter_LIKES_ownerName']}"/>
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
				<li><a class="add" href="${ctx}/pmas/house!input.action" target="navTab" rel="house-input" title="添加房屋"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/pmas/house!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_housemanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
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
																																			<th width="80" orderField="houseCode" class="orderFlag">房屋编号</th>
																														<th width="80">房屋类型</th>
																														<th width="120">房屋属性</th>
																														<th width="80">业主姓名</th>
																														<th width="120">业主身份证</th>
																														<th width="80" orderField="area" class="orderFlag">房屋面积</th>
																																																																																																																																																																																																																																																																																																																																																																																																																<th width="80" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.houseCode}</td>
																																								<td><tags:js.dict.getValue value="${a.houseType}" /></td>
																																								<td><tags:js.dict.getValue value="${a.houseAtt}" /></td>
																																								<td>${a.ownerName}</td>
																																								<td>${a.ownerCert}</td>
																																								<td>${a.area}</td>
																																																																																																																																																																																																																																																																																																																																																																																																																					<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/pmas/house!view.action?id=${a.id}" target="navTab" title="查看房屋信息" rel="house-view"></a>
							<a class="btnEdit" href="${ctx}/pmas/house!input.action?id=${a.id}" target="navTab" title="修改房屋信息" rel="house-update"></a>
							<a class="btnDel" href="${ctx}/pmas/house!delete.action?id=${a.id}&result4Json.navTabId=nav_housemanage" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>