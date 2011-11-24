<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					发件人：
				</label>
				<input name="sendEmployeeId" readonly="readonly" type="text"
					size="30" value="<tags:js.user.getValue property="userName" value="${sendEmployeeId}"/>" />
			</p>
			<p>
				<label>
					邮件状态：
				</label>
				<input name="isRead" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${isRead}"/>" />
			</p>
			<p style="width:100%;">
				<label>
					发送时间：
				</label>
				<input style="width:500px" name="dateKt" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${dateKt}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
			</p>


			<p style="width:100%;">
				<label>
					主题：
				</label>
				<input style="width:500px"  name="title" readonly="readonly" type="text" size="30"
					value="${title}" />
			</p>

	<p style="width:100%;height:400px">
					<label>
						内容：
					</label>
					<textarea name="content" readonly="readonly" maxlength="2000" alt="请输入邮件内容" style="width:500px;height:400px">${content}</textarea>
				</p>
<div style="width:100%;margin-top:10px">
					<label style="float:left">
						附件：<tags:fileSelector type="${type_}" isv="false" hiddenId="attachment" labelId="fileQueue" hiddenIdValue="${attachment}"/>
					</label>
				<div id="fileQueue" class="fileselector"></div>
</div>

		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="Button" onclick="navTab.openTab('receiveMail-view', '${ctx}/daily/sendmail!reply.action?id=${id}',{title:'回复邮件'});">
								回复
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
