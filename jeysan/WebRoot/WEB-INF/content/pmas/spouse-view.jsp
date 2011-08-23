<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
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
				<input readonly="readonly" type="text" size="30"
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
				<input type="text" size="30" value="${person.personCode}"
					readonly="readonly" />
			</p>
			<p>
				<label>
					国籍：
				</label>
				<input type="text" size="30" readonly="readonly" 
					value="<tags:js.dict.getValue value="${person.personBasic.nationality}"/>" />
			</p>
			<p>
				<label>
					民族：
				</label>
				<input type="text" size="30" readonly="readonly" 
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
				<input readonly="readonly" type="text" size="30"
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
				<input readonly="readonly" type="text" size="30" value="${nameh}" />
			</p>


			<p>
				<label>
					身份证号码：
				</label>
				<input readonly="readonly type="text"  ize="30" value="${code}" />
			</p>


			<p>
				<label>
					出生日期：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>" />
			</p>

			<p>
				<label>
					年龄：
				</label>
				<input readonly="readonly" type="text" size="30" value="${age}" />
			</p>

			<div class="divider"></div>

			<p style="width: 98%">
				<label>
					户籍地：
				</label>
				<input readonly="readonly" type="text" size="100"
					value="${domicile}" />
			</p>
			<p>
				<label>
					户籍地编码：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${domicileCode}" />
			</p>
			<p>
				<label>
					户籍地邮编：
				</label>
				<input readonly="readonly" type="text" size="30" value="${zipCode}" />
			</p>

			<div class="divider"></div>

			<p style="width: 98%">
				<label>
					现居住地：
				</label>
				<input readonly="readonly" type="text" size="100"
					value="${address}" />
			</p>
			<p>
				<label>
					现居住地编码：
				</label>
				<input readonly="readonly"
					type="text" size="30" value="${addressCode}" />
			</p>

			<p>
				<label>
					居住地类型：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${addressType}" />
			</p>
			<p>
				<label>
					门牌号码：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${houseNumber}" />
			</p>
			<p>
				<label>
					户口类别：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${domicileType}"/>" />
			</p>
			<div class="divider"></div>
			<p>
				<label>
					民族：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${native}"/>" />
			</p>
			<p>
				<label>
					初婚日期：
				</label>
				<input readonly="readonly"
					type="text" size="30"
					value="<fmt:formatDate value="${firstMarryDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					文化程度：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${edu}"/>" />
			</p>
			<p>
				<label>
					政治面貌：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${politicalStatus}"/>" />
			</p>
			<p>
				<label>
					户口性质：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${househodeKind}"/>" />
			</p>
			<p>
				<label>
					职业：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${job}"/>" />
			</p>
			<p>
				<label>
					是否独生：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.yes.no.getValue value="${isSingle}"/>" />
			</p>
			<p>
				<label>
					工作单位：
				</label>
				<input readonly="readonly" type="text" size="30" value="${company}" />
			</p>
			<p>
				<label>
					照片：
				</label>
				<input readonly="readonly" type="text" size="30" value="${photo}" />
			</p>
			<p>
				<label>
					指纹：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${fingerprint}" />
			</p>
			<p>
				<label>
					联系电话：
				</label>
				<input readonly="readonly" type="text" size="30" value="${tel}" />
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
				<input readonly="readonly" type="text" size="30" value="${remark}" />
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
