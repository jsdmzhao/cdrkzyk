<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/daily/sendmail.action">
	<input type="hidden" name="filter_EQS_status"
		value="${param['filter_EQS_status']}" />
	<input type="hidden" name="filter_LIKES_title"
		value="${param['filter_LIKES_title']}" />
	<input type="hidden" name="dateKt"
		value="${param['dateKt']}" />
</tags:js.pager>
<c:if test="${param.filter_EQS_status==1}"><c:set var="mail_title" value="已发邮件"/><c:set var="do_title" value="发送"/></c:if>
<c:if test="${param.filter_EQS_status==2}"><c:set var="mail_title" value="草稿箱邮件"/><c:set var="do_title" value="保存"/></c:if>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/daily/sendmail.action" method="post">
	<input type="hidden" name="filter_EQS_status"
		value="${param['filter_EQS_status']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							主题：
							<input type="text" name="filter_LIKES_title"
								value="${param['filter_LIKES_title']}" />
						</td>
						<td>
							${do_title}时间：
							<input type="text" name="dateKt" class="date" readonly="true" value="${param['dateKt']}"/>
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
						href="${ctx}/daily/sendmail!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_sendmail${param.filter_EQS_status}manage"
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
					<th width="180" orderField="title" class="orderFlag">
						主题
					</th>
					<th width="120">
						收件人
					</th>
					<th width="120" orderField="dateKt" class="orderFlag">
						${do_title}时间
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
							${a.title}
						</td>
						<td>
							<c:forEach var="t" items="${fn:split(a.receiveEmployeeIds,',')}"><tags:js.user.getValue property="userName" value="${t}"/>&nbsp;</c:forEach>
						</td>
						<td>
							<fmt:formatDate value="${a.dateKt}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
							<div style="width: 50px;">
								<a class="btnView"
									href="${ctx}/daily/sendmail!view.action?id=${a.id}"
									target="navTab" title="查看${mail_title}信息" rel="sendMail${param.filter_EQS_status}-view"></a>
								<a class="btnDel"
									href="${ctx}/daily/sendmail!delete.action?id=${a.id}&result4Json.navTabId=nav_sendmail${param.filter_EQS_status}manage"
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