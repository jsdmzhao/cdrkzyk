<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery9view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<c:choose>
		<c:when test="${param.p_type eq 1}">
			<input type="hidden" name="filter_EQI_marryStatus" class="text" value="${param.filter_EQI_marryStatus}"/>
		</c:when>
		<c:when test="${param.p_type eq 2}">
			<input type="hidden" name="filter_GED_firstMarryDate" class="text" value="${param.filter_GED_firstMarryDate}"/>
			<input type="hidden" name="filter_LED_firstMarryDate" class="text" value="${param.filter_LED_firstMarryDate}"/>
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
		return '育龄妇女婚姻孕产查询(育妇婚姻状况)';
	}else if(p_type == 2){
		return '育龄妇女婚姻孕产查询(育妇初婚年龄情况)';
	}else if(p_type == 3){
		return '家庭子女出生情况查询(按现有家庭子女数)';
	}
	return '';
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery9view.action" method="post">
		<input type="hidden" name="p_type" value="${param.p_type }"/>
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
		<div class="searchBar">
			<table class="searchContent">
			<c:set var="layouth" value="138"/>
			<c:choose>
			<c:when test="${param.p_type eq 1}">
				<tr>
					<td>婚姻状况：
<tags:js.dict.selector name="filter_EQI_marryStatus" value="${param.filter_EQI_marryStatus}" dictCode="JS1015" noRender="true"/>				
					</td>
				</tr>
			</c:when>
			<c:when test="${param.p_type eq 2}">
				<tr>
				<td>妇女初婚年月：
<input type="text" name="filter_GED_firstMarryDate" class="date" readonly="true" value="${param.filter_GED_firstMarryDate}"/>~
<input type="text" name="filter_LED_firstMarryDate" class="date" readonly="true" value="${param.filter_LED_firstMarryDate}"/>					
				</td>
				</tr>
				</c:when>
				<c:otherwise>
					<tr>
					<td>避孕节育措施类型：
<tags:js.dict.selector name="filter_EQI_method" value="${param.filter_EQI_method}" dictCode="JS1018" noRender="true"/>				
					</td>
					<td>子女结构情况：
						男孩数<input type="text" class="text" name="filter_EQL_boynum" value="${param.filter_EQL_girlnum}"/>
						女孩数<input type="text" class="text" name="filter_EQL_girlnum" value="${param.filter_EQL_girlnum}""/>
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
		<table class="table" width="100%" layouth="${layouth }">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag">育龄妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">姓名</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">婚姻状况</th>
					<th width="80" orderField="firstMarryDate" class="orderFlag" htype="date">初婚日期</th>
					<th width="80" orderField="marryCryDate" class="orderFlag" htype="date" distype="2,3">最近婚姻变动日期</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">避孕节育措施</th>
					<th width="80" orderField="boynum" class="orderFlag" htype="digits">男孩数</th>
					<th width="80" orderField="girlnum" class="orderFlag" htype="digits">女孩数</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
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
					<td><fmt:formatDate value="${a.marryCryDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.method}"/></td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td>${a.nameh2}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>