<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" readonly="readonly" type="text" size="30" value="${womanId}"/>
					</p>
																														<p>
					<label>申请日期：</label>
					<input name="dateh" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>申请类型：</label>
					<input name="typeh" readonly="readonly" type="text" size="30" value="${typeh}"/>
					</p>
																														<p>
					<label>是否接受申请：</label>
					<input name="isAccept" readonly="readonly" type="text" size="30" value="${isAccept}"/>
					</p>
																														<p>
					<label>是否再生二孩：</label>
					<input name="isSecond" readonly="readonly" type="text" size="30" value="${isSecond}"/>
					</p>
																														<p>
					<label>申请条件：</label>
					<input name="cond" readonly="readonly" type="text" size="30" value="${cond}"/>
					</p>
																														<p>
					<label>申请书编号：</label>
					<input name="code" readonly="readonly" type="text" size="30" value="${code}"/>
					</p>
																														<p>
					<label>经办人：</label>
					<input name="agent" readonly="readonly" type="text" size="30" value="${agent}"/>
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
