<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/doublecheckstat.action">
	<input type="hidden" name="filter_EQI_year" value="${param['filter_EQI_year']}" />
	<input type="hidden" name="filter_EQI_seq" value="${param['filter_EQI_seq']}" />
	<input type="hidden" name="start" value="${param['start']}" />
	<input type="hidden" name="end" value="${param['end']}" />
	<input type="hidden" name="status" value="${param['status']}" />
	<input type="hidden" name="type" value="${param['type']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/doublecheckstat.action" method="post">
	<input type="hidden" name="type" value="${param['type']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							<input type="radio" name="status" value="0" id="status0" checked="checked">
							按轮次
						</td>
						<td>
							年度：
							<select name="filter_EQI_year" id="filter_EQI_year">
								<option value="">选择年度</option>
								<c:forEach begin="1931" end="2030" var="a">
								<option value="${a}">${a}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							轮次：
							<select name="filter_EQI_seq" id="filter_EQI_seq">
								<option value="">选择轮次</option>
								<c:forEach var="a" items="${dcs}">
								<option value="${a.seq}">${a.seq}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<input type="radio" name="status" value="1" id="status1">
							按时间段
						</td>
						<td>
							起始年月：
							<input type="input" id="start" name="start" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})">
						</td>
						<td>
							终止年月：
							<input type="input" id="end" name="end" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})">
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
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li>
					<a class="icon" href="javascript:<c:if test="${(not empty param.start) && (not empty param.end)}">JS_print2('${param.start}至${param.end}查环查孕情况汇总表(一)')</c:if>"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<div layoutH="96">
		<table class="list" width="150%">
			<thead>
				<tr>
					<th></th>
					<th colspan="5">应查人数</th>
					<th colspan="5">已查人数</th>
					<th colspan="5">未查人数</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th width="80">
						单位
					</th>

					<th width="80">
						上环
					</th>
					<th width="80">
						使用药具
					</th>
					<th width="80">
						应落实措未落实
					</th>
					<th width="80">
						结扎不到一年
					</th>
					<th width="80">
						合计
					</th>


					<th width="80">
						上环
					</th>
					<th width="80">
						使用药具
					</th>
					<th width="80">
						应落实措未落实
					</th>
					<th width="80">
						结扎不到一年
					</th>
					<th width="80">
						合计
					</th>


					<th width="80">
						上环
					</th>
					<th width="80">
						使用药具
					</th>
					<th width="80">
						应落实措未落实
					</th>
					<th width="80">
						结扎不到一年
					</th>
					<th width="80">
						合计
					</th>


					<th width="80">
						查环查孕率
					</th>
					<th width="80">
						备注
					</th>
				</tr>
			</thead>
			<tbody>
<c:set var="total_161_0" value="0"/>
<c:set var="total_162_0" value="0"/>
<c:set var="total_166_0" value="0"/>
<c:set var="total_165_0" value="0"/>
<c:set var="total_0" value="0"/>
<c:set var="total_161_1" value="0"/>
<c:set var="total_162_1" value="0"/>
<c:set var="total_166_1" value="0"/>
<c:set var="total_165_1" value="0"/>
<c:set var="total_1" value="0"/>
				<c:forEach var="a" items="${villages}" varStatus="b">
<c:set var="t0" value="${results[a.code].s_161_0+results[a.code].s_162_0+results[a.code].s_166_0+results[a.code].s_165_0}"/>
<c:set var="t1" value="${results[a.code].s_161_1+results[a.code].s_162_1+results[a.code].s_166_1+results[a.code].s_165_1}"/>
<c:set var="total_161_0" value="${total_161_0+results[a.code].s_161_0}"/>
<c:set var="total_162_0" value="${total_162_0+results[a.code].s_162_0}"/>
<c:set var="total_166_0" value="${total_166_0+results[a.code].s_166_0}"/>
<c:set var="total_165_0" value="${total_165_0+results[a.code].s_165_0}"/>
<c:set var="total_0" value="${total_0+t0}"/>
<c:set var="total_161_1" value="${total_161_1+results[a.code].s_161_1}"/>
<c:set var="total_162_1" value="${total_162_1+results[a.code].s_162_1}"/>
<c:set var="total_166_1" value="${total_166_1+results[a.code].s_166_1}"/>
<c:set var="total_165_1" value="${total_165_1+results[a.code].s_165_1}"/>
<c:set var="total_1" value="${total_1+t1}"/>
					<tr>
						<td height="25">${a.name}</td>

						<td>${results[a.code].s_161_0+0}</td>
						<td>${results[a.code].s_162_0+0}</td>
						<td>${results[a.code].s_166_0+0}</td>
						<td>${results[a.code].s_165_0+0}</td>
						<td>${t0}</td>

						<td>${results[a.code].s_161_1+0}</td>
						<td>${results[a.code].s_162_1+0}</td>
						<td>${results[a.code].s_166_1+0}</td>
						<td>${results[a.code].s_165_1+0}</td>
						<td>${t1}</td>

						<td>${results[a.code].s_161_0-results[a.code].s_161_1}</td>
						<td>${results[a.code].s_162_0-results[a.code].s_162_1}</td>
						<td>${results[a.code].s_166_0-results[a.code].s_166_1}</td>
						<td>${results[a.code].s_165_0-results[a.code].s_165_1}</td>
						<td>${t0-t1}</td>

						<td><fmt:formatNumber value="${t0==0?0:(t1/t0)}" type="percent" pattern="#0.00%"/></td>
						<td></td>
					</tr>
				</c:forEach>
					<tr>
						<td height="25">合计</td>

						<td>${total_161_0}</td>
						<td>${total_162_0}</td>
						<td>${total_166_0}</td>
						<td>${total_165_0}</td>
						<td>${total_0}</td>
						
						<td>${total_161_1}</td>
						<td>${total_162_1}</td>
						<td>${total_166_1}</td>
						<td>${total_165_1}</td>
						<td>${total_1}</td>

						<td>${total_161_0-total_161_1}</td>
						<td>${total_162_0-total_162_1}</td>
						<td>${total_166_0-total_166_1}</td>
						<td>${total_165_0-total_165_1}</td>
						<td>${total_0-total_1}</td>

						<td><fmt:formatNumber value="${total_0==0?0:(total_1/total_0)}" type="percent" pattern="#0.00%"/></td>
						<td></td>
					</tr>
			</tbody>
		</table>
		</div>
	</div>
</div>
<script>
$(function(){
	var $box = navTab.getCurrentPanel();
	$('#filter_EQI_year',$box).val('${param.filter_EQI_year}');
	$('#filter_EQI_seq',$box).val('${param.filter_EQI_seq}');
	$('#start',$box).val('${param.start}');
	$('#end',$box).val('${param.end}');
	<c:if test="${not empty param.status}">
	$('#status${param.status}',$box).attr('checked','checked');
	</c:if>
	var data_tmp = null;
	$('#filter_EQI_year',$box).change(function(){
		if(this.value != ''){
			$.post('${ctx}/bcmas/doublecheckobject!getDoubleChecksByYear.action',{year:this.value},function(data){
				data_tmp = data;
				var $seq_selector = $('#filter_EQI_seq',$box);
				$seq_selector.empty();
				$("<option value=''>选择轮次</option>").appendTo($seq_selector);
				for(var i=0;i<data.length;i++)
					$("<option value='"+data[i].seq+"'>"+data[i].seq+"</option>").appendTo($seq_selector);
			},'json');
		}else{
			$('#filter_EQI_seq',$box).empty();
			$("<option value=''>选择轮次</option>").appendTo($seq_selector);
			$('#start',$box).val('');
			$('#end',$box).val('');
		}
	});
	$('#filter_EQI_seq',$box).change(function(){
		if(this.value != ''){
			if(data_tmp == null){
				<c:if test="${not empty dcs}">
				<c:forEach var="a" items="${dcs}">
				if(this.value=='${a.seq}'){
					$('#start',$box).val('${a.start}');
					$('#end',$box).val('${a.end}');
				}
				</c:forEach>
				</c:if>
			}else{
					for(var i=0;i<data_tmp.length;i++){
						if(this.value == data_tmp[i].seq){
							$('#start',$box).val(data_tmp[i].start);
							$('#end',$box).val(data_tmp[i].end);
							break;
						}
					}
			}
		}else{
			$('#start',$box).val('');
			$('#end',$box).val('');
		}
	});
});
</script>