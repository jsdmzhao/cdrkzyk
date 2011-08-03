<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
																													<p>
					<label>轮次ID：</label>
					<input name="detailId" readonly="readonly" type="text" size="30" value="${detailId}"/>
					</p>
																														<p>
					<label>对象种类：</label>
					<input name="objType" readonly="readonly" type="text" size="30" value="${objType}"/>
					</p>
																														<p>
					<label>WOMAN_ID：</label>
					<input name="womanId" readonly="readonly" type="text" size="30" value="${womanId}"/>
					</p>
																														<p>
					<label>双查情况：</label>
					<input name="dcStatus" readonly="readonly" type="text" size="30" value="${dcStatus}"/>
					</p>
																														<p>
					<label>双查时间：</label>
					<input name="dcDate" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${dcDate}" pattern="yyyy-MM-dd"/>"/>
					</p>
																														<p>
					<label>查环结果：</label>
					<input name="dcResult1" readonly="readonly" type="text" size="30" value="${dcResult1}"/>
					</p>
																														<p>
					<label>查孕结果：</label>
					<input name="dcResult2" readonly="readonly" type="text" size="30" value="${dcResult2}"/>
					</p>
																														<p>
					<label>双查医院：</label>
					<input name="hospital" readonly="readonly" type="text" size="30" value="${hospital}"/>
					</p>
																														<p>
					<label>医院类型：</label>
					<input name="hospitalType" readonly="readonly" type="text" size="30" value="${hospitalType}"/>
					</p>
																														<p>
					<label>检查医生：</label>
					<input name="doctor" readonly="readonly" type="text" size="30" value="${doctor}"/>
					</p>
																														<p>
					<label>备注：</label>
					<input name="remark" readonly="readonly" type="text" size="30" value="${remark}"/>
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
