<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>三杰通用管理平台</title>

<link href="${ctx4doc}/dwz/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx4doc}/dwz/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="${ctx4doc}/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" />
<!--[if IE]>
<link href="${ctx4doc}/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="${ctx4doc}/dwz/javascripts/speedup.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz/javascripts/jquery-1.4.4.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz/javascripts/jquery.cookie.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz/javascripts/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz/javascripts/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz/xheditor/xheditor-zh-cn.min.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz/uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz/uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>

<script src="${ctx4doc}/dwz/bin/dwz.min.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz/javascripts/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${ctx4doc}/js/jscommon.js" type="text/javascript"></script>
<script src="${ctx4doc}/js/query.js" type="text/javascript"></script>

<script src="${ctx4doc}/js/json2.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("${ctx4doc}/dwz/dwz.frag.xml", {
		loginUrl:"${ctx}/j_spring_security_logout",
		debug:false,
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"});
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
					<li id="switchEnvBox"><a href="javascript:">（<span>北京</span>）切换角色</a>
						<ul>
							<li><a href="sidebar_bj.html">北京</a></li>
							<li><a href="sidebar_sh.html">上海</a></li>
							<li><a href="sidebar_sh.html">南京</a></li>
							<li><a href="sidebar_sh.html">深圳</a></li>
							<li><a href="sidebar_sh.html">广州</a></li>
							<li><a href="sidebar_sh.html">天津</a></li>
							<li><a href="sidebar_sh.html">杭州</a></li>
						</ul>
					</li>
					<li><a href="${ctx}/main/changepwd.action" target="dialog">修改密码</a></li>
					<li><a href="javascript:void(0)">系统配置</a></li>
					<li><a href="http://bbs.dwzjs.com" target="_blank">论坛</a></li>
					<li><a href="javascript:void(0)">设为首页</a></li>
					<li><a href="javascript:void(0)">帮助</a></li>
					<li><a href="${ctx}/j_spring_security_logout">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
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
					<div class="accordionHeader">
						<h2><span>Folder</span>日常办公</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="tabsPage.html" target="navTab">邮件系统</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">外收邮件</a></li>
									<li><a href="demo_page4.html" target="navTab" rel="page1">撰写邮件</a></li>
									<li><a href="demo_page1.html" target="navTab" rel="page1" flesh="false">已发邮件</a></li>
									<li><a href="demo_page2.html" target="navTab" rel="page2">已存邮件</a></li>
									<li><a href="demo_page4.html" target="navTab" rel="page3" title="页面三（自定义标签名）">已删邮件</a></li>
								</ul>
							</li>
							
							<li><a>工作处理</a>
								<ul>
									<li><a href="w_panel.html" target="navTab" rel="w_panel">待处理流程</a></li>
									<li><a href="w_tabs.html" target="navTab" rel="w_tabs">已处理流程</a></li>
									<li><a href="w_dialog.html" target="navTab" rel="w_dialog">发起流程</a></li>
								</ul>
							</li>
							<li><a href="dwz.frag.xml" target="navTab" rel="w_panel1">通知通报</a></li>		
							<li><a href="dwz.frag.xml" target="navTab" rel="w_panel1">待办事宜</a></li>
							<li><a href="dwz.frag.xml" target="navTab" rel="w_panel2">备忘录/提醒</a></li>
							<li><a href="dwz.frag.xml" target="navTab" rel="w_panel1">通讯录</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>人力资源管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="newPage1.html" target="navTab" rel="dlg_page2">人员管理</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>设备管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="newPage1.html" target="navTab" rel="dlg_page2">车辆管理</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>项目管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="newPage1.html" target="navTab" rel="dlg_page2">结合图管理</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="${ctx}/security/org.action" target="navTab" rel="nav_orgmanage">机构管理</a></li>
							<li><a href="${ctx}/security/user.action" target="navTab" rel="nav_usermanage">用户管理</a></li>
							<li><a href="${ctx}/security/role.action" target="navTab" rel="nav_rolemanage">角色管理</a></li>
							<li><a href="${ctx}/security/resource.action" target="navTab" rel="nav_resourcemanage">资源管理</a></li>
							<li><a href="${ctx}/security/dict.action" target="navTab" rel="nav_dictmanage">字典管理</a></li>
							<li><a href="${ctx}/security/dictsub.action" target="navTab" rel="nav_dictSubmanage">字典子项管理</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">流程自定义</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>实用工具集</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">系统配置</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">天气预报</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">完美日历</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">站内聊天</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">聊天室</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">论坛</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>代码生成器</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="${ctx}/cg/table!conf.action" target="navTab" rel="nav_projec_config">项目配置</a></li>
							<li><a href="${ctx}/cg/table.action" target="navTab" rel="nav_table_manage">表格管理</a></li>
						</ul>
					</div>
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
							
						</div>
						<div class="pageFormContent" layoutH="80">
							
<div class="divider"></div>
<h2>常见问题及解决:</h2>
<pre style="margin:5px;line-height:1.4em">
Error loading XML document: dwz.frag.xml
直接用IE打开index.html弹出一个对话框：Error loading XML document: dwz.frag.xml
原因：没有加载成功dwz.frag.xml。IE ajax laod本地文件有限制, 是ie安全级别的问题, 不是框架的问题。
解决方法：用firefox打开或部署到apache下。

IIS不能使用Ajax解决方案
IIS下firebug调试报错ajax 405 Method Not Allowed。
Http 405原因是IIS不允许ajax访问*.htm或是*.html后缀的网页，这是IIS的问题，不是框架bug。
</pre>

<div class="divider"></div>
<h2>有偿服务请联系:</h2>
<p style="color:red">ajie25@sina.com</p>
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