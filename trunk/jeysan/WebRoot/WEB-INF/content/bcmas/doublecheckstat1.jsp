﻿<%@ page contentType="text/html;charset=UTF-8"%>
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
				<tr head="true">
					<th width="160" hcode="area">
						单位
					</th>

					<th width="80" hcode="s_161_0" htype="digits">
						上环
					</th>
					<th width="80" hcode="s_162_0" htype="digits">
						使用药具
					</th>
					<th width="120" hcode="s_166_0" htype="digits">
						应落实措未落实
					</th>
					<th width="120" hcode="s_165_0" htype="digits">
						结扎不到一年
					</th>
					<th width="80" hcode="s_0" htype="digits">
						合计
					</th>


					<th width="80" hcode="s_161_1" htype="digits">
						上环
					</th>
					<th width="80" hcode="s_162_1" htype="digits">
						使用药具
					</th>
					<th width="120" hcode="s_166_1" htype="digits">
						应落实措未落实
					</th>
					<th width="120" hcode="s_165_1" htype="digits">
						结扎不到一年
					</th>
					<th width="80" hcode="s_1" htype="digits">
						合计
					</th>


					<th width="80" hcode="s_161_2" htype="digits">
						上环
					</th>
					<th width="80" hcode="s_162_2" htype="digits">
						使用药具
					</th>
					<th width="120" hcode="s_166_2" htype="digits">
						应落实措未落实
					</th>
					<th width="120" hcode="s_165_2" htype="digits">
						结扎不到一年
					</th>
					<th width="80" hcode="s_2" htype="digits">
						合计
					</th>


					<th width="80" hcode="s_scale" htype="per">
						查环查孕率
					</th>
					<th width="80" hcode="remark">
						备注
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${results}" varStatus="b">
					<tr>
						<td height="25">${a.area}</td>

						<td>${a.s_161_0}</td>
						<td>${a.s_162_0}</td>
						<td>${a.s_166_0}</td>
						<td>${a.s_165_0}</td>
						<td>${a.s_0}</td>

						<td>${a.s_161_1}</td>
						<td>${a.s_162_1}</td>
						<td>${a.s_166_1}</td>
						<td>${a.s_165_1}</td>
						<td>${a.s_1}</td>

						<td>${a.s_161_2}</td>
						<td>${a.s_162_2}</td>
						<td>${a.s_166_2}</td>
						<td>${a.s_165_2}</td>
						<td>${a.s_2}</td>

						<td><fmt:formatNumber value="${a.s_scale}" type="percent" pattern="#0.00%"/></td>
						<td></td>
					</tr>
				</c:forEach>
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