<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>姓名：</label>
					<input name="nameh"  type="text" size="30" value="${nameh}" readonly="readonly" />
					</p>
					<p>
					<label>性别：</label>
					<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${sex}"/>"/>
					</p>
					<p>
					<label>证件号码：</label>
					<input name="code"     type="text" size="30" value="${code}" readonly="readonly" />
					</p>
					<p>
					<label>证件类型：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${certType}"/>"/>
					</p>
					<p>
					<label>户口类别：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${domicileType}"/>"/>
					</p>
					<p>
					<label>人员类别：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${kind}"/>"/>
					</p>
					<p>
					<label>人员编号：</label>
					<input name="personCode"     type="text" size="30" value="${personCode}" readonly="readonly" />
					</p>

<div class="divider"></div>
					<p>
					<label>国籍：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${personBasic.nationality}"/>"/>
					</p>
					<p>
					<label>民族：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${personBasic.native}"/>"/>
					</p>
					<p>
					<label>出生日期：</label>
					<input name="personBasic.birthday" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${personBasic.birthday}" pattern="yyyy-MM-dd"/>"/>
					</p>
					<p>
					<label>年龄：</label>
					<input name="age"  type="text" size="30" value="${age}" readonly="readonly"/>
					</p>
					<p>
					<label>婚姻状况：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${personBasic.marryStatus}"/>"/>
					</p>
					<p>
					<label>初婚日期：</label>
					<input name="personBasic.firstMarryDate"  readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${personBasic.firstMarryDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
					<p>
					<label>文化程度：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${personBasic.edu}"/>"/>
					</p>
					<p>
					<label>政治面貌：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${personBasic.politicalStatus}"/>"/>
					</p>
					<p>
					<label>户口性质：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${personBasic.househodeKind}"/>"/>
					</p>
					<p>
					<label>职业：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${personBasic.job}"/>"/>
					</p>
					<p>
					<label>是否独生：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${personBasic.isSingle}"/>"/>
					</p>
					<p>
					<label>工作单位：</label>
					<input name="personBasic.company"    type="text" size="30" value="${personBasic.company}" readonly="readonly" />
					</p>
					<p>
					<label>照片：</label>
					<input name="personBasic.photo"    type="text" size="30" value="${personBasic.photo}" readonly="readonly" />
					</p>
					<p>
					<label>指纹：</label>
					<input name="personBasic.fingerprint"    type="text" size="30" value="${personBasic.fingerprint}" readonly="readonly" />
					</p>
					<p>
					<label>联系电话：</label>
					<input name="personBasic.tel"    type="text" size="30" value="${personBasic.tel}" readonly="readonly" />
					</p>
<div class="divider"></div>
					<p>
					<label>居住地类型：</label>
					<input name="personBasic.addressType" type="text" size="30" value="${personBasic.addressType}" readonly="readonly" />
					</p>
					<p style="width:98%">
					<label>现居住地：</label>
					<input name="personBasic.address"    type="text" size="100" value="${personBasic.address}" readonly="readonly" />
					</p>
					<p>
					<label>现居住地编码：</label>
					<input name="personBasic.addressCode"    type="text" size="30" value="${personBasic.addressCode}" readonly="readonly" />
					</p>
					<p>
					<label>现居住地门牌号码：</label>
					<input name="personBasic.houseNo"    type="text" size="30" value="${personBasic.houseNo}" readonly="readonly" />
					</p>
					<p>
					<label>现居住地房号：</label>
					<input name="personBasic.roomNo"    type="text" size="30" value="${personBasic.roomNo}" readonly="readonly" />
					</p>
					<p>
					<label>现居住地邮编：</label>
					<input name="personBasic.zipCode"    type="text" size="30" value="${personBasic.zipCode}" readonly="readonly" />
					</p>
					<p>
					<label>村民小组：</label>
					<input name="personBasic.villagerTeamId" type="text" size="30" value="${villagerteam.teamName}" readonly="readonly" />
					</p>
					<p>
					<label>户编码：</label>
					<input name="personBasic.houseHoldCode"    type="text" size="30" value="${personBasic.houseHoldCode}" readonly="readonly" />
					</p>
					<p>
					<label>户主姓名：</label>
					<input name="personBasic.ownerName"    type="text" size="30" value="${personBasic.ownerName}" readonly="readonly" />
					</p>
					<p>
					<label>与户主关系：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${personBasic.relation}"/>"/>
					</p>
					<p>
					<label>房屋编码：</label>
					<input name="house.houseCode" class="digits" type="text" size="30" value="${house.houseCode}"/>
					</p>
<div class="divider"></div>
					<p style="width:98%">
					<label>户籍地：</label>
					<input name="personBasic.domicile"    type="text" size="100" value="${personBasic.domicile}" readonly="readonly" />
					</p>
					<p style="width:98%">
					<label>户籍地编码：</label>
					<input name="personBasic.domicileCode"    type="text" size="30" value="${personBasic.domicileCode}" readonly="readonly" />
					</p>
					<p>
					<label>户籍地门牌号码：</label>
					<input name="personBasic.domicileHouseNo"    type="text" size="30" value="${personBasic.domicileHouseNo}" readonly="readonly" />
					</p>
					<p>
					<label>户籍地房号：</label>
					<input name="personBasic.domicileRoomNo"    type="text" size="30" value="${personBasic.domicileRoomNo}" readonly="readonly" />
					</p>
					<p>
					<label>户籍地邮编：</label>
					<input name="personBasic.domicileZipCode"    type="text" size="30" value="${personBasic.domicileZipCode}" readonly="readonly" />
					</p>

<div class="divider"></div>
					<p>
					<label>父亲姓名：</label>
					<input name="personBasic.father"    type="text" size="30" value="${personBasic.father}" readonly="readonly" />
					</p>

					<p>
					<label>父亲身份证：</label>
					<input name="personBasic.fatherCode"    type="text" size="30" value="${personBasic.fatherCode}" readonly="readonly" />
					</p>

					<p>
					<label>母亲姓名：</label>
					<input name="personBasic.mother"    type="text" size="30" value="${personBasic.mother}" readonly="readonly" />
					</p>

					<p>
					<label>母亲身份证：</label>
					<input name="personBasic.motherCode"    type="text" size="30" value="${personBasic.motherCode}" readonly="readonly" />
					</p>
					
<div class="divider"></div>
					<p>
					<label>何地迁入(流入)：</label>
					<input name="settleInPlace"    type="text" size="30" value="${settleInPlace}" readonly="readonly" />
					</p>
					<p>
					<label>迁入(流入)日期：</label>
					<input name="settleInDate"  readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${settleInDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
					<p>
					<label>迁入(流入)原因：</label>
					<input name="settleInCause"    type="text" size="30" value="${settleInCause}" readonly="readonly" />
					</p>
					<p>
					<label>迁入(流入)类别：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${settleInType}"/>"/>
					</p>
<div class="divider"></div>
					<p>
					<label>备注：</label>
					<input name="personBasic.remark"    type="text" size="30" value="${personBasic.remark}" readonly="readonly" />
					</p>
																		</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
</div>
