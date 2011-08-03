<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <HEAD>
  <TITLE>上海卓领Join</TITLE>
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
  <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
  <meta http-equiv="content-type" content="text/html; charset=gbk">
 </HEAD>
<style>
<!--
.ta{font-size:14px;color:#333;margin:0;padding:0}
.on{color:#5680d2;font-weight:bold;}
.td_1{background:url(img/tabimg_01.gif); width:49px;height:24px;float:left;text-align: center;margin:0;padding-top: 5px}
.td_2{background:url(img/tabimg_02.gif); width:49px;height:24px;float:left;text-align: center;margin:0;padding-top: 5px}
.title{width:100%;padding: 2px;font-weight: bold;}
.title_little{width:100%;}
-->
</style>
<script>
var url_address = "http://<%=request.getLocalAddr()%>:<%=request.getLocalPort()%>/<%=request.getContextPath()%>";
var width=434,height=454,format='png',traffic='off';			
var maplevel=2;
var adjust = 0.0002;
var font='宋体,1,15,0xff0cc0,0xffffe0,0';
var cenX=null,cenY=null;
var X=null,Y=null;
var X2=null,Y2=null;
var startName=null,endName=null;
var lines = null;
// 响应onkeypress事件
window.document.onkeypress = function(keyEvent) 
{
	keyEvent = keyEvent ? keyEvent : window.event;
	var keyvalue = keyEvent.which ? keyEvent.which : keyEvent.keyCode;
	keyEventListener(keyvalue);
}
function keyEventListener(keyvalue){
	//document.getElementById("keycode").value = keyvalue;
	// 处理返回键270  首页280
	if( keyvalue == 270 || keyvalue == 8)
	{
		 history.go(-1);
	}
	if( keyvalue == 50 )
	{
		 cenY += getAdjust();
		 refreshMap(cenX,cenY);
	}
	if( keyvalue == 56 )
	{
		 cenY -= getAdjust();
		 refreshMap(cenX,cenY);
	}
	if( keyvalue == 52 )
	{
		 cenX -= getAdjust();
		 refreshMap(cenX,cenY);
	}
	if( keyvalue == 54 )
	{
		 cenX += getAdjust();
		 refreshMap(cenX,cenY);
	}
	if( keyvalue == 49 )
	{
		 if (maplevel > 0) {
			maplevel--;
			refreshMap(cenX,cenY);
		}
	}
	if( keyvalue == 51 )
	{
		 if (maplevel < 17) {
			maplevel++;
			refreshMap(cenX,cenY);
		}
	}
	if( keyvalue == 53 )
	{
		if(traffic=='off')
			traffic = 'on';
		else if(traffic=='on')
			traffic = 'off';
		refreshMap(cenX,cenY);
	}
	if( keyvalue == 55 )
	{
		exchangeSlide();
	}
}
function getAdjust(){
	if(maplevel<=5)
		return adjust*10;
	else if(maplevel<=8)
		return adjust*100;
	else
		return adjust*1000;
}
//标志变量,是搜索兴趣点还是查询路线
var isInitPOIMap = true;
function refreshMap(_cenX,_cenY){
	cenX=_cenX;
	cenY=_cenY;
	if(isInitPOIMap)
		refresh2();
	else
		refresh();
}
//搜索兴趣点
var xs,ys,names;
function refreshNames(_xs,_ys,_names){
	xs = _xs;
	ys = _ys;
	names = _names;
}
function refreshSearchMap(_cenX,_cenY,address,tel,xml,name){//document.getElementById('ss_i_1').value = name;
	cenX = _cenX;
	cenY = _cenY;
	refresh2();
	if(address)
		openPopFac(address,tel,xml,name);
	else
		closePopFac();
}
//搜索兴趣点
function refresh2(){
	document.getElementById("map").src = "img/ajaxloader.gif";
	var url = url_address;
	url += "/searchMap";
	url += "?width="+width;
	url += "&height="+height;
	url += "&format="+format;
	url += "&cenX="+cenX;
	url += "&cenY="+cenY;
	url += "&xs="+xs+"&ys="+ys+"&names="+encodeSC(names);
	url += "&maplevel="+maplevel;
	url += "&traffic="+traffic;
	url += "&font="+encodeSC(font);
	document.getElementById("map").src = url;
}
//公交或者自驾
function refresh(){
	document.getElementById("map").src = "img/ajaxloader.gif";
	var url = url_address;
	url += "/searchLineMap";
	url += "?width="+width;
	url += "&height="+height;
	url += "&format="+format;
	url += "&cenX="+cenX;
	url += "&cenY="+cenY;
	url += "&X="+X;
	url += "&Y="+Y;
	url += "&X2="+X2;
	url += "&Y2="+Y2;
	url += "&lines=0xff0000,2,"+lines;
	url += "&maplevel="+maplevel;
	url += "&traffic="+traffic;
	url += "&font="+encodeSC(font);
	if(startName!=null)
		url += "&startName="+encodeSC(startName);
	if(endName!=null)
		url += "&endName="+encodeSC(endName);
	document.getElementById("map").src = url;
}
function encodeSC(sc){
	if('${jsType}'=='0')
		return encodeURIComponent(sc);//本地
	else if('${jsType}'=='1')
		return encodeURIComponent(sc);//ut/中兴
	else if('${jsType}'=='2')
		return escape(escape(sc));//玉星/同洲 /华为
	return sc;
}
function queryRoute(){
	var startName = document.getElementById("startName").value;
	var endName = document.getElementById("endName").value;
	if(startName == endName)
		return;
	var url = url_address;
	url += "/searchRoute";
	url += "?startName="+startName;
	url += "&endName="+endName;
	if(currentType==2)
		url += "&tripMode=1";//公交
	else if(currentType==3)
		url += "&tripMode=0";//自驾
	//else if(currentType==1)
	//	url += "&tripMode=2";//搜索
	url += "&routeType=2";
	document.getElementById("leftFrame").src = url;
}
/**自驾**/
function refreshMap1(_cenX,_cenY,_X,_Y,_lines){
	if(_lines)
		lines=_lines;
	cenX = _cenX;
	cenY = _cenY;
	X = _cenX;
	Y = _cenY;
	X2 = _X;
	Y2 = _Y;
	startName = null;
	endName = null;
	refresh();
}
/**公交 ..整段的线路**/
function refreshMap2(_lines,_cenX,_cenY,_X,_Y,_startName,_endName){
	lines=_lines;
	cenX = _cenX;
	cenY = _cenY;
	X = _cenX;
	Y = _cenY;
	X2 = _X;
	Y2 = _Y;
	startName = _startName;
	endName = _endName;
	refresh();
}
/**公交 ..分段线路**/
function refreshMap3(_cenX,_cenY,_X,_Y,_startName,_endName){
	cenX = _cenX;
	cenY = _cenY;
	X = _cenX;
	Y = _cenY;
	X2 = _X;
	Y2 = _Y;
	startName = _startName;
	endName = _endName;
	refresh();
}
//当前搜索的入口：1 搜索 2公交 3 自驾
var currentType = 1;
function ss(type){
	currentType = type;
	if(type == 1){
		div1IsBlock = true;
		closePop();
		closePopResult;
	}else{
		closePopFac();
	}
	for(var i=1;i<=3;i++){
		if(type == i){
			document.getElementById("ss_td_"+i).className = "td_1";
			document.getElementById("ss_a_"+i).className = "ta on";
		}else{
			document.getElementById("ss_td_"+i).className = "td_2";
			document.getElementById("ss_a_"+i).className = "ta";
		}
	}
	if(type == 1){
		document.getElementById("ss_div_1").style.display = "block";
		document.getElementById("ss_div_23").style.display = "none";
		showResult(false);
	}else{
		document.getElementById("ss_div_1").style.display = "none";
		document.getElementById("ss_div_23").style.display = "block";
		showResult(true);
	}
}
function showResult(sResult){
	if(sResult){
		document.getElementById("ss_div_result_1").style.display = "none";
		document.getElementById("ss_div_result_23").style.display = "block";
	}else{
		document.getElementById("ss_div_result_1").style.display = "block";
		document.getElementById("ss_div_result_23").style.display = "none";
	}
}
var isShow = true;
function exchangeSlide(){
	if(isShow){
		document.getElementById("div_left").style.display = "none";
		document.getElementById("ss_div_result_23").style.display = "none";
		document.getElementById("div_right").style.left = "0px";
		document.getElementById("div_right").style.width = "638px";
		document.getElementById("popFac").style.left = "168px";
		width = 636;
	}else{
		document.getElementById("div_left").style.display = "block";
		document.getElementById("popFac").style.left = "270px";
		document.getElementById("div_right").style.left = "202px";
		document.getElementById("div_right").style.width = "436px";
		document.getElementById("ss_div_result_"+(div1IsBlock?1:23)).style.display = "block";
		//if(currentType==1) showResult(false);
		//else showResult(true);
		width = 434;
	}
	refreshMap(cenX,cenY);
	isShow = !isShow;
}
//标志变量：分类图层是否可见
var div1IsBlock = true;
/*根据分类查询*/
function searchPOI(kindName){
	div1IsBlock = false;
	isInitPOIMap = true;
	var url = url_address;
	url += "/searchPOI";
	url += "?cityCode=021&searchName="+encodeSC(kindName);
	showResult(true);
	document.getElementById("leftFrame").src = url;
}
/*根据用户选择查询：currentType 1 自定义 2 公交 3 驾车*/
function searchType(){
	if(currentType==1){
		isInitPOIMap = true;
		var ss_i_1_value = document.getElementById('ss_i_1_e').value;
		if(ss_i_1_value!=null&&ss_i_1_value!='')
			searchPOI(ss_i_1_value);
	}else{
		isInitPOIMap = false;
		queryRoute();
	}
}
var msg = null,hasPop = false;
function sendSMS(_msg){
	msg = _msg;
	if(document.getElementById("pop").style.display == 'none'){
		document.getElementById("pop").style.display = 'block';
		document.getElementById("mobilephone").focus();
		hasPop = true;
	}
}
function sendSMS_T(){
	var phoneNo = document.getElementById("mobilephone").value;
	if(phoneNo==null||phoneNo==''||isNaN(phoneNo))
		return;
	var startName_SMS =  document.getElementById("startName");
	var s_SMS = startName_SMS.options[startName_SMS.selectedIndex].text;
	var endName_SMS =  document.getElementById("endName");
	var e_SMS = endName_SMS.options[endName_SMS.selectedIndex].text;
	var url = url_address;
	url += "/sendSMS";
	url += "?phoneNo="+phoneNo;
	url += "&content="+encodeSC("起点:"+s_SMS + ",终点:"+e_SMS + ",建议线路如下:"+msg);
	url += "&date="+new Date().getTime();
	document.getElementById("smsFrame").src = url;
}
//短信提示框
function closePop(){
	document.getElementById("pop").style.display = 'none';
	hasPop = false;
}
function openPopResult(type){
	if(type==1){
		document.getElementById("popResultMsg").innerText = '定制成功';
		document.getElementById("errorMsg").innerText='短信已经发到号码为'+document.getElementById("mobilephone").value+'的手机上';
	}else if(type==0){
		document.getElementById("popResultMsg").innerText = '定制失败';
		document.getElementById("errorMsg").innerText='可能原因:手机号码不正确';
	}
	if(document.getElementById("popResult").style.display == 'none'){
		document.getElementById("popResult").style.display = 'inline';
		document.getElementById("okBtn").focus();
		hasPop = true;
	}
}
function closePopResult(){
	//document.getElementById("pop").style.display = 'none';
	document.getElementById("popResult").style.display = 'none';
	hasPop = false;
}
//商家详细信息提示框
function closePopFac(){
	document.getElementById("popFac").style.display = 'none';
}
function openPopFac(address,tel,xml,name){
	document.getElementById("address").innerText = address;
	document.getElementById("tel").innerText = tel;
	document.getElementById("xml").innerText = xml;
	document.getElementById("name").innerText = name;
	if(document.getElementById("popFac").style.display == 'none')
		document.getElementById("popFac").style.display = 'block';
}
function init(){
	xs = '121.480665';
	ys = '31.233274';
	cenX = 121.480665;
	cenY = 31.233274;
	names = '人民广场';
	refresh2();
	inidKind();
}
var kindArray = ['本帮菜,川菜,粤菜,湘菜,火锅,自助餐,日本菜,韩国料理,西餐,面包甜点,美食',
                 '商场,超市,烟酒,服装,鞋包,珠宝,化妆品,运动户外,母婴儿童,品牌折扣店,数码家电,家居建材,书店,眼镜店',
                 '咖啡厅,酒吧,茶馆,KTV,电影院,文化艺术,景点,公园,足疗按摩,洗浴,游乐游艺,桌球,桌游,DIY手工坊',
				 '银行,证券,旅行社,酒店,培训,装潢,宠物,齿科,快照,搬家,家政,医院,学校',
                 '亲子游乐,早教,幼儿培训,亲子摄影,亲子购物,幼儿园,小学,妇幼医院',
				 '4S店,汽车保险,维修保养,汽车配件,车饰,驾校,汽车租赁,停车场',
                 '南京西路,南京东路,五角场,天山路,中山公园,人民广场,浦东,徐家汇,淮海路,四川路'];
//初始化分类
function inidKind(){
	var hrefStr,kindArray_sub;
	for(var j=0;j<kindArray.length-1;j++){
		hrefStr = '';
		kindArray_sub = kindArray[j].split(',');
		for(var i=0;i<kindArray_sub.length;i++){
			hrefStr += '<a href="javascript:void(0)" onclick="searchPOI(\''+kindArray_sub[i]+'\')">'+kindArray_sub[i]+'</a>&nbsp;';
		}
		document.getElementById('kind_td_'+j).innerHTML = hrefStr;
	}
}
function exchangeSelected(){
	var ss_i_1_s_value = document.getElementById('ss_i_1_s').value;
	var ss_i_1_e = document.getElementById('ss_i_1_e');
	var options = ss_i_1_e.options;
	//Method 1
	document.getElementById('ss_td_1_e').innerHTML = '';
	var kindArray_sub = kindArray[parseInt(ss_i_1_s_value)].split(',');
	var optionStr = '<select name="ss_i_1_e" id="ss_i_1_e" class="input_2">';
	for(var i=0;i<kindArray_sub.length;i++){
		optionStr += '<option value="'+kindArray_sub[i]+'">'+kindArray_sub[i]+'</option>';
	}
	optionStr += '</select>';
	document.getElementById('ss_td_1_e').innerHTML = optionStr;
	//Method 2
	/*while(ss_i_1_e.options.length>0){
		ss_i_1_e.removeChild(options.item(0));
	}
	var kindArray_sub_sub = kindArray_sub[0].split(',');
	for(var i=0;i<kindArray_sub_sub.length;i++){
		createOption(options,kindArray_sub_sub[i],kindArray_sub_sub[i]);
	}*/
}
//Method 2专用，创建下拉框选项：不支持
function createOption(options,text,value){
	var option = document.createElement("OPTION");
	options.add(option);
	option.innerText = text;
	option.value = value;
}
</script>
<body onload="init()">
	<div style="width:640px;height:65px;position: absolute;top: 0px;left: 0px;background:url(img/2011_new_year_header_banner.gif) no-repeat right;">
		<div style="float:left;margin:2px 0 0 5px;width:256px;height:35px;background:url(img/tabimg_03.gif) no-repeat;">
				<div id="ss_div_1" style="position:absolute;left:10px;top:4px;width:100%;">
					<div style="float:left;width:90px;margin-left: 10px">
					<select name="ss_i_1_s" id="ss_i_1_s" onchange="exchangeSelected()">
					<option value="0">美食</option>
					<option value="1">购物</option>
					<option value="2">娱乐</option>
					<option value="3">生活</option>
					<option value="4">亲子</option>
					<option value="5">爱车</option>
					<option value="6" selected="selected">热门商圈</option>
					</select>
					</div>
					<div style="float:left;width:90px;margin-left: 30px" id="ss_td_1_e">
					<select name="ss_i_1_e" id="ss_i_1_e">
					<option value="南京西路" selected="selected">南京西路</option>
					<option value="南京东路">南京东路</option>
					<option value="五角场">五角场</option>
					<option value="天山路">天山路</option>
					<option value="中山公园">中山公园</option>
					<option value="人民广场">人民广场</option>
					<option value="浦东">浦东</option>
					<option value="徐家汇">徐家汇</option>
					<option value="淮海路">淮海路</option>
					<option value="四川路">四川路</option>
					</select>
					</div>
				</div>
				<div id="ss_div_23" style="position:absolute;left:10px;top:4px;width:100%;display: none;">
					<div style="float:left;width:90px;margin-left: 10px">
					<select name="startName">
					<option value="121.419996,31.222641" selected="selected">中山公园</option>
					<option value="121.608481,31.200268">张江高科</option>
					<option value="121.512758,31.232723">东昌路</option>
					<option value="121.542339,31.248686">浦东大道</option>
					<option value="121.361858,31.212060">淞虹路</option>
					<option value="121.480665,31.233274">人民广场</option>
					<option value="121.447237,31.224226">静安寺</option>
					<option value="121.433658,31.223459">徐家汇</option>
					</select>
					</div>
					<div style="float:left;width:90px;margin-left: 30px">
					<select name="endName">
					<option value="121.419996,31.222641">中山公园</option>
					<option value="121.608481,31.200268">张江高科</option>
					<option value="121.512758,31.232723">东昌路</option>
					<option value="121.542339,31.248686">浦东大道</option>
					<option value="121.361858,31.212060">淞虹路</option>
					<option value="121.480665,31.233274" selected="selected">人民广场</option>
					<option value="121.447237,31.224226">静安寺</option>
					<option value="121.433658,31.223459">徐家汇</option>
					</select>
					</div>
				</div>
		</div>
	</div>
		<div style="position:absolute;left:270px;top:4px;width:49px;height:28px;">
			<a href="javascript:void(0)" onclick="searchType()"><img style="border:0" src="img/search.gif"></a>
		</div>
		<div style="position:absolute;left:20px;top:30px;width:500px;height:23px;">
			<div class="td_1" id="ss_td_1"><a id="ss_a_1" href="javascript:ss(1)" class="ta on">搜索</a></div>
			<div style="float:left;width:10px"></div>
			<div class="td_2" id="ss_td_2"><a id="ss_a_2" href="javascript:ss(2)" class="ta">公交</a></div>
			<div style="float:left;width:10px"></div>
			<div class="td_2" id="ss_td_3"><a id="ss_a_3" href="javascript:ss(3)" class="ta">驾车</a></div>
		</div>
		<div style="position:absolute;left:200px;top:45px;width:330px;height:28px;">
<marquee behavior="alternate" direction="left" scrollAmount="1" scrollDelay="10" onMouseOver="this.stop();" onMouseOut="this.start();">
			<a href="javascript:void(0)" onclick="javascript:void(0)">五一国际劳动节，全场让利大促销</a>
</marquee>
		</div>
	<div id="div_left" style="width:198px;height:485px;position: absolute;top: 65px;left: 0px;border:1px solid #3b6ac4;">
		<div id="ss_div_result_1" style="width:198px;height:483px">
			<div style="width:100%;height:27px;padding: 5px;font-weight: bold;background: url(img/title2.gif)">热门分类</div>
			<div class="title">美食</div>
			<div class="title_little" id="kind_td_0"></div>
			<div class="title">购物</div>
			<div class="title_little" id="kind_td_1"></div>
			<div class="title">娱乐</div>
			<div class="title_little" id="kind_td_2"></div>
			<div class="title">生活</div>
			<div class="title_little" id="kind_td_3"></div>
			<div class="title">亲子</div>
			<div class="title_little" id="kind_td_4"></div>
			<div class="title">爱车</div>
			<div class="title_little" id="kind_td_5"></div>
		</div>
		<div id="ss_div_result_23" style="width:198px;height:483px;display: none">
			<div style="width:100%;height:483px"><iframe height="483" width="100%" border="0" frameborder="0" src="" name="leftFrame" id="leftFrame" title="leftFrame" scrolling="no"></iframe></div>
		</div>
	</div>
	<div id="div_right" style="width:436px;height:485px;position: absolute;top: 65px;left: 202px;border:1px solid #3b6ac4;">
		<div style="float:left;width:100%;height:27px;background: url('img/title2.gif')">
			<div style="float:right;margin-top:6px;color:blue;font-size:14px;text-align: right">2向上 4向左 8向下 6向右 1放大 3缩小 5实时路况 7全屏</div>			
		</div>
		<div style="float:left;width:434px;height:454px"><img src="img/ajaxloader.gif" name="map"></div>
	</div>


<div id="pop" style="width:300px;height:110px;background: url('img/pop_bg2.png') no-repeat;position: absolute;left:240px;top:145px;float:left;display:none">
<div style="width:300px;height:32px;">
<div style="float:left;font-size:14px;color:#ffffff;margin:10px 0px 0px 35px;font-weight:bold;width:225px">请输入手机号码</div><div style="float:right;margin:5px 10px 0px 0px;width:16px"><img src="img/close.png" style="cursor:pointer" onclick="javascript:closePop()"/></div>
</div>
<div style="width:300px;height:76px;font-size:13px;color:#000000;margin-top:15px">
&nbsp;<input type="text" name="mobilephone" style="width:200px;height:30px"/> <input style="width:50px;height:30px" type="button" value="发送" onclick="javascript:sendSMS_T()"/>
</div>
<iframe height="0" width="0" border="0" frameborder="0" src="" name="smsFrame" id="smsFrame" title="smsFrame"></iframe>
</div>
<div id="popResult" style="width:300px;height:110px;background: url('img/pop_bg2.png') no-repeat;position: absolute;left:240px;top:145px;float:left;display:none">
<div style="width:300px;height:32px;">
<div style="float:left;font-size:14px;color:#ffffff;margin:10px 0px 0px 35px;font-weight:bold;width:225px"><span id="popResultMsg" name="popResultMsg"></span></div><div style="float:right;margin:5px 10px 0px 0px;width:16px"><img src="img/close.png" style="cursor:pointer" onclick="javascript:closePopResult()"/></div>
</div>
<div style="width:300px;height:76px;font-size:13px;color:#000000;margin-top:15px">
<div style="float:left;margin-left:15px;width:200px;height:60px" id="errorMsg"></div>
<div style="float:left">
<input style="width:50px;height:30px;float:left;margin-left:10px;margin-top:10px" type="button" value="确定" onclick="javascript:closePopResult()" id="okBtn"/>
</div>
</div>
</div>

<div id="popFac" style="width:300px;height:128px;background: url('img/pop_bg.png') no-repeat;position: absolute;left:270px;top:185px;float:left;display:none">
<div style="width:300px;height:32px;">
<div style="float:left;font-size:14px;color:#ffffff;margin:10px 0px 0px 10px;font-weight:bold;width:250px"><span id="name">A.星巴克</span></div><div style="float:right;margin:5px 10px 0px 0px;width:16px"><img src="img/close.png" style="cursor:pointer" onclick="javascript:closePopFac()"/></div>
</div>
<div style="width:300px;height:76px;font-size:13px;color:#000000">
<div style="margin:5px 0px 0px 5px">地址：<span id="address">长宁路999号多媒体生活广场1层</span></div>
<div style="margin:5px 0px 0px 5px">电话：<span id="tel">021-52410325</span></div>
<div style="margin:5px 0px 0px 5px">描述：<span id="xml">021-52410325</span></div>
</div>
</div>


</body>
</html>