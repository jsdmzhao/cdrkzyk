<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>USER_ID：</label>
					<input name="userId" readonly="readonly" type="text" size="30" value="${userId}"/>
					</p>
																														<p>
					<label>开始时间：</label>
					<input name="startTime" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${startTime}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>结束时间：</label>
					<input name="endTime" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>标题：</label>
					<input name="title" readonly="readonly" type="text" size="30" value="${title}"/>
					</p>
																														<p>
					<label>详情：</label>
					<input name="detail" readonly="readonly" type="text" size="30" value="${detail}"/>
					</p>
																														<p>
					<label>状态：</label>
					<input name="status" readonly="readonly" type="text" size="30" value="${status}"/>
					</p>
																														<p>
					<label>备忘：</label>
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
