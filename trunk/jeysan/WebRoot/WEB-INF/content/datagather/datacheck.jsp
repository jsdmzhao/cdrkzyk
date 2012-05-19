<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<form action="${ctx}/datagather/datacheck!checkPoliceData.action" method="post" onsubmit="return iframeCallback(this,navTabAjaxDone4Update);">
						<p style="float:left;width:620px">
						<label style="float:left">公安电子数据</label>
					<c:if test="${cm['s0']>0||cm['s1']>0||cm['s2']>0}">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">校验</button></div></div>
					</c:if>
					<c:if test="${cm['s0']==0&&cm['s1']==0&&cm['s2']==0}">
						<div class="buttonDisabled"><div class="buttonContent"><button type="button">校验</button></div></div>
					</c:if>
						<div style="width:100%;color:blue"><ul>
<li>婴儿出生入户情况表：<c:if test="${cm['s0']>0}">新增<font color="red">(${cm['s0']})</font>条</c:if><c:if test="${cm['s0']==0}">暂无新</c:if>记录</li>
<li>人员迁入情况表：<c:if test="${cm['s1']>0}">新增<font color="red">(${cm['s1']})</font>条</c:if><c:if test="${cm['s1']==0}">暂无新</c:if>记录</li>
<li>死亡人员情况表：<c:if test="${cm['s2']>0}">新增<font color="red">(${cm['s2']})</font>条</c:if><c:if test="${cm['s2']==0}">暂无新</c:if>记录</li>
						</ul></div>
						</p>
					</form>

					<form action="${ctx}/datagather/datacheck!checkCivilData.action" method="post" onsubmit="return iframeCallback(this,navTabAjaxDone4Update);">
						<p style="float:left;width:620px">
						<label style="float:left">民政电子数据</label>
					<c:if test="${cm['s3']>0}">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">校验</button></div></div>
					</c:if>
					<c:if test="${cm['s3']==0}">
						<div class="buttonDisabled"><div class="buttonContent"><button type="button">校验</button></div></div>
					</c:if>
						<div style="width:100%;color:blue"><ul>
<li>结婚登记情况表：<c:if test="${cm['s3']>0}">新增<font color="red">(${cm['s3']})</font>条</c:if><c:if test="${cm['s3']==0}">暂无新</c:if>记录</li>
						</ul></div>
						</p>
					</form>

					<form action="${ctx}/datagather/datacheck!checkHospital.action" method="post" onsubmit="return iframeCallback(this,navTabAjaxDone4Update);">
						<p style="float:left;width:620px">
						<label style="float:left">医院电子数据</label>
					<c:if test="${cm['s4']>0||cm['s5']>0||cm['s6']>0||cm['s7']>0}">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">校验</button></div></div>
					</c:if>
					<c:if test="${cm['s5']==0&&cm['s5']==0&&cm['s6']==0&&cm['s7']==0}">
						<div class="buttonDisabled"><div class="buttonContent"><button type="button">校验</button></div></div>
					</c:if>
						<div style="width:100%;color:blue"><ul>
<li>出生情况表：<c:if test="${cm['s4']>0}">新增<font color="red">(${cm['s4']})</font>条</c:if><c:if test="${cm['s4']==0}">暂无新</c:if>记录</li>
<li>四术情况表：<c:if test="${cm['s5']>0}">新增<font color="red">(${cm['s5']})</font>条</c:if><c:if test="${cm['s5']==0}">暂无新</c:if>记录</li>
<li>孕检情况表：<c:if test="${cm['s6']>0}">新增<font color="red">(${cm['s6']})</font>条</c:if><c:if test="${cm['s6']==0}">暂无新</c:if>记录</li>
<li>防疫情况表：<c:if test="${cm['s7']>0}">新增<font color="red">(${cm['s7']})</font>条</c:if><c:if test="${cm['s7']==0}">暂无新</c:if>记录</li>
						</ul></div>
						</p>
					</form>
					
					<form action="${ctx}/datagather/datacheck!checkGmcc.action" method="post" onsubmit="return iframeCallback(this,navTabAjaxDone4Update);">
						<p style="float:left;width:620px">
						<label style="float:left">社保电子数据</label>
					<c:if test="${cm['s8']>0}">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">校验</button></div></div>
					</c:if>
					<c:if test="${cm['s8']==0}">
						<div class="buttonDisabled"><div class="buttonContent"><button type="button">校验</button></div></div>
					</c:if>
						<div style="width:100%;color:blue"><ul>
<li>社保部门情况表：<c:if test="${cm['s8']>0}">新增<font color="red">(${cm['s8']})</font>条</c:if><c:if test="${cm['s8']==0}">暂无新</c:if>记录</li>
						</ul></div>
						</p>
					</form>
					
					<form action="${ctx}/datagather/datacheck!checkEdudata.action" method="post" onsubmit="return iframeCallback(this,navTabAjaxDone4Update);">
						<p style="float:left;width:620px">
						<label style="float:left">教育电子数据</label>
						<div class="buttonDisabled"><div class="buttonContent"><button type="button">校验</button></div></div>
						<div style="width:100%;color:blue"><ul>
<li>教育部门情况表：暂无新记录</li>
						</ul></div>
						</p>
					</form>
					
					<form action="${ctx}/datagather/datacheck!checkCompany.action" method="post" onsubmit="return iframeCallback(this,navTabAjaxDone4Update);">
						<p style="float:left;width:620px">
						<label style="float:left">企业电子数据</label>
					<c:if test="${cm['s9']>0}">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">校验</button></div></div>
					</c:if>
					<c:if test="${cm['s9']==0}">
						<div class="buttonDisabled"><div class="buttonContent"><button type="button">校验</button></div></div>
					</c:if>
						<div style="width:100%;color:blue"><ul>
<li>计划生育情况表：<c:if test="${cm['s9']>0}">新增<font color="red">(${cm['s9']})</font>条</c:if><c:if test="${cm['s9']==0}">暂无新</c:if>记录</li>
						</ul></div>
						</p>
					</form>
					
					<form action="${ctx}/datagather/datacheck!checkEpistation.action" method="post" onsubmit="return iframeCallback(this,navTabAjaxDone4Update);">
						<p style="float:left;width:620px">
						<label style="float:left">防疫站电子数据</label>
					<c:if test="${cm['s10']>0}">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">校验</button></div></div>
					</c:if>
					<c:if test="${cm['s10']==0}">
						<div class="buttonDisabled"><div class="buttonContent"><button type="button">校验</button></div></div>
					</c:if>
						<div style="width:100%;color:blue"><ul>
<li>防疫站情况表：<c:if test="${cm['s10']>0}">新增<font color="red">(${cm['s10']})</font>条</c:if><c:if test="${cm['s10']==0}">暂无新</c:if>记录</li>
						</ul></div>
						</p>
					</form>

				</div>
			</div>
			<div class="formBar">
				<ul>
					<!-- <li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">全部校验</button></div></div>
					</li> -->
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
	</div>
</div>