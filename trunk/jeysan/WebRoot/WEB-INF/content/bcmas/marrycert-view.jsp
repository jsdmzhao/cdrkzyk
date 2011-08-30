<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						姓名：
					</label>
					<input readonly="readonly" name="person.nameh" type="text" size="30"
						value="${person.nameh}" />
				</p>
				<p>
					<label>
						编码：
					</label>
					<input readonly="readonly" name="person.personCode" type="text" size="30"
						value="${person.personCode}" />
				</p>
				<p>
					<label>
						证件号码：
					</label>
					<input readonly="readonly" name="person.code" type="text" size="30"
						value="${person.code}" />
				</p>
<div class="divider"></div>
			<p>
				<label>
					发证机关：
				</label>
				<input name="issOrg" readonly="readonly" type="text" size="30"
					value="${issOrg}" />
			</p>
			<p>
				<label>
					发证日期：
				</label>
				<input name="issDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p style="width:98%">
				<label>
					发证机关地址：
				</label>
				<input name="issOrgAddress" readonly="readonly" type="text"
					size="100" value="${issOrgAddress}" />
			</p>
			<p>
				<label>
					证书编号：
				</label>
				<input name="certCode" readonly="readonly" type="text" size="30"
					value="${certCode}" />
			</p>
			<p>
				<label>
					邮政编码：
				</label>
				<input name="zipCode" readonly="readonly" type="text" size="30"
					value="${zipCode}" />
			</p>
			<p>
				<label>
					电话：
				</label>
				<input name="tel" readonly="readonly" type="text" size="30"
					value="${tel}" />
			</p>
			<p>
				<label>
					有效期：
				</label>
				<input name="validPeriod" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${validPeriod}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					经办人：
				</label>
				<input name="agent" readonly="readonly" type="text" size="30"
					value="${agent}" />
			</p>
			<p>
				<label>
					结婚时间：
				</label>
				<input name="marryDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${marryDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					所在乡（镇、街道）计生办电话：
				</label>
				<input name="fpoTel1" readonly="readonly" type="text" size="30"
					value="${fpoTel1}" />
			</p>
			<p>
				<label>
					配偶所在乡（镇、街道）计生办电话：
				</label>
				<input name="fpoTel2" readonly="readonly" type="text" size="30"
					value="${fpoTel2}" />
			</p>
			<p>
				<label>
					发证时已有子女数（男）：
				</label>
				<input name="beforeBoyCount" readonly="readonly" type="text"
					size="30" value="${beforeBoyCount}" />
			</p>
			<p>
				<label>
					发证时已有子女数（女）：
				</label>
				<input name="beforeGirlCount" readonly="readonly" type="text"
					size="30" value="${beforeGirlCount}" />
			</p>
			<p>
				<label>
					发证后生育子女数（男）：
				</label>
				<input name="afterBoyCount" readonly="readonly" type="text"
					size="30" value="${afterBoyCount}" />
			</p>
			<p>
				<label>
					发证后生育子女数（女）：
				</label>
				<input name="afterGirlCount" readonly="readonly" type="text"
					size="30" value="${afterGirlCount}" />
			</p>
			<p>
				<label>
					照片：
				</label>
				<input name="photo" readonly="readonly" type="text" size="30"
					value="${photo}" />
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
