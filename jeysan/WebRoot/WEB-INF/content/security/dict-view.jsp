<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>字典名称：</label>
					<input name="dictName" readonly="readonly" type="text" size="30" value="${dictName}"/>
					</p>
																														<p>
					<label>字典编码：</label>
					<input name="dictCode" readonly="readonly" type="text" size="30" value="${dictCode}"/>
					</p>
																														<p>
					<label>字典是否有效：</label>
					<input name="dictStatus" readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${dictStatus}"/>"/>
					</p>
																														<p>
					<label>字典描述：</label>
					<input name="dictInfo" readonly="readonly" type="text" size="30" value="${dictInfo}"/>
					</p>
																														<p>
					<label>是否可以修改：</label>
					<input name="canModified" readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${canModified}"/>"/>
					</p>
																														<p>
					<label>是否末级：</label>
					<input name="isLeaf" readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${isLeaf}"/>"/>
					</p>
																														<p>
					<label>父类字典：</label>
					<input name="parentId" readonly="readonly" type="text" size="30" value="${parentId}"/>
					</p>
<div class="divider"></div>
		<table class="list" style="width:100%">
			<thead>
				<tr>
					<th width="10%" style="text-align: center">序号</th>
					<th width="18%">子项名称</th>
					<th width="12%">子项编码</th>
					<th width="36%">子项描述</th>
					<th width="12%">子项颜色</th>
					<th width="12%">子项序号</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${dictSubList}" varStatus="b">
				<tr>
					<td style="text-align: center">${b.index+1}</td>
					<td>${a.subName}</td>
					<td>${a.subCode}</td>
					<td>${a.subInfo}</td>
					<td>${a.subColor}</td>
					<td>${a.subIndex}</td>
				</tr>
				</c:forEach>
				<c:if test="${fn:length(dictSubList)==0}">
				<tr>
					<td style="text-align: center">1</td>
					<td></td>
					<td></td>
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
