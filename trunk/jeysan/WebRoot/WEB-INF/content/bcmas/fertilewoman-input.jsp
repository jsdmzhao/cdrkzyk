﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/fertilewoman!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_fertilewomanmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>PERSON_ID：</label>
					<input name="personId" class="digits  required" type="text" size="30" value="${personId}"/>
					</p>
																													<p>
					<label>建卡日期：</label>
					<input name="createDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${createDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>妇女类别：</label>
					<input name="typeh" class="digits" type="text" size="30" value="${typeh}"/>
					</p>
																													<p>
					<label>妇女编码：</label>
					<input name="code"    type="text" size="30" value="${code}" />
					</p>
																													<p>
					<label>所属区域：</label>
					<input name="area"    type="text" size="30" value="${area}" />
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