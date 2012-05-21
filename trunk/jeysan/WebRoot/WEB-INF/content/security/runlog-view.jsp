<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>更新时间：</label>
					<input name="updateTime" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${updateTime}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>业务名称：</label>
					<input name="bussName" readonly="readonly" type="text" size="30" value="${bussName}"/>
					</p>
																														<p>
					<label>类：</label>
					<input name="bussClass" readonly="readonly" type="text" size="30" value="${bussClass}"/>
					</p>
																														<p>
					<label>方法：</label>
					<input name="bussMethod" readonly="readonly" type="text" size="30" value="${bussMethod}"/>
					</p>
																														<p>
					<label>持续时间：</label>
					<input name="lastTime" readonly="readonly" type="text" size="30" value="${lastTime}"/>
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
