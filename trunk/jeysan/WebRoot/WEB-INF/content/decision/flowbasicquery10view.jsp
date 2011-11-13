<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery10view.action">
	<input type="hidden" name="filter_EQS_area"
		value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />

	<input type="hidden" name="filter_GED_settleInDate"
		value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate"
		value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_GED_punishDate"
		value="${param['filter_GED_punishDate']}" />
	<input type="hidden" name="filter_LED_punishDate"
		value="${param['filter_LED_punishDate']}" />

	<input type="hidden" name="filter_LIKES_punishCause"
		value="${param['filter_LIKES_punishCause']}" />

</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery10view.action" method="post">
			<input type="hidden" name="filter_EQI_domicileType"
				value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td colspan="2">
							流入日期：
							<input type="text" name="filter_GED_settleInDate" class="date"
								readonly="true" value="${param.filter_GED_settleInDate}" />
							~
							<input type="text" name="filter_LED_settleInDate" class="date"
								readonly="true" value="${param.filter_LED_settleInDate}" />
						</td>
						<td colspan="2">
							处罚日期：
							<input type="text" name="filter_GED_punishDate" class="date"
								readonly="true" value="${param.filter_GED_punishDate}" />
							~
							<input type="text" name="filter_LED_punishDate" class="date"
								readonly="true" value="${param.filter_LED_punishDate}" />
						</td>
					</tr>
					<tr>
						<td>
							处罚原因：
							<input type="text" name="filter_LIKES_punishCause" class="text"
								value="${param.filter_LIKES_punishCause}" />
						</td>
						<td>
							所属区域：
							<tags:js.area.selector name="filter_EQS_area" readonly="true"
								value="${param['filter_EQS_area']}" size="20"></tags:js.area.selector>
						</td><td></td><td></td>
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
					<a class="icon"
						href="javascript:JS_print2('行政处罚情况')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="200%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="personCode" class="orderFlag">
						人员编号
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">
						出生日期
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						子女数
					</th>
					<th width="80" orderField="settleInDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="punishDate" class="orderFlag" htype="date">
						处罚日期
					</th>
					<th width="80" orderField="punishCause" class="orderFlag">
						处罚原因
					</th>
					<th width="80" orderField="moneyh" class="orderFlag" htype="money">
						处罚金额
					</th>
					<th width="80" orderField="count" class="orderFlag" htype="digits">
						第几次
					</th>
					<th width="80" orderField="agent" class="orderFlag">
						收款人
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地地址
					</th>
					<th width="80" orderField="address" class="orderFlag">
						现居住地地址
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
							${a.personCode}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"/>
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							<fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.punishDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.punishCause}
						</td>
						<td>
							<fmt:formatNumber value="${a.moneyh}" type="currency" pattern="￥.00"/>
						</td>
						<td>
							${a.count}
						</td>
						<td>
							${a.agent}
						</td>
						<td>
							${a.domicile}
						</td>
						<td>
							${a.address}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>