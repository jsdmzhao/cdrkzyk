<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	request.setAttribute("filter", java.util.Arrays.asList(672, 673));
%>
<tags:js.pager action="${ctx}/pmas/person!historydestroy.action">
	<input type="hidden" name="nameh" value="${param.nameh}" />
	<input type="hidden" name="code" value="${param.code}" />
	<input type="hidden" name="personCode" value="${param.personCode}" />
	<input type="hidden" name="sex" value="${param.sex}" />
	<input type="hidden" name="kind" value="${param.kind}" />
	<input type="hidden" name="cancelType" value="${param.cancelType}" />
	<input type="hidden" name="area" value="${param.area}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/pmas/person!historydestroy.action" method="post">
			<div class="searchBar">

				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="nameh" value="${param.nameh}" />
						</td>
						<td>
							性别：
							<tags:js.dict.selector noRender="true" name="sex"
								value="${param.sex}" dictCode="JS010" />
						</td>
						<td>
							人员类别：
							<tags:js.dict.selector noRender="true" name="kind"
								value="${param.kind}" dictCode="JS1050" />
						</td>
						<td>
							区域：
							<tags:js.area.selector name="area" readonly="true"
								value="${param.area}" size="20"></tags:js.area.selector>
						</td>
					</tr>
					<tr>
						<td>
							人员编号：
							<input type="text" name="personCode" value="${param.personCode}" />
						</td>
						<td>
							证件号码：
							<input type="text" name="code" value="${param.code}" />
						</td>
						<td>
							注销状态：
							<tags:js.dict.selector noRender="true" name="cancelType"
								value="${param.cancelType}" dictCode="JS1010" filter="${filter}" />
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
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:void(0);"><span>打印</span> </a>
				</li>
				<li>
					<a class="icon" href="doc/dwz-team.xls" target="dwzExport"
						targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span> </a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="163">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="60" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="sex" class="orderFlag">
						性别
					</th>
					<th width="80" orderField="certType" class="orderFlag">
						证件类型
					</th>
					<th width="120" orderField="code" class="orderFlag">
						证件号码
					</th>
					<th width="120" orderField="personCode" class="orderFlag">
						人员编号
					</th>
					<th width="80" orderField="cancelType" class="orderFlag">
						注销状态
					</th>
					<th width="80" orderField="domicileType" class="orderFlag">
						户口类别
					</th>
					<th width="80" orderField="kind" class="orderFlag">
						人员类别
					</th>
					<th width="40" align="center">
						查看
					</th>
					<th width="40" align="center">
						销毁
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
							${a.nameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.sex}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.certType}"></tags:js.dict.getValue>
						</td>
						<td>
							${a.code}
						</td>
						<td>
							${a.personCode}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.cancelType}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.domicileType}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.kind}"></tags:js.dict.getValue>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnView"
									href="${ctx}/pmas/person!view.action?id=${a.id}"
									target="navTab" title="查看人员信息" rel="person-view"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnDel"
									href="${ctx}/pmas/person!destoryDo.action?id=${a.id}"
									target="navTab" title="确定要销毁人员历史数据" rel="person-update"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>