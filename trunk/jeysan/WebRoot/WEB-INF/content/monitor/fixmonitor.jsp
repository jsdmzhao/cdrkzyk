<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
		
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<p>
						<a class="button" href="${ctx}/monitor/hpmonitor.action?domicileType=<%=Constants.DOMICILE_TYPE.FIX%>" target="navTab" rel="fixmonitor_sub"><span>待双查对象一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/monitor/hpmonitor!findBirth2Applys.action?domicileType=<%=Constants.DOMICILE_TYPE.FIX%>" target="navTab" rel="fixmonitor_sub"><span>待审批计划生育一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/monitor/hpmonitor!viewoverbirth.action" width="900" height="500" target="dialog" rel="fixmonitor_sub"><span>孕产期超七个月对象一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="${ctx}/monitor/hpmonitor!getNoContraception.action" width="900" height="500" target="dialog" rel="fixmonitor_sub"><span>无避孕节育措施一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="fixmonitor_sub"><span>申请缓期节育到期对象清单</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="fixmonitor_sub"><span>应交社会抚养费对象一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="fixmonitor_sub"><span>新增数据待审核一览表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="fixmonitor_sub"><span>下级待完成工作汇总</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="fixmonitor_sub"><span>育龄人员的跟踪管理</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="fixmonitor_sub"><span>怀孕人员的监控跟踪</span></a>
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