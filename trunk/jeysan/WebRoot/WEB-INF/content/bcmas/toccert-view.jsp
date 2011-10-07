<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="cancel" value="<%=com.jeysan.cpf.util.Constants.CERT_STATUS.CANCEL%>"></c:set>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						父母信息
					</h2>
				</div>
				<p>
					<label>
						姓名：
					</label>
					<input 
						readonly="readonly" type="text" size="30" value="${person.nameh}" />
				</p>
				<p>
					<label>
						性别：
					</label>
					<input 
						readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${person.sex}"/>" />
				</p>
				<p>
					<label>
						编码：
					</label>
					<input 
						readonly="readonly" type="text" size="30"
						value="${person.personCode}" />
				</p>
				<p>
					<label>
						证件号码：
					</label>
					<input readonly="readonly"
						type="text" size="30" value="${person.code}" />
				</p>
				<p>
					<label>
						工作单位：
					</label>
					<input readonly="readonly"
						type="text" size="30" value="${person.personBasic.company}" />
				</p>
				<p>
					<label>
						配偶姓名：
					</label>
					<input 
						readonly="readonly" type="text" size="30" value="${spouse.nameh}" />
				</p>
				<p>
					<label>
						配偶工作单位：
					</label>
					<input readonly="readonly"
						type="text" size="30" value="${spouse.company}" />
				</p>


				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						子女信息
					</h2>
				</div>
				<p>
					<label>
						姓名：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${children.nameh}" />
				</p>
				<p>
					<label>
						性别：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${children.sex}"/>" />
				</p>
				<p>
					<label>
						民族：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${children.native}"/>" />
				</p>
				<p>
					<label>
						出生日期：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${children.birthday}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						照片：
					</label>
					<input  readonly="readonly" type="text" size="30"
						value="${children.photo}" />
				</p>
				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						证书信息
					</h2>
				</div>
				<p>
					<label>
						发证机关：
					</label>
					<input type="text" size="30" value="${issOrg}" />
				</p>
				<p>
					<label>
						发证日期：
					</label>
					<input readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						证书编号：
					</label>
					<input readonly="readonly" type="text" size="30" value="${certCode}" />
				</p>
				<p>
					<label>
						证书属性：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${issAttr}" />" />
				</p>
<c:if test="${isCancel==cancel}">
<div class="divider"></div>
				<p>
					<label>
						注销原因：
					</label>
					<input type="text" size="30" readonly="readonly"
						value="${cancelCause}" />
				</p>
				<p>
					<label>
						注销日期：
					</label>
					<input readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>" />
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
