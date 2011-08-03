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
					<label>取环类型：</label>
					<input name="typeh" readonly="readonly" type="text" size="30" value="${typeh}"/>
					</p>
																														<p>
					<label>取环时间：</label>
					<input name="dateh" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>手术医院：</label>
					<input name="hospital" readonly="readonly" type="text" size="30" value="${hospital}"/>
					</p>
																														<p>
					<label>手术医院类型：</label>
					<input name="hospitalType" readonly="readonly" type="text" size="30" value="${hospitalType}"/>
					</p>
																														<p>
					<label>手术医院地址：</label>
					<input name="hospitalAddress" readonly="readonly" type="text" size="30" value="${hospitalAddress}"/>
					</p>
																														<p>
					<label>手术人：</label>
					<input name="doctor" readonly="readonly" type="text" size="30" value="${doctor}"/>
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
