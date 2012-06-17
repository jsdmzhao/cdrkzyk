<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/bcscertcheck!list4view.action">
	<input type="hidden" name="filter_EQD_dateh"
		value="${param['filter_EQD_dateh']}" />
	<input type="hidden" name="filter_EQL_bcs.id"
		value="${param['filter_EQL_bcs.id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/bcscertcheck!list4view.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							发证机关：
							<input readonly="readonly" type="text" size="30" value="${bcs.issOrg}" />
						</td>
						<td>
							发证日期：
							<input readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${bcs.issDate}" pattern="yyyy-MM-dd" />" />
						</td>
						<td>
							证书编号：
							<input readonly="readonly" type="text" size="30" value="${bcs.certCode}" />
						</td>
						<td>
							经办人：
							<input readonly="readonly" type="text" size="30" value="${bcs.agent}" />
						</td>
					</tr>
					<tr>
						<td>
							查验日期：
							<input name="filter_EQD_dateh" value="${param.filter_EQD_dateh}" type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" />
						</td><td><input name="filter_EQL_bcs.id" type="hidden" value="${param['filter_EQL_bcs.id']}"/></td><td></td><td></td>
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
			</ul>
		</div>
		<table class="table" width="100%" layouth="164">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="200" orderField="content" class="orderFlag">
						查验内容
					</th>
					<th width="80" orderField="dateh" class="orderFlag">
						查验日期
					</th>
					<th width="80" orderField="agent" class="orderFlag">
						查验经办人
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td>
							${b.index+1}
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
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>