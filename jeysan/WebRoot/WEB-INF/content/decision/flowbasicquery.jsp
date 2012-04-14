<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<ul class="tree treeFolder collapse">
						<li><a href="javascript:">流动人口基本查询</a>
							<ul>
								<li><a href="javascript:">流动人口基本情况查询</a>
									<ul>
										<li><a href="${ctx}/decision/flowbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">流入人员基本信息</a></li>
										<li><a href="${ctx}/decision/flowbasicquery2view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">流出人员基本信息</a></li>
										<!-- <li><a href="javascript:" target="navTab" rel="flowbasicquery_sub">流入重复人员信息</a></li> -->
									</ul>
								</li>
								<li><a href="javascript:">子女情况查询</a>
									<ul>
										<li><a href="${ctx}/decision/flowbasicquery3view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=1" target="navTab" rel="flowbasicquery_sub">生育子女情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery3view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=2" target="navTab" rel="flowbasicquery_sub">子女出生情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery4view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">符合生育政策人员情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery5view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">孕产情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery6view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">社会抚养费征收情况</a></li>
									</ul>
								</li>
								<li><a href="javascript:">避孕节育</a>
									<ul>
										<li><a href="${ctx}/decision/flowbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=1" target="navTab" rel="flowbasicquery_sub">当前夫妇避孕节育情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=2" target="navTab" rel="flowbasicquery_sub">未落实结扎上环情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=3" target="navTab" rel="flowbasicquery_sub">应落实补救措施情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=4" target="navTab" rel="flowbasicquery_sub">有子女未避孕人员情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=5" target="navTab" rel="flowbasicquery_sub">计划生育手术情况</a></li>
									</ul>
								</li>
								<li><a href="javascript:">证件情况查询</a>
									<ul>
										<li><a href="${ctx}/decision/flowbasicquery8view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=1" target="navTab" rel="flowbasicquery_sub">流入人员持证验证情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery8view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=2" target="navTab" rel="flowbasicquery_sub">流入人员应办证情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery8view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>&type=3" target="navTab" rel="flowbasicquery_sub">办理国证临时证情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery9view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">流出人员办证情况</a></li>
										<li><a href="${ctx}/decision/flowbasicquery10view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">行政处罚情况</a></li>
									</ul>
								</li>
								<li><a href="javascript:">居住地情况查询</a>
									<ul>
										<li><a href="${ctx}/pmas/house.action?type=1" target="navTab" rel="flowbasicquery_sub">居住地基本信息</a></li>
										<li><a href="${ctx}/decision/flowbasicquery11view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">居住人员情况息</a></li>
										<li><a href="${ctx}/pmas/house.action?type=2" target="navTab" rel="flowbasicquery_sub">业主情况</a></li>
									</ul>
								</li>
								<li><a href="javascript:">地区分布情况查询</a>
									<ul>
										<li><a href="${ctx}/decision/flowbasicquery12view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">来源情况查询</a></li>
										<li><a href="${ctx}/decision/flowbasicquery13view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">来源地分布查询</a></li>
									</ul>
								</li>
								<li><a href="javascript:">注销情况查询</a>
									<ul>
										<li><a href="${ctx}/decision/flowbasicquery14view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">已注销流入人员查询</a></li>
										<li><a href="${ctx}/decision/flowbasicquery15view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FLOW%>" target="navTab" rel="flowbasicquery_sub">已注销流出人员查询</a></li>
									</ul>
								</li>
							</ul>
						</li>
					</ul>
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