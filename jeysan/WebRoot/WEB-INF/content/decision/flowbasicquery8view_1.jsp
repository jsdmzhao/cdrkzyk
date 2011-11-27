<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery8view.action">
	<input type="hidden" name="type" value="${param['type']}" />
	<input type="hidden" name="filter_EQS_area"
		value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />


	<input type="hidden" name="filter_GED_settleInDate" value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate" value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_LIKES_domicile" value="${param['filter_LIKES_domicile']}" />
	<input type="hidden" name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" />
	<input type="hidden" name="filter_EQI_sex" value="${param['filter_EQI_sex']}" />
	<input type="hidden" name="filter_GED_dateh" value="${param['filter_GED_dateh']}" />
	<input type="hidden" name="filter_LED_dateh" value="${param['filter_LED_dateh']}" />
	<input type="hidden" name="filter_EQI_haveStatus" value="${param['filter_EQI_haveStatus']}" />
	<input type="hidden" name="filter_EQL_childnum" value="${param['filter_EQL_childnum']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery8view.action" method="post">
			<input type="hidden" name="filter_EQI_domicileType"
				value="${param['filter_EQI_domicileType']}" />
			<input type="hidden" name="type" value="${param['type']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td colspan="2">
							流入日期：
							<input type="text" name="filter_GED_settleInDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param.filter_GED_settleInDate}" />
							~
							<input type="text" name="filter_LED_settleInDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param.filter_LED_settleInDate}" />
						</td>
						<td>
							户籍地：
							<input type="text" name="filter_LIKES_domicile" class="text"
								value="${param.filter_LIKES_domicile}" />
						</td>
						<td>
							婚姻状况：
							<tags:js.dict.selector name="filter_EQI_marryStatus"
								value="${param['filter_EQI_marryStatus']}" dictCode="JS1015"
								noRender="true" />
						</td>
						<td>
							性别：
							<tags:js.dict.selector name="filter_EQI_sex"
								value="${param['filter_EQI_sex']}" dictCode="JS010"
								noRender="true" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							验证日期：
							<input type="text" name="filter_GED_dateh" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param.filter_GED_dateh}" />
							~
							<input type="text" name="filter_LED_dateh" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param.filter_LED_dateh}" />
						</td>
						<td>
							持证情况：
							<tags:js.dict.selector name="filter_EQI_haveStatus"
								value="${param['filter_EQI_haveStatus']}" dictCode="JS1051"
								noRender="true" />
						</td>
						<td>
							子女数：
							<input type="text" name="filter_EQL_childnum" class="text"
								value="${param.filter_EQL_childnum}" />
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
						href="javascript:JS_print2('流入人员持证验证情况')"><span>打印或者导出</span>
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
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="code" class="orderFlag">
						身份证号
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="settleInDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="haveStatus" class="orderFlag" htype="dict">
						持证情况
					</th>
					<th width="80" orderField="certCode" class="orderFlag">
						计生证号
					</th>
					<th width="80" orderField="validPeroid" class="orderFlag" htype="date">
						有效期
					</th>
					<th width="80" orderField="dateh" class="orderFlag" htype="date">
						验证日期
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
							<tags:js.dict.getValue value="${a.sex}"/>
						</td>
						<td>
							${a.code}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.haveStatus}"/>
						</td>
						<td>
							${a.certCode}
						</td>
						<td>
							<fmt:formatDate value="${a.validPeroid}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />
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