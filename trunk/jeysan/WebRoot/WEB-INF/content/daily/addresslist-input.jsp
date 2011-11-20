<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/daily/addresslist!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_addresslistmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>USER_ID：</label>
					<input name="userId" class="digits  required" type="text" size="30" value="${userId}"/>
					</p>
																													<p>
					<label>姓名：</label>
					<input name="nameh"  class="required" maxlength="20"    type="text" size="30" value="${nameh}"  alt="请输入姓名" />
					</p>
																													<p>
					<label>固话：</label>
					<input name="telPhone"  class="required" maxlength="20"    type="text" size="30" value="${telPhone}"  alt="请输入固话" />
					</p>
																													<p>
					<label>移动电话：</label>
					<input name="mobilePhone"  class="required" maxlength="20"    type="text" size="30" value="${mobilePhone}"  alt="请输入移动电话" />
					</p>
																													<p>
					<label>常用邮箱：</label>
					<input name="email"    type="text" size="30" value="${email}" />
					</p>
																													<p>
					<label>单位：</label>
					<input name="company"    type="text" size="30" value="${company}" />
					</p>
																													<p>
					<label>住址：</label>
					<input name="address"  class="required" maxlength="100"    type="text" size="30" value="${address}"  alt="请输入住址" />
					</p>
																													<p>
					<label>分组：</label>
					<input name="grouph" class="digits  required" type="text" size="30" value="${grouph}"/>
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