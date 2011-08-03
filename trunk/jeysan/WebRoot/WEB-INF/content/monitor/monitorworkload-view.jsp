<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>操作时间：</label>
					<input name="operatTime" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${operatTime}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>操作人：</label>
					<input name="operator" readonly="readonly" type="text" size="30" value="${operator}"/>
					</p>
																														<p>
					<label>操作人IP：</label>
					<input name="operatIp" readonly="readonly" type="text" size="30" value="${operatIp}"/>
					</p>
																														<p>
					<label>工作类别：</label>
					<input name="workType" readonly="readonly" type="text" size="30" value="${workType}"/>
					</p>
																														<p>
					<label>工作量：</label>
					<input name="workLoad" readonly="readonly" type="text" size="30" value="${workLoad}"/>
					</p>
																														<p>
					<label>操作类型：</label>
					<input name="operatType" readonly="readonly" type="text" size="30" value="${operatType}"/>
					</p>
																														<p>
					<label>所属区域：</label>
					<input name="orgCode" readonly="readonly" type="text" size="30" value="${orgCode}"/>
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
