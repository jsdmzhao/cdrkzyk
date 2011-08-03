<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/birth2check!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_birth2checkmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>APPLY_ID：</label>
					<input name="applyId" class="digits  required" type="text" size="30" value="${applyId}"/>
					</p>
																													<p>
					<label>审批结果：</label>
					<input name="isAgree" class="digits" type="text" size="30" value="${isAgree}"/>
					</p>
																													<p>
					<label>是否签订生育合同：</label>
					<input name="isAssign" class="digits" type="text" size="30" value="${isAssign}"/>
					</p>
																													<p>
					<label>生育合同日期：</label>
					<input name="dateh" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>生育合同编号：</label>
					<input name="code"    type="text" size="30" value="${code}" />
					</p>
																													<p>
					<label>二孩计划日期：</label>
					<input name="edd" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${edd}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>部门意见：</label>
					<input name="deptOpt"    type="text" size="30" value="${deptOpt}" />
					</p>
																													<p>
					<label>审批人：</label>
					<input name="checkor"    type="text" size="30" value="${checkor}" />
					</p>
																													<p>
					<label>审批日期：</label>
					<input name="checkDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${checkDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
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