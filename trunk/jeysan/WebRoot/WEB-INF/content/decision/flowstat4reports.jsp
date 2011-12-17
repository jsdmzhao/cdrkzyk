<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowstatreports.action">
	<input type="hidden" name="filter_GED_startDate" value="${param['filter_GED_startDate']}" />
	<input type="hidden" name="filter_LED_endDate" value="${param['filter_LED_endDate']}" />
	<input type="hidden" name="type" value="${param['type']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowstatreports.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="type" value="${param['type']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							起始月份：
							<input type="input" value="${param['filter_GED_startDate']}" id="filter_GED_startDate" name="filter_GED_startDate" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})">
						</td>
						<td>
							终止月份：
							<input type="input" value="${param['filter_LED_endDate']}" id="filter_LED_endDate" name="filter_LED_endDate" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})">
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
					<a class="icon" href="javascript:<c:if test="${(not empty param.filter_GED_startDate) && (not empty param.filter_LED_endDate)}">JS_print3('${param.filter_GED_startDate}至${param.filter_LED_endDate}分孩次落实节育措施情况统计表')</c:if>"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<div layoutH="96">
		<table class="list" width="150%">
			<thead>
				<tr>
					<th></th>
					<th colspan="8">一孩夫妇</th>
					<th colspan="10">二孩夫妇</th>
					<th colspan="8">三孩及以上夫妇</th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th colspan="7">其中</th>
					<th></th>
					<th colspan="2">其中纯女户</th>
					<th colspan="7">其中</th>
					<th></th>
					<th colspan="7">其中</th>
				</tr>
				<tr head="true">
					<th width="160" hcode="area">
						单位
					</th>
					<!-- 一孩 -->
					<th width="80" hcode="s19_1" htype="digits">
						人数
					</th>
					<th width="80" hcode="s11_1" htype="digits">
						男结扎
					</th>
					<th width="80" hcode="s12_1" htype="digits">
						女结扎
					</th>
					<th width="80" hcode="s13_1" htype="digits">
						放环(花)
					</th>
					<th width="80" hcode="s14_1" htype="digits">
						避孕药具
					</th>
					<th width="80" hcode="s15_1" htype="digits">
						皮下埋植
					</th>
					<th width="80" hcode="s16_1" htype="digits">
						其它
					</th>
					<th width="80" hcode="a1" htype="digits">
						合计
					</th>
					<!-- 二孩 -->
					<th width="80" hcode="s19_2" htype="digits">
						人数
					</th>
					<th width="80" hcode="s17" htype="digits">
						人数
					</th>
					<th width="80" hcode="s18" htype="digits">
						其中结扎
					</th>
					<th width="80" hcode="s11_2" htype="digits">
						男结扎
					</th>
					<th width="80" hcode="s12_2" htype="digits">
						女结扎
					</th>
					<th width="80" hcode="s13_2" htype="digits">
						放环(花)
					</th>
					<th width="80" hcode="s14_2" htype="digits">
						避孕药具
					</th>
					<th width="80" hcode="s15_2" htype="digits">
						皮下埋植
					</th>
					<th width="80" hcode="s16_2" htype="digits">
						其它
					</th>
					<th width="80" hcode="a2" htype="digits">
						合计
					</th>

					<!-- 三孩及以上 -->
					<th width="80" hcode="s19_3" htype="digits">
						人数
					</th>
					<th width="80" hcode="s11_3" htype="digits">
						男结扎
					</th>
					<th width="80" hcode="s12_3" htype="digits">
						女结扎
					</th>
					<th width="80" hcode="s13_3" htype="digits">
						放环(花)
					</th>
					<th width="80" hcode="s14_3" htype="digits">
						避孕药具
					</th>
					<th width="80" hcode="s15_3" htype="digits">
						皮下埋植
					</th>
					<th width="80" hcode="s16_3" htype="digits">
						其它
					</th>
					<th width="80" hcode="a3" htype="digits">
						合计
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${results}" varStatus="b">
					<tr>
						<td height="25">${a.area}</td>

						<td>${a.s19_1}</td>
						<td>${a.s11_1}</td>
						<td>${a.s12_1}</td>
						<td>${a.s13_1}</td>
						<td>${a.s14_1}</td>
						<td>${a.s15_1}</td>
						<td>${a.s16_1}</td>
						<td>${a.a1}</td>
					
						<td>${a.s19_2}</td>
						<td>${a.s17}</td>
						<td>${a.s18}</td>
						<td>${a.s11_2}</td>
						<td>${a.s12_2}</td>
						<td>${a.s13_2}</td>
						<td>${a.s14_2}</td>
						<td>${a.s15_2}</td>
						<td>${a.s16_2}</td>
						<td>${a.a2}</td>

						<td>${a.s19_3}</td>
						<td>${a.s11_3}</td>
						<td>${a.s12_3}</td>
						<td>${a.s13_3}</td>
						<td>${a.s14_3}</td>
						<td>${a.s15_3}</td>
						<td>${a.s16_3}</td>
						<td>${a.a3}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</div>