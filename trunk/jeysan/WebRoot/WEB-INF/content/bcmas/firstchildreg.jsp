<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/firstchildreg.action">
	<input type="hidden" name="filter_LIKES_fertileWoman.nameh"
		value="${param['filter_LIKES_fertileWoman.nameh']}" />
	<input type="hidden" name="filter_EQS_fertileWoman.code"
		value="${param['filter_EQS_fertileWoman.code']}" />
	<input type="hidden" name="filter_EQD_dateh"
		value="${param['filter_EQD_dateh']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/firstchildreg.action" method="post">
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
							登记日期：
							<input type="text" name="filter_EQD_dateh" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param['filter_EQD_dateh']}" />
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
					<a class="add" href="${ctx}/bcmas/firstchildreg!input.action"
						target="navTab" rel="firstChildReg-input" title="添加一孩登记"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/bcmas/firstchildreg!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_firstchildregmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('一孩登记基本信息')"><span>打印或导出</span>
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
					<th width="80" orderField="dateh" class="orderFlag" htype="date">
						登记日期
					</th>
					<th width="80" orderField="isSecond" class="orderFlag" htype="bool">
						是否再生一孩
					</th>
					<th width="80" orderField="deptOpt" class="orderFlag">
						部门意见
					</th>
					<th width="80" orderField="agent" class="orderFlag">
						经办人
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
							${a.fertileWoman.nameh}
						</td>
						<td>
							${a.fertileWoman.code}
						</td>
						<td>
							<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.isSecond}"></tags:js.yes.no.getValue>
						</td>
						<td>
							${a.deptOpt}
						</td>
						<td>
							${a.agent}
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/bcmas/firstchildreg!view.action?id=${a.id}"
									target="navTab" title="查看一孩登记信息" rel="firstChildReg-view"></a>
								<a class="btnEdit"
									href="${ctx}/bcmas/firstchildreg!input.action?id=${a.id}"
									target="navTab" title="修改一孩登记信息" rel="firstChildReg-update"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/firstchildreg!delete.action?id=${a.id}&result4Json.navTabId=nav_firstchildregmanage"
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