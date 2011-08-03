<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/firstchildreg!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_firstchildregmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" class="digits  required" type="text" size="30" value="${womanId}"/>
					</p>
																													<p>
					<label>登记日期：</label>
					<input name="dateh" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>是否再生一孩：</label>
					<input name="isSecond" class="digits" type="text" size="30" value="${isSecond}"/>
					</p>
																													<p>
					<label>再生一孩条件：</label>
					<input name="cond"    type="text" size="30" value="${cond}" />
					</p>
																													<p>
					<label>部门意见：</label>
					<input name="deptOpt"    type="text" size="30" value="${deptOpt}" />
					</p>
																													<p>
					<label>经办人：</label>
					<input name="agent"    type="text" size="30" value="${agent}" />
					</p>
																													<p>
					<label>合同签署日期：</label>
					<input name="assignDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${assignDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>生育合同编号：</label>
					<input name="code"    type="text" size="30" value="${code}" />
					</p>
																													<p>
					<label>一孩预产期：</label>
					<input name="edd" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${edd}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
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