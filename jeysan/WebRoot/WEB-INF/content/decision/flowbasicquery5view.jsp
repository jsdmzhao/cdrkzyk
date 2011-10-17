<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery5view.action">
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQS_personCode" value="${param['filter_EQS_personCode']}" />
	<input type="hidden" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" />
	<input type="hidden" name="filter_GED_birthday" value="${param['filter_GED_birthday']}" />
	<input type="hidden" name="filter_LED_birthday" value="${param['filter_LED_birthday']}" />
	<input type="hidden" name="filter_LIKES_domicile" value="${param['filter_LIKES_domicile']}" />
	<input type="hidden" name="filter_GED_settleInDate" value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate" value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_GED_outDate" value="${param['filter_GED_outDate']}" />
	<input type="hidden" name="filter_LED_outDate" value="${param['filter_LED_outDate']}" />
	<input type="hidden" name="filter_GED_conceptDate" value="${param['filter_GED_conceptDate']}" />
	<input type="hidden" name="filter_LED_conceptDate" value="${param['filter_LED_conceptDate']}" />
	<input type="hidden" name="filter_GED_endDate" value="${param['filter_GED_endDate']}" />
	<input type="hidden" name="filter_LED_endDate" value="${param['filter_LED_endDate']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery5view.action" method="post">
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
							婚姻状况：
<tags:js.dict.selector name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" dictCode="JS1015" noRender="true"/>
						</td>
						<td>
							户籍地：
<input type="text" name="filter_LIKES_domicile" class="text" value="${param.filter_LIKES_domicile}"/>
						</td>
</tr><tr>
						<td colspan="2">
							出生日期：
<input type="text" name="filter_GED_birthday" class="date" readonly="true" value="${param.filter_GED_birthday}"/>~<input type="text" name="filter_LED_birthday" class="date" readonly="true" value="${param.filter_LED_birthday}"/>
						</td>
						<td colspan="2">
							流入日期：
<input type="text" name="filter_GED_settleInDate" class="date" readonly="true" value="${param.filter_GED_settleInDate}"/>~<input type="text" name="filter_LED_settleInDate" class="date" readonly="true" value="${param.filter_LED_settleInDate}"/>
						</td>
</tr><tr>
						<td colspan="2">
							流出日期：
<input type="text" name="filter_GED_outDate" class="date" readonly="true" value="${param.filter_GED_outDate}"/>~<input type="text" name="filter_LED_outDate" class="date" readonly="true" value="${param.filter_LED_outDate}"/>
						</td>
						<td colspan="2">
							怀孕日期：
<input type="text" name="filter_GED_conceptDate" class="date" readonly="true" value="${param.filter_GED_conceptDate}"/>~<input type="text" name="filter_LED_conceptDate" class="date" readonly="true" value="${param.filter_LED_conceptDate}"/>
						</td>
</tr><tr>
						<td colspan="2">
							孕产日期：
<input type="text" name="filter_GED_endDate" class="date" readonly="true" value="${param.filter_GED_endDate}"/>~<input type="text" name="filter_LED_endDate" class="date" readonly="true" value="${param.filter_LED_endDate}"/>
						</td>
						<td colspan="2">
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
						href="javascript:JS_print2('孕产情况')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="200%" layouth="219">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="personCode" class="orderFlag">
						流动人员编码
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
					<th width="80" orderField="currentConceptStatus" class="orderFlag" htype="dict">
						现孕状态
					</th>
					<th width="80" orderField="conceptCause" class="orderFlag">
						怀孕原因
					</th>
					<th width="80" orderField="matenalResult" class="orderFlag" htype="dict">
						孕产结果
					</th>
					<th width="80" orderField="settleInDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="address" class="orderFlag">
						居住地
					</th>
					<th width="80" orderField="outDate" class="orderFlag" htype="date">
						流出日期
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
							<tags:js.dict.getValue value="${a.currentConceptStatus}"/>
						</td>
						<td>
							${a.conceptCause}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.matenalResult}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.domicile}
						</td>
						<td>
							${a.address}
						</td>
						<td>
							<fmt:formatDate value="${a.outDate}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>