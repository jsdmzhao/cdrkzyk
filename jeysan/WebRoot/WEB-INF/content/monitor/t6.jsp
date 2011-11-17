<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="fix" value="<%=Constants.DOMICILE_TYPE.FIX%>"/>
<c:set var="flow" value="<%=Constants.DOMICILE_TYPE.FLOW%>"/>
<tags:js.pager action="${ctx}/monitor/hpmonitor!findSocialUpbrings.action">
	<input type="hidden" name="domicileType" value="${param['domicileType']}" />
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/monitor/hpmonitor!findSocialUpbrings.action" method="post">
	<input type="hidden" name="domicileType" value="${param['domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							所属区域：
							<tags:js.area.selector name="filter_EQS_area" readonly="true"
								value="${param['filter_EQS_area']}" size="20"></tags:js.area.selector>
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
					<a class="icon" href="javascript:JS_print2('应交社会抚养费对象一览表')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
<c:if test="${param.domicileType==fix}">
		<table class="table" width="150%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="PERSON_CODE" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="NAMEH" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="NAMEH2" class="orderFlag">
						丈夫姓名
					</th>
					<th width="80" orderField="CAUSE" class="orderFlag">
						征收原因
					</th>
					<th width="80" orderField="TOTAL_MONEY" class="orderFlag" htype="money">
						应交金额
					</th>
					<th width="80" orderField="YET_MONEY" class="orderFlag" htype="money">
						已交金额
					</th>
					<th width="80" orderField="counth" class="orderFlag" htype="digits">
						交款次数
					</th>
					<th width="80" orderField="ADDRESS" class="orderFlag">
						现居住地
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr>
						<td height="25">
							${b.index+1}
						</td>
						<td>
							${a.PERSON_CODE}
						</td>
						<td>
							${a.NAMEH}
						</td>
						<td>
							${a.NAMEH2}
						</td>
						<td>
							${a.CAUSE}
						</td>
						<td>
							<fmt:formatNumber value="${a.TOTAL_MONEY}" type="currency" pattern="￥.00"/>
						</td>
						<td>
							<fmt:formatNumber value="${a.YET_MONEY}" type="currency" pattern="￥.00"/>
						</td>
						<td>
							${a.counth}
						</td>
						<td>
							${a.ADDRESS}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</c:if>
<c:if test="${param.domicileType==flow}">
		<table class="table" width="150%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="PERSON_CODE" class="orderFlag">
						流动人口编号
					</th>
					<th width="80" orderField="NAMEH" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="NAMEH2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="CAUSE" class="orderFlag">
						缴交原因
					</th>
					<th width="80" orderField="TOTAL_MONEY" class="orderFlag" htype="money">
						应交金额
					</th>
					<th width="80" orderField="YET_MONEY" class="orderFlag" htype="money">
						已交金额
					</th>
					<th width="80" orderField="counth" class="orderFlag" htype="digits">
						缴款次数
					</th>
					<th width="80" orderField="ADDRESS" class="orderFlag">
						现居住地
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr>
						<td height="25">
							${b.index+1}
						</td>
						<td>
							${a.PERSON_CODE}
						</td>
						<td>
							${a.NAMEH}
						</td>
						<td>
							${a.NAMEH2}
						</td>
						<td>
							${a.CAUSE}
						</td>
						<td>
							<fmt:formatNumber value="${a.TOTAL_MONEY}" type="currency" pattern="￥.00"/>
						</td>
						<td>
							<fmt:formatNumber value="${a.YET_MONEY}" type="currency" pattern="￥.00"/>
						</td>
						<td>
							${a.counth}
						</td>
						<td>
							${a.ADDRESS}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</c:if>
<div class="panelBar">
	<div class="pages"><span>共有&nbsp;${page.totalCount}&nbsp;条记录</span></div>
</div>
	</div>
</div>