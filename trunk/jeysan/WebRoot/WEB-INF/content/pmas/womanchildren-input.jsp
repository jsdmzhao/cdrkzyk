<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/womanchildren!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_womanchildrenmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>人员ID：</label>
					<input name="personId" class="digits  required" type="text" size="30" value="${personId}"/>
					</p>
																													<p>
					<label>姓名：</label>
					<input name="nameh"    type="text" size="30" value="${nameh}" />
					</p>
																													<p>
					<label>性别：</label>
					<input name="sex" class="digits" type="text" size="30" value="${sex}"/>
					</p>
																													<p>
					<label>出生日期：</label>
					<input name="birthday" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>出生地点：</label>
					<input name="birthAddress"    type="text" size="30" value="${birthAddress}" />
					</p>
																													<p>
					<label>政策内外：</label>
					<input name="policy" class="digits" type="text" size="30" value="${policy}"/>
					</p>
																													<p>
					<label>政策外类型：</label>
					<input name="outType" class="digits" type="text" size="30" value="${outType}"/>
					</p>
																													<p>
					<label>孩次：</label>
					<input name="childIndex" class="digits" type="text" size="30" value="${childIndex}"/>
					</p>
																													<p>
					<label>出生证号：</label>
					<input name="birthCert"    type="text" size="30" value="${birthCert}" />
					</p>
																													<p>
					<label>健康状况：</label>
					<input name="healthStatus" class="digits" type="text" size="30" value="${healthStatus}"/>
					</p>
																													<p>
					<label>血缘关系：</label>
					<input name="kinship"    type="text" size="30" value="${kinship}" />
					</p>
																													<p>
					<label>变化日期：</label>
					<input name="changeDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${changeDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>变化原因：</label>
					<input name="changeCause"    type="text" size="30" value="${changeCause}" />
					</p>
																													<p>
					<label>出生医院名称：</label>
					<input name="hospital"    type="text" size="30" value="${hospital}" />
					</p>
																													<p>
					<label>出生医院类型：</label>
					<input name="hospitalType" class="digits" type="text" size="30" value="${hospitalType}"/>
					</p>
																													<p>
					<label>收养日期：</label>
					<input name="adoptDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${adoptDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>收养证号：</label>
					<input name="adoptCept"    type="text" size="30" value="${adoptCept}" />
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