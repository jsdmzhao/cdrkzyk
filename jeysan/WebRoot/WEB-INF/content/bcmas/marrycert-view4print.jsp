<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/print/Export.jsp" %>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
  .limitedwidth {width:563px;height:306px;}
  .In1-table1 {  border: 2px #000000 solid;font-size:12;}
  .In1-td-right {font-size:12px;  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px}
  .In1-td-leftbottom {font-size:12px;  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-bottom {font-size:12px;  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px}
  .In1-td-rightbottom {font-size:12px;  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-top { font-size:12px; border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px}
  .title_black { font-size: 18px;font-weight: bold;font-family: "宋体";}
  .STYLE1 { border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-weight: bold; }
 -->
 </style>
<div style="margin:5px;">
<table border="0" cellspacing="0" cellpadding="0"  class="limitedwidth"><tr><td>
<table border="0" cellspacing="0" cellpadding="0"  class="In1-table1">
<tr>
 <td width="63" height="23" align="center" valign="middle" class="In1-td-rightbottom">证号</td>
 <td width="212" class="In1-td-rightbottom">&nbsp;${certCode}</td>
 <td width="10" rowspan="13" class="In1-td-right">&nbsp;</td>
 <td colspan="2" rowspan="13" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
     <td width="63" height="27" align="center" valign="middle" class="In1-td-rightbottom">婚姻状况</td>
     <td width="120" class="In1-td-bottom">&nbsp;<tags:js.dict.getValue value="${person.personBasic.marryStatus}"/></td>
   </tr>
   <tr>
     <td width="63" height="27" align="center" valign="middle" class="In1-td-rightbottom">出生年月</td>
     <td width="120" class="In1-td-bottom">&nbsp;<fmt:formatDate value="${person.personBasic.birthday}" pattern="yyyy-MM-dd"/></td>
   </tr>
   <tr>
     <td width="63" height="27" align="center" valign="middle" class="In1-td-rightbottom">身份证<br/>号码</td>
     <td width="120" class="In1-td-bottom">&nbsp;${person.code}</td>
   </tr>
   <tr>
     <td width="63" height="27" align="center" valign="middle" class="In1-td-rightbottom">结婚时间</td>
     <td width="120" class="In1-td-bottom">&nbsp;<fmt:formatDate value="${marryDate}" pattern="yyyy-MM-dd"/></td>
   </tr>
   <tr>
     <td width="63" height="27" align="center" valign="middle" class="In1-td-rightbottom">常住户<br/>籍所在地</td>
     <td width="120" class="In1-td-bottom">&nbsp;${person.personBasic.domicile}</td>
   </tr>
   <tr>
     <td width="63" height="27" align="center" valign="middle" class="In1-td-rightbottom">所在乡(镇、街道)<br/>计生办电话</td>
     <td width="120" class="In1-td-bottom">&nbsp;${fpoTel1}</td>
   </tr>
   <tr>
     <td width="63" height="30" align="center" valign="middle" class="In1-td-rightbottom">配偶姓名</td>
     <td width="120" class="In1-td-bottom">&nbsp;${spouse.nameh}</td>
   </tr>
   <tr>
     <td width="63" height="30" align="center" valign="middle" class="In1-td-rightbottom">常住户籍<br/>所在地</td>
     <td width="120" class="In1-td-bottom">&nbsp;${spouse.domicile}</td>
   </tr>
   <tr>
     <td width="63" height="30" align="center" valign="middle" class="In1-td-rightbottom">所在乡(镇、街道)<br/>计生办电话</td>
     <td width="120" class="In1-td-bottom">&nbsp;${fpoTel2}</td>
   </tr>
   <tr>
     <td height="54" colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="120" height="27" align="center" valign="middle" class="In1-td-rightbottom">发证时已有子女数</td>
         <td width="30" class="In1-td-rightbottom">&nbsp;${beforeBoyCount}</td>
         <td align="center" valign="middle" class="In1-td-rightbottom">男</td>
         <td width="30" class="In1-td-rightbottom">&nbsp;${beforeGirlCount}</td>
         <td align="center" valign="middle" class="In1-td-bottom">女</td>
       </tr>
       <tr>
         <td height="27" align="center" valign="middle" class="In1-td-right">发证后生育子女数</td>
         <td class="In1-td-right">&nbsp;${afterBoyCount}</td>
         <td align="center" valign="middle" class="In1-td-right">男</td>
         <td class="In1-td-right">&nbsp;${afterGirlCount}</td>
         <td align="center" valign="middle">女</td>
       </tr>
     </table></td>
   </tr>
   </table></td>
 </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">姓名</td>
  <td rowspan="6" align="center" valign="middle" class="In1-td-rightbottom"><img width="202" height="143" src="${ctx}/${photo}" /></td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${person.nameh}</td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">性别</td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${person.sex}"/></td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">年龄</td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${person.age}</td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">发证机关</td>
  <td class="In1-td-rightbottom">&nbsp;${issOrg}</td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">发证机关<br/>地址</td>
  <td class="In1-td-rightbottom">&nbsp;${issOrgAddress}</td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" colspan="2">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
	  <td width="63" height="23" class="In1-td-rightbottom">邮政编码</td>
      <td width="60" class="In1-td-rightbottom">&nbsp;${zipCode}</td>
      <td width="35" align="center" valign="middle" class="In1-td-rightbottom">电话</td>
      <td class="In1-td-rightbottom">&nbsp;${tel}</td>
      </tr>
  </table></td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">发证日期</td>
  <td class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd"/></td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-rightbottom">有效期</td>
  <td class="In1-td-rightbottom">&nbsp;至<fmt:formatDate value="${validPeriod}" pattern="yyyy-MM-dd"/>止</td>
  </tr>
<tr>
  <td height="23" align="center" valign="middle" class="In1-td-right">经办人</td>
  <td class="In1-td-right">&nbsp;${agent}</td>
  </tr>
</table>
</td></tr></table>
</div>
</form>
<table border="0" cellspacing="0" cellpadding="0">
<tr><td width="275" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="In1-table1">
<tr><td height="25" class="In1-td-rightbottom" align="center">避孕节育措施</td><td class="In1-td-bottom" align="center">手术日期</td></tr>
<c:forEach var="a" items="${wcs}" varStatus="b">
<tr><td height="25" class="<tagsold:getCss columns="2" columnIndex="0" rows="${fn:length(wcs)}" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.method}"/></td>
<td class="<tagsold:getCss columns="2" columnIndex="1" rows="${fn:length(wcs)}" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd"/></td></tr>
</c:forEach>
</table>
</td><td width="10">
&nbsp;
</td><td width="275" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="In1-table1">
<tr><td height="25" class="In1-td-rightbottom" align="center">应交金额</td><td class="In1-td-rightbottom" align="center">已交金额</td><td class="In1-td-bottom" align="center">交款日期</td></tr>
<c:forEach var="a" items="${wuds}" varStatus="b">
<tr>
<td height="25" class="<tagsold:getCss columns="3" columnIndex="0" rows="${fn:length(wuds)}" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${a.moneyh}" type="currency" pattern="￥.00"/></td>
<td class="<tagsold:getCss columns="3" columnIndex="1" rows="${fn:length(wuds)}" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${a.factMoney}" type="currency" pattern="￥.00"/></td>
<td class="<tagsold:getCss columns="3" columnIndex="2" rows="${fn:length(wuds)}" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd"/></td></tr>
</c:forEach>
</table>
</td></tr></table>