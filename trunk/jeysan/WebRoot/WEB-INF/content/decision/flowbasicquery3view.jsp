<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery3view.action">
	<input type="hidden" name="filter_EQI_id"
		value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery3view.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							主键：
							<input type="text" name="filter_EQI_id"
								value="${param['filter_EQI_id']}" />
						</td>
						<td>
							建档日期：
							<input type="text" class="date" readonly="true" />
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
					<a class="icon" href="javascript:JS_print2('生育子女情况')"><span>打印或者导出</span>
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
					<th width="80" orderField="personCode" class="orderFlag">
						流动人口编号
					</th>
					<th width="80" orderField="code" class="orderFlag">
						证件号码
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="sex" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="settleInDate" class="orderFlag" htype="date">
						流入日期
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="address" class="orderFlag">
						居住地
					</th>
					<th width="80" orderField="birthday" class="orderFlag" htype="date">
						出生日期
					</th>
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="domicile2" class="orderFlag">
						配偶户籍地
					</th>
					<th width="80" orderField="childnum" class="orderFlag" htype="digits">
						子女数
					</th>
					<th width="80" orderField="nameh3" class="orderFlag">
						子女姓名
					</th>
					<th width="80" orderField="sex2" class="orderFlag" htype="dict">
						性别
					</th>
					<th width="80" orderField="childIndex" class="orderFlag" htype="digits">
						孩次
					</th>
					<th width="80" orderField="birthday2" class="orderFlag" htype="date">
						出生日期
					</th>
					<th width="80" orderField="policy" class="orderFlag" htype="dict">
						政策内外
					</th>
					<th width="80" orderField="birthAddress" class="orderFlag">
						出生地点
					</th>
					<th width="80" orderField="kinship" class="orderFlag" htype="dict">
						血缘关系
					<th width="80" orderField="changeCause" class="orderFlag" htype="dict">
						变化原因
					</th>
					<th width="80" orderField="method" class="orderFlag" htype="dict">
						避孕节育措施
					</th>
					<th width="80" orderField="opsDate" class="orderFlag" htype="date">
						落实时间
					</th>
					</th>
					<th width="80" orderField="remark" class="orderFlag">
						备注
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
							${a.personCode}
						</td>
						<td>
							${a.code}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.sex}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.domicile}
						</td>
						<td>
							${a.address}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							${a.domicile2}
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							${a.nameh3}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.sex2}"/>
						</td>
						<td>
							${a.childIndex}
						</td>
						<td>
							<fmt:formatDate value="${a.birthday2}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<tags:js.dict.getValue value="${a.policy}"/>
						</td>
						<td>
							${a.birthAddress}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.kinship}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.changeCause}"/>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.method}"/>
						</td>
						<td>
							<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.remark}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>