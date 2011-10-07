<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/getiud.action">
	<input type="hidden" name="filter_LIKES_fertileWoman.nameh"
		value="${param['filter_LIKES_fertileWoman.nameh']}" />
	<input type="hidden" name="filter_EQS_fertileWoman.code"
		value="${param['filter_EQS_fertileWoman.code']}" />
	<input type="hidden" name="filter_EQD_dateh"
		value="${param['filter_EQD_dateh']}" />
	<input type="hidden" name="filter_EQI_typeh"
		value="${param['filter_EQI_typeh']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/getiud.action" method="post">
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
							取环时间：
							<input type="text" name="filter_EQD_dateh" class="date"
								readonly="true" value="${param['filter_EQD_dateh']}" />
						</td>
						<td>
							取环类别：
							<tags:js.dict.selector noRender="true" name="filter_EQI_typeh" value="${param['filter_EQI_typeh']}" dictCode="JS1012"/>
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
					<a class="delete"
						href="${ctx}/bcmas/getiud!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_getiudmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('取环结果登记基本信息')"><span>打印或导出</span>
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
					<th width="120" orderField="typeh" class="orderFlag" htype="dict">
						取环类型
					</th>
					<th width="80" orderField="dateh" class="orderFlag" htype="date">
						取环时间
					</th>
					<th width="120" orderField="hospital" class="orderFlag">
						手术医院
					</th>
					<th width="80" orderField="hospitalType" class="orderFlag" htype="dict">
						手术医院类型
					</th>
					<th width="50" align="center">
						登记
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
							<tags:js.dict.getValue value="${a.typeh}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.hospital}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.hospitalType}"/>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/getiud!input.action?id=${a.id}"
									target="navTab" title="修改取环信息" rel="getIud-update"></a>
							</div>
						</td>
						<td>
							<div style="width: 50px;">
								<a class="btnView"
									href="${ctx}/bcmas/getiud!view.action?id=${a.id}"
									target="navTab" title="查看取环信息" rel="getIud-view"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/getiud!delete.action?id=${a.id}&result4Json.navTabId=nav_getiudmanage"
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