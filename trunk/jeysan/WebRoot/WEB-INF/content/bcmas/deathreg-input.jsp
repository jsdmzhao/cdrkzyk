<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/deathreg!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="master.dwz_personLookup.personId" value="${person.id}"/>
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_deathregmanage" />
			<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					姓名：
				</label>
				<input name="master.dwz_personLookup.nameh" readonly="readonly" type="text" size="30"
					value="${person.nameh}" />
				<a class="btnLook" href="${ctx}/pmas/person!list4lookup.action" lookupGroup="master" lookupName="personLookup">查找人员</a>
			</p>
			<p>
				<label>
					性别：
				</label>
				<input name="master.dwz_personLookup.sex" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${person.sex}"/>" />
			</p>
			<p>
				<label>
					年龄：
				</label>
				<input name="master.dwz_personLookup.age" readonly="readonly" type="text" size="30"
					value="${person.age}" />
			</p>
			<p>
				<label>
					证件号码：
				</label>
				<input name="master.dwz_personLookup.code" readonly="readonly" type="text" size="30"
					value="${person.code}" />
			</p>
<div class="divider"></div>
				<p>
					<label>
						死亡日期：
					</label>
					<input name="dateh" class="date " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>" />
					<a class="inputDateButton" href="javascript:void(0)">选择</a>
				</p>
				<p>
					<label>
						死亡原因：
					</label>
					<input name="cause" type="text" size="30" value="${cause}" />
				</p>
				<p>
					<label>
						户主姓名：
					</label>
					<input name="nameh" type="text" size="30" value="${nameh}" />
				</p>
				<p>
					<label>
						与户主关系：
					</label>
					<tags:js.dict.selector value="${relation}" name="relation" dictCode="JS1040"></tags:js.dict.selector>
				</p>
				<p style="width:98%">
					<label>
						原住址：
					</label>
					<input name="oldAddress" type="text" size="100"
						value="${oldAddress}" />
				</p>
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