<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>所属字典：</label>
					<input name="dictId" readonly="readonly" type="text" size="30" value="${dictId}"/>
					</p>
																														<p>
					<label>子项名称：</label>
					<input name="subName" readonly="readonly" type="text" size="30" value="${subName}"/>
					</p>
																														<p>
					<label>子项编码：</label>
					<input name="subCode" readonly="readonly" type="text" size="30" value="${subCode}"/>
					</p>
																														<p>
					<label>子项颜色：</label>
					<input name="subColor" readonly="readonly" type="text" size="30" value="${subColor}"/>
					</p>
																														<p>
					<label>子项描述：</label>
					<input name="subInfo" readonly="readonly" type="text" size="30" value="${subInfo}"/>
					</p>
																														<p>
					<label>子项序号：</label>
					<input name="subIndex" readonly="readonly" type="text" size="30" value="${subIndex}"/>
					</p>
																		</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>
