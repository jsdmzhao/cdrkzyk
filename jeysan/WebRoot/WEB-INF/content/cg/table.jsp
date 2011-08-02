<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<form id="pagerForm" method="post" action="${ctx}/cg/table!list.action">
	<input type="hidden" id="pageNum" name="pageNo" value="${page.pageNo}" />
	<input type="hidden" id="numPerPage" name="pageSize" value="${page.pageSize}" />
	<input type="hidden" id="orderField" name="orderBy" value="${page.orderBy}" />
	
	<input type="hidden" name="tablenamelike" value="${param['tablenamelike']}" />
</form>

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/cg/table!list.action" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						表名称：<input type="text" name="tablenamelike" value="${param['tablenamelike']}"/> (可以输入前缀或者后缀，模糊查找)
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	<div class="pageContent">
<form id="form2" action="${ctx}/cg/table!saveTables.action" method="post" onsubmit="return validateCallback(this)">
		<input type="hidden" name="flag" id="flag"/>
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="javascript:" onclick="saveTemplate(false)"><span>保存</span></a></li>
				<li><a class="icon" href="javascript:" onclick="saveTemplate(true)"><span>生成项目模块</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" group="tablename_check" /></th>
					<th width="5%" align="center">序号</th>
					<th width="20%">表名</th>
					<th width="7%">主键</th>
					<th width="18%">前缀</th>
					<th width="20%">所属模块</th>
					<th width="20%">业务名称</th>
					<th width="5%" align="center">编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${tables}" varStatus="b">
				<tr target="sid_user" rel="${a.tablename}">
					<td><input id="AA_${a.tablename}" type="checkbox" name="tablename_check" value="${a.tablename}" <c:if test="${a.selected}">checked="checked"</c:if>/></td>
					<td>${b.index+1}</td>
					<td><input type="text" name="tableName" size="15" value="${a.tablename}" readonly="readonly"/></td>
					<td><input type="text" name="primaryKey" size="15" value="${a.varPrimaryKey}" readonly="readonly"/></td>
					<td><input type="text" name="tablePrefix" size="15" value="${a.tablePrefix}" id="BB_${a.tablename}"/></td>
					<td><input type="text" name="tableModule" size="15" value="${a.tableModule}" id="CC_${a.tablename}"/></td>
					<td><input type="text" name="tableLabel" size="15" value="${a.tableLabel}" id="DD_${a.tablename}"/></td>
					<td><div style="width: 25px;"><a mask="true" width="600" height="400" class="btnEdit" href="${ctx}/cg/table!getSubs.action?tableDto.tablename=${a.tablename}&tableDto.primaryKey=${a.primaryKey}&tableDto.tablePrefix={BB_${a.tablename}}&tableDto.tableModule={CC_${a.tablename}}&tableDto.tableLabel={DD_${a.tablename}}&hxhxhxhxhxhx" target="navTab" title="编辑列" onclick="boxChecked('AA_${a.tablename}')"></a></div></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="panelBar">
		</div>
</form>
	</div>
</div>