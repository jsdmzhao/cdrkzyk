﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="pageContent">
	<div class="tabs" currentIndex="0" eventType="click">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="${ctx}/bcmas/womanbasic.action?id=${param.id}" class="j-ajax" external="true"><span>育妇基础信息</span></a></li>
					<li><a href="${ctx}/bcmas/womanfiveperiod.action?id=${param.id}" class="j-ajax"><span>五期教育</span></a></li>
					<li><a href="${ctx}/bcmas/womansocialupbring.action?id=${param.id}" class="j-ajax"><span>社会抚养费</span></a></li>
					<li><a href="${ctx}/bcmas/womanupbringdetail.action?id=${param.id}" class="j-ajax"><span>缴交详情</span></a></li>
					<li><a href="${ctx}/bcmas/womanpunish.action?id=${param.id}" class="j-ajax"><span>行政处罚</span></a></li>
					<li><a href="${ctx}/bcmas/womanbearassurance.action?id=${param.id}" class="j-ajax"><span>计划生育保险</span></a></li>
					<li><a href="${ctx}/bcmas/womanmatenal.action?id=${param.id}" class="j-ajax"><span>孕产信息</span></a></li>
					<li><a href="${ctx}/bcmas/womancontracept.action?id=${param.id}" class="j-ajax"><span>避孕节育</span></a></li>
					<li><a href="${ctx}/pmas/womanchildren.action?id=${param.id}" class="j-ajax"><span>子女信息</span></a></li>
					<li><a href="${ctx}/bcmas/womanaward.action?id=${param.id}" class="j-ajax"><span>优待奖励</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent" style="height:503px;">
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>