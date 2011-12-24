<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<tags:js.pager action="${ctx}/decision/fixbasicquery1view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<c:choose>
		<c:when test="${param.p_type eq 1}">
			<input type="hidden" name="filter_LIKES_address" class="text" size="52" value="${param.filter_LIKES_address}"/>
			<input type="hidden" name="filter_EQS_houseNo" class="text" value="${param.filter_EQS_houseNo}"/>
			<input type="hidden" name="filter_GES_personCode" class="text" value="${param.filter_GES_personCode}"/>
			<input type="hidden" name="filter_LES_personCode" class="text" value="${param.filter_LES_personCode}"/>
			<input type="hidden" name="filter_LIKES_nameh" class="text" value="${param.filter_LIKES_nameh}"/>
			<input type="hidden" name="filter_LIKES_nameh2" class="text" value="${param.filter_LIKES_nameh2}"/>
		</c:when>
		<c:when test="${param.p_type eq 2}">
			<input type="hidden" name="filter_LIKES_nameh" class="text" value="${param.filter_LIKES_nameh}"/>
			<input type="hidden" name="filter_LIKES_nameh2" class="text" value="${param.filter_LIKES_nameh2}"/>
		</c:when>
		<c:when test="${param.p_type eq 3}">
			<input type="hidden" name="filter_EQI_househodeKind" class="text" value="${param.filter_EQI_househodeKind}"/>
			<input type="hidden" name="filter_EQI_househodeKind2" class="text" value="${param.filter_EQI_househodeKind2}"/>
		</c:when>
		<c:when test="${param.p_type eq 4}">
			<input type="hidden" name="filter_EQI_job" class="text" value="${param.filter_EQI_job}"/>
		</c:when>
		<c:when test="${param.p_type eq 7}">
			<input type="hidden" name="filter_EQI_politicalStatus" class="text" value="${param.filter_EQI_politicalStatus}"/>
			<input type="hidden" name="filter_EQI_politicalStatus2" class="text" value="${param.filter_EQI_politicalStatus2}"/>		
		</c:when>
		<c:when test="${param.p_type eq 9}">
			<input type="hidden" name="filter_EQS_personCode" class="text" value="${param.filter_EQS_personCode}"/>
			<input type="hidden" name="filter_EQS_code" class="text" value="${param.filter_EQS_code}"/>	
			<input type="hidden" name="filter_LIKES_nameh" class="text" value="${param.filter_LIKES_nameh}"/>	
			<input type="hidden" name="filter_GED_cancelDate" class="text" value="${param.filter_GED_cancelDate}"/>	
			<input type="hidden" name="filter_LED_cancelDate" class="text" value="${param.filter_LED_cancelDate}"/>	
			<input type="hidden" name="filter_EQI_cancelType" class="text" value="${param.filter_EQI_cancelType}"/>	
		</c:when>
		<c:when test="${param.p_type eq 10}">
			<input type="hidden" name="filter_GED_createDate" class="text" value="${param.filter_GED_createDate}"/>
			<input type="hidden" name="filter_LED_createDate" class="text" value="${param.filter_LED_createDate}"/>	
			<input type="hidden" name="filter_EQI_cardStatus" class="text" value="${param.filter_EQI_cardStatus}"/>	
		</c:when>
		<c:otherwise>
			<input type="hidden" name="repeat" class="text" value="${repeat }"/>	
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
	if('${param.p_type}' == '11'){
		var repeat = '${repeat}'||'1';
		$(':checkbox[name=repeat]').each(function(){
			$(this).attr('checked',repeat.indexOf(this.value) > -1);
		});
	}
}

function JS_getKindTitle(p_type){
	switch(p_type){
		case 1:
			return '(按育妇编码、地址、姓名)';
		case 2:
			return '(按育妇出生年月分年龄)';
		case 3:
			return '(按育妇及丈夫户口性质)';
		case 4:
			return '(按育妇职业类型)';
		case 7:
			return '(按育妇及丈夫政治面貌)';
		case 9:
			return '(已注销人员基本情况)';
		case 10:
			return '(育妇新增、变更情况)';
		case 11:
			return '(重复人口)';
		default:
			return '';
	}
}
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}/decision/fixbasicquery1view.action" method="post">
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
					<td>地址：
<input type="text" name="filter_LIKES_address" class="text" size="52" value="${param.filter_LIKES_address}"/>
					</td>
					<td>门牌号码：
<input type="text" name="filter_EQS_houseNo" class="text" value="${param.filter_EQS_houseNo}"/>
					</td>
				</tr><tr>
					<td>妇女编码范围：
<input type="text" name="filter_GES_personCode" class="text" value="${param.filter_GES_personCode}"/>~
<input type="text" name="filter_LES_personCode" class="text" value="${param.filter_LES_personCode}"/>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名：
<input type="text" name="filter_LIKES_nameh" class="text" value="${param.filter_LIKES_nameh}"/>
					</td>
					<td>丈夫姓名：
<input type="text" name="filter_LIKES_nameh2" class="text" value="${param.filter_LIKES_nameh2}"/>
					</td>
				</tr>
				</c:when>
				<c:when test="${param.p_type eq 2}">
					<tr>
					<td>妇女年龄：
<input type="text" name="filter_GEI_age" class="text" value="${param.filter_GEI_age}"/>~
<input type="text" name="filter_LEI_age" class="text" value="${param.filter_LEI_age}"/>
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 3}">
					<tr>
					<td>妇女户口：
<tags:js.dict.selector name="filter_EQI_househodeKind" value="${param.filter_EQI_househodeKind}" dictCode="JS1014" noRender="true"/>
					</td>
					<td>丈夫户口：
<tags:js.dict.selector name="filter_EQI_househodeKind2" value="${param.filter_EQI_househodeKind2}" dictCode="JS1014" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 4}">
					<tr>
					<td>职业类型：
<tags:js.dict.selector name="filter_EQI_job" value="${param.filter_EQI_job}" dictCode="JS1017" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 7}">
					<tr>
					<td>妇女政治面貌：
<tags:js.dict.selector name="filter_EQI_politicalStatus" value="${param.filter_EQI_politicalStatus}" dictCode="JS1049" noRender="true"/>
					</td>
					<td>丈夫政治面貌：
<tags:js.dict.selector name="filter_EQI_politicalStatus2" value="${param.filter_EQI_politicalStatus2}" dictCode="JS1049" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 9}">
				<c:set var="layouth" value="165"/>
					<tr>
					<td>妇女编码：
<input type="text" name="filter_EQS_personCode" class="text" size="43" value="${param.filter_EQS_personCode}"/>
					</td>
					<td>身份证号：
<input type="text" name="filter_EQS_code" class="text" value="${param.filter_EQS_code}"/>
					</td>
					<td>妇女姓名：
<input type="text" name="filter_LIKES_nameh" class="text" value="${param.filter_LIKES_nameh}"/>
					</td>
					</tr><tr>
					<td>注销时间：
<input type="text" name="filter_GED_cancelDate" class="date" readonly="true" value="${param.filter_GED_cancelDate}"/>~<input type="text" name="filter_LED_cancelDate" class="date" readonly="true" value="${param.filter_LED_cancelDate}"/>					
					</td>
					<td>注销原因：
<tags:js.dict.selector name="filter_EQI_cancelType" value="${param.filter_EQI_cancelType}" dictCode="JS1010" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:when test="${param.p_type eq 10}">
					<tr>
					<td>日期：
<input type="text" name="filter_GED_createDate" class="date" readonly="true" value="${param.filter_GED_createDate}"/>~<input type="text" name="filter_LED_createDate" class="date" readonly="true" value="${param.filter_LED_createDate}"/>					
					</td>
					<td>变更类型：
<tags:js.dict.selector name="filter_EQI_cardStatus" value="${param.filter_EQI_cardStatus}" dictCode="JS1023" noRender="true"/>
					</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
					<td>
<input type="checkbox" name="repeat" value="1"/>
					</td>
					<td>姓名重复</td>
					<td>
<input type="checkbox" name="repeat" value="2"/>
					</td>
					<td>身份证重复</td>
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
					<a class="icon" href="javascript:JS_print2('育龄妇女基本情况'+JS_getKindTitle(${param.p_type }))"><span>打印或者导出</span>
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
					<th width="80" orderField="code" class="orderFlag" distype="1,2,3,4,7,9,10">证件号码</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">出生日期</th>
					<th width="80" orderField="age" class="orderFlag" distype="1,3,4,7,11">年龄</th>
					<th width="80" orderField="cancelType" class="orderFlag" htype="dict" distype="1,2,3,4,7,10,11">注销类型</th>
					<th width="80" orderField="cancelDate" class="orderFlag" distype="1,2,3,4,7,10,11">注销日期</th>
					<th width="80" orderField="politicalStatus" class="orderFlag" htype="dict" distype="1,2,3,4,9,10,11">政治面貌</th>
					<th width="80" orderField="job" class="orderFlag" htype="dict" distype="1,2,3,7,9,10,11">职业类型</th>
					<th width="80" orderField="firstMarryDate" class="orderFlag" htype="date">初婚日期</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">婚姻状况</th>
					<th width="80" orderField="househodeKind" class="orderFlag" htype="dict" distype="9,10">户口性质</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">避孕节育措施</th>
					<th width="80" htype="digits">子女数</th>
					<th width="80" orderField="boynum" class="orderFlag" htype="digits">男孩数</th>
					<th width="80" orderField="girlnum" class="orderFlag" htype="digits">女孩数</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
					<th width="80" orderField="cardStatus" class="orderFlag" htype="dict" distype="1,2,3,4,7,9,11">操作类型</th>
					<th width="80" orderField="househodeKind2" class="orderFlag" htype="dict" distype="4,7,9,10">丈夫户口性质</th>
					<th width="80" orderField="politicalStatus2" class="orderFlag" htype="dict" distype="1,2,3,4,9,10,11">丈夫政治面貌</th>
					<th width="80" orderField="houseNo" class="orderFlag" distype="2,3,4,7,9,10">门牌号码</th>
					<th width="80" orderField="settleInPlace" class="orderFlag" distype="1,2,3,4,7,9,10,11">何地迁入</th>
					<th width="80" orderField="settleInDate" class="orderFlag" htype="date" distype="1,2,3,4,7,9,10,11">迁入日期</th>
					<th width="80" orderField="createDate" class="orderFlag" htype="date" distype="1,2,3,4,7,9,10">建卡日期</th>
					<th width="80" orderField="domicile" class="orderFlag" distype="1,2,3,4,7,9,10,11">丈夫户籍地</th>
					<th width="80" orderField="domicileType" class="orderFlag" htype="dict" distype="1,2,3,4,7,9,10,11">丈夫户口类别</th>
					<th width="80" orderField="area" class="orderFlag" htype="region" distype="1,2,3,4,7,9,10,11">所属区域</th>
				</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<td>${a.code}</td>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td>${a.age}</td>
					<td><tags:js.dict.getValue value="${a.cancelType}"/></td>
					<td><fmt:formatDate value="${a.createDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.politicalStatus}"/></td>
					<td><tags:js.dict.getValue value="${a.job}"/></td>
					<td><fmt:formatDate value="${a.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.marryStatus}"/></td>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td>${a.method}</td>
					<td>${a.boynum + a.girlnum}</td>
					<td>${a.boynum}</td>
					<td>${a.girlnum}</td>
					<td>${a.nameh2}</td>
					<td><tags:js.dict.getValue value="${a.househodeKind2}"/></td>
					<td><tags:js.dict.getValue value="${a.politicalStatus2}"/></td>
					<td>${a.houseNo}</td>
					<td>${a.settleInPlace}</td>
					<td><fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${a.cancelDate}" pattern="yyyy-MM-dd"/></td>
					<td>${a.cardStatus}</td>
					<td>${a.domicile}</td>
					<td><tags:js.dict.getValue value="${a.domicileType}"/></td>
					<td><tags:js.area.getValue value="${a.area}"></tags:js.area.getValue></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"  %>
	</div>
</div>