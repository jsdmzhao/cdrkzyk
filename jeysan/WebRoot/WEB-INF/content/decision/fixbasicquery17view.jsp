<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery17view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_GED_dateh" value="${param['filter_GED_dateh']}" />
	<input type="hidden" name="filter_LED_dateh" value="${param['filter_LED_dateh']}" />
	<input type="hidden" name="filter_EQI_typeh" value="${param['filter_EQI_typeh']}" />
</tags:js.pager>
<script type="text/javascript">
$(function(){
	var typeh = '${param.filter_EQI_typeh}';
	if(typeh){
		$(':radio[name=filter_EQI_typeh][value='+typeh+']').attr('checked',true);
	}
});
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery17view.action" method="post">

	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>变更日期：
<input type="text" name="filter_GED_dateh" class="date" readonly="true" value="${param.filter_GED_dateh}"/>~
<input type="text" name="filter_LED_dateh" class="date" readonly="true" value="${param.filter_LED_dateh}"/>
					</td>
					<td><input type="radio" name="filter_EQI_typeh" value="1"/>更换服务证
						<input type="radio" name="filter_EQI_typeh" value="0"/>废止服务证
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
					<a class="icon" href="javascript:JS_print2('证件办理情况查询(计划生育服务证变更废止情况)')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag">育龄妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">姓名</th>
					<th width="80" orderField="code" class="orderFlag">身份证号码</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">婚姻状况</th>
					<th width="80" orderField="househodeKind" class="orderFlag" htype="dict">户口性质</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">子女数</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">避孕节育措施</th>
					<th width="80" orderField="nameh3" class="orderFlag">丈夫姓名</th>
					<th width="80" orderField="househodeKind2" class="orderFlag" htype="dict">丈夫户口性质</th>
					<th width="80" orderField="dateh" class="orderFlag" htype="date">日期</th>
					<th width="80" orderField="cause" class="orderFlag" htype="dict">原因</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td>${a.code}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.marryStatus}"/></td>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td>${a.childnum}</td>
					<td><tags:js.dict.getValue value="${a.method}"/></td>
					<td>${a.nameh3}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind2}"/></td>
					<td><fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.cause}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>