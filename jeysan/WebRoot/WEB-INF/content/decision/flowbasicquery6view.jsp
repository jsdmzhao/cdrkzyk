<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery6view.action">
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQS_personCode" value="${param['filter_EQS_personCode']}" />
	<input type="hidden" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" />
	<input type="hidden" name="filter_EQL_childnum" value="${param['filter_EQL_childnum']}" />
	<input type="hidden" name="filter_GED_settleInDate" value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate" value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_EQS_cause" value="${param['filter_EQS_cause']}" />
	<input type="hidden" name="filter_EQI_lodType" value="${param['filter_EQI_lodType']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery6view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							编号：
<input type="text" name="filter_EQS_personCode" class="text" value="${param.filter_EQS_personCode}"/>
						</td>
						<td>
							姓名：
<input type="text" name="filter_LIKES_nameh" class="text" value="${param.filter_LIKES_nameh}"/>
						</td>
						<td>
							子女数：
<input type="text" name="filter_EQL_childnum" class="text" value="${param.filter_EQL_childnum}"/>
						</td>
						<td>
							婚姻状况：
<tags:js.dict.selector name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" dictCode="JS1015" noRender="true"/>
						</td>
</tr><tr>
						<td colspan="2">
							流入日期：
<input type="text" name="filter_GED_settleInDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_GED_settleInDate}"/>~<input type="text" name="filter_LED_settleInDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_LED_settleInDate}"/>
						</td>
						<td>
							征收原因：
<tags:js.dict.selector name="filter_EQS_cause" value="${param['filter_EQS_cause']}" dictCode="JS1075" noRender="true"/>
						</td>
						<td>
							征收机关：
<tags:js.dict.selector name="filter_EQI_lodType" value="${param['filter_EQI_lodType']}" dictCode="JS1070" noRender="true"/>
						</td>
					</tr>
<tr>

						<td colspan="4">
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
					<a class="icon"
						href="javascript:JS_print2('社会抚养费征收情况')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="200%" layouth="192">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="personCode" class="orderFlag">
						流动人口编号
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
					<th width="80" orderField="cause" class="orderFlag" htype="dict">
						征收原因
					</th>
					<th width="80" orderField="totalMoney" class="orderFlag" htype="money">
						应缴金额
					</th>
					<th width="80" orderField="yetMoney" class="orderFlag" htype="money">
						已缴金额
					</th>
					<th width="80" orderField="yetMoney" class="orderFlag" htype="money">
						未缴金额
					</th>
					<th width="80" orderField="installmentNum" class="orderFlag" htype="digits">
						缴款次数
					</th>
					<th width="80" orderField="lodOrg" class="orderFlag">
						征收机关
					</th>
					<th width="80" orderField="tel" class="orderFlag">
						联系电话
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="address" class="orderFlag">
						居住地
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
							<tags:js.dict.getValue value="${a.cause}"/>
						</td>
						<td>
							<fmt:formatNumber value="${a.totalMoney}" type="currency" pattern="￥.00"/>
						</td>
						<td>
							<fmt:formatNumber value="${a.yetMoney}" type="currency" pattern="￥.00"/>
						</td>
						<td>
							<fmt:formatNumber value="${a.noMoney}" type="currency" pattern="￥.00"/>
						</td>
						<td>
							${a.installmentNum}
						</td>
						<td>
							${a.lodOrg}
						</td>
						<td>
							${a.tel}
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