<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/pmas/house.action">
	<input type="hidden" name="type" value="${param['type']}" />
	<input type="hidden" name="filter_EQS_houseCode"
		value="${param['filter_EQS_houseCode']}" />
	<input type="hidden" name="filter_EQI_houseType"
		value="${param['filter_EQI_houseType']}" />
	<input type="hidden" name="filter_EQI_houseAtt"
		value="${param['filter_EQI_houseAtt']}" />
	<input type="hidden" name="filter_LIKES_ownerName"
		value="${param['filter_LIKES_ownerName']}" />
	<input type="hidden" name="filter_EQS_housePoliceNo"
		value="${param['filter_EQS_housePoliceNo']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/pmas/house.action" method="post">
	<input type="hidden" name="type" value="${param['type']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							业主姓名：
							<input type="text" name="filter_LIKES_ownerName"
								value="${param['filter_LIKES_ownerName']}" />
						</td>
						<td>
							居住地类型：
							<tags:js.dict.selector noRender="true"
								name="filter_EQI_houseType"
								value="${param['filter_EQI_houseType']}" dictCode="JS1038" />
						</td>
						<td>
							房屋编号：
							<input type="text" name="filter_EQS_houseCode"
								value="${param['filter_EQS_houseCode']}" />
						</td>
						<td>
							公安牌号：
							<input type="text" name="filter_EQS_housePoliceNo"
								value="${param['filter_EQS_housePoliceNo']}" />
						</td>
						<td>
							居住地属性：
							<tags:js.dict.selector noRender="true" name="filter_EQI_houseAtt"
								value="${param['filter_EQI_houseAtt']}" dictCode="JS1039" />
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
					<a class="icon" href="javascript:JS_print2('居住地基本信息')"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="150%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="houseCode" class="orderFlag">
						房屋编号
					</th>
					<th width="80" orderField="housePoliceNo" class="orderFlag">
						公安牌号
					</th>
					<th width="80" orderField="houseType" class="orderFlag" htype="dict">
						居住地类型
					</th>
					<th width="120" orderField="houseAtt" class="orderFlag" htype="dict">
						居住地属性
					</th>
					<th width="120" orderField="personCount" class="orderFlag" htype="digits">
						居住人数
					</th>
					<th width="120" orderField="detailAddress" class="orderFlag">
						详细地址
					</th>
					<th width="80" orderField="ownerAddress" class="orderFlag">
						业主居住地址
					</th>
					<th width="80" orderField="ownerName" class="orderFlag">
						业主姓名
					</th>
					<th width="120" orderField="ownerTel" class="orderFlag">
						业主电话
					</th>
					<th width="80" orderField="bcsDate" class="orderFlag" htype="date">
						计生责任书签订日期
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
							${a.houseCode}
						</td>
						<td>
							${a.housePoliceNo}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.houseType}" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.houseAtt}" />
						</td>
						<td>
							${a.personCount}
						</td>
						<td>
							${a.detailAddress}
						</td>
						<td>
							${a.ownerAddress}
						</td>
						<td>
							${a.ownerName}
						</td>
						<td>
							${a.ownerTel}
						</td>
						<td>
							<fmt:formatDate value="${a.bcsDate}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>