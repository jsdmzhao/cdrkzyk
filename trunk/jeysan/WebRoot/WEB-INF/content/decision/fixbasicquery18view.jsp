<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery18view.action">
	<c:choose>
	<c:when test="${param.p_type eq 1}">
		<input type="hidden" name="filter_GED_issDate" value="${param.filter_GED_issDate}"/>
		<input type="hidden" name="filter_LED_issDate" value="${param.filter_LED_issDate}"/>
		<input type="hidden" name="filter_EQI_househodeKind" value="${param.filter_EQI_househodeKind}"/>
		<input type="hidden" name="filter_EQL_childnum" value="1"/>
	</c:when>
	<c:when test="${param.p_type eq 2}">
		<input type="hidden" name="filter_GED_issDate" value="${param.filter_GED_issDate}"/>
		<input type="hidden" name="filter_LED_issDate" value="${param.filter_LED_issDate}"/>
		<input type="hidden" name="filter_EQL_childnum" value="2"/>
		<input type="hidden" name="filter_EQI_sex2" value="2"/>
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
		return '基层常用统计资料查询(光荣证及养老保险办理)';
	}else if(p_type == 2){
		return '基层常用统计资料查询(纯二女户养老保险办理)';
	}
	return '';
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery18view.action" method="post">
		<input type="hidden" name="p_type" value="${param.p_type }"/>
		<div class="searchBar">
			<table class="searchContent">
			<c:set var="layouth" value="138"/>
			<c:choose>
			<c:when test="${param.p_type eq 1}">
				<input type="hidden" name="filter_EQL_childnum" value="1"/>
				<tr>
					<td>办理日期：
<input type="text" name="filter_GED_issDate" class="date" readonly="true" value="${param.filter_GED_issDate}"/>~
<input type="text" name="filter_LED_issDate" class="date" readonly="true" value="${param.filter_LED_issDate}"/>					
					</td>
					<td>户口性质：
<tags:js.dict.selector name="filter_EQI_househodeKind" value="${param.filter_EQI_househodeKind}" dictCode="JS1014" noRender="true"/>
					</td>
				</tr>
				</c:when>
				<c:when test="${param.p_type eq 2}">
				<input type="hidden" name="filter_EQL_childnum" value="2"/>
				<input type="hidden" name="filter_EQI_sex2" value="2"/>
					<tr>
					<td>办理日期：
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
					<th width="80" orderField="nameh" class="nameh">母方姓名</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">母方出生日期</th>
					<th width="80" orderField="domicile">母方户籍地</th>
					<th width="80" orderField="address">母方常住地</th>
					<th width="80" orderField="househodeKind" class="orderFlag" htype="dict">母方户口性质</th>
					<th width="80" orderField="nameh2" class="orderFlag">父方姓名</th>
					<th width="80" orderField="domicile2">父方户籍地</th>
					<th width="80" orderField="househodeKind2" class="orderFlag" htype="dict">父方户口性质</th>
					<th width="80" orderField="sex2" class="orderFlag" htype="dict">子女性别</th>
					<th width="80" orderField="childIndex" class="orderFlag" htype="digits" distype="1">孩次</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date">子女出生日期</th>
					<th width="80" orderField="policy" class="orderFlag" htype="dict">子女政策内外</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">避孕节育措施</th>
					<th width="80" orderField="issDate" class="orderFlag" htype="date">办理独生子女证日期</th>
					<th width="80" orderField="dateh" class="orderFlag">投保年月</th>
					<th width="80" orderField="moneyh" class="orderFlag" htype="digits">投保金额</th>
					<th width="80" orderField="remark">备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.nameh}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td>${a.domicile}</td>
					<td>${a.address}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td>${a.nameh2}</td>
					<td>${a.domicile2}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind2}"/></td>
					<td><tags:js.dict.getValue value="${a.sex2}"/></td>
					<td>${a.childIndex}</td>
					<td><fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.policy}"/></td>
					<td><tags:js.dict.getValue value="${a.method}"/></td>
					<td><fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.dateh}</td>
					<td>${a.moneyh}</td>
					<td>${a.remark}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>