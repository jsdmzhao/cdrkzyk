<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>姓名：</label>
					<input name="nameh" readonly="readonly" type="text" size="30" value="${nameh}"/>
					</p>
																														<p>
					<label>身份证号码：</label>
					<input name="code" readonly="readonly" type="text" size="30" value="${code}"/>
					</p>
																														<p>
					<label>人员类别：</label>
					<input name="kind" readonly="readonly" type="text" size="30" value="${kind}"/>
					</p>
																														<p>
					<label>人员编号：</label>
					<input name="personCode" readonly="readonly" type="text" size="30" value="${personCode}"/>
					</p>
																														<p>
					<label>户口类别：</label>
					<input name="domicileType" readonly="readonly" type="text" size="30" value="${domicileType}"/>
					</p>
																														<p>
					<label>注销类别：</label>
					<input name="cancelType" readonly="readonly" type="text" size="30" value="${cancelType}"/>
					</p>
																														<p>
					<label>注销日期：</label>
					<input name="cancelDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>死亡（迁出）时间：</label>
					<input name="dateh" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>何地迁入(流入)：</label>
					<input name="settleInPlace" readonly="readonly" type="text" size="30" value="${settleInPlace}"/>
					</p>
																														<p>
					<label>迁入(流入)日期：</label>
					<input name="settleInDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${settleInDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>迁入(流入)原因：</label>
					<input name="settleInCause" readonly="readonly" type="text" size="30" value="${settleInCause}"/>
					</p>
																														<p>
					<label>迁入(流入)类别：</label>
					<input name="settleInType" readonly="readonly" type="text" size="30" value="${settleInType}"/>
					</p>
																		</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
</div>
