<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageHeader">
<form id="queryForm" onsubmit="return navTabSearch(this);" method="post" action="${ctx}/security/user!preAssignRoles.action">
<input type="hidden" name="id" value="${model.id}"/>
		<div class="searchBar">
			<div class="subBar">
				<ul style="float:left;">
					<li style="padding-top:2px"><div>用户名称：<input type="text" value="${model.userName}" readonly="readonly"/></div></li>
					<li style="padding-top:2px"><div>用户编码：<input type="text" value="${model.userCode}" readonly="readonly"/></div></li>
					<li style="padding-top:2px"><div>所属机构：<input type="text" value="${model.org.orgName}" readonly="readonly"/></div></li>
				</ul>
			</div>
			<div class="subBar">
				<ul style="float:left;">
					<li style="padding-top:2px"><div>角色名称：<input type="text" name="roleName" value="${roleName}"/></div></li>
					<li style="padding-top:2px"><div>角色编码：<input type="text" name="roleCode" value="${roleCode}"/></div></li>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			</div>
		</div></form>
	</div>
	<div class="pageContent">
<form id="form3" action="${ctx}/security/user!saveAssignRoles.action" method="post" onsubmit="return validateCallback(this)">
		<input type="hidden" name="id" value="${model.id}"/>
		<table class="table" layouth="111">
			<thead>
				<tr>
					<th width="30" align="center"><input type="checkbox" class="checkboxCtrl" group="checkedRoleIds" /></th>
					<th width="40" align="center">序号</th>
																																			<th width="100">角色名称</th>
																														<th width="80">角色编码</th>
																														<th width="280">角色描述</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${allRoles}" varStatus="b">
				<tr target="sid_xxx" rel="${a.id}">
					<td><input type="checkbox" name="checkedRoleIds" value="${a.id}" <tags:js.contains value="${a.id}" collection="${checkedRoleIds}">checked="checked"</tags:js.contains>/></td>
					<td>${b.index+1}</td>
																																								<td>${a.roleName}</td>
																																								<td>${a.roleCode}</td>
																																								<td>${a.roleInfo}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="panelBar">
			<ul style="float:right;">
					<li style="height:50px;"><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li style="height:50px;">
						<div class="button"><div class="buttonContent"><button type="Button" onclick="$('#form3')[0].reset()">重置</button></div></div>
					</li>
					<li style="height:50px;margin-right:5px">
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
			</ul>
		</div></form>
	</div>
</div>