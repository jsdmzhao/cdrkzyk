<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form id="form4" method="post"
			action="${ctx}/bcmas/womanupbringdetail!saveDetails.action"
			class="pageForm"
			 onsubmit="return validateSubs(this);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="upbringId" value="${upbring.id}" />
			<input type="hidden" name="factMoneyOld" value="${factMoney}" />
			<input type="hidden" name="upbring.fertileWoman.id"
				value="${upbring.fertileWoman.id}" />
			<!-- <input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="womanUpbringDetail-update" />
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

				<div class="panelBar">
					<ul class="toolBar">
						<li>
							<a class="add" href="javascript:" onclick="operateRow('add')"><span>增加一行缴费记录</span>
							</a>
						</li>
						<li>
							<a class="delete" href="javascript:"
								onclick="operateRow('delete')"><span>减少一行缴费记录</span> </a>
						</li>
					</ul>
				</div>

				<table class="list" width="98%">
					<thead>
						<tr>
							<th width="10%" style="text-align: center">
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
						</tr>
					</thead>
					<tbody id="tr_list">
						<c:forEach var="a" items="${upbring.detailList}" varStatus="b">
							<tr target="rowIndex" rel="${b.index+1}">
								<td style="text-align: center">
									<span>${b.index+1}</span>
									<input type="hidden" name="detailId" value="${a.id}" />
								</td>
								<td>
									<input type="text" name="moneyh_${b.index+1}"
										class="required number" size="15" value="${a.moneyh}" />
								</td>
								<td>
									<input type="text" name="factMoney_${b.index+1}"
										class="required number" size="15" value="${a.factMoney}" />
								</td>
								<td>
									<input type="text" name="charger_${b.index+1}" size="15"
										value="${a.charger}" />
								</td>
								<td>
									<input type="text" name="dateh_${b.index+1}" class="date"
										size="15" value="<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/>" />
									<a class="inputDateButton" href="javascript:;">选择</a>
								</td>
								<td>
									<input type="text" name="voucherCode_${b.index+1}" size="15"
										value="${a.voucherCode}" />
								</td>
							</tr>
						</c:forEach>
						<c:if test="${fn:length(upbring.detailList)==0}">
							<tr target="rowIndex" rel="1">
								<td style="text-align: center">
									<span>1</span>
									<input type="hidden" name="detailId" value="-1" />
								</td>
								<td>
									<input type="text" name="moneyh_1" class="required number"
										size="15" />
								</td>
								<td>
									<input type="text" name="factMoney_1" class="required number"
										size="15" />
								</td>
								<td>
									<input type="text" name="charger_1" size="15" />
								</td>
								<td>
									<input type="text" name="dateh_1" class="date" size="15" />
									<a class="inputDateButton" href="javascript:;">选择</a>
								</td>
								<td>
									<input type="text" name="voucherCode_1" size="15" />
								</td>
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
								<button type="Button" onclick="navTab.reload()">
									重置
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
