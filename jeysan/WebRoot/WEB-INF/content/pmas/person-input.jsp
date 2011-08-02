<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/person!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>姓名：</label>
					<input name="nameh"  class="required" maxlength="50"    type="text" size="30" value="${nameh}"  alt="请输入姓名" />
					</p>
																													<p>
					<label>身份证号码：</label>
					<input name="code"    type="text" size="30" value="${code}" />
					</p>
																													<p>
					<label>人员类别：</label>
					<input name="kind" class="digits" type="text" size="30" value="${kind}"/>
					</p>
																													<p>
					<label>人员编号：</label>
					<input name="personCode"    type="text" size="30" value="${personCode}" />
					</p>
																													<p>
					<label>户口类别：</label>
					<input name="domicileType" class="digits" type="text" size="30" value="${domicileType}"/>
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