﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/person!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personmanage"/>
			<c:if test="${not empty id}"><input type="hidden" name="cancelType" value="672"/></c:if>
			<div class="pageFormContent" layoutH="56">
					<p>
					<label>姓名：</label>
					<input name="nameh"  class="required" maxlength="50"    type="text" size="30" value="${nameh}"  alt="请输入姓名" />
					</p>
					<p>
					<label>性别：</label>
					<tags:js.dict.selector name="sex" class1="required"  value="${sex}" dictCode="JS010"/>
					</p>
					<p>
					<label>证件类型：</label>
					<tags:js.dict.selector name="certType" class1="required"  value="${certType}" dictCode="JS1043"/>
					</p>
					<p>
					<label>证件号码：</label>
					<input name="code"   type="text" size="30" value="${code}" />
					</p>
					<p>
					<label>户口类别：</label>
					<tags:js.dict.selector name="domicileType" value="${domicileType}" dictCode="JS1048"/>					
					</p>
					<p>
					<label>人员类别：</label>
					<tags:js.dict.selector name="kind" value="${kind}" dictCode="JS1050"/>					
					</p>
					<p>
					<label>人员编号：</label>
					<input name="personCode"  class="required"   type="text" size="30" value="${personCode}" />
					</p>

<div class="divider"></div>
					<p>
					<label>国籍：</label>
					<tags:js.dict.selector name="personBasic.nationality" value="${personBasic.nationality}" dictCode="JS1045"/>
					</p>
					<p>
					<label>民族：</label>
					<tags:js.dict.selector name="personBasic.native" value="${personBasic.native}" dictCode="JS1044"/>
					</p>
					<p>
					<label>出生日期：</label>
					<input name="personBasic.birthday" class="date required" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${personBasic.birthday}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p>
					<label>年龄：</label>
					<input name="age" readonly="readonly" type="text" size="30" value="${age}"/>
					</p>
					<p>
					<label>婚姻状况：</label>
					<tags:js.dict.selector name="personBasic.marryStatus" value="${personBasic.marryStatus}" dictCode="JS1015"/>
					</p>
					<p>
					<label>初婚日期：</label>
					<input name="personBasic.firstMarryDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${personBasic.firstMarryDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p>
					<label>文化程度：</label>
					<tags:js.dict.selector name="personBasic.edu" value="${personBasic.edu}" dictCode="JS1041"/>
					</p>
					<p>
					<label>政治面貌：</label>
					<tags:js.dict.selector name="personBasic.politicalStatus" value="${personBasic.politicalStatus}" dictCode="JS1049"/>
					</p>
					<p>
					<label>户口性质：</label>
					<tags:js.dict.selector name="personBasic.househodeKind" value="${personBasic.househodeKind}" dictCode="JS1014"/>
					</p>
					<p>
					<label>职业：</label>
					<tags:js.dict.selector name="personBasic.job" value="${personBasic.job}" dictCode="JS1017"/>
					</p>
					<p>
					<label>是否独生：</label>
					<tags:js.yes.no.selector name="personBasic.isSingle" value="${personBasic.isSingle}"></tags:js.yes.no.selector>
					</p>
					<p>
					<label>工作单位：</label>
					<input name="personBasic.company"    type="text" size="30" value="${personBasic.company}" />
					</p>
					<p>
					<label>照片：</label>
					<input name="personBasic.photo"    type="text" size="30" value="${personBasic.photo}" />
					</p>
					<p>
					<label>指纹：</label>
					<input name="personBasic.fingerprint"    type="text" size="30" value="${personBasic.fingerprint}" />
					</p>
					<p>
					<label>联系电话：</label>
					<input name="personBasic.tel"    type="text" size="30" value="${personBasic.tel}" />
					</p>
<div class="divider"></div>
					<p>
					<label>现居住地：</label>
					<input name="personBasic.address"    type="text" size="30" value="${personBasic.address}" />
					</p>
					<p>
					<label>居住地类型：</label>
					<input name="personBasic.addressType" class="digits" type="text" size="30" value="${personBasic.addressType}"/>
					</p>
					<p>
					<label>现居住地编码：</label>
					<input name="personBasic.addressCode"    type="text" size="30" value="${personBasic.addressCode}" />
					</p>
					<p>
					<label>现居住地门牌号码：</label>
					<input name="personBasic.houseNo"    type="text" size="30" value="${personBasic.houseNo}" />
					</p>
					<p>
					<label>现居住地房号：</label>
					<input name="personBasic.roomNo"    type="text" size="30" value="${personBasic.roomNo}" />
					</p>
					<p>
					<label>现居住地邮编：</label>
					<input name="personBasic.zipCode"    type="text" size="30" value="${personBasic.zipCode}" />
					</p>
					<p>
					<label>村民小组：</label>
					<input name="personBasic.villagerTeamId" class="digits" type="text" size="30" value="${personBasic.villagerTeamId}"/>
					</p>
					<p>
					<label>户编码：</label>
					<input name="personBasic.houseHoldCode"    type="text" size="30" value="${personBasic.houseHoldCode}" />
					</p>
					<p>
					<label>户主姓名：</label>
					<input name="personBasic.ownerName"    type="text" size="30" value="${personBasic.ownerName}" />
					</p>
					<p>
					<label>与户主关系：</label>
					<tags:js.dict.selector name="personBasic.relation" value="${personBasic.relation}" dictCode="JS1040"/>
					</p>
					<p>
					<label>房屋编码：</label>
					<input name="personBasic.houseId" class="digits" type="text" size="30" value="${personBasic.houseId}"/>
					</p>
<div class="divider"></div>
					<p>
					<label>户籍地：</label>
					<input name="personBasic.domicile"    type="text" size="30" value="${personBasic.domicile}" />
					</p>
					<p>
					<label>户籍地编码：</label>
					<input name="personBasic.domicileCode"    type="text" size="30" value="${personBasic.domicileCode}" />
					</p>
					<p>
					<label>户籍地门牌号码：</label>
					<input name="personBasic.domicileHouseNo"    type="text" size="30" value="${personBasic.domicileHouseNo}" />
					</p>
					<p>
					<label>户籍地房号：</label>
					<input name="personBasic.domicileRoomNo"    type="text" size="30" value="${personBasic.domicileRoomNo}" />
					</p>
					<p>
					<label>户籍地邮编：</label>
					<input name="personBasic.domicileZipCode"    type="text" size="30" value="${personBasic.domicileZipCode}" />
					</p>

<div class="divider"></div>
					<p>
					<label>父亲姓名：</label>
					<input name="personBasic.father"    type="text" size="30" value="${personBasic.father}" />
					</p>

					<p>
					<label>父亲身份证：</label>
					<input name="personBasic.fatherCode"    type="text" size="30" value="${personBasic.fatherCode}" />
					</p>

					<p>
					<label>母亲姓名：</label>
					<input name="personBasic.mother"    type="text" size="30" value="${personBasic.mother}" />
					</p>

					<p>
					<label>母亲身份证：</label>
					<input name="personBasic.motherCode"    type="text" size="30" value="${personBasic.motherCode}" />
					</p>
					
<div class="divider"></div>
					<p>
					<label>何地迁入(流入)：</label>
					<input name="settleInPlace"    type="text" size="30" value="${settleInPlace}" />
					</p>
					<p>
					<label>迁入(流入)日期：</label>
					<input name="settleInDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${settleInDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p>
					<label>迁入(流入)原因：</label>
					<input name="settleInCause"    type="text" size="30" value="${settleInCause}" />
					</p>
					<p>
					<label>迁入(流入)类别：</label>
					<tags:js.dict.selector name="settleInType" value="${settleInType}" dictCode="JS1046"/>
					</p>
<div class="divider"></div>
					<p>
					<label>备注：</label>
					<input name="personBasic.remark"    type="text" size="30" value="${personBasic.remark}" />
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