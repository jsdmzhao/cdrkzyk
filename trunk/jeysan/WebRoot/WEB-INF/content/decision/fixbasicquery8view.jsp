<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery8view.action">
	<input type="hidden" name="filter_GED_dateh" value="${param['filter_GED_dateh']}" />
	<input type="hidden" name="filter_LED_dateh" value="${param['filter_LED_dateh']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery8view.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>未避孕日期：
<input type="text" name="filter_GED_dateh" class="date" readonly="true" value="${param.filter_GED_dateh}"/>~
<input type="text" name="filter_LED_dateh" class="date" readonly="true" value="${param.filter_LED_dateh}"/>	
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
					<a class="icon" href="javascript:JS_print2('安排生育情况(取环、停药具、复通)')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag">妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">妇女姓名</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
					<th width="80" orderField="dateh" class="orderFlag" htype="date">未避孕日期</th>
					<th width="80" orderField="typeh" class="orderFlag" htype="dict">未避孕原因</th>
					<th width="80" orderField="boynum" class="orderFlag" htype="digits">男孩数</th>
					<th width="80" orderField="girlnum" class="orderFlag" htype="digits">女孩数</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.typeh}"/></td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td>${a.nameh2}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>