<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<p>
						<a class="button" href="${ctx}/decision/flowbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub"><span>流动人口基本情况查询之流入人员基本信息</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowbasicquery2view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub"><span>流动人口基本情况查询之流出人员基本信息</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowbasicquery_sub"><span>流动人口基本情况查询之流入重复人员信息</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowbasicquery3view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=1" target="navTab" rel="flowbasicquery_sub"><span>子女情况查询之生育子女情况</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowbasicquery3view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=2" target="navTab" rel="flowbasicquery_sub"><span>子女情况查询之子女出生情况</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowbasicquery4view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub"><span>子女情况查询之符合生育政策人员情况</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowbasicquery5view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub"><span>子女情况查询之孕产情况</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowbasicquery6view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub"><span>子女情况查询之社会抚养费征收情况</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/decision/flowbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub"><span>避孕节育之当前夫妇避孕节育情况</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowbasicquery_sub"><span>信息通报与反馈情况查询</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowbasicquery_sub"><span>证件情况查询</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowbasicquery_sub"><span>居住地情况查询</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowbasicquery_sub"><span>地区分布情况查询</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="flowbasicquery_sub"><span>注销情况查询</span></a>
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