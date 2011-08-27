<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/doublecheck!save.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="noPre" value="yes" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_doublecheckmanage" />
			<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					姓名：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${nameh}" />
			</p>
			<p>
				<label>
					妇女类别：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${typeh}"/>" />
			</p>
			<p>
				<label>
					妇女编码：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${code}" />
			</p>
			<p>
				<label>
					所属区域：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${area}" />
			</p>
			<p>
				<label>
					婚姻状态：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${marryStatus}"/>" />
			</p>
			<p>
				<label>
					夫婚姻状态：
				</label>
				<input name="spouseMarryStatus" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${spouseMarryStatus}"/>" />
			</p>
			<p>
				<label>
					年龄：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${age}" />
			</p>
			<p>
				<label>
					证件号码：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${certCode}" />
			</p>
			<p>
				<label>
					户口类别：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${domicileType}"/>" />
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
					工作单位：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${company}" />
			</p>
			<p style="width:98%">
				<label>
					现居住地门牌号码：
				</label>
				<input readonly="readonly" type="text" size="100"
					value="${houseNo}" />
			</p>
<div class="divider"></div>
			<p>
				<label>
					现家庭孩子数：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${boyCount+girlCount}" />
			</p>
			<p>
				<label>
					男孩数：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${boyCount}" />
			</p>
			<p>
				<label>
					女孩数：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${girlCount}" />
			</p>
<div class="divider"></div>
			<p>
				<label>
					避孕节育措施：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${method}"/>" />
			</p>
			<p>
				<label>
					未避孕原因：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${noCause}" />
			</p>
			<p>
				<label>
					落实措施时间：
				</label>
				<input readonly="readonly" type="text" size="30"
					value="${opsDate}" />
			</p>

<div class="divider"></div>
			<p>
				<label>
					轮次：
				</label>
				<select style="width:100px" name="dcId" class="required combox">
					<option value="">请选择</option>
					<c:forEach var="a" items="${dcs}">
					<option value="${a.id}" <c:if test="${a.id==dcId}">selected="selected"</c:if>>${a.year}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>
					查环查孕类型：
				</label>
				<tags:js.dict.selector class1="required" name="dcTypeh" value="${dcTypeh}" dictCode="JS1016"/>
			</p>
			<p>
				<label>
					查环查孕类型原因：
				</label>
				<input name="cause" type="text" size="30"  class="required"
					value="${cause}" />
			</p>
			<p>
				<label>
					查环查孕起始年月：
				</label>
				<input class="Wdate"  onclick="WdatePicker({dateFmt:'yyyy-MM'})" name="start" type="text" size="30"
					value="${start}" />
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