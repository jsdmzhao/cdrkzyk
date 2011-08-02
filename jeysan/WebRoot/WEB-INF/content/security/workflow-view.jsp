<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>流程Id：</label>
					<input name="processId" readonly="readonly" type="text" size="30" value="${processId}"/>
					</p>
																														<p>
					<label>流程名称：</label>
					<input name="name" readonly="readonly" type="text" size="30" value="${name}"/>
					</p>
																														<p>
					<label>中文名称：</label>
					<input name="displayName" readonly="readonly" type="text" size="30" value="${displayName}"/>
					</p>
																														<p>
					<label>版本号：</label>
					<input name="version" readonly="readonly" type="text" size="30" value="${version}"/>
					</p>
																														<p>
					<label>上载人：</label>
					<input name="uploadUser" readonly="readonly" type="text" size="30" value="<tags:js.user.getValue property="userName" value="${uploadUser}"></tags:js.user.getValue>"/>
					</p>
																														<p>
					<label>上载时间：</label>
					<input name="uploadTime" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${uploadTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
					</p>
					
																														<p>
					<label>发布人：</label>
					<input name="publishUser" readonly="readonly" type="text" size="30" value="<tags:js.user.getValue property="userName" value="${publishUser}"></tags:js.user.getValue>"/>
					</p>
																														<p>
					<label>发布时间：</label>
					<input name="publishTime" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${publishTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
					</p>
					
																														<p>
					<label>是否有效：</label>
					<input name="state" readonly="readonly" type="text" size="30" value="${state?'有效':'无效'}"/>
					</p>													</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>
