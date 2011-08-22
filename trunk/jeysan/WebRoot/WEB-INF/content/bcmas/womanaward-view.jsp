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
					奖励日期：
				</label>
				<input name="awardDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${awardDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					奖励内容：
				</label>
				<input name="awardContent" readonly="readonly" type="text" size="30"
					value="${awardContent}" />
			</p>
			<p>
				<label>
					奖励经办人：
				</label>
				<input name="agent" readonly="readonly" type="text" size="30"
					value="${agent}" />
			</p>
			<p>
				<label>
					奖励类别：
				</label>
				<input name="typeh" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${typeh}"/>" />
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
