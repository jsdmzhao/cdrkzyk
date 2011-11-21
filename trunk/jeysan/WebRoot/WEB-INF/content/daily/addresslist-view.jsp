<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					姓名：
				</label>
				<input name="nameh" readonly="readonly" type="text" size="30"
					value="${nameh}" />
			</p>
			<p>
				<label>
					固话：
				</label>
				<input name="telPhone" readonly="readonly" type="text" size="30"
					value="${telPhone}" />
			</p>
			<p>
				<label>
					移动电话：
				</label>
				<input name="mobilePhone" readonly="readonly" type="text" size="30"
					value="${mobilePhone}" />
			</p>
			<p>
				<label>
					常用邮箱：
				</label>
				<input name="email" readonly="readonly" type="text" size="30"
					value="${email}" />
			</p>
			<p>
				<label>
					单位：
				</label>
				<input name="company" readonly="readonly" type="text" size="30"
					value="${company}" />
			</p>
			<p>
				<label>
					住址：
				</label>
				<input name="address" readonly="readonly" type="text" size="30"
					value="${address}" />
			</p>
			<p>
				<label>
					分组：
				</label>
				<input name="grouph" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${grouph}"/>" />
			</p>
			<p>
				<label>
					备注：
				</label>
				<input name="remark" readonly="readonly" type="text" size="30"
					value="${remark}" />
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
