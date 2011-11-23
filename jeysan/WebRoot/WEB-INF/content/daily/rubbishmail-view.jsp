<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p style="width:100%;">
				<label>
					发件人：
				</label>
				<input style="width:500px"  name="sendEmployeeId" readonly="readonly" type="text"
					size="30" value="<tags:js.user.getValue property="userName" value="${sendEmployeeId}"/>" />
			</p>
			<p style="width:100%;">
				<label>
					收件人：
				</label>
				
				<input style="width:500px" readonly="readonly" type="text" size="30"
					value="<c:forEach var="t" items="${fn:split(receiveEmployeeIds,',')}"><tags:js.user.getValue property="userName" value="${t}"/>&nbsp;</c:forEach>" />
							
			</p>
			<p style="width:100%;">
				<label>
					时间：
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


			<p>
				<label>
					来源：
				</label>
				<input name="source" readonly="readonly" type="text" size="30"
					value="<c:if test="${source==0}">收件箱</c:if><c:if test="${source==1}">发件箱</c:if><c:if test="${source==2}">草稿箱</c:if>" />
			</p>

		</div>
		<div class="formBar">
			<ul>
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
