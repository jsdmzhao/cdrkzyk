<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/monitor/monitorworkload!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_monitorworkloadmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>操作时间：</label>
					<input name="operatTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate  required " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${operatTime}" pattern="yyyy-MM-dd"/>"/>
					</p>
																													<p>
					<label>操作人：</label>
					<input name="operator" class="digits" type="text" size="30" value="${operator}"/>
					</p>
																													<p>
					<label>操作人IP：</label>
					<input name="operatIp"    type="text" size="30" value="${operatIp}" />
					</p>
																													<p>
					<label>工作类别：</label>
					<input name="workType" class="digits" type="text" size="30" value="${workType}"/>
					</p>
																													<p>
					<label>工作量：</label>
					<input name="workLoad" class="digits" type="text" size="30" value="${workLoad}"/>
					</p>
																													<p>
					<label>操作类型：</label>
					<input name="operatType" class="digits" type="text" size="30" value="${operatType}"/>
					</p>
																													<p>
					<label>所属区域：</label>
					<input name="orgCode"    type="text" size="30" value="${orgCode}" />
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