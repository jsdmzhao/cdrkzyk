<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery11view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_EQI_dcResult1" value="${param['filter_EQI_dcResult1']}" />
	<input type="hidden" name="filter_EQI_year" value="${param['filter_EQI_year']}" />
	<input type="hidden" name="filter_EQI_seq" value="${param['filter_EQI_seq']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery11view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>双查对象类型：
<tags:js.dict.selector name="filter_EQI_dcResult1" value="${param.filter_EQI_dcResult1}" dictCode="JS1013" noRender="true" />
					</td>					<td>
						设置查环查孕轮次：<input type="text" name="filter_EQI_year" class="text" value="${param.filter_EQI_year}" size="5"/>年度&nbsp;&nbsp;
						第<input type="text" name="filter_EQI_seq" class="text" value="${param.filter_EQI_seq}" size="2"/>次
					</td>
				</tr>
				<tr>
					<td>选择对象：
						<input type="checkbox" name="filter_EQI_objType" value="1"/>应查对象&nbsp;&nbsp;
						<input type="checkbox" name="filter_EQI_objType" value="0"/>免查对象
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
					<a class="icon" href="javascript:JS_print2('育龄妇女避孕节育情况查询(各时期需要查环查孕情况)')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag">妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">姓名</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
					<th width="80" orderField="minbirthday" class="orderFlag" htype="date">最小孩出生日期</th>
					<th width="80" orderField="tel" class="orderFlag">联系电话</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">避孕节育措施</th>
					<th width="80" orderField="opsDate" class="orderFlag" htype="date">落实措施时间</th>
					<th width="80" orderField="objType" class="orderFlag" htype="dict">对象种类</th>
					<th width="80" orderField="count4dc2" class="orderFlag" htype="digits">每年应双查次数</th>
					<th width="80" orderField="dcDate" class="orderFlag" htype="date">双查时间</th>
					<th width="80" orderField="hospital" class="orderFlag">双查医院</th>
					<th width="80" orderField="dcResult1" class="orderFlag" >查环结果</th>
					<th width="80" orderField="dcResult2" class="orderFlag">查孕结果</th>
					</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td>${a.nameh2}</td>
					<td><fmt:formatDate value="${a.minbirthday}" pattern="yyyy-MM-dd"/></td>
					<td>${a.tel}</td>
					<td><tags:js.dict.getValue value="${a.method}"/></td>
					<td><fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.objType}"/></td>
					<td>${a.count4dc2}</td>
					<td><fmt:formatDate value="${a.dcDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.hospital}</td>
					<td>${a.dcResult1}</td>
					<td>${a.dcResult2}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>