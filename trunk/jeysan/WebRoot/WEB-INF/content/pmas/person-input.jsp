<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/person!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>姓名：</label>
					<input name="nameh"  class="required" maxlength="50"    type="text" size="30" value="${nameh}"  alt="请输入姓名" />
					</p>
																													<p>
					<label>身份证号码：</label>
					<input name="code"    type="text" size="30" value="${code}" />
					</p>
																													<p>
					<label>人员类别：</label>
					<input name="kind" class="digits" type="text" size="30" value="${kind}"/>
					</p>
																													<p>
					<label>人员编号：</label>
					<input name="personCode"    type="text" size="30" value="${personCode}" />
					</p>
																													<p>
					<label>户口类别：</label>
					<input name="domicileType" class="digits" type="text" size="30" value="${domicileType}"/>
					</p>
																													<p>
					<label>注销类别：</label>
					<input name="cancelType" class="digits" type="text" size="30" value="${cancelType}"/>
					</p>
																													<p>
					<label>注销日期：</label>
					<input name="cancelDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>死亡（迁出）时间：</label>
					<input name="dateh" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>何地迁入(流入)：</label>
					<input name="settleInPlace"    type="text" size="30" value="${settleInPlace}" />
					</p>
																													<p>
					<label>迁入(流入)日期：</label>
					<input name="settleInDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${settleInDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>迁入(流入)原因：</label>
					<input name="settleInCause"    type="text" size="30" value="${settleInCause}" />
					</p>
																													<p>
					<label>迁入(流入)类别：</label>
					<input name="settleInType" class="digits" type="text" size="30" value="${settleInType}"/>
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