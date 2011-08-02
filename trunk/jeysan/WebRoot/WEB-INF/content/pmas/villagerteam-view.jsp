<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>行政区编码：</label>
					<input name="orgCode" readonly="readonly" type="text" size="30" value="${orgCode}"/>
					</p>
																														<p>
					<label>小组名称：</label>
					<input name="teamName" readonly="readonly" type="text" size="30" value="${teamName}"/>
					</p>
																														<p>
					<label>小组序号：</label>
					<input name="teamIndex" readonly="readonly" type="text" size="30" value="${teamIndex}"/>
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
