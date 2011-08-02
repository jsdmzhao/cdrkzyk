<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>请假流程流转过程查看</title>
<script src="${ctx4doc}/dwz/javascripts/jquery-1.4.4.js" type="text/javascript"></script>
<script src="${ctx4doc}/js/gcanvas2.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
$(function(){
	for(var ii=0; ii<document.links.length; ii++){
		document.links[ii].onfocus=function(){
			this.blur();
		}
	}
	if ($.browser.msie) {
		$('#canvas').css('top','-70px').css('left','-70px');
	}
});
$(function(){
	<c:if test="${model.wfState!=null}">
	var gc = GCanvas("canvas", 1200, 600);
	gc.fgColor("red");
	gc.fgSize(2);
	<c:if test="${model.wfState!=7}">
	drawRectangle(gc,'level_${model.wfLevel+1}');
	</c:if>
	<c:if test="${model.wfState==7}">
		<c:if test="${model.leaveCount<=3}">
			<c:if test="${model.deptorCheck==13}">
			drawPolyline(gc,'line_1');
			</c:if>
			<c:if test="${model.deptorCheck==12}">
			drawPolyline(gc,'line_2');
			</c:if>
		</c:if>
		<c:if test="${model.leaveCount>3}">
			<c:if test="${model.deptorCheck==12}">
				<c:if test="${model.bossCheck==12}">
				drawPolyline(gc,'line_3');
				</c:if>
				<c:if test="${model.bossCheck==13}">
				drawPolyline(gc,'line_4');
				</c:if>
			</c:if>
			<c:if test="${model.deptorCheck==13}">
			drawPolyline(gc,'line_1');
			</c:if>
		</c:if>
	</c:if>
	</c:if>
});
</script>
<body leftmargin="0" topmargin="0">

<div id="img" style="position:absolute;top:0;left:0">
	<img src="${ctx4doc}/img/wf/LeaveProcess_5.jpg" width="999" height="399" border="0" usemap="#Map" />
	<map name="Map" id="Map">
	  <area id="level_1" shape="rect" coords="46,188,162,246"/>
	  <area id="level_2" shape="rect" coords="232,186,317,246"/>
	  <area id="level_3" shape="rect" coords="458,286,559,346"/>
	
	  <area id="line_1" shape="poly" coords="14,216,204,215,354,214,764,39,984,207"/>
	  <area id="line_2" shape="poly" coords="13,217,202,216,356,215,780,147,983,207"/>
	  <area id="line_3" shape="poly" coords="13,216,204,215,351,215,507,316,634,318,782,253,982,207"/>
	  <area id="line_4" shape="poly" coords="12,216,202,215,350,214,506,316,633,319,774,364,981,208"/>
	</map>
</div>

<div id="canvas" style="position:absolute;top:0;left:0"></div>
</body>
</html>
