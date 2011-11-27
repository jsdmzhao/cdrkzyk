<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/lostreg!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_lostregmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>双查对象ID：</label>
					<input name="dcbId" class="digits  required" type="text" size="30" value="${dcbId}"/>
					</p>
																													<p>
					<label>漏查处理情况：</label>
					<input name="ldwStatus" class="digits" type="text" size="30" value="${ldwStatus}"/>
					</p>
																													<p>
					<label>处理措施：</label>
					<input name="ldwContent"    type="text" size="30" value="${ldwContent}" />
					</p>
																													<p>
					<label>处理时间：</label>
					<input name="ldwDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${ldwDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																													<p>
					<label>违约金：</label>
					<input name="moneyh" class="digits" type="text" size="30" value="${moneyh}"/>
					</p>
																													<p>
					<label>交款日期：</label>
					<input name="payDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${payDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																													<p>
					<label>收款人：</label>
					<input name="cashier"    type="text" size="30" value="${cashier}" />
					</p>
																	</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>