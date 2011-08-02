<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/daily/leave!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="result4Json.navTabId"
				value="nav_leavemanage" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						编号：
					</label>
					<input name="leaveNo" class="required" maxlength="20" type="text"
						size="30" value="${leaveNo}" alt="请输入编号" />
				</p>
				<p>
					<label>
						请假事由：
					</label>
					<tags:js.dict.selector dictCode="JS070" name="leaveCause"
						value="${leaveCause}" class1="required"></tags:js.dict.selector>
				</p>
				<p>
					<label>
						请假开始日期：
					</label>
					<input name="leaveStart" class="date  required "
						readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${leaveStart}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						请假结束日期：
					</label>
					<input name="leaveEnd" class="date  required " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${leaveEnd}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						请假总天数：
					</label>
					<input name="leaveCount" class="digits" type="text" size="30"
						value="${leaveCount}" readonly="readonly" />
					&nbsp;天
				</p>

				<p style="width: 100%; height: 130px">
					<label>
						备注：
					</label>
					<textarea name="remark" maxlength="200" cols="55" rows="5">${remark}</textarea>
				</p>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<a class="buttonActive"
							href="${ctx}/main/iframe.action?url=${ctx}/daily/leave!img4wf.action&width=999&height=399&id=${id}"
							target="dialog" maxable=false rel="dlg_leave-img4wf" width="1009" height="439"><span>查看流程图</span>
						</a>
					</li>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									保存
								</button>
							</div>
						</div>
					</li>
					<c:if test="${wfState==99}">
						<li>
							<a class="buttonActive"
								href="${ctx}/daily/leave!submitWF.action?id=${id}&result4Json.navTabId=nav_leavemanage"
								target="ajaxTodo" title="确定要提交申请吗？提交后，请假单将不可以修改，并且申请不可撤销"><span>提交申请</span>
							</a>
						</li>
					</c:if>
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