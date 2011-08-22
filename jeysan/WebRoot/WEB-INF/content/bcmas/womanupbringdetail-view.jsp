<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>UPBRING_ID：</label>
					<input name="upbringId" readonly="readonly" type="text" size="30" value="${upbringId}"/>
					</p>
																														<p>
					<label>缴款序号：</label>
					<input name="count" readonly="readonly" type="text" size="30" value="${counth}"/>
					</p>
																														<p>
					<label>本次应缴金额：</label>
					<input name="moneyh" readonly="readonly" type="text" size="30" value="${moneyh}"/>
					</p>
																														<p>
					<label>收款人：</label>
					<input name="charger" readonly="readonly" type="text" size="30" value="${charger}"/>
					</p>
																														<p>
					<label>交款日期：</label>
					<input name="dateh" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>收据编号：</label>
					<input name="voucherCode" readonly="readonly" type="text" size="30" value="${voucherCode}"/>
					</p>
																		</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
</div>
