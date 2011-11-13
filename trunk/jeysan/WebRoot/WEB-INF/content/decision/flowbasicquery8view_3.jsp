<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery8view.action">
	<input type="hidden" name="type" value="${param['type']}" />
	<input type="hidden" name="filter_EQS_area"
		value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />


	<input type="hidden" name="filter_LIKES_domicile" value="${param['filter_LIKES_domicile']}" />
	<input type="hidden" name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" />
	<input type="hidden" name="filter_EQI_sex" value="${param['filter_EQI_sex']}" />
	<input type="hidden" name="filter_GED_issDate" value="${param['filter_GED_issDate']}" />
	<input type="hidden" name="filter_LED_issDate" value="${param['filter_LED_issDate']}" />
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
							发证日期：
							<input type="text" name="filter_GED_issDate" class="date"
								readonly="true" value="${param.filter_GED_issDate}" />
							~
							<input type="text" name="filter_LED_issDate" class="date"
								readonly="true" value="${param.filter_LED_issDate}" />
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
						href="javascript:JS_print2('办理国证临时证情况')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="200%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="certCode" class="orderFlag">
						计生证号
					</th>
					<th width="80" orderField="personCode" class="orderFlag">
						人员编号
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						持证人姓名
					</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="code" class="orderFlag">
						身份证号码
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地址
					</th>
					<th width="80" orderField="issOrg" class="orderFlag">
						发证机关
					</th>
					<th width="80" orderField="issDate" class="orderFlag" htype="date">
						发证日期
					</th>
					<th width="80" orderField="validPeroid" class="orderFlag" htype="date">
						有效期
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
							${a.certCode}
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
							${a.domicile}
						</td>
						<td>
							${a.issOrg}
						</td>
						<td>
							<fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.validPeroid}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>