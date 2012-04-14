<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.jeysan.cpf.util.Constants"%>
<c:set var="type_" value="<%=Constants.UPLOAD_FILE_TYPE.MAIL%>"/>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/daily/sendmail!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${model.id}" />
			<input type="hidden" name="send_type" id="send_type" value="${send_type}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_sendmail${model.status}manage" />
			<div class="pageFormContent" layoutH="56">
				<p style="width:100%;height:155px">
					<label>
						收件人：
					</label>
					<select name="receiveEmployeeIds" id="receiveEmployeeIds" class="required" multiple="multiple" style="width:500px;height:150px">
<c:forEach var="a" items="${users}">
<c:if test="${a.id!=_js_user.id}">
<option value="${a.id}">[${a.userCode}]${a.userName}</option>
</c:if>
</c:forEach>
					</select>
				</p>
				<p style="width:100%;">
					<label>
						主题：
					</label>
					<input style="width:500px" name="title" class="required" maxlength="200" type="text"
						size="30" value="${model.title}" alt="请输入主题" />
				</p>
	<p style="width:100%;height:400px">
					<label>
						内容：
					</label>
					<textarea name="content" class="required" maxlength="2000" alt="请输入邮件内容" style="width:500px;height:400px">${model.content}</textarea>
				</p>
<div style="width:100%;margin-top:10px">
					<label style="float:left">
						附件：<tags:fileSelector type="${type_}" isv="true" hiddenId="attachment" labelId="fileQueue" hiddenIdValue="${model.attachment}"/>
					</label>
				<div id="fileQueue" class="fileselector"></div>
</div>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit" onclick="javascript:$('#send_type',navTab.getCurrentPanel()).val(0)">
									发送
								</button>
							</div>
						</div>
					</li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="submit" onclick="javascript:$('#send_type',navTab.getCurrentPanel()).val(1)">
									保存
								</button>
							</div>
						</div>
					</li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="submit" onclick="javascript:$('#send_type',navTab.getCurrentPanel()).val(2)">
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
<script>
$(function(){
	var $box = navTab.getCurrentPanel();
	$("#receiveEmployeeIds option",$box).each(function(){
		<c:forEach var="t" items="${fn:split(model.receiveEmployeeIds,',')}">
			if(this.value=='${t}') this.selected = true;
		</c:forEach>
	});
});
</script>