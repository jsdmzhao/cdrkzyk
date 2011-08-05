<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/personbasic!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personbasicmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>PERSON_ID：</label>
					<input name="personId" class="digits  required" type="text" size="30" value="${personId}"/>
					</p>
					<p>
					<label>性别：</label>
					<input name="sex" class="digits  required" type="text" size="30" value="${sex}"/>
					</p>
					<p>
					<label>年龄：</label>
					<input name="age" class="digits  required" type="text" size="30" value="${age}"/>
					</p>
					<p>
					<label>户籍地：</label>
					<input name="domicile"    type="text" size="30" value="${domicile}" />
					</p>
					<p>
					<label>户籍地编码：</label>
					<input name="domicileCode"    type="text" size="30" value="${domicileCode}" />
					</p>
					<p>
					<label>户籍地门牌号码：</label>
					<input name="domicileHouseNo"    type="text" size="30" value="${domicileHouseNo}" />
					</p>
					<p>
					<label>户籍地房号：</label>
					<input name="domicileRoomNo"    type="text" size="30" value="${domicileRoomNo}" />
					</p>
					<p>
					<label>户籍地邮编：</label>
					<input name="domicileZipCode"    type="text" size="30" value="${domicileZipCode}" />
					</p>
					<p>
					<label>现居住地：</label>
					<input name="address"    type="text" size="30" value="${address}" />
					</p>
					<p>
					<label>居住地类型：</label>
					<input name="addressType" class="digits" type="text" size="30" value="${addressType}"/>
					</p>
					<p>
					<label>现居住地编码：</label>
					<input name="addressCode"    type="text" size="30" value="${addressCode}" />
					</p>
					<p>
					<label>现居住地门牌号码：</label>
					<input name="houseNo"    type="text" size="30" value="${houseNo}" />
					</p>
					<p>
					<label>现居住地房号：</label>
					<input name="roomNo"    type="text" size="30" value="${roomNo}" />
					</p>
					<p>
					<label>现居住地邮编：</label>
					<input name="zipCode"    type="text" size="30" value="${zipCode}" />
					</p>
					<p>
					<label>民族：</label>
					<input name="native" class="digits" type="text" size="30" value="${native}"/>
					</p>
					<p>
					<label>houseId：</label>
					<input name="houseId" class="digits" type="text" size="30" value="${houseId}"/>
					</p>
					<p>
					<label>出生日期：</label>
					<input name="birthday" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p>
					<label>文化程度：</label>
					<input name="edu" class="digits" type="text" size="30" value="${edu}"/>
					</p>
					<p>
					<label>政治面貌：</label>
					<input name="politicalStatus" class="digits" type="text" size="30" value="${politicalStatus}"/>
					</p>
					<p>
					<label>户口性质：</label>
					<input name="househodeKind" class="digits" type="text" size="30" value="${househodeKind}"/>
					</p>
					<p>
					<label>职业：</label>
					<input name="job" class="digits" type="text" size="30" value="${job}"/>
					</p>
					<p>
					<label>是否独生：</label>
					<input name="isSingle" class="digits" type="text" size="30" value="${isSingle}"/>
					</p>
					<p>
					<label>工作单位：</label>
					<input name="company"    type="text" size="30" value="${company}" />
					</p>
					<p>
					<label>照片：</label>
					<input name="photo"    type="text" size="30" value="${photo}" />
					</p>
					<p>
					<label>指纹：</label>
					<input name="fingerprint"    type="text" size="30" value="${fingerprint}" />
					</p>
					<p>
					<label>联系电话：</label>
					<input name="tel"    type="text" size="30" value="${tel}" />
					</p>
					<p>
					<label>持证情况：</label>
					<input name="haveStatus" class="digits" type="text" size="30" value="${haveStatus}"/>
					</p>
					<p>
					<label>验证情况：</label>
					<input name="validateStatus" class="digits" type="text" size="30" value="${validateStatus}"/>
					</p>
					<p>
					<label>spouseId：</label>
					<input name="spouseId" class="digits" type="text" size="30" value="${spouseId}"/>
					</p>
					<p>
					<label>dbType：</label>
					<input name="dbType"    type="text" size="30" value="${dbType}" />
					</p>
					<p>
					<label>备注：</label>
					<input name="remark"    type="text" size="30" value="${remark}" />
					</p>
					<p>
					<label>户主姓名：</label>
					<input name="ownerName"    type="text" size="30" value="${ownerName}" />
					</p>
					<p>
					<label>与户主关系：</label>
					<input name="relation" class="digits" type="text" size="30" value="${relation}"/>
					</p>
					<p>
					<label>婚姻状况：</label>
					<input name="marryStatus" class="digits" type="text" size="30" value="${marryStatus}"/>
					</p>
					<p>
					<label>初婚日期：</label>
					<input name="firstMarryDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${firstMarryDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p>
					<label>国籍：</label>
					<input name="nationality" class="digits" type="text" size="30" value="${nationality}"/>
					</p>
					<p>
					<label>村民小组：</label>
					<input name="villagerTeamId" class="digits" type="text" size="30" value="${villagerTeamId}"/>
					</p>
					<p>
					<label>户编码：</label>
					<input name="houseHoldCode"    type="text" size="30" value="${houseHoldCode}" />
					</p>

<p>
					<label>父亲姓名：</label>
					<input name="father"    type="text" size="30" value="${father}" />
					</p>

<p>
					<label>父亲身份证：</label>
					<input name="fatherCode"    type="text" size="30" value="${fatherCode}" />
					</p>

<p>
					<label>母亲姓名：</label>
					<input name="mother"    type="text" size="30" value="${mother}" />
					</p>

<p>
					<label>母亲身份证：</label>
					<input name="motherCode"    type="text" size="30" value="${motherCode}" />
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