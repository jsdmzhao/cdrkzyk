<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<script>
function ok(){
	navTabAjaxDone4Update(
			{navTabId:'nav_womanchildrenmanage',message:'操作成功',action:'${id==null?1:2}',statusCode:'200'}
	);
}
</script>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/pmas/womanchildren!save.action"
			 enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,ok);">
			<input type="hidden" name="id" value="${id}" />
			<!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId"
				value="nav_womanchildrenmanage" />
			<input type="hidden" name="person.id" value="${person.id}" />
			<div class="pageFormContent" layoutH="56">
				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						${person.sex==1?'父亲':'母亲'}信息：
					</h2>
				</div>
				<p>
					<label>
						姓名：
					</label>
					<input type="text" size="30" value="${person.nameh}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						人员编码：
					</label>
					<input type="text" size="30" value="${person.personCode}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						出生日期：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${person.personBasic.birthday}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						年龄：
					</label>
					<input type="text" size="30" value="${person.age}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						证件类型：
					</label>
					<input type="text" size="30"
						value="<tags:js.dict.getValue value="${person.certType}" />"
						readonly="readonly" />
				</p>
				<p>
					<label>
						证件号码：
					</label>
					<input type="text" size="30" value="${person.code}"
						readonly="readonly" />
				</p>
				<p>
					<label>
						户口类别：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.dict.getValue value="${person.domicileType}"/>" />
				</p>

				<div style="float: left; width: 98%;">
					<h2 class="contentTitle">
						子女信息：
					</h2>
				</div>

				<p>
					<label>
						姓名：
					</label>
					<input class="required" name="nameh" type="text" size="30"
						value="${nameh}" />
				</p>
				<p>
					<label>
						性别：
					</label>
					<tags:js.dict.selector name="sex" class1="required" value="${sex}"
						dictCode="JS010" />
				</p>
				<p>
					<label>
						出生日期：
					</label>
					<input name="birthday" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						出生地点：
					</label>
					<input name="birthAddress" type="text" size="30"
						value="${birthAddress}" />
				</p>
				<p>
					<label>
						民族：
					</label>
					<tags:js.dict.selector name="native" value="${native}"
						dictCode="JS1044" />
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
					<img width="200" height="120" src="${ctx}/${photo}" />
				</p>
				<p>
					<label>
						政策内外：
					</label>
					<tags:js.dict.selector name="policy" class1="required"
						value="${policy}" dictCode="JS1037" />
				</p>
				<p>
					<label>
						政策外类型：
					</label>
					<tags:js.dict.selector name="outType" class1="required"
						value="${outType}" dictCode="JS1059" />
				</p>
				<p>
					<label>
						孩次：
					</label>
					<input name="childIndex" class="digits" type="text" size="30"
						value="${childIndex}" />
				</p>
				<p>
					<label>
						出生证号：
					</label>
					<input name="birthCert" type="text" size="30" value="${birthCert}" />
				</p>
				<p>
					<label>
						健康状况：
					</label>
					<tags:js.dict.selector name="healthStatus" class1="required"
						value="${healthStatus}" dictCode="JS1060" />
				</p>
				<p>
					<label>
						血缘关系：
					</label>
					<tags:js.dict.selector name="kinship" class1="required"
						value="${kinship}" dictCode="JS1061" />
				</p>
				<p>
					<label>
						变化日期：
					</label>
					<input name="changeDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${changeDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						变化原因：
					</label>
					<input name="changeCause" type="text" size="30"
						value="${changeCause}" />
				</p>
				<p>
					<label>
						出生医院名称：
					</label>
					<input name="hospital" type="text" size="30" value="${hospital}" />
				</p>
				<p>
					<label>
						出生医院类型：
					</label>
					<tags:js.dict.selector name="hospitalType" class1="required"
						value="${hospitalType}" dictCode="JS1053" />
				</p>
				<p>
					<label>
						收养日期：
					</label>
					<input name="adoptDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate " readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${adoptDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						收养证号：
					</label>
					<input name="adoptCept" type="text" size="30" value="${adoptCept}" />
				</p>
				<div class="divider"></div>
				<p>
					<label>
						上报日期：
					</label>
					<input name="upDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate required" readonly="readonly"
						type="text" size="30"
						value="<fmt:formatDate value="${upDate}" pattern="yyyy-MM-dd"/>" />
					
				</p>
				<p>
					<label>
						备注：
					</label>
					<input name="remark" type="text" size="30" value="${remark}" />
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