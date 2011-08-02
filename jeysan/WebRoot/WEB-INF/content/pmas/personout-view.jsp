<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>PERSON_ID：</label>
					<input name="personId" readonly="readonly" type="text" size="30" value="${personId}"/>
					</p>
																														<p>
					<label>流出原因：</label>
					<input name="outCause" readonly="readonly" type="text" size="30" value="${outCause}"/>
					</p>
																														<p>
					<label>流出地编码：</label>
					<input name="outAddressCode" readonly="readonly" type="text" size="30" value="${outAddressCode}"/>
					</p>
																														<p>
					<label>流出地地址：</label>
					<input name="outAddress" readonly="readonly" type="text" size="30" value="${outAddress}"/>
					</p>
																														<p>
					<label>流出日期：</label>
					<input name="outDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${outDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>流入地编码：</label>
					<input name="inAddressCode" readonly="readonly" type="text" size="30" value="${inAddressCode}"/>
					</p>
																														<p>
					<label>流入地地址：</label>
					<input name="inAddress" readonly="readonly" type="text" size="30" value="${inAddress}"/>
					</p>
																														<p>
					<label>持证情况：</label>
					<input name="haveStatus" readonly="readonly" type="text" size="30" value="${haveStatus}"/>
					</p>
																														<p>
					<label>夫妻是否共同流出：</label>
					<input name="isFamilyAllOut" readonly="readonly" type="text" size="30" value="${isFamilyAllOut}"/>
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
