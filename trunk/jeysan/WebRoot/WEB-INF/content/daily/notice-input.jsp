<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/daily/notice!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_noticemanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>签发人：</label>
					<input name="sendEmployeeId" class="digits  required" type="text" size="30" value="${sendEmployeeId}"/>
					</p>
																													<p>
					<label>主题：</label>
					<input name="title"  class="required" maxlength="200"    type="text" size="30" value="${title}"  alt="请输入主题" />
					</p>
																													<p>
					<label>级别：</label>
					<input name="levelKt"  class="required" maxlength="20"    type="text" size="30" value="${levelKt}"  alt="请输入级别" />
					</p>
																													<p>
					<label>内容：</label>
					<input name="content"  class="required" maxlength="2000"    type="text" size="30" value="${content}"  alt="请输入内容" />
					</p>
																													<p>
					<label>发布时间：</label>
					<input name="dateKt" class="date  required " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateKt}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>附件：</label>
					<input name="attachment"    type="text" size="30" value="${attachment}" />
					</p>
																													<p>
					<label>备注：</label>
					<input name="remark"    type="text" size="30" value="${remark}" />
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