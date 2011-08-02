<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form id="form3" action="${ctx}/cg/table!saveColumns.action" method="post" class="pageForm">
	<div class="pageHeader">
		<div class="searchBar">
			<div class="subBar" style="height:50px">
				<ul style="float:left">
					<li style="padding-top:2px"><div>表格名称：<input type="text" name="tableDto.tablename" value="${tableDto.tablename}" readonly="readonly"/></div></li>
					<li style="padding-top:2px"><div>主键：<input type="text" name="tableDto.primaryKey" value="${tableDto.primaryKey}" readonly="readonly"/></div></li>
					<li style="padding-top:2px"><div>表前缀：<input type="text" name="tableDto.tablePrefix" value="${tableDto.tablePrefix}" readonly="readonly"/></div></li>
					<li style="padding-top:2px"><div>业务名称：<input type="text" name="tableDto.tableLabel" value="${tableDto.tableLabel}" readonly="readonly"/></div></li>
					<li style="padding-top:2px"><div>模块：<input type="text" id="tableDto_tableModule" name="tableDto.tableModule" value="${tableDto.tableModule}" readonly="readonly"/></div></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="javascript:" onclick="validateModuleInColumn($('#tableDto_tableModule')[0].value)"><span>保存</span></a></li>
			</ul>
		</div>
		<div layoutH="116">
		<table class="list" width="98%">
			<thead>
				<tr>
					<th width="10%" style="text-align: center">序号</th>
					<th width="18%">名称</th>
					<th width="18%">类型</th>
					<th width="18%">长度</th>
					<th width="18%">能否为空</th>
					<th width="18%">业务名称</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${columns}" varStatus="b">
				<tr target="sid_user" rel="${a.varName}">
					<td style="text-align: center">${b.index+1}</td>
					<td><input type="text" name="columnName" size="15" value="${a.varName}" readonly="readonly"/></td>
					<td>${a.javaType}</td>
					<td>${a.length}</td>
					<td>${a.isNullable}</td>
					<td><input type="text" name="columnLabel" size="20" value="${a.columnLabel}" onchange="valueHasChanged(true)"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<div class="panelBar">
			<div class="pages">
				<span style="color:red" id="msgTip"></span>
			</div>
		</div>
	</div></form>
</div>