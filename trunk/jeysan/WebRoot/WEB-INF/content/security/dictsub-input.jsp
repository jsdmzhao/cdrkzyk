<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form id="form3" action="${ctx}/security/dict!saveSubs.action" method="post" class="pageForm" onsubmit="return validateSubs(this);">
<input type="hidden" name="id" value="${entity.id}"/>
	<div class="pageHeader">
		<div class="searchBar">
			<div class="subBar">
				<ul style="float:left">
					<li style="padding-top:2px"><div>字典名称：<input type="text" value="${entity.dictName}" readonly="readonly"/></div></li>
					<li style="padding-top:2px"><div>字典编码：<input type="text" value="${entity.dictCode}" readonly="readonly"/></div></li>
					<li style="padding-top:2px"><div>字典描述：<input type="text" value="${entity.dictInfo}" readonly="readonly"/></div></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="javascript:" onclick="operateRow('add')"><span>增加一行</span></a></li>
				<li><a class="delete" href="javascript:" onclick="operateRow('delete')"><span>减少一行</span></a></li>
			</ul>
		</div>
		<div layoutH="91">
		<table class="list" width="98%">
			<thead>
				<tr>
					<th width="10%" style="text-align: center">序号</th>
					<th width="18%">子项名称(<font color="red">*必选</font>)</th>
					<th width="12%">子项编码</th>
					<th width="36%">子项描述</th>
					<th width="12%">子项颜色</th>
					<th width="12%">子项序号(<font color="red">数字</font>)</th>
				</tr>
			</thead>
			<tbody id="tr_list">
				<c:forEach var="a" items="${entity.dictSubList}" varStatus="b">
				<tr target="rowIndex" rel="${b.index+1}">
					<td style="text-align: center"><span>${b.index+1}</span><input type="hidden" name="subId" value="${a.id}"/></td>
					<td><input type="text" name="subName_${b.index+1}" class="required" maxlength="20" size="15" value="${a.subName}"/></td>
					<td><input type="text" name="subCode_${b.index+1}" maxlength="20" size="15" value="${a.subCode}"/></td>
					<td><input type="text" name="subInfo_${b.index+1}" maxlength="50" size="35" value="${a.subInfo}"/></td>
					<td><input type="text" name="subColor_${b.index+1}" size="15" maxlength="10" value="${a.subColor}"/></td>
					<td><input type="text" name="subIndex_${b.index+1}" class="digits" size="15" value="${a.subIndex}"/></td>
				</tr>
				</c:forEach>
				<c:if test="${fn:length(entity.dictSubList)==0}">
				<tr target="rowIndex" rel="1">
					<td style="text-align: center"><span>1</span><input type="hidden" name="subId" value="-1"/></td>
					<td><input type="text" name="subName_1" class="required" maxlength="20" size="15"/></td>
					<td><input type="text" name="subCode_1" maxlength="20" size="15"/></td>
					<td><input type="text" name="subInfo_1" maxlength="50" size="35"/></td>
					<td><input type="text" name="subColor_1" size="15" maxlength="10"/></td>
					<td><input type="text" name="subIndex_1" class="digits" size="15"/></td>
				</tr>
				</c:if>
			</tbody>
		</table>
		</div>
		<div class="panelBar">
			<span id="msgTip" style="color:red;float:left;margin:8px 0 0 2px"></span>
			<ul style="float:right;">
					<li style="height:50px;"><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li style="height:50px;">
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.reload()">重置</button></div></div>
					</li>
					<li style="height:50px;margin-right:5px">
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
			</ul>
		</div>
	</div></form>
</div>
