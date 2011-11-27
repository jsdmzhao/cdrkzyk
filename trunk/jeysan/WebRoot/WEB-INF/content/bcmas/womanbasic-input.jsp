﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/womanbasic!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> 
			<input type="hidden" name="result4Json.navTabId" value="fertileWomanFix"/>-->
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						WOMAN_ID：
					</label>
					<input name="womanId" class="digits  required" type="text"
						size="30" value="${womanId}" />
				</p>
				<p>
					<label>
						婚姻状态：
					</label>
					<input name="marryStatus" class="digits" type="text" size="30"
						value="${marryStatus}" />
				</p>
				<p>
					<label>
						夫婚姻状态：
					</label>
					<input name="spouseMarryStatus" class="digits" type="text"
						size="30" value="${spouseMarryStatus}" />
				</p>
				<p>
					<label>
						初婚日期：
					</label>
					<input name="firstMarryDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${firstMarryDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						婚变日期：
					</label>
					<input name="marryCryDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${marryCryDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						领光荣证日期：
					</label>
					<input name="getGrzDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${getGrzDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						安排二孩原因：
					</label>
					<input name="planChild2Cause" type="text" size="30"
						value="${planChild2Cause}" />
				</p>
				<p>
					<label>
						安排二孩日期：
					</label>
					<input name="planChild2Date" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${planChild2Date}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						安排再生原因：
					</label>
					<input name="planBear2Cause" type="text" size="30"
						value="${planBear2Cause}" />
				</p>
				<p>
					<label>
						安排再生日期：
					</label>
					<input name="planBear2Date" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${planBear2Date}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						领流动证类型：
					</label>
					<input name="getLdzType" class="digits" type="text" size="30"
						value="${getLdzType}" />
				</p>
				<p>
					<label>
						领流动证日期：
					</label>
					<input name="getLdzDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${getLdzDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						健康状况：
					</label>
					<input name="healthStatus" class="digits" type="text" size="30"
						value="${healthStatus}" />
				</p>
				<p>
					<label>
						注销类型：
					</label>
					<input name="cancelType" class="digits" type="text" size="30"
						value="${cancelType}" />
				</p>
				<p>
					<label>
						注销日期：
					</label>
					<input name="cancelDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						备注：
					</label>
					<input name="remark" type="text" size="30" value="${remark}" />
				</p>
				<p>
					<label>
						计生证明号：
					</label>
					<input name="certCode" type="text" size="30" value="${certCode}" />
				</p>
				<p>
					<label>
						计生证有效期：
					</label>
					<input name="certDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${certDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									保存
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