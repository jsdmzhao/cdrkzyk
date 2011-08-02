<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager
	action="${ctx}/workflow/workitem!list.action?type=${type}">
	<input type="hidden" name="filter_EQS_id"
		value="${param['filter_EQS_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/daily/leave.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							主键：
							<input type="text" name="filter_EQS_id"
								value="${param['filter_EQS_id']}" />
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
						序号
					</th>
					<th width="160">
						任务名称
					</th>
					<th width="160" orderField="taskInstance.createdTime" class="orderFlag">
						提交时间
					</th>
					<th width="80">
						流程状态
					</th>
					<c:if test="${type==1}">
						<th width="25" align="center">
							查看
						</th>
					</c:if>
					<c:if test="${type==0}">
						<th width="25" align="center">
							签收
						</th>
						<th width="25" align="center">
							处理
						</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td>
							${b.index+1}
						</td>
						<td>
							${a.taskInstance.displayName}
						</td>
						<td>
							<fmt:formatDate value="${a.taskInstance.createdTime}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
							<c:if test="${type==0}">
								<tags:js.wf.state.getValue type="0" value="${a.state}"></tags:js.wf.state.getValue>
							</c:if>
							<c:if test="${type==1}">
								<tags:js.wi.state.getValue type="2" wi="${a}"></tags:js.wi.state.getValue>
							</c:if>
						</td>
						<c:if test="${type==1}">
							<td>
								<div style="width: 25px;">
									<a class="btnView"
										href="${ctx}/workflow/workitem!openform.action?type=0&wiid=${a.id}"
										target="navTab" title="查看流程" rel="workitem-view"></a>
								</div>
							</td>
						</c:if>
						<c:if test="${type==0}">
							<td>
								<c:if test="${a.state==0}">
									<div style="width: 25px;">
										<a class="btnSelect"
											href="${ctx}/workflow/workitem!claim.action?wiid=${a.id}&result4Json.navTabId=nav_workitemmanage"
											target="ajaxTodo" title="签收流程"></a>
									</div>
								</c:if>
							</td>
							<td>
								<c:if test="${a.state==1}">
									<div style="width: 25px;">
										<a class="btnEdit"
											href="${ctx}/workflow/workitem!openform.action?type=1&wiid=${a.id}"
											target="navTab" title="处理流程" rel="workitem-update"></a>
									</div>
								</c:if>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>