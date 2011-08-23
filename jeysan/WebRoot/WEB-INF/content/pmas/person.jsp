<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/pmas/person.action">
	<input type="hidden" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQS_code" value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_EQS_personCode" value="${param['filter_EQS_personCode']}" />
	<input type="hidden" name="filter_EQI_sex" value="${param['filter_EQI_sex']}" />
	<input type="hidden" name="filter_EQI_certType" value="${param['filter_EQI_certType']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQI_kind" value="${param['filter_EQI_kind']}" />
	<input type="hidden" name="filter_EQI_cancelType" value="${param['filter_EQI_cancelType']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/pmas/person.action" method="post">
		<div class="searchBar">

			<table class="searchContent">
				<tr>
					<td>
						姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}"/>
					</td>
					<td>
						性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<tags:js.dict.selector noRender="true" name="filter_EQI_sex" value="${param['filter_EQI_sex']}" dictCode="JS010"/>
					</td>
					<td>
						人员类别：<tags:js.dict.selector noRender="true" name="filter_EQI_kind" value="${param['filter_EQI_kind']}" dictCode="JS1050"/>
					</td>
					<td>
						人员编号：&nbsp;&nbsp;<input type="text" name="filter_EQS_personCode" value="${param['filter_EQS_personCode']}"/>
					</td>
				</tr>
				<tr>
					<td>
						证件号码：<input type="text" name="filter_EQS_code" value="${param['filter_EQS_code']}"/>
					</td>
					<td>
						证件类型：<tags:js.dict.selector noRender="true" name="filter_EQI_certType" value="${param['filter_EQI_certType']}" dictCode="JS1043"/>
					</td>
					<td>
						户口类别：<tags:js.dict.selector noRender="true" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" dictCode="JS1048"/>
					</td>
					<td>
						人员状态：<tags:js.dict.selector noRender="true" name="filter_EQI_cancelType" value="${param['filter_EQI_cancelType']}" dictCode="JS1010"/>
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
				<li><a class="add" href="${ctx}/pmas/person!input.action" target="navTab" rel="person-input" title="添加人员"><span>添加</span></a></li>
				<li><a class="delete" href="${ctx}/pmas/person!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_personmanage" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
				<li><a class="icon" href="javascript:void(0);"><span>打印</span></a></li>
				<li><a class="icon" href="doc/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="163">
			<thead>
				<tr>
					<th width="30" align="center"><input type="checkbox" class="checkboxCtrl" group="ids" /></th>
					<th width="30" align="center">序号</th>
																																			<th width="60" orderField="nameh" class="orderFlag">姓名</th>
																														<th width="80" orderField="sex" class="orderFlag">性别</th>
																														<th width="80" orderField="certType" class="orderFlag">证件类型</th>
																														<th width="120" orderField="code" class="orderFlag">证件号码</th>
																														<th width="120" orderField="personCode" class="orderFlag">人员编号</th>
																														<th width="80" orderField="cancelType" class="orderFlag">状态</th>
																														<th width="80" orderField="domicileType" class="orderFlag">户口类别</th>
																														<th width="80" orderField="kind" class="orderFlag">人员类别</th>
																																																																																																																																												<th width="80" align="center">操作</th>
<th width="55" align="center">配偶</th>
<th width="55" align="center">子女</th>
<th width="70" align="center">恢复与注销</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td height="25"><input type="checkbox" name="ids" value="${a.id}" /></td>
					<td>${b.index+1}</td>
																																								<td>${a.nameh}</td>
																																								<td><tags:js.dict.getValue value="${a.sex}"></tags:js.dict.getValue></td>
																																								<td><tags:js.dict.getValue value="${a.certType}"></tags:js.dict.getValue></td>
																																								<td>${a.code}</td>
																																								<td>${a.personCode}</td>
																																								<td><tags:js.dict.getValue value="${a.cancelType}"></tags:js.dict.getValue></td>
																																								<td><tags:js.dict.getValue value="${a.domicileType}"></tags:js.dict.getValue></td>
																																								<td><tags:js.dict.getValue value="${a.kind}"></tags:js.dict.getValue></td>
																																																																																																																																																	<td>
						<div style="width: 75px;">
							<a class="btnView" href="${ctx}/pmas/person!view.action?id=${a.id}" target="navTab" title="查看人员信息" rel="person-view"></a>
							<a class="btnEdit" href="${ctx}/pmas/person!input.action?id=${a.id}" target="navTab" title="修改人员信息" rel="person-update"></a>
							<a class="btnDel" href="${ctx}/pmas/person!delete.action?id=${a.id}&result4Json.navTabId=nav_personmanage" target="ajaxTodo" title="确定要删除吗？"></a>
						</div>
					</td>
					<td>
						<div style="width: 50px;">
							<a class="btnView" href="${ctx}/pmas/spouse!view.action?personId=${a.id}" target="navTab" title="查看配偶信息" rel="spouse-view"></a>
							<a class="btnEdit" href="${ctx}/pmas/spouse!input.action?personId=${a.id}" target="navTab" title="管理配偶信息" rel="spouse-update"></a>
						</div>
					</td>
					<td>
						<div style="width: 50px;">
							<a class="btnView" href="${ctx}/pmas/womanchildren!view.action?personId=${a.id}" target="navTab" title="查看子女信息" rel="womanchildren-view"></a>
							<a class="btnEdit" href="${ctx}/pmas/womanchildren.action?filter_EQL_person.id=${a.id}&personId=${a.id}&from=person" target="navTab" title="管理子女信息" rel="nav_womanchildrenmanage"></a>
						</div>
					</td>
					<td>
						<div style="width: 25px;">
<c:if test="${a.cancelType==672||a.cancelType==673}">
							<a class="btnDel" href="${ctx}/pmas/person!precancel.action?id=${a.id}&type=0" target="navTab" title="人员注销" rel="person-update"></a>
</c:if>
<c:if test="${a.cancelType!=672&&a.cancelType!=673}">
							<a class="btnSelect" href="${ctx}/pmas/person!cancel.action?id=${a.id}&type=1&result4Json.navTabId=nav_personmanage" target="ajaxTodo" title="确定要恢复注销吗？"></a>
</c:if>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>