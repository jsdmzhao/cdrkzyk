<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%
request.setAttribute("filter",java.util.Arrays.asList(672,673)); %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/person!cancel.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${person.id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_personmanage"/>
			<input type="hidden" name="type" value="0"/>
			<div class="pageFormContent" layoutH="56"><p>
					<label>姓名：</label>
					<input name="nameh"  type="text" size="30" value="${person.nameh}" readonly="readonly" />
					</p>
					<p>
					<label>性别：</label>
					<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${person.sex}"/>"/>
					</p>
					<p>
					<label>证件号码：</label>
					<input name="code"     type="text" size="30" value="${person.code}" readonly="readonly" />
					</p>
					<p>
					<label>证件类型：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${person.certType}"/>"/>
					</p>
					<p>
					<label>户口类别：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${person.domicileType}"/>"/>
					</p>
					<p>
					<label>人员类别：</label>
<input readonly="readonly" type="text" size="30" value="<tags:js.dict.getValue value="${person.kind}"/>"/>
					</p>
					<p>
					<label>人员编号：</label>
					<input name="personCode"     type="text" size="30" value="${person.personCode}" readonly="readonly" />
					</p>
					<p>
					<label>状态：</label>
					<input name="cancelType_"     type="text" size="30" readonly="readonly" value="<tags:js.dict.getValue value="${person.cancelType}"/>"/>
					</p>

<div class="divider"></div>
					<p style="width:100%">
					<label>注销类别：</label>
					<tags:js.dict.selector filter="${filter}" name="cancelType" class1="required" value="${person.cancelType}" dictCode="JS1010" onChange="if(this.value==153) $('#dateh_tips').html('发生时间：');if(this.value==154) $('#dateh_tips').html('迁出时间：');if(this.value==155) $('#dateh_tips').html('死亡时间：');"/>
					</p>
					<p>
					<label id="dateh_tips">发生时间：</label>
					<input name="dateh" class="date required" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${person.dateh}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
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