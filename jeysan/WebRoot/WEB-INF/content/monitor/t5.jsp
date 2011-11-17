<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/monitor/hpmonitor!findDelayContracepts.action">
	<input type="hidden" name="domicileType" value="${param['domicileType']}" />
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/monitor/hpmonitor!findDelayContracepts.action" method="post">
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
					<a class="icon" href="javascript:JS_print2('申请缓期节育到期对象清单')"><span>打印或者导出</span>
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
					<th width="80" orderField="FIRST_MARRY_DATE" class="orderFlag" htype="date">
						初婚日期
					</th>
					<th width="80" orderField="DELAY_CAUSE" class="orderFlag">
						缓期原因
					</th>
					<th width="80" orderField="DELAY_END_CAUSE" class="orderFlag" htype="date">
						缓期终止日期
					</th>
					<th width="80" orderField="DELAY_COMPANY" class="orderFlag">
						签订单位
					</th>
					<th width="80" orderField="DELAY_DATE" class="orderFlag" htype="date">
						缓期签订日期
					</th>
					<th width="80" orderField="DELAY_DOCTOR" class="orderFlag">
						缓期鉴定医生
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
							<fmt:formatDate value="${a.FIRST_MARRY_DATE}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.DELAY_CAUSE}
						</td>
						<td>
							<fmt:formatDate value="${a.DELAY_END_CAUSE}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.DELAY_COMPANY}
						</td>
						<td>
							<fmt:formatDate value="${a.DELAY_DATE}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.DELAY_DOCTOR}
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