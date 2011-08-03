<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/spouse!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_spousemanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>配偶ID：</label>
					<input name="personId" class="digits" type="text" size="30" value="${personId}"/>
					</p>
																													<p>
					<label>NAMEH：</label>
					<input name="nameh"  class="required" maxlength="50"    type="text" size="30" value="${nameh}"  alt="请输入NAMEH" />
					</p>
																													<p>
					<label>性别：</label>
					<input name="sex" class="digits  required" type="text" size="30" value="${sex}"/>
					</p>
																													<p>
					<label>年龄：</label>
					<input name="age" class="digits  required" type="text" size="30" value="${age}"/>
					</p>
																													<p>
					<label>身份证号码：</label>
					<input name="code"    type="text" size="30" value="${code}" />
					</p>
																													<p>
					<label>户籍地：</label>
					<input name="domicile"    type="text" size="30" value="${domicile}" />
					</p>
																													<p>
					<label>户籍地编码：</label>
					<input name="domicileCode"    type="text" size="30" value="${domicileCode}" />
					</p>
																													<p>
					<label>户籍地邮编：</label>
					<input name="zipCode"    type="text" size="30" value="${zipCode}" />
					</p>
																													<p>
					<label>现居住地：</label>
					<input name="address"    type="text" size="30" value="${address}" />
					</p>
																													<p>
					<label>居住地类型：</label>
					<input name="addressType" class="digits" type="text" size="30" value="${addressType}"/>
					</p>
																													<p>
					<label>现居住地编码：</label>
					<input name="addressCode"    type="text" size="30" value="${addressCode}" />
					</p>
																													<p>
					<label>门牌号码：</label>
					<input name="houseNumber"    type="text" size="30" value="${houseNumber}" />
					</p>
																													<p>
					<label>户口类别：</label>
					<input name="domicileType" class="digits" type="text" size="30" value="${domicileType}"/>
					</p>
																													<p>
					<label>民族：</label>
					<input name="native" class="digits" type="text" size="30" value="${native}"/>
					</p>
																													<p>
					<label>出生日期：</label>
					<input name="birthday" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>文化程度：</label>
					<input name="edu" class="digits" type="text" size="30" value="${edu}"/>
					</p>
																													<p>
					<label>政治面貌：</label>
					<input name="politicalStatus" class="digits" type="text" size="30" value="${politicalStatus}"/>
					</p>
																													<p>
					<label>户口性质：</label>
					<input name="househodeKind" class="digits" type="text" size="30" value="${househodeKind}"/>
					</p>
																													<p>
					<label>职业：</label>
					<input name="job" class="digits" type="text" size="30" value="${job}"/>
					</p>
																													<p>
					<label>是否独生：</label>
					<input name="isSingle" class="digits" type="text" size="30" value="${isSingle}"/>
					</p>
																													<p>
					<label>工作单位：</label>
					<input name="company"    type="text" size="30" value="${company}" />
					</p>
																													<p>
					<label>照片：</label>
					<input name="photo"    type="text" size="30" value="${photo}" />
					</p>
																													<p>
					<label>指纹：</label>
					<input name="fingerprint"    type="text" size="30" value="${fingerprint}" />
					</p>
																													<p>
					<label>联系电话：</label>
					<input name="tel"    type="text" size="30" value="${tel}" />
					</p>
																													<p>
					<label>持证情况：</label>
					<input name="haveStatus" class="digits" type="text" size="30" value="${haveStatus}"/>
					</p>
																													<p>
					<label>验证情况：</label>
					<input name="validateStatus" class="digits" type="text" size="30" value="${validateStatus}"/>
					</p>
																													<p>
					<label>备注：</label>
					<input name="remark"    type="text" size="30" value="${remark}" />
					</p>
																	</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>