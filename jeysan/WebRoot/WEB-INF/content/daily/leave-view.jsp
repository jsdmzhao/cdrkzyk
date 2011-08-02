<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<div style="float: left; width: 98%;">
				<h2 class="contentTitle">
					请假单：
					<tags:js.wf.state.getValue value="${wfState}" type="2"></tags:js.wf.state.getValue>
				</h2>
			</div>
			<p>
				<label>
					编号：
				</label>
				<input name="leaveNo" readonly="readonly" type="text" size="30"
					value="${leaveNo}" />
			</p>
			<p>
				<label>
					申请人：
				</label>
				<input name="leaveEmployeeId" readonly="readonly" type="text"
					size="30"
					value="<tags:js.user.getValue property="userName" value="${leaveEmployeeId}"></tags:js.user.getValue>" />
			</p>
			<p>
				<label>
					申请时间：
				</label>
				<input name="dateKt" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${dateKt}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
			</p>
			<p>
				<label>
					请假事由：
				</label>
				<input name="leaveCause" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${leaveCause}"></tags:js.dict.getValue>" />
			</p>


			<p>
				<label>
					请假开始日期：
				</label>
				<input name="leaveStart" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${leaveStart}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					请假结束日期：
				</label>
				<input name="leaveEnd" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${leaveEnd}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					请假总天数：
				</label>
				<input name="leaveCount" readonly="readonly" type="text" size="30"
					value="${leaveCount}" />
				&nbsp;天
			</p>

			<p style="width: 100%; height: 130px">
				<label>
					备注：
				</label>
				<textarea name="remark" readonly="readonly" maxlength="200"
					cols="55" rows="5">${remark}</textarea>
			</p>
			<c:if test="${wfState!=99}">
				<c:if test="${wfLevel>=2}">
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
							value="${deptorCheck}" readOnly="true"></tags:js.dict.selector>
					</p>

					<p>
						<label>
							审批人：
						</label>
						<input name="deptor" readonly="readonly" type="text"
							size="30"
							value="<tags:js.user.getValue property="userName" value="${deptor}"></tags:js.user.getValue>" />
					</p>

					<p>
						<label>
							审批时间：
						</label>
						<input name="deptorDate" readonly="readonly" type="text" size="30"
							value="<fmt:formatDate value="${deptorDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
					</p>

					<p style="width: 98%; height: 130px">
						<label>
							审批意见：
						</label>
						<textarea name="deptorOpinion" maxlength="200" cols="55" rows="5"
							readonly="readonly">${deptorOpinion}</textarea>
					</p>


				</c:if>

				<c:if test="${wfLevel>=3}">
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
							value="${bossCheck}" readOnly="true"></tags:js.dict.selector>
					</p>

					<p>
						<label>
							审批人：
						</label>
						<input name="boss" readonly="readonly" type="text"
							size="30"
							value="<tags:js.user.getValue property="userName" value="${boss}"></tags:js.user.getValue>" />
					</p>

					<p>
						<label>
							审批时间：
						</label>
						<input name="bossDate" readonly="readonly" type="text" size="30"
							value="<fmt:formatDate value="${bossDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
					</p>

					<p style="width: 98%; height: 130px">
						<label>
							审批意见：
						</label>
						<textarea name="bossOpinion" maxlength="200" cols="55" rows="5"
							readonly="readonly">${bossOpinion}</textarea>
					</p>


				</c:if>
			</c:if>
		</div>
		<div class="formBar">
			<ul>
				<c:if test="${wfState==99}">
					<li>
						<a class="buttonActive"
							href="${ctx}/daily/leave!submitWF.action?id=${id}&result4Json.navTabId=nav_leavemanage"
							target="ajaxTodo" title="确定要提交申请吗？提交后，请假单将不可以修改，并且申请不可撤销"><span>提交申请</span>
						</a>
					</li>
				</c:if>
				<li>
					<a class="buttonActive"
						href="${ctx}/main/iframe.action?url=${ctx}/daily/leave!img4wf.action&width=999&height=399&id=${id}"
						target="dialog" maxable=false rel="dlg_leave-img4wf" width="1009" height="439"><span>查看流程图</span>
					</a>
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
