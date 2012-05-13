<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<form action="${ctx}/datagather/basicdatain!importPoliceData.action" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
						<p style="float:left;width:620px">
						<label style="float:left">公安电子数据</label>
						<input style="float:left" id="upload1" name="file" type="file" class="required" accept="xls" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>

					<form action="${ctx}/datagather/basicdatain!importCivilData.action" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
						<p style="float:left;width:620px">
						<label style="float:left">民政电子数据</label>
						<input style="float:left" id="upload2" name="file" type="file" class="required" accept="xls" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>

					<form action="${ctx}/datagather/basicdatain!importHospital.action" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
						<p style="float:left;width:620px">
						<label style="float:left">医院电子数据</label>
						<input style="float:left" id="upload3" name="file" type="file" class="required" accept="xls" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					
					<form action="${ctx}/datagather/basicdatain!importGmcc.action" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
						<p style="float:left;width:620px">
						<label style="float:left">社保电子数据</label>
						<input style="float:left" id="upload4" name="file" type="file" class="required" accept="xls" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					
					<form action="${ctx}/datagather/basicdatain!importEdudata.action" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
						<p style="float:left;width:620px">
						<label style="float:left">教育电子数据</label>
						<input style="float:left" id="upload5" name="file" type="file" class="required" accept="xls" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					
					<form action="${ctx}/datagather/basicdatain!importCompany.action" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
						<p style="float:left;width:620px">
						<label style="float:left">企业电子数据</label>
						<input style="float:left" id="upload6" name="file" type="file" class="required" accept="xls" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					
					<form action="${ctx}/datagather/basicdatain!importEpistation.action" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
						<p style="float:left;width:620px">
						<label style="float:left">防疫站电子数据</label>
						<input style="float:left" id="upload7" name="file" type="file" class="required" accept="xls" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>

				</div>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
	</div>
</div>