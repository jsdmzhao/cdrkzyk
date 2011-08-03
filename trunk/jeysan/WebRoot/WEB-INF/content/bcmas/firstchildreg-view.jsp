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
					<label>登记日期：</label>
					<input name="dateh" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>是否再生一孩：</label>
					<input name="isSecond" readonly="readonly" type="text" size="30" value="${isSecond}"/>
					</p>
																														<p>
					<label>再生一孩条件：</label>
					<input name="cond" readonly="readonly" type="text" size="30" value="${cond}"/>
					</p>
																														<p>
					<label>部门意见：</label>
					<input name="deptOpt" readonly="readonly" type="text" size="30" value="${deptOpt}"/>
					</p>
																														<p>
					<label>经办人：</label>
					<input name="agent" readonly="readonly" type="text" size="30" value="${agent}"/>
					</p>
																														<p>
					<label>合同签署日期：</label>
					<input name="assignDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${assignDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>生育合同编号：</label>
					<input name="code" readonly="readonly" type="text" size="30" value="${code}"/>
					</p>
																														<p>
					<label>一孩预产期：</label>
					<input name="edd" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${edd}" pattern="yyyy-MM-dd"/>"/>
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
