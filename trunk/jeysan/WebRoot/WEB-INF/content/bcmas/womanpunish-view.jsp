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
					value="${fertileWoman.person.nameh}" />
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
					处罚日期：
				</label>
				<input name="punishDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${punishDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					处罚原因：
				</label>
				<input name="punishCause" readonly="readonly" type="text" size="30"
					value="${punishCause}" />
			</p>
			<p>
				<label>
					处罚经办人：
				</label>
				<input name="agent" readonly="readonly" type="text" size="30"
					value="${agent}" />
			</p>
			<p>
				<label>
					处罚金额：
				</label>
				<input name="moneyh" readonly="readonly" type="text" size="30"
					value="${moneyh}" />
			</p>
			<p>
				<label>
					处罚次数：
				</label>
				<input name="count" readonly="readonly" type="text" size="30"
					value="${count}" />
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
