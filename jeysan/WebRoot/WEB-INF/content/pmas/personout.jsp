<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/pmas/personout.action">
	<input type="hidden" name="filter_LIKES_person.nameh"
		value="${param['filter_LIKES_person.nameh']}" />
	<input type="hidden" name="filter_EQI_person.sex"
		value="${param['filter_EQI_person.sex']}" />
	<input type="hidden" name="filter_EQI_outCause"
		value="${param['filter_EQI_outCause']}" />
	<input type="hidden" name="filter_EQD_outDate"
		value="${param['filter_EQD_outDate']}" />
	<input type="hidden" name="filter_EQI_person.area"
		value="${param['filter_EQI_person.area']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/pmas/personout.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_person.nameh"
								value="${param['filter_LIKES_person.nameh']}" />
						</td>
						<td>
							性别：
							<tags:js.dict.selector noRender="true"
								name="filter_EQI_person.sex"
								value="${param['filter_EQI_person.sex']}" dictCode="JS010" />
						</td>
						<td>
							流出原因：
							<tags:js.dict.selector noRender="true" name="filter_EQI_outCause"
								value="${param['filter_EQI_outCause']}" dictCode="JS1042" />
						</td>
						<td>
							流出日期：
							<input name="filter_EQD_outDate" type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param['filter_EQD_outDate']}" />
						</td>
						<td>
							区域：
							<tags:js.area.selector name="filter_EQI_person.area" readonly="true" size="20"
								value="${param['filter_EQI_person.area']}"></tags:js.area.selector>
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
					<a class="add" href="${ctx}/pmas/personout!input.action"
						target="navTab" rel="personOut-input" title="添加人口流出"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/pmas/personout!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_personoutmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				
				<li>
					<a class="icon" href="javascript:JS_print2('流出人员基本信息')"><span>打印或导出</span>
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
					<th width="80" orderField="person.sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="outCause" class="orderFlag" htype="dict">
						流出原因
					</th>
					<th width="80" orderField="outType" class="orderFlag" htype="dict">
						流出类型
					</th>
					<th width="120" orderField="outAddressCode" class="orderFlag">
						流出地编码
					</th>
					<th width="80" orderField="outDate" class="orderFlag" htype="date">
						流出日期
					</th>
					<th width="80" hcode="person.cancelType" htype="dict">
						状态
					</th>
					<th width="80" align="center">
						操作
					</th>
					<th width="25" align="center">
						注销
					</th>
					<th width="50" align="center">
						恢复注销
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
							<tags:js.dict.getValue value="${a.person.sex}" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.outCause}" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.outType}" />
						</td>
						<td>
							${a.outAddressCode}
						</td>
						<td>
							<fmt:formatDate value="${a.outDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.person.cancelType}" />
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/pmas/personout!view.action?id=${a.id}"
									target="navTab" title="查看人口流出信息" rel="personOut-view"></a>
								<a class="btnEdit"
									href="${ctx}/pmas/personout!input.action?id=${a.id}"
									target="navTab" title="修改人口流出信息" rel="personOut-update"></a>
								<a class="btnDel"
									href="${ctx}/pmas/personout!delete.action?id=${a.id}&result4Json.navTabId=nav_personoutmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<c:if
									test="${a.person.cancelType==672||a.person.cancelType==673}">
									<a class="btnDel"
										href="${ctx}/pmas/personout!cancel.action?personId=${a.person.id}&type=0&result4Json.navTabId=nav_personoutmanage"
										target="ajaxTodo" title="确定要注销吗？"></a>
								</c:if>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<c:if test="${a.person.cancelType==154}">
									<a class="btnSelect"
										href="${ctx}/pmas/personout!cancel.action?personId=${a.person.id}&type=1&result4Json.navTabId=nav_personoutmanage"
										target="ajaxTodo" title="确定要恢复注销吗？"></a>
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