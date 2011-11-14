<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/flowbasicquery13view.action">
	<input type="hidden" name="filter_EQI_id" value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/flowbasicquery13view.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						主键：<input type="text" name="filter_EQI_id" value="${param['filter_EQI_id']}"/>
					</td>
					<td>
						建档日期：<input type="text" class="date" readonly="true" />
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
					<a class="icon" href="javascript:JS_print2('fhp_flowbasicquery13_view')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="200%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
															<th width="80" orderField="area" class="orderFlag">所属区域</th>
																				<th width="80" orderField="domicileType" class="orderFlag">户口类别</th>
																				<th width="80" orderField="personnum" class="orderFlag">人口数</th>
																				<th width="80" orderField="arealevel" class="orderFlag">流入或流出类别</th>
																				<th width="80" orderField="dateh" class="orderFlag">日期</th>
																				<th width="80" orderField="inOutType" class="orderFlag">流入或流出</th>
														</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
																				<td>${a.area}</td>
																														<td>${a.domicileType}</td>
																														<td>${a.personnum}</td>
																														<td>${a.arealevel}</td>
																														<td><fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/></td>
																														<td>${a.inOutType}</td>
																			</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>