<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>资源编码：</label>
					<input name="resourceCode" readonly="readonly" type="text" size="30" value="${resourceCode}"/>
					</p>
																														<p>
					<label>资源名称：</label>
					<input name="resourceName" readonly="readonly" type="text" size="30" value="${resourceName}"/>
					</p>
																														<p>
					<label>资源类型：</label>
					<input name="resourceType" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${resourceType}"/>"/>
					</p>
																														<p>
					<label>资源值：</label>
					<input name="resourceValue" readonly="readonly" type="text" size="30" value="${resourceValue}"/>
					</p>
																														<p>
					<label>父资源：</label>
					<input name="resourceParent" readonly="readonly" type="text" size="30" value="${parent.resourceName}"/>
					</p>
																														<p>
					<label>资源序号：</label>
					<input name="resourceIndex" readonly="readonly" type="text" size="30" value="${resourceIndex}"/>
					</p>
																														<p>
					<label>资源层级：</label>
					<input name="resourceLevel" readonly="readonly" type="text" size="30" value="${resourceLevel}"/>
					</p>
																														<p>
					<label>对应实体名：</label>
					<input name="entityName" readonly="readonly" type="text" size="30" value="${entityName}"/>
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
</div>
