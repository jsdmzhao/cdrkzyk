<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/getiud!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="fertileWoman.id"
				value="${fertileWoman.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_getiudmanage" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						姓名：
					</label>
					<input readonly="readonly" type="text"
						size="30" value="${fertileWoman.nameh}" />
				</p>
				<p>
					<label>
						妇女编码：
					</label>
					<input readonly="readonly"  type="text"
						size="30" value="${fertileWoman.code}" />
				</p>
				<p>
					<label>
						取环类型：
					</label>
					<input readonly="readonly"  type="text"
						size="30" value="<tags:js.dict.getValue value="${typeh}"/>" />
				</p>
				<p>
					<label>
						取环时间：
					</label>
					<input name="dateh" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						未避孕类型：
					</label>
					<tags:js.dict.selector name="noContraceptType" value="${noContraceptType}" dictCode="JS1074"/>
				</p>
				<p>
					<label>
						手术医院：
					</label>
					<input name="hospital" class=" required" type="text" size="30" value="${hospital}" />
				</p>
				<p>
					<label>
						手术医院类型：
					</label>
					<tags:js.dict.selector name="hospitalType" value="${hospitalType}" dictCode="JS1053"/>
				</p>
				<p style="width:98%">
					<label>
						手术医院地址：
					</label>
					<input name="hospitalAddress" type="text" size="100"
						value="${hospitalAddress}" />
				</p>
				<p>
					<label>
						手术人：
					</label>
					<input name="doctor" type="text" size="30" value="${doctor}" />
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