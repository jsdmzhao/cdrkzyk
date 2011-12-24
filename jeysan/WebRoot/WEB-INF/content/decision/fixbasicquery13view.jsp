<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery13view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQI_househodeKind" value="${param['filter_EQI_househodeKind']}" />
	<input type="hidden" name="filter_EQI_househodeKind2" value="${param['filter_EQI_househodeKind2']}" />
	<input type="hidden" name="filter_EQI_sex2" value="${param['filter_EQI_sex2']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery13view.action" method="post">

	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>妇女户口：
<tags:js.dict.selector name="filter_EQI_househodeKind" value="${param.filter_EQI_househodeKind}" dictCode="JS1014" noRender="true"/>
					</td>
					<td>丈夫户口：
<tags:js.dict.selector name="filter_EQI_househodeKind2" value="${param.filter_EQI_househodeKind2}" dictCode="JS1014" noRender="true"/>
					</td>
					<td>子女性别：
<tags:js.dict.selector name="filter_EQI_sex2" value="${param.filter_EQI_sex2}" dictCode="JS010" noRender="true"/>
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
						<li>
							<div class="button">
								<div class="buttonContent">
									<button type="reset">
										重置
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
					<a class="icon" href="javascript:JS_print2('证件办理情况查询(现有一孩未领光荣证情况)')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag">妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">妇女姓名</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">婚姻状况</th>
					<th width="80" orderField="househodeKind" class="orderFlag" htype="dict">户口性质</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">子女数</th>
					<th width="80" orderField="boynum" class="orderFlag" htype="digits">女孩数</th>
					<th width="80" orderField="girlnum" class="orderFlag" htype="digits">女孩数</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date">一孩出生日期</th>
					<th width="80" orderField="sex2" class="orderFlag" htype="dict">一孩性别</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
					<th width="80" orderField="househodeKind2" class="orderFlag" htype="dict">丈夫户口性质</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.marryStatus}"/></td>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td>${a.childnum}</td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td><fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.sex2}"/></td>
					<td>${a.nameh2}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind2}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>