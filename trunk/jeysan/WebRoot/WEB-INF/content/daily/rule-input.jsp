<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="type_" value="<%=Constants.UPLOAD_FILE_TYPE.RULE1 %>"/>
<c:if test="${param.filter_EQI_typeh==0}"><c:set var="rule_title" value="规章制度"/></c:if>
<c:if test="${param.filter_EQI_typeh==1}"><c:set var="rule_title" value="法律法规"/></c:if>
<c:if test="${param.filter_EQI_typeh==2}"><c:set var="rule_title" value="通知通报"/></c:if>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/daily/rule!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="filter_EQI_typeh" value="${param.filter_EQI_typeh}" />
			<input type="hidden" name="typeh" value="${param.filter_EQI_typeh}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_rule${param.filter_EQI_typeh}manage" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						${rule_title}名称：
					</label>
					<input name="title" class="required" maxlength="200" type="text"
						size="30" value="${title}" alt="请输入${rule_title}名称" />
				</p>
				<p>
					<label>
						${rule_title}级别：
					</label>
					<tags:js.dict.selector name="levelKt" class1="required"  value="${levelKt}" dictCode="JS1079"/>
				</p>
				<p style="width:100%;height:400px">
					<label>
						${rule_title}内容：
					</label>
					<textarea name="content" class="required" maxlength="2000" alt="请输入${rule_title}内容" style="width:500px;height:400px">${content}</textarea>
				</p>
<div style="width:100%;margin-top:10px">
					<label style="float:left">
						附件：<tags:fileSelector type="${type_}" isv="true" hiddenId="attachment" labelId="fileQueue" hiddenIdValue="${attachment}"/>
					</label>
				<div id="fileQueue" class="fileselector"></div>
</div>
				<p>
					<label>
						备注：
					</label>
					<input name="remark" type="text" size="30" value="${remark}" />
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