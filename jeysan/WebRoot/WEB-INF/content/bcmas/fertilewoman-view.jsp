<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					姓名：
				</label>
				<input name="personId" readonly="readonly" type="text" size="30"
					value="${person.nameh}" />
			</p>
			<p>
				<label>
					建卡日期：
				</label>
				<input name="createDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${createDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					妇女编码：
				</label>
				<input name="code" readonly="readonly" type="text" size="30"
					value="${code}" />
			</p>
			<p>
				<label>
					所属区域：
				</label>
				<input name="area" readonly="readonly" type="text" size="30"
					value="${area}" />
			</p>
			<div class="divider"></div>

			<p>
				<label>
					婚姻状态：
				</label>
				<input name="womanBasic.marryStatus" readonly="readonly" type="text"
					size="30"
					value="<tags:js.dict.getValue value="${womanBasic.marryStatus}"/>" />
			</p>
			<p>
				<label>
					夫婚姻状态：
				</label>
				<input name="womanBasic.spouseMarryStatus" readonly="readonly"
					type="text" size="30"
					value="<tags:js.dict.getValue value="${womanBasic.spouseMarryStatus}"/>" />
			</p>
			<p>
				<label>
					初婚日期：
				</label>
				<input name="womanBasic.firstMarryDate" readonly="readonly"
					type="text" size="30"
					value="<fmt:formatDate value="${womanBasic.firstMarryDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					婚变日期：
				</label>
				<input name="womanBasic.marryCryDate" readonly="readonly"
					type="text" size="30"
					value="<fmt:formatDate value="${womanBasic.marryCryDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<div class="divider"></div>
			<p>
				<label>
					领光荣证日期：
				</label>
				<input name="womanBasic.getGrzDate" readonly="readonly" type="text"
					size="30"
					value="<fmt:formatDate value="${womanBasic.getGrzDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					安排二孩原因：
				</label>
				<input name="womanBasic.planChild2Cause" readonly="readonly"
					type="text" size="30" value="${womanBasic.planChild2Cause}" />
			</p>
			<p>
				<label>
					安排二孩日期：
				</label>
				<input name="womanBasic.planChild2Date" readonly="readonly"
					type="text" size="30"
					value="<fmt:formatDate value="${womanBasic.planChild2Date}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					安排再生原因：
				</label>
				<input name="womanBasic.planBear2Cause" readonly="readonly"
					type="text" size="30" value="${womanBasic.planBear2Cause}" />
			</p>
			<p>
				<label>
					安排再生日期：
				</label>
				<input name="womanBasic.planBear2Date" readonly="readonly"
					type="text" size="30"
					value="<fmt:formatDate value="${womanBasic.planBear2Date}" pattern="yyyy-MM-dd"/>" />
			</p>
			<div class="divider"></div>
			<p>
				<label>
					领流动证类型：
				</label>
				<input name="womanBasic.getLdzType" readonly="readonly" type="text"
					size="30" value="${womanBasic.getLdzType}" />
			</p>
			<p>
				<label>
					领流动证日期：
				</label>
				<input name="womanBasic.getLdzDate" readonly="readonly" type="text"
					size="30"
					value="<fmt:formatDate value="${womanBasic.getLdzDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					健康状况：
				</label>
				<input name="womanBasic.healthStatus" readonly="readonly"
					type="text" size="30" value="${womanBasic.healthStatus}" />
			</p><!-- 
			<p>
				<label>
					注销类型：
				</label>
				<input name="womanBasic.cancelType" readonly="readonly" type="text"
					size="30" value="${womanBasic.cancelType}" />
			</p>
			<p>
				<label>
					注销日期：
				</label>
				<input name="womanBasic.cancelDate" readonly="readonly" type="text"
					size="30"
					value="<fmt:formatDate value="${womanBasic.cancelDate}" pattern="yyyy-MM-dd"/>" />
			</p> -->
			<p>
				<label>
					备注：
				</label>
				<input name="womanBasic.remark" readonly="readonly" type="text"
					size="30" value="${womanBasic.remark}" />
			</p>
			<div class="divider"></div>
			<p>
				<label>
					计生证明号：
				</label>
				<input name="womanBasic.certCode" readonly="readonly" type="text"
					size="30" value="${womanBasic.certCode}" />
			</p>
			<p>
				<label>
					计生证有效期：
				</label>
				<input name="womanBasic.certDate" readonly="readonly" type="text"
					size="30"
					value="<fmt:formatDate value="${womanBasic.certDate}" pattern="yyyy-MM-dd"/>" />
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
