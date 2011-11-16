<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/monitor/hpmonitor!findBirth2Applys.action">
	<input type="hidden" name="domicileType" value="${param['domicileType']}" />
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="typeh" value="${param['typeh']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/monitor/hpmonitor!findBirth2Applys.action" method="post">
	<input type="hidden" name="domicileType" value="${param['domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							申请类型：
							<tags:js.dict.selector noRender="true" name="typeh" value="${param['typeh']}" dictCode="JS1011"/>
						</td>
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
					<a class="icon" href="javascript:JS_print2('待审批计划生育一览表')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
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
						妇女姓名
					</th>
					<th width="80" orderField="NAMEH2" class="orderFlag">
						丈夫姓名
					</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						现家庭子女数
					</th>
					<th width="80" orderField="DATEH" class="orderFlag" htype="date">
						申请时间
					</th>
					<th width="80" orderField="IS_SECOND" class="orderFlag" htype="bool">
						是否再生二孩
					</th>
					<th width="80" orderField="COND" class="orderFlag">
						申请条件
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
							${a.childnum}
						</td>
						<td>
							<fmt:formatDate value="${a.DATEH}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.IS_SECOND}"/>
						</td>
						<td>
							${a.COND}
						</td>
						<td>
							${a.ADDRESS}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<div class="panelBar">
	<div class="pages"><span>共有&nbsp;${page.totalCount}&nbsp;条记录</span></div>
</div>
	</div>
</div>