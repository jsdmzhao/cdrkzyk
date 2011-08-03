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
					<label>姓名：</label>
					<input name="nameh" readonly="readonly" type="text" size="30" value="${nameh}"/>
					</p>
																														<p>
					<label>性别：</label>
					<input name="sex" readonly="readonly" type="text" size="30" value="${sex}"/>
					</p>
																														<p>
					<label>出生日期：</label>
					<input name="birthday" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>出生地点：</label>
					<input name="birthAddress" readonly="readonly" type="text" size="30" value="${birthAddress}"/>
					</p>
																														<p>
					<label>政策内外：</label>
					<input name="policy" readonly="readonly" type="text" size="30" value="${policy}"/>
					</p>
																														<p>
					<label>政策外类型：</label>
					<input name="outType" readonly="readonly" type="text" size="30" value="${outType}"/>
					</p>
																														<p>
					<label>孩次：</label>
					<input name="childIndex" readonly="readonly" type="text" size="30" value="${childIndex}"/>
					</p>
																														<p>
					<label>出生证号：</label>
					<input name="birthCert" readonly="readonly" type="text" size="30" value="${birthCert}"/>
					</p>
																														<p>
					<label>健康状况：</label>
					<input name="healthStatus" readonly="readonly" type="text" size="30" value="${healthStatus}"/>
					</p>
																														<p>
					<label>血缘关系：</label>
					<input name="kinship" readonly="readonly" type="text" size="30" value="${kinship}"/>
					</p>
																														<p>
					<label>变化日期：</label>
					<input name="changeDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${changeDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>变化原因：</label>
					<input name="changeCause" readonly="readonly" type="text" size="30" value="${changeCause}"/>
					</p>
																														<p>
					<label>出生医院名称：</label>
					<input name="hospital" readonly="readonly" type="text" size="30" value="${hospital}"/>
					</p>
																														<p>
					<label>出生医院类型：</label>
					<input name="hospitalType" readonly="readonly" type="text" size="30" value="${hospitalType}"/>
					</p>
																														<p>
					<label>收养日期：</label>
					<input name="adoptDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${adoptDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>收养证号：</label>
					<input name="adoptCept" readonly="readonly" type="text" size="30" value="${adoptCept}"/>
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
