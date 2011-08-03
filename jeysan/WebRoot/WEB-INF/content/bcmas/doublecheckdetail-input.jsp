<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/doublecheckdetail!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_doublecheckdetailmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>批次ID：</label>
					<input name="dcId" class="digits  required" type="text" size="30" value="${dcId}"/>
					</p>
																													<p>
					<label>轮次：</label>
					<input name="seq" class="digits" type="text" size="30" value="${seq}"/>
					</p>
																													<p>
					<label>起始年月：</label>
					<input name="start"    type="text" size="30" value="${start}" />
					</p>
																													<p>
					<label>结束年月：</label>
					<input name="end"    type="text" size="30" value="${end}" />
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