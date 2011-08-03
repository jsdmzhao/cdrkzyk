<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>操作时间：</label>
					<input name="operatTime" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${operatTime}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>操作人：</label>
					<input name="operator" readonly="readonly" type="text" size="30" value="${operator}"/>
					</p>
																														<p>
					<label>操作人IP：</label>
					<input name="operatIp" readonly="readonly" type="text" size="30" value="${operatIp}"/>
					</p>
																														<p>
					<label>操作内容：</label>
					<input name="content" readonly="readonly" type="text" size="30" value="${content}"/>
					</p>
																														<p>
					<label>持续时间(S)：</label>
					<input name="lastTime" readonly="readonly" type="text" size="30" value="${lastTime}"/>
					</p>
																														<p>
					<label>影响行数：</label>
					<input name="effectRows" readonly="readonly" type="text" size="30" value="${effectRows}"/>
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
