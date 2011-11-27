<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/deathreg.action">
	<input type="hidden" name="filter_LIKES_person.nameh"
		value="${param['filter_LIKES_person.nameh']}" />
	<input type="hidden" name="filter_EQS_person.code"
		value="${param['filter_EQS_person.code']}" />
	<input type="hidden" name="filter_EQD_dateh"
		value="${param['filter_EQD_dateh']}" />
	<input type="hidden" name="filter_EQI_person.sex"
		value="${param['filter_EQI_person.sex']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/deathreg.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_person.nameh"
								value="${param['filter_LIKES_person.nameh']}" />
						</td>
						<td>
							性别：
							<tags:js.dict.selector noRender="true" name="filter_EQI_person.sex" value="${param['filter_EQI_person.sex']}" dictCode="JS010"/>
						</td>
						<td>
							证件号码：
							<input type="text" name="filter_EQS_person.code"
								value="${param['filter_EQS_person.code']}" />
						</td>
						<td>
							死亡日期：
							<input type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" name="filter_EQD_dateh"
								value="${param['filter_EQD_dateh']}" />
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
					<a class="add" href="${ctx}/bcmas/deathreg!input.action"
						target="navTab" rel="deathReg-input" title="添加死亡登记"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/bcmas/deathreg!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_deathregmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('死亡登记基本信息')"><span>打印或导出</span>
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
					<th width="80" orderField="person.nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="person.sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="person.age" class="orderFlag" htype="digits">
						年龄
					</th>
					<th width="120" orderField="person.code" class="orderFlag">
						证件号码
					</th>
					<th width="80" orderField="dateh" class="orderFlag" htype="date">
						死亡日期
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						户主姓名
					</th>
					<th width="80" orderField="relation" class="orderFlag" htype="dict">
						与户主关系
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
							${a.person.nameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.person.sex}"></tags:js.dict.getValue>
						</td>
						<td>
							${a.person.age}
						</td>
						<td>
							${a.person.code}
						</td>
						<td>
							<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.relation}"></tags:js.dict.getValue>
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/bcmas/deathreg!view.action?id=${a.id}"
									target="navTab" title="查看死亡登记信息" rel="deathReg-view"></a>
								<a class="btnEdit"
									href="${ctx}/bcmas/deathreg!input.action?id=${a.id}"
									target="navTab" title="修改死亡登记信息" rel="deathReg-update"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/deathreg!delete.action?id=${a.id}&result4Json.navTabId=nav_deathregmanage"
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