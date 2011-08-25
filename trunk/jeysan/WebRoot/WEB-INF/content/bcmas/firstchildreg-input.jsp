<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/firstchildreg!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" id="personId_" value="${fertileWoman.person.id}" />
			<input type="hidden" id="personId"
				name="master.dwz_fertileWomanLookup.personId"
				value="${fertileWoman.person.id}" />
			<input type="hidden"
				name="master.dwz_fertileWomanLookup.fertileWomanId"
				value="${fertileWoman.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_firstchildregmanage" />
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
											href="${ctx}/bcmas/fertilewoman!list4lookup.action?filter_EQI_registerType=<%=com.jeysan.cpf.util.Constants.RegisterType.NO%>"
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
							姓名：
						</label>
						<input name="master.dwz_fertileWomanLookup.nameh_"
							readonly="readonly" type="text" size="30"
							value="${fertileWoman.nameh}" />
					</p>
					<p>
						<label>
							妇女编码：
						</label>
						<input name="master.dwz_fertileWomanLookup.code_"
							readonly="readonly" type="text" size="30"
							value="${fertileWoman.code}" />
					</p>
					<p>
						<label>
							登记日期：
						</label>
						<input name="dateh" class="date " readonly="readonly" type="text"
							size="30"
							value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>" />
						<a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p>
						<label>
							是否再生一孩：
						</label>
						<tags:js.yes.no.selector class1="required" name="isSecond"
							value="${isSecond}" onChange="setCond(this.value)"></tags:js.yes.no.selector>
					</p>
					<p>
						<label>
							再生一孩条件：
						</label>
						<input id="cond__" name="cond" readonly="readonly" type="text"
							size="30" value="${cond}" />
					</p>
					<p>
						<label>
							部门意见：
						</label>
						<input name="deptOpt" type="text" size="30" value="${deptOpt}" />
					</p>
					<p>
						<label>
							经办人：
						</label>
						<input name="agent" type="text" size="30" value="${agent}" />
					</p>
					<p>
						<label>
							合同签署日期：
						</label>
						<input name="assignDate" class="date " readonly="readonly"
							type="text" size="30"
							value="<fmt:formatDate value="${assignDate}" pattern="yyyy-MM-dd"/>" />
						<a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p>
						<label>
							生育合同编号：
						</label>
						<input name="code" type="text" size="30" value="${code}" />
					</p>
					<p>
						<label>
							一孩预产期：
						</label>
						<input name="edd" class="date " readonly="readonly" type="text"
							size="30"
							value="<fmt:formatDate value="${edd}" pattern="yyyy-MM-dd"/>" />
						<a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p>
						<label>
							备注：
						</label>
						<input name="remark" type="text" size="30" value="${remark}" />
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
			$('#cond__').val('');
		} else if (value == 1) {
			$('#cond__').val('孩子死亡安排再生一孩');
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
		}
	}
</script>