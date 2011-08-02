<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>PERSON_ID：</label>
					<input name="personId" readonly="readonly" type="text" size="30" value="${personId}"/>
					</p>
																														<p>
					<label>建卡日期：</label>
					<input name="createDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${createDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>妇女类别：</label>
					<input name="typeh" readonly="readonly" type="text" size="30" value="${typeh}"/>
					</p>
																														<p>
					<label>妇女编码：</label>
					<input name="code" readonly="readonly" type="text" size="30" value="${code}"/>
					</p>
																														<p>
					<label>所属区域：</label>
					<input name="area" readonly="readonly" type="text" size="30" value="${area}"/>
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
