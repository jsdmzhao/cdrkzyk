<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/security/post!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_postmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>职务名称：</label>
					<input name="postName"  class="required" maxlength="50"    type="text" size="30" value="${postName}"  alt="请输入职务名称" />
					</p>
																													<p>
					<label>职务编码：</label>
					<input name="postCode"  class="required" maxlength="20"    type="text" size="30" value="${postCode}"  alt="请输入职务编码" />
					</p>
																													<p>
					<label>是否有效：</label>
					<tags:js.yes.no.selector name="postEnabled" value="${postEnabled}"></tags:js.yes.no.selector>
					</p>
																													<p>
					<label>职责：</label>
					<input name="postContent"    type="text" size="30" value="${postContent}" />
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