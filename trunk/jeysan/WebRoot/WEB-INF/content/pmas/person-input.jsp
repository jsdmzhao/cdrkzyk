<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script>
function ok(){
	navTabAjaxDone4Update(
			{navTabId:'nav_personmanage',message:'操作成功',action:'${id==null?1:2}',statusCode:'200'}
	);
}
</script>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/person!save.action" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,ok);">
			<input type="hidden" name="id" value="${id}"/>
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personmanage"/>
			<input type="hidden" name="master.dwz_houseLookup.houseId" value="${house.id}"/>
			<input id="personBasic_address" name="personBasic.address" type="hidden" value="${personBasic.address}" />
			<input id="personBasic_domicile" name="personBasic.domicile" type="hidden" value="${personBasic.domicile}" />
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
					<input name="personBasic.birthday" id="personBasic_birthday" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:setage})" class="Wdate required" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${personBasic.birthday}" pattern="yyyy-MM-dd"/>"/>
					</p>
					<p>
					<label>年龄：</label>
					<input id="age" name="age" class="required" readonly="readonly" type="text" size="30" value="${age}"/>
					</p>
					<p>
					<label>婚姻状况：</label>
					<tags:js.dict.selector name="personBasic.marryStatus" value="${personBasic.marryStatus}" dictCode="JS1015" class1="required"/>
					</p>
					<p>
					<label>初婚日期：</label>
					<input name="personBasic.firstMarryDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${personBasic.firstMarryDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
				<p>
					<label>
						婚变日期：
					</label>
					<input name="personBasic.marryCryDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${personBasic.marryCryDate}" pattern="yyyy-MM-dd"/>" />
					
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
					<p style="width:98%;">
					<label>照片：</label>
					<input name="personBasic_photo"    type="file" size="30" />
					</p>
					<p style="width:98%;height:120px">
					<label>照片预览：</label>
					<img width="200" height="120" src="${ctx}/${personBasic.photo}"/>
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
					<label>居住地类型：</label>
					<input name="personBasic.addressType" class="digits" type="text" size="30" value="${personBasic.addressType}"/>
					</p>
					<p style="width:98%">
					<label>现居住地：</label>
					<tags:js.area.selector readonly="true" size="100" id="personBasic_addressCode" name="personBasic.addressCode" valueLabel="${personBasic.address}" onChange="setAddress"></tags:js.area.selector>
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
					<select name="personBasic.villagerTeamId" id="personBasic_villagerTeamId">
						<c:if test="${empty villagerteam}">
						<option value="">所有村民小组</option>
						</c:if>
						<c:if test="${not empty villagerteam}">
						<option value="${villagerteam.id}">${villagerteam.teamName}</option>
						</c:if>
					</select>
					</p>
					<p>
					<label>户编码：</label>
					<input name="personBasic.houseHoldCode"    type="text" size="30" value="${personBasic.houseHoldCode}" />
					</p>
					<p>
					<label>房屋编码：</label>
					<input readonly="readonly" name="master.dwz_houseLookup.houseCode" class="required" type="text" size="30" value="${house.houseCode}"/>
					<a class="btnLook" href="${ctx}/pmas/house!list4lookup.action" lookupGroup="master" lookupName="houseLookup">查找房屋</a>
					</p>
					<p>
					<label>户主姓名：</label>
					<input name="personBasic.ownerName"    type="text" size="30" value="${personBasic.ownerName}" />
					</p>
					<p>
					<label>与户主关系：</label>
					<tags:js.dict.selector name="personBasic.relation" value="${personBasic.relation}" dictCode="JS1040"/>
					</p>
<div class="divider"></div>
					<p style="width:98%">
					<label>户籍地：</label>
					<tags:js.district2.selector name="personBasic.domicileCode" id="personBasic_domicileCode" readonly="true" size="100" valueLabel="${personBasic.domicile}" onChange="setAddress2" type="5"></tags:js.district2.selector>
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
					<input name="settleInDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${settleInDate}" pattern="yyyy-MM-dd"/>"/>
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
<script>
function setAddress(orgCode,address_){
	var $box = navTab.getCurrentPanel();
	$('#personBasic_address',$box).val(address_);
	if(orgCode == null || orgCode == ''){
		$("#personBasic_villagerTeamId",$box).html("<option value=\"\">请选择</option>");
		return;
	}
	$.post("${ctx}/pmas/villagerteam!findByCode.action", {orgCode:orgCode.split('_')[1]}, function(data) {
		var html = "<option value=\"\">所有村民小组</option>";
		for (var i = 0; i < data.length; i++) {
			html += "<option value=\"" + data[i].id+ "\">" + data[i].teamName + "</option>";
		}
		$("#personBasic_villagerTeamId",$box).html(html);
	});
}
function setAddress2(orgCode,address_){
	$('#personBasic_domicile',navTab.getCurrentPanel()).val(address_);
}
var yearNow = new Date().getYear();
function setage(){
	var $box = navTab.getCurrentPanel();
	var birth = $('#personBasic_birthday',$box).val();
	if(birth==null||birth==''){
		$('#age',$box).val('');
	}else{
		var year_ = birth.substr(0,birth.indexOf('-'));
		$('#age',$box).val(yearNow-year_);
	}
}
</script>