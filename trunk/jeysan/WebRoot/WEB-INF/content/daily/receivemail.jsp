﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/daily/receivemail.action">
	<input type="hidden" name="filter_LIKES_title"
		value="${param['filter_LIKES_title']}" />
	<input type="hidden" name="dateKt"
		value="${param['dateKt']}" />
	<input type="hidden" name="filter_EQI_isRead"
		value="${param['filter_EQI_isRead']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/daily/receivemail.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							主题：
							<input type="text" name="filter_LIKES_title"
								value="${param['filter_LIKES_title']}" />
						</td>
						<td>
							发送时间：
							<input type="text" name="dateKt" class="date" readonly="true" value="${param['dateKt']}"/>
						</td>
						<td>
							邮件状态：
							<tags:js.dict.selector noRender="true" name="filter_EQI_isRead"
								value="${param['filter_EQI_isRead']}" dictCode="JS1081" />
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
					<a class="delete"
						href="${ctx}/daily/receivemail!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_receivemailmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
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
						<input type="checkbox" class="checkboxCtrl" group="ids" title="全选" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="sendEmployeeId" class="orderFlag">
						发件人
					</th>
					<th width="180" orderField="title" class="orderFlag">
						主题
					</th>
					<th width="120" orderField="dateKt" class="orderFlag">
						发送时间
					</th>
					<th width="120" orderField="isRead" class="orderFlag">
						邮件状态
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
							<tags:js.user.getValue property="userName" value="${a.sendEmployeeId}"/>
						</td>
						<td>
							${a.title}
						</td>
						<td>
							<fmt:formatDate value="${a.dateKt}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.isRead}"/>
						</td>
						<td>
							<div style="width: 50px;">
								<a class="btnView"
									href="${ctx}/daily/receivemail!view.action?id=${a.id}"
									target="navTab" title="查看邮件信息"
									rel="receiveMail-view"></a>
								<a class="btnDel"
									href="${ctx}/daily/receivemail!delete.action?id=${a.id}&result4Json.navTabId=nav_receivemailmanage"
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