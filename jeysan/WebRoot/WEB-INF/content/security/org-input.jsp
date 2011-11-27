<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/security/org!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_orgmanage"/>
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>机构编码：</label>
					<input name="orgCode" class="required" type="text" size="30" value="${orgCode}" alt="请输入机构编码"/>
				</p>
				<p>
					<label>机构名称：</label>
					<input name="orgName" class="required" type="text" size="30" value="${orgName}" alt="请输入机构名称"/>
				</p>
				<p>
					<label>机构简称：</label>
					<input name="simpleName" type="text" size="30" value="${simpleName}"/>
				</p>
				<p>
					<label>上级机构：</label>
					<tags:js.org.selector isRequired="false" o1="parentId" o1_v="${parent.id}" o2_v="${parent.orgName}"/>
				</p>
				<p>
					<label>机构类型：</label><tags:js.dict.selector name="orgType"  value="${orgType}" dictCode="JS020"/>
				</p>
				<p>
					<label>是否末级机构：</label><tags:js.yes.no.selector name="isLeaf" value="${isLeaf}"/>
					
				</p>
				<p>
					<label>是否有效：</label><tags:js.yes.no.selector name="disabledStatus" value="${disabledStatus}"/>
					
				</p>
				<div class="divider"></div>
				<p>
					<label>级次：</label>
					<input name="levelNum" class="digits" type="text" size="30" value="${levelNum}" readonly="readonly"/>
				</p>
				<p>
					<label>建档日期：</label>
					<input type="text" name="endDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" size="30" readonly="readonly"/>
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