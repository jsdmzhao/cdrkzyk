<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/security/resource!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_resourcemanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>资源编码：</label>
					<input name="resourceCode"    type="text" size="30" value="${resourceCode}" />
					</p>
																													<p>
					<label>资源名称：</label>
					<input name="resourceName"  class="required" maxlength="50"    type="text" size="30" value="${resourceName}"  alt="请输入资源名称" />
					</p>
																													<p>
					<label>资源类型：</label><tags:js.dict.selector name="resourceType"  value="${resourceType}" dictCode="JS030"/>
					</p>
																													<p>
					<label>资源值：</label>
					<input name="resourceValue"  class="required" maxlength="100"    type="text" size="30" value="${resourceValue}"  alt="请输入资源值" />
					</p>
																													<p>
					<label>父资源：</label><tags:js.map.selector result="${topLevelResource}" name="parentId" value="${parent.id}"></tags:js.map.selector>
					</p>
																													<p>
					<label>资源序号：</label>
					<input name="resourceIndex"  class="required digits" type="text" size="30" value="${resourceIndex}" />
					</p>
																													<p>
					<label>资源层级：</label>
					<input name="resourceLevel"  class="required digits" type="text" size="30" value="${resourceLevel}" />
					</p>
																													<p>
					<label>对应实体名：</label>
					<input name="entityName"    type="text" size="30" value="${entityName}" />
					</p>
																	</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>