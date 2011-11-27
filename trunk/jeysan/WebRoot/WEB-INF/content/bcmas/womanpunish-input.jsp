<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/womanpunish!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="fertileWoman.id"
				value="${fertileWoman.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_womanpunishmanage" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						姓名：
					</label>
					<input name="womanId" readonly="readonly" type="text"
						size="30" value="${fertileWoman.nameh}" />
				</p>
				<p>
					<label>
						妇女编码：
					</label>
					<input name="womanId" readonly="readonly"  type="text"
						size="30" value="${fertileWoman.code}" />
				</p>
				<p>
					<label>
						处罚日期：
					</label>
					<input name="punishDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${punishDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						处罚原因：
					</label>
					<input name="punishCause" type="text" size="30"
						value="${punishCause}" />
				</p>
				<p>
					<label>
						处罚经办人：
					</label>
					<input name="agent" type="text" size="30" value="${agent}" />
				</p>
				<p>
					<label>
						处罚金额：
					</label>
					<input name="moneyh" class="digits" type="text" size="30"
						value="${moneyh}" />
				</p>
				<p>
					<label>
						处罚次数：
					</label>
					<input name="count" class="digits" type="text" size="30"
						value="${count}" />
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