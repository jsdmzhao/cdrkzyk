<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>用户名：</label>
					<input name="userName" readonly="readonly" type="text" size="30" value="${userName}"/>
					</p>
																														<p>
					<label>用户编码：</label>
					<input name="userCode" readonly="readonly" type="text" size="30" value="${userCode}"/>
					</p>
																														<p>
					<label>所属机构：</label>
					<input name="orgId" readonly="readonly" type="text" size="30" value="${org.orgName}"/>
					</p>
																														<p>
					<label>是否有效：</label>
					<input name="userEnabled" readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${userEnabled}"/>"/>
					</p>
					<div class="divider"></div>													
		<table class="list" style="width:100%">
			<thead>
				<tr>
					<th width="30" style="text-align: center">序号</th>
					<th width="100">角色名称</th>
					<th width="80">角色编码</th>
					<th width="280">角色描述</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${roleList}" varStatus="b">
				<tr>
					<td style="text-align: center">${b.index+1}</td>
					<td>${a.roleName}</td>
					<td>${a.roleCode}</td>
					<td>${a.roleInfo}</td>
				</tr>
				</c:forEach>
				<c:if test="${fn:length(roleList)==0}">
				<tr>
					<td style="text-align: center">1</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
			</tbody>
		</table>	
<div class="divider"></div>													
		<table class="list" style="width:100%">
			<thead>
				<tr>
					<th width="30" style="text-align: center">序号</th>
					<th width="100">职务名称</th>
					<th width="80">职务编码</th>
					<th width="280">职责</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${postList}" varStatus="b">
				<tr>
					<td style="text-align: center">${b.index+1}</td>
					<td>${a.postName}</td>
					<td>${a.postCode}</td>
					<td>${a.postContent}</td>
				</tr>
				</c:forEach>
				<c:if test="${fn:length(postList)==0}">
				<tr>
					<td style="text-align: center">1</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
			</tbody>
		</table>	
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
