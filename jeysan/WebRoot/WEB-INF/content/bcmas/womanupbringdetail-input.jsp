<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/womanupbringdetail!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_womanupbringdetailmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>UPBRING_ID：</label>
					<input name="upbringId" class="digits  required" type="text" size="30" value="${upbringId}"/>
					</p>
																													<p>
					<label>缴款序号：</label>
					<input name="count" class="digits" type="text" size="30" value="${count}"/>
					</p>
																													<p>
					<label>本次应缴金额：</label>
					<input name="moneyh" class="digits" type="text" size="30" value="${moneyh}"/>
					</p>
																													<p>
					<label>收款人：</label>
					<input name="charger"    type="text" size="30" value="${charger}" />
					</p>
																													<p>
					<label>交款日期：</label>
					<input name="dateh" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>收据编号：</label>
					<input name="voucherCode"    type="text" size="30" value="${voucherCode}" />
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