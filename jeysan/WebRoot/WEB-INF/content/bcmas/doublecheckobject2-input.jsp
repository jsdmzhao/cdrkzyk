<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post"
			action="${ctx}/bcmas/doublecheckobject!save2.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${model.id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_doublecheckobject2manage" />
			<div class="pageFormContent" layoutH="56">
				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						整体双查信息
					</h2>
				</div>

				<p>
					<label>
						年度：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${dc.year}" />
				</p>
				<p>
					<label>
						双查总次数：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${dc.total}" />
				</p>
<div class="divider"></div>
<c:forEach var="a" items="${dcs}">
				<p>
					<label>
						第${a.seq}轮&nbsp;&nbsp;起始年月：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${a.start}" />
				</p>
				<p>
					<label>
						结束年月：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${a.end}" />
				</p>
</c:forEach>
<div class="divider"></div>
				<p>
					<label>
						本次轮次：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${dc.seq}" />
				</p>
<div class="divider"></div>
				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						个人双查信息
					</h2>
				</div>
				<p>
					<label>
						名称：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${model.fertileWoman.nameh}" />
				</p>
				<p>
					<label>
						建卡时间：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${model.fertileWoman.createDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						编码：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${model.fertileWoman.code}" />
				</p>
				<p>
					<label>
						是否整体轮次：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.yes.no.getValue value="${model.issingle}"/>" />
				</p>
				<p>
					<label>
						双查类型：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${model.typeh}"/>" />
				</p>
				<p>
					<label>
						双查类型原因：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.cause}" />
				</p>
				<p>
					<label>
						双查起始年月：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.start}" />
				</p>
				<p>
					<label>
						双查结束年月：
					</label>
					<input readonly="readonly" type="text" size="30" value="${model.end}" />
				</p>
<div class="divider"></div>
				<p>
					<label>
						双查时间：
					</label>
					<input name="dcDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${model.dcDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						查环结果：
					</label>
					<tags:js.dict.selector name="dcResult1" class1="required"  value="${model.dcResult1}" dictCode="JS1077"/>
				</p>
				<p>
					<label>
						查孕结果：
					</label>
					<tags:js.dict.selector name="dcResult2" class1="required"  value="${model.dcResult2}" dictCode="JS1078"/>
				</p>
				<p>
					<label>
						双查医院：
					</label>
					<input name="hospital" type="text" size="30" value="${model.hospital}" />
				</p>
				<p>
					<label>
						医院类型：
					</label>
					<tags:js.dict.selector name="hospitalType" value="${model.hospitalType}" dictCode="JS1053"/>
				</p>
				<p>
					<label>
						检查医生：
					</label>
					<input name="doctor" type="text" size="30" value="${model.doctor}" />
				</p>
				<p>
					<label>
						备注：
					</label>
					<input name="remark" type="text" size="30" value="${model.remark}" />
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