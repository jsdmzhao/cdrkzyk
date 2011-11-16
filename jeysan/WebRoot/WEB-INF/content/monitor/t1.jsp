<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="fix" value="<%=Constants.DOMICILE_TYPE.FIX%>"/>
<c:set var="flow" value="<%=Constants.DOMICILE_TYPE.FLOW%>"/>
<tags:js.pager action="${ctx}/monitor/hpmonitor.action">
	<input type="hidden" name="domicileType" value="${param['domicileType']}" />
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/monitor/hpmonitor.action" method="post">
	<input type="hidden" name="domicileType" value="${param['domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							所属区域：
							<tags:js.area.selector name="filter_EQS_area" readonly="true"
								value="${param['filter_EQS_area']}" size="20"></tags:js.area.selector>
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
					<a class="icon" href="javascript:JS_print2('待双查对象一览表')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
<c:if test="${param.domicileType==fix}">
		<table class="table" width="150%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="PERSON_CODE" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="NAMEH" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="NAMEH2" class="orderFlag">
						丈夫姓名
					</th>
					<th width="80" orderField="MARRY_STATUS" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						现家庭子女数
					</th>
					<th width="80" orderField="JOB" class="orderFlag" htype="dict">
						妇女职业
					</th>
					<th width="80" orderField="METHOD" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="OPS_DATE" class="orderFlag" htype="date">
						避孕节育日期
					</th>
					<th width="80" orderField="minBirthday" class="orderFlag" htype="date">
						最小孩出生日期
					</th>
					<th width="80" orderField="DOMICILE" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="ADDRESS" class="orderFlag">
						现居住地
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr>
						<td height="25">
							${b.index+1}
						</td>
						<td>
							${a.PERSON_CODE}
						</td>
						<td>
							${a.NAMEH}
						</td>
						<td>
							${a.NAMEH2}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.MARRY_STATUS}"/>
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.JOB}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.METHOD}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.OPS_DATE}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.minBirthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.DOMICILE}
						</td>
						<td>
							${a.ADDRESS}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</c:if>
<c:if test="${param.domicileType==flow}">
		<table class="table" width="150%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="PERSON_CODE" class="orderFlag">
						流动人口编号
					</th>
					<th width="80" orderField="NAMEH" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="SEX" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="CODE" class="orderFlag">
						身份证号码
					</th>
					<th width="80" orderField="MARRY_STATUS" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="ADDRESS" class="orderFlag">
						现居住地地址
					</th>
					<th width="80" orderField="TEL" class="orderFlag">
						现居住地电话
					</th>
					<th width="80" orderField="SETTLE_IN_DATE" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="COMPANY" class="orderFlag">
						工作单位
					</th>
					<th width="80" orderField="METHOD" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="OPS_DATE" class="orderFlag" htype="date">
						落实措施日期
					</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						子女数
					</th>
					<th width="80" orderField="minBirthday" class="orderFlag" htype="date">
						最小孩出生日期
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr>
						<td height="25">
							${b.index+1}
						</td>
						<td>
							${a.PERSON_CODE}
						</td>
						<td>
							${a.NAMEH}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.SEX}"/>
						</td>
						<td>
							${a.CODE}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.MARRY_STATUS}"/>
						</td>
						<td>
							${a.ADDRESS}
						</td>
						<td>
							${a.TEL}
						</td>
						<td>
							${a.SETTLE_IN_DATE}
						</td>
						<td>
							${a.COMPANY}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.METHOD}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.OPS_DATE}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							<fmt:formatDate value="${a.minBirthday}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</c:if>
<div class="panelBar">
	<div class="pages"><span>共有&nbsp;${page.totalCount}&nbsp;条记录</span></div>
</div>
	</div>
</div>