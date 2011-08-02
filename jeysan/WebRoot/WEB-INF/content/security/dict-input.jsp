<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/security/dict!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_dictmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>字典名称：</label>
					<input name="dictName"  class="required" maxlength="50"    type="text" size="30" value="${dictName}"  alt="请输入字典名称" />
					</p>
																													<p>
					<label>字典编码：</label>
					<input name="dictCode" class="required" maxlength="20" type="text" size="30" value="${dictCode}" />
					</p>

																													<p>
					<label>父类字典：</label>
					<input name="parentId" class="digits" type="text" size="30" value="${parent.id}" />
					</p>

					<p style="width:100%;height:130px">
					<label>字典描述：</label>
					<textarea name="dictInfo" maxlength="200" cols="25" rows="5">${dictInfo}</textarea>
					</p>

<div class="divider"></div>
																													<p>
					<label>字典是否有效：</label>
					<tags:js.yes.no.selector name="dictStatus" value="${dictStatus}"/>
					</p>
																													<p>
					<label>是否可以修改：</label>
					<tags:js.yes.no.selector name="canModified" value="${canModified}"/>
					</p>
																													<p>
					<label>是否末级：</label>
					<tags:js.yes.no.selector name="isLeaf" value="${isLeaf}"/>
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