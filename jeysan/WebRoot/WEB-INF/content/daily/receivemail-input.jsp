<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/daily/receivemail!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_receivemailmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>发件人：</label>
					<input name="sendEmployeeId" class="digits  required" type="text" size="30" value="${sendEmployeeId}"/>
					</p>
																													<p>
					<label>收件人：</label>
					<input name="receiveEmployeeIds"  class="required" maxlength="10"    type="text" size="30" value="${receiveEmployeeIds}"  alt="请输入收件人" />
					</p>
																													<p>
					<label>主题：</label>
					<input name="title"  class="required" maxlength="200"    type="text" size="30" value="${title}"  alt="请输入主题" />
					</p>
																													<p>
					<label>附件：</label>
					<input name="attachment"    type="text" size="30" value="${attachment}" />
					</p>
																													<p>
					<label>内容：</label>
					<input name="content"    type="text" size="30" value="${content}" />
					</p>
																													<p>
					<label>状态：</label>
					<input name="status"  class="required" maxlength="1"    type="text" size="30" value="${status}"  alt="请输入状态" />
					</p>
																													<p>
					<label>父邮件：</label>
					<input name="parMailId" class="digits" type="text" size="30" value="${parMailId}"/>
					</p>
																													<p>
					<label>发送日期：</label>
					<input name="dateKt" class="date  required " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateKt}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>是否已读：</label>
					<input name="isRead"    type="text" size="30" value="${isRead}" />
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