<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery1view.action">	
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" />
	<input type="hidden" name="filter_EQI_method" value="${param['filter_EQI_method']}" />
	<input type="hidden" name="filter_GED_birthday" value="${param['filter_GED_birthday']}" />
	<input type="hidden" name="filter_LED_birthday" value="${param['filter_LED_birthday']}" />
	<input type="hidden" name="filter_EQS_domicileCode" value="${param['filter_EQS_domicileCode']}" />
	<input type="hidden" name="filter_LIKES_address" value="${param['filter_LIKES_address']}" />
	<input type="hidden" name="filter_GED_firstMarryDate" value="${param['filter_GED_firstMarryDate']}" />
	<input type="hidden" name="filter_LED_firstMarryDate" value="${param['filter_LED_firstMarryDate']}" />
	<input type="hidden" name="filter_EQI_haveStatus2" value="${param['filter_EQI_haveStatus2']}" />
	<input type="hidden" name="filter_EQI_childNum" value="${param['filter_EQI_childNum']}" />
	<input type="hidden" name="filter_GED_inDate" value="${param['filter_GED_inDate']}" />
	<input type="hidden" name="filter_LED_inDate" value="${param['filter_LED_inDate']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery1view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							婚姻状况：
<tags:js.dict.selector name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" dictCode="JS1015" noRender="true"/>
						</td>
						<td>
							节育措施：
<tags:js.dict.selector name="filter_EQI_method" value="${param['filter_EQI_method']}" dictCode="JS1018" noRender="true"/>
						</td>
						<td>
							出生日期：
							<input type="text" name="filter_GED_birthday" class="date" readonly="true" value="${param.filter_GED_birthday}"/>~<input type="text" name="filter_LED_birthday" class="date" readonly="true" value="${param.filter_LED_birthday}"/>
						</td>
					</tr>
					<tr>
						<td>
							户籍地：
<tags:js.district2.selector hasButton="false" name="filter_EQS_domicileCode" id="domicile" readonly="true" size="30" type="5" value="${param.filter_EQS_domicileCode}"></tags:js.district2.selector>
						</td>
						<td>
							居住地：
<input type="text" name="filter_LIKES_address" class="text" value="${param.filter_LIKES_address}"/>
						</td>
						<td>
							初婚日期：
							<input type="text" name="filter_GED_firstMarryDate" class="date" readonly="true" value="${param.filter_GED_firstMarryDate}"/>~<input type="text" name="filter_LED_firstMarryDate" class="date" readonly="true" value="${param.filter_LED_firstMarryDate}"/>
						</td>
					</tr>
					<tr>
						<td>
							持证情况：
<tags:js.dict.selector name="filter_EQI_haveStatus2" value="${param.filter_EQI_haveStatus2}" dictCode="JS1051" noRender="true"/>
						</td>
						<td>
							子女数：
<input type="text" name="filter_EQI_childNum" class="text digits" value="${param.filter_EQI_childNum}"/>
						</td>
						<td>
							流入日期：
							<input type="text" name="filter_GED_inDate" class="date" readonly="true" value="${param.filter_GED_inDate}"/>~<input type="text" name="filter_LED_inDate" class="date" readonly="true" value="${param.filter_LED_inDate}"/>
						</td>
					</tr>
					<tr>
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
					<a class="icon" href="javascript:JS_print2('流入人员基本信息')"><span>打印或者导出</span>
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
						流动人口编码
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">
						出生日期
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="marryCryDate" class="orderFlag" htype="date">
						最近婚变日期
					</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						子女数
					</th>
					<th width="80" orderField="inCause" class="orderFlag" htype="dict">
						流入原因
					</th>
					<th width="80" orderField="inDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="haveStatus2" class="orderFlag" htype="dict">
						是否持证
					</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="haveStatus" class="orderFlag" htype="dict">
						配偶是否持证
					</th>
					<th width="80" orderField="isFamilyAllIn" class="orderFlag" htype="bool">
						是否共同流入
					</th>
					<th width="80" orderField="tel" class="orderFlag">
						联系电话
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
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.marryCryDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.inCause}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.inDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.haveStatus2}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.method}"/>
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.haveStatus}"/>
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.isFamilyAllIn}"/>
						</td>
						<td>
							${a.tel}
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>