<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.jeysan.cpf.util.Constants"%>
<c:set var="type_" value="<%=Constants.UPLOAD_FILE_TYPE.MAIL%>"/>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/daily/sendmail!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="parMailId" value="${m.id}" />
			<input type="hidden" name="receiveEmployeeIds" value="${m.sendEmployeeId}" />
			<input type="hidden" name="send_type" id="send_type" value="${send_type}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_sendmail${m.status}manage" />
			<div class="pageFormContent" layoutH="56">
				<p style="width:100%;">
					<label>
						收件人：
					</label>
					<input style="width:500px" type="text" readonly="readonly"
						size="30" value="<tags:js.user.getValue property="userName" value="${m.sendEmployeeId}"/>" />
				</p>
				<p style="width:100%;">
					<label>
						主题：
					</label>
					<input style="width:500px" name="title" class="required" maxlength="200" type="text"
						size="30" value="Re:${m.title}" alt="请输入主题" />
				</p>
	<p style="width:100%;height:400px">
					<label>
						内容：
					</label>
					<textarea name="content" class="required" maxlength="2000" alt="请输入邮件内容" style="width:500px;height:400px">
&#13;&#10;
<tags:js.user.getValue property="userName" value="${m.sendEmployeeId}"/>写于<fmt:formatDate value="${m.dateKt}" pattern="yyyy-MM-dd HH:mm:ss" />
---------------------------------
&#13;&#10;${m.content}&#13;&#10;
					</textarea>
				</p>
<div style="width:100%;margin-top:10px">
					<label style="float:left">
						附件：<tags:fileSelector type="${type_}" isv="true" hiddenId="attachment" labelId="fileQueue"/>
					</label>
				<div id="fileQueue" class="fileselector"></div>
</div>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit" onclick="javascript:$('#send_type').val(0)">
									发送
								</button>
							</div>
						</div>
					</li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="submit" onclick="javascript:$('#send_type').val(1)">
									保存
								</button>
							</div>
						</div>
					</li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="submit" onclick="javascript:$('#send_type').val(2)">
									发送并保存
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