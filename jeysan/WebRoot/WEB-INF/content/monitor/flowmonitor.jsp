<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<p>
						<a class="button" href="${ctx}/monitor/hpmonitor.action?domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowmonitor_sub"><span>待双查对象一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowmonitor_sub"><span>无避孕节育措施一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowmonitor_sub"><span>应持证无持证对象一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowmonitor_sub"><span>应交社会抚养费对象一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowmonitor_sub"><span>应重新验证对象一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowmonitor_sub"><span>应反馈对象一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowmonitor_sub"><span>新增数据待审核一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowmonitor_sub"><span>下级待完成工作汇总</span></a>
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