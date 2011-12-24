<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery7view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<c:choose>
		<c:when test="${param.p_type eq 1}">
			<input type="hidden" name="filter_GED_edd" value="${param.filter_GED_edd}"/>
			<input type="hidden" name="filter_LED_edd" value="${param.filter_LED_edd}"/>
			<input type="hidden" name="filter_EQI_planType" value="${param.filter_EQI_planType}"/>
			<input type="hidden" name="filter_EQI_bornType" value="${param.filter_EQI_bornType}"/>
		</c:when>
		<c:when test="${param.p_type eq 2}">
			<input type="hidden" name="filter_GED_checkDate" class="text" size="52" value="${param.filter_GED_checkDate}"/>
			<input type="hidden" name="filter_LED_checkDate" class="text" value="${param.filter_LED_checkDate}"/>
			<input type="hidden" name="filter_EQI_isAgree" class="text" value="${param.filter_EQI_isAgree}"/>
			<input type="hidden" name="filter_EQI_typeh" class="text" value="${param.filter_EQI_typeh}"/>
		</c:when>
		<c:otherwise>
			
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
		return '安排生育情况(安排生育二孩情况)';
	}else if(p_type == 2){
		return '安排生育情况(二孩生育审批情况)';
	}else if(p_type == 3){
		return '基层常用统计资料查询(查符合政策安排生育二孩)';
	}
	return '';
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery7view.action" method="post">
		<input type="hidden" name="p_type" value="${param.p_type }"/>
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
		<div class="searchBar">
			<table class="searchContent">
				<c:set var="layouth" value="138"/>
			<c:choose>
			<c:when test="${param.p_type eq 1}">
				<tr>
					<td>安排年月：
<input type="text" name="filter_GED_edd" class="date" readonly="true" value="${param.filter_GED_edd}"/>~
<input type="text" name="filter_LED_edd" class="date" readonly="true" value="${param.filter_LED_edd}"/>					
					</td>
					<td>安排生育情况：
<tags:js.dict.selector name="filter_EQI_planType" value="${param.filter_EQI_planType}" dictCode="JS1028" noRender="true"/>
					</td>
					<td>安排生育类型：
<tags:js.dict.selector name="filter_EQI_bornType" value="${param.filter_EQI_bornType}" dictCode="JS1027" noRender="true"/>
					</td>
				</tr>
				</c:when>
			<c:when test="${param.p_type eq 2}">
				<tr>
				<td>生育审批年月：
<input type="text" name="filter_GED_checkDate" class="date" readonly="true" value="${param.filter_GED_checkDate}"/>~
<input type="text" name="filter_LED_checkDate" class="date" readonly="true" value="${param.filter_LED_checkDate}"/>					
					</td>
					<td>审批结果：
<tags:js.dict.selector name="filter_EQI_isAgree" value="${param.filter_EQI_isAgree}" dictCode="JS060" noRender="true"/>
					</td>
					<td>生育申请类型：
<tags:js.dict.selector name="filter_EQI_typeh" value="${param.filter_EQI_typeh}" dictCode="JS1011" noRender="true"/>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<tr>
				<td>安排二孩日期：
<input type="text" name="filter_GED_edd" class="date" readonly="true" value="${param.filter_GED_edd}"/>~
<input type="text" name="filter_LED_edd" class="date" readonly="true" value="${param.filter_LED_edd}"/>						
					</td>
					<td>安排生育类型：
<tags:js.dict.selector name="filter_EQI_typeh" value="${param.filter_EQI_typeh}" dictCode="JS1024" noRender="true"/>
					</td>
					<td>安排生育情况：
<tags:js.dict.selector name="filter_EQI_planType" value="${param.filter_EQI_planType}" dictCode="JS1028" noRender="true"/>
					</td>
				</tr>
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
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag">育龄妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">姓名</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
					<th width="80" orderField="isAgree" class="orderFlag" htype="dict" distype="1,3">审批结果</th>
					<th width="80" orderField="checkDate" class="orderFlag"  htype="date" distype="1,3">审批日期</th>
					<th width="80" orderField="typeh" class="orderFlag" htype="dict" distype="1,3">申请类型</th>
					<th width="80" orderField="firstMarryDate" class="orderFlag" htype="date" distype="2">初婚日期</th>
					<th width="80" orderField="househodeKind" class="orderFlag" htype="dict" distype="2">户口性质</th>
					<th width="80" orderField="domicile" class="orderFlag" distype="1,2">户籍地</th>
					<th width="80" orderField="address" class="orderFlag" distype="1,2">常住地</th>
					<th width="80" orderField="minbirthday" class="orderFlag" htype="date" distype="2">一孩出生日期</th>
					<th width="80" orderField="minsex" class="orderFlag" htype="dict" distype="1,2">一孩性别</th>
					<th width="80" orderField="boynum" class="orderFlag" htype="digits" distype="3">男孩数</th>
					<th width="80" orderField="girlnum" class="orderFlag" htype="digits" distype="3">女孩数</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date" distype="1,2">丈夫出生日期</th>
					<th width="80" orderField="househodeKind2" class="orderFlag" htype="dict">丈夫户口性质</th>
					<th width="80" orderField="domicile2" class="orderFlag" distype="1,2">丈夫户籍地</th>
					<th width="80" orderField="planType" class="orderFlag" distype="2,3" htype="dict">安排生育情况</th>
					<th width="80" orderField="noContraceptDate" class="orderFlag" htype="date" distype="1,2">停止避孕时间</th>
					<th width="80" orderField="edd" class="orderFlag" htype="date" distype="1,2">安排生育时间</th>
					<th width="80" orderField="remark" class="orderFlag" distype="1,2">备注</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.isAgree}"/></td>
					<td><fmt:formatDate value="${a.checkDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.typeh}"/></td>
					<td><fmt:formatDate value="${a.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td>${a.domicile}</td>
					<td>${a.address}</td>
					<td><fmt:formatDate value="${a.minbirthday}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.minsex}"/></td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td>${a.nameh2}</td>
					<td><fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.househodeKind2}"/></td>
					<td>${a.domicile2}</td>
					<td><tags:js.dict.getValue value="${a.planType}"/></td>
					<td><fmt:formatDate value="${a.noContraceptDate}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${a.edd}" pattern="yyyy-MM-dd"/></td>
					<td>${a.remark}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>