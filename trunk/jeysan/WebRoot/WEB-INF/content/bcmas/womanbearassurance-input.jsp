<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post"
			action="${ctx}/bcmas/womanbearassurance!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="dateh" value="${dateh}" id="dateh"/>
			<input type="hidden" name="fertileWoman.id"
				value="${fertileWoman.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_womanbearassurancemanage" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						姓名：
					</label>
					<input name="womanId" readonly="readonly" type="text"
						size="30" value="${fertileWoman.nameh}" />
				</p>
				<p>
					<label>
						妇女编码：
					</label>
					<input name="womanId" readonly="readonly"  type="text"
						size="30" value="${fertileWoman.code}" />
				</p>
				<p>
					<label>
						投保类型：
					</label>
					<tags:js.dict.selector name="typeh" value="${typeh}" dictCode="JS1019"/>
				</p>
				<p>
					<label>
						投保年月：
					</label>
					<select class="required" name="year_" id="year_" onchange="setDate_()" >
						<option value="">选择年份</option>
						<c:forEach begin="1931" end="2030" var="a">
						<option value="${a}">${a}</option>
						</c:forEach>
					</select>
					<select style="margin-left:10px" class="required" name="month_" id="month_" onchange="setDate_()" >
						<option value="">选择月份</option>
						<c:forEach begin="1" end="12" var="a">
						<c:if test="${a<10}"><c:set var="a" value="0${a}"/></c:if>
						<option value="${a}">${a}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label>
						投保金额：
					</label>
					<input name="moneyh" class="number" type="text" size="30"
						value="${moneyh}" />
				</p>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									保存
								</button>
							</div>
						</div>
					</li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="Button" onclick="navTab.closeCurrentTab()">
									取消
								</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>
<script>
function setDate_(){
	var year_ = $('#year_').val();
	var month_ = $('#month_').val();
	if(year_!=''&&month_!=''){
		$('#dateh').val(year_+'-'+month_);
	}
}
<c:if test="${not empty dateh}">
<c:set var="year_month" value="${fn:split(dateh, '-')}"/>
$('#year_').val('${year_month[0]}');
$('#month_').val('${year_month[1]}');
</c:if>
</script>