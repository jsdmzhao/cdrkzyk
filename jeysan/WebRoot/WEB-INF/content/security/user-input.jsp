<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/security/user!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_usermanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>用户名：</label>
					<input name="userName"  class="required" maxlength="20"  type="text" size="30" value="${userName}"/>
					</p>
																					<p>
					<label>用户密码：</label>
					<input name="userPassword" id="userPassword" class="required alphanumeric" alt="字母,数字,下划线"  maxlength="20"    type="password" size="30" />
					</p>
																							<p>
					<label>用户编码：</label>
					<input name="userCode"  class="required" maxlength="20"    type="text" size="30" value="${userCode}" />
					</p>
																													<p>
					<label>确认密码：</label>
					<input name="reUserPassword" class="required" maxlength="20"    type="password" size="30"  equalTo='#userPassword'/>
					</p>
																													<p>
					<label>所属机构：</label><tags:js.org.selector isRequired="true" o1="orgId" o1_v="${org.id}" o2_v="${org.orgName}"/></p>
<div class="divider"></div>		
					
																													<p>
					<label>是否有效：</label><tags:js.yes.no.selector name="userEnabled" value="${userEnabled}"/>
					
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