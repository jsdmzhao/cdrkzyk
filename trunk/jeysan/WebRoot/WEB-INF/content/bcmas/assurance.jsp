<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="hasAss" value="<%=com.jeysan.cpf.util.Constants.ASS_STATUS.YET_ASS%>"></c:set>
<c:set var="noAss" value="<%=com.jeysan.cpf.util.Constants.ASS_STATUS.NO_ASS%>"></c:set>
<tags:js.pager action="${ctx}/bcmas/assurance.action">
	<input type="hidden" name="filter_LIKES_nameh"
		value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQS_code"
		value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_LIKES_area"
		value="${param['filter_LIKES_area']}" />
	<input type="hidden" name="filter_EQI_assStatus"
		value="${param['filter_EQI_assStatus']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/assurance.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							妇女姓名：
							<input type="text" name="filter_LIKES_nameh"
								value="${param['filter_LIKES_nameh']}" />
						</td>
						<td>
							妇女编码：
							<input type="text" name="filter_EQS_code"
								value="${param['filter_EQS_code']}" />
						</td>
						<td>
							所属区域：
							<input type="text" name="filter_LIKES_area"
								value="${param['filter_LIKES_area']}" />
						</td>
						<td>
							投保情况：
							<tags:js.dict.selector noRender="true" name="filter_EQI_assStatus" value="${param['filter_EQI_assStatus']}" dictCode="JS1066"/>
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
						href="${ctx}/bcmas/assurance!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_assurancemanage"
						target="ajaxTodo" title="确定要清除保险信息吗?"><span>清除保险信息</span>
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
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="code" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="birthday" class="orderFlag">
						出生日期
					</th>
					<th width="80" orderField="spNameh" class="orderFlag">
						丈夫姓名
					</th>
					<th width="80" orderField="househodeKind" class="orderFlag">
						户口性质
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag">
						婚姻状况
					</th>
					<th width="80">
						子女数
					</th>
					<th width="80" orderField="method" class="orderFlag">
						避孕节育措施
					</th>
					<th width="80" orderField="assStatus" class="orderFlag">
						投保情况
					</th>
					<th width="80" align="center">
						登记/取消保险
					</th>
					<th width="80" align="center">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td height="25"><c:if test="${a.assStatus!=noAss}">
							<input type="checkbox" name="ids" value="${a.id}" /></c:if>
						</td>
						<td>
							${b.index+1}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							${a.code}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.spNameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.househodeKind}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"></tags:js.dict.getValue>
						</td>
						<td>
							${a.boyCount+a.girlCount}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.method}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.assStatus}"></tags:js.dict.getValue>
						</td>
						<td>
							<div style="width: 25px;">
							<c:if test="${a.assStatus==noAss}">
								<a class="btnEdit"
									href="${ctx}/bcmas/assurance!input.action?fertileWomanId=${a.id}&type=0"
									target="navTab" title="登记保险" rel="assurance-update"></a>
									</c:if>
							<c:if test="${a.assStatus==hasAss}">
								<a class="btnDel"
									href="${ctx}/bcmas/assurance!input.action?fertileWomanId=${a.id}&type=1"
									target="navTab" title="取消保险" rel="assurance-update"></a>
									</c:if>
							</div>
						</td>
						<td>
							<div style="width: 50px;">
								<a class="btnView"
									href="${ctx}/bcmas/assurance!view.action?fertileWomanId=${a.id}"
									target="navTab" title="查看保险保障信息" rel="assurance-view"></a>
								<c:if test="${a.assStatus!=noAss}">
								<a class="btnDel"
									href="${ctx}/bcmas/assurance!delete.action?fertileWomanId=${a.id}&result4Json.navTabId=nav_assurancemanage"
									target="ajaxTodo" title="确定要清除保险信息吗？"></a>
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