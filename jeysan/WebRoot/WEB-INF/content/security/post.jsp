<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/post.action">
	<input type="hidden" name="filter_EQS_postCode"
		value="${param['filter_EQS_postCode']}" />
	<input type="hidden" name="filter_LIKES_postName"
		value="${param['filter_LIKES_postName']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/post.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							编码：
							<input type="text" name="filter_EQS_postCode"
								value="${param['filter_EQS_postCode']}" />
						</td>
						<td>
							名称：
							<input type="text" name="filter_LIKES_postName"
								value="${param['filter_LIKES_postName']}" />
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
					<a class="add" href="${ctx}/security/post!input.action"
						target="navTab" rel="post-input" title="添加职务"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/security/post!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_postmanage"
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
					<th width="80" orderField="postName" class="orderFlag">
						职务名称
					</th>
					<th width="80" orderField="postCode" class="orderFlag">
						职务编码
					</th>
					<th width="80">
						是否有效
					</th>
					<th width="80">
						职责
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
							${a.postName}
						</td>
						<td>
							${a.postCode}
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.postEnabled}"></tags:js.yes.no.getValue>
						</td>
						<td>
							${a.postContent}
						</td>
						<td class="operate">
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/security/post!view.action?id=${a.id}"
									target="navTab" title="查看职务信息" rel="post-view"></a>
								<a class="btnEdit"
									href="${ctx}/security/post!input.action?id=${a.id}"
									target="navTab" title="修改职务信息" rel="post-update"></a>
								<a class="btnDel"
									href="${ctx}/security/post!delete.action?id=${a.id}&result4Json.navTabId=nav_postmanage"
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