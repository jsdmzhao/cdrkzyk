<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/security/role!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_rolemanage" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						角色编码：
					</label>
					<input name="roleCode" type="text" size="30" value="${roleCode}" />
				</p>
				<p>
					<label>
						角色名称：
					</label>
					<input name="roleName" class="required" maxlength="50" type="text"
						size="30" value="${roleName}" alt="请输入角色名称" />
				</p>
				<p>
					<label>
						是否启用：
					</label>
					<tags:js.yes.no.selector name="roleEnable" value="${roleEnable}" />
				</p>

				<p>
					<label>
						是否受限：
					</label>
					<tags:js.yes.no.selector name="roleIslimited" value="${roleIslimited}" />
				</p>

				<div class="divider"></div>


				<p style="width: 100%">
					<label>
						角色描述：
					</label>
					<textarea name="roleInfo" maxlength="200" cols="23" rows="5">${roleInfo}</textarea>
				</p>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									保存
								</button>
							</div>
						</div>
					</li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="Button" onclick="navTab.closeCurrentTab()">
									取消
								</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>