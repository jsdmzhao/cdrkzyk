<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/spouse!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="sex" value="${person.sex==2?1:2}" />
			<input type="hidden" name="personId" value="${person.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> 
			<input type="hidden" name="result4Json.navTabId"
				value="spouse-update" />-->
			<div class="pageFormContent" layoutH="56">

				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						${person.sex==1?'男':'女'}方信息：
					</h2>
				</div>
				<p>
					<label>
						姓名：
					</label>
					<input type="text" size="30" value="${person.nameh}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						出生日期：
					</label>
					<input readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${person.personBasic.birthday}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						年龄：
					</label>
					<input type="text" size="30" value="${person.age}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						证件号码：
					</label>
					<input type="text" size="30" value="${person.code}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						证件类型：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${person.certType}"/>" />
				</p>
				<p>
					<label>
						户口类别：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${person.domicileType}"/>" />
				</p>
				<p>
					<label>
						人员类别：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${person.kind}"/>" />
				</p>
				<p>
					<label>
						人员编号：
					</label>
					<input type="text" size="30"
						value="${person.personCode}" readonly="readonly" />
				</p>
				<p>
					<label>
						国籍：
					</label>
					<input type="text" size="30"
						value="<tags:js.dict.getValue value="${person.personBasic.nationality}"/>" />
				</p>
				<p>
					<label>
						民族：
					</label>
					<input type="text" size="30"
						value="<tags:js.dict.getValue value="${person.personBasic.native}"/>" />
				</p>
				<p>
					<label>
						婚姻状况：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${person.personBasic.marryStatus}"/>" />
				</p>
				<p>
					<label>
						初婚日期：
					</label>
					<input readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${person.personBasic.firstMarryDate}" pattern="yyyy-MM-dd"/>" />
				</p>



				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						${person.sex==2?'男':'女'}方信息：
					</h2>
				</div>

				<p>
					<label>
						姓名：
					</label>
					<input name="nameh" class="required" maxlength="50" type="text"
						size="30" value="${nameh}" alt="请输入姓名" />
				</p>


				<p>
					<label>
						身份证号码：
					</label>
					<input name="code" class="required" type="text" size="30" value="${code}" />
				</p>


				<p>
					<label>
						出生日期：
					</label>
					<input name="birthday" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly"
						type="text" size="30" onpropertychange="setage(this.value)"
						value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>" />
					
				</p>

				<p>
					<label>
						年龄：
					</label>
					<input id="age" name="age" readonly="readonly" class="required" type="text" size="30"
						value="${age}" />
				</p>

<div class="divider"></div>

				<p style="width: 98%">
					<label>
						户籍地：
					</label>
					<tags:js.district.selector onChange="setAddress2" />
				</p>
				<p style="width: 98%">
					<label>
						户籍地：
					</label>
					<input id="domicile" name="domicile" type="text" size="100"
						value="${domicile}" />
				</p>
				<p>
					<label>
						户籍地编码：
					</label>
					<input id="domicileCode" name="domicileCode" readonly="readonly"
						type="text" size="30" value="${domicileCode}" />
				</p>
				<p>
					<label>
						户籍地邮编：
					</label>
					<input name="zipCode" type="text" size="30" value="${zipCode}" />
				</p>

<div class="divider"></div>

				
				<p style="width: 98%">
					<label>
						现居住地：
					</label>
					<tags:js.district.selector onChange="setAddress" />
				</p>
				<p style="width: 98%">
					<label>
						现居住地：
					</label>
					<input id="address" name="address" type="text" size="100"
						value="${address}" />
				</p>
				<p>
					<label>
						现居住地编码：
					</label>
					<input id="addressCode" name="addressCode" readonly="readonly"
						type="text" size="30" value="${addressCode}" />
				</p>

				<p>
					<label>
						居住地类型：
					</label>
					<input name="addressType" class="digits" type="text" size="30"
						value="${addressType}" />
				</p>
				<p>
					<label>
						门牌号码：
					</label>
					<input name="houseNumber" type="text" size="30"
						value="${houseNumber}" />
				</p>
				<p>
					<label>
						户口类别：
					</label>
					<tags:js.dict.selector name="domicileType" value="${domicileType}"
						dictCode="JS1048" />
				</p>
<div class="divider"></div>
				<p>
					<label>
						民族：
					</label>
					<tags:js.dict.selector name="native" value="${native}"
						dictCode="JS1044" />
				</p>
				<p>
					<label>
						文化程度：
					</label>
					<tags:js.dict.selector name="edu"
						value="${edu}" dictCode="JS1041" />
				</p>
				<p>
					<label>
						政治面貌：
					</label>
					<tags:js.dict.selector name="politicalStatus"
						value="${politicalStatus}" dictCode="JS1049" />
				</p>
				<p>
					<label>
						户口性质：
					</label>
					<tags:js.dict.selector name="househodeKind"
						value="${househodeKind}" dictCode="JS1014" />
				</p>
				<p>
					<label>
						职业：
					</label>
					<tags:js.dict.selector name="job"
						value="${job}" dictCode="JS1017" />
				</p>
				<p>
					<label>
						是否独生：
					</label>
					<tags:js.yes.no.selector name="isSingle"
						value="${isSingle}"></tags:js.yes.no.selector>
				</p>
				<p>
					<label>
						工作单位：
					</label>
					<input name="company" type="text" size="30"
						value="${company}" />
				</p>
				<p>
					<label>
						照片：
					</label>
					<input name="photo" type="text" size="30"
						value="${photo}" />
				</p>
				<p>
					<label>
						指纹：
					</label>
					<input name="fingerprint" type="text" size="30"
						value="${fingerprint}" />
				</p>
				<p>
					<label>
						联系电话：
					</label>
					<input name="tel" type="text" size="30"
						value="${tel}" />
				</p>

<div class="divider"></div>
				<!-- 
				<p>
					<label>
						持证情况：
					</label>
					<input name="haveStatus" class="digits" type="text" size="30"
						value="${haveStatus}" />
				</p>
				<p>
					<label>
						验证情况：
					</label>
					<input name="validateStatus" class="digits" type="text" size="30"
						value="${validateStatus}" />
				</p> -->
				<p>
					<label>
						备注：
					</label>
					<input name="remark" type="text" size="30" value="${remark}" />
				</p>
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
<script>
function setAddress(obj,address_,type){
	$('#addressCode').val(obj.value.split('_')[1]);
	$('#address').val(address_);
	if(type == 5){
		var orgCode = obj.value;
		if(orgCode == null || orgCode == '')
			return;
		$.post("${ctx}/pmas/villagerteam!findByCode.action", {orgCode:orgCode.split('_')[1]}, function(data) {
			var html = "<option value=\"\">所有村民小组</option>";
			for (var i = 0; i < data.length; i++) {
				html += "<option value=\"" + data[i].id+ "\">" + data[i].teamName + "</option>";
			}
			$("#villagerTeamId").html(html);
		});
	}else{
		$("#villagerTeamId").html("<option value=\"\">所有村民小组</option>");
	}
}
function setAddress2(obj,address_){
	$('#domicileCode').val(obj.value.split('_')[1]);
	$('#domicile').val(address_);
}
var yearNow = new Date().getYear();
function setage(birth){
	if(birth==null||birth==''){
		$('#age').val('');
	}else{
		var year_ = birth.substr(0,birth.indexOf('-'));
		$('#age').val(yearNow-year_);
	}
}
</script>