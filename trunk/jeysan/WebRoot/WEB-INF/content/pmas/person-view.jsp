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
