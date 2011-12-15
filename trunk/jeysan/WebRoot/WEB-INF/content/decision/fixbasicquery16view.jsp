<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery16view.action">
	<c:choose>
	<c:when test="${param.p_type eq 1}">
		<input type="hidden" name="filter_GED_issDate" class="text" value="${param.filter_GED_issDate}"/>
		<input type="hidden" name="filter_LED_issDate" class="text" value="${param.filter_LED_issDate}"/>
		<input type="hidden" name="filter_EQI_domicile" class="text" value="${param.filter_EQI_domicile}"/>
		<input type="hidden" name="filter_EQI_notake" class="text" value="${param.filter_EQI_notake}"/>
	</c:when>
	<c:when test="${param.p_type eq 2}">
		<input type="hidden" name="filter_GED_issDate" class="text" value="${param.filter_GED_issDate}"/>
		<input type="hidden" name="filter_LED_issDate" class="text" value="${param.filter_LED_issDate}"/>
		<input type="hidden" name="filter_EQI_notake" class="text" value="0"/>
	</c:when>
	<c:otherwise>
	</c:otherwise>
	</c:choose>
	<input type="hidden" name="p_type" value="${param.p_type }"/>
</tags:js.pager>
<script type="text/javascript">
$(function(){
	var notake = '${param.filter_EQI_notake}';
	if(notake){
		$(':radio[name=filter_EQI_notake][value='+notake+']').attr('checked',true);
		$('th[orderField=issDate]').attr('distype',notake == '1'?'1':'');
	}
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
		return '证件办理情况查询(计划生育服务证发放情况)';
	}else if(p_type == 2){
		return '基层常用统计资料查询(领计划生育服务证情况)';
	}
	return '';
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery16view.action" method="post">
		<input type="hidden" name="p_type" value="${param.p_type }"/>
		<div class="searchBar">
			<table class="searchContent">
			<c:set var="layouth" value="138"/>
			<c:choose>
			<c:when test="${param.p_type eq 1}">
				<c:set var="layouth" value="182"/>
				<tr>
					<td>办理服务证时间：
<input type="text" name="filter_GED_issDate" class="date" readonly="true" value="${param.filter_GED_issDate}"/>~
<input type="text" name="filter_LED_issDate" class="date" readonly="true" value="${param.filter_LED_issDate}"/>					
					<input type="radio" name="filter_EQI_notake" value="0">
					已领取服务证
					<input type="radio" name="filter_EQI_notake" value="1">
					未领取服务证
				</tr>
				<tr>
				<td class="pageFormContent"><label style="width: 50px">户籍地：</label>
<tags:js.district2.selector name="filter_EQI_domicile" readonly="true" size="85" valueLabel="${filter_EQI_domicile}" onChange="setAddress2" type="5"></tags:js.district2.selector>
					</td>
				</tr>
				</c:when>
				<c:when test="${param.p_type eq 2}">
					<input type="hidden" name="filter_EQI_notake" class="text" value="0"/>
					<tr>
					<td>领证日期：
<input type="text" name="filter_GED_issDate" class="date" readonly="true" value="${param.filter_GED_issDate}"/>~
<input type="text" name="filter_LED_issDate" class="date" readonly="true" value="${param.filter_LED_issDate}"/>		
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
					<a class="icon" href="javascript:JS_print2(JS_getKindTitle(${param.p_type }))"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="${layouth }">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag" distype="2">育龄妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">姓名</th>
					<th width="80" orderField="code" class="orderFlag" distype="2">身份证号码</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict" distype="2">性别</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict" distype="2">婚姻状况</th>
					<th width="80" orderField="domicile" distype="1">户籍地</th>
					<th width="80" orderField="address"  distype="1">常住地</th>
					<th width="80" orderField="househodeKind" class="orderFlag" htype="dict" distype="2">户口性质</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits" distype="2">子女数</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict" distype="2">避孕节育措施</th>
					<th width="80" orderField="nameh3" class="orderFlag">丈夫姓名</th>
					<th width="80" orderField="househodeKind2" class="orderFlag" htype="dict">丈夫户口性质</th>
					<th width="80" orderField="certCode" class="orderFlag" distype="1">计划生育服务证号码</th>
					<th width="80" orderField="issDate" class="orderFlag" htype="date">领服务证日期</th>
					<th width="80" orderField="agent" class="orderFlag" distype="1">经办人</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td>${a.code}</td>
					<td><tags:js.dict.getValue value="${a.sex}"/></td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.marryStatus}"/></td>
					<td>${a.domicile}</td>
					<td>${a.address}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td>${a.childnum}</td>
					<td><tags:js.dict.getValue value="${a.method}"/></td>
					<td>${a.nameh3}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind2}"/></td>
					<td>${a.certCode}</td>
					<td><fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.agent}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>