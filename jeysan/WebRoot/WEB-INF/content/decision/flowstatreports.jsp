<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<p>
						<a class="button" href="${ctx}/decision/flowstatreports.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=1" target="navTab" rel="flowstatreports_sub"><span>统计表1-期间计划生育情况统计表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowstatreports.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=2" target="navTab" rel="flowstatreports_sub"><span>统计表2-期间人口自然变动及女性初婚情况统计表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowstatreports.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=3" target="navTab" rel="flowstatreports_sub"><span>统计表3-期间已婚育龄夫妇节育情况统计表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowstatreports.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=4" target="navTab" rel="flowstatreports_sub"><span>统计表4-期间分孩次落实节育措施情况统计表</span></a>
					</p><!-- 
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowstatreports_sub"><span>流动人口计划生育情况表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowstatreports_sub"><span>本省流入人员持证情况表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowstatreports_sub"><span>外省流入人员持证情况表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowstatreports_sub"><span>流出人员计划生育情况表</span></a>
					</p> -->
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowbasicquery_sub"><span>流出人员流量分析</span></a>
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