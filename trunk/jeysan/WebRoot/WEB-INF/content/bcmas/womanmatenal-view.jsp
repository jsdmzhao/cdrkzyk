<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
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
				<input name="conceptPolicy" readonly="readonly" type="text"
					size="30" value="<tags:js.dict.getValue value="${conceptPolicy}"/>" />
			</p>
			<p>
				<label>
					怀孕日期：
				</label>
				<input name="conceptDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${conceptDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					怀孕原因：
				</label>
				<input name="conceptCause" readonly="readonly" type="text" size="30"
					value="${conceptCause}" />
			</p>
			<p>
				<label>
					怀孕结果：
				</label>
				<input name="conceptResult" readonly="readonly" type="text"
					size="30" value="<tags:js.dict.getValue value="${conceptResult}"/>" />
			</p>
			<p>
				<label>
					预产期：
				</label>
				<input name="edd" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${edd}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					妇女生产方式：
				</label>
				<input name="typeh" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${typeh}"/>" />
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
					孕产结果：
				</label>
				<input name="matenalResult" readonly="readonly" type="text"
					size="30" value="<tags:js.dict.getValue value="${matenalResult}"/>" />
			</p>
			<p>
				<label>
					手术日期：
				</label>
				<input name="endDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>" />
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
					手术医生：
				</label>
				<input name="doctor" readonly="readonly" type="text" size="30"
					value="${doctor}" />
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
