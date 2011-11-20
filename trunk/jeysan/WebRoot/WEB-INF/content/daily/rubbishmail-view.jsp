<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>发件人：</label>
					<input name="sendEmployeeId" readonly="readonly" type="text" size="30" value="${sendEmployeeId}"/>
					</p>
																														<p>
					<label>收件人：</label>
					<input name="receiveEmployeeIds" readonly="readonly" type="text" size="30" value="${receiveEmployeeIds}"/>
					</p>
																														<p>
					<label>主题：</label>
					<input name="title" readonly="readonly" type="text" size="30" value="${title}"/>
					</p>
																														<p>
					<label>附件：</label>
					<input name="attachment" readonly="readonly" type="text" size="30" value="${attachment}"/>
					</p>
																														<p>
					<label>内容：</label>
					<input name="content" readonly="readonly" type="text" size="30" value="${content}"/>
					</p>
																														<p>
					<label>状态：</label>
					<input name="status" readonly="readonly" type="text" size="30" value="${status}"/>
					</p>
																														<p>
					<label>父邮件：</label>
					<input name="parMailId" readonly="readonly" type="text" size="30" value="${parMailId}"/>
					</p>
																														<p>
					<label>时间：</label>
					<input name="dateKt" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateKt}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>是否已读：</label>
					<input name="isRead" readonly="readonly" type="text" size="30" value="${isRead}"/>
					</p>
																														<p>
					<label>来源：</label>
					<input name="source" readonly="readonly" type="text" size="30" value="${source}"/>
					</p>
																		</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
</div>
