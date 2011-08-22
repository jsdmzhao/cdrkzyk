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
					教育类型：
				</label>
				<input name="eduType" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${eduType}"/>" />
			</p>
			<p>
				<label>
					教育日期：
				</label>
				<input name="eduDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${eduDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					教育地点：
				</label>
				<input name="eduAddress" readonly="readonly" type="text" size="30"
					value="${eduAddress}" />
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
