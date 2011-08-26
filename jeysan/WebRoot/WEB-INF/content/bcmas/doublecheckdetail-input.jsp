<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post"
			action="${ctx}/bcmas/doublecheckdetail!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/>
			<input type="hidden" name="result4Json.navTabId"
				value="nav_doublecheckdetailmanage" /> -->
			<div class="pageFormContent" layoutH="56">
				<div style="width:98%;float:left">
				<p style="width:98%">
					<label>
						年份：
					</label>
					<select name="year" id="year" onchange="navTab.reload('${ctx}/bcmas/doublecheckdetail!input.action?year='+this.value)">
						<option value="">选择年份</option>
						<c:forEach begin="1931" end="2030" var="a">
						<option value="${a}">${a}</option>
						</c:forEach>
					</select>
				</p>

				<p style="width:98%">
					<label>
						每年双查次数：
					</label>
					<select name="count" id="count" onchange="addCount()">
						<option value="">选择次数</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</p>
				<p style="width:98%">
					<label>
						轮次起始年月：
					</label>
					<input id="start" name="start" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM',onpicked:addCount})" type="text" size="30" value="${start}" />
				</p>
				</div>
				<div style="width:600px;float:left;border:1px solid #ccc;margin-top:40px;padding:10px" id="detail_div">
					<table cellpadding="0" cellspacing="0" id="detail_table">
					<c:if test="${fn:length(detailList)!=0}">
					<c:forEach items="${detailList}" var="a" varStatus="b">
						<tr>
							<td width="120" height="30">第${b.index+1}轮</td><td width="25" align="center">从</td>
							<td width="180"><input name="detail_start" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})" type="text" size="20" value="${a.start}" /></td><td width="25" align="center">到</td>
							<td width="180"><input name="detail_end" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})" type="text" size="20" value="${a.end}" /></td>
						</tr>
					</c:forEach>
					</c:if>
					<c:if test="${fn:length(detailList)==0}">
						<tr>
							<td width="120" height="30">第1轮</td><td width="25" align="center">从</td>
							<td width="180"><input name="detail_start" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})" type="text" size="20" /></td><td width="25" align="center">到</td>
							<td width="180"><input name="detail_end" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})" type="text" size="20"/></td>
						</tr>
					</c:if>
					</table>
				</div>

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
$(function(){
	$('#year').val('${year}');
	$('#count').val('${count}');
});
function addCount(){
	var v = $('#count').val();
	if(v == null || v == '')
		return;
	var start = $('#start').val();
	var $detail_table = $('#detail_table');
	var copyed_tr = $detail_table.find('tr').eq(0);
	$detail_table.empty();
	for(var i=0;i<v;i++){
		copyed_tr.find('td').eq(0).html('第'+(i+1)+'轮')
		if(start != null && start !=''){
			copyed_tr.find('input').eq(0).val(getNextYM(start,i*4));
			copyed_tr.find('input').eq(1).val(getNextYM(start,i*4+3));
		}
		$detail_table.append(copyed_tr.clone());
	}
}
</script>