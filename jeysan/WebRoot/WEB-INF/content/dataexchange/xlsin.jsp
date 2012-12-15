<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<form action="${ctx}/dataexchange/xlsdatain!importFullData.action" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
						<p style="float:left;width:620px">
						<label style="float:left">全员数据导入</label>
						<input style="float:left" id="upload1" name="file" type="file" class="required" accept="xls" size="50"/>
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