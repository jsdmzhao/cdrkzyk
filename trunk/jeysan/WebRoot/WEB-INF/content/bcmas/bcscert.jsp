<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="normal" value="<%=com.jeysan.cpf.util.Constants.CERT_TYPE.NORMAL%>"></c:set>
<c:set var="changed" value="<%=com.jeysan.cpf.util.Constants.CERT_TYPE.CHANGED%>"></c:set>
<c:set var="cancel" value="<%=com.jeysan.cpf.util.Constants.CERT_TYPE.CANCEL%>"></c:set>
<tags:js.pager action="${ctx}/bcmas/bcscert.action">
	<input type="hidden" name="filter_LIKES_fertileWoman.nameh"
		value="${param['filter_LIKES_fertileWoman.nameh']}" />
	<input type="hidden" name="filter_EQS_fertileWoman.code"
		value="${param['filter_EQS_fertileWoman.code']}" />
	<input type="hidden" name="filter_EQI_certType"
		value="${param['filter_EQI_certType']}" />
	<input type="hidden" name="filter_EQD_issDate"
		value="${param['filter_EQD_issDate']}" />
	<input type="hidden" name="filter_EQS_certCode"
		value="${param['filter_EQS_certCode']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/bcscert.action" method="post">
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
							发证日期：
							<input class="date" readonly="readonly" type="text" name="filter_EQD_issDate"
								value="${param['filter_EQD_issDate']}" />
						</td>
						<td>
							证书编号：
							<input type="text" name="filter_EQS_certCode"
								value="${param['filter_EQS_certCode']}" />
						</td>
						<td>
							证书状态：
							<tags:js.dict.selector noRender="true" name="filter_EQI_certType" value="${param['filter_EQI_certType']}" dictCode="JS1069"/>
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
					<a class="add" href="${ctx}/bcmas/bcscert!input.action"
						target="navTab" rel="bcsCert-input" title="添加计划生育服务证"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/bcmas/bcscert!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_bcscertmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('计划生育服务证基本信息')"><span>打印或导出</span>
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
					<th width="80" orderField="fertileWoman.nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="fertileWoman.code" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="issOrg" class="orderFlag">
						发证机关
					</th>
					<th width="80" orderField="issDate" class="orderFlag" htype="date">
						发证日期
					</th>
					<th width="80" orderField="certCode" class="orderFlag">
						证书编号
					</th>
					<th width="80" orderField="certType" class="orderFlag" htype="dict">
						证书状态
					</th>
					<th width="80" align="center">
						操作
					</th>
					<th width="40" align="center">
						变更
					</th>
					<th width="40" align="center">
						废止
					</th>
					<th width="60" align="center">
						查验
					</th>
					<th width="40" align="center">
						查看证书
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
							${a.issOrg}
						</td>
						<td>
							<fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.certCode}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.certType}"></tags:js.dict.getValue>
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/bcmas/bcscert!view.action?id=${a.id}"
									target="navTab" title="查看计划生育服务证信息" rel="bcsCert-view"></a>
<c:if test="${a.certType==normal}">
								<a class="btnEdit"
									href="${ctx}/bcmas/bcscert!input.action?id=${a.id}"
									target="navTab" title="修改计划生育服务证信息" rel="bcsCert-update"></a>
</c:if>
								<a class="btnDel"
									href="${ctx}/bcmas/bcscert!delete.action?id=${a.id}&result4Json.navTabId=nav_bcscertmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
						<td><c:if test="${a.certType==normal}">
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/bcscert!input.action?id=${a.id}&type=0"
									target="navTab" title="证书变更" rel="bcsCert-update"></a>
							</div></c:if>
						</td>
						<td><c:if test="${a.certType==normal||a.certType==changed}">
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/bcscert!input.action?id=${a.id}&type=1"
									target="navTab" title="证书废止" rel="bcsCert-update"></a>
							</div></c:if>
						</td>
						<td>
							<div style="width: 50px;">
								<a class="btnView"
									href="${ctx}/bcmas/bcscertcheck!list4view.action?filter_EQL_bcs.id=${a.id}"
									target="navTab" title="查看证书查验记录" rel="bcsCert-view"></a>
								<a class="btnEdit"
									href="${ctx}/bcmas/bcscert!input.action?id=${a.id}&type=2"
									target="navTab" title="新增查验记录" rel="bcsCert-update"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnLook"
									href="${ctx}/bcmas/bcscert!input.action?id=${a.id}"
									target="dialog" title="查看计生服务证书" rel="bcsCert-update"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>