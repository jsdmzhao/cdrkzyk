<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/personout!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personoutmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>PERSON_ID：</label>
					<input name="personId" class="digits" type="text" size="30" value="${personId}"/>
					</p>
																													<p>
					<label>流出原因：</label>
					<input name="outCause" class="digits" type="text" size="30" value="${outCause}"/>
					</p>
																													<p>
					<label>流出地编码：</label>
					<input name="outAddressCode"    type="text" size="30" value="${outAddressCode}" />
					</p>
																													<p>
					<label>流出地地址：</label>
					<input name="outAddress"    type="text" size="30" value="${outAddress}" />
					</p>
																													<p>
					<label>流出日期：</label>
					<input name="outDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${outDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
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
					<label>夫妻是否共同流出：</label>
					<input name="isFamilyAllOut" class="digits" type="text" size="30" value="${isFamilyAllOut}"/>
					</p>
																													<p>
					<label>备注：</label>
					<input name="remark"    type="text" size="30" value="${remark}" />
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