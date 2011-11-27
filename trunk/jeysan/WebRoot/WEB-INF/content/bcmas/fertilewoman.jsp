<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/bcmas/fertilewoman.action">
	<input type="hidden" name="filter_LIKES_nameh"
		value="${param['filter_LIKES_nameh']}" />
	<input type="hidden" name="type" value="${param['type']}" />
	<input type="hidden" name="filter_EQD_createDate"
		value="${param['filter_EQD_createDate']}" />
	<input type="hidden" name="filter_EQS_code"
		value="${param['filter_EQS_code']}" />
	<input type="hidden" name="filter_EQS_area"
		value="${param['filter_EQS_area']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/bcmas/fertilewoman.action?type=${param['type']}"
			method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="filter_LIKES_nameh"
								value="${param['filter_LIKES_nameh']}" />
						</td>
						<td>
							建卡日期：
							<input type="text" name="filter_EQD_createDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param['filter_EQD_createDate']}" />
						</td>
						<td>
							编号：
							<input type="text" name="filter_EQS_code"
								value="${param['filter_EQS_code']}" />
						</td>
						<td>
							区域：
							<tags:js.area.selector readonly="true" size="20" name="filter_EQS_area" value="${param['filter_EQS_area']}"></tags:js.area.selector>
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
			<ul class="toolBar"><!-- 
				<li>
					<a class="add" href="${ctx}/bcmas/fertilewoman!input.action"
						target="navTab" rel="fertileWoman-input" title="添加育龄妇女"><span>添加</span>
					</a>
				</li> -->
				<li>
					<a class="delete"
						href="${ctx}/bcmas/fertilewoman!delete.action?ids={sid_xxx}&result4Json.navTabId=nav_fertilewomanmanage"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="icon" href="javascript:JS_print2('${param.type=='fix'?'户籍人口':'流动人口'}育妇基本信息')"><span>打印或导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						<input type="checkbox" class="checkboxCtrl" group="ids" />
					</th>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="createDate" class="orderFlag" htype="date">
						建卡日期
					</th>
					<th width="80" orderField="code" class="orderFlag">
						妇女编码
					</th>
					<th width="75" align="center">
						操作
					</th>
					<th width="50" align="center">
						育妇详情
					</th>
					<th width="40" align="center">
						查看卡片
					</th>
					<th style="display:none" hcode="womanBasic.marryStatus" htype="dict">婚姻状态</th>
					<th style="display:none" hcode="womanBasic.spouseMarryStatus" htype="dict">夫婚姻状态</th>
					<th style="display:none" hcode="womanBasic.firstMarryDate" htype="date">初婚日期</th>
					<th style="display:none" hcode="womanBasic.marryCryDate" htype="date">婚变日期</th>
					<th style="display:none" hcode="womanBasic.getGrzDate" htype="dict">领光荣证日期</th>
					<th style="display:none" hcode="womanBasic.planChild2Cause">安排二孩原因</th>
					<th style="display:none" hcode="womanBasic.planChild2Date" htype="date">安排二孩日期</th>
					<th style="display:none" hcode="womanBasic.planBear2Cause">安排再生原因</th>
					<th style="display:none" hcode="womanBasic.planBear2Date" htype="date">安排再生日期</th>
					<th style="display:none" hcode="womanBasic.getLdzType">领流动证类型</th>
					<th style="display:none" hcode="womanBasic.getLdzDate" htype="date">领流动证日期</th>
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
							${a.nameh}
						</td>
						<td>
							<fmt:formatDate value="${a.createDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.code}
						</td>
						<td>
							<div style="width: 75px;">
								<a class="btnView"
									href="${ctx}/bcmas/fertilewoman!view.action?id=${a.id}"
									target="navTab" title="查看育龄妇女信息" rel="fertileWoman-view"></a>
								<a class="btnEdit"
									href="${ctx}/bcmas/fertilewoman!input.action?id=${a.id}"
									target="navTab" title="修改育龄妇女信息" rel="fertileWoman-update"></a>
								<a class="btnDel"
									href="${ctx}/bcmas/fertilewoman!delete.action?id=${a.id}&result4Json.navTabId=nav_fertilewomanmanage"
									target="ajaxTodo" title="确定要删除吗？"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnInfo"
									href="${ctx}/bcmas/fertilewoman!${param['type']}.action?id=${a.id}&personId=${a.person.id}"
									target="navTab" title="育龄妇女详细信息" rel="fertileWomanFix"></a>
							</div>
						</td>
						<td>
							<div style="width: 25px;">
								<a class="btnLook"
									href="${ctx}/bcmas/fertilewoman!${param['type']}.action?id=${a.id}&personId=${a.person.id}&print=true"
									target="navTab" external="true" title="查看妇女信息卡" rel="marryCert-view"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>