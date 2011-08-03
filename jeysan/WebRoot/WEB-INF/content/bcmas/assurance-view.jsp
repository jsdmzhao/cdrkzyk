<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" readonly="readonly" type="text" size="30" value="${womanId}"/>
					</p>
																														<p>
					<label>保险类型：</label>
					<input name="assType" readonly="readonly" type="text" size="30" value="${assType}"/>
					</p>
																														<p>
					<label>投保情况：</label>
					<input name="assStatus" readonly="readonly" type="text" size="30" value="${assStatus}"/>
					</p>
																														<p>
					<label>投保类型：</label>
					<input name="assKind" readonly="readonly" type="text" size="30" value="${assKind}"/>
					</p>
																														<p>
					<label>投保日期：</label>
					<input name="assDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${assDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>被保险人：</label>
					<input name="insured" readonly="readonly" type="text" size="30" value="${insured}"/>
					</p>
																														<p>
					<label>投保人：</label>
					<input name="applicant" readonly="readonly" type="text" size="30" value="${applicant}"/>
					</p>
																														<p>
					<label>保险收益人：</label>
					<input name="insurant" readonly="readonly" type="text" size="30" value="${insurant}"/>
					</p>
																														<p>
					<label>投保金额：</label>
					<input name="insuredAmount" readonly="readonly" type="text" size="30" value="${insuredAmount}"/>
					</p>
																														<p>
					<label>收款人：</label>
					<input name="cashier" readonly="readonly" type="text" size="30" value="${cashier}"/>
					</p>
																														<p>
					<label>取消保险日期：</label>
					<input name="cancelDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>取消保险原因：</label>
					<input name="cancelCause" readonly="readonly" type="text" size="30" value="${cancelCause}"/>
					</p>
																														<p>
					<label>退还金额：</label>
					<input name="returnAmount" readonly="readonly" type="text" size="30" value="${returnAmount}"/>
					</p>
																														<p>
					<label>退款人：</label>
					<input name="returner" readonly="readonly" type="text" size="30" value="${returner}"/>
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
