<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/security/dict.action">
	<input type="hidden" name="filter_EQS_dictCode"
		value="${param['filter_EQS_dictCode']}" />
	<input type="hidden" name="filter_LIKES_dictName"
		value="${param['filter_LIKES_dictName']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/security/dict.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							编码：
							<input type="text" name="filter_EQS_dictCode"
								value="${param['filter_EQS_dictCode']}" />
						</td>
						<td>
							名称：
							<input type="text" name="filter_LIKES_dictName"
								value="${param['filter_LIKES_dictName']}" />
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
					<a class="add" href="${ctx}/security/dict!input.action"
						target="navTab" rel="dict-input" title="添加字典"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/security/dict!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_dictmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span> </a>
				</li>
				<li class="line">
					line
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
					<th width="80" orderField="dictName" class="orderFlag">
						字典名称
					</th>
					<th width="80" orderField="dictCode" class="orderFlag">
						字典编码
					</th>
					<th width="80">
						是否有效
					</th>
					<th width="80">
						字典描述
					</th>
					<th width="80">
						是否可以修改
					</th>
					<th width="80">
						是否末级
					</th>
					<th width="80">
						父类字典
					</th>
					<th width="80" align="center">
						操作
					</th>
					<th width="60" align="center">
						编辑子项
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
							${a.dictName}
						</td>
						<td>
							${a.dictCode}
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.dictStatus}" />
						</td>
						<td>
							${a.dictInfo}
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.canModified}" />
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.isLeaf}" />
						</td>
						<td>
							${a.parent.dictName}
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/security/dict!view.action?id=${a.id}"
									target="navTab" title="查看字典信息" rel="dict-view"></a>
								<a class="btnEdit"
									href="${ctx}/security/dict!input.action?id=${a.id}"
									target="navTab" title="修改字典信息" rel="dict-update"></a>
								<a class="btnDel"
									href="${ctx}/security/dict!delete.action?id=${a.id}&result4Json.navTabId=nav_dictmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/security/dict!preAddSubs.action?id=${a.id}"
									target="navTab" title="编辑字典子项" rel="dict-subs-update"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>