<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<c:set var="action" value="${ctx}/decision/fixbasicquery4view.action"/>
<c:if test="${param.isTake eq 0}">
	<c:set var="action" value="${ctx}/decision/fixbasicquery5view.action"/>
</c:if>
<tags:js.pager action="${action}">
	<c:if test="${param.isTake eq 1}">
		<input type="hidden" name="filter_EQS_typeh" value="${param['filter_EQS_typeh']}" />
	</c:if>
</tags:js.pager>
<script type="text/javascript">
$(function(){
	$('select[name=isTake]').val('${param.isTake}');
	$('select[name=isTake]').change(function(){
		$('#selector_filter_EQS_typeh').attr('disabled',this.value==0);
		var action = '${ctx}/decision/fixbasicquery4view.action';
		if(this.value == 0){
			action = '${ctx}/decision/fixbasicquery5view.action'
		}
		$('div.pageHeader form').attr('action',action);
	}).change();
});
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${action}" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>是否投保：
						<select name="isTake" style="width: 100px" class="">
							<option value="1" selected="selected" >已买</option>
							<option value="0">应买</option>
						</select>											
					</td>
					<td>
						保险类型：
<tags:js.dict.selector name="filter_EQS_typeh" value="${param.filter_EQS_typeh}" dictCode="JS1019" noRender="true"/>					
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
						<li>
							<div class="button">
								<div class="buttonContent">
									<button type="reset">
										重置
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
					<a class="icon" href="javascript:JS_print2('育龄妇女基本情况(按参加社会保险情况)')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag">育龄妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">妇女姓名</th>
					<c:if test="${param.isTake eq 0}">
					<th width="80" orderField="age" htype="digits" class="orderFlag">年龄</th>
					</c:if>
					<c:if test="${param.isTake eq 1}">
					<th width="80" orderField="typeh" htype="dict"  class="orderFlag">投保类型</th>
					<th width="80" orderField="moneyh" class="orderFlag">投保金额</th>
					<th width="80" orderField="dateh" class="orderFlag">投保日期</th>
					</c:if>
					<th width="80" orderField="minchildindex" htype="digits" class="orderFlag">孩次</th>
					<th width="80" orderField="minbirthday" htype="date" class="orderFlag">最小孩出生日期</th>
					<th width="80" orderField="minsex" htype="dict" class="orderFlag">最小孩性别</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
					<th width="80" orderField="domicileType" htype="dict" class="orderFlag">丈夫户口</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.nameh}</td>
					<td>${a.personCode}</td>
					<c:if test="${param.isTake eq 0}">
					<td>${a.age}</td>
					</c:if>
					<c:if test="${param.isTake eq 1}">
					<td><tags:js.dict.getValue value="${a.typeh}"/></td>
					<td>${a.moneyh}</td>
					<td>${a.dateh}</td>
					</c:if>
					<td>${a.minchildindex}</td>
					<td><fmt:formatDate value="${a.minbirthday}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.minsex}"/></td>
					<td>${a.nameh2}</td>
					<td><tags:js.dict.getValue value="${a.domicileType}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>