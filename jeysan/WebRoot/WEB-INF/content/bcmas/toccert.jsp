<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="normal" value="<%=com.jeysan.cpf.util.Constants.CERT_STATUS.NORMAL%>"></c:set>
<c:set var="cancel" value="<%=com.jeysan.cpf.util.Constants.CERT_STATUS.CANCEL%>"></c:set>
<tags:js.pager action="${ctx}/bcmas/toccert.action">
	<input type="hidden" name="filter_LIKES_person.nameh"
		value="${param['filter_LIKES_person.nameh']}" />
	<input type="hidden" name="filter_EQS_person.code"
		value="${param['filter_EQS_person.code']}" />
	<input type="hidden" name="filter_EQS_person.personCode"
		value="${param['filter_EQS_person.personCode']}" />
	<input type="hidden" name="filter_LIKES_children.nameh"
		value="${param['filter_LIKES_children.nameh']}" />
	<input type="hidden" name="filter_EQI_children.sex"
		value="${param['filter_EQI_children.sex']}" />
	<input type="hidden" name="filter_EQD_children.birthday"
		value="${param['filter_EQD_children.birthday']}" />
	<input type="hidden" name="filter_EQI_isCancel"
		value="${param['filter_EQI_isCancel']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/toccert.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							孩子姓名：
							<input type="text" name="filter_LIKES_children.nameh"
								value="${param['filter_LIKES_children.nameh']}" />
						</td>
						<td>
							孩子性别：
							<tags:js.dict.selector noRender="true" name="filter_EQS_children.sex" value="${param['filter_EQS_children.sex']}" dictCode="JS010"/>
						</td>
						<td>
							孩子出生日期：
							<input readonly="readonly" type="text" class="date" name="filter_EQD_children.birthday"
								value="${param['filter_EQD_children.birthday']}" />
						</td>
						<td>
							证书状态：
							<tags:js.dict.selector noRender="true" name="filter_EQI_isCancel" value="${param['filter_EQI_isCancel']}" dictCode="JS1068"/>
						</td>
					</tr>
					<tr>
						<td>
							家长姓名：
							<input type="text" name="filter_LIKES_person.nameh"
								value="${param['filter_LIKES_person.nameh']}" />
						</td>
						<td>
							家长编码：
							<input type="text" name="filter_EQS_person.personCode"
								value="${param['filter_EQS_person.personCode']}" />
						</td>
						<td>
							家长证件号码：
							<input type="text" name="filter_EQS_person.code"
								value="${param['filter_EQS_person.code']}" />
						</td><td></td>
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
					<a class="add" href="${ctx}/bcmas/toccert!input.action?type=0"
						target="navTab" rel="tocCert-input" title="添加独生子女光荣证"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/bcmas/toccert!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_toccertmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
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
					<th width="80" orderField="children.nameh" class="orderFlag">
						孩子姓名
					</th>
					<th width="120" orderField="children.sex" class="orderFlag">
						性别
					</th>
					<th width="120" orderField="children.birthday" class="orderFlag">
						出生日期
					</th>
					<th width="80" orderField="person.nameh" class="orderFlag">
						家长姓名
					</th>
					<th width="120" orderField="person.personCode" class="orderFlag">
						编码
					</th>
					<th width="120" orderField="person.code" class="orderFlag">
						证件号码
					</th>
					<th width="80" orderField="issDate" class="orderFlag">
						发证日期
					</th>
					<th width="80" orderField="certCode" class="orderFlag">
						证书编号
					</th>
					<th width="80" orderField="isCancel" class="orderFlag">
						证书状态
					</th>
					<th width="80" align="center">
						操作
					</th>
					<th width="60" align="center">
						查看证书
					</th>
					<th width="60" align="center">
						证书注销
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
							${a.children.nameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.children.sex}"></tags:js.dict.getValue>
						</td>
						<td>
							<fmt:formatDate value="${a.children.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.person.nameh}
						</td>
						<td>
							${a.person.personCode}
						</td>
						<td>
							${a.person.code}
						</td>
						<td>
							<fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.certCode}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.isCancel}"></tags:js.dict.getValue>
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/bcmas/toccert!view.action?id=${a.id}"
									target="navTab" title="查看独生子女光荣证信息" rel="tocCert-view"></a>
								<c:if test="${a.isCancel==normal}">
								<a class="btnEdit"
									href="${ctx}/bcmas/toccert!input.action?id=${a.id}&type=0"
									target="navTab" title="修改独生子女光荣证信息" rel="tocCert-update"></a>
								</c:if>
								<a class="btnDel"
									href="${ctx}/bcmas/toccert!delete.action?id=${a.id}&result4Json.navTabId=nav_toccertmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnLook"
									href="${ctx}/bcmas/toccert!view.action?id=${a.id}"
									target="dialog" title="查看独生子女光荣证书" rel="marryCert-view"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<c:if test="${a.isCancel==normal}">
								<a class="btnDel"
									href="${ctx}/bcmas/toccert!input.action?id=${a.id}&type=1"
									target="navTab" title="注销独生子女光荣证信息" rel="tocCert-update"></a>
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