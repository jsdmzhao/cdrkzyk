<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>人员ID：</label>
					<input name="personId" readonly="readonly" type="text" size="30" value="${personId}"/>
					</p>
																														<p>
					<label>子女ID：</label>
					<input name="childId" readonly="readonly" type="text" size="30" value="${childId}"/>
					</p>
																														<p>
					<label>发证机关：</label>
					<input name="issOrg" readonly="readonly" type="text" size="30" value="${issOrg}"/>
					</p>
																														<p>
					<label>发证日期：</label>
					<input name="issDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>证书编号：</label>
					<input name="certCode" readonly="readonly" type="text" size="30" value="${certCode}"/>
					</p>
																														<p>
					<label>是否注销：</label>
					<input name="isCancel" readonly="readonly" type="text" size="30" value="${isCancel}"/>
					</p>
																														<p>
					<label>注销原因：</label>
					<input name="cancelCause" readonly="readonly" type="text" size="30" value="${cancelCause}"/>
					</p>
																														<p>
					<label>注销日期：</label>
					<input name="cancelDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>"/>
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
