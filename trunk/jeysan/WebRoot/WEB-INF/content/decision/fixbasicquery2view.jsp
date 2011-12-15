<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<c:set var="action" value="${ctx}/decision/fixbasicquery2view.action"/>
<c:if test="${param.hasAccept eq 0}">
	<c:set var="action" value="${ctx}/decision/fixbasicquery3view.action"/>
</c:if>
<tags:js.pager action="${action}">
	<input type="hidden" name="hasAccept" value="${param.hasAccept}" />
	<c:if test="${param.hasAccept eq 1}">
	<input type="hidden" name="filter_EQS_eduType" value="${param.filter_EQS_eduType}" />
	<input type="hidden" name="filter_GED_eduDate" value="${param.filter_GED_eduDate}" />
	<input type="hidden" name="filter_LED_eduDate" value="${param.filter_LED_eduDate}" />
	</c:if>
	<c:if test="${param.hasAccept eq 0}">
	<input type="hidden" name="filter_GEI_age" value="${param.filter_GEI_age}" />
	<input type="hidden" name="filter_LEI_age" value="${param.filter_LEI_age}" />
	</c:if>
</tags:js.pager>
<script type="text/javascript">
$(function(){
	if('${param.hasAccept}'.length > 0){
		$(':radio[name=hasAccept][value=${param.hasAccept}]').attr('checked',true);
		$('td[id^=show_]').hide();
		$('#show_${param.hasAccept}').show();
		if('${param.hasAccept}' == '0'){
			$('#selector_filter_EQS_eduType').attr('disabled',true);
		}
	}
	$(':radio[name=hasAccept]').click(function(){
		$('td[id^=show_]').hide();
		$('#show_' + this.value).show();
		var action = '${ctx}/decision/fixbasicquery2view.action';
		if(this.value==0){
			action = '${ctx}/decision/fixbasicquery3view.action';
		}
		$('#selector_filter_EQS_eduType').attr('disabled',this.value==0);
		$('div.pageHeader form').attr('action',action);
	});

});
</script>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${action}" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						<input type="radio" name="hasAccept" value="1" checked="checked"/>
					</td>
					<td>
						已接受五期教育
					</td>
					<td>五期教育类型：
<tags:js.dict.selector name="filter_EQS_eduType" value="${param.filter_EQS_eduType}" dictCode="JS1022" noRender="true"/>
					</td>
				</tr><tr>
					<td>
						<input type="radio" name="hasAccept" value="0"/>
					</td>
					<td>
						未接受五期教育
					</td>
					<td id="show_1" style="display: none;">教育时间：
<input type="text" name="filter_GED_eduDate" class="date" readonly="true" value="${param.filter_GED_eduDate}"/>~<input type="text" name="filter_LED_eduDate" class="date" readonly="true" value="${param.filter_LED_eduDate}"/>					
					</td>
					<td id="show_0" style="display: none;">年龄：
<input type="text" name="filter_GEI_age" class="text" value="${param.filter_GEI_age}"/>~<input type="text" name="filter_LEI_age" class="text" value="${param.filter_LEI_age}"/>					
					</td>
				</tr>
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
					<a class="icon" href="javascript:JS_print2('育龄妇女基本情况(按育妇接受五期教育)')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">序号</th>
					<th width="80" orderField="personCode" class="orderFlag">育龄妇女编码</th>
					<th width="80" orderField="nameh" class="orderFlag">姓名</th>
					<c:if test="${param.hasAccept eq 0}">
					<th width="80" orderField="age" class="orderFlag">年龄</th>
					</c:if>
					<th width="80" orderField="birthday" htype="date" class="orderFlag">出生日期</th>
					<th width="80" orderField="firstMarryDate" htype="date" class="orderFlag">初婚日期</th>
					<th width="80" orderField="marryStatus" htype="dict" class="orderFlag">婚姻状况</th>
					<c:if test="${param.hasAccept eq 1}">
					<th width="80" orderField="eduType" htype="dict" class="orderFlag">教育类型</th>
					<th width="80" orderField="eduDate" htype="date" class="orderFlag">教育时间</th>
					</c:if>
					<th width="80" orderField="househodeKind" htype="dict" class="orderFlag">育妇户口性质</th>
					<th width="80" orderField="method" class="orderFlag">避孕节育措施</th>
					<th width="80" htype="digits">子女数</th>
					<th width="80" orderField="boynum" htype="digits" class="orderFlag">男孩数</th>
					<th width="80" orderField="girlnum" htype="digits" class="orderFlag">女孩数</th>
					<th width="80" orderField="nameh2" class="orderFlag">丈夫姓名</th>
					</tr>
			</thead>
			<tbody>
								<c:forEach var="a" items="${page.result}" varStatus="b">
				<tr>
					<td height="25">${b.index+1}</td>
					<td>${a.personCode}</td>
					<td>${a.nameh}</td>
					<c:if test="${param.hasAccept eq 0}">
					<td>${a.age}</td>
					</c:if>
					<td><fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${a.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
					<td><tags:js.dict.getValue value="${a.marryStatus}"/></td>
					<c:if test="${param.hasAccept eq 1}">
					<td><tags:js.dict.getValue value="${a.eduType}"/></td>
					<td><fmt:formatDate value="${a.eduDate}" pattern="yyyy-MM-dd"/></td>
					</c:if>
					<td><tags:js.dict.getValue value="${a.househodeKind}"/></td>
					<td>${a.method}</td>
					<td>${a.boynum + a.girlnum}</td>
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