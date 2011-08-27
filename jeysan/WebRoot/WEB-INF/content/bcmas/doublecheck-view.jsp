<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					姓名：
				</label>
				<input name="nameh" readonly="readonly" type="text" size="30"
					value="${nameh}" />
			</p>
			<p>
				<label>
					妇女类别：
				</label>
				<input name="typeh" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${typeh}"/>" />
			</p>
			<p>
				<label>
					妇女编码：
				</label>
				<input name="code" readonly="readonly" type="text" size="30"
					value="${code}" />
			</p>
			<p>
				<label>
					所属区域：
				</label>
				<input name="area" readonly="readonly" type="text" size="30"
					value="${area}" />
			</p>
			<p>
				<label>
					婚姻状态：
				</label>
				<input name="marryStatus" readonly="readonly" type="text" size="30"
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
				<input name="age" readonly="readonly" type="text" size="30"
					value="${age}" />
			</p>
			<p>
				<label>
					证件号码：
				</label>
				<input name="certCode" readonly="readonly" type="text" size="30"
					value="${certCode}" />
			</p>
			<p>
				<label>
					户口类别：
				</label>
				<input name="domicileType" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${domicileType}"/>" />
			</p>
			<p>
				<label>
					户口性质：
				</label>
				<input name="househodeKind" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${househodeKind}"/>" />
			</p>
			<p>
				<label>
					职业：
				</label>
				<input name="job" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${job}"/>" />
			</p>
			<p>
				<label>
					工作单位：
				</label>
				<input name="company" readonly="readonly" type="text" size="30"
					value="${company}" />
			</p>
			<p style="width:98%">
				<label>
					现居住地门牌号码：
				</label>
				<input name="houseNo" readonly="readonly" type="text" size="100"
					value="${houseNo}" />
			</p>
<div class="divider"></div>
			<p>
				<label>
					现家庭孩子数：
				</label>
				<input name="childrenCount" readonly="readonly" type="text" size="30"
					value="${boyCount+girlCount}" />
			</p>
			<p>
				<label>
					男孩数：
				</label>
				<input name="boyCount" readonly="readonly" type="text" size="30"
					value="${boyCount}" />
			</p>
			<p>
				<label>
					女孩数：
				</label>
				<input name="girlCount" readonly="readonly" type="text" size="30"
					value="${girlCount}" />
			</p>
<div class="divider"></div>
			<p>
				<label>
					避孕节育措施：
				</label>
				<input name="method" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${method}"/>" />
			</p>
			<p>
				<label>
					未避孕原因：
				</label>
				<input name="noCause" readonly="readonly" type="text" size="30"
					value="${noCause}" />
			</p>
			<p>
				<label>
					落实措施时间：
				</label>
				<input name="opsDate" readonly="readonly" type="text" size="30"
					value="${opsDate}" />
			</p>
<div class="divider"></div>
			<p>
				<label>
					轮次：
				</label>
				<input name="dcId" readonly="readonly" type="text" size="30"
					value="${year}" />
			</p>
			<p>
				<label>
					查环查孕类型：
				</label>
				<input name="dcTypeh" readonly="readonly" type="text" size="30"
					value="<tags:js.dict.getValue value="${dcTypeh}"/>" />
			</p>
			<p>
				<label>
					查环查孕类型原因：
				</label>
				<input name="cause" readonly="readonly" type="text" size="30"
					value="${cause}" />
			</p>
			<p>
				<label>
					查环查孕起始年月：
				</label>
				<input name="start" readonly="readonly" type="text" size="30"
					value="${start}" />
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
