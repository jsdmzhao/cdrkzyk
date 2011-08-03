<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>证书ID：</label>
					<input name="certId" readonly="readonly" type="text" size="30" value="${certId}"/>
					</p>
																														<p>
					<label>内容：</label>
					<input name="content" readonly="readonly" type="text" size="30" value="${content}"/>
					</p>
																														<p>
					<label>日期：</label>
					<input name="dateh" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>经办人：</label>
					<input name="agent" readonly="readonly" type="text" size="30" value="${agent}"/>
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
