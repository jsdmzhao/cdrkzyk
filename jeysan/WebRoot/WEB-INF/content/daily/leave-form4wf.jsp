<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form id="form4wf" method="post"
			action="${ctx}/daily/leave!saveBizData.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="wiid" value="${cwi.id}" />
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="level" value="${level}" />
			<input type="hidden" name="result4Json.navTabId"
				value="nav_workitemmanage" />
			<input type="hidden" name="saveOrComplete" id="saveOrComplete"
				value="0" />
			<div class="pageFormContent" layoutH="56">


				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						请假单：
						<tags:js.wf.state.getValue value="${model.wfState}" type="2"></tags:js.wf.state.getValue>
					</h2>
				</div>

				<p>
					<label>
						编号：
					</label>
					<input name="leaveNo" readonly="readonly" type="text" size="30"
						value="${model.leaveNo}" />
				</p>
				<p>
					<label>
						申请人：
					</label>
					<input type="hidden" name="leaveEmployeeId"
						value="${model.leaveEmployeeId}" />
					<input name="leaveEmployeeName" readonly="readonly" type="text"
						size="30"
						value="<tags:js.user.getValue property="userName" value="${model.leaveEmployeeId}"></tags:js.user.getValue>" />
				</p>
				<p>
					<label>
						申请时间：
					</label>
					<input name="dateKt" readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${model.dateKt}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
				</p>
				<p>
					<label>
						请假事由：
					</label>
					<input name="leaveCause" readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${model.leaveCause}"></tags:js.dict.getValue>" />
				</p>
				<p>
					<label>
						请假开始日期：
					</label>
					<input name="leaveStart" readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${model.leaveStart}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						请假结束日期：
					</label>
					<input name="leaveEnd" readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${model.leaveEnd}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						请假总天数：
					</label>
					<input name="leaveCount" readonly="readonly" type="text" size="30"
						value="${model.leaveCount}" />
					&nbsp;天
				</p>

				<p style="width: 98%; height: 130px">
					<label>
						备注：
					</label>
					<textarea name="remark" maxlength="200" cols="55" rows="5"
						readonly="readonly">${model.remark}</textarea>
				</p>

				<c:if test="${level>=2}">
					<div style="float: left; width: 98%;">
						<h2 class="contentTitle">
							部门经理
						</h2>
					</div>


					<p>
						<label>
							审批决定：
						</label>
						<tags:js.dict.selector dictCode="JS060" name="deptorCheck"
							value="${model.deptorCheck}" readOnly="${level!=2}"
							class1="required"></tags:js.dict.selector>
					</p>

					<p style="width: 98%; height: 130px">
						<label>
							审批意见：
						</label>
						<textarea name="deptorOpinion" maxlength="200" cols="55" rows="5"
							<c:if test="${level!=2}">readonly="readonly"</c:if>>${model.deptorOpinion}</textarea>
					</p>

				</c:if>

				<c:if test="${level>=3}">
					<div style="float: left; width: 98%;">
						<h2 class="contentTitle">
							公司负责人
						</h2>
					</div>
					<p>
						<label>
							审批决定：
						</label>
						<tags:js.dict.selector dictCode="JS060" name="bossCheck"
							value="${model.bossCheck}" readOnly="${level!=3}"
							class1="required"></tags:js.dict.selector>
					</p>

					<p style="width: 98%; height: 130px">
						<label>
							审批意见：
						</label>
						<textarea name="bossOpinion" maxlength="200" cols="55" rows="5"
							<c:if test="${level!=3}">readonly="readonly"</c:if>>${model.bossOpinion}</textarea>
					</p>
				</c:if>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<a class="buttonActive"
							href="${ctx}/main/iframe.action?url=${ctx}/daily/leave!img4wf.action&width=999&height=399&id=${model.id}"
							target="dialog" maxable=false rel="dlg_leave-img4wf" width="1009" height="439"><span>查看流程图</span>
						</a>
					</li>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit" onclick="$('#saveOrComplete').val(0)">
									保存
								</button>
							</div>
						</div>
					</li>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit"
									onclick="$('#saveOrComplete').val(1);alertMsg.confirm('您确定要处理吗？', {okCall: function(){validateCallback($('#form4wf')[0], navTabAjaxDone4Update);}});return false;">
									处理
								</button>
							</div>
						</div>
					</li>
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