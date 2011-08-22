<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/pmas/person!list4lookup.action">
	<input type="hidden" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQS_code" value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_EQS_personCode" value="${param['filter_EQS_personCode']}" />
	<input type="hidden" name="filter_EQI_sex" value="${param['filter_EQI_sex']}" />
	<input type="hidden" name="filter_EQI_certType" value="${param['filter_EQI_certType']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQI_kind" value="${param['filter_EQI_kind']}" />
	<input type="hidden" name="filter_EQI_cancelType" value="${param['filter_EQI_cancelType']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return dwzSearch(this, 'dialog');" action="${ctx}/pmas/person!list4lookup.action" method="post">
		<div class="searchBar">

			<table class="searchContent">
				<tr>
					<td>
						姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}"/>
					</td>
					<td>
						性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<tags:js.dict.selector noRender="true" name="filter_EQI_sex" value="${param['filter_EQI_sex']}" dictCode="JS010"/>
					</td>
					<td>
						人员类别：<tags:js.dict.selector noRender="true" name="filter_EQI_kind" value="${param['filter_EQI_kind']}" dictCode="JS1050"/>
					</td>
					<td>
						人员编号：&nbsp;&nbsp;<input type="text" name="filter_EQS_personCode" value="${param['filter_EQS_personCode']}"/>
					</td>
				</tr>
				<tr>
					<td>
						证件号码：<input type="text" name="filter_EQS_code" value="${param['filter_EQS_code']}"/>
					</td>
					<td>
						证件类型：<tags:js.dict.selector noRender="true" name="filter_EQI_certType" value="${param['filter_EQI_certType']}" dictCode="JS1043"/>
					</td>
					<td>
						户口类别：<tags:js.dict.selector noRender="true" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" dictCode="JS1048"/>
					</td><td>
						人员状态：<tags:js.dict.selector noRender="true" name="filter_EQI_cancelType" value="${param['filter_EQI_cancelType']}" dictCode="JS1010"/>
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
		<table class="table" targettype="dialog" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
																																			<th width="80" orderField="nameh" class="orderFlag">姓名</th>
																														<th width="80" orderField="sex" class="orderFlag">性别</th>
																														<th width="80" orderField="certType" class="orderFlag">证件类型</th>
																														<th width="120" orderField="code" class="orderFlag">证件号码</th>
																														<th width="80" orderField="personCode" class="orderFlag">人员编号</th>
																														<th width="80" orderField="domicileType" class="orderFlag">户口类别</th>
																														<th width="80" orderField="domicileType" class="orderFlag">人员类别</th>
																																																																																																																																												<th width="30" align="center">操作</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td>${b.index+1}</td>
																																								<td>${a.nameh}</td>
																																								<td><tags:js.dict.getValue value="${a.sex}"></tags:js.dict.getValue></td>
																																								<td><tags:js.dict.getValue value="${a.certType}"></tags:js.dict.getValue></td>
																																								<td>${a.code}</td>
																																								<td>${a.personCode}</td>
																																								<td><tags:js.dict.getValue value="${a.domicileType}"></tags:js.dict.getValue></td>
																																								<td><tags:js.dict.getValue value="${a.kind}"></tags:js.dict.getValue></td>
																																																																																																																																																	<td>
						<div style="width: 30px;">
							<a class="btnSelect" href="javascript:$.bringBack({personId:'${a.id}', nameh:'${a.nameh}', sex:'<tags:js.dict.getValue value="${a.sex}"/>', certType:'<tags:js.dict.getValue value="${a.certType}"/>', code:'${a.code}', birthday:'<fmt:formatDate value="${a.personBasic.birthday}" pattern="yyyy-MM-dd"/>', age:'${a.age}', marryStatus:'<tags:js.dict.getValue value="${a.personBasic.marryStatus}"/>',childrenCount:'${fn:length(a.womanChildrenLst)}'})" title="确定带回">选择</a>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot4dwz.jsp"  %>
	</div>
</div>