<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					妇女姓名：
				</label>
				<input name="master.dwz_fertileWomanLookup.nameh" type="text"
					size="30" value="${bcs.fertileWoman.nameh}" readonly="readonly" />
			</p>
			<p>
				<label>
					妇女编号：
				</label>
				<input readonly="readonly"
					name="master.dwz_fertileWomanLookup.code_" type="text" size="30"
					value="${bcs.fertileWoman.code}" />
			</p>
			<div class="divider"></div>
			<p>
				<label>
					发证机关：
				</label>
				<input readonly="readonly" name="issOrg" type="text" size="30"
					value="${bcs.issOrg}" />
			</p>
			<p>
				<label>
					发证日期：
				</label>
				<input name="issDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${bcs.issDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					发证机关地址：
				</label>
				<input readonly="readonly" name="issOrgAddress" type="text"
					size="30" value="${bcs.issOrgAddress}" />
			</p>
			<p>
				<label>
					证书编号：
				</label>
				<input readonly="readonly" name="certCode" type="text" size="30"
					value="${bcs.certCode}" />
			</p>
			<p>
				<label>
					邮政编码：
				</label>
				<input readonly="readonly" type="text" size="30" value="${bcs.zipCode}" />
			</p>
			<p>
				<label>
					电话：
				</label>
				<input readonly="readonly" name="tel" type="text" size="30"
					value="${bcs.tel}" />
			</p>
			<p>
				<label>
					经办人：
				</label>
				<input readonly="readonly" name="agent" type="text" size="30"
					value="${bcs.agent}" />
			</p>
			<p>
				<label>
					照片：
				</label>
				<input readonly="readonly" name="photo" type="text" size="30"
					value="${bcs.photo}" />
			</p>
			<div class="divider"></div>
			<p style="width:98%">
				<label>
					内容：
				</label>
				<input name="content" readonly="readonly" type="text" size="100"
					value="${content}" />
			</p>
			<p>
				<label>
					日期：
				</label>
				<input name="dateh" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					经办人：
				</label>
				<input name="agent" readonly="readonly" type="text" size="30"
					value="${agent}" />
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
