<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/pmas/villagerteam.action">
	<input type="hidden" name="filter_EQS_orgCode"
		value="${param['filter_EQS_orgCode']}" />
	<input type="hidden" name="filter_LIKES_orgName"
		value="${param['filter_LIKES_orgName']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/pmas/villagerteam.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							行政区编码：
							<input type="text" name="filter_EQS_orgCode"
								value="${param['filter_EQS_orgCode']}" />
						</td>
						<td>
							行政区名称：
							<input type="text" name="filter_LIKES_orgName"
								value="${param['filter_LIKES_orgName']}" />
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
					<a class="add" href="${ctx}/pmas/villagerteam!input.action"
						target="navTab" rel="villagerTeam-input" title="添加村民小组"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/pmas/villagerteam!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_villagerteammanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('村居小组基本信息')"><span>打印或导出</span>
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
					<th width="120" orderField="orgCode" class="orderFlag">
						行政区编码
					</th>
					<th width="400" orderField="orgName" class="orderFlag">
						行政区名称
					</th>
					<th width="80" orderField="teamName" class="orderFlag">
						小组名称
					</th>
					<th width="80" orderField="teamIndex" class="orderFlag">
						小组序号
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
							${a.orgCode}
						</td>
						<td>
							${a.orgName}
						</td>
						<td>
							${a.teamName}
						</td>
						<td>
							${a.teamIndex}
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/pmas/villagerteam!view.action?id=${a.id}"
									target="navTab" title="查看村民小组信息" rel="villagerTeam-view"></a>
								<a class="btnEdit"
									href="${ctx}/pmas/villagerteam!input.action?id=${a.id}"
									target="navTab" title="修改村民小组信息" rel="villagerTeam-update"></a>
								<a class="btnDel"
									href="${ctx}/pmas/villagerteam!delete.action?id=${a.id}&result4Json.navTabId=nav_villagerteammanage"
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