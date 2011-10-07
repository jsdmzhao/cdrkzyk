<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">

			<div style="float: left; width: 98%;">
				<h2 class="contentTitle">
					申请信息：
				</h2>
			</div>

			<p>
				<label>
					申请类型：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${typeh}"/>" />
			</p>

			<p>
				<label>
					申请日期：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>" />
			</p>

			<p>
				<label>
					是否接受申请：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.yes.no.getValue value="${isAccept}"/>" />
			</p>
			<p>
				<label>
					是否再生二孩：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.yes.no.getValue value="${isSecond}"/>" />
			</p>
			<p style="width: 98%">
				<label>
					申请条件：
				</label>
				<input readonly="readonly" type="text" size="100" value="${cond}" />
			</p>
			<p>
				<label>
					申请书编号：
				</label>
				<input readonly="readonly" type="text" size="30" value="${code}" />
			</p>
			<p>
				<label>
					经办人：
				</label>
				<input readonly="readonly" type="text" size="30" value="${agent}" />
			</p>



			<div style="float: left; width: 98%;">
				<h2 class="contentTitle">
					审批信息：
				</h2>
			</div>

			<p>
				<label>
					审批结果：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${birth2Check.isAgree}"/>" />
			</p>
			<p>
				<label>
					是否签订生育合同：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.yes.no.getValue value="${birth2Check.isAssign}"/>" />
			</p>
			<p>
				<label>
					生育合同日期：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${birth2Check.dateh}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					生育合同编号：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${birth2Check.code}" />
			</p>
			<p>
				<label>
					二孩计划日期：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${birth2Check.edd}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p style="width:98%">
				<label>
					部门意见：
				</label>
				<input readonly="readonly" type="text" size="100"
					value="${birth2Check.deptOpt}" />
			</p>
			<p>
				<label>
					审批人：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${birth2Check.checkor}" />
			</p>
			<p>
				<label>
					审批日期：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${birth2Check.checkDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					备注：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${birth2Check.remark}" />
			</p>
<div class="divider"></div>

			<p>
				<label>
					停止避孕时间：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${noContraceptDdate}" pattern="yyyy-MM-dd"/>" />
			</p>


			<p>
				<label>
					安排生育情况：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${planType}"/>" />
			</p>
			
		</div>
		<div class="formBar">
			<ul>
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
