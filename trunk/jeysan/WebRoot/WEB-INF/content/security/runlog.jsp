<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/runlog.action">
	<input type="hidden" name="filter_EQI_id"
		value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/runlog.action" method="post">
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
					<a class="add" href="${ctx}/security/runlog!input.action"
						target="navTab" rel="runLog-input" title="添加运行日志"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/security/runlog!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_runlogmanage"
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
						<input type="checkbox" class="checkboxCtrl" group="ids" title="全选" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="updateTime" class="orderFlag">
						更新时间
					</th>
					<th width="80" orderField="bussName" class="orderFlag">
						业务名称
					</th>
					<th width="80" orderField="bussClass" class="orderFlag">
						类
					</th>
					<th width="80" orderField="bussMethod" class="orderFlag">
						方法
					</th>
					<th width="80" orderField="lastTime" class="orderFlag">
						持续时间
					</th>
					<th width="80" orderField="remark" class="orderFlag">
						备注
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
							<fmt:formatDate value="${a.updateTime}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.bussName}
						</td>
						<td>
							${a.bussClass}
						</td>
						<td>
							${a.bussMethod}
						</td>
						<td>
							${a.lastTime}
						</td>
						<td>
							${a.remark}
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/security/runlog!view.action?id=${a.id}"
									target="navTab" title="查看运行日志信息" rel="runLog-view"></a>
								<a class="btnEdit"
									href="${ctx}/security/runlog!input.action?id=${a.id}"
									target="navTab" title="修改运行日志信息" rel="runLog-update"></a>
								<a class="btnDel"
									href="${ctx}/security/runlog!delete.action?id=${a.id}&result4Json.navTabId=nav_runlogmanage"
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