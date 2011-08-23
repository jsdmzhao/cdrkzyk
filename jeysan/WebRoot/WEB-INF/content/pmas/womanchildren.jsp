<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageHeader">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						${person.sex==1?'父亲':'母亲'}姓名：<input type="text" size="30" value="${person.nameh}"
							readonly="readonly" />
					</td>
					<td>
						人员编号：<input type="text" size="30" value="${person.personCode}"
							readonly="readonly" />
					</td>
					<td>
						出生日期：<input readonly="readonly" type="text" size="30"
							value="<fmt:formatDate value="${person.personBasic.birthday}" pattern="yyyy-MM-dd"/>" />
					</td></tr><tr>
					<td>
						${person.sex==1?'父亲':'母亲'}年龄：<input type="text" size="30" value="${person.age}"
							readonly="readonly" />
					</td>
					<td>
						证件类型：<input type="text" size="30" value="<tags:js.dict.getValue value="${person.certType}"/>"
							readonly="readonly" />
					</td>
					<td>
						证件号码：<input type="text" size="30" value="${person.code}"
							readonly="readonly" />
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li>
					<a class="add"
						href="${ctx}/pmas/womanchildren!input.action?personId=${param['personId']}"
						target="navTab" rel="womanChildren-input" title="添加子女"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/pmas/womanchildren!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_womanchildrenmanage"
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
		<table class="table" width="100%" layouth="${param.from=='person'?138:180}">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" >
						姓名
					</th>
					<th width="80" >
						性别
					</th>
					<th width="80" >
						出生日期
					</th>
					<th width="80" >
						出生地点
					</th>
					<th width="80" >
						政策内外
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
							<tags:js.dict.getValue value="${a.sex}"></tags:js.dict.getValue>
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.birthAddress}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.policy}"></tags:js.dict.getValue>
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/pmas/womanchildren!simplesub.action?id=${a.id}"
									target="navTab" title="查看子女信息" rel="womanChildren-view"></a>
								<a class="btnEdit"
									href="${ctx}/pmas/womanchildren!input.action?id=${a.id}"
									target="navTab" title="修改子女信息" rel="womanChildren-update"></a>
								<a class="btnDel"
									href="${ctx}/pmas/womanchildren!delete.action?id=${a.id}&result4Json.navTabId=nav_womanchildrenmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>