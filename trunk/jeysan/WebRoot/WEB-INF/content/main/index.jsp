<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title><%=com.jeysan.modules.utils.Constants.Application.PLATFORM_TITLE%></title>

<link href="${ctx4doc}/dwz2/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx4doc}/dwz2/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="${ctx4doc}/dwz2/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" />
<!--[if IE]>
<link href="${ctx4doc}/dwz2/themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="${ctx4doc}/dwz2/javascripts/speedup.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz2/javascripts/jquery-1.4.4.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz2/javascripts/jquery.cookie.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz2/javascripts/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz2/javascripts/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz2/xheditor/xheditor-zh-cn.min.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz2/uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz2/uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>

<script src="${ctx4doc}/dwz2/bin/dwz.min.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz2/javascripts/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${ctx4doc}/js/jscommon2.js" type="text/javascript"></script>
<script src="${ctx4doc}/js/plugin.js" type="text/javascript"></script>
<script src="${ctx4doc}/js/query.js" type="text/javascript"></script>

<script src="${ctx4doc}/js/json2.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	DWZ.init("${ctx4doc}/dwz2/dwz.frag.xml", {
		loginUrl:"${ctx}/j_spring_security_logout",
		debug:false,
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"${ctx4doc}/dwz2/themes"});
		}
	});
});
//清理浏览器内存,只对IE起效,FF不需要
if ($.browser.msie) {
	window.setInterval("CollectGarbage();", 10000);
}
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)">标志</a>
				<ul class="nav">
					<li><a href="${ctx}/security/changepwd.action" target="dialog">修改密码</a></li>
					<li><a href="javascript:void(0)" target="_blank">论坛</a></li>
					<li><a href="javascript:setHomepage()">设为首页</a></li>
					<li><a href="javascript:AddToFavorite()">加入收藏夹</a></li>
					<li><a href="javascript:void(0)">帮助</a></li>
					<li><a href="${ctx}/j_spring_security_logout">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
				<div class="accordion" fillSpace="sidebar">
					<c:forEach items="${_js_hasResources}" var="a" varStatus="b">
						<div class="accordionHeader">
							<h2><span>Folder</span>${a.key.resourceName}</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
								<c:forEach items="${a.value}" var="c" varStatus="d">
								<li>
									<c:choose>
										<c:when test="${c.resourceCode=='1007'}">
										<a>${c.resourceName}</a>
										<ul>
											<li><a href="${ctx}/${c.resourceValue}?type=0" target="navTab" rel="nav_${c.entityName}manage">待处理流程</a></li>
											<li><a href="${ctx}/${c.resourceValue}?type=1" target="navTab" rel="nav_${c.entityName}manage">已处理流程</a></li>
										</ul>
										</c:when>
										<c:when test="${c.resourceCode=='55003'}">
										<a>${c.resourceName}</a>
										<ul>
											<li><a href="${ctx}/bcmas/firstchildreg.action" target="navTab" rel="nav_firstchildregmanage">一孩登记</a></li>
											<li><a href="${ctx}/bcmas/birth2apply.action" target="navTab" rel="nav_birth2applymanage">再生育申请</a></li>
											<li><a href="${ctx}/bcmas/birth2check.action" target="navTab" rel="nav_birth2checkmanage">再生育审批</a></li>
											<li><a href="${ctx}/bcmas/getiud.action" target="navTab" rel="nav_getiudmanage">取环管理</a></li>
										</ul>
										</c:when>
										<c:when test="${c.resourceCode=='55004'}">
										<a>${c.resourceName}</a>
										<ul>
											<li><a href="${ctx}/bcmas/doublecheck.action" target="navTab" rel="nav_doublecheckmanage">确定双查轮次</a></li>
											<li><a href="${ctx}/bcmas/confirmdcobj.action?type=0" target="navTab" rel="nav_confirmdcobjmanage_1">确定双查对象</a></li>
											<li><a href="${ctx}/bcmas/confirmdcobj.action?type=1" target="navTab" rel="nav_confirmdcobjmanage_2">登记检查结果</a></li>
											<li><a href="${ctx}/bcmas/lostreg.action" target="navTab" rel="nav_lostregmanage">漏查登记</a></li>
											<li><a href="${ctx}/bcmas/doublecheckstat.action" target="navTab" rel="nav_doublecheckstatmanage">双查汇总</a></li>
										</ul>
										</c:when>
										<c:when test="${c.resourceCode=='55006'}">
										<a>${c.resourceName}</a>
										<ul>
											<li><a href="${ctx}/bcmas/marrycert.action" target="navTab" rel="nav_marrycertmanage">婚育证明</a></li>
											<li><a href="${ctx}/bcmas/toccert.action" target="navTab" rel="nav_toccertmanage">独生子女光荣证</a></li>
											<li><a href="${ctx}/bcmas/bcscert.action" target="navTab" rel="nav_bcscertmanage">计划生育服务证</a></li>
											<li><a href="${ctx}/bcmas/bcscertcheck.action" target="navTab" rel="nav_bcscertcheckmanage">计划生育服务证查验</a></li>
										</ul>
										</c:when>
										<c:when test="${c.resourceCode=='55007'}">
										<a>${c.resourceName}</a>
										<ul>
											<li><a href="${ctx}/pmas/personbasic.action?type=0" target="navTab" rel="nav_cancelmanage_0">超龄注销</a></li>
											<li><a href="${ctx}/pmas/personbasic.action?type=1" target="navTab" rel="nav_cancelmanage_1">死亡注销</a></li>
											<li><a href="${ctx}/pmas/personbasic.action?type=2" target="navTab" rel="nav_cancelmanage_2">迁出注销</a></li>
											<li><a href="${ctx}/pmas/personbasic.action?type=3" target="navTab" rel="nav_cancelmanage_3">恢复注销</a></li>
										</ul>
										</c:when>
										<c:otherwise>
											<a href="${ctx}/${c.resourceValue}" target="navTab" rel="nav_${c.entityName}manage">${c.resourceName}</a>
										</c:otherwise>
									</c:choose>
								</li>
								</c:forEach>
							</ul>
						</div>
					</c:forEach>
				</div>

			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent">
					<div>
						<div class="accountInfo">
							<p><span>${_js_user.userName}，您好！</span></p>
						</div>
						<div class="pageFormContent" layoutH="80" style="width:100%;">
							<div style="width:600px;position: absolute;top:10px;left:10px">
								<div class="panel collapse" minH="100" defH="200">
									<h1>我的工作区</h1>
									<div>
										<p>O(∩_∩)O~~</p>
									</div>
								</div>
								<div class="panel collapse" minH="100" defH="150" style="margin-top: 10px">
									<h1>我的消息</h1>
									<div>
										<p>O(∩_∩)O~~</p>
									</div>
								</div>
							</div>
							<div style="width:430px;position: absolute;top:10px;left:620px">
								<div class="panel collapse" minH="100" defH="200">
									<h1>单位通报</h1>
									<div>
										<p>O(∩_∩)O~~</p>
									</div>
								</div>
								<div class="panel collapse" minH="100" defH="150" style="margin-top: 10px">
									<h1>行业法律法规</h1>
									<div>
										<p>O(∩_∩)O~~</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="taskbar" style="left:0px; display:none;">
			<div class="taskbarContent">
				<ul></ul>
			</div>
			<div class="taskbarLeft taskbarLeftDisabled" style="display:none;">taskbarLeft</div>
			<div class="taskbarRight" style="display:none;">taskbarRight</div>
		</div>
		<div id="splitBar"></div>
		<div id="splitBarProxy"></div>
	</div>

	<div id="footer">Copyright &copy; 2011 <a href="http://www.jeysan.com" target="navTab" rel="jeysan">三杰软件</a></div>

<!--拖动效果-->
	<div class="resizable"></div>
<!--阴影-->
	<div class="shadow" style="width:508px; top:148px; left:296px;">
		<div class="shadow_h">
			<div class="shadow_h_l"></div>
			<div class="shadow_h_r"></div>
			<div class="shadow_h_c"></div>
		</div>
		<div class="shadow_c">
			<div class="shadow_c_l" style="height:296px;"></div>
			<div class="shadow_c_r" style="height:296px;"></div>
			<div class="shadow_c_c" style="height:296px;"></div>
		</div>
		<div class="shadow_f">
			<div class="shadow_f_l"></div>
			<div class="shadow_f_r"></div>
			<div class="shadow_f_c"></div>
		</div>
	</div>
	<!--遮盖屏幕-->
	<div id="alertBackground" class="alertBackground"></div>
	<div id="dialogBackground" class="dialogBackground"></div>

	<div id='background' class='background'></div>
	<div id='progressBar' class='progressBar'>数据加载中，请稍等...</div>

<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-16716654-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? ' https://ssl' : ' http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

</body>
</html>