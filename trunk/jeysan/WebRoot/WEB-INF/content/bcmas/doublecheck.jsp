<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/doublecheck.action">
	<input type="hidden" name="filter_EQS_code"
		value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_LIKES_nameh"
		value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQI_dcTypeh"
		value="${param['filter_EQI_dcTypeh']}" />
	<input type="hidden" name="filter_EQI_househodeKind"
		value="${param['filter_EQI_househodeKind']}" />
	<input type="hidden" name="filter_EQI_job"
		value="${param['filter_EQI_job']}" />
	<input type="hidden" name="filter_EQI_method"
		value="${param['filter_EQI_method']}" />
	<input type="hidden" name="filter_LIKES_houseNo"
		value="${param['filter_LIKES_houseNo']}" />
	<input type="hidden" name="filter_EQI_marryStatus"
		value="${param['filter_EQI_marryStatus']}" />
	<input type="hidden" name="filter_EQS_area"
		value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQL_dcId"
		value="${param['filter_EQL_dcId']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/doublecheck.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							编码：
							<input type="text" name="filter_EQS_code" value="${param['filter_EQS_code']}" />
						</td>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}" />
						</td>
						<td>
							门牌号码：
							<input type="text" name="filter_LIKES_houseNo" value="${param['filter_LIKES_houseNo']}" />
						</td>
						<td>
							地区：
							<input type="text" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
						</td>
						<td>
							轮次：
<select style="width:100px" name="filter_EQL_dcId">
	<option value="">请选择</option>
	<c:forEach var="a" items="${dcs}">
	<option value="${a.id}" <c:if test="${a.id==param.filter_EQL_dcId}">selected="selected"</c:if>>${a.year}</option>
	</c:forEach>
</select>
						</td>
					</tr>
					<tr>
						<td>
							查环查孕类型：
							<tags:js.dict.selector noRender="true" name="filter_EQI_dcTypeh" value="${param['filter_EQI_dcTypeh']}" dictCode="JS1016"/>
						</td>
						<td>
							户口性质：
							<tags:js.dict.selector noRender="true" name="filter_EQI_househodeKind" value="${param['filter_EQI_househodeKind']}" dictCode="JS1014"/>
						</td>
						<td>
							职业类型：
							<tags:js.dict.selector noRender="true" name="filter_EQI_job" value="${param['filter_EQI_job']}" dictCode="JS1017"/>
						</td>
						<td>
							节育措施：
							<tags:js.dict.selector noRender="true" name="filter_EQI_method" value="${param['filter_EQI_method']}" dictCode="JS1018"/>
						</td>
						<td>
							婚姻状况：
							<tags:js.dict.selector noRender="true" name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" dictCode="JS1015"/>
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
					<a class="edit"
						href="${ctx}/bcmas/doublecheck!delete.action?ids={sid_xxx}&type=0&result4Json.navTabId=nav_doublecheckmanage"
						target="ajaxTodo" title="确定所选不查吗?"><span>所选不查</span>
					</a>
				</li>
				<li>
					<a class="edit"
						href="${ctx}/bcmas/doublecheck!delete.action?ids={sid_xxx}&type=1&result4Json.navTabId=nav_doublecheckmanage"
						target="ajaxTodo" title="确定所选免查吗?"><span>所选免查</span>
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
		<table class="table" width="100%" layouth="164">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="code" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="age" class="orderFlag">
						年龄
					</th>
					<th width="80" orderField="job" class="orderFlag">
						职业类型
					</th>
					<th width="80" orderField="househodeKind" class="orderFlag">
						户口性质
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag">
						婚姻状况
					</th>
					<th width="80" orderField="dcTypeh" class="orderFlag">
						查环查孕类型
					</th>
					<th width="120" orderField="dcId" class="orderFlag">
						轮次~起始
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
							${a.code}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							${a.age}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.job}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.househodeKind}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.dcTypeh}"></tags:js.dict.getValue>
						</td>
						<td>
							[${a.year}]~${a.start}
						</td>
						<td>
							<div style="width: 50px;">
								<a class="btnView"
									href="${ctx}/bcmas/doublecheck!view.action?id=${a.id}"
									target="navTab" title="查看双查轮次信息" rel="doubleCheck-view"></a>
								<a class="btnEdit"
									href="${ctx}/bcmas/doublecheck!input.action?id=${a.id}"
									target="navTab" title="修改双查轮次信息" rel="doubleCheck-update"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>