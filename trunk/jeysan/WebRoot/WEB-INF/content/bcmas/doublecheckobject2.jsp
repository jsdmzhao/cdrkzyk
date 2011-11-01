<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/doublecheckobject!list2.action">
	<input type="hidden" name="filter_EQS_fertileWoman.area" value="${param['filter_EQS_fertileWoman.area']}" />
	<input type="hidden" name="filter_EQI_year" value="${param['filter_EQI_year']}" />
	<input type="hidden" name="filter_EQI_seq" value="${param['filter_EQI_seq']}" />
	<input type="hidden" name="filter_EQI_typeh" value="${param['filter_EQI_typeh']}" />
	<input type="hidden" name="status" value="${param['status']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/doublecheckobject!list2.action" method="post">
	<input type="hidden" name="filter_EQS_fertileWoman.area" value="${param['filter_EQS_fertileWoman.area']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
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
							<input type="radio" name="status" value="0" id="status0" checked="checked">
							未登记
							<input type="radio" name="status" value="1" id="status1">
							已登记
						</td>
						<td id="td_typeh">
							双查类型：
							<tags:js.dict.selector noRender="true" name="filter_EQI_typeh" value="${param.filter_EQI_typeh}" dictCode="JS1016"/>
						</td>
					</tr>
					<tr>
						<td>
							起始年月：
							<input type="input" id="start" name="start" readonly="readonly">
						</td>
						<td>
							终止年月：
							<input type="input" id="end" name="end" readonly="readonly">
						</td>
						<td>
							所属区域：
							<tags:js.area.selector name="fertileWoman.area" readonly="true"
								value="${param['fertileWoman.area']}" size="20"></tags:js.area.selector>
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
					<a class="delete"
						href="${ctx}/bcmas/doublecheckobject!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_doubleCheckObject2manage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('${param.filter_EQI_year}年第${param.filter_EQI_seq}轮${param.status==0?'未':'已'}登记双查信息')"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="150%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" title="全选" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="year" class="orderFlag">
						年度
					</th>
					<th width="80" orderField="total" class="orderFlag">
						总次数
					</th>
					<th width="80" orderField="seq" class="orderFlag">
						轮次
					</th>
					<th width="80" orderField="fertileWoman.nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="fertileWoman.createDate" class="orderFlag" htype="date">
						建卡日期
					</th>
					<th width="80" orderField="fertileWoman.code" class="orderFlag">
						妇女编码
					</th>
					<th width="80" orderField="issingle" class="orderFlag" htype="bool">
						是否整体轮次
					</th>
					<th width="80" orderField="start" class="orderFlag">
						起始年月
					</th>
					<th width="80" orderField="end" class="orderFlag">
						终止年月
					</th>
					<th width="80" orderField="typeh" class="orderFlag" htype="dict">
						双查类型
					</th>
					<th width="80" orderField="cause" class="orderFlag">
						双查类型原因
					</th>
					<th width="80" orderField="dcStatus" class="orderFlag" htype="dict">
						双查状态
					</th>
					<th width="80" orderField="dcDate" class="orderFlag" htype="date">
						双查时间
					</th>
					<th width="80" orderField="dcResult1" class="orderFlag" htype="dict">
						查环结果
					</th>
					<th width="80" orderField="dcResult2" class="orderFlag" htype="dict">
						查孕结果
					</th>
					<th width="100" align="center">
						登记/修改
					</th>
					<th width="80" align="center">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td height="25">
							<input type="checkbox" name="ids" value="${a.id}" />
						</td>
						<td>
							${b.index+1}
						</td>
						<td>
							${a.year}
						</td>
						<td>
							${a.total}
						</td>
						<td>
							${a.seq}
						</td>
						<td>
							${a.fertileWoman.nameh}
						</td>
						<td>
							<fmt:formatDate value="${a.fertileWoman.createDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.fertileWoman.code}
						</td>
						<td>
							<tags:js.yes.no.getValue value="${a.issingle}"></tags:js.yes.no.getValue>
						</td>
						<td>
							${a.start}
						</td>
						<td>
							${a.end}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.typeh}"/>
						</td>
						<td>
							${a.cause}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.dcStatus}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.dcDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.dcResult1}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.dcResult2}"/>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/doublecheckobject!input2.action?id=${a.id}"
									target="navTab" title="登记或修改双查结果"
									rel="doubleCheckObject2-update"></a>
							</div>
						</td>
						<td>
							<div style="width: 50px;">
								<a class="btnView"
									href="${ctx}/bcmas/doublecheckobject!view.action?id=${a.id}&type=2"
									target="navTab" title="查看登记信息"
									rel="doubleCheckObject2-view"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/doublecheckobject!delete.action?id=${a.id}&type=2&result4Json.navTabId=nav_doubleCheckObject2manage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>
<script>
$(function(){
	var $box = navTab.getCurrentPanel();
	$('#filter_EQI_year',$box).val('${param.filter_EQI_year}');
	$('#filter_EQI_seq',$box).val('${param.filter_EQI_seq}');
	$('#start',$box).val('${param.start}');
	$('#end',$box).val('${param.end}');
	$('#status${param.status}',$box).attr('checked','checked');

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