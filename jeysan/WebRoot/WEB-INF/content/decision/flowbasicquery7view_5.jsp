<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery7view.action">
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_GED_settleInDate" value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate" value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_GED_opsDate" value="${param['filter_GED_opsDate']}" />
	<input type="hidden" name="filter_LED_opsDate" value="${param['filter_LED_opsDate']}" />


	<input type="hidden" name="filter_EQI_method" value="${param['filter_EQI_method']}" />
	<input type="hidden" name="filter_EQI_repairMethod" value="${param['filter_EQI_repairMethod']}" />
	<input type="hidden" name="filter_LIKES_hospitalAddress" value="${param['filter_LIKES_hospitalAddress']}" />

	<input type="hidden" name="type" value="${param['type']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery7view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="type" value="${param['type']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td colspan="2">
							流入日期：
<input type="text" name="filter_GED_settleInDate" class="date" readonly="true" value="${param.filter_GED_settleInDate}"/>~<input type="text" name="filter_LED_settleInDate" class="date" readonly="true" value="${param.filter_LED_settleInDate}"/>
						</td>
						<td colspan="2">
							手术日期：
<input type="text" name="filter_GED_opsDate" class="date" readonly="true" value="${param.filter_GED_opsDate}"/>~<input type="text" name="filter_LED_opsDate" class="date" readonly="true" value="${param.filter_LED_opsDate}"/>
						</td>
</tr><tr>
						<td>
							避孕节育措施：
<tags:js.dict.selector name="filter_EQI_method" value="${param['filter_EQI_method']}" dictCode="JS1018" noRender="true"/>
						</td>
						<td>
							补救措施：
<tags:js.dict.selector name="filter_EQI_repairMethod" value="${param['filter_EQI_repairMethod']}" dictCode="JS1031" noRender="true"/>
						</td>
						<td>
							手术地点：
<input type="text" name="filter_LIKES_hospitalAddress" class="text" value="${param.filter_LIKES_hospitalAddress}"/>
						</td>
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
					<a class="icon"
						href="javascript:JS_print2('计划生育手术情况')"><span>打印或者导出</span>
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
					<th width="80" orderField="method" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="opsDate" class="orderFlag" htype="date">
						落实措施日期
					</th>
					<th width="80" orderField="hospitalAddress" class="orderFlag">
						手术地点
					</th>
					<th width="80" orderField="repairMethod" class="orderFlag" htype="dict">
						补救措施
					</th>
					<th width="80" orderField="repairDate" class="orderFlag" htype="date">
						补救措施时间
					</th>
					<th width="80" orderField="repairAddress" class="orderFlag">
						补救措施地点
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
							<tags:js.dict.getValue value="${a.method}"/>
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.hospitalAddress}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.repairMethod}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.repairDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.repairAddress}
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
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>