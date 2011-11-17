<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/monitor/hpmonitor!findWomanMatenalOver7Months.action">
	<input type="hidden" name="domicileType" value="${param['domicileType']}" />
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/monitor/hpmonitor!findWomanMatenalOver7Months.action" method="post">
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
					<a class="icon" href="javascript:JS_print2('孕产期超七个月对象一览表')"><span>打印或者导出</span>
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
						姓名
					</th>
					<th width="80" orderField="MARRY_STATUS" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="ADDRESS" class="orderFlag">
						现居住地
					</th>
					<th width="80" orderField="childNum" class="orderFlag" htype="digits">
						现家庭子女数
					</th>
					<th width="80" orderField="CONCEPT_DATE" class="orderFlag" htype="date">
						怀孕时间
					</th>
					<th width="80" orderField="EDD" class="orderFlag" htype="date">
						预产期
					</th>
					<th width="80" orderField="HOUSE_NO" class="orderFlag">
						门牌号码
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
							<tags:js.dict.getValue value="${a.MARRY_STATUS}"/>
						</td>
						<td>
							${a.ADDRESS}
						</td>
						<td>
							${a.childNum}
						</td>
						<td>
							<fmt:formatDate value="${a.CONCEPT_DATE}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.EDD}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.HOUSE_NO}
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