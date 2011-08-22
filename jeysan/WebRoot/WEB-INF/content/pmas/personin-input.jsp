<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/personin!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personinmanage"/>
			<input type="hidden" name="master.dwz_personLookup.personId" value="${person.id}"/>
			<div class="pageFormContent" layoutH="56">
					<div style="float: left; width: 98%;">
						<h2 class="contentTitle">
							流入人员基本情况
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
							流入人员流动情况
						</h2>
					</div>
																													<p>
					<label>流入原因：</label>
					<tags:js.dict.selector name="inCause" class1="required"  value="${inCause}" dictCode="JS1042"/>
					</p>
					<p>
					<label>流入类型：</label>
					<tags:js.dict.selector name="inType" class1="required"  value="${inType}" dictCode="JS1046"/>
					</p>
																													<p>
					<label>流入日期：</label>
					<input name="inDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${inDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
					<p style="width:98%">
					<label>流入地地址：</label>
					<tags:js.district.selector onChange="setAddress"/>
					</p>

					<p style="width:98%">
					<label>流入地地址：</label>
					<input id="inAddress" name="inAddress" type="text" size="100" value="${inAddress}"/>
					</p>
																														<p>
					<label>流入地编码：</label>
					<input id="inAddressCode" name="inAddressCode" readonly="readonly" type="text" size="30" value="${inAddressCode}"/>
					</p>
																													<p>
					<label>持证情况：</label>
					<tags:js.dict.selector name="haveStatus" class1="required"  value="${haveStatus}" dictCode="JS1051"/>
					</p>
																													<p>
					<label>夫妻是否共同流入：</label>
					<tags:js.yes.no.selector name="isFamilyAllIn" value="${isFamilyAllIn}"></tags:js.yes.no.selector>
					</p>
																													<p>
					<label>配偶流入日期：</label>
					<input name="spouseInDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${spouseInDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>配偶流出日期：</label>
					<input name="spouseOutDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${spouseOutDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
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
<script>
function setAddress(obj,address_){
	$('#inAddressCode').val(obj.value.split('_')[1]);
	$('#inAddress').val(address_);
}
</script>