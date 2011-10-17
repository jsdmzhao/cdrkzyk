<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<tags:js.pager action="${ctx}/decision/flowbasicquery6view.action">
	<input type="hidden" name="filter_EQI_id"
		value="${param['filter_EQI_id']}" />
</tags:js.pager>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}/decision/flowbasicquery6view.action" method="post">
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
					<a class="icon"
						href="javascript:JS_print2('fhp_flowbasicquery6_view')"><span>打印或者导出</span>
					</a>
				</li>
			</ul>
		</div>
		<table class="table" width="200%" layouth="138">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80" orderField="personCode" class="orderFlag">
						流动人口编号
					</th>
					<th width="80" orderField="nameh" class="orderFlag">
						姓名
					</th>
					<th width="80" orderField="code" class="orderFlag">
						身份证号码
					</th>
					<th width="80" orderField="settleInDate" class="orderFlag">
						流入日期
					</th>
					<th width="80" orderField="birthday" class="orderFlag">
						出生日期
					</th>
					<th width="80" orderField="marryStatus" class="orderFlag">
						婚姻状况
					</th>
					<th width="80" orderField="domicile" class="orderFlag">
						户籍地
					</th>
					<th width="80" orderField="address" class="orderFlag">
						居住地
					</th>
					<th width="80" orderField="tel" class="orderFlag">
						联系方式
					</th>
					<th width="80" orderField="childnum" class="orderFlag">
						子女数
					</th>
					<th width="80" orderField="cause" class="orderFlag">
						征收原因
					</th>
					<th width="80" orderField="totalMoney" class="orderFlag">
						应缴金额
					</th>
					<th width="80" orderField="yetMoney" class="orderFlag">
						已交金额
					</th>
					<th width="80" orderField="outDate" class="orderFlag">
						流出日期
					</th>
					<th width="80" orderField="noMoney" class="orderFlag">
						未交金额
					</th>
					<th width="80" orderField="installmentNum" class="orderFlag">
						分期数
					</th>
					<th width="80" orderField="lodOrg" class="orderFlag">
						征收机关
					</th>
					<th width="80" orderField="datehFirst" class="orderFlag">
						首次缴款日期
					</th>
					<th width="80" orderField="moneyhFirst" class="orderFlag">
						首次缴款金额
					</th>
					<th width="80" orderField="datehSecond" class="orderFlag">
						二次缴款日期
					</th>
					<th width="80" orderField="moneyhSecond" class="orderFlag">
						二次缴款金额
					</th>
					<th width="80" orderField="datehThird" class="orderFlag">
						三次缴款日期
					</th>
					<th width="80" orderField="moneyhThird" class="orderFlag">
						三次缴款金额
					</th>
					<th width="80" orderField="nameh2" class="orderFlag">
						配偶姓名
					</th>
					<th width="80" orderField="domicile2" class="orderFlag">
						配偶户籍地
					</th>
					<th width="80" orderField="area" class="orderFlag">
						所属区域
					</th>
					<th width="80" orderField="domicileType" class="orderFlag">
						户口类别
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
							${a.nameh}
						</td>
						<td>
							${a.code}
						</td>
						<td>
							<fmt:formatDate value="${a.settleInDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.marryStatus}
						</td>
						<td>
							${a.domicile}
						</td>
						<td>
							${a.address}
						</td>
						<td>
							${a.tel}
						</td>
						<td>
							${a.childnum}
						</td>
						<td>
							${a.cause}
						</td>
						<td>
							${a.totalMoney}
						</td>
						<td>
							${a.yetMoney}
						</td>
						<td>
							<fmt:formatDate value="${a.outDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.noMoney}
						</td>
						<td>
							${a.installmentNum}
						</td>
						<td>
							${a.lodOrg}
						</td>
						<td>
							<fmt:formatDate value="${a.datehFirst}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.moneyhFirst}
						</td>
						<td>
							<fmt:formatDate value="${a.datehSecond}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.moneyhSecond}
						</td>
						<td>
							<fmt:formatDate value="${a.datehThird}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.moneyhThird}
						</td>
						<td>
							${a.nameh2}
						</td>
						<td>
							${a.domicile2}
						</td>
						<td>
							${a.area}
						</td>
						<td>
							${a.domicileType}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/common/page-foot.jsp"%>
	</div>
</div>