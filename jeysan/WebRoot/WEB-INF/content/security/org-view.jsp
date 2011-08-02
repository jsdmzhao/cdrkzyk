<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>机构编码：</label>
					<input name="orgCode" readonly="readonly" type="text" size="30" value="${orgCode}"/>
				</p>
				<p>
					<label>机构名称：</label>
					<input name="orgName" readonly="readonly" type="text" size="30" value="${orgName}"/>
				</p>
				<p>
					<label>机构简称：</label>
					<input name="simpleName" readonly="readonly" type="text" size="30" value="${simpleName}"/>
				</p>
				<p>
					<label>上级机构：</label>
					<input name="parentOrgId" readonly="readonly" type="text" size="30" value="${parent.orgName}"/>
				</p>
				<p>
					<label>机构类型：</label>
					<input name="orgType" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${orgType}"/>"/>
				</p>
				<p>
					<label>是否末级机构：</label>
					<input name="isLeaf" readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${isLeaf}"/>"/>
				</p>
				<p>
					<label>是否有效：</label>
					<input name="disabledStatus" readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${disabledStatus}"/>"/>
				</p>
				<div class="divider"></div>
				<p>
					<label>级次：</label>
					<input name="levelNum" readonly="readonly" type="text" size="30" value="${levelNum}"/>
				</p>
				<p>
					<label>建档日期：</label>
					<input type="text" name="endDate" readonly="readonly" size="30"/>
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