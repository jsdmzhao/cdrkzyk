<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowstatreports.action">
	<input type="hidden" name="start" value="${param['start']}" />
	<input type="hidden" name="end" value="${param['end']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowstatreports.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							起始月份：
							<input type="input" id="start" name="start" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})">
						</td>
						<td>
							终止月份：
							<input type="input" id="end" name="end" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})">
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
					<a class="icon" href="javascript:<c:if test="${(not empty param.start) && (not empty param.end)}">JS_print2('${param.start}至${param.end}计划生育情况统计表')</c:if>"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<div layoutH="96">
		<table class="list" width="150%">
			<thead>
				<tr>
					<th></th>
					<th colspan="13">出生</th>
					<th colspan="13">计划生育手术</th>
				</tr>
				<tr>
					<th></th>
					<th colspan="3">一孩</th>
					<th colspan="4">二孩</th>
					<th colspan="3">三孩及以上</th>
					<th colspan="3"></th>
					<th colspan="13"></th>
				</tr>
				<tr>
					<th></th>
					<th colspan="5"></th>
					<th colspan="2">其中政策内</th>
					<th colspan="3"></th>
					<th colspan="3"></th>
					<th colspan="13"></th>
				</tr>
				<tr head="true">
					<th width="160" hcode="area">
						单位
					</th>
					<!-- 一孩 -->
					<th width="80" hcode="s11" htype="digits">
						人数
					</th>
					<th width="80" hcode="a1" htype="per">
						%
					</th>
					<th width="80" hcode="s12" htype="digits">
						其中政策内人数
					</th>
					<!-- 二孩 -->
					<th width="80" hcode="s13" htype="digits">
						人数
					</th>
					<th width="80" hcode="a2" htype="per">
						%
					</th>
					<th width="80" hcode="s14" htype="digits">
						人数
					</th>
					<th width="80" hcode="a3" htype="per">
						占二孩%
					</th>

					<!-- 三孩及以上 -->
					<th width="80" hcode="s15" htype="digits">
						人数
					</th>
					<th width="80" hcode="a4" htype="per">
						%
					</th>
					<th width="80" hcode="s16" htype="digits">
						其中政策内人数
					</th>

					<th width="80" hcode="a5" htype="digits">
						合计
					</th>
					<th width="80" hcode="a6" htype="per">
						与去年同期相比(+,-)
					</th>
					<th width="80" hcode="a7" htype="per">
						政策生育率
					</th>

					<!-- 结扎 -->
					<th width="80" hcode="s21" htype="digits">
						男结扎
					</th>
					<th width="80" hcode="s22" htype="digits">
						女结扎
					</th>
					<th width="80" hcode="b1" htype="digits">
						小计
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
						其中一孩上环
					</th>

					<!-- 补救措施 -->
					<th width="80" hcode="s41" htype="digits">
						补救措施一
					</th>
					<th width="80" hcode="s42" htype="digits">
						补救措施二
					</th>
					<th width="80" hcode="c1" htype="digits">
						小计
					</th>

					<th width="80" hcode="s51" htype="digits">
						皮下埋植
					</th>
					<th width="80" hcode="d1" htype="digits">
						合计
					</th>
					<th width="80" hcode="e1" htype="digits">
						与去年同期相比(+,-)
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${results}" varStatus="b">
					<tr>
						<td height="25">${a.area}</td>

						<td>${a.s11}</td>
						<td><fmt:formatNumber value="${a.a1}" type="percent" pattern="#0.00%"/></td>
						<td>${a.s12}</td>
						<td>${a.s13}</td>
						<td><fmt:formatNumber value="${a.a2}" type="percent" pattern="#0.00%"/></td>
						<td>${a.s14}</td>
						<td><fmt:formatNumber value="${a.a3}" type="percent" pattern="#0.00%"/></td>
						<td>${a.s15}</td>
						<td><fmt:formatNumber value="${a.a4}" type="percent" pattern="#0.00%"/></td>
						<td>${a.s16}</td>
						<td>${a.a5}</td>
						<td><fmt:formatNumber value="${a.a6}" type="percent" pattern="#0.00%"/></td>
						<td><fmt:formatNumber value="${a.a7}" type="percent" pattern="#0.00%"/></td>

						<td>${a.s21}</td>
						<td>${a.s22}</td>
						<td>${a.b1}</td>
						<td>${a.s23}</td>
						<td>${a.s24}</td>

						<td>${a.s31}</td>
						<td>${a.s32}</td>

						<td>${a.s41}</td>
						<td>${a.s42}</td>
						<td>${a.c1}</td>

						<td>${a.51}</td>
						<td>${a.d1}</td>
						<td>${a.e1}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</div>