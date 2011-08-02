<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/villagerteam!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_villagerteammanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>行政区编码：</label>
					<input name="orgCode"    type="text" size="30" value="${orgCode}" />
					</p>
																													<p>
					<label>小组名称：</label>
					<input name="teamName"    type="text" size="30" value="${teamName}" />
					</p>
																													<p>
					<label>小组序号：</label>
					<input name="teamIndex" class="digits" type="text" size="30" value="${teamIndex}"/>
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