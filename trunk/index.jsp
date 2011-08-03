<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <HEAD>
  <TITLE>�Ϻ�׿��Join</TITLE>
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
var font='����,1,15,0xff0cc0,0xffffe0,0';
var cenX=null,cenY=null;
var X=null,Y=null;
var X2=null,Y2=null;
var startName=null,endName=null;
var lines = null;
// ��Ӧonkeypress�¼�
window.document.onkeypress = function(keyEvent) 
{
	keyEvent = keyEvent ? keyEvent : window.event;
	var keyvalue = keyEvent.which ? keyEvent.which : keyEvent.keyCode;
	keyEventListener(keyvalue);
}
function keyEventListener(keyvalue){
	//document.getElementById("keycode").value = keyvalue;
	// �����ؼ�270  ��ҳ280
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
//��־����,��������Ȥ�㻹�ǲ�ѯ·��
var isInitPOIMap = true;
function refreshMap(_cenX,_cenY){
	cenX=_cenX;
	cenY=_cenY;
	if(isInitPOIMap)
		refresh2();
	else
		refresh();
}
//������Ȥ��
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
//������Ȥ��
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
//���������Լ�
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
		return encodeURIComponent(sc);//����
	else if('${jsType}'=='1')
		return encodeURIComponent(sc);//ut/����
	else if('${jsType}'=='2')
		return escape(escape(sc));//����/ͬ�� /��Ϊ
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
		url += "&tripMode=1";//����
	else if(currentType==3)
		url += "&tripMode=0";//�Լ�
	//else if(currentType==1)
	//	url += "&tripMode=2";//����
	url += "&routeType=2";
	document.getElementById("leftFrame").src = url;
}
/**�Լ�**/
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
/**���� ..���ε���·**/
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
/**���� ..�ֶ���·**/
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
//��ǰ��������ڣ�1 ���� 2���� 3 �Լ�
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
//��־����������ͼ���Ƿ�ɼ�
var div1IsBlock = true;
/*���ݷ����ѯ*/
function searchPOI(kindName){
	div1IsBlock = false;
	isInitPOIMap = true;
	var url = url_address;
	url += "/searchPOI";
	url += "?cityCode=021&searchName="+encodeSC(kindName);
	showResult(true);
	document.getElementById("leftFrame").src = url;
}
/*�����û�ѡ���ѯ��currentType 1 �Զ��� 2 ���� 3 �ݳ�*/
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
	url += "&content="+encodeSC("���:"+s_SMS + ",�յ�:"+e_SMS + ",������·����:"+msg);
	url += "&date="+new Date().getTime();
	document.getElementById("smsFrame").src = url;
}
//������ʾ��
function closePop(){
	document.getElementById("pop").style.display = 'none';
	hasPop = false;
}
function openPopResult(type){
	if(type==1){
		document.getElementById("popResultMsg").innerText = '���Ƴɹ�';
		document.getElementById("errorMsg").innerText='�����Ѿ���������Ϊ'+document.getElementById("mobilephone").value+'���ֻ���';
	}else if(type==0){
		document.getElementById("popResultMsg").innerText = '����ʧ��';
		document.getElementById("errorMsg").innerText='����ԭ��:�ֻ����벻��ȷ';
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
//�̼���ϸ��Ϣ��ʾ��
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
	names = '����㳡';
	refresh2();
	inidKind();
}
var kindArray = ['�����,����,����,���,���,������,�ձ���,��������,����,������,��ʳ',
                 '�̳�,����,�̾�,��װ,Ь��,�鱦,��ױƷ,�˶�����,ĸӤ��ͯ,Ʒ���ۿ۵�,����ҵ�,�Ҿӽ���,���,�۾���',
                 '������,�ư�,���,KTV,��ӰԺ,�Ļ�����,����,��԰,���ư�Ħ,ϴԡ,��������,����,����,DIY�ֹ���',
				 '����,֤ȯ,������,�Ƶ�,��ѵ,װ��,����,�ݿ�,����,���,����,ҽԺ,ѧУ',
                 '��������,���,�׶���ѵ,������Ӱ,���ӹ���,�׶�԰,Сѧ,����ҽԺ',
				 '4S��,��������,ά�ޱ���,�������,����,��У,��������,ͣ����',
                 '�Ͼ���·,�Ͼ���·,��ǳ�,��ɽ·,��ɽ��԰,����㳡,�ֶ�,��һ�,����·,�Ĵ�·'];
//��ʼ������
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
//Method 2ר�ã�����������ѡ���֧��
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
					<option value="0">��ʳ</option>
					<option value="1">����</option>
					<option value="2">����</option>
					<option value="3">����</option>
					<option value="4">����</option>
					<option value="5">����</option>
					<option value="6" selected="selected">������Ȧ</option>
					</select>
					</div>
					<div style="float:left;width:90px;margin-left: 30px" id="ss_td_1_e">
					<select name="ss_i_1_e" id="ss_i_1_e">
					<option value="�Ͼ���·" selected="selected">�Ͼ���·</option>
					<option value="�Ͼ���·">�Ͼ���·</option>
					<option value="��ǳ�">��ǳ�</option>
					<option value="��ɽ·">��ɽ·</option>
					<option value="��ɽ��԰">��ɽ��԰</option>
					<option value="����㳡">����㳡</option>
					<option value="�ֶ�">�ֶ�</option>
					<option value="��һ�">��һ�</option>
					<option value="����·">����·</option>
					<option value="�Ĵ�·">�Ĵ�·</option>
					</select>
					</div>
				</div>
				<div id="ss_div_23" style="position:absolute;left:10px;top:4px;width:100%;display: none;">
					<div style="float:left;width:90px;margin-left: 10px">
					<select name="startName">
					<option value="121.419996,31.222641" selected="selected">��ɽ��԰</option>
					<option value="121.608481,31.200268">�Ž��߿�</option>
					<option value="121.512758,31.232723">����·</option>
					<option value="121.542339,31.248686">�ֶ����</option>
					<option value="121.361858,31.212060">����·</option>
					<option value="121.480665,31.233274">����㳡</option>
					<option value="121.447237,31.224226">������</option>
					<option value="121.433658,31.223459">��һ�</option>
					</select>
					</div>
					<div style="float:left;width:90px;margin-left: 30px">
					<select name="endName">
					<option value="121.419996,31.222641">��ɽ��԰</option>
					<option value="121.608481,31.200268">�Ž��߿�</option>
					<option value="121.512758,31.232723">����·</option>
					<option value="121.542339,31.248686">�ֶ����</option>
					<option value="121.361858,31.212060">����·</option>
					<option value="121.480665,31.233274" selected="selected">����㳡</option>
					<option value="121.447237,31.224226">������</option>
					<option value="121.433658,31.223459">��һ�</option>
					</select>
					</div>
				</div>
		</div>
	</div>
		<div style="position:absolute;left:270px;top:4px;width:49px;height:28px;">
			<a href="javascript:void(0)" onclick="searchType()"><img style="border:0" src="img/search.gif"></a>
		</div>
		<div style="position:absolute;left:20px;top:30px;width:500px;height:23px;">
			<div class="td_1" id="ss_td_1"><a id="ss_a_1" href="javascript:ss(1)" class="ta on">����</a></div>
			<div style="float:left;width:10px"></div>
			<div class="td_2" id="ss_td_2"><a id="ss_a_2" href="javascript:ss(2)" class="ta">����</a></div>
			<div style="float:left;width:10px"></div>
			<div class="td_2" id="ss_td_3"><a id="ss_a_3" href="javascript:ss(3)" class="ta">�ݳ�</a></div>
		</div>
		<div style="position:absolute;left:200px;top:45px;width:330px;height:28px;">
<marquee behavior="alternate" direction="left" scrollAmount="1" scrollDelay="10" onMouseOver="this.stop();" onMouseOut="this.start();">
			<a href="javascript:void(0)" onclick="javascript:void(0)">��һ�����Ͷ��ڣ�ȫ�����������</a>
</marquee>
		</div>
	<div id="div_left" style="width:198px;height:485px;position: absolute;top: 65px;left: 0px;border:1px solid #3b6ac4;">
		<div id="ss_div_result_1" style="width:198px;height:483px">
			<div style="width:100%;height:27px;padding: 5px;font-weight: bold;background: url(img/title2.gif)">���ŷ���</div>
			<div class="title">��ʳ</div>
			<div class="title_little" id="kind_td_0"></div>
			<div class="title">����</div>
			<div class="title_little" id="kind_td_1"></div>
			<div class="title">����</div>
			<div class="title_little" id="kind_td_2"></div>
			<div class="title">����</div>
			<div class="title_little" id="kind_td_3"></div>
			<div class="title">����</div>
			<div class="title_little" id="kind_td_4"></div>
			<div class="title">����</div>
			<div class="title_little" id="kind_td_5"></div>
		</div>
		<div id="ss_div_result_23" style="width:198px;height:483px;display: none">
			<div style="width:100%;height:483px"><iframe height="483" width="100%" border="0" frameborder="0" src="" name="leftFrame" id="leftFrame" title="leftFrame" scrolling="no"></iframe></div>
		</div>
	</div>
	<div id="div_right" style="width:436px;height:485px;position: absolute;top: 65px;left: 202px;border:1px solid #3b6ac4;">
		<div style="float:left;width:100%;height:27px;background: url('img/title2.gif')">
			<div style="float:right;margin-top:6px;color:blue;font-size:14px;text-align: right">2���� 4���� 8���� 6���� 1�Ŵ� 3��С 5ʵʱ·�� 7ȫ��</div>			
		</div>
		<div style="float:left;width:434px;height:454px"><img src="img/ajaxloader.gif" name="map"></div>
	</div>


<div id="pop" style="width:300px;height:110px;background: url('img/pop_bg2.png') no-repeat;position: absolute;left:240px;top:145px;float:left;display:none">
<div style="width:300px;height:32px;">
<div style="float:left;font-size:14px;color:#ffffff;margin:10px 0px 0px 35px;font-weight:bold;width:225px">�������ֻ�����</div><div style="float:right;margin:5px 10px 0px 0px;width:16px"><img src="img/close.png" style="cursor:pointer" onclick="javascript:closePop()"/></div>
</div>
<div style="width:300px;height:76px;font-size:13px;color:#000000;margin-top:15px">
&nbsp;<input type="text" name="mobilephone" style="width:200px;height:30px"/> <input style="width:50px;height:30px" type="button" value="����" onclick="javascript:sendSMS_T()"/>
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
<input style="width:50px;height:30px;float:left;margin-left:10px;margin-top:10px" type="button" value="ȷ��" onclick="javascript:closePopResult()" id="okBtn"/>
</div>
</div>
</div>

<div id="popFac" style="width:300px;height:128px;background: url('img/pop_bg.png') no-repeat;position: absolute;left:270px;top:185px;float:left;display:none">
<div style="width:300px;height:32px;">
<div style="float:left;font-size:14px;color:#ffffff;margin:10px 0px 0px 10px;font-weight:bold;width:250px"><span id="name">A.�ǰͿ�</span></div><div style="float:right;margin:5px 10px 0px 0px;width:16px"><img src="img/close.png" style="cursor:pointer" onclick="javascript:closePopFac()"/></div>
</div>
<div style="width:300px;height:76px;font-size:13px;color:#000000">
<div style="margin:5px 0px 0px 5px">��ַ��<span id="address">����·999�Ŷ�ý������㳡1��</span></div>
<div style="margin:5px 0px 0px 5px">�绰��<span id="tel">021-52410325</span></div>
<div style="margin:5px 0px 0px 5px">������<span id="xml">021-52410325</span></div>
</div>
</div>


</body>
</html>