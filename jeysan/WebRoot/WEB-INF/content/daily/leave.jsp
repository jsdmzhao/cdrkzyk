<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/daily/leave.action">
	<input type="hidden" name="filter_EQI_id"
		value="${param['filter_EQI_id']}" />
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
								rel="dlg_page1" title="查询框"><span>高级检索</span>
							</a>
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
					<a class="add" href="${ctx}/daily/leave!input.action"
						target="navTab" rel="leave-input" title="填写请假单"><span>填写请假单</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/daily/leave!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_leavemanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除请假单</span>
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
					<th width="120" orderField="leaveNo" class="orderFlag">
						编号
					</th>
					<th width="160" orderField="dateKt" class="orderFlag">
						申请时间
					</th>
					<th width="80">
						请假事由
					</th>
					<th width="80">
						请假开始日期
					</th>
					<th width="80">
						请假结束日期
					</th>
					<th width="80">
						流程状态
					</th>
					<th width="105" align="center">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td>
							<c:if test="${a.wfState==99}">
								<input type="checkbox" name="ids" value="${a.id}" />
							</c:if>
						</td>
						<td>
							${b.index+1}
						</td>
						<td>
							${a.leaveNo}
						</td>
						<td>
							<fmt:formatDate value="${a.dateKt}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.leaveCause}"></tags:js.dict.getValue>
						</td>
						<td>
							<fmt:formatDate value="${a.leaveStart}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.leaveEnd}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.wf.state.getValue value="${a.wfState}" type="2"></tags:js.wf.state.getValue>
						</td>
						<td class="operate">
							<div style="width: 100px;">
								<a class="btnView"
									href="${ctx}/daily/leave!view.action?id=${a.id}"
									target="navTab" title="查看信息" rel="leave-view"></a>
								<c:if test="${a.wfState==99}">
									<a class="btnEdit"
										href="${ctx}/daily/leave!input.action?id=${a.id}"
										target="navTab" title="修改请假单信息" rel="leave-update"></a>
								</c:if>
								<c:if test="${a.wfState==99}">
									<a class="btnDel"
										href="${ctx}/daily/leave!delete.action?id=${a.id}&result4Json.navTabId=nav_leavemanage"
										target="ajaxTodo" title="确定要删除吗？"></a>
								</c:if>
								<c:if test="${a.wfState==99}">
									<a class="btnSelect"
										href="${ctx}/daily/leave!submitWF.action?id=${a.id}&result4Json.navTabId=nav_leavemanage"
										target="ajaxTodo" title="确定要提交申请吗？提交后，请假单将不可以修改，并且申请不可撤销"></a>
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