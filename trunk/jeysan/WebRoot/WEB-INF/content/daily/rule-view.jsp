<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>类别：</label>
					<input name="typeh" readonly="readonly" type="text" size="30" value="${typeh}"/>
					</p>
																														<p>
					<label>标题：</label>
					<input name="title" readonly="readonly" type="text" size="30" value="${title}"/>
					</p>
																														<p>
					<label>发布人：</label>
					<input name="sendEmployeeId" readonly="readonly" type="text" size="30" value="${sendEmployeeId}"/>
					</p>
																														<p>
					<label>发布时间：</label>
					<input name="dateKt" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateKt}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>级别：</label>
					<input name="levelKt" readonly="readonly" type="text" size="30" value="${levelKt}"/>
					</p>
																														<p>
					<label>内容：</label>
					<input name="content" readonly="readonly" type="text" size="30" value="${content}"/>
					</p>
																														<p>
					<label>附件：</label>
					<input name="attachment" readonly="readonly" type="text" size="30" value="${attachment}"/>
					</p>
																														<p>
					<label>备注：</label>
					<input name="remark" readonly="readonly" type="text" size="30" value="${remark}"/>
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
