function chk(evt){
	    evt = (evt) ? evt : ((window.event) ? window.event : "")    
		if(evt.keyCode==13){
			loginSystem();
		}if(evt.keyCode==27){
			reset();
		}
	}
	
	function getCookieValSS(offset){
		var endstr = document.cookie.indexOf (";", offset);
		if (endstr == -1)
		endstr = document.cookie.length;
		return unescape(document.cookie.substring(offset, endstr));
	}

	function setCookie(name, value){
		var expdate = new Date();
		var argv = setCookie.arguments;
		var argc = setCookie.arguments.length;
		var expires = (argc > 2) ? argv[2] : null;
		var path = (argc > 3) ? argv[3] : null;
		var domain = (argc > 4) ? argv[4] : null;
		var secure = (argc > 5) ? argv[5] : false;
		if(expires!=null) expdate.setTime(expdate.getTime() + ( expires * 1000 ));
		document.cookie = name + "=" + escape (value) +((expires == null) ? "" : ("; expires="+ expdate.toGMTString()))
		+((path == null) ? "" : ("; path=" + path)) +((domain == null) ? "" : ("; domain=" + domain))
		+((secure == true) ? "; secure" : "");
	}

	function delCookie(name){
		var exp = new Date();
		exp.setTime (exp.getTime() - 1);
		var cval = GetCookie(name);
		document.cookie = name + "=" + cval + "; expires="+ exp.toGMTString();
	}

	function getCookie(name){
		var arg = name + "=";
		var alen = arg.length;
		var clen = document.cookie.length;
		var i = 0;
		while (i < clen){
			var j = i + alen;
			if (document.cookie.substring(i, j) == arg){
				return getCookieValSS(j);
			}
			i = document.cookie.indexOf(" ", i) + 1;
			if (i == 0) break;
		}
		return null;
	}
	
function Map(){
	this.elements=new Array();
	this.size=function(){
		this.elements.length;
	}
	this.put=function(_key,_value){
		this.elements.push({key:_key,value:_value});
	}
	this.remove=function(_key){
		var bln=false;
		try{
			for (i=0;i<this.elements.length;i++){
				if (this.elements[i].key==_key){
					this.elements.splice(i,1);
					return true;
				}
			}
		}catch(e){
			bln=false;
		}
		return bln;
	}
	this.containsKey=function(_key){
		var bln=false;
		try{
			for (i=0;i<this.elements.length;i++){
				if (this.elements[i].key==_key){
					bln=true;
				}
			}
		}catch(e){
			bln=false;
		}
		return bln;
	}
	this.get=function(_key){
		try{
			for (i=0;i<this.elements.length;i++){
				if (this.elements[i].key==_key){
				return this.elements[i];
				}
			}
		}catch(e){
			return null;
		}
	}
	this.toValueString=function(){
		try{
			var str='';
			for (i=0;i<this.elements.length;i++){
				str+=','+this.elements[i].value;
			}
			return str.substring(1);
		}catch(e){
			return null;
		}
	}
	this.toKeyString=function(){
		try{
			var str='';
			for (i=0;i<this.elements.length;i++){
				str+=','+this.elements[i].key;
			}
			return str.substring(1);
		}catch(e){
			return null;
		}
	}
	this.removeAll=function(){
		try{
			for (i=0;i<this.elements.length;i++){
				this.remove(this.elements[i].key);
			}
		}catch(e){
			return ;
		}
	}
}
function formatNumber(number,pattern){
	var lesszero=false;
	if(number<0){
		number=-1*number;
		lesszero=true;
	}
    var str= number.toString();
    var strInt;
    var strFloat;
    var formatInt;
    var formatFloat;
    if(/\./g.test(pattern)){
        formatInt        = pattern.split('.')[0];
        formatFloat        = pattern.split('.')[1];
    }else{
        formatInt = pattern;
        formatFloat = null;
    }

    if(/\./g.test(str)){
        if(formatFloat!=null){
            var tempFloat = Math.round(parseFloat('0.'+str.split('.')[1])*Math.pow(10,formatFloat.length))/Math.pow(10,formatFloat.length);
            strInt  = (Math.floor(number)+Math.floor(tempFloat)).toString();                
            strFloat = /\./g.test(tempFloat.toString())?tempFloat.toString().split('.')[1]:'0';            
        }else{
            strInt  = Math.round(number).toString();
            strFloat    = '0';
        }
    }else{
        strInt = str;
        strFloat = '0';
    }
    if(formatInt!=null){
        var outputInt  = '';
        var zero   = formatInt.match(/0*$/)[0].length;
        var comma  = null;
        if(/,/g.test(formatInt)){
            comma = formatInt.match(/,[^,]*/)[0].length-1;
        }
        var newReg = new RegExp('(\\d{'+comma+'})','g');

        if(strInt.length<zero){
            outputInt = new Array(zero+1).join('0')+strInt;
            outputInt = outputInt.substr(outputInt.length-zero,zero)
        }else{
            outputInt = strInt;
        }

        var 
        outputIn= outputInt.substr(0,outputInt.length%comma)+outputInt.substring(outputInt.length%comma).replace(newReg,(comma!=null?',':'')+'$1')
        outputInt= outputInt.replace(/^,/,'');

        strInt= outputInt;
    }

    if(formatFloat!=null){
        var outputFloat    = '';
        var zero        = formatFloat.match(/^0*/)[0].length;

        if(strFloat.length<zero){
            outputFloat        = strFloat+new Array(zero+1).join('0');
            //outputFloat        = outputFloat.substring(0,formatFloat.length);
            var outputFloat1    = outputFloat.substring(0,zero);
            var outputFloat2    = outputFloat.substring(zero,formatFloat.length);
            outputFloat        = outputFloat1+outputFloat2.replace(/0*$/,'');
        }else{
            outputFloat        = strFloat.substring(0,formatFloat.length);
        }

        strFloat    = outputFloat;
    }else{
        if(pattern!='' || (pattern=='' && strFloat=='0')){
            strFloat    = '';
        }
    }

   var result=strInt+(strFloat==''?'':'.'+strFloat);
   if(lesszero){
   	result='-'+result;
   }
   return result;
}

function rnd() { 
	rnd.today=new Date(); 
	rnd.seed=rnd.today.getTime(); 
	rnd.seed = (rnd.seed*9301+49297) % 233280; 
	return parseInt(rnd.seed/(233280.0)*100000); 
} 
function myescape(str){
	return str.replace(new RegExp('\\\\',"gm"),'').replace(new RegExp('\"',"gm"),'\\\"');
}

function isEmpty(str) {
    if (str == "" || str == null) {
        return true;
    }
	if (str.replace(/ /g, "") == "") {
        return true;
    }
    return false;
} 
/**
 isDate("2005-4-1");
 */
function isDate(dt) {
    if (!/^[1|2]\d{3}-\d{2}-\d{2}$/.test(dt)) {
        return false;
    }
    var arr1 = dt.split("-")
    var date1 = new Date(arr1[0], parseInt(arr1[1].replace(/^0/, "")) - 1, arr1[2]);
    if ((date1.getMonth() + 1).toString() != arr1[1].replace(/^0/, "") || date1.getDate().toString() != arr1[2].replace(/^0/, "")) {
        return false;
    }
    return true;
}
//计算天数差的函数，通用  
   function  DateDiff(sDate1,  sDate2){    //sDate1和sDate2是2006-12-18格式  
       var  aDate,  oDate1,  oDate2,  iDays  
       aDate  =  sDate1.split("-")  
       oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])    //转换为12-18-2006格式  
       aDate  =  sDate2.split("-")  
       oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])  
       iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24)    //把相差的毫秒数转换为天数  
       return  iDays  
   }   
function toHJDivL(hjlove) {
    if (document.getElementById("bgDiv") == undefined && hjlove == 1) {
        var msgw,msgh,bordercolor;
        msgw = 400;
        //提示窗口的宽度
        msgh = 100;
        //提示窗口的高度
        titleheight = 25 //提示窗口标题高度
        bordercolor = "#68C9E5";
        //提示窗口的边框颜色
        titlecolor = "#C6E2F7";
        //提示窗口的标题颜色

        var sWidth,sHeight;
        sWidth = document.body.scrollWidth;
        sHeight = document.body.scrollHeight;
        var bgObj = document.createElement("div");
        bgObj.setAttribute('id', 'bgDiv');
        bgObj.style.position = "absolute";
        bgObj.style.top = "0";
        bgObj.style.background = "#777";
        bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=25";
        bgObj.style.opacity = "0.3";
        bgObj.style.left = "0";
        bgObj.style.width = sWidth + "px";
        bgObj.style.height = sHeight + "px";
        bgObj.style.zIndex = "10000";
        document.body.appendChild(bgObj);

        var iframeH = document.createElement("iframe");
        iframeH.setAttribute('id', 'iframeH');
		iframeH.setAttribute('src', 'about:blank');
        iframeH.style.position = "absolute";
        iframeH.style.top = "0";
        iframeH.style.background = "#777";
        iframeH.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=25";
        iframeH.style.opacity = "0.3";
        iframeH.style.left = "0";
        iframeH.style.width = sWidth + "px";
        iframeH.style.height = sHeight + "px";
        iframeH.style.zIndex = "-1";
		iframeH.style.frameborder = "0";
		iframeH.style.scrolling = "no";
		iframeH.style.border = "0";
		iframeH.style.framespacing = "0";


        bgObj.appendChild(iframeH);

        var msgObj = document.createElement("div")
        msgObj.setAttribute("id", "msgDiv");
        msgObj.setAttribute("align", "center");
        msgObj.style.background = "white";
        msgObj.style.border = "1px solid " + bordercolor;
        msgObj.style.position = "absolute";
        msgObj.style.left = "50%";
        msgObj.style.top = "50%";
        msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
        msgObj.style.marginLeft = "-225px";
        msgObj.style.marginTop = -75 + document.documentElement.scrollTop + "px";
        msgObj.style.width = msgw + "px";
        msgObj.style.height = msgh + "px";
        msgObj.style.textAlign = "center";
        msgObj.style.lineHeight = "25px";
        msgObj.style.zIndex = "10001";

        var title = document.createElement("h4");
        title.setAttribute("id", "msgTitle");
        title.setAttribute("align", "right");
        title.style.margin = "0";
        title.style.padding = "3px";
        title.style.background = bordercolor;
        title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
        title.style.opacity = "0.75";
        title.style.border = "1px solid " + bordercolor;
        title.style.height = "18px";
        title.style.font = "12px Verdana, Geneva, Arial, Helvetica, sans-serif";
        title.style.color = "white";
        title.style.cursor = "pointer";
        title.innerHTML = "[Tips]";

        document.body.appendChild(msgObj);
        msgObj.appendChild(title);
        var txt = document.createElement("p");
        txt.style.margin = "1em 0"
        txt.setAttribute("id", "msgTxt");
        txt.innerHTML = "<img src='../images/ajaxloader.gif'>loading......";
        document.getElementById("msgDiv").appendChild(txt);
    } else if (hjlove == 0) {
        document.getElementById("msgDiv").removeChild(document.getElementById("msgTitle"));
        document.body.removeChild(document.getElementById("msgDiv"));
        document.getElementById("bgDiv").removeChild(document.getElementById("iframeH"));
        document.body.removeChild(document.getElementById("bgDiv"));
    }
}
function autoCompKt(){
	
}

function parseFn(data) {
	        var rows = JSON.parse(data).result;
	        for(var i=0; i<rows.length; i++){
	              rows[i] = {
	               data:rows[i],
	               value:getText(rows[i]),
	               result:getText(rows[i])
	           };
	         }
	        return rows;
	     }
function autocompleteKT(fieldId,url,funK,funR){
$("#"+fieldId+"").autocomplete(url, {
				width:200,
				matchContains:true,
				minChars:2,
				matchCase:true,
				max:50,
				formatItem:function(row, i, max) {
					return funK(row);
				},
				formatResult:function(row) {
					return funK(row);
				}
			});
$("#"+fieldId+"").result(function(event, data, formatted){funR(data);});
}

function showWindowRaw(strurl, width, height) {
    window.open(strurl, 'report_select', 'toolbar=no,location=no,status=yes,menubar=no,scrollbars=yes,resizable=yes,width=' + width + ',height=' + height);
}

function getPrintInfo(){
	var obj = document.getElementById('print_info');
	if(obj == null) return '';
	var text  ='';
	var property = '';
	var hres =  obj.getElementsByTagName('A');
	for( var i=0;i<hres.length;i++){
		if(hres[i] != null){
			property+=hres[i].id+',';
			text+=hres[i].innerHTML+',' ;
		}
	}
	if(text.length > 0 ) text = text.substring(0,text.length-1);
	if(property.length > 0 ) property = property.substring(0,property.length-1);
	return 'text='+text+'&property='+property;
}

function autoApplyHeight4IFrame(iframeId){
		     var tag = parent.document.getElementById(iframeId);
		     if(document){
		     	$(tag).css('height',document.body.scrollHeight);
		     }else if(contentDocument)
		     	$(tag).css('height',contentDocument.body.offsetHeight);
		}
function formatDate(dateObj){
	var result;
	var year;
	var month;
	var date;
	var hours;
	var minutes;
	var seconds;
	
	if ($.browser.msie) {
		year = dateObj.getYear();
	} else {
		year = dateObj.getYear() + 1900;
	}
	month = dateObj.getMonth() + 1;
	date = dateObj.getDate();
	hours = dateObj.getHours();
	minutes = dateObj.getMinutes();
	seconds = dateObj.getSeconds();
	result = year + "-" + fillZero4fieldDate(month) + "-" + fillZero4fieldDate(date) + " " +  fillZero4fieldDate(hours) + ":" + fillZero4fieldDate(minutes) + ":" + fillZero4fieldDate(seconds);
	
	return result;
}

function fillZero4fieldDate(field){
	if((field+"").length==1)
		return "0"+field;
	else
		return field;
}
var scX = 20000 , scY = 20000;
function queryMapCommon(e,service,onComplete,onFailure,layers,properyArr){
        var lonLatXY = map.getLonLatFromViewPortPx(e.xy);
        var xmlPara = "<wfs:GetFeature service='WFS' version='1.0.0' outputFormat='GML2' " + 
		"xmlns:topp='http://www.openplans.org/topp' xmlns:wfs='http://www.opengis.net/wfs' " + 
		"xmlns:ogc='http://www.opengis.net/ogc' xmlns:gml='http://www.opengis.net/gml' " + 
		"xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' " + 
		"xsi:schemaLocation='http://www.opengis.net/wfs http://schemas.opengis.net/wfs/1.0.0/WFS-basic.xsd'> " + 
		"<wfs:Query typeName='"+layers+"'> " ; 
		for(var a in properyArr)
			xmlPara += "<wfs:PropertyName>"+properyArr[a]+"</wfs:PropertyName> ";
xmlPara += "<ogc:Filter><ogc:BBOX><ogc:PropertyName>the_geom</ogc:PropertyName> " + 
		"<gml:Box srsName='http://www.opengis.net/gml/srs/epsg.xml#4326'> " + 
		"<gml:coordinates>"+(lonLatXY.lon-scX)+","+(lonLatXY.lat+scY)+" "+(lonLatXY.lon+scX)+","+(lonLatXY.lat-scY)+"</gml:coordinates> " + 
		"</gml:Box></ogc:BBOX></ogc:Filter> " + 
		"</wfs:Query></wfs:GetFeature>"; 
		new OpenLayers.Ajax.Request( service,{contentType: "application/xml", method: 'post', postBody: xmlPara, onComplete: onComplete,onFailure:onFailure});
		Event.stop(e);
}
 function queryMapCommon2(e,map,service,onComplete,onFailure,layers){
	 var url =  map.layers[0].getFullRequestString({
         REQUEST: "GetFeatureInfo",
         EXCEPTIONS: "application/vnd.ogc.se_xml",
         BBOX: map.getExtent().toBBOX(),
         X: e.xy.x,
         Y: e.xy.y,
         INFO_FORMAT: 'text/xml',
         QUERY_LAYERS: map.layers[0].params.LAYERS,
         FEATURE_COUNT: 50,
         layers: layers,
         styles: '',
         srs: 'EPSG:4326',
         WIDTH: map.size.w,
         HEIGHT: map.size.h},
         service
         );
		OpenLayers.loadURL(url, '', this, onComplete, onFailure);
		Event.stop(e);
 }
 function showResponse2(req){
	 if (req.responseText.indexOf('no results') == -1) {
	        var name="Unknown", dzm="Unknown";
	        var lines = req.responseText.split('\n');
	        for (lcv = 0; lcv < (lines.length); lcv++) {
	            var vals = lines[lcv].replace(/^\s*/,'').replace(/\s*$/,'').replace(/ = /,"=").replace(/'/g,'').split('=');
	            if (vals[1] == "") {
	                vals[1] = "Unknown";
	            }
	            if (vals[0].indexOf('DZM') != -1 ) {
	            	dzm = vals[1];
	            } else if (vals[0].indexOf('NAME') != -1 ) {
	                name = vals[1];
	            }
	        }
	 }
	 return name+'='+dzm;
 }
  function showResponse(req){
	var gmlParse = new OpenLayers.Format.GML();
	var features = gmlParse.read(req.responseText);
	var icon = new OpenLayers.Icon('images/pp.gif');
	
	var feature, lonlat, marker;
	for(var feat in features){   
	   feature = features[feat];
	   lonlat = new OpenLayers.LonLat(feature.geometry.x,feature.geometry.y);   
	   marker = new OpenLayers.Marker(lonlat,icon.clone());  
	   marker.events.register("mousedown", marker, mousedown); 
	   markers.addMarker(marker);      
	}
	
}

function DateUtil(){
/***功能:格式化时间*示例:DateUtil.Format("yyyy/MM/dd","Thu Nov 9 20:30:37 UTC+0800 2006 ");*返回:2006/11/09*/
this.Format=function(fmtCode,date){ 
var result,d,arr_d; 
var patrn_now_1=/^y{4}-M{2}-d{2}\sh{2}:m{2}:s{2}$/; 
var patrn_now_11=/^y{4}-M{1,2}-d{1,2}\sh{1,2}:m{1,2}:s{1,2}$/; 
var patrn_now_2=/^y{4}\/M{2}\/d{2}\sh{2}:m{2}:s{2}$/; 
var patrn_now_22=/^y{4}\/M{1,2}\/d{1,2}\sh{1,2}:m{1,2}:s{1,2}$/; 
var patrn_now_3=/^y{4}年M{2}月d{2}日\sh{2}时m{2}分s{2}秒$/; 
var patrn_now_33=/^y{4}年M{1,2}月d{1,2}日\sh{1,2}时m{1,2}分s{1,2}秒$/; 
var patrn_date_1=/^y{4}-M{2}-d{2}$/; 
var patrn_date_11=/^y{4}-M{1,2}-d{1,2}$/; 
var patrn_date_2=/^y{4}\/M{2}\/d{2}$/; 
var patrn_date_22=/^y{4}\/M{1,2}\/d{1,2}$/; 
var patrn_date_3=/^y{4}年M{2}月d{2}日$/; 
var patrn_date_33=/^y{4}年M{1,2}月d{1,2}日$/; 
var patrn_time_1=/^h{2}:m{2}:s{2}$/; 
var patrn_time_11=/^h{1,2}:m{1,2}:s{1,2}$/; 
var patrn_time_2=/^h{2}时m{2}分s{2}秒$/; 
var patrn_time_22=/^h{1,2}时m{1,2}分s{1,2}秒$/; 
if(!fmtCode){fmtCode="yyyy/MM/dd hh:mm:ss";} 
if(date){ 
	d=new Date(date); 
	if(isNaN(d)){ 
	msgBox("时间参数非法\n正确的时间示例:\nThu Nov 9 20:30:37 UTC+0800 2006\n或\n2006/ 10/17"); 
	return;
	} 
}else{ 
d=new Date(); 
} 
if(patrn_now_1.test(fmtCode)) { 
	arr_d=splitDate(d,true); 
	result=arr_d.yyyy+"-"+arr_d.MM+"-"+arr_d.dd+" "+arr_d.hh+":"+arr_d.mm+":"+arr_d.ss; 
} else if(patrn_now_11.test(fmtCode)) { 
	arr_d=splitDate(d); 
	result=arr_d.yyyy+"-"+arr_d.MM+"-"+arr_d.dd+" "+arr_d.hh+":"+arr_d.mm+":"+arr_d.ss; 
} else if(patrn_now_2.test(fmtCode)) { 
	arr_d=splitDate(d,true); 
	result=arr_d.yyyy+"/"+arr_d.MM+"/"+arr_d.dd+" "+arr_d.hh+":"+arr_d.mm+":"+arr_d.ss; 
} else if(patrn_now_22.test(fmtCode)) { 
	arr_d=splitDate(d); 
	result=arr_d.yyyy+"/"+arr_d.MM+"/"+arr_d.dd+" "+arr_d.hh+":"+arr_d.mm+":"+arr_d.ss; 
} else if(patrn_now_3.test(fmtCode)) { 
	arr_d=splitDate(d,true); 
	result=arr_d.yyyy+"年"+arr_d.MM+"月"+arr_d.dd+"日"+" "+arr_d.hh+"时"+arr_d.mm+"分"+arr_d.ss+"秒"; 
} else if(patrn_now_33.test(fmtCode)) { 
	arr_d=splitDate(d); 
	result=arr_d.yyyy+"年"+arr_d.MM+"月"+arr_d.dd+"日"+" "+arr_d.hh+"时"+arr_d.mm+"分"+arr_d.ss+"秒"; 
} else if(patrn_date_1.test(fmtCode)) { 
	arr_d=splitDate(d,true); 
	result=arr_d.yyyy+"-"+arr_d.MM+"-"+arr_d.dd; 
} else if(patrn_date_11.test(fmtCode)) { 
	arr_d=splitDate(d); 
	result=arr_d.yyyy+"-"+arr_d.MM+"-"+arr_d.dd; 
} else if(patrn_date_2.test(fmtCode)) { 
	arr_d=splitDate(d,true); 
	result=arr_d.yyyy+"/"+arr_d.MM+"/"+arr_d.dd; 
} else if(patrn_date_22.test(fmtCode)) { 
	arr_d=splitDate(d); 
	result=arr_d.yyyy+"/"+arr_d.MM+"/"+arr_d.dd; 
} else if(patrn_date_3.test(fmtCode)) { 
	arr_d=splitDate(d,true); 
	result=arr_d.yyyy+"年"+arr_d.MM+"月"+arr_d.dd+"日"; 
} else if(patrn_date_33.test(fmtCode)) { 
	arr_d=splitDate(d); 
	result=arr_d.yyyy+"年"+arr_d.MM+"月"+arr_d.dd+"日"; 
} else if(patrn_time_1.test(fmtCode)){ 
	arr_d=splitDate(d,true); 
	result=arr_d.hh+":"+arr_d.mm+":"+arr_d.ss; 
} else if(patrn_time_11.test(fmtCode)){ 
	arr_d=splitDate(d); 
	result=arr_d.hh+":"+arr_d.mm+":"+arr_d.ss; 
} else if(patrn_time_2.test(fmtCode)){ 
	arr_d=splitDate(d,true); 
	result=arr_d.hh+"时"+arr_d.mm+"分"+arr_d.ss+"秒"; 
} else if(patrn_time_22.test(fmtCode)){ 
	arr_d=splitDate(d); 
	result=arr_d.hh+"时"+arr_d.mm+"分"+arr_d.ss+"秒"; 
} else{ 
	msgBox("没有匹配的时间格式!"); 
	return; 
} 
return result;
};
}

function splitDate(d,isZero){ 
var yyyy,MM,dd,hh,mm,ss; 
if(isZero){ 
yyyy=d.getYear(); 
MM=(d.getMonth()+1)<10?"0"+(d.getMonth()+1):d.getMonth()+1; 
dd=d.getDate()<10?"0"+d.getDate():d.getDate(); 
hh=d.getHours()<10?"0"+d.getHours():d.getHours(); 
mm=d.getMinutes()<10?"0"+d.getMinutes():d.getMinutes(); 
ss=d.getSeconds()<10?"0"+d.getSeconds():d.getSeconds(); 
}else{ 
yyyy=d.getYear(); 
MM=d.getMonth()+1; 
dd=d.getDate(); 
hh=d.getHours(); 
mm=d.getMinutes(); 
ss=d.getSeconds(); 
} 
return {"yyyy":yyyy,"MM":MM,"dd":dd,"hh":hh,"mm":mm,"ss":ss}; 
}
function msgBox(msg){ window.alert(msg);}
String.prototype.endWith=function(str){
if(str==null||str==""||this.length==0||str.length>this.length)
  return false;
if(this.substring(this.length-str.length)==str)
  return true;
else
  return false;
return true;
}

String.prototype.startWith=function(str){
if(str==null||str==""||this.length==0||str.length>this.length)
  return false;
if(this.substr(0,str.length)==str)
  return true;
else
  return false;
return true;
}

function dyniframesize(down) {
	var pTar = null; 
	if (document.getElementById){ 
		pTar = document.getElementById(down); 
	}else{ 
		eval('pTar = ' + down + ';'); 
	} 
	if (pTar && !window.opera){ 
	//begin resizing iframe 
	pTar.style.display="block" 
	if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight){ 
		//ns6 syntax 
		pTar.height = pTar.contentDocument.body.offsetHeight +20; 
		pTar.width = pTar.contentDocument.body.scrollWidth+20; 
	}else if (pTar.Document && pTar.Document.body.scrollHeight){ 
		//ie5+ syntax 
		pTar.height = pTar.Document.body.scrollHeight; 
		pTar.width = pTar.Document.body.scrollWidth; 
	}
 }
} 
function NumToBig(num) 
{
     if(isNaN(num))
     { 
         alert('请检查小写金额是否正确!'); 
         return; 
     } 
     else
     {
         //保留两位有效数字
        num = Math.round(num*Math.pow(10,2))/Math.pow(10,2);
     }
     var NumStr = String(num);
     var NumChar = '零壹贰叁肆伍陆柒捌玖'; 
     var UnitChar1 = ' 拾佰仟 拾佰仟 拾佰仟 拾佰仟'; 
     var UnitChar2 = ' 万亿兆'; 
     var Len; 
     var LeftLen,LeftStr; 
     var RightLen,RightStr; 
     var BigStr = ''; 
     Len = NumStr.length; 
     //根据小数点分割字符串
     if(NumStr.indexOf('.')==-1)//没有小数 
     { 
         LeftStr = NumStr; 
         LeftLen = Len; 
         RightStr = ''; 
         RightLen = 0; 
     } 
     else
     { 
         LeftStr = (NumStr.split('.'))[0]; 
         LeftLen = LeftStr.length; 
         RightStr = (NumStr.split('.'))[1]; 
         RightLen = RightStr.length; 
     } 
     //转换整数部分
     for(var i=0;i<LeftLen;i++)
     {
         //按位取小写数字
         var LeftTempNum = parseInt(LeftStr.substring(i,i+1));
         //转换成大写
         var LeftTempStr = NumChar.substring(LeftTempNum,LeftTempNum+1);
         //数字位为零且不是一位数
         if(LeftTempStr=='零' && LeftLen!=1)
         {
             //下一位数字为零或者为万(个)位
             if(LeftStr.substring(i+1,i+2)=='0' || (LeftLen-i)%4==1)
             {
                 LeftTempStr = '';
             }
         }
         else
         {
             //加上读的单位，拾佰仟之类的
             LeftTempStr += UnitChar1.substring(LeftLen-i-1,LeftLen-i).replace(' ','');
         }
         //万位或个位
         if((LeftLen-i)%4==1)
         {
         LeftTempStr += UnitChar2.substring(parseInt((LeftLen-i)/4),parseInt((LeftLen-i)/4)+1);
             if(i>2)
             {
                 if(LeftStr.substring(i-3,i+1)=='0000')
                 {
                     LeftTempStr = TempStr.substring(0,LeftTempStr.length-1);
                 }
             }
         }
         BigStr += LeftTempStr.replace(' ','');
     }
     //处理小数部分
     if(RightLen==0) 
     { 
         BigStr += '元整'; 
     }
     else
     {
         BigStr += '元';
         for(var i=0;i<RightLen;i++)
         {
             //按位取小写数字
             var RightTempNum = parseInt(RightStr.substring(i,i+1));
             //转换成大写
             var RightTempStr = NumChar.substring(RightTempNum,RightTempNum+1);
             if (i==0)
             {
                 RightTempStr+="角";
             }
             if (i==1)
             {
                 RightTempStr+="分";
             }
             BigStr += RightTempStr;
         }
     }
     return BigStr;
}
function unionSelect(id1,id2,add,remove){
		var opleft = $("#"+id1+" option");
		var opright = $("#"+id2+" option");
		for(var i=0;i<opright.length;i++){
		   var va = opright.eq(i).attr("value");
		   opleft.remove("[value='"+va+"']");
		}
		   $("#"+id1+" option:first,#"+id2+" option:first").attr("selected",true);
		   $("#"+id1).dblclick(function(){
		      var alloptions = $("#"+id1+" option");
		      var so = $("#"+id1+" option:selected");
		    if(so === null || so == "undefined"){return;}
		try{
		     var a = (so.get(so.length-1).index == alloptions.length-1)? so.prev().attr("selected",true):so.next().attr("selected",true);
		     }catch(e){return;}
		    $("#"+id2).append(so);
		   });
		   $("#"+id2).dblclick(function(){
		     var alloptions = $("#"+id2+" option");
		     var so = $("#"+id2+" option:selected");
		    if(so === null || so == "undefined"){return;}
		    try{
		        var a = (so.get(so.length-1).index == alloptions.length-1)? so.prev().attr("selected",true):so.next().attr("selected",true);
		    }catch(e){return;}
		      $("#"+id1).append(so);
		   });
		$("#"+add).click(function(){
		     var alloptions = $("#"+id1+" option");
		     var so = $("#"+id1+" option:selected");
		     if(so.length==0)
		     return;
		    var a = (so.get(so.length-1).index == alloptions.length-1)? so.prev().attr("selected",true):so.next().attr("selected",true);
		    $("#"+id2).append(so);
		});
		    $("#"+remove).click(function(){
		     var alloptions = $("#"+id2+" option");
		     var so = $("#"+id2+" option:selected");
		     if(so.length==0)
		     return;
		      var a = (so.get(so.length-1).index == alloptions.length-1)? so.prev().attr("selected",true):so.next().attr("selected",true);
		    $("#"+id1).append(so);
		   });
}
function incomeTaxCommon(totalIncome){
	if(totalIncome<2000)
		return "0.00";
	var tax = 0;
	if(totalIncome>4000){
		tax = (totalIncome-2000)*0.15-125;
	}else if(totalIncome>2500&&totalIncome<=4000){
		tax = (totalIncome-2000)*0.1-25;
	}else if(totalIncome>2000&&totalIncome<=2500){
		tax = (totalIncome-2000)*0.05;
	}
	var s = (tax + "").split(".");
	if(s.length == 1)
		return s[0] + ".00";
	else {
		if(s[1].length == 1)
			return s[0] + "." + s[1] + "0";
		else
			return s[0] + "." + s[1].substr(0,2);
	}
}
