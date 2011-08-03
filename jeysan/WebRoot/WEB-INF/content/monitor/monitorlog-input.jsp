<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/monitor/monitorlog!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_monitorlogmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>操作时间：</label>
					<input name="operatTime" class="date  required " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${operatTime}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>操作人：</label>
					<input name="operator" class="digits" type="text" size="30" value="${operator}"/>
					</p>
																													<p>
					<label>操作人IP：</label>
					<input name="operatIp"    type="text" size="30" value="${operatIp}" />
					</p>
																													<p>
					<label>操作内容：</label>
					<input name="content"    type="text" size="30" value="${content}" />
					</p>
																													<p>
					<label>持续时间(S)：</label>
					<input name="lastTime" class="digits" type="text" size="30" value="${lastTime}"/>
					</p>
																													<p>
					<label>影响行数：</label>
					<input name="effectRows" class="digits" type="text" size="30" value="${effectRows}"/>
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