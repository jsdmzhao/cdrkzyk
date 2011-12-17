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
					<a class="icon" href="javascript:<c:if test="${(not empty param.filter_GED_startDate) && (not empty param.filter_LED_endDate)}">JS_print3('${param.filter_GED_startDate}至${param.filter_LED_endDate}已婚育龄夫妇节育情况统计表')</c:if>"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<div layoutH="96">
		<table class="list" width="150%">
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th colspan="12">本期计划生育手术</th>
					<th colspan="10">现有已婚育龄夫妇落实节育措施</th>
					<th colspan="3">领取独生子女证</th>
					<th></th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th colspan="5">结扎</th>
					<th colspan="2">放环(花)</th>
					<th colspan="3">采取补救措施</th>
					<th colspan="2"></th>
					<th colspan="10"></th>
					<th colspan="2">人数</th>
					<th></th>
					<th></th>
				</tr>
				<tr head="true">
					<th width="160" hcode="area">
						单位
					</th>
					<th width="80" hcode="s11" htype="digits">
						已婚育龄妇女人数
					</th>
					<!-- 结扎 -->
					<th width="80" hcode="a1" htype="digits">
						小计
					</th>
					<th width="80" hcode="s21" htype="digits">
						男结扎
					</th>
					<th width="80" hcode="s22" htype="digits">
						女结扎
					</th>
					<th width="80" hcode="s23" htype="digits">
						其中二孩结扎
					</th>
					<th width="80" hcode="s24" htype="digits">
						其中纯二女扎
					</th>
					<!-- 放环(花) -->
					<th width="80" hcode="s31" htype="digits">
						小计
					</th>
					<th width="80" hcode="s32" htype="digits">
						其中一孩放环
					</th>

					<!-- 采取补救措施 -->
					<th width="80" hcode="a2" htype="digits">
						小计
					</th>
					<th width="80" hcode="s41" htype="digits">
						补救措施一
					</th>
					<th width="80" hcode="s42" htype="digits">
						补救措施二
					</th>

					<th width="80" hcode="s51" htype="digits">
						皮下埋植
					</th>
					<th width="80" hcode="a3" htype="digits">
						合计
					</th>

					<!-- 现有已婚育龄夫妇落实节育措施-->
					<th width="80" hcode="s61" htype="digits">
						男结扎
					</th>
					<th width="80" hcode="s62" htype="digits">
						女结扎
					</th>
					<th width="80" hcode="s63" htype="digits">
						放环(花)
					</th>
					<th width="80" hcode="s64" htype="digits">
						服(注)药
					</th>
					<th width="80" hcode="s65" htype="digits">
						避孕套
					</th>
					<th width="80" hcode="s66" htype="digits">
						外用药
					</th>
					<th width="80" hcode="s67" htype="digits">
						皮下埋植
					</th>
					<th width="80" hcode="s68" htype="digits">
						其它
					</th>
					<th width="80" hcode="a4" htype="digits">
						合计
					</th>
					<th width="80" hcode="a5" htype="per">
						节育率
					</th>

					<!-- 领独生子女证-->
					<th width="80" hcode="s71" htype="digits">
						本期
					</th>
					<th width="80" hcode="s72" htype="digits">
						期末
					</th>
					<th width="80" hcode="a6" htype="per">
						领证率
					</th>

					<th width="80" hcode="s81" htype="digits">
						取环(花)
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${results}" varStatus="b">
					<tr>
						<td height="25">${a.area}</td>

						<td>${a.s11}</td>
						<td>${a.a1}</td>
						<td>${a.s21}</td>
						<td>${a.s22}</td>
						<td>${a.s23}</td>
						<td>${a.s24}</td>

						<td>${a.s31}</td>
						<td>${a.s32}</td>
						<td>${a.a2}</td>
						<td>${a.s41}</td>
						<td>${a.s42}</td>
						<td>${a.s51}</td>
						<td>${a.a3}</td>

						<td>${a.s61}</td>
						<td>${a.s62}</td>
						<td>${a.s63}</td>
						<td>${a.s64}</td>
						<td>${a.s65}</td>
						<td>${a.s66}</td>
						<td>${a.s67}</td>
						<td>${a.s68}</td>
						<td>${a.a4}</td>
						<td><fmt:formatNumber value="${a.a5}" type="percent" pattern="#0.00%"/></td>

						<td>${a.s71}</td>
						<td>${a.s72}</td>
						<td><fmt:formatNumber value="${a.a6}" type="percent" pattern="#0.00%"/></td>

						<td>${a.s81}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</div>