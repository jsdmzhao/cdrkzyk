<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/bcscert!list4lookup.action">
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
		<form onsubmit="return dwzSearch(this, 'dialog');"
			action="${ctx}/bcmas/bcscert!list4lookup.action" method="post">
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
						</td></tr><tr>
						<td>
							证书编号：
							<input type="text" name="filter_EQS_certCode"
								value="${param['filter_EQS_certCode']}" />
						</td>
						<td>
							证书状态：
							<tags:js.dict.selector noRender="true" name="filter_EQI_certType" value="${param['filter_EQI_certType']}" dictCode="JS1069"/>
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
		<table class="table" targettype="dialog" width="100%" layouth="164">
			<thead>
				<tr>
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
					<th width="80" orderField="issDate" class="orderFlag">
						发证日期
					</th>
					<th width="80" orderField="certCode" class="orderFlag">
						证书编号
					</th>
					<th width="80" orderField="certType" class="orderFlag">
						证书状态
					</th>
					<th width="80" align="center">
						操作
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
							<div style="width: 30px;">
								<a class="btnSelect"
									href="javascript:$.bringBack({bcsId:'${a.id}', nameh:'${a.fertileWoman.nameh}', code:'${a.fertileWoman.code}', issOrg:'${a.issOrg}', issDate:'<fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd"/>', issOrgAddress:'${a.issOrgAddress}', certCode:'${a.certCode}',zipCode:'${a.zipCode}',tel:'${a.tel}',agent:'${a.agent}',photo:'${a.photo}'})"
									title="确定带回">选择</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot4dwz.jsp"%>
	</div>
</div>