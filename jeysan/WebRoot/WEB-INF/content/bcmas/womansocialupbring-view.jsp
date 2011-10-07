<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					姓名：
				</label>
				<input name="womanId" readonly="readonly" type="text" size="30"
					value="${fertileWoman.nameh}" />
			</p>
			<p>
				<label>
					妇女编码：
				</label>
				<input name="womanId" readonly="readonly" type="text" size="30"
					value="${fertileWoman.code}" />
			</p>
			<p>
				<label>
					征收原因：
				</label>
				<input name="cause" readonly="readonly" type="text" size="30"
					value="${cause}" />
			</p>
			<p>
				<label>
					政策外生育日期：
				</label>
				<input name="outDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${outDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					应交金额：
				</label>
				<input name="totalMoney" readonly="readonly" type="text" size="30"
					value="${totalMoney}" />
			</p>
			<p>
				<label>
					已交金额：
				</label>
				<input name="yetMoney" readonly="readonly" type="text" size="30"
					value="${yetMoney}" />
			</p>
			<p>
				<label>
					是否分期：
				</label>
				<input name="isInstallment" readonly="readonly" type="text"
					size="30" value="<tags:js.yes.no.getValue value="${isInstallment}"/>" />
			</p>
			<p>
				<label>
					分期数：
				</label>
				<input name="installmentNum" readonly="readonly" type="text"
					size="30" value="${installmentNum}" />
			</p>
			<p>
				<label>
					缴交期限：
				</label>
				<input name="endDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					决定书编号：
				</label>
				<input name="lodCode" readonly="readonly" type="text" size="30"
					value="${lodCode}" />
			</p>
			<p>
				<label>
					决定书日期：
				</label>
				<input name="lodDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${lodDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					征收机关：
				</label>
				<input name="lodOrg" readonly="readonly" type="text" size="30"
					value="${lodOrg}" />
			</p>
			<p>
				<label>
					征收机关类型：
				</label>
				<input name="lodType" readonly="readonly" type="text"
					size="30" value="<tags:js.dict.getValue value="${lodTYpe}"/>" />
			</p>
			<p>
				<label>
					征收经办人：
				</label>
				<input name="lodCharger" readonly="readonly" type="text" size="30"
					value="${lodCharger}" />
			</p>
			<p>
				<label>
					是否缴清：
				</label>
				<input name="isPayup" readonly="readonly" type="text"
					size="30" value="<tags:js.yes.no.getValue value="${isPayup}"/>" />
			</p>

<div class="divider"></div>
		<table class="list" style="width:100%">
			<thead>
				<tr>
					<th width="15%" style="text-align: center">缴款序号</th>
					<th width="20%">本次应缴金额</th>
					<th width="20%">实际缴纳金额</th>
					<th width="15%">收款人</th>
					<th width="15%">交款日期</th>
					<th width="15%">收据编号</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${detailList}">
				<tr>
					<td style="text-align: center">${a.counth}</td>
					<td>${a.moneyh}</td>
					<td>${a.factMoney}</td>
					<td>${a.charger}</td>
					<td><fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/></td>
					<td>${a.voucherCode}</td>
				</tr>
				</c:forEach>
				<c:if test="${fn:length(detailList)==0}">
				<tr>
					<td style="text-align: center">1</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
			</tbody>
		</table>	

		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="Button" onclick="navTab.closeCurrentTab()">
								取消
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
