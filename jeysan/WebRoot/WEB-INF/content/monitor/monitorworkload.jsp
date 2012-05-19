<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/monitor/monitorworkload.action">
	<input type="hidden" name="filter_LIKES_remark"
		value="${param['filter_LIKES_remark']}" />
	<input type="hidden" name="filter_EQI_operator"
		value="${param['filter_EQI_operator']}" />
	<input type="hidden" name="filter_GED_operatTime"
		value="${param['filter_GED_operatTime']}" />
	<input type="hidden" name="filter_LED_operatTime"
		value="${param['filter_LED_operatTime']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/monitor/monitorworkload.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							操作人：
							<select name="filter_EQI_operator">
								<option value="">
									全部
								</option>
								<c:forEach var="a" items="${users}">
									<option value="${a.id}"
										<c:if test="${a.id==param['filter_EQI_operator']}"> selected="selected"</c:if>>
										[${a.userCode}]${a.userName}
									</option>
								</c:forEach>
							</select>
						</td>
						<td>
							操作时间：
							<input type="text" class="Wdate" name="filter_GED_operatTime"
								value="${param['filter_GED_operatTime']}"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								readonly="true" />
							~
							<input type="text" class="Wdate" name="filter_LED_operatTime"
								value="${param['filter_LED_operatTime']}"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								readonly="true" />
						</td>
						<td>
							备注：
							<input type="text" name="filter_LIKES_remark"
								value="${param['filter_LIKES_remark']}" />
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
						href="${ctx}/monitor/monitorworkload!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_monitorworkloadmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon"
						href="javascript:JS_print2('${rule_title}用户操作日志列表')"><span>打印或导出</span>
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
					<th width="130" orderField="operatTime" class="orderFlag" htype="time">
						操作时间
					</th>
					<th width="120" orderField="operator" class="orderFlag" htype="user">
						操作人
					</th>
					<th width="80" orderField="operatIp" class="orderFlag">
						操作人IP
					</th>
					<th width="80" orderField="workType" class="orderFlag" htype="dict">
						工作类别
					</th>
					<th width="80" orderField="workLoad" class="orderFlag" htype="digits">
						工作量
					</th>
					<th width="80" orderField="operatType" class="orderFlag" htype="dict">
						操作类型
					</th>
					<th width="150" orderField="remark" class="orderFlag">
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
							<fmt:formatDate value="${a.operatTime}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
							<tags:js.user.getValue property="userName" value="${a.operator}"/>
						</td>
						<td>
							${a.operatIp}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.workType}"></tags:js.dict.getValue>
						</td>
						<td>
							${a.workLoad}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.operatType}"></tags:js.dict.getValue>
						</td>
						<td>
							${a.remark}
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnDel"
									href="${ctx}/monitor/monitorworkload!delete.action?id=${a.id}&result4Json.navTabId=nav_monitorworkloadmanage"
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