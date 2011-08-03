<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>APPLY_ID：</label>
					<input name="applyId" readonly="readonly" type="text" size="30" value="${applyId}"/>
					</p>
																														<p>
					<label>审批结果：</label>
					<input name="isAgree" readonly="readonly" type="text" size="30" value="${isAgree}"/>
					</p>
																														<p>
					<label>是否签订生育合同：</label>
					<input name="isAssign" readonly="readonly" type="text" size="30" value="${isAssign}"/>
					</p>
																														<p>
					<label>生育合同日期：</label>
					<input name="dateh" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>生育合同编号：</label>
					<input name="code" readonly="readonly" type="text" size="30" value="${code}"/>
					</p>
																														<p>
					<label>二孩计划日期：</label>
					<input name="edd" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${edd}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>部门意见：</label>
					<input name="deptOpt" readonly="readonly" type="text" size="30" value="${deptOpt}"/>
					</p>
																														<p>
					<label>审批人：</label>
					<input name="checkor" readonly="readonly" type="text" size="30" value="${checkor}"/>
					</p>
																														<p>
					<label>审批日期：</label>
					<input name="checkDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${checkDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>备注：</label>
					<input name="remark" readonly="readonly" type="text" size="30" value="${remark}"/>
					</p>
																		</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
</div>
