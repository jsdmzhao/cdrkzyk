<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/marrycert.action">
	<input type="hidden" name="filter_LIKES_person.nameh"
		value="${param['filter_LIKES_person.nameh']}" />
	<input type="hidden" name="filter_EQS_person.code"
		value="${param['filter_EQS_person.code']}" />
	<input type="hidden" name="filter_EQS_person.personCode"
		value="${param['filter_EQS_person.personCode']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/marrycert.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_person.nameh"
								value="${param['filter_LIKES_person.nameh']}" />
						</td>
						<td>
							编码：
							<input type="text" name="filter_EQS_person.personCode"
								value="${param['filter_EQS_person.personCode']}" />
						</td>
						<td>
							证件号码：
							<input type="text" name="filter_EQS_person.code"
								value="${param['filter_EQS_person.code']}" />
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
					<a class="add" href="${ctx}/bcmas/marrycert!input.action"
						target="navTab" rel="marryCert-input" title="添加婚育证明"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/bcmas/marrycert!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_marrycertmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:void(0);"><span>打印</span>
					</a>
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
					<th width="80" orderField="person.nameh" class="orderFlag">
						姓名
					</th>
					<th width="120" orderField="person.personCode" class="orderFlag">
						编码
					</th>
					<th width="120" orderField="person.code" class="orderFlag">
						证件号码
					</th>
					<th width="80" orderField="issOrg" class="orderFlag">
						发证机关
					</th>
					<th width="80" orderField="issDate" class="orderFlag">
						发证日期
					</th>
					<th width="80" orderField="certCode" class="orderFlag">
						证书编号
					</th>
					<th width="80" align="center">
						操作
					</th>
					<th width="40" align="center">
						查看证书
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
							${a.person.nameh}
						</td>
						<td>
							${a.person.personCode}
						</td>
						<td>
							${a.person.code}
						</td>
						<td>
							${a.issOrg}
						</td>
						<td>
							<fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.certCode}
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/bcmas/marrycert!view.action?id=${a.id}"
									target="navTab" title="查看婚育证明信息" rel="marryCert-view"></a>
								<a class="btnEdit"
									href="${ctx}/bcmas/marrycert!input.action?id=${a.id}"
									target="navTab" title="修改婚育证明信息" rel="marryCert-update"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/marrycert!delete.action?id=${a.id}&result4Json.navTabId=nav_marrycertmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnLook"
									href="${ctx}/bcmas/marrycert!view.action?id=${a.id}"
									target="dialog" title="查看婚育证书" rel="marryCert-view"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>