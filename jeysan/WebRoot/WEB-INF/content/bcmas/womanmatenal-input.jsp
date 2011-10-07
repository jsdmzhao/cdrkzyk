<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/womanmatenal!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="fertileWoman.id"
				value="${fertileWoman.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_womanmatenalmanage" />
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
						怀孕政策属性：
					</label>
					<tags:js.dict.selector name="conceptPolicy" value="${conceptPolicy}" dictCode="JS1056"/>
				</p>
				<p>
					<label>
						怀孕日期：
					</label>
					<input name="conceptDate" class="date " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${conceptDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						怀孕原因：
					</label>
					<input name="conceptCause" type="text" size="30"
						value="${conceptCause}" />
				</p>
				<p>
					<label>
						现孕状态：
					</label>
					<tags:js.dict.selector name="currentConceptStatus" value="${currentConceptStatus}" dictCode="JS1030"/>
				</p>
				<p>
					<label>
						怀孕结果：
					</label>
					<tags:js.dict.selector name="conceptResult" value="${conceptResult}" dictCode="JS1055"/>
				</p>
				<p>
					<label>
						预产期：
					</label>
					<input name="edd" class="date " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${edd}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						妇女生产方式：
					</label>
					<tags:js.dict.selector name="typeh" value="${typeh}" dictCode="JS1054"/>
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
						孕产结果：
					</label>
					<tags:js.dict.selector name="matenalResult" value="${matenalResult}" dictCode="JS1032"/>
				</p>
				<p>
					<label>
						手术日期：
					</label>
					<input name="endDate" class="date " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						手术医院：
					</label>
					<input name="hospital" type="text" size="30" value="${hospital}" />
				</p>
				<p>
					<label>
						手术医生：
					</label>
					<input name="doctor" type="text" size="30" value="${doctor}" />
				</p>
				<p>
					<label>
						手术医院类型：
					</label>
					<tags:js.dict.selector name="hospitalType" value="${hospitalType}" dictCode="JS1053"/>
				</p>
				<p>
					<label>
						变化日期：
					</label>
					<input name="changeDate" class="date " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${changeDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						变化原因：
					</label>
					<input name="changeCause" type="text" size="30"
						value="${changeCause}" />
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