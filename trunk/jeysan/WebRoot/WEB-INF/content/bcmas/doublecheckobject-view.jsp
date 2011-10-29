<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					轮次ID：
				</label>
				<input name="dcId" readonly="readonly" type="text" size="30"
					value="${dcId}" />
			</p>
			<p>
				<label>
					妇女ID：
				</label>
				<input name="womanId" readonly="readonly" type="text" size="30"
					value="${womanId}" />
			</p>
			<p>
				<label>
					是否个人：
				</label>
				<input name="issingle" readonly="readonly" type="text" size="30"
					value="${issingle}" />
			</p>
			<p>
				<label>
					年度(主要针对个人)：
				</label>
				<input name="year" readonly="readonly" type="text" size="30"
					value="${year}" />
			</p>
			<p>
				<label>
					本次双查总次数(主要针对个人)：
				</label>
				<input name="total" readonly="readonly" type="text" size="30"
					value="${total}" />
			</p>
			<p>
				<label>
					轮次(主要针对个人)：
				</label>
				<input name="seq" readonly="readonly" type="text" size="30"
					value="${seq}" />
			</p>
			<p>
				<label>
					双查类型：
				</label>
				<input name="typeh" readonly="readonly" type="text" size="30"
					value="${typeh}" />
			</p>
			<p>
				<label>
					双查类型原因：
				</label>
				<input name="cause" readonly="readonly" type="text" size="30"
					value="${cause}" />
			</p>
			<p>
				<label>
					双查起始年月(主要针对个人)：
				</label>
				<input name="start" readonly="readonly" type="text" size="30"
					value="${start}" />
			</p>
			<p>
				<label>
					双查结束年月(主要针对个人)：
				</label>
				<input name="end" readonly="readonly" type="text" size="30"
					value="${end}" />
			</p>
			<p>
				<label>
					双查状态：
				</label>
				<input name="dcStatus" readonly="readonly" type="text" size="30"
					value="${dcStatus}" />
			</p>
			<p>
				<label>
					双查时间：
				</label>
				<input name="dcDate" readonly="readonly" type="text" size="30"
					value="<fmt:formatDate value="${dcDate}" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>
					查环结果：
				</label>
				<input name="dcResult1" readonly="readonly" type="text" size="30"
					value="${dcResult1}" />
			</p>
			<p>
				<label>
					查孕结果：
				</label>
				<input name="dcResult2" readonly="readonly" type="text" size="30"
					value="${dcResult2}" />
			</p>
			<p>
				<label>
					双查医院：
				</label>
				<input name="hospital" readonly="readonly" type="text" size="30"
					value="${hospital}" />
			</p>
			<p>
				<label>
					医院类型：
				</label>
				<input name="hospitalType" readonly="readonly" type="text" size="30"
					value="${hospitalType}" />
			</p>
			<p>
				<label>
					检查医生：
				</label>
				<input name="doctor" readonly="readonly" type="text" size="30"
					value="${doctor}" />
			</p>
			<p>
				<label>
					备注：
				</label>
				<input name="remark" readonly="readonly" type="text" size="30"
					value="${remark}" />
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
