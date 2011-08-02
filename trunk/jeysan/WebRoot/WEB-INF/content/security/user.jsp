<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/user.action">
	<input type="hidden" name="filter_EQI_id"
		value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/user.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							主键：
							<input type="text" name="filter_EQI_id"
								value="${param['filter_EQI_id']}" />
						</td>
						<td>
							建档日期：
							<input type="text" class="date" readonly="true" />
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
						<li>
							<a class="button" href="demo_page6.html" target="dialog"
								rel="dlg_page1" title="查询框"><span>高级检索</span> </a>
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
					<a class="add" href="${ctx}/security/user!input.action"
						target="navTab" rel="user-input" title="添加用户"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/security/user!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_usermanage"
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
					<th width="80" orderField="userName" class="orderFlag">
						用户名
					</th>
					<th width="80" orderField="userCode" class="orderFlag">
						用户编码
					</th>
					<th width="280">
						所属机构
					</th>
					<th width="80">
						是否有效
					</th>
					<th width="80" align="center">
						操作
					</th>
					<th width="50" align="center">
						分配角色
					</th>
					<th width="50" align="center">
						分配职务
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
							${a.userName}
						</td>
						<td>
							${a.userCode}
						</td>
						<td>
							${a.org.orgName}
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.userEnabled}" />
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/security/user!view.action?id=${a.id}"
									target="navTab" title="查看用户信息" rel="user-view"></a>
								<a class="btnEdit"
									href="${ctx}/security/user!input.action?id=${a.id}"
									target="navTab" title="修改用户信息" rel="user-update"></a>
								<a class="btnDel"
									href="${ctx}/security/user!delete.action?id=${a.id}&result4Json.navTabId=nav_usermanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnAssign"
									href="${ctx}/security/user!preAssignRoles.action?id=${a.id}"
									target="navTab" title="分配角色" rel="user-role-update">分配角色</a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnAssign"
									href="${ctx}/security/user!preAssignPosts.action?id=${a.id}"
									target="navTab" title="分配职务" rel="user-post-update"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>