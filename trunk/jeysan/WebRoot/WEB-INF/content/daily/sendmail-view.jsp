<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:if test="${status==1}"><c:set var="do_title" value="发送"/></c:if>
<c:if test="${status==2}"><c:set var="do_title" value="保存"/></c:if>
<div class="page">
<c:if test="${status==1}">
	<form class="pageForm">
</c:if>
<c:if test="${status==2}">
		<form method="post" action="${ctx}/daily/sendmail!draft.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="type" id="type" value="${type}" />
			<!-- <input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_sendmail${status}manage" />
</c:if>
		<div class="pageFormContent" layoutH="56">
			<p style="width:100%;">
				<label>
					主题：
				</label>
				<input style="width:500px" readonly="readonly" type="text" size="30"
					value="${title}" />
			</p>
			<p style="width:100%;">
				<label>
					${do_title}时间：
				</label>
				<input style="width:500px" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${dateKt}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
			</p>
			<p style="width:100%;">
				<label>
					收件人：
				</label>
				
				<input style="width:500px" readonly="readonly" type="text" size="30"
					value="<c:forEach var="t" items="${fn:split(receiveEmployeeIds,',')}"><tags:js.user.getValue property="userName" value="${t}"/>&nbsp;</c:forEach>" />
							
			</p>

	<p style="width:100%;height:400px">
					<label>
						内容：
					</label>
					<textarea readonly="readonly" maxlength="2000" style="width:500px;height:400px">${content}</textarea>
				</p>
<div style="width:100%;margin-top:10px">
					<label style="float:left">
						附件：<tags:fileSelector type="${type_}" isv="false" hiddenId="attachment_" labelId="fileQueue" hiddenIdValue="${attachment}"/>
					</label>
				<div id="fileQueue" class="fileselector"></div>
</div>
		</div>
		<div class="formBar">
			<ul><c:if test="${status==2}">
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" onclick="$('#type').val(0)">
								发送
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="Button" onclick="navTab.openTab('sendMail${status}-view', '${ctx}/daily/sendmail!draft.action?id=${id}&type=1',{title:'编辑草稿箱邮件'});">
								重新编辑
							</button>
						</div>
					</div>
				</li></c:if>
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
