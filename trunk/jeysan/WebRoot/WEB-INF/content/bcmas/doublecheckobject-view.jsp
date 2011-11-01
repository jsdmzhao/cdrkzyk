<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						整体双查信息
					</h2>
				</div>

				<p>
					<label>
						年度：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${dc.year}" />
				</p>
				<p>
					<label>
						双查总次数：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${dc.total}" />
				</p>
<div class="divider"></div>
<c:forEach var="a" items="${dcs}">
				<p>
					<label>
						第${a.seq}轮&nbsp;&nbsp;起始年月：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${a.start}" />
				</p>
				<p>
					<label>
						结束年月：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${a.end}" />
				</p>
</c:forEach>
<div class="divider"></div>
				<p>
					<label>
						本次轮次：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${dc.seq}" />
				</p>
<div class="divider"></div>
				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						个人双查信息
					</h2>
				</div>
				<p>
					<label>
						名称：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${model.fertileWoman.nameh}" />
				</p>
				<p>
					<label>
						建卡时间：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${model.fertileWoman.createDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						编码：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${model.fertileWoman.code}" />
				</p>
				<p>
					<label>
						是否整体轮次：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.yes.no.getValue value="${model.issingle}"/>" />
				</p>
				<p>
					<label>
						双查类型：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${model.typeh}"/>" />
				</p>
				<p>
					<label>
						双查类型原因：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.cause}" />
				</p>
				<p>
					<label>
						双查起始年月：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.start}" />
				</p>
				<p>
					<label>
						双查结束年月：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.end}" />
				</p>
<div class="divider"></div>
<c:if test="${param.type==2}">
				<p>
					<label>
						双查时间：
					</label>
					<input name="dcDate" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${model.dcDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						查环结果：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${model.dcResult1}"/>" />
				</p>
				<p>
					<label>
						查孕结果：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${model.dcResult2}"/>" />
				</p>
				<p>
					<label>
						双查医院：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.hospital}" />
				</p>
				<p>
					<label>
						医院类型：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${model.hospitalType}"/>" />
				</p>
				<p>
					<label>
						检查医生：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.doctor}" />
				</p>
				<p>
					<label>
						备注：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.remark}" />
				</p>
</c:if>
<c:if test="${param.type==3}">


				<p>
					<label>
						处理措施：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${model.ldwContent}" />
				</p>
				<p>
					<label>
						处理时间：
					</label>
					<input readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${model.ldwDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						违约金：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${model.moneyh}" />
				</p>
				<p>
					<label>
						交款日期：
					</label>
					<input readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${payDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						收款人：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.cashier}" />
				</p>
</c:if>
		</div>
		<div class="formBar">
			<ul>
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
