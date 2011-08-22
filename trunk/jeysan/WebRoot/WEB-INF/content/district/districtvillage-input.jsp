<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/district/districtvillage!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_districtvillagemanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>编码：</label>
					<input name="code"    type="text" size="30" value="${code}" />
					</p>
																													<p>
					<label>名称：</label>
					<input name="name"    type="text" size="30" value="${name}" />
					</p>
																													<p>
					<label>PARENT_ID：</label>
					<input name="parentId" class="digits" type="text" size="30" value="${parentId}"/>
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