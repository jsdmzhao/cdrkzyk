<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery3view.action">
	<input type="hidden" name="filter_EQS_area" value="${param['filter_EQS_area']}" />
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="type" value="${param['type']}" />
<c:if test="${param.type==1}">
	<input type="hidden" name="filter_EQS_personCode" value="${param['filter_EQS_personCode']}" />
	<input type="hidden" name="filter_LIKES_nameh" value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="filter_EQL_childnum" value="${param['filter_EQL_childnum']}" />
	<input type="hidden" name="filter_EQL_boynum" value="${param['filter_EQL_boynum']}" />
	<input type="hidden" name="filter_EQL_girlnum" value="${param['filter_EQL_girlnum']}" />
	<input type="hidden" name="filter_LIKES_domicile" value="${param['filter_LIKES_domicile']}" />
	<input type="hidden" name="filter_GED_minbirthday" value="${param['filter_GED_minbirthday']}" />
	<input type="hidden" name="filter_LED_minbirthday" value="${param['filter_LED_minbirthday']}" />
	<input type="hidden" name="filter_GED_settleInDate" value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate" value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_EQI_policy" value="${param['filter_EQI_policy']}" />
	<input type="hidden" name="filter_EQI_sex2" value="${param['filter_EQI_sex2']}" />
	<input type="hidden" name="filter_GED_birthday2" value="${param['filter_GED_birthday2']}" />
	<input type="hidden" name="filter_LED_birthday2" value="${param['filter_LED_birthday2']}" />
</c:if>
<c:if test="${param.type==2}">
	<input type="hidden" name="filter_GED_birthday2" value="${param['filter_GED_birthday2']}" />
	<input type="hidden" name="filter_LED_birthday2" value="${param['filter_LED_birthday2']}" />
	<input type="hidden" name="filter_GED_upDate" value="${param['filter_GED_upDate']}" />
	<input type="hidden" name="filter_LED_upDate" value="${param['filter_LED_upDate']}" />
	<input type="hidden" name="filter_LIKES_domicile" value="${param['filter_LIKES_domicile']}" />
	<input type="hidden" name="filter_GED_settleInDate" value="${param['filter_GED_settleInDate']}" />
	<input type="hidden" name="filter_LED_settleInDate" value="${param['filter_LED_settleInDate']}" />
	<input type="hidden" name="filter_EQI_policy" value="${param['filter_EQI_policy']}" />
	<input type="hidden" name="filter_EQI_sex2" value="${param['filter_EQI_sex2']}" />
	<input type="hidden" name="filter_EQI_childIndex" value="${param['filter_EQI_childIndex']}" />
</c:if>
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery3view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType" value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="type" value="${param['type']}" />
			<div class="searchBar">
				<table class="searchContent">
<c:if test="${param.type==1}">
					<tr>
						<td>
							编号：
							<input type="text" name="filter_EQS_personCode"
								value="${param['filter_EQS_personCode']}" />
						</td>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_nameh"
								value="${param['filter_LIKES_nameh']}" />
						</td>
						<td>
							子女数：
							<input type="text" name="filter_EQL_childnum"
								value="${param['filter_EQL_childnum']}"/>
						</td>
						<td>
							男孩数：
							<input type="text" name="filter_EQL_boynum"
								value="${param['filter_EQL_boynum']}"/>
						</td>
						<td>
							女孩数：
							<input type="text" name="filter_EQL_girlnum"
								value="${param['filter_EQL_girlnum']}"/>
						</td>
</tr><tr>
						<td>
							户籍地：
<input type="text" name="filter_LIKES_domicile" class="text" value="${param.filter_LIKES_domicile}"/>
						</td>
						<td colspan="2">
							最小孩出生日期：
<input type="text" name="filter_GED_minbirthday" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_GED_minbirthday}"/>~<input type="text" name="filter_LED_minbirthday" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_LED_minbirthday}"/>
						</td>
						<td colspan="2">
							流入日期：
<input type="text" name="filter_GED_settleInDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_GED_settleInDate}"/>~<input type="text" name="filter_LED_settleInDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_LED_settleInDate}"/>
						</td>
					</tr>
					<tr>	
						<td>
							政策内外：
<tags:js.dict.selector name="filter_EQI_policy" value="${param.filter_EQI_policy}" dictCode="JS1037" noRender="true"/>
						</td>	
						<td>
							子女性别：
<tags:js.dict.selector name="filter_EQI_sex2" value="${param.filter_EQI_sex2}" dictCode="JS010" noRender="true"/>
						</td>
						<td colspan="2">
							子女出生日期：
<input type="text" name="filter_GED_birthday2" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_GED_birthday2}"/>~<input type="text" name="filter_LED_birthday2" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_LED_birthday2}"/>
						</td>
						<td>
							所属区域：
							<tags:js.area.selector name="filter_EQS_area" readonly="true"
								value="${param['filter_EQS_area']}" size="20"></tags:js.area.selector>
						</td>
					</tr>
</c:if>
<c:if test="${param.type==2}">
					<tr>
						<td colspan="2">
							出生日期：
<input type="text" name="filter_GED_birthday2" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_GED_birthday2}"/>~<input type="text" name="filter_LED_birthday2" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_LED_birthday2}"/>
						</td>
						<td colspan="2">
							上报日期：
<input type="text" name="filter_GED_upDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_GED_upDate}"/>~<input type="text" name="filter_LED_upDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_LED_upDate}"/>
						</td>
						<td>
							户籍地：
<input type="text" name="filter_LIKES_domicile" class="text" value="${param.filter_LIKES_domicile}"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							流入日期：
<input type="text" name="filter_GED_settleInDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_GED_settleInDate}"/>~<input type="text" name="filter_LED_settleInDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="${param.filter_LED_settleInDate}"/>
						</td>
						<td>
							政策内外：
<tags:js.dict.selector name="filter_EQI_policy" value="${param.filter_EQI_policy}" dictCode="JS1037" noRender="true"/>
						</td>	
						<td>
							统计孩次：<select style="width:100px" class=" " name="filter_EQI_childIndex" id="filter_EQI_childIndex" value=""  >
	<option value="" >全部</option>
	<option value="1" >一孩</option>
	<option value="2" >二孩</option>
	<option value="99" >多孩</option>
</select>
						</td>
						<td>
							性别：
<tags:js.dict.selector name="filter_EQI_sex2" value="${param.filter_EQI_sex2}" dictCode="JS010" noRender="true"/>
						</td>
					</tr>
					<tr>
						<td>
							所属区域：
							<tags:js.area.selector name="filter_EQS_area" readonly="true"
								value="${param['filter_EQS_area']}" size="20"></tags:js.area.selector>
						</td>
					</tr>
</c:if>
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
					<a class="icon" href="javascript:JS_print2('<c:if test="${param.type==1}">生育子女情况</c:if><c:if test="${param.type==2}">子女出生情况</c:if>')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
<c:if test="${param.type==1}">
		<table class="table" width="200%" layouth="192">
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
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						子女数
					</th>
					<th width="80" orderField="nameh3" class="orderFlag">
						子女姓名
					</th>
					<th width="80" orderField="sex2" class="orderFlag" htype="dict">
						子女性别
					</th>
					<th width="80" orderField="childIndex" class="orderFlag" htype="digits">
						孩次
					</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date">
						子女出生日期
					</th>
					<th width="80" orderField="policy" class="orderFlag" htype="dict">
						政策内外
					</th>
					<th width="80" orderField="birthAddress" class="orderFlag">
						出生地点
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
							${a.childnum}
						</td>
						<td>
							${a.nameh3}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.sex2}"/>
						</td>
						<td>
							${a.childIndex}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.policy}"/>
						</td>
						<td>
							${a.birthAddress}
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
</c:if>
<c:if test="${param.type==2}">
		<table class="table" width="200%" layouth="192">
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
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						 性别
					</th>
					<th width="120" orderField="code" class="orderFlag">
						身份证号码
					</th>
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="settleInDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="nameh3" class="orderFlag">
						子女姓名
					</th>
					<th width="80" orderField="sex2" class="orderFlag" htype="dict">
						子女性别
					</th>
					<th width="80" orderField="childIndex" class="orderFlag" htype="digits">
						孩次
					</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date">
						子女出生日期
					</th>
					<th width="80" orderField="policy" class="orderFlag" htype="dict">
						政策内外
					</th>
					<th width="80" orderField="birthAddress" class="orderFlag">
						出生地点
					</th>
					<th width="80" orderField="kinship" class="orderFlag" htype="dict">
						血缘关系
					</th>
					<th width="80" orderField="changeCause" class="orderFlag" htype="dict">
						变化原因
					</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="opsDate" class="orderFlag" htype="date">
						落实时间
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
							<tags:js.dict.getValue value="${a.sex}"/>
						</td>
						<td>
							${a.code}
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							<fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd" />
						</td><td>
							${a.nameh3}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.sex2}"/>
						</td>
						<td>
							${a.childIndex}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.policy}"/>
						</td>
						<td>
							${a.birthAddress}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.kinship}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.changeCause}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.method}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd" />
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
</c:if>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>
<c:if test="${param.type==2}">
<script>
	$(function(){
		$('#filter_EQI_childIndex').val('${param.filter_EQI_childIndex}');
	});
</script>
</c:if>