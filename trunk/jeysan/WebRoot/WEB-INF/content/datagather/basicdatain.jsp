<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<form action="${ctx}/policedata!import.action" method="post" onsubmit="return navTabSearch(this)">
						<p style="float:left;width:620px">
						<label style="float:left">公安电子数据</label>
						<input style="float:left" id="upload1" name="upload1" type="file" class="required" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					<div class="divider"></div>

					<form action="${ctx}/civildata!import.action" method="post" onsubmit="return navTabSearch(this)">
						<p style="float:left;width:620px">
						<label style="float:left">民政电子数据</label>
						<input style="float:left" id="upload2" name="upload2" type="file" class="required" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					<div class="divider"></div>

					<form action="${ctx}/hospitaldata!import.action" method="post" onsubmit="return navTabSearch(this)">
						<p style="float:left;width:620px">
						<label style="float:left">医院电子数据</label>
						<input style="float:left" id="upload3" name="upload3" type="file" class="required" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					<div class="divider"></div>
					
					<form action="${ctx}/gmccdata!import.action" method="post" onsubmit="return navTabSearch(this)">
						<p style="float:left;width:620px">
						<label style="float:left">社保电子数据</label>
						<input style="float:left" id="upload4" name="upload4" type="file" class="required" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					<div class="divider"></div>
					
					<form action="${ctx}/edudata!import.action" method="post" onsubmit="return navTabSearch(this)">
						<p style="float:left;width:620px">
						<label style="float:left">教育电子数据</label>
						<input style="float:left" id="upload5" name="upload5" type="file" class="required" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					<div class="divider"></div>
					
					<form action="${ctx}/companydata!import.action" method="post" onsubmit="return navTabSearch(this)">
						<p style="float:left;width:620px">
						<label style="float:left">企业电子数据</label>
						<input style="float:left" id="upload6" name="upload6" type="file" class="required" size="50"/>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div>
						</p>
					</form>
					<div class="divider"></div>
					
					<form action="${ctx}/epistationdata!import.action" method="post" onsubmit="return navTabSearch(this)">
						<p style="float:left;width:620px">
						<label style="float:left">防疫站电子数据</label>
						<input style="float:left" id="upload7" name="upload7" type="file" class="required" size="50"/>
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