<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/security/runlog!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_runlogmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>更新时间：</label>
					<input name="updateTime" class="date  required " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${updateTime}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>业务名称：</label>
					<input name="bussName" class="digits" type="text" size="30" value="${bussName}"/>
					</p>
																													<p>
					<label>类：</label>
					<input name="bussClass"    type="text" size="30" value="${bussClass}" />
					</p>
																													<p>
					<label>方法：</label>
					<input name="bussMethod"    type="text" size="30" value="${bussMethod}" />
					</p>
																													<p>
					<label>持续时间：</label>
					<input name="lastTime" class="digits" type="text" size="30" value="${lastTime}"/>
					</p>
																													<p>
					<label>备注：</label>
					<input name="remark"    type="text" size="30" value="${remark}" />
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