<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post"
			action="${ctx}/bcmas/womansocialupbring!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="isPayup" value="0" />
			<input type="hidden" name="yetMoney" value="0" />
			<input type="hidden" name="fertileWoman.id"
				value="${fertileWoman.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_womansocialupbringmanage" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						姓名：
					</label>
					<input name="womanId" readonly="readonly" type="text" size="30"
						value="${fertileWoman.nameh}" />
				</p>
				<p>
					<label>
						妇女编码：
					</label>
					<input name="womanId" readonly="readonly" type="text" size="30"
						value="${fertileWoman.code}" />
				</p>
				<p>
					<label>
						征收原因：
					</label>
					<tags:js.dict.selector name="cause" value="${cause}" dictCode="JS1075"/>
				</p>
				<p>
					<label>
						政策外生育日期：
					</label>
					<input name="outDate" class="date " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${outDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						应交金额：
					</label>
					<input name="totalMoney" class="number" type="text" size="30"
						value="${totalMoney}" />
				</p>
				<p>
					<label>
						是否分期：
					</label>
					<tags:js.yes.no.selector name="isInstallment" value="${isInstallment}"/>
				</p>
				<p>
					<label>
						分期数：
					</label>
					<input name="installmentNum" class="digits" type="text" size="30"
						value="${installmentNum}" />
				</p>
				<p>
					<label>
						缴交期限：
					</label>
					<input name="endDate" class="date " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						决定书编号：
					</label>
					<input name="lodCode" type="text" size="30" value="${lodCode}" />
				</p>
				<p>
					<label>
						决定书日期：
					</label>
					<input name="lodDate" class="date " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${lodDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						征收机关：
					</label>
					<input name="lodOrg" type="text" size="30" value="${lodOrg}" />
				</p>
				<p>
					<label>
						征收机关类型：
					</label>
					<tags:js.dict.selector name="lodType" value="${lodType}" dictCode="JS1070"/>
				</p>
				<p>
					<label>
						征收经办人：
					</label>
					<input name="lodCharger" type="text" size="30"
						value="${lodCharger}" />
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