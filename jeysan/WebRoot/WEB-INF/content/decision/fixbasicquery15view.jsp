<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery15view.action">
	<input type="hidden" name="filter_GED_issDate" class="text" value="${param.filter_GED_issDate}"/>
	<input type="hidden" name="filter_LED_issDate" class="text" value="${param.filter_LED_issDate}"/>
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery15view.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>办理流动证日期：
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
					<a class="icon" href="javascript:JS_print2('证件办理情况查询(领取流动人口婚育证明情况)')"><span>打印或者导出</span>
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
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">婚姻状况</th>
					<th width="80" orderField="househodeKind" class="orderFlag" htype="dict">户口性质</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">避孕节育方法</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">子女数</th>
					<th width="80" orderField="boynum" class="orderFlag" htype="digits">男孩数</th>
					<th width="80" orderField="girlnum" class="orderFlag" htype="digits">女孩数</th>
					<th width="80" orderField="issType" class="orderFlag" htype="dict">流动证类型</th>
					<th width="80" orderField="issDate" class="orderFlag" htype="date">领流动证日期</th>
					<th width="80" orderField="nameh3" class="orderFlag">丈夫姓名</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td><tags:js.dict.getValue value="${a.marryStatus}"/></td>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td><tags:js.dict.getValue value="${a.method}"/></td>
					<td>${a.childnum}</td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td><tags:js.dict.getValue value="${a.issType}"/></td>
					<td><fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.nameh3}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>