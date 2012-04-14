<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/birth2apply!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" id="id" name="id" value="${id}" />
			<input type="hidden" id="personId_" value="${fertileWoman.person.id}" />
			<input type="hidden" id="personId"
				name="master.dwz_fertileWomanLookup.personId"
				value="${fertileWoman.person.id}" />
			<input type="hidden" id="fertileWomanId"
				name="master.dwz_fertileWomanLookup.fertileWomanId"
				value="${fertileWoman.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_birth2applymanage" />
			<div class="pageFormContent" layoutH="56">
				<div style="float: left; width: 98%;">
					<div style="float: left; width: 48%; margin: 2px">

						<div class="tabs" currentIndex="0" eventType="click">
							<div class="tabsHeader">
								<div class="tabsHeaderContent">
									<ul>
										<li>
											<a href="javascript:;"><span>母亲信息</span> </a>
										</li>
									</ul>
								</div>
							</div>
							<div class="tabsContent" style="height: 160px;">
								<div>
									<p>
										<label>
											姓名：
										</label>
										<input name="master.dwz_fertileWomanLookup.nameh"
											class="required" type="text" size="30"
											value="${fertileWoman.nameh}" readonly="readonly"
											onpropertychange="setSpouseAndChildren()" />
										<a class="btnLook"
											href="${ctx}/bcmas/fertilewoman!list4lookup.action?filter_EQI_birth2Type=<%=com.jeysan.cpf.util.Constants.Birth2Type.NO%>"
											lookupGroup="master" lookupName="fertileWomanLookup"
											onclick="javascript:a=1;">查找妇女</a>
									</p>
									<p>
										<label>
											出生日期：
										</label>
										<input name="master.dwz_fertileWomanLookup.birthday"
											readonly="readonly" type="text" size="30"
											value="<fmt:formatDate value="${fertileWoman.person.personBasic.birthday}" pattern="yyyy-MM-dd"/>" />
									</p>
									<p>
										<label>
											年龄：
										</label>
										<input name="master.dwz_fertileWomanLookup.age" type="text"
											size="30" value="${fertileWoman.person.age}"
											readonly="readonly" />
									</p>
									<p>
										<label>
											证件号码：
										</label>
										<input name="master.dwz_fertileWomanLookup.code" type="text"
											size="30" value="${fertileWoman.person.code}"
											readonly="readonly" />
									</p>
									<p>
										<label>
											户口类别：
										</label>
										<input name="master.dwz_fertileWomanLookup.domicileType"
											readonly="readonly" type="text" size="30"
											value="<tags:js.dict.getValue value="${fertileWoman.person.domicileType}"/>" />
									</p>

								</div>
							</div>
							<div class="tabsFooter">
								<div class="tabsFooterContent"></div>
							</div>
						</div>


					</div>
					<div style="float: left; width: 48%; margin: 2px">
						<div class="tabs" currentIndex="0" eventType="click">
							<div class="tabsHeader">
								<div class="tabsHeaderContent">
									<ul>
										<li>
											<a href="javascript:;"><span>父亲信息</span> </a>
										</li>
									</ul>
								</div>
							</div>
							<div class="tabsContent" style="height: 160px;">
								<div>
									<p>
										<label>
											姓名：
										</label>
										<input id="nameh2" readonly="readonly" type="text" size="30"
											value="${spouse.nameh}" />
									</p>


									<p>
										<label>
											出生日期：
										</label>
										<input id="birthday2" readonly="readonly" type="text"
											size="30"
											value="<fmt:formatDate value="${spouse.birthday}" pattern="yyyy-MM-dd"/>" />
									</p>

									<p>
										<label>
											年龄：
										</label>
										<input id="age2" readonly="readonly" type="text" size="30"
											value="${spouse.age}" />
									</p>

									<p>
										<label>
											身份证号码：
										</label>
										<input id="code2" readonly="readonly" type="text" size="30"
											value="${spouse.code}" />
									</p>

									<p>
										<label>
											户口类别：
										</label>
										<input id="domicileType2" readonly="readonly" type="text"
											size="30"
											value="<tags:js.dict.getValue value="${spouse.domicileType}"/>" />
									</p>

								</div>
							</div>
							<div class="tabsFooter">
								<div class="tabsFooterContent"></div>
							</div>
						</div>

					</div>
				</div>
				<div class="divider"></div>
				<div style="float: left; width: 98%;">
					<p>
						<label>
							申请类型：
						</label>
						<tags:js.dict.selector noRender="true" class1="required" name="typeh" value="${typeh}" dictCode="JS1011"/>
					</p>

					<p>
						<label>
							申请日期：
						</label>
						<input id="selector_dateh" name="dateh" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly" type="text"
							size="30"
							value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>" />
						
					</p>
					
					<p>
						<label>
							是否接受申请：
						</label>
						<tags:js.yes.no.selector noRender="true" class1="required" name="isAccept" value="${isAccept}"/>
					</p>
					<p>
						<label>
							是否再生二孩：
						</label>
						<tags:js.yes.no.selector noRender="true" class1="required" name="isSecond"
							value="${isSecond}" onChange="setCond(this.value)"/>
					</p>
					<p style="width:98%">
						<label>
							申请条件：
						</label>
						<input id="selector_cond__" name="cond" type="text" size="100" value="${cond}" />
					</p>
					<p>
						<label>
							申请书编号：
						</label>
						<input id="selector_code" name="code" type="text" size="30" value="${code}" />
					</p>
					<p>
						<label>
							经办人：
						</label>
						<input id="selector_agent" name="agent" type="text" size="30" value="${agent}" />
					</p>
					<p>
						<label>
							孕产状态：
						</label>
						<tags:js.dict.selector name="matenalStatus" value="${matenalStatus}" dictCode="JS1071"/>
					</p>
				</div>
				<div class="divider"></div>
				<div style="float: left; width: 150%; margin-top: 5px">
					<div class="tabs" currentIndex="${id==null?-1:0}" eventType="click">
						<div class="tabsHeader">
							<div class="tabsHeaderContent">
								<ul>
									<li>
										<a id="tab__"
											href="${ctx}/pmas/womanchildren!multiplysubs.action?personId=${fertileWoman.person.id}"
											class="j-ajax"><span>子女信息</span> </a>
									</li>
								</ul>
							</div>
						</div>
						<div class="tabsContent" style="height: 231px;">
							<div></div>
						</div>
						<div class="tabsFooter">
							<div class="tabsFooterContent"></div>
						</div>
					</div>
				</div>


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
	function setCond(value) {
		if (value == '' || value == 0) {
			$('#cond__',$box).val('');
		} else if (value == 1) {
			$('#cond__',$box).val('孩子死亡安排再生二孩');
		}
	}
	function setSpouseAndChildren() {
		if (a == 1) {
			var personId = $('#personId',$box).val();
			if (personId == $('#personId_',$box).val())
				return;
			var $tab = $('#tab__',$box);
			$tab.attr('href','${ctx}/pmas/womanchildren!multiplysubs.action?personId=' + personId);
			$tab.click();
			$('#personId_',$box).val(personId);

			$.post("${ctx}/pmas/spouse!findByPersonId.action", {personId :personId}, function(data) {
				$('#nameh2',$box).val(data.nameh);
				$('#age2',$box).val(data.age);
				$('#code2',$box).val(data.code);
				$('#birthday2',$box).val(data.birthdayLabel);
				$('#domicileType2',$box).val(data.domicileTypeLabel);
			});

			$.post("${ctx}/bcmas/birth2apply!findByWomanId.action", {fertileWomanId :$('#fertileWomanId').val()}, function(data) {
				$('#selector_typeh',$box).val(data.typeh);
				$('#selector_dateh',$box).val(data.datehLabel);
				$('#selector_isAccept',$box).val(data.isAccept);
				$('#selector_isSecond',$box).val(data.isSecond);
				$('#selector_cond__',$box).val(data.cond__);
				$('#selector_code',$box).val(data.code);
				$('#selector_agent',$box).val(data.agent);
				$('#id',$box).val(data.id);
			});
		}
	}
</script>