<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>爱地图-公交查询-数字线路结果</title>
<link href="${ctx}/css/theme.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/js/imap.js"></script>
<script type="text/javascript" src="${ctx}/js/map_operate.js"></script>
<script type="text/javascript">
function backLine(){
	window.location = '${ctx}/traffic/bus?method=${params['isText']!='1'?'getBusLine4Numeric':'getBusLineByName&isText=1'}&queryBusName='+encodeSC('${jsType}','${params['queryBusName']}')+'&busName='+encodeSC('${jsType}','${psline.name}')+'&upOrDown=${params['upOrDown']!='1'?1:0}';
}
</script>
</head>
<body>
<div class="absolute container2" style="top:0;left:0;">
	<!--title-->
<div class="left" style="width:100%; height:22px">
    	<div class="left title_h2">公交查询结果</div>
		<c:if test="${params['isText']=='1'}">
		<div class="right"><div class="button_4"><a href="${ctx}/pages/line/bus_text.html">返回前页</a></div></div>
		</c:if>
        <div class="right" style="margin-right:10px"><div class="button_4"><a href="${ctx}/index.html">返回首页</a></div></div>
    </div>
    <div class="left hr" style="margin-top:10px;width:100%;"></div>
    <!--查询条件-->
<div class="left youhui" style="width:100%; height:25px; line-height:25px">
        <a class="left">${params['queryBusName']}</a>
		<c:forEach var="a" items="${pslines}">
		<a href="${ctx}/traffic/bus?method=getBusLine4Numeric&queryBusName=${params['queryBusName']}&busName=${a.name}&upOrDown=0" class="left" style="margin-left:20px">${a.name}</a>
		</c:forEach>
    </div>
    <div class="left hr" style="margin-top:10px;width:100%;"></div>
    <!--根据首字母或者历史记录查询的结果-->
  	<div class="left" style="width:100%;height:398px">
	  <div class="left" style="width:100%;">上海<span class=" title_h2">${psline.name}</span>公交车线路
	  </div>
      <div class="left" style="width:100%; font-size:14px; margin-top:5px; line-height:23px">售票方式：${psline.saleMode=='0'?'人工售票':'自动售票'}◇${psline.price}◇发车间隔(分钟)：${psline.busInterval}◇换乘优惠：${psline.discount=='0'?'有':'无'}◇所属公司：${psline.company}</div>
        <div class="left youhui" style="width:100%;font-size:14px; margin-top:15px; line-height:23px">
        	<span class="left title_h2">${startBusStand.name}→${endBusStand.name}方向</span>
			<span class="left" style="margin-left:10px">时间：${psline.businessHours}</span>
            <a href="javascript:openI('${ctx}/map?method=preMap&type=multiply&lineId=${params['upOrDown']!='1'?(psline.abcUpLine):(psline.abcDownLine)}','',638,528,0,0)" class="right" style="margin-left:10px">电子地图</a>
            <a href="javascript:backLine()" class="right">${params['upOrDown']!='1'?'返程线路':'正向线路'}</a>
            
		</div>
<tags:pagination4full inBodyId="bus_states" items="${busStands}">
    <div class="left youhui" style="width:580px; height:244px;overflow:hidden">
        <div id="bus_states"  name="bus_states" class="left">
		<c:forEach var="a" items="${busStands}" varStatus="b">
    	<div class="left search_result_3"><a href="javascript:openI('${ctx}/map?method=preMap&type=single&name='+encodeSC('${jsType}','${a.name}')+'&x=${a.x}&y=${a.y}','',638,528,0,0)">${b.index+1}<img class="noborder" src="${ctx}/images/transparent.png" style="width:20px;height:5px;"/>${a.name}</a></div>
        </c:forEach>
        </div>
    </div>
</tags:pagination4full>
    </div>
    <!--操作提示-->
    <div class="left operator_tips" style="width:100%;height:40px"><iframe id="frm_operator_tips" name="frm_operator_tips" allowtransparency="true" width="100%" height="100%" scrolling="no" src="${ctx}/pages/operator_tips.html" frameborder="0"></iframe></div>
</div>
<jsp:include page="/pages/iframe.jsp" flush="true"></jsp:include>
</body>
</html>
