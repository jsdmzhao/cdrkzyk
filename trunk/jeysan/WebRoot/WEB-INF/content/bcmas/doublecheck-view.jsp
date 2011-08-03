<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>每年双查次数：</label>
					<input name="count" readonly="readonly" type="text" size="30" value="${count}"/>
					</p>
																														<p>
					<label>轮次起始年月：</label>
					<input name="start" readonly="readonly" type="text" size="30" value="${start}"/>
					</p>
																														<p>
					<label>年度：</label>
					<input name="year" readonly="readonly" type="text" size="30" value="${year}"/>
					</p>
																														<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" readonly="readonly" type="text" size="30" value="${womanId}"/>
					</p>
																														<p>
					<label>查环查孕类型：</label>
					<input name="typeh" readonly="readonly" type="text" size="30" value="${typeh}"/>
					</p>
																														<p>
					<label>查环查孕类型原因：</label>
					<input name="cause" readonly="readonly" type="text" size="30" value="${cause}"/>
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
