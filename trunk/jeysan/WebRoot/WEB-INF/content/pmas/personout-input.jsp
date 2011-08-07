<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/personout!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personoutmanage"/>
			<input type="hidden" name="master.dwz_personLookup.personId" value="${person.id}"/>
			<div class="pageFormContent" layoutH="56">
					<div style="float: left; width: 98%;">
						<h2 class="contentTitle">
							流出人员基本情况
						</h2>
					</div>
					<p>
					<label>姓名：</label>
					<input name="master.dwz_personLookup.nameh" class="required"  type="text" size="30" value="${person.nameh}" readonly="readonly" />
					<a class="btnLook" href="${ctx}/pmas/person!list4lookup.action" lookupGroup="master" lookupName="personLookup">查找人员</a>	
					</p>
					<p>
					<label>性别：</label>
					<input name="master.dwz_personLookup.sex" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${person.sex}"/>"/>
					</p>
					<p>
					<label>证件类型：</label>
<input readonly="readonly" name="master.dwz_personLookup.certType" type="text" size="30" value="<tags:js.dict.getValue value="${person.certType}"/>"/>
					</p>
					<p>
					<label>证件号码：</label>
					<input name="master.dwz_personLookup.code"   type="text" size="30" value="${person.code}" readonly="readonly" />
					</p>
					<p>
					<label>出生日期：</label>
					<input name="master.dwz_personLookup.birthday" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${person.personBasic.birthday}" pattern="yyyy-MM-dd"/>"/>
					</p>
					<p>
					<label>年龄：</label>
					<input name="master.dwz_personLookup.age"  type="text" size="30" value="${person.age}" readonly="readonly"/>
					</p>
					<p>
					<label>婚姻状况：</label>
<input readonly="readonly" name="master.dwz_personLookup.marryStatus" type="text" size="30" value="<tags:js.dict.getValue value="${person.personBasic.marryStatus}"/>"/>
					</p>
					<p>
					<label>避孕节育措施：</label>
					<input name="master.dwz_personLookup.method" type="text" size="30" value="${method}" readonly="readonly"/>
					</p>
					<p>
					<label>子女数：</label>
					<input name="master.dwz_personLookup.childrenCount"  type="text" size="30" value="${childrenCount}" readonly="readonly"/>
					</p>

					<div style="float: left; width: 98%;">
						<h2 class="contentTitle">
							流出人员流动情况
						</h2>
					</div>
																													<p>
					<label>流出原因：</label>
					<tags:js.dict.selector name="outCause" class1="required"  value="${outCause}" dictCode="JS1042"/>
					</p>	
																						<p>
					<label>流出类型：</label>
					<tags:js.dict.selector name="outType" class1="required"  value="${outType}" dictCode="JS1047"/>
					</p>
																													<p>
					<label>流出地编码：</label>
					<input name="outAddressCode" class="required" type="text" size="30" value="${outAddressCode}" />
					</p>
																													<p>
					<label>流出地地址：</label>
					<input name="outAddress" class="required" type="text" size="30" value="${outAddress}" />
					</p>
																													<p>
					<label>流出日期：</label>
					<input name="outDate" class="date required" type="text" readonly="readonly" size="30" value="<fmt:formatDate value="${outDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>流入地编码：</label>
					<input name="inAddressCode"    type="text" size="30" value="${inAddressCode}" />
					</p>
																													<p>
					<label>流入地地址：</label>
					<input name="inAddress"    type="text" size="30" value="${inAddress}" />
					</p>
																													<p>
					<label>持证情况：</label>
					<tags:js.dict.selector name="haveStatus" class1="required"  value="${haveStatus}" dictCode="JS1051"/>
					</p>
																													<p>
					<label>夫妻是否共同流出：</label>
					<tags:js.yes.no.selector name="isFamilyAllOut" value="${isFamilyAllOut}"></tags:js.yes.no.selector>
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