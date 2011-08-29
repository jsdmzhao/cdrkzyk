﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					姓名：
				</label>
				<input name="person.nameh" readonly="readonly" type="text" size="30"
					value="${person.nameh}" />
			</p>
			<p>
				<label>
					性别：
				</label>
				<input name="person.sex" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${person.sex}"/>" />
			</p>
			<p>
				<label>
					年龄：
				</label>
				<input name="person.age" readonly="readonly" type="text" size="30"
					value="${person.age}" />
			</p>
			<p>
				<label>
					证件号码：
				</label>
				<input name="person.code" readonly="readonly" type="text" size="30"
					value="${person.code}" />
			</p>
<div class="divider"></div>
			<p>
				<label>
					死亡日期：
				</label>
				<input name="dateh" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					死亡原因：
				</label>
				<input name="cause" readonly="readonly" type="text" size="30"
					value="${cause}" />
			</p>
			<p>
				<label>
					户主姓名：
				</label>
				<input name="nameh" readonly="readonly" type="text" size="30"
					value="${nameh}" />
			</p>
			<p>
				<label>
					与户主关系：
				</label>
				<input name="relation" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${relation}"/>" />
			</p>
			<p style="width:98%">
				<label>
					原住址：
				</label>
				<input name="oldAddress" readonly="readonly" type="text" size="100"
					value="${oldAddress}" />
			</p>
			<p>
				<label>
					备注：
				</label>
				<input name="remark" readonly="readonly" type="text" size="30"
					value="${remark}" />
			</p>
		</div>
		<div class="formBar">
			<ul>
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
