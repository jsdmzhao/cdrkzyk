﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/dictsub.action">
	<input type="hidden" name="filter_EQI_id"
		value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/dictsub.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							主键：
							<input type="text" name="filter_EQI_id"
								value="${param['filter_EQI_id']}" />
						</td>
						<td>
							建档日期：
							<input type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" />
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
					<a class="add" href="${ctx}/security/dictsub!input.action"
						target="navTab" rel="dictSub-input" title="添加字典子项"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/security/dictsub!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_dictSubmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span> </a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:void(0);"><span>打印</span> </a>
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
					<th width="80">
						所属字典
					</th>
					<th width="80" orderField="subName" class="orderFlag">
						子项名称
					</th>
					<th width="80" orderField="subCode" class="orderFlag">
						子项编码
					</th>
					<th width="80">
						子项颜色
					</th>
					<th width="80">
						子项序号
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
							${a.dictId}
						</td>
						<td>
							${a.subName}
						</td>
						<td>
							${a.subCode}
						</td>
						<td>
							${a.subColor}
						</td>
						<td>
							${a.subIndex}
						</td>
						<td class="operate">
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/security/dictsub!view.action?id=${a.id}"
									target="navTab" title="查看字典子项信息" rel="dictSub-view"></a>
								<a class="btnEdit"
									href="${ctx}/security/dictsub!input.action?id=${a.id}"
									target="navTab" title="修改字典子项信息" rel="dictSub-update"></a>
								<a class="btnDel"
									href="${ctx}/security/dictsub!delete.action?id=${a.id}&result4Json.navTabId=nav_dictSubmanage"
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