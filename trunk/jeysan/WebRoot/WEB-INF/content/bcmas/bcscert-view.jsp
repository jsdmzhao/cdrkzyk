<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="changed" value="<%=com.jeysan.cpf.util.Constants.CERT_TYPE.CHANGED%>"></c:set>
<c:set var="cancel" value="<%=com.jeysan.cpf.util.Constants.CERT_TYPE.CANCEL%>"></c:set>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						妇女姓名：
					</label>
					<input name="master.dwz_fertileWomanLookup.nameh" 
						type="text" size="30" value="${fertileWoman.nameh}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						妇女编号：
					</label>
					<input readonly="readonly"  name="master.dwz_fertileWomanLookup.code_" type="text" size="30" value="${fertileWoman.code}" />
				</p>
<div class="divider"></div>
				<p>
					<label>
						发证机关：
					</label>
					<input readonly="readonly" name="issOrg" type="text" size="30" value="${issOrg}" />
				</p>
				<p>
					<label>
						发证日期：
					</label>
					<input name="issDate" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						有效：
					</label>
					<input name="validPeroid" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${validPeroid}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						发证机关地址：
					</label>
					<input readonly="readonly" name="issOrgAddress" type="text" size="30"
						value="${issOrgAddress}" />
				</p>
				<p>
					<label>
						证书编号：
					</label>
					<input readonly="readonly" name="certCode" type="text" size="30" value="${certCode}" />
				</p>
				<p>
					<label>
						邮政编码：
					</label>
					<input readonly="readonly" type="text" size="30" value="${zipCode}" />
				</p>
				<p>
					<label>
						电话：
					</label>
					<input readonly="readonly" name="tel" type="text" size="30" value="${tel}" />
				</p>
				<p>
					<label>
						经办人：
					</label>
					<input readonly="readonly" name="agent" type="text" size="30" value="${agent}" />
				</p>
				<p style="width: 98%; height: 120px">
					<label>
						照片：
					</label>
					<img width="78" height="78" src="${ctx}/${children.photo}}" />
				</p>
<c:if test="${certType == changed}">
<div class="divider"></div>
				<p>
					<label>
						换证原因：
					</label>
					<input readonly="readonly" name="change.cause" type="text" size="30" value="<tags:js.dict.getValue value="${change.cause}"/>" />
				</p>
				<p>
					<label>
						换证日期：
					</label>
					<input name="change.dateh" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${change.dateh}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						换证经办人：
					</label>
					<input readonly="readonly" name="change.agent" type="text" size="30"
						value="${change.agent}" />
				</p>
</c:if>				
<c:if test="${certType == cancel}">
<div class="divider"></div>
				<p>
					<label>
						废止原因：
					</label>
					<input readonly="readonly" name="change.cause" type="text" size="30" value="<tags:js.dict.getValue value="${change.cause}"/>" />
				</p>
				<p>
					<label>
						废止日期：
					</label>
					<input name="change.dateh" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${change.dateh}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						废止经办人：
					</label>
					<input readonly="readonly" name="change.agent" type="text" size="30"
						value="${change.agent}" />
				</p>
</c:if>			
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="Button" onclick="navTab.closeCurrentTab()">
								取消
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
