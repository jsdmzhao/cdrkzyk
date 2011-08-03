<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/birth2apply!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_birth2applymanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" class="digits  required" type="text" size="30" value="${womanId}"/>
					</p>
																													<p>
					<label>申请日期：</label>
					<input name="dateh" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>申请类型：</label>
					<input name="typeh" class="digits" type="text" size="30" value="${typeh}"/>
					</p>
																													<p>
					<label>是否接受申请：</label>
					<input name="isAccept" class="digits" type="text" size="30" value="${isAccept}"/>
					</p>
																													<p>
					<label>是否再生二孩：</label>
					<input name="isSecond" class="digits" type="text" size="30" value="${isSecond}"/>
					</p>
																													<p>
					<label>申请条件：</label>
					<input name="cond"    type="text" size="30" value="${cond}" />
					</p>
																													<p>
					<label>申请书编号：</label>
					<input name="code"    type="text" size="30" value="${code}" />
					</p>
																													<p>
					<label>经办人：</label>
					<input name="agent"    type="text" size="30" value="${agent}" />
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