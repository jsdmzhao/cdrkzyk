<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/role.action">
	<input type="hidden" name="filter_EQS_roleCode"
		value="${param['filter_EQS_roleCode']}" />
	<input type="hidden" name="filter_LIKES_roleName"
		value="${param['filter_LIKES_roleName']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/role.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							编码：
							<input type="text" name="filter_EQS_roleCode"
								value="${param['filter_EQS_roleCode']}" />
						</td>
						<td>
							名称：
							<input type="text" name="filter_LIKES_roleName"
								value="${param['filter_LIKES_roleName']}" />
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
					<a class="add" href="${ctx}/security/role!input.action"
						target="navTab" rel="role-input" title="添加角色"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/security/role!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_rolemanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span> </a>
				</li>
				<li class="line">
					line
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
					<th width="80" orderField="roleCode" class="orderFlag">
						角色编码
					</th>
					<th width="80" orderField="roleName" class="orderFlag">
						角色名称
					</th>
					<th width="80">
						是否启用
					</th>
					<th width="80">
						是否受限
					</th>
					<th width="80" align="center">
						操作
					</th>
					<th width="60" align="center">
						分配资源
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
							${a.roleCode}
						</td>
						<td>
							${a.roleName}
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.roleEnable}" />
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.roleIslimited}" />
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/security/role!view.action?id=${a.id}"
									target="navTab" title="查看角色信息" rel="role-view"></a>
								<a class="btnEdit"
									href="${ctx}/security/role!input.action?id=${a.id}"
									target="navTab" title="修改角色信息" rel="role-update"></a>
								<a class="btnDel"
									href="${ctx}/security/role!delete.action?id=${a.id}&result4Json.navTabId=nav_rolemanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnAssign"
									href="${ctx}/security/role!preAssignResources.action?id=${a.id}"
									target="navTab" title="分配资源" rel="role-resources-update"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>