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
					<label>流入原因：</label>
					<input name="inCause" readonly="readonly" type="text" size="30" value="${inCause}"/>
					</p>
																														<p>
					<label>流入日期：</label>
					<input name="inDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${inDate}" pattern="yyyy-MM-dd"/>"/>
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
					<label>夫妻是否共同流入：</label>
					<input name="isFamilyAllIn" readonly="readonly" type="text" size="30" value="${isFamilyAllIn}"/>
					</p>
																														<p>
					<label>SPOUSE_ID：</label>
					<input name="spouseId" readonly="readonly" type="text" size="30" value="${spouseId}"/>
					</p>
																														<p>
					<label>配偶流入日期：</label>
					<input name="spouseInDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${spouseInDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>配偶流出日期：</label>
					<input name="spouseOutDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${spouseOutDate}" pattern="yyyy-MM-dd"/>"/>
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
