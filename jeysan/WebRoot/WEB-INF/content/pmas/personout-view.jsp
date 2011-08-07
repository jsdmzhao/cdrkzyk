<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
					<div style="float: left; width: 98%;">
						<h2 class="contentTitle">
							流出人员基本情况
						</h2>
					</div>
					<p>
					<label>姓名：</label>
					<input name="master.dwz_personLookup.nameh" class="required"  type="text" size="30" value="${person.nameh}" readonly="readonly" />
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
					<input name="outCause" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${outCause}"/>"/>
					</p>
																														<p>
					<label>流出类型：</label>
					<input name="outType" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${outType}"/>"/>
					</p>																									<p>
					<label>流出地编码：</label>
					<input name="outAddressCode" readonly="readonly" type="text" size="30" value="${outAddressCode}"/>
					</p>
																														<p>
					<label>流出地地址：</label>
					<input name="outAddress" readonly="readonly" type="text" size="30" value="${outAddress}"/>
					</p>
																														<p>
					<label>流出日期：</label>
					<input name="outDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${outDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>流入地编码：</label>
					<input name="inAddressCode" readonly="readonly" type="text" size="30" value="${inAddressCode}"/>
					</p>
																														<p>
					<label>流入地地址：</label>
					<input name="inAddress" readonly="readonly" type="text" size="30" value="${inAddress}"/>
					</p>
																														<p>
					<label>持证情况：</label>
					<input name="haveStatus" readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${haveStatus}"/>"/>
					</p>
																														<p>
					<label>夫妻是否共同流出：</label>
					<input name="isFamilyAllOut" readonly="readonly" type="text" size="30" value="<tags:js.yes.no.getValue value="${isFamilyAllOut}"/>"/>
					</p>
																														<p>
					<label>备注：</label>
					<input name="remark" readonly="readonly" type="text" size="30" value="${remark}"/>
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
