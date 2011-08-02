<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>职务名称：</label>
					<input name="postName" readonly="readonly" type="text" size="30" value="${postName}"/>
					</p>
																														<p>
					<label>职务编码：</label>
					<input name="postCode" readonly="readonly" type="text" size="30" value="${postCode}"/>
					</p>
																														<p>
					<label>是否有效：</label>
					<input name="postEnabled" readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${postEnabled}"></tags:js.yes.no.getValue>"/>
					</p>
																														<p>
					<label>职责：</label>
					<input name="postContent" readonly="readonly" type="text" size="30" value="${postContent}"/>
					</p>
																		</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
</div>
