<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/toccert!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="type" value="${param.type}" />
			<input type="hidden" id="childrenId" name="childrenId" value="${children.id}" />
			<input type="hidden" id="personId_" value="${person.id}" />
			<input type="hidden" id="personId" name="master.dwz_personLookup.personId"
				value="${person.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_toccertmanage" />
			<div class="pageFormContent" layoutH="56">
				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						父母信息
					</h2>
				</div>
				<p>
					<label>
						姓名：
					</label>
					<input class="required" name="master.dwz_personLookup.nameh"
						readonly="readonly" type="text" size="30" value="${person.nameh}"
						onpropertychange="setSpouseAndChildren()" />
					<a class="btnLook" href="${ctx}/pmas/person!list4lookup.action"
						onclick="javascript:a=1;"
						lookupGroup="master" lookupName="personLookup">查找人员</a>
				</p>
				<p>
					<label>
						性别：
					</label>
					<input name="master.dwz_personLookup.sex"
						readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${person.sex}"/>" />
				</p>
				<p>
					<label>
						编码：
					</label>
					<input name="master.dwz_personLookup.personCode"
						readonly="readonly" type="text" size="30"
						value="${person.personCode}" />
				</p>
				<p>
					<label>
						证件号码：
					</label>
					<input name="master.dwz_personLookup.code" readonly="readonly"
						type="text" size="30" value="${person.code}" />
				</p>
				<p>
					<label>
						工作单位：
					</label>
					<input name="master.dwz_personLookup.company" readonly="readonly"
						type="text" size="30" value="${person.personBasic.company}" />
				</p>
				<p>
					<label>
						配偶姓名：
					</label>
					<input id="spouse_nameh"
						readonly="readonly" type="text" size="30" value="${spouse.nameh}" />
				</p>
				<p>
					<label>
						配偶工作单位：
					</label>
					<input id="spouse_company" readonly="readonly"
						type="text" size="30" value="${spouse.company}" />
				</p>


				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						子女信息
					</h2>
				</div>
				<p>
					<label>
						姓名：
					</label>
					<input id="children_nameh" readonly="readonly" type="text" size="30"
						value="${children.nameh}" />
				</p>
				<p>
					<label>
						性别：
					</label>
					<input id="children_sex" readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${children.sex}"/>" />
				</p>
				<p>
					<label>
						民族：
					</label>
					<input id="children_native" readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${children.native}"/>" />
				</p>
				<p>
					<label>
						出生日期：
					</label>
					<input id="children_birthday"  readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${children.birthday}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						照片：
					</label>
					<input id="children_photo" readonly="readonly" type="text" size="30"
						value="${children.photo}" />
				</p>
				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						证书信息
					</h2>
				</div>
<c:if test="${param.type==0}">
				<p>
					<label>
						发证机关：
					</label>
					<input class="required" name="issOrg" type="text" size="30" value="${issOrg}" />
				</p>
				<p>
					<label>
						发证日期：
					</label>
					<input name="issDate" class="date required" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						证书编号：
					</label>
					<input class="required" name="certCode" type="text" size="30" value="${certCode}" />
				</p>
</c:if>

<c:if test="${param.type==1}">
				<p>
					<label>
						发证机关：
					</label>
					<input readonly="readonly" type="text" size="30" value="${issOrg}" />
				</p>
				<p>
					<label>
						发证日期：
					</label>
					<input readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						证书编号：
					</label>
					<input readonly="readonly" type="text" size="30" value="${certCode}" />
				</p>
<div class="divider"></div>
				<p>
					<label>
						注销原因：
					</label>
					<input class="required" name="cancelCause" type="text" size="30"
						value="${cancelCause}" />
				</p>
				<p>
					<label>
						注销日期：
					</label>
					<input name="cancelDate" class="date required" readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${cancelDate}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
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
<script>
	var $box = navTab.getCurrentPanel();
	var a = 0;
	function setSpouseAndChildren() {
		if (a == 1) {
			var personId = $('#personId',$box).val();
			if (personId == $('#personId_',$box).val())
				return;
			var $tab = $('#tab__',$box);
			$('#personId_',$box).val(personId);

			$.post("${ctx}/pmas/spouse!findByPersonId.action", {personId :personId}, function(data) {
				$('#spouse_nameh',$box).val(data.nameh);
				$('#spouse_company',$box).val(data.company);
			});

			$.post("${ctx}/pmas/womanchildren!simplesub4ajax.action", {personId :personId}, function(data) {
				$('#children_nameh',$box).val(data.nameh);
				$('#children_sex',$box).val(data.sexLabel);
				$('#children_native',$box).val(data.nativeLabel);
				$('#children_birthday',$box).val(data.birthdayLabel);
				$('#children_photo',$box).val(data.photo);
				$('#childrenId',$box).val(data.id);
			});
		}
	}
</script>