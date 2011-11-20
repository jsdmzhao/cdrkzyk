<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/resource.action">
	<input type="hidden" name="filter_EQS_resourceCode"
		value="${param['filter_EQS_resourceCode']}" />
	<input type="hidden" name="filter_LIKES_resourceName"
		value="${param['filter_LIKES_resourceName']}" />
	<input type="hidden" name="filter_EQI_parent.id"
		value="${param['filter_EQI_parent.id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/resource.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							编码：
							<input type="text" name="filter_EQS_resourceCode"
								value="${param['filter_EQS_resourceCode']}" />
						</td>
						<td>
							名称：
							<input type="text" name="filter_LIKES_resourceName"
								value="${param['filter_LIKES_resourceName']}" />
						</td>
						<td>
							父资源：
							<tags:js.map.selector noRender="true" result="${topLevelResource}" name="filter_EQI_parent.id" value="${param['filter_EQI_parent.id']}"/>
						</td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">
										检索
									</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li>
					<a class="add" href="${ctx}/security/resource!input.action"
						target="navTab" rel="resource-input" title="添加资源"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/security/resource!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_resourcemanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span> </a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:void(0);"><span>打印</span> </a>
				</li>
				<li>
					<a class="icon" href="javascript:void(0);"><span>导出EXCEL</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="resourceCode" class="orderFlag">
						资源编码
					</th>
					<th width="80" orderField="resourceName" class="orderFlag">
						资源名称
					</th>
					<th width="80">
						资源类型
					</th>
					<th width="180">
						资源值
					</th>
					<th width="80">
						父资源
					</th>
					<th width="80">
						资源序号
					</th>
					<th width="80" align="center">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td height="25">
							<input type="checkbox" name="ids" value="${a.id}" />
						</td>
						<td>
							${b.index+1}
						</td>
						<td>
							${a.resourceCode}
						</td>
						<td>
							${a.resourceName}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.resourceType}" />
						</td>
						<td>
							${a.resourceValue}
						</td>
						<td>
							${a.parent.resourceName}
						</td>
						<td>
							${a.resourceIndex}
						</td>

						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/security/resource!view.action?id=${a.id}"
									target="navTab" title="查看资源信息" rel="resource-view"></a>
								<a class="btnEdit"
									href="${ctx}/security/resource!input.action?id=${a.id}"
									target="navTab" title="修改资源信息" rel="resource-update"></a>
								<a class="btnDel"
									href="${ctx}/security/resource!delete.action?id=${a.id}&result4Json.navTabId=nav_resourcemanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>