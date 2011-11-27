<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post"
			action="${ctx}/bcmas/womanupbringdetail!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="upbringId" value="${upbring.id}" />
			<input type="hidden" name="factMoneyOld" value="${factMoney}" />
			<input type="hidden" name="upbring.fertileWoman.id"
				value="${upbring.fertileWoman.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_womanupbringdetailmanage" />
			<div class="pageFormContent" layoutH="56">

				<p>
					<label>
						姓名：
					</label>
					<input name="womanId" readonly="readonly" type="text" size="30"
						value="${upbring.fertileWoman.nameh}" />
				</p>
				<p>
					<label>
						妇女编码：
					</label>
					<input name="womanId" readonly="readonly" type="text" size="30"
						value="${upbring.fertileWoman.code}" />
				</p>
				<p>
					<label>
						征收原因：
					</label>
					<input name="cause" readonly="readonly" type="text" size="30"
						value="${upbring.cause}" />
				</p>
				<p>
					<label>
						政策外生育日期：
					</label>
					<input name="outDate" readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${upbring.outDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						应交金额：
					</label>
					<input name="totalMoney" readonly="readonly" type="text" size="30"
						value="${upbring.totalMoney}" />
				</p>
				<p>
					<label>
						已交金额：
					</label>
					<input name="yetMoney" readonly="readonly" type="text" size="30"
						value="${upbring.yetMoney}" />
				</p>
				<p>
					<label>
						是否分期：
					</label>
					<input name="isInstallment" readonly="readonly" type="text"
						size="30"
						value="<tags:js.yes.no.getValue value="${upbring.isInstallment}"/>" />
				</p>
				<p>
					<label>
						分期数：
					</label>
					<input name="installmentNum" readonly="readonly" type="text"
						size="30" value="${upbring.installmentNum}" />
				</p>
				<p>
					<label>
						缴交期限：
					</label>
					<input name="endDate" readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${upbring.endDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						决定书编号：
					</label>
					<input name="lodCode" readonly="readonly" type="text" size="30"
						value="${upbring.lodCode}" />
				</p>
				<p>
					<label>
						决定书日期：
					</label>
					<input name="lodDate" readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${upbring.lodDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						征收机关：
					</label>
					<input name="lodOrg" readonly="readonly" type="text" size="30"
						value="${upbring.lodOrg}" />
				</p>
				<p>
					<label>
						征收经办人：
					</label>
					<input name="lodCharger" readonly="readonly" type="text" size="30"
						value="${upbring.lodCharger}" />
				</p>
				<p>
					<label>
						是否缴清：
					</label>
					<input name="isPayup" readonly="readonly" type="text" size="30"
						value="<tags:js.yes.no.getValue value="${upbring.isPayup}"/>" />
				</p>

				<div class="divider"></div>
				<table class="list" style="width: 100%">
					<thead>
						<tr>
							<th width="15%">
								缴款序号
							</th>
							<th width="20%">
								本次应缴金额
							</th>
							<th width="20%">
								实际缴纳金额
							</th>
							<th width="10%">
								收款人
							</th>
							<th width="15%">
								交款日期
							</th>
							<th width="10%">
								收据编号
							</th>
							<th width="10%" style="text-align: center">
								操作
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${upbring.detailList}" varStatus="b">
							<tr>
								<td style="text-align: center">
									<input name="counth_${b.index}" class="digits" type="text"
										size="15" value="${a.counth}" />
								</td>
								<td>
									<input name="moneyh_${b.index}" class="number" type="text"
										size="15" value="${a.moneyh}" />
								</td>
								<td>
									<input name="factMoney_${b.index}" class="number" type="text"
										size="15" value="${a.factMoney}" />
								</td>
								<td>
									<input name="charger_${b.index}" type="text" size="15"
										value="${a.charger}" />
								</td>
								<td>
									<input name="dateh_${b.index}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate "
										readonly="readonly" type="text" size="15"
										value="<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/>" />
									
								</td>
								<td>
									<input name="voucherCode_${b.index}" type="text" size="15"
										value="${a.voucherCode}" />
								</td>
								<td style="text-align: center">
									<div style="width: 25px;">
										<a class="btnDel" href="javascript:"
											onclick="javascript:$(this).parents('tr:first').remove();"
											title="删除行"></a>
									</div>
								</td>
							</tr>
						</c:forEach>
						<c:if test="${fn:length(upbring.detailList)==0}">
							<tr>
								<td style="text-align: center">
									1
								</td>
								<td></td>
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
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									保存
								</button>
							</div>
						</div>
					</li>
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
</div>