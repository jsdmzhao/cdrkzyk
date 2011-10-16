<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery2view.action">
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQI_outType" value="${param['filter_EQI_outType']}" />
	<input type="hidden" name="filter_GED_outDate" value="${param['filter_GED_outDate']}" />
	<input type="hidden" name="filter_LED_outDate" value="${param['filter_LED_outDate']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery2view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							流出日期：
							<input type="text" name="filter_GED_outDate" class="date" readonly="true" value="${param.filter_GED_outDate}"/>~<input type="text" name="filter_LED_outDate" class="date" readonly="true" value="${param.filter_LED_outDate}"/>
						</td>
						<td>
							流出人员类型：
<tags:js.dict.selector name="filter_EQI_outType" value="${param['filter_EQI_outType']}" dictCode="JS1047" noRender="true"/>
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
						href="javascript:JS_print2('流出人员基本信息')"><span>打印或者导出</span>
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
						流动人口编码
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="120" orderField="code" class="orderFlag">
						证件号码
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
					<th width="80" orderField="method" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="inAddress" class="orderFlag">
						流入地
					</th>
					<th width="80" orderField="outDate" class="orderFlag" htype="date">
						流出日期
					</th>
					<th width="80" orderField="haveStatus" class="orderFlag" htype="dict">
						是否持证
					</th>
					<th width="80" orderField="outType" class="orderFlag" htype="dict">
						流出类型
					</th>
					<th width="80" orderField="isFamilyAllOut" class="orderFlag" htype="bool">
						夫妻是否共同流出
					</th>
					<th width="80" orderField="remark" class="orderFlag">
						备注
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
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"/>
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.method}"/>
						</td>
						<td>
							${a.inAddress}
						</td>
						<td>
							<fmt:formatDate value="${a.outDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.haveStatus}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.outType}"/>
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.isFamilyAllOut}"/>
						</td>
						<td>
							${a.remark}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>