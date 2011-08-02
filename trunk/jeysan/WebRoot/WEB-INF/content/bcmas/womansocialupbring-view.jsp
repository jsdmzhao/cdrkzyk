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
					<label>征收原因：</label>
					<input name="cause" readonly="readonly" type="text" size="30" value="${cause}"/>
					</p>
																														<p>
					<label>政策外生育日期：</label>
					<input name="outDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${outDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>应交金额：</label>
					<input name="totalMoney" readonly="readonly" type="text" size="30" value="${totalMoney}"/>
					</p>
																														<p>
					<label>是否分期：</label>
					<input name="isInstallment" readonly="readonly" type="text" size="30" value="${isInstallment}"/>
					</p>
																														<p>
					<label>缴交期限：</label>
					<input name="endDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>决定书编号：</label>
					<input name="lodCode" readonly="readonly" type="text" size="30" value="${lodCode}"/>
					</p>
																														<p>
					<label>决定书日期：</label>
					<input name="lodDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${lodDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>征收机关：</label>
					<input name="lodOrg" readonly="readonly" type="text" size="30" value="${lodOrg}"/>
					</p>
																														<p>
					<label>征收经办人：</label>
					<input name="lodCharger" readonly="readonly" type="text" size="30" value="${lodCharger}"/>
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
