<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/daily/addresslist.action">
	<input type="hidden" name="filter_LIKES_nameh"
		value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQI_grouph"
		value="${param['filter_EQI_grouph']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/daily/addresslist.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_nameh"
								value="${param['filter_LIKES_nameh']}" />
						</td>
						<td>
							分组：
							<tags:js.dict.selector noRender="true" name="filter_EQI_grouph"
								value="${param['filter_EQI_grouph']}" dictCode="JS1080" />
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
					<a class="add" href="${ctx}/daily/addresslist!input.action"
						target="navTab" rel="addressList-input" title="添加通讯录"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/daily/addresslist!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_addresslistmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('我的通讯录')"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" title="全选" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="telPhone" class="orderFlag">
						固话
					</th>
					<th width="80" orderField="mobilePhone" class="orderFlag">
						移动电话
					</th>
					<th width="80" orderField="email" class="orderFlag">
						常用邮箱
					</th>
					<th width="80" orderField="company" class="orderFlag">
						单位
					</th>
					<th width="80" orderField="grouph" class="orderFlag" htype="dict">
						分组
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
							${a.nameh}
						</td>
						<td>
							${a.telPhone}
						</td>
						<td>
							${a.mobilePhone}
						</td>
						<td>
							${a.email}
						</td>
						<td>
							${a.company}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.grouph}"/>
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/daily/addresslist!view.action?id=${a.id}"
									target="navTab" title="查看通讯录信息"
									rel="addressList-view"></a>
								<a class="btnEdit"
									href="${ctx}/daily/addresslist!input.action?id=${a.id}"
									target="navTab" title="修改通讯录信息"
									rel="addressList-update"></a>
								<a class="btnDel"
									href="${ctx}/daily/addresslist!delete.action?id=${a.id}&result4Json.navTabId=nav_addresslistmanage"
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