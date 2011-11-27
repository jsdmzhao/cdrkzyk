<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:if test="${param.filter_EQI_typeh==0}"><c:set var="rule_title" value="规章制度"/></c:if>
<c:if test="${param.filter_EQI_typeh==1}"><c:set var="rule_title" value="法律法规"/></c:if>
<c:if test="${param.filter_EQI_typeh==2}"><c:set var="rule_title" value="通知通报"/></c:if>
<tags:js.pager action="${ctx}/daily/rule.action">
	<input type="hidden" name="filter_LIKES_title"
		value="${param['filter_LIKES_title']}" />
	<input type="hidden" name="filter_GED_dateKt"
		value="${param['filter_GED_dateKt']}" />
	<input type="hidden" name="filter_LED_dateKt"
		value="${param['filter_LED_dateKt']}" />
	<input type="hidden" name="filter_EQS_levelKt"
		value="${param['filter_EQS_levelKt']}" />

	<input type="hidden" name="filter_EQI_typeh"
		value="${param['filter_EQI_typeh']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/daily/rule.action" method="post">
	<input type="hidden" name="filter_EQI_typeh"
		value="${param['filter_EQI_typeh']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							${rule_title}名称：
							<input type="text" name="filter_LIKES_title"
								value="${param['filter_LIKES_title']}" />
						</td>
						<td>
							${rule_title}级别：
							<tags:js.dict.selector noRender="true" name="filter_EQS_levelKt"
								value="${param['filter_EQS_levelKt']}" dictCode="JS1079" />
						</td>
						<td>
							发布日期：
							<input type="text" name="filter_GED_dateKt" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param.filter_GED_dateKt}" />
							~
							<input type="text" name="filter_LED_dateKt" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param.filter_LED_dateKt}" />
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
					<a class="add" href="${ctx}/daily/rule!input.action?filter_EQI_typeh=${param.filter_EQI_typeh}"
						target="navTab" rel="rule${param.filter_EQI_typeh}-input" title="添加${rule_title}"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/daily/rule!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_rule${param.filter_EQI_typeh}manage&filter_EQI_typeh=${param.filter_EQI_typeh}"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('${rule_title}列表信息')"><span>打印或导出</span>
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
					<th width="120" orderField="title" class="orderFlag">
						${rule_title}名称
					</th>
					<th width="80" orderField="levelKt" class="orderFlag" htype="dict">
						${rule_title}级别
					</th>
					<th width="80" orderField="sendEmployeeId" class="orderFlag" htype="user">
						发布人
					</th>
					<th width="80" orderField="dateKt" class="orderFlag" htype="date">
						发布时间
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
							<tags:js.dict.getValue value="${a.levelKt}"/>
						</td>
						<td>
							<tags:js.user.getValue property="userName" value="${a.sendEmployeeId}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.dateKt}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/daily/rule!view.action?id=${a.id}" target="navTab"
									title="查看${rule_title}信息" rel="rule${param.filter_EQI_typeh}-view"></a>
								<a class="btnEdit"
									href="${ctx}/daily/rule!input.action?id=${a.id}&filter_EQI_typeh=${param.filter_EQI_typeh}"
									target="navTab" title="修改${rule_title}信息" rel="rule${param.filter_EQI_typeh}-update"></a>
								<a class="btnDel"
									href="${ctx}/daily/rule!delete.action?id=${a.id}&result4Json.navTabId=nav_rule${param.filter_EQI_typeh}manage&filter_EQI_typeh=${param.filter_EQI_typeh}"
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