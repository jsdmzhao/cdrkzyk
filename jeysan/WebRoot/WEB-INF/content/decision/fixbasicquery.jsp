<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.jeysan.cpf.util.Constants"%>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
				<ul class="tree treeFolder collapse">
					<li><a href="javascript:">户籍人口基本查询</a>
						<ul>
							<li><a href="javascript:">育龄妇女基本情况查询</a>
								<ul>
									<li><a href="${ctx}/decision/fixbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1" target="navTab" rel="fixbasicquery_sub">按育妇编码、地址、姓名</a></li>
									<li><a href="${ctx}/decision/fixbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2" target="navTab" rel="fixbasicquery_sub">育妇出生年月分年龄</a></li>
									<li><a href="${ctx}/decision/fixbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=3" target="navTab" rel="fixbasicquery_sub">按育妇及丈夫户口性质</a></li>
									<li><a href="${ctx}/decision/fixbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=4" target="navTab" rel="fixbasicquery_sub">按育妇职业类型</a></li>
									<li><a href="${ctx}/decision/fixbasicquery2view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&hasAccept=1" target="navTab" rel="fixbasicquery_sub">按育妇接受五期教育</a></li>
									<li><a href="${ctx}/decision/fixbasicquery4view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&isTake=1" target="navTab" rel="fixbasicquery_sub">按参加社会保险情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=7" target="navTab" rel="fixbasicquery_sub">按育妇及丈夫政治面貌</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">按育妇迁入情况</a></li> -->
									<li><a href="${ctx}/decision/fixbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=9" target="navTab" rel="fixbasicquery_sub">已注销人员基本情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=10" target="navTab" rel="fixbasicquery_sub">育妇新增、变更情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery1view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=11" target="navTab" rel="fixbasicquery_sub">重复人口查询</a></li>
								</ul>
							</li>
						
							<li><a href="javascript:">安排生育情况查询</a>
								<ul>
									<li><a href="${ctx}/decision/fixbasicquery6view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1" target="navTab" rel="fixbasicquery_sub">按年份查安排生育情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery6view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2" target="navTab" rel="fixbasicquery_sub">安排生育未生情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery6view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=3" target="navTab" rel="fixbasicquery_sub">已安排生育无孩无措施情况</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">已婚无孩育妇情况</a></li> -->
									<li><a href="${ctx}/decision/fixbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1" target="navTab" rel="fixbasicquery_sub">安排生育二孩情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2" target="navTab" rel="fixbasicquery_sub">二孩生育审批情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery8view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>" target="navTab" rel="fixbasicquery_sub">取环、停药具、复通情况</a></li>
								</ul>
							</li>
						
							<li><a href="javascript:">育龄妇女婚姻孕产查询</a>
								<ul>
									<li><a href="${ctx}/decision/fixbasicquery9view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1" target="navTab" rel="fixbasicquery_sub">育妇婚姻状况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery9view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2" target="navTab" rel="fixbasicquery_sub">育妇初婚年龄情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery10view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1" target="navTab" rel="fixbasicquery_sub">育妇当年孕产动态</a></li>
									<li><a href="${ctx}/decision/fixbasicquery10view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2" target="navTab" rel="fixbasicquery_sub">按年月查补救措施情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery10view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=3" target="navTab" rel="fixbasicquery_sub">按年月查死产、补救措施一情况</a></li>
								</ul>
							</li>
						
							<li><a href="javascript:">育龄妇女避孕节育情况查询</a>
								<ul>
									<li><a href="${ctx}/decision/fixbasicquery11view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>" target="navTab" rel="fixbasicquery_sub">各时期需要查环查孕情况</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">未落实结扎上环对象情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">应落实补救措施对象情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">二孩及以上有病未结扎情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">按年月分孩次查各种避孕情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">当前夫妇现有避孕情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">分孩次避孕失败情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">按子女出生年月查避孕情况</a></li>-->
									<li><a href="${ctx}/decision/fixbasicquery10view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=4" target="navTab" rel="fixbasicquery_sub">按育妇年龄查避孕情况</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">查环查孕次数设定情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">节育措施及时率</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">节育措施落实率查询</a></li>-->
								</ul>
							</li>
						
							<li><a href="javascript:">政策外生育、征款查询</a>
								<ul>
									<li><a href="${ctx}/decision/fixbasicquery12view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1&filter_EQI_policy=291" target="navTab" rel="fixbasicquery_sub">政策外出生子女情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery12view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2&filter_EQI_policy=291&filter_EQI_politicalStatus=665" target="navTab" rel="fixbasicquery_sub">党员政策外出生子女情况</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">应缴交社会抚养费情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">社会抚养费征收情况</a></li>
									<li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">社会抚养费征收情况汇总</a></li>-->
								</ul>
							</li>
						
							<li><a href="javascript:">家庭子女出生情况查询</a>
								<ul>
									<li><a href="${ctx}/decision/fixbasicquery9view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=3" target="navTab" rel="fixbasicquery_sub">按现有家庭子女数</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">按子女性别</a></li> -->
									<li><a href="${ctx}/decision/fixbasicquery12view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=3" target="navTab" rel="fixbasicquery_sub">按子女血缘关系</a></li>
									<li><a href="${ctx}/decision/fixbasicquery12view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=4" target="navTab" rel="fixbasicquery_sub">按上报年月查育妇生育情况</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">按育妇年龄段查子女出生间隔</a></li> -->
									<li><a href="${ctx}/decision/fixbasicquery12view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=5" target="navTab" rel="fixbasicquery_sub">按妇女初婚后生育间隔</a></li>
									<li><a href="${ctx}/decision/fixbasicquery12view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=6" target="navTab" rel="fixbasicquery_sub">按年份查总和生育率</a></li>
									<li><a href="${ctx}/decision/fixbasicquery12view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=7&filter_EQI_miss=1" target="navTab" rel="fixbasicquery_sub">历年漏报查询</a></li>
								</ul>
							</li>
						
							<li><a href="javascript:">证件办理情况查询</a>
								<ul>
									<li><a href="${ctx}/decision/fixbasicquery14view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1" target="navTab" rel="fixbasicquery_sub">按年月查光荣证情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery14view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2" target="navTab" rel="fixbasicquery_sub">现有领光荣证情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery13view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>" target="navTab" rel="fixbasicquery_sub">现有一孩未领光荣证情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery15view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>" target="navTab" rel="fixbasicquery_sub">领取流动人口婚育证明情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery16view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1&filter_EQI_notake=0" target="navTab" rel="fixbasicquery_sub">计划生育服务证发放情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery17view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&filter_EQI_typeh=1" target="navTab" rel="fixbasicquery_sub">计划生育服务证变更废止情况</a></li>
								</ul>
							</li>
						
							<li><a href="javascript:">基层常用统计资料查询</a>
								<ul>
									<li><a href="${ctx}/decision/fixbasicquery7view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=3" target="navTab" rel="fixbasicquery_sub">查符合政策安排生育二孩</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">四术登记情况</a></li>-->
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">未及时落实四术情况</a></li>-->
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">子女出生情况</a></li>-->
									<li><a href="${ctx}/decision/fixbasicquery18view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=1&filter_EQL_childnum=1" target="navTab" rel="fixbasicquery_sub">光荣证及养老保险办理</a></li>
									<li><a href="${ctx}/decision/fixbasicquery18view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2&filter_EQL_childnum=2&filter_EQI_sex2=2" target="navTab" rel="fixbasicquery_sub">纯二女户养老保险办理</a></li>
									<li><a href="${ctx}/decision/fixbasicquery16view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>&p_type=2&filter_EQI_notake=0" target="navTab" rel="fixbasicquery_sub">领计划生育服务证情况</a></li>
									<!-- <li><a href="javascript:" target="navTab" rel="fixbasicquery_sub">征收社会抚养费情况</a></li>-->
									<li><a href="${ctx}/decision/fixbasicquery19view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>" target="navTab" rel="fixbasicquery_sub">结婚登记情况</a></li>
									<li><a href="${ctx}/decision/fixbasicquery20view.action?filter_EQI_domicileType=<%=Constants.DOMICILE_TYPE.FIX%>" target="navTab" rel="fixbasicquery_sub">死亡登记情况</a></li>
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