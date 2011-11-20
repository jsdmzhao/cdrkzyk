var cityid,city1,city2,weaXML,weaHTML;
weaXML = "http://service.weather.com.cn/plugin/";
weaHTML = "http://m.weather.com.cn/data/";
var imgUrl = "http://m.weather.com.cn/img";
$().ready(function() {
 cityid = $.cookie('wea_cityid');
 if(cityid==null){
  LoadJS("http://fw.qq.com:80/ipaddress", function()
  {
   if (typeof IPData != "undefined")
   {
    city1 = IPData[2];
    city2 = IPData[3];
    if(city2!=''){
	    city1 = city1.replace("省","")
	    city2 = city2.replace("市","");
    }else{
    	city1 = city1.replace("市","")
    }
    if(city2=="") city2 = city1;
    $.cookie('wea_cityip', IPData[0]);
    getLocalCity("data/city.xml",0);
   }
  });
 }
 else{
  getWeather(cityid);
 }
});
function getLocalCity(turl,b)
{
 $.ajax({
    type: "GET",
    url: weaXML+turl,
    dataType: "text",
    success: function(msg){
   var cityArr = msg.split(",");
   for(var i=0;i <cityArr.length;i++){
    cid = cityArr[i].split("|")[0];
    if(b<3){
     if(cityArr[i].split("|")[1]==city1 || cityArr[i].split("|")[1]==city2){
      getLocalCity("data/city"+ cid +".xml",b+1);
      break;
     }
    }
    else{
     cid = cityArr[i].split("|")[1];
     getWeather(cid);
     break;
    }
   }
    }
 });
}
function getWeather(cid)
{
 $.cookie('wea_cityid', cid,{expires: 365});
 var weajs = weaHTML+cid+'.html';
 $.getJSON(
  weajs,
  function(objJson){//alert(JSON.stringify(objJson));
  try{ var cityname=objJson.weatherinfo.city;  //上海
   var id=objJson.weatherinfo.cityid;   //101020100 
   var cityinfo1=objJson.weatherinfo.weather1; //晴转多云
   var cityinfo2=objJson.weatherinfo.weather2;
   var cityinfo3=objJson.weatherinfo.weather3;
   var cityinfo4=objJson.weatherinfo.weather4;
   var cityinfo5=objJson.weatherinfo.weather5;
   var wd1=objJson.weatherinfo.wind1;   //北风3-4级
   //var wd2=objJson.weatherinfo.wind2;
  // var wd3=objJson.weatherinfo.wind3;
  // var wd4=objJson.weatherinfo.wind4;
  // var wd5=objJson.weatherinfo.wind5;
  // var fl1=objJson.weatherinfo.fl1;   //3-4级
  // var fl2=objJson.weatherinfo.fl2;
  // var fl3=objJson.weatherinfo.fl3;
  // var fl4=objJson.weatherinfo.fl4;
  // var fl5=objJson.weatherinfo.fl5;
   var temp1=objJson.weatherinfo.temp1;  //4℃~-1℃
   var temp2=objJson.weatherinfo.temp2;
   var temp3=objJson.weatherinfo.temp3;
   var temp4=objJson.weatherinfo.temp4;
   var temp5=objJson.weatherinfo.temp5;
   var img1=objJson.weatherinfo.img1;
   var img2=objJson.weatherinfo.img2;
   var img3=objJson.weatherinfo.img3;
   var img4=objJson.weatherinfo.img4;
   var img5=objJson.weatherinfo.img5;
   var img6=objJson.weatherinfo.img6;
   var img7=objJson.weatherinfo.img7;
   var img8=objJson.weatherinfo.img8;
   var img9=objJson.weatherinfo.img9;
   var img10=objJson.weatherinfo.img10;
  // var index=objJson.weatherinfo.index;
  // var index_d=objJson.weatherinfo.index_d;
  // var index_xc=objJson.weatherinfo.index_xc;
   var index_uv1=objJson.weatherinfo.index_uv;
  // var index_uv2=objJson.weatherinfo.index48_uv;
   var date=objJson.weatherinfo.date;
  // var date_y=objJson.weatherinfo.date_y;
   var week=objJson.weatherinfo.week;

  // var imgtitle1=objJson.weatherinfo.img_title1;
  // var imgtitle2=objJson.weatherinfo.img_title2;
  // var imgsingle=objJson.weatherinfo.img_single;
 //  var imgtitlesingle=objJson.weatherinfo.img_title_single;

   //$("#jsCity").html("<a href='http://www.weather.com.cn/html/weather/"+id+".shtml' target=_bank>"+cityname+"</a>");
   var nowDate = new Date();
   var dateUtil = new DateUtil();
   var content = "<a href='http://www.weather.com.cn/html/weather/"+id+".shtml' target=_bank>"+cityname+"</a><br/>"+dateUtil.Format('yyyy年MM月dd日',nowDate)+"<br/>"+date+"<br/>"+week;
   $("#city").html(content);
   content = "";
   if(img1!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img1+".gif'/>";
   if(img2!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img2+".gif'/>";
   content += "<br/>天气：" + cityinfo1+"<br/>温度："+temp1+"<br/>风力："+wd1+"<br/>紫外线："+index_uv1;
   $("#today").html(content);
   content = "";
   nowDate.setDate(nowDate.getDate()+1);
   if(img3!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img3+".gif'/>";
   if(img4!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img4+".gif'/>";
   content += "<br/>"+dateUtil.Format('yyyy年MM月dd日',nowDate)+"<br/>天气："+cityinfo2+"<br/>温度："+temp2;
   $("#tomorrow_1").html(content);
   content = "";
	nowDate.setDate(nowDate.getDate()+1);
   if(img5!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img5+".gif'/>";
   if(img6!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img6+".gif'/>";
   content += "<br/>"+dateUtil.Format('yyyy年MM月dd日',nowDate)+"<br/>天气："+cityinfo3+"<br/>温度："+temp3;
   $("#tomorrow_2").html(content);
   content = "";
   nowDate.setDate(nowDate.getDate()+1);
   if(img7!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img7+".gif'/>";
   if(img8!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img8+".gif'/>";
   content += "<br/>"+dateUtil.Format('yyyy年MM月dd日',nowDate)+"<br/>天气："+cityinfo4+"<br/>温度："+temp4;
   $("#tomorrow_3").html(content);
   content = "";
   nowDate.setDate(nowDate.getDate()+1);
   if(img9!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img9+".gif'/>";
   if(img10!=99) content+=" <img src='http://m.weather.com.cn/img/b"+img10+".gif'/>";
   content += "<br/>"+dateUtil.Format('yyyy年MM月dd日',nowDate)+"<br/>天气："+cityinfo5+"<br/>温度："+temp5;
   $("#tomorrow_4").html(content);
   }catch(e){alert(e)}
   $("#jsWeather").html(content);
   //setWeather(id,cityname,cityinfo1,temp1,wd1,index_uv,img1)
 }); 
}
function LoadJS(jsUrl,fCallBack)
{
 var _script = document.createElement('script');
 _script.setAttribute('type', 'text/javascript');
 _script.setAttribute('charset', 'gb2312');
 _script.setAttribute('src', jsUrl);
 document.getElementsByTagName('head')[0].appendChild(_script);
 if(typeof fCallBack != "undefined")
 {
  if ($.browser.msie)
  {
   _script.onreadystatechange = function()
   {
    if (this.readyState=='loaded' || this.readyState=='complete')
    {fCallBack();}
   };
  }
  else if ($.browser.mozilla)
  {
   _script.onload = function(){fCallBack();};
  }
  else
  {
   fCallBack();
  }
 }
}