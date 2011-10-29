<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					本次双查总次数：
				</label>
				<input name="total" readonly="readonly" type="text" size="30"
					value="${total}" />
			</p>
			<p>
				<label>
					年度：
				</label>
				<input name="year" readonly="readonly" type="text" size="30"
					value="${year}" />
			</p>
			<p>
				<label>
					轮次：
				</label>
				<input name="seq" readonly="readonly" type="text" size="30"
					value="${seq}" />
			</p>
			<p>
				<label>
					起始年月：
				</label>
				<input name="start" readonly="readonly" type="text" size="30"
					value="${start}" />
			</p>
			<p>
				<label>
					结束年月：
				</label>
				<input name="end" readonly="readonly" type="text" size="30"
					value="${end}" />
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
