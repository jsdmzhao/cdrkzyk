﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/personin!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personinmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>PERSON_ID：</label>
					<input name="personId" class="digits" type="text" size="30" value="${personId}"/>
					</p>
																													<p>
					<label>流入原因：</label>
					<input name="inCause" class="digits" type="text" size="30" value="${inCause}"/>
					</p>
																													<p>
					<label>流入日期：</label>
					<input name="inDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${inDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>流入地编码：</label>
					<input name="inAddressCode"    type="text" size="30" value="${inAddressCode}" />
					</p>
																													<p>
					<label>流入地地址：</label>
					<input name="inAddress"    type="text" size="30" value="${inAddress}" />
					</p>
																													<p>
					<label>持证情况：</label>
					<input name="haveStatus" class="digits" type="text" size="30" value="${haveStatus}"/>
					</p>
																													<p>
					<label>夫妻是否共同流入：</label>
					<input name="isFamilyAllIn" class="digits" type="text" size="30" value="${isFamilyAllIn}"/>
					</p>
																													<p>
					<label>SPOUSE_ID：</label>
					<input name="spouseId" class="digits" type="text" size="30" value="${spouseId}"/>
					</p>
																													<p>
					<label>配偶流入日期：</label>
					<input name="spouseInDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${spouseInDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>配偶流出日期：</label>
					<input name="spouseOutDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${spouseOutDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																	</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>