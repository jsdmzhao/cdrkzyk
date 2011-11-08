﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						${entity.person.sex==1?'父亲':'母亲'}信息：
					</h2>
				</div>
				<p>
					<label>
						姓名：
					</label>
					<input type="text" size="30" value="${entity.person.nameh}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						人员编码：
					</label>
					<input type="text" size="30" value="${entity.person.personCode}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						出生日期：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${entity.person.personBasic.birthday}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						年龄：
					</label>
					<input type="text" size="30" value="${entity.person.age}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						证件类型：
					</label>
					<input type="text" size="30" value="<tags:js.dict.getValue value="${entity.person.certType}" />"
						readonly="readonly" />
				</p>
				<p>
					<label>
						证件号码：
					</label>
					<input type="text" size="30" value="${entity.person.code}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						户口类别：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${entity.person.domicileType}"/>" />
				</p>

				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						子女信息：
					</h2>
				</div>
			<p>
				<label>
					姓名：
				</label>
				<input name="nameh" readonly="readonly" type="text" size="30"
					value="${entity.nameh}" />
			</p>
			<p>
				<label>
					性别：
				</label>
				<input name="sex" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${entity.sex}" />" />
			</p>
			<p>
				<label>
					出生日期：
				</label>
				<input name="birthday" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${entity.birthday}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					出生地点：
				</label>
				<input name="birthAddress" readonly="readonly" type="text" size="30"
					value="${entity.birthAddress}" />
			</p>
			<p>
				<label>
					民族：
				</label>
				<input name="native" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${entity.native}" />" />
			</p>
				<p style="width: 98%; height: 120px">
					<label>
						照片：
					</label>
					<img width="200" height="120" src="${ctx}/${entity.photo}" />
				</p>
			<p>
				<label>
					政策内外：
				</label>
				<input name="policy" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${entity.policy}" />" />
			</p>
			<p>
				<label>
					政策外类型：
				</label>
				<input name="outType" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${entity.outType}" />" />
			</p>
			<p>
				<label>
					孩次：
				</label>
				<input name="childIndex" readonly="readonly" type="text" size="30"
					value="${entity.childIndex}" />
			</p>
			<p>
				<label>
					出生证号：
				</label>
				<input name="birthCert" readonly="readonly" type="text" size="30"
					value="${entity.birthCert}" />
			</p>
			<p>
				<label>
					健康状况：
				</label>
				<input name="healthStatus" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${entity.healthStatus}" />" />
			</p>
			<p>
				<label>
					血缘关系：
				</label>
				<input name="kinship" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${entity.kinship}" />" />
			</p>
			<p>
				<label>
					变化日期：
				</label>
				<input name="changeDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${entity.changeDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					变化原因：
				</label>
				<input name="changeCause" readonly="readonly" type="text" size="30"
					value="${entity.changeCause}" />
			</p>
			<p>
				<label>
					出生医院名称：
				</label>
				<input name="hospital" readonly="readonly" type="text" size="30"
					value="${entity.hospital}" />
			</p>
			<p>
				<label>
					出生医院类型：
				</label>
				<input name="hospitalType" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${entity.hospitalType}" />" />
			</p>
			<p>
				<label>
					收养日期：
				</label>
				<input name="adoptDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${entity.adoptDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					收养证号：
				</label>
				<input name="adoptCept" readonly="readonly" type="text" size="30"
					value="${entity.adoptCept}" />
			</p>
<div class="divider"></div>
				<p>
					<label>
						上报日期：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${entity.upDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						备注：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${entity.remark}" />
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
