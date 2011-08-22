<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/pmas/house!list4lookup.action">
	<input type="hidden" name="filter_EQS_houseCode" value="${param['filter_EQS_houseCode']}" />
	<input type="hidden" name="filter_EQI_houseType" value="${param['filter_EQI_houseType']}" />
	<input type="hidden" name="filter_EQI_houseAtt" value="${param['filter_EQI_houseAtt']}" />
	<input type="hidden" name="filter_LIKES_ownerName" value="${param['filter_LIKES_ownerName']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return dwzSearch(this, 'dialog');" action="${ctx}/pmas/house!list4lookup.action" method="post">
		<div class="searchBar">

			<table class="searchContent">
				<tr>
					<td>
						房屋编号：<input type="text" name="filter_EQS_houseCode" value="${param['filter_EQS_houseCode']}"/>
					</td>
					<td>
						房屋类型：<tags:js.dict.selector noRender="true" name="filter_EQI_houseType" value="${param['filter_EQI_houseType']}" dictCode="JS1038"/>
					</td>
				</tr><tr>
					<td>
						业主姓名：<input type="text" name="filter_LIKES_ownerName" value="${param['filter_LIKES_ownerName']}"/>
					</td>
					<td>
						房屋属性：<tags:js.dict.selector noRender="true" name="filter_EQI_houseAtt" value="${param['filter_EQI_houseAtt']}" dictCode="JS1039"/>
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
		<table class="table" targettype="dialog" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
																																			<th width="80" orderField="houseCode" class="orderFlag">房屋编号</th>
																														<th width="80">房屋类型</th>
																														<th width="120">房屋属性</th>
																														<th width="80">业主姓名</th>
																														<th width="120">业主身份证</th>
																														<th width="80" orderField="area" class="orderFlag">房屋面积</th>
																																																																																																																																												<th width="30" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td>${b.index+1}</td>
																																								<td>${a.houseCode}</td>
																																								<td><tags:js.dict.getValue value="${a.houseType}" /></td>
																																								<td><tags:js.dict.getValue value="${a.houseAtt}" /></td>
																																								<td>${a.ownerName}</td>
																																								<td>${a.ownerCert}</td>
																																								<td>${a.area}</td>
																																																																																																																																																	<td>
						<div style="width: 30px;">
							<a class="btnSelect" href="javascript:$.bringBack({houseId:'${a.id}', houseCode:'${a.houseCode}'})" title="确定带回">选择</a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot4dwz.jsp"  %>
	</div>
</div>