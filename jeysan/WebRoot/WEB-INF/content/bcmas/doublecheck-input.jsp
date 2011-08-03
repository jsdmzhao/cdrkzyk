<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/doublecheck!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_doublecheckmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>每年双查次数：</label>
					<input name="count" class="digits" type="text" size="30" value="${count}"/>
					</p>
																													<p>
					<label>轮次起始年月：</label>
					<input name="start"    type="text" size="30" value="${start}" />
					</p>
																													<p>
					<label>年度：</label>
					<input name="year" class="digits" type="text" size="30" value="${year}"/>
					</p>
																													<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" class="digits" type="text" size="30" value="${womanId}"/>
					</p>
																													<p>
					<label>查环查孕类型：</label>
					<input name="typeh" class="digits" type="text" size="30" value="${typeh}"/>
					</p>
																													<p>
					<label>查环查孕类型原因：</label>
					<input name="cause"    type="text" size="30" value="${cause}" />
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