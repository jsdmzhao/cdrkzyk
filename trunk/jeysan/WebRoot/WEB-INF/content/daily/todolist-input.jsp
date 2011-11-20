<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/daily/todolist!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_todolistmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>USER_ID：</label>
					<input name="userId" class="digits  required" type="text" size="30" value="${userId}"/>
					</p>
																													<p>
					<label>开始时间：</label>
					<input name="startTime" class="date  required " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${startTime}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>结束时间：</label>
					<input name="endTime" class="date  required " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>标题：</label>
					<input name="title"  class="required" maxlength="100"    type="text" size="30" value="${title}"  alt="请输入标题" />
					</p>
																													<p>
					<label>详情：</label>
					<input name="detail"    type="text" size="30" value="${detail}" />
					</p>
																													<p>
					<label>状态：</label>
					<input name="status" class="digits" type="text" size="30" value="${status}"/>
					</p>
																													<p>
					<label>备忘：</label>
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