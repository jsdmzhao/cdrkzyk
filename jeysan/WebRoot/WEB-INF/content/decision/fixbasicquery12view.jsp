<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery12view.action">
	<c:choose>
		<c:when test="${param.p_type eq 1}">
			<input type="hidden" name="filter_GED_upDate" class="text" size="52" value="${param.filter_GED_upDate}"/>
			<input type="hidden" name="filter_LED_upDate" class="text" value="${param.filter_LED_upDate}"/>
			<input type="hidden" name="filter_EQI_policy" class="text" value="291"/>
		</c:when>
		<c:when test="${param.p_type eq 2}">
			<input type="hidden" name="filter_EQI_politicalStatus" value="665"/>
			<input type="hidden" name="filter_EQI_policy" class="text" value="291"/>
		</c:when>
		<c:when test="${param.p_type eq 3}">
			<input type="hidden" name="filter_GED_birthday2" class="text" size="52" value="${param.filter_GED_birthday2}"/>
			<input type="hidden" name="filter_LED_birthday2" class="text" value="${param.filter_LED_birthday2}"/>
			<input type="hidden" name="filter_EQS_kinship" class="text" value="${param.filter_EQS_kinship}"/>	
		</c:when>
		<c:when test="${param.p_type eq 4}">
			<input type="hidden" name="filter_GED_upDate" class="text" size="52" value="${param.filter_GED_upDate}"/>
			<input type="hidden" name="filter_LED_upDate" class="text" value="${param.filter_LED_upDate}"/>
			<input type="hidden" name="filter_EQI_sex" class="text" value="${param.filter_EQI_sex}"/>	
			<input type="hidden" name="filter_EQI_policy" class="text" value="${param.filter_EQI_policy}"/>	
		</c:when>
		<c:when test="${param.p_type eq 5}">
			<input type="hidden" name="filter_GED_firstMarryDate" class="text" size="52" value="${param.filter_GED_firstMarryDate}"/>
			<input type="hidden" name="filter_LED_firstMarryDate" class="text" value="${param.filter_LED_firstMarryDate}"/>
			<input type="hidden" name="filter_EQI_childIndex" class="text" value="${param.filter_EQI_childIndex}"/>	
		</c:when>
		<c:when test="${param.p_type eq 6}">
			<input type="hidden" name="filter_GED_birthday2" class="text" size="52" value="${param.filter_GED_birthday2}"/>
			<input type="hidden" name="filter_LED_birthday2" class="text" value="${param.filter_LED_birthday2}"/>
		</c:when>
		<c:otherwise>
			<input type="hidden" name="filter_EQI_miss" value="1"/>
			<input type="hidden" name="filter_GED_birthday2" class="text" size="52" value="${param.filter_GED_birthday2}"/>
			<input type="hidden" name="filter_LED_birthday2" class="text" value="${param.filter_LED_birthday2}"/>
			<input type="hidden" name="filter_GED_upDate" class="text" size="52" value="${param.filter_GED_upDate}"/>
			<input type="hidden" name="filter_LED_upDate" class="text" value="${param.filter_LED_upDate}"/>
			<input type="hidden" name="filter_EQI_policy" class="text" value="${param.filter_EQI_policy}"/>	
			<input type="hidden" name="filter_EQI_childIndex" class="text" value="${param.filter_EQI_childIndex}"/>	
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
	switch(p_type){
		case 1:
			return '政策外生育、征款查询(政策外出生子女情况)';
		case 2:
			return '政策外生育、征款查询(党员政策外出生子女情况)';
		case 3:
			return '家庭子女出生情况查询(按子女血缘关系)';
		case 4:
			return '家庭子女出生情况查询(按上报年月查育妇生育情况)';
		case 5:
			return '家庭子女出生情况查询(按妇女初婚后生育间隔)';
		case 6:
			return '家庭子女出生情况查询(按年份查总和生育率)';
		case 7:
			return '家庭子女出生情况查询(历年漏报查询)';
		default:
			return '';
			
	}
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery12view.action" method="post">
		<input type="hidden" name="p_type" value="${param.p_type }"/>
		<div class="searchBar">
			<table class="searchContent">
			<c:set var="layouth" value="138"/>
			<c:choose>
			<c:when test="${param.p_type eq 1}">
				<tr>
					<td>查询日期：
<input type="text" name="filter_GED_upDate" class="date" readonly="true" value="${param.filter_GED_upDate}"/>~
<input type="text" name="filter_LED_upDate" class="date" readonly="true" value="${param.filter_LED_upDate}"/>	
<input type="hidden" name="filter_EQI_policy" class="text" value="291"/>				
					</td>
				</tr>
				</c:when>
				<c:when test="${param.p_type eq 2}">
<input type="hidden" name="filter_EQI_politicalStatus" value="665"/>
<input type="hidden" name="filter_EQI_policy" class="text" value="291"/>
				</c:when>
				<c:when test="${param.p_type eq 3}">
					<tr>
					<td>子女出生日期：
<input type="text" name="filter_GED_birthday2" class="date" readonly="true" value="${param.filter_GED_birthday2}"/>~
<input type="text" name="filter_LED_birthday2" class="date" readonly="true" value="${param.filter_LED_birthday2}"/>	
					</td>
					<td>血缘关系类型：
<tags:js.dict.selector name="filter_EQS_kinship" value="${param.filter_EQS_kinship}" dictCode="JS1061" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 4}">
				<c:set var="layouth" value="165"/>
					<tr>
					<td>子女上报日期：
<input type="text" name="filter_GED_upDate" class="date" readonly="true" value="${param.filter_GED_upDate}"/>~
<input type="text" name="filter_LED_upDate" class="date" readonly="true" value="${param.filter_LED_upDate}"/>	
					</td>
					<td>性别：
<tags:js.dict.selector name="filter_EQI_sex" value="${param.filter_EQI_sex}" dictCode="JS010" noRender="true"/>
					<td>政策内外出生类型：
<tags:js.dict.selector name="filter_EQI_policy" value="${param.filter_EQI_policy}" dictCode="JS1037" noRender="true"/>
					</td>
					</tr>
					<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;孩次：
<input type="text" name="filter_EQI_childIndex" class="text" size="5" value="${param.filter_EQI_childIndex}"/>	
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 5}">
					<tr>
					<td>初婚日期：
<input type="text" name="filter_GED_firstMarryDate" class="date" readonly="true" value="${param.filter_GED_firstMarryDate}"/>~
<input type="text" name="filter_LED_firstMarryDate" class="date" readonly="true" value="${param.filter_LED_firstMarryDate}"/>	
					</td>
					<td>婚后生育第
<input type="text" name="filter_EQI_childIndex" class="text" size="5" value="${param.filter_EQI_childIndex}"/>个孩子
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 6}">
					<tr>
					<td>子女出生日期：
<input type="text" name="filter_GED_birthday2" class="date" readonly="true" value="${param.filter_GED_birthday2}"/>~
<input type="text" name="filter_LED_birthday2" class="date" readonly="true" value="${param.filter_LED_birthday2}"/>	
					</td>
					</tr>
				</c:when>
				<c:otherwise>
				<c:set var="layouth" value="165"/>
				<input type="hidden" name="filter_EQI_miss" value="1"/>
					<tr>
					<td>子女出生日期：
<input type="text" name="filter_GED_birthday2" class="date" readonly="true" value="${param.filter_GED_birthday2}"/>~
<input type="text" name="filter_LED_birthday2" class="date" readonly="true" value="${param.filter_LED_birthday2}"/>	
					</td>
					<td>孩次：
<input type="text" name="filter_EQI_childIndex" class="text" size="5" value="${param.filter_EQI_childIndex}"/>	
					</td>
					</tr>
					<tr>
					<td>子女上报日期：
<input type="text" name="filter_GED_birthday" class="date" readonly="true" value="${param.filter_GED_upDate}"/>~
<input type="text" name="filter_LED_upDate" class="date" readonly="true" value="${param.filter_LED_upDate}"/>	
					</td>
					<td>政策内外出生类型：
<tags:js.dict.selector name="filter_EQI_policy" value="${param.filter_EQI_policy}" dictCode="JS1037" noRender="true"/>
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
					<th width="80" orderField="birthday" class="orderFlag" htype="date" distype="1,2,3,4">出生日期</th>
					<th width="80" orderField="firstMarryDate" class="orderFlag" htype="date" distype="1,2,4,7">初婚日期</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict" distype="1,2,3,4,5,7">婚姻状况</th>
					<th width="80" orderField="politicalStatus" class="orderFlag" htype="dict" distype="1,3,4,5,6,7">政治面貌</th>
					<th width="80" orderField="nameh3" class="orderFlag" distype="3">丈夫姓名</th>
					<th width="80" orderField="politicalStatus2" class="orderFlag" htype="dict" distype="1,3,4,5,6,7">丈夫政治面貌</th>
					<th width="80" orderField="nameh2" class="orderFlag" distype="1,2,3,6">子女姓名</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">子女性别</th>
					<th width="80" orderField="childIndex" class="orderFlag" htype="digits" distype="6">孩次</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date" distype="3,7">子女出生日期</th>
					<th width="80" orderField="kinship" class="orderFlag" htype="dict" distype="4,6,7">血缘关系</th>
					<th width="80" orderField="policy" class="orderFlag" htype="dict" distype="1,2,5">政策内外</th>
					<th width="80" orderField="changeDate" class="orderFlag" htype="date" distype="3,5,7">变化日期</th>
					<th width="80" orderField="changeCause" class="orderFlag" distype="3,5,7">变化原因</th>
					<th width="80" orderField="code" class="orderFlag" distype="1,2,3,4,5,6,7">身份证号</th>
					<th width="80" orderField="age" class="orderFlag" distype="1,2,3,4,5,6,7">年龄</th>
					<th width="80" orderField="tel" class="orderFlag" distype="1,2,3,4,5,6,7">联系电话</th>
					<th width="80" orderField="houseNo" class="orderFlag" distype="1,2,3,5,6,7">门牌号</th>
					<th width="80" orderField="outType" class="orderFlag" distype="1,2,3,4,5,6,7">政策外类型</th>
					<th width="80" orderField="upDate" class="orderFlag" distype="1,2,4,5,6">上报日期</th>
					<th width="80" orderField="domicileType" class="orderFlag" distype="1,2,3,4,5,6,7">户口类别</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${a.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.marryStatus}"/></td>
					<td><tags:js.dict.getValue value="${a.politicalStatus}"/></td>
					<td>${a.nameh3}</td>
					<td><tags:js.dict.getValue value="${a.politicalStatus2}"/></td>
					<td>${a.nameh2}</td>
					<td><tags:js.dict.getValue value="${a.sex}"/></td>
					<td>${a.childIndex}</td>
					<td><fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.kinship}"/></td>
					<td><tags:js.dict.getValue value="${a.policy}"/></td>
					<td><fmt:formatDate value="${a.changeDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.changeCause}</td>
					<td>${a.code}</td>
					<td>${a.age}</td>
					<td>${a.tel}</td>
					<td>${a.houseNo}</td>
					<td>${a.outType}</td>
					<td><fmt:formatDate value="${a.upDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.domicileType}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>