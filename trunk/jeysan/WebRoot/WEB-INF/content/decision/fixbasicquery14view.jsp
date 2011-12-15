<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery14view.action">
	<c:choose>
	<c:when test="${param.p_type eq 1}">
		<input type="hidden" name="filter_GED_issDate" class="text" value="${param.filter_GED_issDate}"/>
		<input type="hidden" name="filter_LED_issDate" class="text" value="${param.filter_LED_issDate}"/>
		<input type="hidden" name="filter_EQI_sex2" class="text" value="${param.filter_EQI_sex2}"/>
		<input type="hidden" name="filter_EQI_isCancel" class="text" value="${param.filter_EQI_isCancel}"/>
	</c:when>
	<c:when test="${param.p_type eq 2}">
		<input type="hidden" name="filter_EQI_househodeKind" class="text" value="${param.filter_EQI_househodeKind}"/>	
		<input type="hidden" name="filter_EQI_househodeKind2" class="text" value="${param.filter_EQI_househodeKind2}"/>	
		<input type="hidden" name="filter_EQI_sex2" class="text" value="${param.filter_EQI_sex2}"/>	
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
		return '证件办理情况查询(按年月查光荣证情况)';
	}else if(p_type == 2){
		return '证件办理情况查询(现有领光荣证情况)';
	}
	return '';
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery14view.action" method="post">
		<input type="hidden" name="p_type" value="${param.p_type }"/>
		<div class="searchBar">
			<table class="searchContent">
			<c:set var="layouth" value="138"/>
			<c:choose>
			<c:when test="${param.p_type eq 1}">
				<tr>
					<td>领证时间：
<input type="text" name="filter_GED_issDate" class="date" readonly="true" value="${param.filter_GED_issDate}"/>~
<input type="text" name="filter_LED_issDate" class="date" readonly="true" value="${param.filter_LED_issDate}"/>					
					</td>
					<td>子女性别：
<tags:js.dict.selector name="filter_EQI_sex2" value="${param.filter_EQI_sex2}" dictCode="JS010" noRender="true"/>
					</td>
					<td>是否有效：
<tags:js.dict.selector name="filter_EQI_isCancel" value="${param.filter_EQI_isCancel}" dictCode="JS050" noRender="true"/>
					</td>
				</tr>
				</c:when>
				<c:when test="${param.p_type eq 2}">
				<tr>
					<td>妇女户口：
<tags:js.dict.selector name="filter_EQI_househodeKind" value="${param.filter_EQI_househodeKind}" dictCode="JS1014" noRender="true"/>
					</td>
					<td>丈夫户口：
<tags:js.dict.selector name="filter_EQI_househodeKind2" value="${param.filter_EQI_househodeKind2}" dictCode="JS1014" noRender="true"/>
					</td>
					<td>子女性别：
<tags:js.dict.selector name="filter_EQI_sex2" value="${param.filter_EQI_sex2}" dictCode="JS010" noRender="true"/>
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
					<th width="80" orderField="personCode" class="orderFlag">育龄妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">姓名</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">婚姻状况</th>
					<th width="80" orderField="sex2" class="orderFlag" htype="dict" distype="1">一孩性别</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date" distype="1">生一孩年月</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">子女数</th>
					<th width="80" orderField="boynum" class="orderFlag" htype="digits">男孩数</th>
					<th width="80" orderField="girlnum" class="orderFlag" htype="digits">女孩数</th>
					<th width="80" orderField="issDate" class="orderFlag" htype="date">领独生证日期</th>
					<th width="80" orderField="issAttr" class="orderFlag" htype="dict">独生证属性</th>
					<th width="80" orderField="certCode" class="orderFlag" distype="1">证书编号</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">避孕节育措施</th>
					<th width="80" orderField="nameh3" class="orderFlag">丈夫姓名</th>
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
					<td><tags:js.dict.getValue value="${a.sex2}"/></td>
					<td><fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd"/></td>
					<td>${a.childnum}</td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td><fmt:formatDate value="${a.issDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.issAttr}"/></td>
					<td>${a.certCode}</td>
					<td><tags:js.dict.getValue value="${a.method}"/></td>
					<td>${a.nameh3}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>