<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery19view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_GED_issDate" value="${param['filter_GED_issDate']}" />
	<input type="hidden" name="filter_LED_issDate" value="${param['filter_LED_issDate']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery19view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>登记日期：
<input type="text" name="filter_GED_issDate" class="date" readonly="true" value="${param.filter_GED_issDate}"/>~
<input type="text" name="filter_LED_issDate" class="date" readonly="true" value="${param.filter_LED_issDate}"/>
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
					<a class="icon" href="javascript:JS_print2('基层常用统计资料查询(结婚登记情况)')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="nameh" class="orderFlag">女方姓名</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">女方出生日期</th>
					<th width="80" orderField="domicile">女方户籍地</th>
					<th width="80" orderField="address">女方常住地</th>
					<th width="80" orderField="nameh2" class="orderFlag">男方姓名</th>
					<th width="80" orderField="domicile2">男方户籍地</th>
					<th width="80" orderField="househodeKind2" class="orderFlag" htype="dict">男方户口性质</th>
					<th width="80" orderField="issDate" class="orderFlag" htype="date">登记日期</th>
					<th width="80" orderField="issOrgAddress">登记地</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.nameh}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td>${a.domicile}</td>
					<td>${a.address}</td>
					<td>${a.nameh2}</td>
					<td>${a.domicile2}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind2}"/></td>
					<td><fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.issOrgAddress}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>