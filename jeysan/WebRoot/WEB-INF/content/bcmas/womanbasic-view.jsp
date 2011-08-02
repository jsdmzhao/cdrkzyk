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
					<label>婚姻状态：</label>
					<input name="marryStatus" readonly="readonly" type="text" size="30" value="${marryStatus}"/>
					</p>
																														<p>
					<label>夫婚姻状态：</label>
					<input name="spouseMarryStatus" readonly="readonly" type="text" size="30" value="${spouseMarryStatus}"/>
					</p>
																														<p>
					<label>初婚日期：</label>
					<input name="firstMarryDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${firstMarryDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>婚变日期：</label>
					<input name="marryCryDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${marryCryDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>领光荣证日期：</label>
					<input name="getGrzDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${getGrzDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>安排二孩原因：</label>
					<input name="planChild2Cause" readonly="readonly" type="text" size="30" value="${planChild2Cause}"/>
					</p>
																														<p>
					<label>安排二孩日期：</label>
					<input name="planChild2Date" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${planChild2Date}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>安排再生原因：</label>
					<input name="planBear2Cause" readonly="readonly" type="text" size="30" value="${planBear2Cause}"/>
					</p>
																														<p>
					<label>安排再生日期：</label>
					<input name="planBear2Date" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${planBear2Date}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>领流动证类型：</label>
					<input name="getLdzType" readonly="readonly" type="text" size="30" value="${getLdzType}"/>
					</p>
																														<p>
					<label>领流动证日期：</label>
					<input name="getLdzDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${getLdzDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>健康状况：</label>
					<input name="healthStatus" readonly="readonly" type="text" size="30" value="${healthStatus}"/>
					</p>
																														<p>
					<label>注销类型：</label>
					<input name="cancelType" readonly="readonly" type="text" size="30" value="${cancelType}"/>
					</p>
																														<p>
					<label>注销日期：</label>
					<input name="cancelDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>备注：</label>
					<input name="remark" readonly="readonly" type="text" size="30" value="${remark}"/>
					</p>
																														<p>
					<label>计生证明号：</label>
					<input name="certCode" readonly="readonly" type="text" size="30" value="${certCode}"/>
					</p>
																														<p>
					<label>计生证有效期：</label>
					<input name="certDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${certDate}" pattern="yyyy-MM-dd"/>"/>
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
