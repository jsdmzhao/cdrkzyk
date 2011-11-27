<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/fertilewoman!list4lookup.action">
	<input type="hidden" name="filter_LIKES_nameh"
		value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQI_typeh" 
		value="${param['filter_EQI_typeh']}" />
	<input type="hidden" name="filter_EQD_createDate"
		value="${param['filter_EQD_createDate']}" />
	<input type="hidden" name="filter_EQS_code"
		value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_EQS_area"
		value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_registerType" 
		value="${param['filter_EQI_registerType']}" />
	<input type="hidden" name="filter_EQI_birth2Type" 
		value="${param['filter_EQI_birth2Type']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return dwzSearch(this, 'dialog');"
			action="${ctx}/bcmas/fertilewoman!list4lookup.action?type=${param['type']}"
			method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_nameh"
								value="${param['filter_LIKES_nameh']}" />
						</td>
						<td>
							建卡日期：
							<input type="text" name="filter_EQD_createDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param['filter_EQD_createDate']}" />
						</td>
						<td>
							编号：
							<input type="text" name="filter_EQS_code"
								value="${param['filter_EQS_code']}" />
						</td>
						<td>
							区域：
							<input type="text" name="filter_EQS_area"
								value="${param['filter_EQS_area']}" />
						</td>
					</tr>
					<tr>
						<td>
							户口类别：
							<tags:js.dict.selector noRender="true" name="filter_EQI_typeh" value="${param['filter_EQI_typeh']}" dictCode="JS1048"/>
						</td>
						<td>
							登记状态：
							<tags:js.dict.selector noRender="true" name="filter_EQI_registerType" value="${param['filter_EQI_registerType']}" dictCode="JS1062"/>
						</td>
						<td colspan="2">
							再生育申请状态：
							<tags:js.dict.selector noRender="true" name="filter_EQI_birth2Type" value="${param['filter_EQI_birth2Type']}" dictCode="JS1063"/>
						</td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">
										检索
									</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<table class="table" targettype="dialog" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="createDate" class="orderFlag">
						建卡日期
					</th>
					<th width="80" orderField="code" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="area" class="orderFlag">
						所属区域
					</th>
					<th width="75" align="center">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td>
							${b.index+1}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							<fmt:formatDate value="${a.createDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.code}
						</td>
						<td>
							${a.area}
						</td>
						<td>
							<div style="width: 30px;">
								<a class="btnSelect"
									href="javascript:$.bringBack({nameh_:'${a.nameh}', code_:'${a.code}',personId:'${a.person.id}', code:'${a.person.code}',fertileWomanId:'${a.id}', nameh:'${a.nameh}', code:'${a.person.code}', birthday:'<fmt:formatDate value="${a.person.personBasic.birthday}" pattern="yyyy-MM-dd"/>', age:'${a.person.age}',domicileType:'<tags:js.dict.getValue value="${a.person.domicileType}"/>'})"
									title="确定带回">选择</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot4dwz.jsp"%>
	</div>
</div>