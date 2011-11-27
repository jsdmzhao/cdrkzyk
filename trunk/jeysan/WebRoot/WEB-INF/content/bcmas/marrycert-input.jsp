<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<script>
function ok(){
	navTabAjaxDone4Update(
			{navTabId:'nav_marrycertmanage',message:'操作成功',action:'${id==null?1:2}',statusCode:'200'}
	);
}
</script>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/marrycert!save.action"
			enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,ok);">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="master.dwz_personLookup.personId" value="${person.id}"/>
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_marrycertmanage" />
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>
						姓名：
					</label>
					<input class="required" name="master.dwz_personLookup.nameh" readonly="readonly" type="text" size="30"
						value="${person.nameh}" />
					<a class="btnLook" href="${ctx}/pmas/person!list4lookup.action" lookupGroup="master" lookupName="personLookup">查找人员</a>
				</p>
				<p>
					<label>
						编码：
					</label>
					<input name="master.dwz_personLookup.personCode" readonly="readonly" type="text" size="30"
						value="${person.personCode}" />
				</p>
				<p>
					<label>
						证件号码：
					</label>
					<input name="master.dwz_personLookup.code" readonly="readonly" type="text" size="30"
						value="${person.code}" />
				</p>
<div class="divider"></div>
				<p>
					<label>
						发证机关：
					</label>
					<input name="issOrg" class="required" type="text" size="30" value="${issOrg}" />
				</p>
				<p>
					<label>
						发证日期：
					</label>
					<input name="issDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly" type="text"
						size="30"
						value="<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p style="width:98%">
					<label>
						发证机关地址：
					</label>
					<input name="issOrgAddress" type="text" size="100"
						value="${issOrgAddress}" />
				</p>
				<p>
					<label>
						证书编号：
					</label>
					<input name="certCode" class="required" type="text" size="30" value="${certCode}" />
				</p>
				<p>
					<label>
						证书类型：
					</label>
					<tags:js.dict.selector name="issType" class1="required"  value="${issType}" dictCode="JS1073"/>
				</p>
				<p>
					<label>
						邮政编码：
					</label>
					<input name="zipCode" type="text" size="30" value="${zipCode}" />
				</p>
				<p>
					<label>
						电话：
					</label>
					<input name="tel" type="text" size="30" value="${tel}" />
				</p>
				<p>
					<label>
						有效期：
					</label>
					<input name="validPeriod" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${validPeriod}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						经办人：
					</label>
					<input name="agent" type="text" size="30" value="${agent}" />
				</p>
				<p>
					<label>
						结婚时间：
					</label>
					<input name="marryDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${marryDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						所在乡（镇、街道）计生办电话：
					</label>
					<input name="fpoTel1" type="text" size="30" value="${fpoTel1}" />
				</p>
				<p>
					<label>
						配偶所在乡（镇、街道）计生办电话：
					</label>
					<input name="fpoTel2" type="text" size="30" value="${fpoTel2}" />
				</p>
				<p>
					<label>
						发证时已有子女数（男）：
					</label>
					<input name="beforeBoyCount" class="digits" type="text" size="30"
						value="${beforeBoyCount}" />
				</p>
				<p>
					<label>
						发证时已有子女数（女）：
					</label>
					<input name="beforeGirlCount" class="digits" type="text" size="30"
						value="${beforeGirlCount}" />
				</p>
				<p>
					<label>
						发证后生育子女数（男）：
					</label>
					<input name="afterBoyCount" class="digits" type="text" size="30"
						value="${afterBoyCount}" />
				</p>
				<p>
					<label>
						发证后生育子女数（女）：
					</label>
					<input name="afterGirlCount" class="digits" type="text" size="30"
						value="${afterGirlCount}" />
				</p>
				<p style="width: 98%;">
					<label>
						照片：
					</label>
					<input name="photo_" type="file" size="30" />
				</p>
				<p style="width: 98%; height: 120px">
					<label>
						照片预览：
					</label>
					<img width="202" height="143" src="${ctx}/${photo}" />
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