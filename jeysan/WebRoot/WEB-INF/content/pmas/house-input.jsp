<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/house!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_housemanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>房屋编号：</label>
					<input name="houseCode" class="required number" minlength="8" maxlength="8" type="text" size="30" value="${houseCode}" />
					</p>
<div class="divider"></div>

																													<p>
					<label>房屋类型：</label>
					<tags:js.dict.selector name="houseType" class1="required"  value="${houseType}" dictCode="JS1038"/>
					</p>
																													<p>
					<label>房屋属性：</label>
					<tags:js.dict.selector name="houseAtt" class1="required" value="${houseAtt}" dictCode="JS1039"/>
					</p>
																													<p>
					<label>公安牌号：</label>
					<input name="housePoliceNo"    type="text" size="30" value="${housePoliceNo}" />
					</p>
																													<p>
					<label>间（套）数：</label>
					<input name="rooms" class="digits" type="text" size="30" value="${rooms}"/>
					</p>
																													<p>
					<label>房屋面积：</label>
					<input name="area" class="number" type="text" size="30" value="${area}"/>
					</p>
																													<p>
					<label>居住人数：</label>
					<input name="personCount" class="digits" type="text" size="30" value="${personCount}"/>
					</p>
																													<p>
					<label>房产证类型：</label>
					<tags:js.dict.selector name="pocType"  value="${pocType}" dictCode="JS1052"/>
					</p>
																													<p style="width:89%">
					<label>详细地址：</label>
					<input name="detailAddress"    type="text" size="100" value="${detailAddress}" />
					</p>

<div class="divider"></div>
																													<p>
					<label>业主姓名：</label>
					<input name="ownerName"  class="required"  type="text" size="30" value="${ownerName}" />
					</p>
																													<p>
					<label>业主身份证：</label>
					<input name="ownerCert" class="required"    type="text" size="30" value="${ownerCert}" />
					</p>
																													<p>
					<label>业主性别：</label>
					<tags:js.dict.selector name="ownerSex" class1="required"  value="${ownerSex}" dictCode="JS010"/>
					</p>
																													<p>
					<label>业主电话：</label>
					<input name="ownerTel"    type="text" size="30" value="${ownerTel}" />
					</p>
																													<p style="width:89%">
					<label>业主居住地址：</label>
					<input name="ownerAddress"    type="text" size="100" value="${ownerAddress}" />
					</p>
																													<p>
					<label>业主工作单位：</label>
					<input name="ownerCompany"    type="text" size="30" value="${ownerCompany}" />
					</p>

<div class="divider"></div>
																													<p>
					<label>代管人姓名：</label>
					<input name="agentName"    type="text" size="30" value="${agentName}" />
					</p>
																													<p>
					<label>代管人身份证：</label>
					<input name="agentCert"    type="text" size="30" value="${agentCert}" />
					</p>
																													<p>
					<label>代管人性别：</label>
					<tags:js.dict.selector name="agentSex"  value="${agentSex}" dictCode="JS010"/>
					</p>
																													<p>
					<label>代管人电话：</label>
					<input name="agentTel"    type="text" size="30" value="${agentTel}" />
					</p>
																													<p>
					<label>代管人居住地址：</label>
					<input name="agentAddress"    type="text" size="30" value="${agentAddress}" />
					</p>
																													<p>
					<label>代管人工作单位：</label>
					<input name="agentCompany"    type="text" size="30" value="${agentCompany}" />
					</p>

<div class="divider"></div>
																													<p>
					<label>租赁许可证签证时间：</label>
					<input name="rentPermitDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${rentPermitDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																													<p>
					<label>治安责任书签订时间：</label>
					<input name="orderDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${orderDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																													<p>
					<label>计生责任书签订时间：</label>
					<input name="bcsDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${bcsDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
<!-- 
<div class="divider"></div>
																													<p>
					<label>对应地图ID：</label>
					<input name="gisId"    type="text" size="30" value="${gisId}" />
					</p>
																	 --></div>
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