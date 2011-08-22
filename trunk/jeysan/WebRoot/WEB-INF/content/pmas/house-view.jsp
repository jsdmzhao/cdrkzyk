<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>房屋编号：</label>
					<input name="houseCode" readonly="readonly" type="text" size="30" value="${houseCode}"/>
					</p>
<div class="divider"></div>
																														<p>
					<label>房屋类型：</label>
					<input name="houseType" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${houseType}" />"/>
					</p>
																														<p>
					<label>房屋属性：</label>
					<input name="houseAtt" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${houseAtt}" />"/>
					</p>
																														<p>
					<label>公安牌号：</label>
					<input name="housePoliceNo" readonly="readonly" type="text" size="30" value="${housePoliceNo}"/>
					</p>
																														<p>
					<label>间（套）数：</label>
					<input name="rooms" readonly="readonly" type="text" size="30" value="${rooms}"/>
					</p>
																														<p>
					<label>房屋面积：</label>
					<input name="area" readonly="readonly" type="text" size="30" value="${area}"/>
					</p>
																														<p>
					<label>居住人数：</label>
					<input name="personCount" readonly="readonly" type="text" size="30" value="${personCount}"/>
					</p>
																														<p>
					<label>房产证类型：</label>
					<input name="pocType" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${pocType}" />"/>
					</p>
																														<p style="width:89%">
					<label>详细地址：</label>
					<input name="detailAddress" readonly="readonly" type="text" size="100" value="${detailAddress}"/>
					</p>
<div class="divider"></div>

																														<p>
					<label>业主姓名：</label>
					<input name="ownerName" readonly="readonly" type="text" size="30" value="${ownerName}"/>
					</p>
																														<p>
					<label>业主身份证：</label>
					<input name="ownerCert" readonly="readonly" type="text" size="30" value="${ownerCert}"/>
					</p>
																														<p>
					<label>业主性别：</label>
					<input name="ownerSex" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${ownerSex}" />"/>
					</p>
																														<p>
					<label>业主电话：</label>
					<input name="ownerTel" readonly="readonly" type="text" size="30" value="${ownerTel}"/>
					</p>
																														<p style="width:89%">
					<label>业主居住地址：</label>
					<input name="ownerAddress" readonly="readonly" type="text" size="100" value="${ownerAddress}"/>
					</p>
																														<p>
					<label>业主工作单位：</label>
					<input name="ownerCompany" readonly="readonly" type="text" size="30" value="${ownerCompany}"/>
					</p>

<div class="divider"></div>
																														<p>
					<label>代管人姓名：</label>
					<input name="agentName" readonly="readonly" type="text" size="30" value="${agentName}"/>
					</p>
																														<p>
					<label>代管人身份证：</label>
					<input name="agentCert" readonly="readonly" type="text" size="30" value="${agentCert}"/>
					</p>
																														<p>
					<label>代管人性别：</label>
					<input name="agentSex" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${agentSex}" />"/>
					</p>
																														<p>
					<label>代管人电话：</label>
					<input name="agentTel" readonly="readonly" type="text" size="30" value="${agentTel}"/>
					</p>
																														<p>
					<label>代管人居住地址：</label>
					<input name="agentAddress" readonly="readonly" type="text" size="30" value="${agentAddress}"/>
					</p>
																														<p>
					<label>代管人工作单位：</label>
					<input name="agentCompany" readonly="readonly" type="text" size="30" value="${agentCompany}"/>
					</p>

<div class="divider"></div>
																														<p>
					<label>租赁许可证签证时间：</label>
					<input name="rentPermitDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${rentPermitDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>治安责任书签订时间：</label>
					<input name="orderDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${orderDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>计生责任书签订时间：</label>
					<input name="bcsDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${bcsDate}" pattern="yyyy-MM-dd"/>"/>
					</p>

<div class="divider"></div>
																														<p>
					<label>对应地图ID：</label>
					<input name="gisId" readonly="readonly" type="text" size="30" value="${gisId}"/>
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
