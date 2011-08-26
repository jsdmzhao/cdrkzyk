<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/getiud!list2.action">
	<input type="hidden" name="filter_LIKES_nameh"
		value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQS_code"
		value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQI_recordType"
		value="${param['filter_EQI_recordType']}" />
	<input type="hidden" name="filter_EQI_giTypeh"
		value="${param['filter_EQI_giTypeh']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/getiud!list2.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							妇女姓名：
							<input type="text" name="filter_LIKES_nameh"
								value="${param.filter_LIKES_nameh}" />
						</td>
						<td>
							妇女编码：
							<input type="text" name="filter_EQS_code"
								value="${param.filter_EQS_code}" />
						</td>
						<td>
							户口类别：
							<tags:js.dict.selector noRender="true"
								name="filter_EQI_domicileType"
								value="${param['filter_EQI_domicileType']}" dictCode="JS1048" />
						</td>
						<td>
							确认状态：
							<tags:js.dict.selector noRender="true"
								name="filter_EQI_recordType"
								value="${param['filter_EQI_recordType']}" dictCode="JS1065" />
						</td>
						<td>
							取环类别：
							<tags:js.dict.selector noRender="true"
								name="filter_EQI_giTypeh"
								value="${param['filter_EQI_giTypeh']}" dictCode="JS1012" />
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
					<a class="edit"
						href="${ctx}/bcmas/getiud!confirm.action?ids={sid_xxx}&result4Json.navTabId=nav_getiudmanage2"
						target="ajaxTodo" title="确定所选名单吗?"><span>确定所选名单</span> </a>
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
						<input type="checkbox" class="checkboxCtrl" group="ids" title="全选"/>
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="120" orderField="code" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="age" class="orderFlag">
						年龄
					</th>
					<th width="80" orderField="domicileType" class="orderFlag">
						户口性质
					</th>
					<th width="120" orderField="certCode" class="orderFlag">
						身份证号
					</th>
					<th width="80">
						状态
					</th>
					<th width="120">
						已确认类别
					</th>
					<th width="120">
						取环类别
					</th>
					<th width="50" align="center">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td height="25"><c:if test="${a.recordType!=719}">
							<input type="checkbox" id="checkbox_${b.index}" name="ids" value="${a.id}_${a.giTypeh2}" /></c:if>
						</td>
						<td>
							${b.index+1}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							${a.code}
						</td>
						<td>
							${a.age}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.domicileType}" />
						</td>
						<td>
							${a.certCode}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.recordType}" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.giTypeh}" />
						</td>
						<td><c:if test="${a.recordType!=719}">
							<tags:js.dict.selector readOnly="${a.recordType==719}" value="${a.giTypeh2}" noRender="true" name="typeh_${b.index}"
								dictCode="JS1012" onChange="setValue(${b.index},${a.id},this.value)"/></c:if>
						</td>
						<td>
							<div style="width: 25px;"><c:if test="${a.recordType!=719}">
								<a class="btnEdit"
									href="${ctx}/bcmas/getiud!confirm.action?id=${a.id}&typeh={selector_typeh_${b.index}}&result4Json.navTabId=nav_getiudmanage2&hxhxhxhxhxhx"
									target="ajaxTodo" title="确定名单吗？"></a></c:if>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>
<script>
function setValue(index,id,value){
	var $box = navTab.getCurrentPanel();
	var $checkbox = $('#checkbox_'+index,$box);
	$checkbox.val(id+'_'+value);
}
</script>