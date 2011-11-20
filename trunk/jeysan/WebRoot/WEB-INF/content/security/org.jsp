<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/org.action">
	<input type="hidden" name="filter_EQS_orgCode"
		value="${param['filter_EQS_orgCode']}" />
	<input type="hidden" name="filter_LIKES_orgName_OR_simpleName"
		value="${param['filter_LIKES_orgName_OR_simpleName']}">
	<input type="hidden" name="filter_EQS_orgType"
		value="${param['filter_EQI_orgType']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/org.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							机构编码：
							<input type="text" name="filter_EQS_orgCode"
								value="${param['filter_EQS_orgCode']}" />
						</td>
						<td>
							机构名称：
							<input type="text" name="filter_LIKES_orgName_OR_simpleName"
								value="${param['filter_LIKES_orgName_OR_simpleName']}" />
						</td>
						<td>
							机构类型：
						</td>
						<td>
							<tags:js.dict.selector name="filter_EQI_orgType"
								value="${param['filter_EQI_orgType']}" dictCode="JS020"
								width="130" />
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
					<a class="add" href="${ctx}/security/org!input.action"
						target="navTab" rel="org-input" title="添加机构"><span>添加</span> </a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/security/org!delete.action?ids={sid_user}&result4Json.navTabId=nav_orgmanage"
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
					<th width="100" orderField="orgCode" class="orderFlag">
						机构编码
					</th>
					<th width="180" orderField="orgName" class="orderFlag">
						机构名称
					</th>
					<th width="180">
						上级机构
					</th>
					<th width="80">
						机构类型
					</th>
					<th width="80">
						是否有效
					</th>
					<th width="80" align="center">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_user" rel="${a.id}">
						<td height="25"><c:if test="${a.id!=999999999}">
							<input type="checkbox" name="ids" value="${a.id}" /></c:if>
						</td>
						<td>
							${b.index+1}
						</td>
						<td>
							${a.orgCode}
						</td>
						<td>
							${a.orgName}
						</td>
						<td>
							${a.parent.orgName}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.orgType}" />
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.disabledStatus}" />
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/security/org!view.action?id=${a.id}"
									target="navTab" title="查看机构信息" rel="org-view"></a>
								<a class="btnEdit"
									href="${ctx}/security/org!input.action?id=${a.id}"
									target="navTab" title="修改机构信息" rel="org-update"></a>
<c:if test="${a.id!=999999999}">
								<a class="btnDel"
									href="${ctx}/security/org!delete.action?id=${a.id}&result4Json.navTabId=nav_orgmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
</c:if>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>