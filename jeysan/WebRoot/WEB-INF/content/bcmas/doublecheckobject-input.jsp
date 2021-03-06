﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	//request.setAttribute("filter", java.util.Arrays.asList(187, 188,189,190));
%>
<div class="page">
	<div class="pageContent">
		<form method="post"
			action="${ctx}/bcmas/doublecheckobject!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${model.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_doublecheckobjectmanage" />
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
					<tags:js.yes.no.selector name="issingle" class1="required" value="${model.issingle}"></tags:js.yes.no.selector>
				</p>
				<p>
					<label>
						双查类型：
					</label>
					<tags:js.dict.selector name="typeh" class1="required"  value="${model.typeh}" dictCode="JS1016"/>
				</p>
				<p>
					<label>
						双查类型原因：
					</label>
					<input name="cause" type="text" size="30" value="${model.cause}" />
				</p>
				<p>
					<label>
						双查起始年月：
					</label>
					<input name="start" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})" type="text" size="30" value="${model.start}" />
				</p>
				<p>
					<label>
						双查结束年月：
					</label>
					<input name="end" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM'})" type="text" size="30" value="${model.end}" />
				</p>
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