<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery7view.action">
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQS_personCode" value="${param['filter_EQS_personCode']}" />
	<input type="hidden" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQI_sex" value="${param['filter_EQI_sex']}" />
	<input type="hidden" name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" />
	<input type="hidden" name="filter_LIKES_domicile" value="${param['filter_LIKES_domicile']}" />
	<input type="hidden" name="filter_GED_settleInDate" value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate" value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_EQI_method" value="${param['filter_EQI_method']}" />
	<input type="hidden" name="filter_GED_birthday" value="${param['filter_GED_birthday']}" />
	<input type="hidden" name="filter_LED_birthday" value="${param['filter_LED_birthday']}" />
	<input type="hidden" name="filter_GED_opsDate" value="${param['filter_GED_opsDate']}" />
	<input type="hidden" name="filter_LED_opsDate" value="${param['filter_LED_opsDate']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery7view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr><td>
							编号：
<input type="text" name="filter_EQS_personCode" class="text" value="${param.filter_EQS_personCode}"/>
						</td>
						<td>
							姓名：
<input type="text" name="filter_LIKES_nameh" class="text" value="${param.filter_LIKES_nameh}"/>
						</td>
						<td>
							性别：
<tags:js.dict.selector name="filter_EQI_sex" value="${param['filter_EQI_sex']}" dictCode="JS010" noRender="true"/>
						</td>
						<td>
							婚姻状况：
<tags:js.dict.selector name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" dictCode="JS1015" noRender="true"/>
						</td>
</tr><tr>
						<td colspan="2">
							流入日期：
<input type="text" name="filter_GED_settleInDate" class="date" readonly="true" value="${param.filter_GED_settleInDate}"/>~<input type="text" name="filter_LED_settleInDate" class="date" readonly="true" value="${param.filter_LED_settleInDate}"/>
						</td>
						<td colspan="2">
							出生日期：
<input type="text" name="filter_GED_birthday" class="date" readonly="true" value="${param.filter_GED_birthday}"/>~<input type="text" name="filter_LED_birthday" class="date" readonly="true" value="${param.filter_LED_birthday}"/>
						</td>
</tr><tr>
						<td>
							户籍地：
<input type="text" name="filter_LIKES_domicile" class="text" value="${param.filter_LIKES_domicile}"/>
						</td>						<td>
							避孕节育措施：
<tags:js.dict.selector name="filter_EQI_method" value="${param['filter_EQI_method']}" dictCode="JS1018" noRender="true"/>
						</td>
						<td colspan="2">
							落实措施日期：
<input type="text" name="filter_GED_opsDate" class="date" readonly="true" value="${param.filter_GED_opsDate}"/>~<input type="text" name="filter_LED_opsDate" class="date" readonly="true" value="${param.filter_LED_opsDate}"/>
						</td>
</tr><tr>
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
						href="javascript:JS_print2('当前夫妇避孕节育情况')"><span>打印或者导出</span>
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
						流动人口编号
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">
						出生日期
					</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="opsDate" class="orderFlag" htype="date">
						落实日期
					</th>
					<th width="80" orderField="noCause" class="orderFlag">
						未避孕原因
					</th>
					<th width="80" orderField="settleInDate" class="orderFlag" htype="date">
						流入日期
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
					<th width="80" orderField="birthday2" class="orderFlag" htype="date">
						最小孩出生日期
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
							<tags:js.dict.getValue value="${a.sex}"/>
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.method}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.noCause}
						</td>
						<td>
							<fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd" />
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
						<td>
							<fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>