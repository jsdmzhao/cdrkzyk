<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery12view.action">
	<input type="hidden" name="filter_EQS_area"
		value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_GED_settleInDate"
		value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate"
		value="${param['filter_LED_settleInDate']}" />

	<input type="hidden" name="filter_EQI_inType"
		value="${param['filter_EQI_inType']}" />
	<input type="hidden" name="filter_LIKES_domicile"
		value="${param['filter_LIKES_domicile']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery12view.action" method="post">
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
						<td>
							流入人员类型：
<tags:js.dict.selector name="filter_EQI_inType" value="${param['filter_EQI_inType']}" dictCode="JS1046" noRender="true"/>
						</td>
						<td>
							户籍地：
							<input type="text" name="filter_LIKES_domicile"
								value="${param['filter_LIKES_domicile']}" />
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
						href="javascript:JS_print2('来源地情况查询')"><span>打印或者导出</span>
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
					<th width="80" orderField="personCode" class="orderFlag">
						人员编号
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地地址
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						性别
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
					<th width="80" orderField="dateh" class="orderFlag" htype="date">
						最小孩出生日期
					</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="opsDate" class="orderFlag" htype="date">
						落实措施日期
					</th>
					<th width="80" orderField="inDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="haveStatus" class="orderFlag" htype="dict">
						持证情况
					</th>
					<th width="80" orderField="certCode" class="orderFlag">
						计生证号码
					</th>
					<th width="80" orderField="dateh2" class="orderFlag" htype="date">
						验证日期
					</th>
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="isFamilyAllIn" class="orderFlag" htype="bool">
						是否同来
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
							${a.domicile}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.sex}"/>
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
							<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.method}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.inDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.haveStatus}"/>
						</td>
						<td>
							${a.certCode}
						</td>
						<td>
							<fmt:formatDate value="${a.dateh2}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.isFamilyAllIn}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>