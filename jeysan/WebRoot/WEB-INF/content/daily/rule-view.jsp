<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:if test="${param.filter_EQI_typeh==0}"><c:set var="rule_title" value="规章制度"/></c:if>
<c:if test="${param.filter_EQI_typeh==1}"><c:set var="rule_title" value="法律法规"/></c:if>
<c:if test="${param.filter_EQI_typeh==2}"><c:set var="rule_title" value="通知通报"/></c:if>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					${rule_title}名称：
				</label>
				<input name="title" readonly="readonly" type="text" size="30"
					value="${title}" />
			</p>
			<p>
				<label>
					${rule_title}级别：
				</label>
				<input name="levelKt" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${levelKt}"/>" />
			</p>
			<p>
				<label>
					发布人：
				</label>
				<input name="sendEmployeeId" readonly="readonly" type="text"
					size="30" value="<tags:js.user.getValue property="userName" value="${sendEmployeeId}"/>" />
			</p>
			<p>
				<label>
					发布时间：
				</label>
				<input name="dateKt" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${dateKt}" pattern="yyyy-MM-dd"/>" />
			</p>
				<p style="width:100%;height:400px">
					<label>
						${rule_title}内容：
					</label>
					<textarea name="content" readonly="readonly" style="width:500px;height:400px">${content}</textarea>
				</p>
<div style="width:100%;margin-top:10px">
					<label style="float:left">
						附件：<tags:fileSelector type="${type_}" isv="false" hiddenId="attachment" labelId="fileQueue" hiddenIdValue="${attachment}"/>
					</label>
				<div id="fileQueue" class="fileselector"></div>
</div>
			<p>
				<label>
					备注：
				</label>
				<input name="remark" readonly="readonly" type="text" size="30"
					value="${remark}" />
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
