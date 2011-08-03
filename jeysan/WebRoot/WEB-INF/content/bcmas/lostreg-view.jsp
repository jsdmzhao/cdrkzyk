<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>轮次ID：</label>
					<input name="detailId" readonly="readonly" type="text" size="30" value="${detailId}"/>
					</p>
																														<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" readonly="readonly" type="text" size="30" value="${womanId}"/>
					</p>
																														<p>
					<label>漏查处理情况：</label>
					<input name="ldwStatus" readonly="readonly" type="text" size="30" value="${ldwStatus}"/>
					</p>
																														<p>
					<label>处理措施：</label>
					<input name="ldwContent" readonly="readonly" type="text" size="30" value="${ldwContent}"/>
					</p>
																														<p>
					<label>处理时间：</label>
					<input name="ldwDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${ldwDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>违约金：</label>
					<input name="moneyh" readonly="readonly" type="text" size="30" value="${moneyh}"/>
					</p>
																														<p>
					<label>交款日期：</label>
					<input name="payDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${payDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>收款人：</label>
					<input name="cashier" readonly="readonly" type="text" size="30" value="${cashier}"/>
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
