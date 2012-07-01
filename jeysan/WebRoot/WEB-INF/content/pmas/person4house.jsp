<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/pmas/person!list4house.action">
	<input type="hidden" name="filter_EQL_personBasic.houseId"
		value="${param['filter_EQL_personBasic.houseId']}" />
<input type="hidden" name="filter_LIKES_nameh"
		value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQS_code"
		value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_EQS_personCode"
		value="${param['filter_EQS_personCode']}" />
	<input type="hidden" name="filter_EQI_sex"
		value="${param['filter_EQI_sex']}" />
	<input type="hidden" name="filter_EQI_certType"
		value="${param['filter_EQI_certType']}" />
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQI_kind"
		value="${param['filter_EQI_kind']}" />
	<input type="hidden" name="filter_EQI_cancelType"
		value="${param['filter_EQI_cancelType']}" />
	<input type="hidden" name="filter_GEI_age"
		value="${param['filter_GEI_age']}" />
	
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/pmas/person!list4house.action" method="post">
			<div class="searchBar">
	<input type="hidden" name="filter_EQL_personBasic.houseId"
		value="${param['filter_EQL_personBasic.houseId']}" />
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_nameh"
								value="${param['filter_LIKES_nameh']}" />
						</td>
						<td>
							性别：
							<tags:js.dict.selector noRender="true" name="filter_EQI_sex"
								value="${param['filter_EQI_sex']}" dictCode="JS010" />
						</td>
						<td>
							人员类别：
							<tags:js.dict.selector noRender="true" name="filter_EQI_kind"
								value="${param['filter_EQI_kind']}" dictCode="JS1050" />
						</td>
						<td>
							人员编号：&nbsp;&nbsp;
							<input type="text" name="filter_EQS_personCode"
								value="${param['filter_EQS_personCode']}" />
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td>
							证件号码：
							<input type="text" name="filter_EQS_code"
								value="${param['filter_EQS_code']}" />
						</td>
						<td>
							证件类型：
							<tags:js.dict.selector noRender="true" name="filter_EQI_certType"
								value="${param['filter_EQI_certType']}" dictCode="JS1043" />
						</td>
						<td>
							户口类别：
							<tags:js.dict.selector noRender="true"
								name="filter_EQI_domicileType"
								value="${param['filter_EQI_domicileType']}" dictCode="JS1048" />
						</td>
						<td>
							人员状态：
							<tags:js.dict.selector noRender="true"
								name="filter_EQI_cancelType"
								value="${param['filter_EQI_cancelType']}" dictCode="JS1010" />
						</td>
						<td>
							年龄(>=)：
							<input type="text" name="filter_GEI_age"
								value="${param['filter_GEI_age']}" />
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
		<div class="panelBar">
			<ul class="toolBar">
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('人员基本信息')"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="60" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="certType" class="orderFlag" htype="dict">
						证件类型
					</th>
					<th width="120" orderField="code" class="orderFlag">
						证件号码
					</th>
					<th width="120" orderField="personCode" class="orderFlag">
						人员编号
					</th>
					<th width="80" orderField="cancelType" class="orderFlag" htype="dict">
						状态
					</th>
					<th width="80" orderField="domicileType" class="orderFlag" htype="dict">
						户口类别
					</th>
					<th width="80" orderField="kind" class="orderFlag" htype="dict">
						人员类别
					</th>
					<th width="80" align="center">
						操作
					</th>
					<th width="55" align="center">
						配偶
					</th>
					<th width="55" align="center">
						子女
					</th>
					<th style="display:none" hcode="personBasic.nationality" htype="dict">国籍</th>
					<th style="display:none" hcode="personBasic.native_" htype="dict">民族</th>
					<th style="display:none" hcode="personBasic.birthday" htype="date">出生日期</th>
					<th style="display:none" hcode="age" htype="digits">年龄</th>
					<th style="display:none" hcode="personBasic.marryStatus" htype="dict">婚姻状况</th>
					<th style="display:none" hcode="personBasic.edu" htype="dict">文化程度</th>
					<th style="display:none" hcode="personBasic.politicalStatus" htype="dict">政治面貌</th>
					<th style="display:none" hcode="personBasic.job" htype="dict">职业</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td height="25">
							<input type="checkbox" name="ids" value="${a.id}" />
						</td>
						<td>
							${b.index+1}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.sex}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.certType}"></tags:js.dict.getValue>
						</td>
						<td>
							${a.code}
						</td>
						<td>
							${a.personCode}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.cancelType}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.domicileType}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.kind}"></tags:js.dict.getValue>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnView"
									href="${ctx}/pmas/person!view.action?id=${a.id}"
									target="navTab" title="查看人员信息" rel="person-view"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnView"
									href="${ctx}/pmas/spouse!view.action?personId=${a.id}"
									target="navTab" title="查看配偶信息" rel="spouse-view"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnView"
									href="${ctx}/pmas/womanchildren!view.action?personId=${a.id}"
									target="navTab" title="查看子女信息" rel="womanchildren-view"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>