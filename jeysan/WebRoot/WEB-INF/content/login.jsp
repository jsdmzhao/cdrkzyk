﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>
<%@ page import="org.springframework.security.web.WebAttributes,com.jeysan.modules.utils.Constants.Application" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><%=Application.PLATFORM_TITLE%></title>
<link href="${ctx4doc}/dwz3/themes/css/login.css" rel="stylesheet" type="text/css" />
<script src="${ctx4doc}/dwz3/js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz3/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${ctx4doc}/js/jscommon2.js" type="text/javascript"></script>
</head>

<body onload="initFocus()">
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="#"><img src="${ctx4doc}/dwz3/themes/default/images/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="javascript:setHomepage()">设为首页</a></li>
						<li><a href="javascript:AddToFavorite()">加入收藏</a></li>
						<!-- <li><a href="#">反馈</a></li>
						<li><a href="#">帮助</a></li> -->
					</ul>
				</div>
				<h2 class="login_title"><img src="${ctx4doc}/dwz3/themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
			<c:if test="${not empty(SPRING_SECURITY_LAST_EXCEPTION)}">
				<div class="error"> ${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
			</c:if>
				<form action="${ctx}/j_spring_security_check" method="post">
					<!-- <p>
						<label>机构码：</label>
						<input type="text" id="j_orgcode" name="j_orgcode" class="login_input"  <c:if test="${not empty(param.error)}">value="${SPRING_SECURITY_LAST_ORGCODE}"</c:if>/>
					</p> -->
					<p>
						<label>用户名：</label>
						<input type="text" id="j_username" name="j_username" size="20" class="login_input" <c:if test="${not empty(param.error)}">value="${SPRING_SECURITY_LAST_USERNAME}"</c:if>/>
					</p>
					<p>
						<label>密&nbsp;&nbsp;&nbsp;码：</label>
						<input type="password" id="j_password" name="j_password" size="20" class="login_input"/>
					</p>
					<p>
						<label>验证码：</label>
						<input name="j_inspect" class="code" type="text" size="5" />
						<span><img src="${ctx}/main/code.action" alt="" width="75" height="24" /></span>
					</p>
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner">
			<div style="float:left;width:631px;height:270px">
			<object
		        classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
		        codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
		        id="login_swf"
		        width="631" height="270"
		      >
		        <param name="movie" value="${ctx4doc}/dwz3/themes/default/images/login.swf">
		        <param name="bgcolor" value="#FFFFFF">
		        <param name="quality" value="high">
		        <param name="seamlesstabbing" value="false">
		        <param name="allowscriptaccess" value="samedomain">
		        <embed
		          type="application/x-shockwave-flash"
		          pluginspage="http://www.adobe.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"
		          name="登录动画"
		          width="631" height="270"
		          src="${ctx4doc}/dwz3/themes/default/images/login.swf"
		          bgcolor="#FFFFFF"
		          quality="high"
		          seamlesstabbing="false"
		          allowscriptaccess="samedomain"
		        >
		          <noembed>
		          </noembed>
		        </embed>
		      </object>
			  </div>
			  <div style="float:left;width:320px;height:270px">
			<img src="${ctx4doc}/dwz3/themes/default/images/login_banner_right.png"/>
			  </div>
			</div>
			<div class="login_main">
				<ul class="helpList">
					<li><a href="${ctx}/print/install_lodop.exe">下载无毒WEB打印插件</a></li>
					<li><a href="${ctx}/help/UserManual.doc">下载帮助文档</a></li>
					<!-- <li><a href="#">忘记密码怎么办？</a></li>
					<li><a href="#">为什么登录失败？</a></li> -->
				</ul><!-- 
				<div class="login_inner">
					<p>界面美观，操作方便</p>
					<p>五种皮肤，自由选择</p>
					<p>易扩展，易升级，易安装</p>
				</div> -->
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; <%=Application.PLATFORM_EXPIRE%>&nbsp;&nbsp;<a href="<%=Application.PLATFORM_SITE%>" target="_blank"><%=Application.PLATFORM_COMPANY%></a>
		</div>
	</div>
</body>
</html>