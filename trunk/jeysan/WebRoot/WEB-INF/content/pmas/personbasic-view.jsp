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
					<label>性别：</label>
					<input name="sex" readonly="readonly" type="text" size="30" value="${sex}"/>
					</p>
																														<p>
					<label>年龄：</label>
					<input name="age" readonly="readonly" type="text" size="30" value="${age}"/>
					</p>
																														<p>
					<label>户籍地：</label>
					<input name="domicile" readonly="readonly" type="text" size="30" value="${domicile}"/>
					</p>
																														<p>
					<label>户籍地编码：</label>
					<input name="domicileCode" readonly="readonly" type="text" size="30" value="${domicileCode}"/>
					</p>
																														<p>
					<label>户籍地邮编：</label>
					<input name="zipCode" readonly="readonly" type="text" size="30" value="${zipCode}"/>
					</p>
																														<p>
					<label>现居住地：</label>
					<input name="address" readonly="readonly" type="text" size="30" value="${address}"/>
					</p>
																														<p>
					<label>居住地类型：</label>
					<input name="addressType" readonly="readonly" type="text" size="30" value="${addressType}"/>
					</p>
																														<p>
					<label>现居住地编码：</label>
					<input name="addressCode" readonly="readonly" type="text" size="30" value="${addressCode}"/>
					</p>
																														<p>
					<label>门牌号码：</label>
					<input name="houseNumber" readonly="readonly" type="text" size="30" value="${houseNumber}"/>
					</p>
																														<p>
					<label>民族：</label>
					<input name="native" readonly="readonly" type="text" size="30" value="${native}"/>
					</p>
																														<p>
					<label>houseId：</label>
					<input name="houseId" readonly="readonly" type="text" size="30" value="${houseId}"/>
					</p>
																														<p>
					<label>出生日期：</label>
					<input name="birthday" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>文化程度：</label>
					<input name="edu" readonly="readonly" type="text" size="30" value="${edu}"/>
					</p>
																														<p>
					<label>政治面貌：</label>
					<input name="politicalStatus" readonly="readonly" type="text" size="30" value="${politicalStatus}"/>
					</p>
																														<p>
					<label>户口性质：</label>
					<input name="househodeKind" readonly="readonly" type="text" size="30" value="${househodeKind}"/>
					</p>
																														<p>
					<label>职业：</label>
					<input name="job" readonly="readonly" type="text" size="30" value="${job}"/>
					</p>
																														<p>
					<label>是否独生：</label>
					<input name="isSingle" readonly="readonly" type="text" size="30" value="${isSingle}"/>
					</p>
																														<p>
					<label>工作单位：</label>
					<input name="company" readonly="readonly" type="text" size="30" value="${company}"/>
					</p>
																														<p>
					<label>照片：</label>
					<input name="photo" readonly="readonly" type="text" size="30" value="${photo}"/>
					</p>
																														<p>
					<label>指纹：</label>
					<input name="fingerprint" readonly="readonly" type="text" size="30" value="${fingerprint}"/>
					</p>
																														<p>
					<label>联系电话：</label>
					<input name="tel" readonly="readonly" type="text" size="30" value="${tel}"/>
					</p>
																														<p>
					<label>持证情况：</label>
					<input name="haveStatus" readonly="readonly" type="text" size="30" value="${haveStatus}"/>
					</p>
																														<p>
					<label>验证情况：</label>
					<input name="validateStatus" readonly="readonly" type="text" size="30" value="${validateStatus}"/>
					</p>
																														<p>
					<label>spouseId：</label>
					<input name="spouseId" readonly="readonly" type="text" size="30" value="${spouseId}"/>
					</p>
																														<p>
					<label>dbType：</label>
					<input name="dbType" readonly="readonly" type="text" size="30" value="${dbType}"/>
					</p>
																														<p>
					<label>注销类别：</label>
					<input name="cancelType" readonly="readonly" type="text" size="30" value="${cancelType}"/>
					</p>
																														<p>
					<label>注销日期：</label>
					<input name="cancelDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>死亡（迁出）时间：</label>
					<input name="dateh" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>备注：</label>
					<input name="remark" readonly="readonly" type="text" size="30" value="${remark}"/>
					</p>
																														<p>
					<label>何地迁入(流入)：</label>
					<input name="settleInPlace" readonly="readonly" type="text" size="30" value="${settleInPlace}"/>
					</p>
																														<p>
					<label>迁入(流入)日期：</label>
					<input name="settleInDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${settleInDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>迁入(流入)原因：</label>
					<input name="settleInCause" readonly="readonly" type="text" size="30" value="${settleInCause}"/>
					</p>
																														<p>
					<label>迁入(流入)类别：</label>
					<input name="settleInType" readonly="readonly" type="text" size="30" value="${settleInType}"/>
					</p>
																														<p>
					<label>户主姓名：</label>
					<input name="ownerName" readonly="readonly" type="text" size="30" value="${ownerName}"/>
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
