﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/womancontracept!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="person.id"
				value="${person.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/>-->
			<input type="hidden" name="result4Json.navTabId" value="nav_womancontraceptmanage"/> 
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						姓名：
					</label>
					<input name="womanId" readonly="readonly" type="text"
						size="30" value="${person.nameh}" />
				</p>
				<p>
					<label>
						妇女编码：
					</label>
					<input name="womanId" readonly="readonly"  type="text"
						size="30" value="${person.code}" />
				</p>
				<p>
					<label>
						避孕节育措施：
					</label>
					<tags:js.dict.selector name="methodh" value="${method}" dictCode="JS1018"/>
				</p>
				<p>
					<label>
						手术医院类型：
					</label>
					<tags:js.dict.selector name="hospitalType" value="${hospitalType}" dictCode="JS1053"/>
				</p>
				<p>
					<label>
						手术医生：
					</label>
					<input name="doctor" type="text" size="30" value="${doctor}" />
				</p>
				<p>
					<label>
						手术医院：
					</label>
					<input name="hospital" type="text" size="30" value="${hospital}" />
				</p>
				<p>
					<label>
						手术日期：
					</label>
					<input name="opsDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${opsDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						手术医院地址：
					</label>
					<input name="hospitalAddress" type="text" size="30"
						value="${hospitalAddress}" />
				</p>
				<p>
					<label>
						避孕节育未落实措施类型：
					</label>
					<tags:js.dict.selector name="noMethodType" value="${noMethodType}" dictCode="JS1033"/>
				</p>
				<p>
					<label>
						未避孕原因：
					</label>
					<input name="noCause" type="text" size="30" value="${noCause}" />
				</p>
				<p>
					<label>
						避孕终止日期：
					</label>
					<input name="endDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						变化日期：
					</label>
					<input name="changeDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${changeDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						变化原因：
					</label>
					<input name="changeCause" type="text" size="30"
						value="${changeCause}" />
				</p>
				<p>
					<label>
						缓期原因：
					</label>
					<input name="delayCause" type="text" size="30"
						value="${delayCause}" />
				</p>
				<p>
					<label>
						缓期终止日期：
					</label>
					<input name="delayEndCause" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${delayEndCause}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						缓期鉴定单位：
					</label>
					<input name="delayCompany" type="text" size="30"
						value="${delayCompany}" />
				</p>
				<p>
					<label>
						缓期鉴定医生：
					</label>
					<input name="delayDoctor" type="text" size="30"
						value="${delayDoctor}" />
				</p>
				<p>
					<label>
						缓期鉴定日期：
					</label>
					<input name="delayDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${delayDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						登记日期：
					</label>
					<input name="regDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${regDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>

				<p>
					<label>
						补救措施：
					</label>
					<tags:js.dict.selector name="repairMethod" value="${repairMethod}" dictCode="JS1031"/>
				</p>
				<p>
					<label>
						补救措施时间：
					</label>
					<input name="repairDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${repairDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						补救措施地点：
					</label>
					<input name="repairAddress" type="text" size="30"
						value="${repairAddress}" />
				</p>
				<p>
					<label>
						 补救措施未落实措施类型：
					</label>
					<tags:js.dict.selector name="noRepairMethodType" value="${noRepairMethodType}" dictCode="JS1034"/>
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