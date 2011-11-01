<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<p>
						<a class="button" href="${ctx}/bcmas/doublecheckstat.action?type=1" target="navTab" rel="doublecheckstat1"><span>查环查孕情况汇总表(一)</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/bcmas/doublecheckstat.action?type=2" target="navTab" rel="doublecheckstat2"><span>查环查孕情况汇总表(二)</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/bcmas/doublecheckstat.action?type=3" target="navTab" rel="doublecheckstat3"><span>查环查孕情况汇总表(三)</span></a>
					</p>
				</div>
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