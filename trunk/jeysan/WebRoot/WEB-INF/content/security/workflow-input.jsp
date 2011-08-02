<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/security/workflow!save.action" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this)">
			<input type="hidden" name="result4Json.navTabId" value="nav_workflowmanage"/>
			<div class="pageFormContent" layoutH="56">
					<p style="width:100%;">
					<label>流程定义文件：</label>
					<input name="upload" type="file" class="required" size="70"/>
					</p>	

<div class="divider"></div>	
					
																													<p>
					<label>是否有效：</label><tags:js.yes.no.selector name="state"/>
					
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