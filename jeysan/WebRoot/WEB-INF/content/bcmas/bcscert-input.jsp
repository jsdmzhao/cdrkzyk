<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="changed" value="<%=com.jeysan.cpf.util.Constants.CERT_TYPE.CHANGED%>"></c:set>
<c:set var="cancel" value="<%=com.jeysan.cpf.util.Constants.CERT_TYPE.CANCEL%>"></c:set>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/bcscert!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="type" value="${param.type}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_bcscertmanage" />
			<input type="hidden" id="fertileWomanId"
				name="master.dwz_fertileWomanLookup.fertileWomanId"
				value="${fertileWoman.id}" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						妇女姓名：
					</label>
					<input name="master.dwz_fertileWomanLookup.nameh" class="required"
						type="text" size="30" value="${fertileWoman.nameh}"
						readonly="readonly" />
					<a class="btnLook"
						href="${ctx}/bcmas/fertilewoman!list4lookup.action"
						lookupGroup="master" lookupName="fertileWomanLookup" >查找妇女</a>
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
					<input class="required" name="issOrg" type="text" size="30" value="${issOrg}" />
				</p>
				<p>
					<label>
						发证日期：
					</label>
					<input name="issDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						有效期：
					</label>
					<input name="validPeroid" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${validPeroid}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						发证机关地址：
					</label>
					<input name="issOrgAddress" type="text" size="30"
						value="${issOrgAddress}" />
				</p>
				<p>
					<label>
						证书编号：
					</label>
					<input class="required" name="certCode" type="text" size="30" value="${certCode}" />
				</p>
				<p>
					<label>
						邮政编码：
					</label>
					<input name="zipCode" type="text" size="30" value="${zipCode}" />
				</p>
				<p>
					<label>
						电话：
					</label>
					<input name="tel" type="text" size="30" value="${tel}" />
				</p>
				<p>
					<label>
						经办人：
					</label>
					<input name="agent" type="text" size="30" value="${agent}" />
				</p>
				<p style="width: 98%;">
					<label>
						照片：
					</label>
					<input name="photo_" type="file" size="30" />
				</p>
				<p style="width: 98%; height: 120px">
					<label>
						照片预览：
					</label>
					<img width="78" height="78" src="${ctx}/${photo}" />
				</p>
<c:if test="${certType == changed}">
<div class="divider"></div>
				<p>
					<label>
						换证原因：
					</label>
					<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${change.cause}"/>" />
				</p>
				<p>
					<label>
						换证日期：
					</label>
					<input readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${change.dateh}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						换证经办人：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${change.agent}" />
				</p>
</c:if>				
<c:if test="${certType == cancel}">
<div class="divider"></div>
				<p>
					<label>
						废止原因：
					</label>
					<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${change.cause}"/>" />
				</p>
				<p>
					<label>
						废止日期：
					</label>
					<input readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${change.dateh}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						废止经办人：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${change.agent}" />
				</p>
</c:if>			
<c:if test="${param.type == 0}">
<div class="divider"></div>
				<p>
					<label>
						换证原因：
					</label>
					<tags:js.dict.selector class1="required" name="change.cause" dictCode="JS1020"/>
				</p>
				<p>
					<label>
						换证日期：
					</label>
					<input name="change.dateh" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly" type="text"
						size="30" />
					
				</p>
				<p>
					<label>
						换证经办人：
					</label>
					<input name="change.agent" type="text" size="30"
						  />
				</p>
</c:if>				
<c:if test="${param.type == 1}">
<div class="divider"></div>
				<p>
					<label>
						废止原因：
					</label>
					<tags:js.dict.selector class1="required" name="change.cause"  dictCode="JS1009"/>
				</p>
				<p>
					<label>
						废止日期：
					</label>
					<input name="change.dateh" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly" type="text"
						size="30"
						  />
					
				</p>
				<p>
					<label>
						废止经办人：
					</label>
					<input name="change.agent" type="text" size="30" />
				</p>
</c:if>				
<c:if test="${param.type == 2}">
<div class="divider"></div>
				<p style="width:98%">
					<label>
						查验记录：
					</label>
					<input class="required" name="check.content" type="text" size="100" />
				</p>
				<p>
					<label>
						查验日期：
					</label>
					<input name="check.dateh" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly" type="text"
						size="30"
						  />
					
				</p>
				<p>
					<label>
						查验经办人：
					</label>
					<input name="check.agent" type="text" size="30" />
				</p>
</c:if>			
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									保存
								</button>
							</div>
						</div>
					</li>
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
</div>