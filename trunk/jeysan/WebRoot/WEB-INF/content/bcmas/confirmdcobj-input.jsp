<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${ctx}/bcmas/confirmdcobj!save.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone4Update);">
			<input type="hidden" name="id" value="${id}"/><!-- 
			<input type="hidden" name="result4Json.callbackType" value="closeCurrent"/> -->
			<input type="hidden" name="result4Json.navTabId" value="nav_confirmdcobjmanage"/>
			<div class="pageFormContent" layoutH="56">
																												<p>
					<label>轮次ID：</label>
					<input name="detailId" class="digits  required" type="text" size="30" value="${detailId}"/>
					</p>
																													<p>
					<label>对象种类：</label>
					<input name="objType" class="digits" type="text" size="30" value="${objType}"/>
					</p>
																													<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" class="digits" type="text" size="30" value="${womanId}"/>
					</p>
																													<p>
					<label>双查情况：</label>
					<input name="dcStatus" class="digits" type="text" size="30" value="${dcStatus}"/>
					</p>
																													<p>
					<label>双查时间：</label>
					<input name="dcDate" class="date " readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dcDate}" pattern="yyyy-MM-dd"/>"/><a class="inputDateButton" href="javascript:void(0)">选择</a>
					</p>
																													<p>
					<label>查环结果：</label>
					<input name="dcResult1" class="digits" type="text" size="30" value="${dcResult1}"/>
					</p>
																													<p>
					<label>查孕结果：</label>
					<input name="dcResult2" class="digits" type="text" size="30" value="${dcResult2}"/>
					</p>
																													<p>
					<label>双查医院：</label>
					<input name="hospital"    type="text" size="30" value="${hospital}" />
					</p>
																													<p>
					<label>医院类型：</label>
					<input name="hospitalType" class="digits" type="text" size="30" value="${hospitalType}"/>
					</p>
																													<p>
					<label>检查医生：</label>
					<input name="doctor"    type="text" size="30" value="${doctor}" />
					</p>
																													<p>
					<label>备注：</label>
					<input name="remark"    type="text" size="30" value="${remark}" />
					</p>
																	</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>