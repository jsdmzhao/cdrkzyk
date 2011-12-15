<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery20view.action">
	<input type="hidden" name="filter_GED_dateh" value="${param['filter_GED_dateh']}" />
	<input type="hidden" name="filter_LED_dateh" value="${param['filter_LED_dateh']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery20view.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>死亡日期：
<input type="text" name="filter_GED_dateh" class="date" readonly="true" value="${param.filter_GED_dateh}"/>~
<input type="text" name="filter_LED_dateh" class="date" readonly="true" value="${param.filter_LED_dateh}"/>
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
					<a class="icon" href="javascript:JS_print2('基层常用统计资料查询(死亡登记情况)')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="teamName" class="orderFlag">村民小组</th>
					<th width="80" orderField="nameh" class="orderFlag">死者姓名</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">死者性别</th>
					<th width="80" orderField="age" class="orderFlag">死者年龄</th>
					<th width="80" orderField="dateh" class="orderFlag" htype="date">死亡日期</th>
					<th width="80" orderField=cause>死亡原因</th>
					<th width="80" orderField="nameh2" class="orderFlag">户主姓名</th>
					<th width="80" orderField="relation" class="orderFlag" htype="dict">与户主关系</th>
					<th width="80" orderField="remark">备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.teamName}</td>
					<td>${a.nameh}</td>
					<td><tags:js.dict.getValue value="${a.sex}"/></td>
					<td>${a.age}</td>
					<td><fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/></td>
					<td>${a.cause}</td>
					<td>${a.nameh2}</td>
					<td><tags:js.dict.getValue value="${a.relation}"/></td>
					<td>${a.remark}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>