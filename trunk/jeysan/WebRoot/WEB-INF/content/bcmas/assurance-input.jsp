<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/assurance!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="fertileWomanId" value="${ass.id}" />
			<input type="hidden" name="type" value="${param.type}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_assurancemanage" />
			<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					姓名：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${ass.nameh}" />
			</p>
			<p>
				<label>
					妇女编码：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${ass.code}" />
			</p>
			<p>
				<label>
					出生日期：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${ass.birthday}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					丈夫姓名：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${ass.spNameh}" />
			</p>
			<p>
				<label>
					户口性质：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${ass.househodeKind}"/>" />
			</p>
			<p>
				<label>
					婚姻状况：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${ass.marryStatus}"/>" />
			</p>
			<p>
				<label>
					子女数：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${ass.boyCount+ass.girlCount}" />
			</p>
			<p>
				<label>
					避孕节育措施：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${ass.method}"/>" />
			</p>
<c:if test="${param.type==0}">
<div class="divider"></div>		
				<p>
					<label>
						保险类型：
					</label>
					<tags:js.dict.selector dictCode="JS1019" name="assType" value="${assType}" class1="required"/>
				</p>
				<p>
					<label>
						投保类型：
					</label>
					<tags:js.dict.selector dictCode="JS1067" name="assKind" value="${assKind}"/>
				</p>
				<p>
					<label>
						投保日期：
					</label>
					<input name="assDate" class="date required" readonly="readonly" type="text"
						size="30" 
						value="<fmt:formatDate value="${assDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						被保险人：
					</label>
					<input name="insured" type="text" size="30" value="${insured}"  class="required"/>
				</p>
				<p>
					<label>
						投保人：
					</label>
					<input name="applicant" type="text" size="30" value="${applicant}"  class="required"/>
				</p>
				<p>
					<label>
						保险收益人：
					</label>
					<input name="insurant" type="text" size="30" value="${insurant}"  class="required"/>
				</p>
				<p>
					<label>
						投保金额：
					</label>
					<input name="insuredAmount" class="digits" type="text" size="30"  class="required"
						value="${insuredAmount}" />
				</p>
				<p>
					<label>
						收款人：
					</label>
					<input name="cashier" type="text" size="30" value="${cashier}" />
				</p>
</c:if>
<c:if test="${param.type==1}">
<div class="divider"></div>		
				<p>
					<label>
						保险类型：
					</label>
					<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${assType}"/>" />
				</p>
				<p>
					<label>
						投保类型：
					</label>
					<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${assKind}"/>" />
				</p>
				<p>
					<label>
						投保日期：
					</label>
					<input readonly="readonly" type="text"
						size="30" 
						value="<fmt:formatDate value="${assDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						被保险人：
					</label>
					<input type="text" size="30" value="${insured}" readonly="readonly"/>
				</p>
				<p>
					<label>
						投保人：
					</label>
					<input type="text" size="30" value="${applicant}" readonly="readonly""/>
				</p>
				<p>
					<label>
						保险收益人：
					</label>
					<input readonly="readonly" type="text" size="30" value="${insurant}" />
				</p>
				<p>
					<label>
						投保金额：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${insuredAmount}" />
				</p>
				<p>
					<label>
						收款人：
					</label>
					<input readonly="readonly" type="text" size="30" value="${cashier}" />
				</p>
<div class="divider"></div>	
				<p>
					<label>
						取消保险日期：
					</label>
					<input name="cancelDate" class="date required" readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						取消保险原因：
					</label>
					<input name="cancelCause" class="required" type="text" size="30"
						value="${cancelCause}" />
				</p>
				<p>
					<label>
						退还金额：
					</label>
					<input name="returnAmount" class="number required" type="text" size="30"
						value="${returnAmount}" />
				</p>
				<p>
					<label>
						退款人：
					</label>
					<input name="returner" type="text" size="30" value="${returner}" />
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