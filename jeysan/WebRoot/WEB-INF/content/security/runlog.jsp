<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/runlog.action">
	<input type="hidden" name="filter_LIKES_bussClass"
		value="${param['filter_LIKES_bussClass']}" />
	<input type="hidden" name="filter_LIKES_bussMethod"
		value="${param['filter_LIKES_bussMethod']}" />
	<input type="hidden" name="filter_GEI_updateTime"
		value="${param['filter_GEI_updateTime']}" />
	<input type="hidden" name="filter_LEI_updateTime"
		value="${param['filter_LEI_updateTime']}" />
	<input type="hidden" name="filter_GEI_lastTime"
		value="${param['filter_GEI_lastTime']}" />
	<input type="hidden" name="filter_LEI_lastTime"
		value="${param['filter_LEI_lastTime']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/runlog.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							类：
							<input type="text" name="filter_LIKES_bussClass"
								value="${param['filter_LIKES_bussClass']}" />
						</td>
						<td>
							运行时间：
							<input type="text" class="Wdate" name="filter_GED_updateTime" value="${param['filter_GED_updateTime']}" 
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="true" />
							~
							<input type="text" class="Wdate" name="filter_LED_updateTime" value="${param['filter_LED_updateTime']}"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="true" />
						</td>
					</tr>
					<tr>
						<td>
							方法：
							<input type="text" name="filter_LIKES_bussMethod"
								value="${param['filter_LIKES_bussMethod']}" />
						</td>
						<td>
							持续时间(ms)：
							<input type="text" name="filter_GEI_lastTime" value="${param['filter_GEI_lastTime']}" />
							~
							<input type="text" name="filter_LEI_lastTime" value="${param['filter_LEI_lastTime']}" />
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
						href="${ctx}/security/runlog!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_runlogmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('${rule_title}系统运行日志列表')"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" title="全选" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="updateTime" class="orderFlag" htype="time">
						运行时间
					</th>
					<th width="150" orderField="bussClass" class="orderFlag">
						类
					</th>
					<th width="80" orderField="bussMethod" class="orderFlag">
						方法
					</th>
					<th width="80" orderField="lastTime" class="orderFlag" htype="digits">
						持续时间(ms)
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
							<fmt:formatDate value="${a.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
							${a.bussClass}
						</td>
						<td>
							${a.bussMethod}
						</td>
						<td>
							<c:if test="${a.lastTime<=20}"><font color="green">${a.lastTime}</font></c:if>
							<c:if test="${a.lastTime>20&&a.lastTime<=50}">${a.lastTime}</c:if>
							<c:if test="${a.lastTime>50}"><font color="red">${a.lastTime}</font></c:if>
						</td>
						<td>
							${a.remark}
						</td>
						<td>
							<div style="width: 25px;">
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