<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/doublecheckobject.action">
	<input type="hidden" name="filter_EQS_fertileWoman.area" value="${param['filter_EQS_fertileWoman.area']}" />
	<input type="hidden" name="filter_EQI_year" value="${param['filter_EQI_year']}" />
	<input type="hidden" name="filter_EQI_seq" value="${param['filter_EQI_seq']}" />
	<input type="hidden" name="filter_EQI_typeh" value="${param['filter_EQI_typeh']}" />
	<input type="hidden" name="status" value="${param['status']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/doublecheckobject.action" method="post">
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
							未确定
							<input type="radio" name="status" value="1" id="status1">
							已确定
						</td>
						<td id="td_dcObjType">
							双查对象类型：
							<tags:js.dict.selector noRender="true" name="dcObjType" value="${param.dcObjType}" dictCode="JS1013"/>
						</td>
						<td id="td_typeh" style="display:none">
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
<c:if test="${param.status==1}">
				<li>
					<a class="delete"
						href="${ctx}/bcmas/doublecheckobject!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_doublecheckobjectmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
</c:if>
<c:if test="${(empty param.status)||param.status==0}">
				<li>
					<a class="add" href="${ctx}/bcmas/doublecheckobject!check.action?ids={sid_xxx}&result4Json.navTabId=nav_doublecheckobjectmanage&check=no&filter_EQI_year=${param.filter_EQI_year}&filter_EQI_seq=${param.filter_EQI_seq}"
						target="ajaxTodo" title="确定不查所选吗?"><span>不查</span>
					</a>
				</li>
				<li>
					<a class="add"
						href="${ctx}/bcmas/doublecheckobject!check.action?ids={sid_xxx}&result4Json.navTabId=nav_doublecheckobjectmanage&check=free&filter_EQI_year=${param.filter_EQI_year}&filter_EQI_seq=${param.filter_EQI_seq}"
						target="ajaxTodo" title="确定免查所选吗?"><span>免查</span>
					</a>
				</li>
				<li>
					<a class="add"
						href="${ctx}/bcmas/doublecheckobject!check.action?ids={sid_xxx}&result4Json.navTabId=nav_doublecheckobjectmanage&check=yes&filter_EQI_year=${param.filter_EQI_year}&filter_EQI_seq=${param.filter_EQI_seq}"
						target="ajaxTodo" title="确定应查所选吗?"><span>应查</span>
					</a>
				</li>
</c:if><c:if test="${not empty param.status}">
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('${param.filter_EQI_year}年第${param.filter_EQI_seq}轮${param.status==0?'未':'已'}确定的双查对象基本信息')"><span>打印或导出</span>
					</a>
				</li></c:if>
			</ul>
		</div>
		<table class="table" width="100%" layouth="165">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" title="全选" />
					</th>
					<th width="30" align="center">
						序号
					</th>
<c:if test="${(empty param.status)||param.status==0}">
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="createDate" class="orderFlag" htype="date">
						建卡日期
					</th>
					<th width="80" orderField="code" class="orderFlag">
						妇女编码
					</th>
					<th width="120" orderField="code2" class="orderFlag">
						证件号码
					</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">
						出生日期
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag" htype="dict">
						婚姻状况
					</th>
					<th width="120" orderField="dcObjType" class="orderFlag" htype="dict">
						双查对象类型
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="address" class="orderFlag">
						居住地
					</th>
					<th width="50" align="center">
						不查
					</th>
					<th width="50" align="center">
						免查
					</th>
					<th width="50" align="center">
						应查
					</th>
					<th width="25" align="center">
						详情
					</th>
</c:if>
<c:if test="${param.status==1}">
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
					<th width="80" orderField="typeh" class="orderFlag" htype="dict">
						双查类型
					</th>
					<th width="80" orderField="cause" class="orderFlag">
						双查类型原因
					</th>
					<th width="80" orderField="dcStatus" class="orderFlag" htype="dict">
						双查状态
					</th>
					<th width="80" align="center">
						操作
					</th>
</c:if>
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
<c:if test="${(empty param.status)||param.status==0}">
						<td>
							${a.nameh}
						</td>
						<td>
							<fmt:formatDate value="${a.createDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.code}
						</td>
						<td>
							${a.code2}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.marryStatus}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.dcObjType}"></tags:js.dict.getValue>
						</td>
						<td>
							${a.domicile}
						</td>
						<td>
							${a.address}
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/doublecheckobject!check.action?id=${a.id}&result4Json.navTabId=nav_doublecheckobjectmanage&check=no&filter_EQI_year=${param.filter_EQI_year}&filter_EQI_seq=${param.filter_EQI_seq}"
									target="ajaxTodo" title="确定不查吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/doublecheckobject!check.action?id=${a.id}&result4Json.navTabId=nav_doublecheckobjectmanage&check=free&filter_EQI_year=${param.filter_EQI_year}&filter_EQI_seq=${param.filter_EQI_seq}"
									target="ajaxTodo" title="确定免查吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/doublecheckobject!check.action?id=${a.id}&result4Json.navTabId=nav_doublecheckobjectmanage&check=yes&filter_EQI_year=${param.filter_EQI_year}&filter_EQI_seq=${param.filter_EQI_seq}"
									target="ajaxTodo" title="确定应查吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnInfo"
									href="${ctx}/bcmas/fertilewoman!${a.domicileType==663?'fix':'flow'}.action?id=${a.id}&personId=${a.personId}"
									target="navTab" title="详细信息" rel="fertileWoman${a.domicileType==663?'Fix':'Flow'}"></a>
							</div>
						</td>
</c:if>
<c:if test="${param.status==1}">
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
							<tags:js.dict.getValue value="${a.typeh}"/>
						</td>
						<td>
							${a.cause}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.dcStatus}"/>
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnEdit"
									href="${ctx}/bcmas/doublecheckobject!input.action?id=${a.id}"
									target="navTab" title="修改双查对象信息"
									rel="doubleCheckObject-update"></a>
								<a class="btnView"
									href="${ctx}/bcmas/doublecheckobject!view.action?id=${a.id}&type=1"
									target="navTab" title="查看双查对象信息"
									rel="doubleCheckObject-view"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/doublecheckobject!delete.action?id=${a.id}&type=1&result4Json.navTabId=nav_doublecheckobjectmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
</c:if>
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
	$('#status0',$box).click(function(){
		if(this.checked){
			$('#td_dcObjType',$box).show();
			$('#td_typeh',$box).hide();
		}
	});
	$('#status1',$box).click(function(){
		if(this.checked){
			$('#td_dcObjType',$box).hide();
			$('#td_typeh',$box).show();
		}
	});
	$('#filter_EQI_year',$box).val('${param.filter_EQI_year}');
	$('#filter_EQI_seq',$box).val('${param.filter_EQI_seq}');
	$('#start',$box).val('${param.start}');
	$('#end',$box).val('${param.end}');
	$('#status${param.status}',$box).attr('checked','checked');
	if('${param.status}'=='0'){
		$('#td_dcObjType',$box).show();
		$('#td_typeh',$box).hide();
	}else if('${param.status}'=='1'){
		$('#td_dcObjType',$box).hide();
		$('#td_typeh',$box).show();
	}
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