<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery7view.action">
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="filter_GED_settleInDate" value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate" value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_EQL_childnum" value="${param['filter_EQL_childnum']}" />

	<input type="hidden" name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" />
	<input type="hidden" name="days" value="${param['days']}" />

	<input type="hidden" name="type" value="${param['type']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery7view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="type" value="${param['type']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td colspan="2">
							流入日期：
<input type="text" name="filter_GED_settleInDate" class="date" readonly="true" value="${param.filter_GED_settleInDate}"/>~<input type="text" name="filter_LED_settleInDate" class="date" readonly="true" value="${param.filter_LED_settleInDate}"/>
						</td>
						<td>
							婚姻状况：
<tags:js.dict.selector name="filter_EQI_marryStatus" value="${param['filter_EQI_marryStatus']}" dictCode="JS1015" noRender="true"/>
						</td>
						<td>
							子女数：
<input type="text" name="filter_EQL_childnum" class="text" value="${param.filter_EQL_childnum}"/>
						</td>
</tr><tr>	
						<td>
							小孩出生：
<select style="width:100px" class=" " name="filter_EQI_childIndex" id="filter_EQI_childIndex" value=""  >
	<option value="" >全部</option>
	<option value="1" >一孩出生</option>
	<option value="2" >二孩出生</option>
	<option value="3" >多孩出生</option>
</select>
						</td>
						<td>
<input type="text" name="days" class="text" id="days_iueo_" value="${param.days}" readonly="readonly"/>天
						</td>
						<td>
							所属区域：
							<tags:js.area.selector name="filter_EQS_area" readonly="true"
								value="${param['filter_EQS_area']}" size="20"></tags:js.area.selector>
						</td><td></td>
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
					<a class="icon"
						href="javascript:JS_print2('有子女未避孕人员情况')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="200%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="personCode" class="orderFlag">
						流动人口编号
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
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						子女数
					</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date">
						最小孩出生日期
					</th>
					<th width="80" orderField="noCause" class="orderFlag">
						未避孕原因
					</th>
					<th width="80" orderField="settleInDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="tel" class="orderFlag">
						联系电话
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="address" class="orderFlag">
						居住地
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
							${a.nameh}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"/>
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.noCause}
						</td>
						<td>
							<fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.tel}
						</td>
						<td>
							${a.domicile}
						</td>
						<td>
							${a.address}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>
<c:if test="${not empty param.doOrNOtMethod}">
<script>
	$(function(){
		$('#filter_EQI_childIndex').change(function(){
			if($(this).val()!=''){
				$('#days_iueo_').removeAttr('readonly');
			}else{
				$('#days_iueo_').attr('readonly','readonly');
			}
		});
	});
</script>
</c:if>