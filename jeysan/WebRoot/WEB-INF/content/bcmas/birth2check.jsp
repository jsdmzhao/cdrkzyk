<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/birth2check.action">
	<input type="hidden" name="filter_LIKES_fertileWoman.nameh"
		value="${param['filter_LIKES_fertileWoman.nameh']}" />
	<input type="hidden" name="filter_EQS_fertileWoman.code"
		value="${param['filter_EQS_fertileWoman.code']}" />
	<input type="hidden" name="filter_EQD_dateh"
		value="${param['filter_EQD_dateh']}" />
	<input type="hidden" name="filter_EQD_birth2Check.checkDate"
		value="${param['filter_EQD_birth2Check.checkDate']}" />
	<input type="hidden" name="filter_EQI_checkType"
		value="${param['filter_EQI_checkType']}" />
	<input type="hidden" name="filter_EQI_birth2Check.isAgree"
		value="${param['filter_EQI_birth2Check.isAgree']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/birth2check.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							妇女姓名：
							<input type="text" name="filter_LIKES_fertileWoman.nameh"
								value="${param['filter_LIKES_fertileWoman.nameh']}" />
						</td>
						<td>
							妇女编码：
							<input type="text" name="filter_EQS_fertileWoman.code"
								value="${param['filter_EQS_fertileWoman.code']}" />
						</td>
						<td>
							申请日期：
							<input type="text" name="filter_EQD_dateh" class="date"
								readonly="true" value="${param['filter_EQD_dateh']}" />
						</td>
					</tr><tr>
						<td>
							审批状态：
							<tags:js.dict.selector noRender="true" name="filter_EQI_checkType" value="${param['filter_EQI_checkType']}" dictCode="JS1064"/>
						</td>
						<td>
							审批日期：
							<input type="text" name="filter_EQD_birth2Check.checkDate" class="date"
								readonly="true" value="${param['filter_EQD_birth2Check.checkDate']}" />
						</td>
						<td>
							审批结果：
							<tags:js.dict.selector noRender="true" name="filter_EQI_birth2Check.isAgree" value="${param['filter_EQI_birth2Check.isAgree']}" dictCode="JS060"/>
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
					<th width="80" orderField="fertileWoman.nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="fertileWoman.code" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="dateh" class="orderFlag">
						申请日期
					</th>
					<th width="80" orderField="typeh" class="orderFlag">
						申请类型
					</th>
					<th width="80" orderField="checkType" class="orderFlag">
						审批状态
					</th>
					<th width="80" orderField="birth2Check.checkDate" class="orderFlag">
						审批日期
					</th>
					<th width="80" orderField="birth2Check.isAgree" class="orderFlag">
						审批结果
					</th>
					<th width="50" align="center">
						审批
					</th>
					<th width="50" align="center">
						查看
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
							${a.fertileWoman.nameh}
						</td>
						<td>
							${a.fertileWoman.code}
						</td>
						<td>
							<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.typeh}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.checkType}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.birth2Check.checkDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.birth2Check.isAgree}"/>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/birth2check!input.action?id=${a.id}"
									target="navTab" title="审批再生育申请" rel="birth2Check-update"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnView"
									href="${ctx}/bcmas/birth2check!view.action?id=${a.id}"
									target="navTab" title="查看详细信息" rel="birth2Check-view"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>