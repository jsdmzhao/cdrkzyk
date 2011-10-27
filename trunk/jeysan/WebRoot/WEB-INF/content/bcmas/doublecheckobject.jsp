<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/doublecheckobject.action">
	<input type="hidden" name="filter_EQI_id"
		value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/doublecheckobject.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							年度：
							<select name="year">
								<option value="">选择年度</option>
								<c:forEach begin="1931" end="2030" var="a">
								<option value="${a}">${a}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							轮次：
							<select name="seq">
								<option value="">选择轮次</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</td>
						<td>
							<input type="radio" name="status" value="0" id="status0" checked="checked">
							未确定
							<input type="radio" name="status" value="1" id="status1">
							已确定
						</td>
						<td id="td_dcObjType">
							双查对象类型：
							<tags:js.dict.selector noRender="true" name="dcObjType" dictCode="JS1013"/>
						</td>
						<td id="td_typeh" style="display:none">
							双查类型：
							<select name="typeh">
								<option value="">请选择</option>
								<option value="186" >不查</option>
								<option value="-1" >应查</option>
								<option value="191" >免查</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							起始年月：
							<input type="input" id="start" value="2011-10" readonly="readonly">
						</td>
						<td>
							终止年月：
							<input type="input" id="end" value="2011-12" readonly="readonly">
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
					<a class="add" href="${ctx}/bcmas/doublecheckobject!input.action"
						target="navTab" rel="doubleCheckObject-input"
						title="添加fhp_double_check_object"><span>添加</span>
					</a>
				</li>
				<li>
					<a class="delete"
						href="${ctx}/bcmas/doublecheckobject!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_doublecheckobjectmanage"
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
		<table class="table" width="100%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" title="全选" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="dcId" class="orderFlag">
						轮次ID
					</th>
					<th width="80" orderField="womanId" class="orderFlag">
						妇女ID
					</th>
					<th width="80" orderField="issingle" class="orderFlag">
						是否个人
					</th>
					<th width="80" orderField="year" class="orderFlag">
						年度(主要针对个人)
					</th>
					<th width="80" orderField="total" class="orderFlag">
						本次双查总次数(主要针对个人)
					</th>
					<th width="80" orderField="seq" class="orderFlag">
						轮次(主要针对个人)
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
							${a.dcId}
						</td>
						<td>
							${a.womanId}
						</td>
						<td>
							${a.issingle}
						</td>
						<td>
							${a.year}
						</td>
						<td>
							${a.total}
						</td>
						<td>
							${a.seq}
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/bcmas/doublecheckobject!view.action?id=${a.id}"
									target="navTab" title="查看fhp_double_check_object信息"
									rel="doubleCheckObject-view"></a>
								<a class="btnEdit"
									href="${ctx}/bcmas/doublecheckobject!input.action?id=${a.id}"
									target="navTab" title="修改fhp_double_check_object信息"
									rel="doubleCheckObject-update"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/doublecheckobject!delete.action?id=${a.id}&result4Json.navTabId=nav_doublecheckobjectmanage"
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
<script>
$(function(){
	$('#status0').click(function(){
		if(this.checked){
			$('#td_dcObjType').show();
			$('#td_typeh').hide();
		}
	});
	$('#status1').click(function(){
		if(this.checked){
			$('#td_dcObjType').hide();
			$('#td_typeh').show();
		}
	});
});
</script>