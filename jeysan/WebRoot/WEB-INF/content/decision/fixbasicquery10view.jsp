<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery10view.action">
	<c:choose>
		<c:when test="${param.p_type eq 1}">
			<input type="hidden" name="filter_GED_endDate" class="text" size="52" value="${param.filter_GED_endDate}"/>
			<input type="hidden" name="filter_LED_endDate" class="text" value="${param.filter_LED_endDate}"/>
			<input type="hidden" name="filter_EQI_matenalResult" class="text" value="${param.filter_EQI_matenalResult}"/>
			<input type="hidden" name="filter_EQI_currentConceptStatus" class="text" value="${param.filter_EQI_currentConceptStatus}"/>
		</c:when>
		<c:when test="${param.p_type eq 2}">
			<input type="hidden" name="filter_GED_endDate" class="text" size="52" value="${param.filter_GED_endDate}"/>
			<input type="hidden" name="filter_LED_endDate" class="text" value="${param.filter_LED_endDate}"/>
			<input type="hidden" name="filter_EQI_repairMethod" class="text" value="${param.filter_EQI_repairMethod}"/>	
		</c:when>
		<c:when test="${param.p_type eq 3}">
			<input type="hidden" name="filter_GED_endDate" class="text" size="52" value="${param.filter_GED_endDate}"/>
			<input type="hidden" name="filter_LED_endDate" class="text" value="${param.filter_LED_endDate}"/>
			<input type="hidden" name="filter_EQI_matenalResult" class="text" value="${param.filter_EQI_matenalResult}"/>	
		</c:when>
		<c:otherwise>
			<input type="hidden" name="filter_GEI_age" class="text" value="${param.filter_GED_age}"/>
			<input type="hidden" name="filter_LEI_age" class="text" value="${param.filter_LED_age}"/>	
		</c:otherwise>
	</c:choose>
	<input type="hidden" name="p_type" value="${param.p_type }"/>
</tags:js.pager>
<script type="text/javascript">
$(function(){
	JS_initComp();
});

function JS_initComp(){
	var distype = '';
	var index = 0;
	var $this = null;
	$('th[distype]',navTab.getCurrentPanel()).each(function(){
		$this = $(this);
		distype = $this.attr('distype');
		if((distype+',').indexOf('${param.p_type},') > -1){
			index = $this.index();
			 $this.hide();
			$($('tr',navTab.getCurrentPanel())).each(function(){
				$('td:eq('+index+')',this).hide();			
			});
		}
	});
}

function JS_getKindTitle(p_type){
	if(p_type == 1){
		return '育龄妇女婚姻孕产查询(育妇当年孕产动态)';
	}else if(p_type == 2){
		return '育龄妇女婚姻孕产查询(按年月查补救措施情况)';
	}else if(p_type == 3){
		return '育龄妇女婚姻孕产查询(按年月查死产、补救措施一情况)';
	}else if(p_type == 4){
		return '育龄妇女避孕节育情况查询(按育妇年龄查避孕情况)';
	}
	return '';
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery10view.action" method="post">
		<input type="hidden" name="p_type" value="${param.p_type }"/>
		<div class="searchBar">
			<table class="searchContent">
				<c:set var="layouth" value="138"/>
			<c:choose>
			<c:when test="${param.p_type eq 1}">
				<tr>
					<td>孕产日期：
<input type="text" name="filter_GED_endDate" class="date" readonly="true" value="${param.filter_GED_endDate}"/>~
<input type="text" name="filter_LED_endDate" class="date" readonly="true" value="${param.filter_LED_endDate}"/>					
					</td>
					<td>孕产结果：
<tags:js.dict.selector name="filter_EQI_matenalResult" value="${param.filter_EQI_matenalResult}" dictCode="JS1029" noRender="true"/>
					</td>
					<td>现孕状况：
<tags:js.dict.selector name="filter_EQI_currentConceptStatus" value="${param.filter_EQI_currentConceptStatus}" dictCode="JS1030" noRender="true"/>
					</td>
				</tr>
				</c:when>
				<c:when test="${param.p_type eq 2}">
					<tr>
					<td>孕产日期：
<input type="text" name="filter_GED_endDate" class="date" readonly="true" value="${param.filter_GED_endDate}"/>~
<input type="text" name="filter_LED_endDate" class="date" readonly="true" value="${param.filter_LED_endDate}"/>	
					</td>
					<td>补救措施类型：
<tags:js.dict.selector name="filter_EQI_repairMethod" value="${param.filter_EQI_repairMethod}" dictCode="JS1031" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 3}">
					<tr>
					<td>孕产日期：
<input type="text" name="filter_GED_endDate" class="date" readonly="true" value="${param.filter_GED_endDate}"/>~
<input type="text" name="filter_LED_endDate" class="date" readonly="true" value="${param.filter_LED_endDate}"/>	
					</td>
					<td>孕产结果：
<tags:js.dict.selector name="filter_EQI_repairMethod" value="${param.filter_EQI_matenalResult}" dictCode="JS1032" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:otherwise>
					<td>妇女年龄：
<input type="text" name="filter_GEI_age" class="text" value="${param.filter_GED_age}"/>~
<input type="text" name="filter_LEI_age" class="text" value="${param.filter_LED_age}"/>	
					</td>
				</c:otherwise>
				</c:choose>
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
					<a class="icon" href="javascript:JS_print2(JS_getKindTitle(${param.p_type }))"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="${layouth }">
			<thead>
				<tr>
				<th width="30" align="center">序号</th>
				<th width="80" orderField="personCode" class="orderFlag">育龄妇女编码</th>
				<th width="80" orderField="nameh" class="orderFlag">姓名</th>
				<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
				<th width="80" orderField="marryStatus" class="orderFlag" htype="dict" distype="1,2,3">婚姻状况 </th>
				<th width="80" orderField="firstMarryDate" class="orderFlag" htype="date" distype="2,3,4">初婚日期</th>
				<th width="80" orderField="conceptPolicy" class="orderFlag" distype="2,3,4">怀孕政策属性</th>
				<th width="80" orderField="matenalResult" class="orderFlag" htype="dict" distype="4">孕产结果</th>
				<th width="80" orderField="endDate" class="orderFlag" htype="date" distype="4">孕产日期</th>
				<th width="80" orderField="changeCause" class="orderFlag" distype="4">变化原因</th>
				<th width="80" orderField="method" class="orderFlag" htype="dict" distype="1">避孕节育措施</th>
				<th width="80" orderField="boynum" class="orderFlag" htype="digits">男孩数</th>
				<th width="80" orderField="girlnum" class="orderFlag" htype="digits">女孩数</th>
				<th width="80" orderField="minbirthday" class="orderFlag" htype="date" distype="3">最小孩出生日期</th>
				<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
				<th width="80" orderField="domicile" class="orderFlag" distype="2,3,4">户籍地</th>
				<th width="80" orderField="houseNumber" class="orderFlag" distype="2,3,4">门牌号码</th>
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
					<td><fmt:formatDate value="${a.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.conceptPolicy}"/></td>
					<td><tags:js.dict.getValue value="${a.matenalResult}"/></td>
					<td><fmt:formatDate value="${a.endDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.changeCause}</td>
					<td><tags:js.dict.getValue value="${a.method}"/></td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td><fmt:formatDate value="${a.minbirthday}" pattern="yyyy-MM-dd"/></td>
					<td>${a.nameh2}</td>
					<td>${a.domicile}</td>
					<td>${a.houseNumber}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>