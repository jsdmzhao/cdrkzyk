<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/toccert!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_toccertmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>人员ID：</label>
					<input name="personId" class="digits  required" type="text" size="30" value="${personId}"/>
					</p>
																													<p>
					<label>子女ID：</label>
					<input name="childId" class="digits" type="text" size="30" value="${childId}"/>
					</p>
																													<p>
					<label>发证机关：</label>
					<input name="issOrg"    type="text" size="30" value="${issOrg}" />
					</p>
																													<p>
					<label>发证日期：</label>
					<input name="issDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>证书编号：</label>
					<input name="certCode"    type="text" size="30" value="${certCode}" />
					</p>
																													<p>
					<label>是否注销：</label>
					<input name="isCancel" class="digits" type="text" size="30" value="${isCancel}"/>
					</p>
																													<p>
					<label>注销原因：</label>
					<input name="cancelCause"    type="text" size="30" value="${cancelCause}" />
					</p>
																													<p>
					<label>注销日期：</label>
					<input name="cancelDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
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