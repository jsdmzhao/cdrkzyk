<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery6view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<c:choose>
		<c:when test="${param.p_type eq 1}">
			<input type="hidden" name="filter_GED_edd" class="text" size="52" value="${param.filter_GED_edd}"/>
			<input type="hidden" name="filter_LED_edd" class="text" value="${param.filter_LED_edd}"/>
			<input type="hidden" name="filter_EQI_bornType" class="text" value="${param.filter_EQI_bornType}"/>
			<input type="hidden" name="filter_GES_dateh" class="text" value="${param.filter_GES_dateh}"/>
			<input type="hidden" name="filter_LES_dateh" class="text" value="${param.filter_LES_dateh}"/>
		</c:when>
		<c:when test="${param.p_type eq 2}">
			<input type="hidden" name="filter_EQI_unBornType" class="text" value="${param.filter_EQI_unBornType}"/>	
		</c:when>
		<c:when test="${param.p_type eq 3}">
			<input type="hidden" name="filter_GED_birthday" class="text" size="52" value="${param.filter_GED_birthday}"/>
			<input type="hidden" name="filter_LED_birthday" class="text" value="${param.filter_LED_birthday}"/>
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
		return '(安排生育情况按年份)';
	}else if(p_type == 2){
		return '(安排生育未生)';
	}else if(p_type == 3){
		return '(已安排生育无孩无措施)';
	}
	return '';
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery6view.action" method="post">
		<input type="hidden" name="p_type" value="${param.p_type }"/>
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
		<div class="searchBar">
		<table class="searchContent">
			<c:set var="layouth" value="138"/>
			<c:choose>
			<c:when test="${param.p_type eq 1}">
			<c:set var="layouth" value="165"/>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;安排生育年月：
<input type="text" name="filter_GED_edd" class="date" readonly="true" value="${param.filter_GED_edd}"/>~
<input type="text" name="filter_LED_edd" class="date" readonly="true" value="${param.filter_LED_edd}"/>					
					</td>
					<td>安排生育类型：
<tags:js.dict.selector name="filter_EQI_bornType" value="${param.filter_EQI_bornType}" dictCode="JS1024" noRender="true"/>
					</td>
				</tr>
				<tr>
					<td>登记申请生育年月：
<input type="text" name="filter_GES_dateh" class="date" readonly="true" value="${param.filter_GES_dateh}"/>~
<input type="text" name="filter_LES_dateh" class="date" readonly="true" value="${param.filter_LES_dateh}"/>
					</td>
				</tr>
				</c:when>
				<c:when test="${param.p_type eq 2}">
					<tr>
					<td>安排生育未生类型：
<tags:js.dict.selector name="filter_EQI_unBornType" value="${param.filter_EQI_unBornType}" dictCode="JS1025" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 3}">
					<tr>
					<td>出生日期：
<input type="text" name="filter_GED_birthday" class="date" readonly="true" value="${param.filter_GED_birthday}"/>~
<input type="text" name="filter_LED_birthday" class="date" readonly="true" value="${param.filter_LED_birthday}"/>
					</td>
					</tr>
				</c:when>
				<c:otherwise>
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
					<a class="icon" href="javascript:JS_print2('安排生育情况'+JS_getKindTitle(${param.p_type }))"><span>打印或者导出</span>
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
					<th width="80" orderField="dateh" class="orderFlag" htype="date" distype="2,3">登记申请日期</th>
					<th width="80" orderField="edd" class="orderFlag" htype="date">安排生育日期</th>
					<th width="80" orderField="remark" class="orderFlag" distype="2,3">安排生育原因</th>
					<th width="80" orderField="househodeKind" class="orderFlag" htype="dict">户口性质</th>
					<th width="80" orderField="matenalStatus" class="orderFlag" htype="dict" distype="1">婚姻状况</th>
					<th width="80" orderField="boynum" class="orderFlag" htype="digits">男孩数</th>
					<th width="80" orderField="girlnum" class="orderFlag" htype="digits">女孩数</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
					<th width="80" orderField="househodeKind2" class="orderFlag" htype="dict">丈夫户口性质</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${a.edd}" pattern="yyyy-MM-dd"/></td>
					<td>${a.remark}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td><tags:js.dict.getValue value="${a.matenalStatus}"/></td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td>${a.nameh2}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind2}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>