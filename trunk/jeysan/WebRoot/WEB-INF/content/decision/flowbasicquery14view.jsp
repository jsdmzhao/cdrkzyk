<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery14view.action">
	<input type="hidden" name="filter_EQS_area"
		value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />


	<input type="hidden" name="filter_LIKES_nameh"
		value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_LIKES_nameh2"
		value="${param['filter_LIKES_nameh2']}" />
	<input type="hidden" name="filter_EQS_code"
		value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_EQS_personCode"
		value="${param['filter_EQS_personCode']}" />
	<input type="hidden" name="filter_GED_cancelDate"
		value="${param['filter_GED_cancelDate']}" />
	<input type="hidden" name="filter_GED_cancelDate"
		value="${param['filter_GED_cancelDate']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery14view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_nameh"
								value="${param['filter_LIKES_nameh']}" />
						</td>
						<td>
							身份证号：
							<input type="text" name="filter_EQS_code"
								value="${param['filter_EQS_code']}" />
						</td>
						<td>
							人员编码：
							<input type="text" name="filter_EQS_personCode"
								value="${param['filter_EQS_personCode']}" />
						</td>
						<td>
							配偶姓名：
							<input type="text" name="filter_LIKES_nameh2"
								value="${param['filter_LIKES_nameh2']}" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							注销日期：
							<input type="text" name="filter_GED_cancelDate" class="date"
								readonly="true" value="${param.filter_GED_cancelDate}" />
							~
							<input type="text" name="filter_LED_cancelDate" class="date"
								readonly="true" value="${param.filter_LED_cancelDate}" />
						</td>
						<td>
							所属区域：
							<tags:js.area.selector name="filter_EQS_area" readonly="true"
								value="${param['filter_EQS_area']}" size="20"></tags:js.area.selector>
						</td><td></td>
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
						href="javascript:JS_print2('已注销流入人员查询')"><span>打印或者导出</span>
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
						人员编码
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
					<th width="80" orderField="code" class="orderFlag">
						身份证号码
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
						落实措施日期
					</th>
					<th width="80" orderField="inDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="dateh" class="orderFlag" htype="date">
						流出日期
					</th>
					<th width="80" orderField="cancelDate" class="orderFlag" htype="date">
						注销日期
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="address" class="orderFlag">
						现居住地址
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
							${a.code}
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
							<fmt:formatDate value="${a.inDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.cancelDate}" pattern="yyyy-MM-dd" />
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