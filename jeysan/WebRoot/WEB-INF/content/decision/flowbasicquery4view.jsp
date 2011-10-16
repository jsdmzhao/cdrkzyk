<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery4view.action">
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_GED_firstMarryDate" value="${param['filter_GED_firstMarryDate']}" />
	<input type="hidden" name="filter_GED_firstMarryDate" value="${param['filter_GED_firstMarryDate']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery4view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
<input type="radio" name="marray_childnum" id="marray_childnum_1" value="1"/>按已婚无孩查询
<input type="radio" name="marray_childnum" id="marray_childnum_2" value="2"/>按已安排生育二孩查询
						</td>
						<td>
							初婚日期：
							<input type="text" name="filter_GED_firstMarryDate" class="date" readonly="true" value="${param.filter_GED_firstMarryDate}"/>~<input type="text" name="filter_LED_firstMarryDate" class="date" readonly="true" value="${param.filter_LED_firstMarryDate}"/>
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
					<a class="icon" href="javascript:JS_print2('符合生育政策人员情况')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="200%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="personCode" class="orderFlag">
						流动人口编号
					</th>
					<th width="120" orderField="code" class="orderFlag">
						证件号码
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">
						出生日期
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="80" orderField="firstMarryDate" class="orderFlag" htype="date">
						初婚日期
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="address" class="orderFlag">
						居住地
					</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						子女数
					</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="changeCause" class="orderFlag" htype="dict">
						变化原因
					</th>
					<th width="80" orderField="opsDate" class="orderFlag" htype="date">
						落实日期
					</th>
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="isAgree" class="orderFlag" htype="dict">
						是否同意
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
							${a.personCode}
						</td>
						<td>
							${a.code}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.firstMarryDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.domicile}
						</td>
						<td>
							${a.address}
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.method}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.changeCause}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.isAgree}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>
<c:if test="${not empty param.marray_childnum}">
<script>
	$(function(){
		$('#marray_childnum_${param.marray_childnum}').attr('checked','checked');
	});
</script>
</c:if>