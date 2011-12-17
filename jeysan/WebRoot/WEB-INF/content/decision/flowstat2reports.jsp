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
					<a class="icon" href="javascript:<c:if test="${(not empty param.filter_GED_startDate) && (not empty param.filter_LED_endDate)}">JS_print3('${param.filter_GED_startDate}至${param.filter_LED_endDate}人口自然变动及女性初婚情况统计表表')</c:if>"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<div layoutH="96">
		<table class="list" width="200%">
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th colspan="20">出生</th>
					<th colspan="2">死亡</th>
					<th colspan="2">自然增长</th>
					<th colspan="3">女性初婚</th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th colspan="6">一孩</th>
					<th colspan="6">二孩</th>
					<th colspan="5">三孩及以上</th>
					<th colspan="3"></th>
					<th colspan="2"></th>
					<th colspan="2"></th>
					<th></th>
					<th colspan="2"></th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th colspan="2"></th>
					<th colspan="2">其中</th>
					<th colspan="2">其中政策内</th>
					<th colspan="2"></th>
					<th colspan="2">其中</th>
					<th colspan="2">其中政策内</th>
					<th colspan="2"></th>
					<th colspan="2">其中</th>
					<th></th>
					<th colspan="3"></th>
					<th colspan="2"></th>
					<th colspan="2"></th>
					<th></th>
					<th colspan="2">其中</th>
				</tr>
				<tr head="true">
					<th width="160" hcode="area">
						单位
					</th>
					<th width="80" hcode="m1" htype="digits">
						总人口数
					</th>
					<th width="80" hcode="m2" htype="digits">
						平均人口数
					</th>
					<!-- 一孩 -->
					<th width="80" hcode="s1t" htype="digits">
						人数
					</th>
					<th width="80" hcode="a1" htype="per">
						%
					</th>
					<th width="80" hcode="s11_1" htype="digits">
						男
					</th>
					<th width="80" hcode="s11_2" htype="digits">
						女
					</th>
					<th width="80" hcode="s12_1" htype="digits">
						男
					</th>
					<th width="80" hcode="s12_2" htype="digits">
						女
					</th>
					<!-- 二孩 -->
					<th width="80" hcode="s2t" htype="digits">
						人数
					</th>
					<th width="80" hcode="a2" htype="per">
						%
					</th>
					<th width="80" hcode="s13_1" htype="digits">
						男
					</th>
					<th width="80" hcode="s13_2" htype="digits">
						女
					</th>
					<th width="80" hcode="s14_1" htype="digits">
						男
					</th>
					<th width="80" hcode="s14_2" htype="digits">
						女
					</th>

					<!-- 三孩及以上 -->
					<th width="80" hcode="s3t" htype="digits">
						人数
					</th>
					<th width="80" hcode="a3" htype="per">
						%
					</th>
					<th width="80" hcode="s15_1" htype="digits">
						男
					</th>
					<th width="80" hcode="s15_2" htype="digits">
						女
					</th>
					<th width="80" hcode="s17" htype="digits">
						其中政策内
					</th>

					<th width="80" hcode="a4" htype="digits">
						合计
					</th>
					<th width="80" hcode="a5" htype="per">
						出生率(%)
					</th>
					<th width="80" hcode="a6" htype="per">
						政策生育率(%)
					</th>

					<!-- 死亡 -->
					<th width="80" hcode="s21" htype="digits">
						人数
					</th>
					<th width="80" hcode="b1" htype="per">
						死亡率(%)
					</th>
					<!-- 自然增长 -->
					<th width="80" hcode="s22" htype="digits">
						人数
					</th>
					<th width="80" hcode="c1" htype="per">
						自然增长率(%)
					</th>
					<!-- 女性初婚 -->
					<th width="80" hcode="s31" htype="digits">
						人数
					</th>
					<th width="80" hcode="s32" htype="digits">
						不足20岁人数
					</th>
					<th width="80" hcode="s33" htype="digits">
						23周岁以上人数
					</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${results}" varStatus="b">
					<tr>
						<td height="25">${a.area}</td>

						<td>${a.m1}</td>
						<td>${a.m2}</td>

						<td>${a.s1t}</td>
						<td><fmt:formatNumber value="${a.a1}" type="percent" pattern="#0.00%"/></td>
						<td>${a.s11_1}</td>
						<td>${a.s11_2}</td>
						<td>${a.s12_1}</td>
						<td>${a.s12_2}</td>

						<td>${a.s2t}</td>
						<td><fmt:formatNumber value="${a.a2}" type="percent" pattern="#0.00%"/></td>
						<td>${a.s13_1}</td>
						<td>${a.s13_2}</td>
						<td>${a.s14_1}</td>
						<td>${a.s14_2}</td>

						<td>${a.s3t}</td>
						<td><fmt:formatNumber value="${a.a3}" type="percent" pattern="#0.00%"/></td>
						<td>${a.s15_1}</td>
						<td>${a.s15_2}</td>
						<td>${a.s17}</td>
					

						<td>${a.a4}</td>
						<td><fmt:formatNumber value="${a.a5}" type="percent" pattern="#0.00%"/></td>
						<td><fmt:formatNumber value="${a.a6}" type="percent" pattern="#0.00%"/></td>

						<td>${a.s21}</td>
						<td><fmt:formatNumber value="${a.b1}" type="percent" pattern="#0.00%"/></td>
						<td>${a.s22}</td>
						<td><fmt:formatNumber value="${a.c1}" type="percent" pattern="#0.00%"/></td>

						<td>${a.s31}</td>
						<td>${a.s32}</td>
						<td>${a.s33}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</div>