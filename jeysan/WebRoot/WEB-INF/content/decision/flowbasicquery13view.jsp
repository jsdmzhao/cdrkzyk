<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery13view.action">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
	<input type="hidden" name="areaLevel"
		value="${param['areaLevel']}" />
	<input type="hidden" name="filter_GED_dateh"
		value="${param['filter_GED_dateh']}" />
	<input type="hidden" name="filter_LED_dateh"
		value="${param['filter_LED_dateh']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery13view.action" method="post">
	<input type="hidden" name="filter_EQI_domicileType"
		value="${param['filter_EQI_domicileType']}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							查询区域级别：
							<select id="areaLevel" name="areaLevel">
<option value="">全部</option>
<c:forEach items="${dict1.dictSubList}" var="a" varStatus="b">
<option value="${a.id}" <c:if test="${param.areaLevel==a.id}">selected="selected"</c:if>>${a.subName}</option>
</c:forEach>
<c:forEach items="${dict2.dictSubList}" var="a" varStatus="b">
<option value="${a.id}" <c:if test="${param.areaLevel==a.id}">selected="selected"</c:if>>${a.subName}</option>
</c:forEach>
							</select>
						</td>
						<td colspan="2">
							流入/流出日期：
							<input type="text" name="filter_GED_dateh" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param.filter_GED_dateh}" />
							~
							<input type="text" name="filter_LED_dateh" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								readonly="true" value="${param.filter_LED_dateh}" />
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
					<a class="icon"
						href="javascript:JS_print2('来源地分布查询')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="100%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" hcode="area" >
						单位
					</th>
					<th width="80" hcode="s_1" htype="digits">
						流入人数
					</th>
					<th width="80" hcode="s_2" htype="digits">
						流出人数
					</th>
					<th width="80" hcode="s_3" htype="per">
						流入比例
					</th>
					<th width="80" hcode="s_4" htype="per">
						流出比例
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${page.result}" varStatus="b">
					<tr>
						<td height="25">
							${b.index+1}
						</td>
						<td>
							${a.area}
						</td>
						<td>
							${a.s_1}
						</td>
						<td>
							${a.s_2}
						</td>
						<td>
							<fmt:formatNumber value="${a.s_3}" type="percent" pattern="#0.00%"/>
						</td>
						<td>
							<fmt:formatNumber value="${a.s_4}" type="percent" pattern="#0.00%"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>