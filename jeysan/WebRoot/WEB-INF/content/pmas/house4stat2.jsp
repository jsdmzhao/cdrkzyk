<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/pmas/house.action">
	<input type="hidden" name="type" value="${param['type']}" />
	<input type="hidden" name="filter_EQS_houseCode"
		value="${param['filter_EQS_houseCode']}" />
	<input type="hidden" name="filter_LIKES_ownerAddress"
		value="${param['filter_LIKES_ownerAddress']}" />
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
							居住地地址：
							<input type="text" name="filter_LIKES_ownerAddress"
								value="${param['filter_LIKES_ownerAddress']}" />
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
					<a class="icon" href="javascript:JS_print2('业主情况')"><span>打印或导出</span>
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
					<th width="80" orderField="ownerName" class="orderFlag">
						业主姓名
					</th>
					<th width="80" orderField="ownerSex" class="orderFlag" htype="dict">
						业主性别
					</th>
					<th width="80" orderField="ownerAddress" class="orderFlag">
						业主居住地址
					</th>
					<th width="80" orderField="ownerCompany" class="orderFlag">
						业主工作单位
					</th>
					<th width="120" orderField="ownerTel" class="orderFlag">
						业主电话
					</th>
					<th width="120" orderField="agentName" class="orderFlag">
						代管人姓名
					</th>
					<th width="120" orderField="agentSex" class="orderFlag" htype="dict">
						代管人性别
					</th>
					<th width="120" orderField="agentTel" class="orderFlag">
						代管人电话
					</th>
					<th width="120" orderField="personCount" class="orderFlag" htype="digits">
						居住人数
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
							${a.ownerName}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.ownerSex}" />
						</td>
						<td>
							${a.ownerAddress}
						</td>
						<td>
							${a.ownerCompany}
						</td>
						<td>
							${a.ownerAddress}
						</td>
						<td>
							${a.ownerTel}
						</td>
						<td>
							${a.agentName}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.agentSex}" />
						</td>
						<td>
							${a.personCount}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>