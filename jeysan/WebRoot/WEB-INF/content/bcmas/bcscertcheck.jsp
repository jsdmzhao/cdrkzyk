<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/bcscertcheck.action">
	<input type="hidden" name="filter_EQD_dateh"
		value="${param['filter_EQD_dateh']}" />
	<input type="hidden" name="filter_EQS_bcs.certCode"
		value="${param['filter_EQS_bcs.certCode']}" />
	<input type="hidden" name="filter_EQD_bcs.issDate"
		value="${param['filter_EQD_bcs.issDate']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/bcscertcheck.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							证书编号：
							<input name="filter_EQS_bcs.certCode" value="${param['filter_EQS_bcs.certCode']}" type="text" />
						</td>
						<td>
							发证日期：
							<input name="filter_EQD_bcs.issDate" value="${param.filter_EQD_bcs.issDate}" type="text" class="date" readonly="true" />
						</td>
						<td>
							查验日期：
							<input name="filter_EQD_dateh" value="${param.filter_EQD_dateh}" type="text" class="date" readonly="true" />
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
					<a class="add" href="${ctx}/bcmas/bcscertcheck!input.action"
						target="navTab" rel="bcsCertCheck-input" title="添加计划生育服务证查验"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/bcmas/bcscertcheck!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_bcscertcheckmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('计划生育服务证查验信息')"><span>打印或导出</span>
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
					<th width="80" orderField="bcs.certCode" class="orderFlag">
						证书编号
					</th>
					<th width="80" orderField="bcs.issDate" class="orderFlag" htype="date">
						发证日期
					</th>
					<th width="80" orderField="content" class="orderFlag">
						查验内容
					</th>
					<th width="80" orderField="dateh" class="orderFlag" htype="date">
						查验日期
					</th>
					<th width="80" orderField="agent" class="orderFlag">
						查验经办人
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
							${a.bcs.certCode}
						</td>
						<td>
							<fmt:formatDate value="${a.bcs.issDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.content}
						</td>
						<td>
							<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.agent}
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/bcmas/bcscertcheck!view.action?id=${a.id}"
									target="navTab" title="查看计划生育服务证查验信息" rel="bcsCertCheck-view"></a>
								<a class="btnEdit"
									href="${ctx}/bcmas/bcscertcheck!input.action?id=${a.id}"
									target="navTab" title="修改计划生育服务证查验信息" rel="bcsCertCheck-update"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/bcscertcheck!delete.action?id=${a.id}&result4Json.navTabId=nav_bcscertcheckmanage"
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