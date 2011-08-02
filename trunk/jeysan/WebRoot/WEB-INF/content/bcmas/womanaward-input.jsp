﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/womanaward!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_womanawardmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" class="digits  required" type="text" size="30" value="${womanId}"/>
					</p>
																													<p>
					<label>奖励日期：</label>
					<input name="awardDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${awardDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>奖励内容：</label>
					<input name="awardContent"    type="text" size="30" value="${awardContent}" />
					</p>
																													<p>
					<label>奖励经办人：</label>
					<input name="agent"    type="text" size="30" value="${agent}" />
					</p>
																													<p>
					<label>奖励类别：</label>
					<input name="typeh" class="digits" type="text" size="30" value="${typeh}"/>
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