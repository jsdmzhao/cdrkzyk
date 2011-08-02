<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/womanbearassurance!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_womanbearassurancemanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" class="digits  required" type="text" size="30" value="${womanId}"/>
					</p>
																													<p>
					<label>投保类型：</label>
					<input name="typeh"    type="text" size="30" value="${typeh}" />
					</p>
																													<p>
					<label>投保年月：</label>
					<input name="dateh"    type="text" size="30" value="${dateh}" />
					</p>
																													<p>
					<label>投保金额：</label>
					<input name="moneyh" class="digits" type="text" size="30" value="${moneyh}"/>
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