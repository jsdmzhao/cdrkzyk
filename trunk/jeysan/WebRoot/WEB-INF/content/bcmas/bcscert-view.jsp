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
					<label>发证机关：</label>
					<input name="issOrg" readonly="readonly" type="text" size="30" value="${issOrg}"/>
					</p>
																														<p>
					<label>发证日期：</label>
					<input name="issDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>发证机关地址：</label>
					<input name="issOrgAddress" readonly="readonly" type="text" size="30" value="${issOrgAddress}"/>
					</p>
																														<p>
					<label>证书编号：</label>
					<input name="certCode" readonly="readonly" type="text" size="30" value="${certCode}"/>
					</p>
																														<p>
					<label>邮政编码：</label>
					<input name="zipCode" readonly="readonly" type="text" size="30" value="${zipCode}"/>
					</p>
																														<p>
					<label>电话：</label>
					<input name="tel" readonly="readonly" type="text" size="30" value="${tel}"/>
					</p>
																														<p>
					<label>经办人：</label>
					<input name="agent" readonly="readonly" type="text" size="30" value="${agent}"/>
					</p>
																														<p>
					<label>照片：</label>
					<input name="photo" readonly="readonly" type="text" size="30" value="${photo}"/>
					</p>
																														<p>
					<label>证件类型：</label>
					<input name="certType" readonly="readonly" type="text" size="30" value="${certType}"/>
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
