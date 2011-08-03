<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>监控类别：</label>
					<input name="monitorType" readonly="readonly" type="text" size="30" value="${monitorType}"/>
					</p>
																														<p>
					<label>是否打开：</label>
					<input name="switch" readonly="readonly" type="text" size="30" value="${switch}"/>
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
