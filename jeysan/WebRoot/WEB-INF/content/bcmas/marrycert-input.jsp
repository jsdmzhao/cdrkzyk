<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/marrycert!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_marrycertmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>PERSON_ID：</label>
					<input name="personId" class="digits" type="text" size="30" value="${personId}"/>
					</p>
																													<p>
					<label>发证机关：</label>
					<input name="issOrg"    type="text" size="30" value="${issOrg}" />
					</p>
																													<p>
					<label>发证日期：</label>
					<input name="issDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>发证机关地址：</label>
					<input name="issOrgAddress"    type="text" size="30" value="${issOrgAddress}" />
					</p>
																													<p>
					<label>证书编号：</label>
					<input name="certCode"    type="text" size="30" value="${certCode}" />
					</p>
																													<p>
					<label>邮政编码：</label>
					<input name="zipCode"    type="text" size="30" value="${zipCode}" />
					</p>
																													<p>
					<label>电话：</label>
					<input name="tel"    type="text" size="30" value="${tel}" />
					</p>
																													<p>
					<label>有效期：</label>
					<input name="validPeriod" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${validPeriod}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>经办人：</label>
					<input name="agent"    type="text" size="30" value="${agent}" />
					</p>
																													<p>
					<label>结婚时间：</label>
					<input name="marryDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${marryDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>所在乡（镇、街道）计生办电话：</label>
					<input name="fpoTel1"    type="text" size="30" value="${fpoTel1}" />
					</p>
																													<p>
					<label>配偶所在乡（镇、街道）计生办电话：</label>
					<input name="fpoTel2"    type="text" size="30" value="${fpoTel2}" />
					</p>
																													<p>
					<label>发证时已有子女数（男）：</label>
					<input name="beforeBoyCount" class="digits" type="text" size="30" value="${beforeBoyCount}"/>
					</p>
																													<p>
					<label>发证时已有子女数（女）：</label>
					<input name="beforeGirlCount" class="digits" type="text" size="30" value="${beforeGirlCount}"/>
					</p>
																													<p>
					<label>发证后生育子女数（男）：</label>
					<input name="afterBoyCount" class="digits" type="text" size="30" value="${afterBoyCount}"/>
					</p>
																													<p>
					<label>发证后生育子女数（女）：</label>
					<input name="afterGirlCount" class="digits" type="text" size="30" value="${afterGirlCount}"/>
					</p>
																													<p>
					<label>照片：</label>
					<input name="photo"    type="text" size="30" value="${photo}" />
					</p>
																	</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>