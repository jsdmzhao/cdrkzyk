<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						姓名：
					</label>
					<input name="womanId" readonly="readonly" type="text"
						size="30" value="${fertileWoman.person.nameh}" />
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
					避孕节育措施：
				</label>
				<input name="method" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${method}"/>" />
			</p>
			<p>
				<label>
					手术医院类型：
				</label>
				<input name="hospitalType" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${hospitalType}"/>" />
			</p>
			<p>
				<label>
					手术医生：
				</label>
				<input name="doctor" readonly="readonly" type="text" size="30"
					value="${doctor}" />
			</p>
			<p>
				<label>
					手术医院：
				</label>
				<input name="hospital" readonly="readonly" type="text" size="30"
					value="${hospital}" />
			</p>
			<p>
				<label>
					手术日期：
				</label>
				<input name="opsDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${opsDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					手术医院地址：
				</label>
				<input name="hospitalAddress" readonly="readonly" type="text"
					size="30" value="${hospitalAddress}" />
			</p>
			<p>
				<label>
					未避孕原因：
				</label>
				<input name="noCause" readonly="readonly" type="text" size="30"
					value="${noCause}" />
			</p>
			<p>
				<label>
					避孕终止日期：
				</label>
				<input name="endDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					变化日期：
				</label>
				<input name="changeDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${changeDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					变化原因：
				</label>
				<input name="changeCause" readonly="readonly" type="text" size="30"
					value="${changeCause}" />
			</p>
			<p>
				<label>
					缓期原因：
				</label>
				<input name="delayCause" readonly="readonly" type="text" size="30"
					value="${delayCause}" />
			</p>
			<p>
				<label>
					缓期终止日期：
				</label>
				<input name="delayEndCause" readonly="readonly" type="text"
					size="30"
					value="<fmt:formatDate value="${delayEndCause}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					缓期鉴定单位：
				</label>
				<input name="delayCompany" readonly="readonly" type="text" size="30"
					value="${delayCompany}" />
			</p>
			<p>
				<label>
					缓期鉴定医生：
				</label>
				<input name="delayDoctor" readonly="readonly" type="text" size="30"
					value="${delayDoctor}" />
			</p>
			<p>
				<label>
					缓期鉴定日期：
				</label>
				<input name="delayDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${delayDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					登记日期：
				</label>
				<input name="regDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${regDate}" pattern="yyyy-MM-dd"/>" />
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
