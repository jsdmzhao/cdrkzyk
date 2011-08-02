<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/cg/table!saveConf.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="result4Json.navTabId" value="nav_table_manage"/>
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>默认模块名称：</label>
					<input name="attribute.module" type="text" size="30" value="${attribute.module}"/>
				</p>
<div class="divider"></div>
				<p>
					<label>默认前缀名称：</label>
					<input name="attribute.prefix" type="text" size="30" value="${attribute.prefix}"/>
				</p>
<div class="divider"></div>
				<p style="width:100%">
					<label>项目路径：</label>
					<input name="attribute.projectrealpath" class="required" type="text" size="60" value="${attribute.projectrealpath}" alt="请输入项目路径"/>
				</p>
<div class="divider"></div>
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