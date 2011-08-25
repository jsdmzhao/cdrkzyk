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
					投保类型：
				</label>
				<input name="typeh" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${typeh}"/>" />
			</p>
			<p>
				<label>
					投保年月：
				</label>
				<input name="dateh" readonly="readonly" type="text" size="30"
					value="${dateh}" />
			</p>
			<p>
				<label>
					投保金额：
				</label>
				<input name="moneyh" readonly="readonly" type="text" size="30"
					value="${moneyh}" />
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
