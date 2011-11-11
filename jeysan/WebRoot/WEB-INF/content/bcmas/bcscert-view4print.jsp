<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/print/Export.jsp" %>
<div style="font-size:14px;margin-top:5px;margin-left:263px">第一面</div>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
  .limitedwidth {width:543px;height:372px; font-size:12px}
  .In1-table1 {  border: 2px #000000 solid; font-size:12px}
  .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px; font-size:12px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .title_black { font-size: 14px;font-weight: bold;font-family: "宋体";}
  .none { font-size:12px}
 -->
 </style>
<div style="margin-left:5px;">
<table border="0" cellspacing="0" cellpadding="0"  class="limitedwidth">
<tr><td>

<table border="0" cellspacing="0" cellpadding="0">
<tr>
  <td width="255" height="372" valign="top" class="In1-table1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="46" height="37" align="center" valign="middle" class="In1-td-rightbottom">持证人<br/>姓名</td>
      <td rowspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="37" class="In1-td-rightbottom">&nbsp;${fertileWoman.nameh}</td>
          <td width="81" rowspan="2" class="In1-td-bottom"><img width="83" height="75" src="${ctx}/${children.photo}}" /></td>
        </tr>
        <tr>
          <td height="37" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${fertileWoman.person.personBasic.birthday}" pattern="yyyy-MM-dd" /></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">出生<br/>年月</td>
      </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">身份证<br/>号码</td>
      <td class="In1-td-bottom">&nbsp;${fertileWoman.person.code}</td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">户口<br/>地址</td>
      <td class="In1-td-bottom">&nbsp;${fertileWoman.person.personBasic.domicile}</td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">工作<br/>单位</td>
      <td class="In1-td-bottom">&nbsp;${fertileWoman.person.personBasic.company}</td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">发证<br/>机构</td>
      <td class="In1-td-bottom">&nbsp;${issOrg}</td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">发证<br/>地址</td>
      <td class="In1-td-bottom">&nbsp;${issOrgAddress}</td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">发证<br/>时间</td>
      <td class="In1-td-bottom">&nbsp;<fmt:formatDate value="${issDate}" pattern="yyyy-MM-dd" /></td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">经办人</td>
      <td class="In1-td-bottom">&nbsp;${agent}</td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-right">编号</td>
      <td>&nbsp;${certCode}</td>
    </tr>
  </table></td></tr></table> 
</td>
<td width="33">&nbsp;</td>
 <td width="255" height="372" valign="top" class="In1-table1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
     <td height="24" align="center" valign="middle" class="title_black In1-td-bottom">婚育情况记录</td>
   </tr>
 </table>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td width="43" height="48" align="center" valign="middle" class="In1-td-rightbottom">婚姻<br/>状况</td>
       <td width="55" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${fertileWoman.person.personBasic.marryStatus}"/></td>
       <td width="43" align="center" valign="middle" class="In1-td-rightbottom">结婚<br/>
         时间</td>
       <td class="In1-td-bottom">&nbsp;<fmt:formatDate value="${fertileWoman.person.personBasic.firstMarryDate}" pattern="yyyy-MM-dd" /></td>
     </tr>
   </table>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td height="24" align="center" valign="middle" class="In1-td-rightbottom">配偶姓名</td>
       <td colspan="2" class="In1-td-rightbottom">&nbsp;${spouse.nameh}</td>
       <td align="center" valign="middle" class="In1-td-rightbottom">年龄</td>
       <td class="In1-td-bottom">&nbsp;${spouse.age}</td>
     </tr>
     <tr>
       <td height="24" align="center" valign="middle" class="In1-td-rightbottom">子女姓名</td>
       <td align="center" valign="middle" class="In1-td-rightbottom">性别</td>
       <td align="center" valign="middle" class="In1-td-rightbottom">出生年月</td>
       <td align="center" valign="middle" class="In1-td-rightbottom">政策内外</td>
       <td align="center" valign="middle" class="In1-td-bottom">出生证号</td>
     </tr>
<c:forEach var="a" items="${childs1}">
     <tr>
       <td height="25" class="In1-td-rightbottom">&nbsp;${a.nameh}</td>
       <td class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${a.sex}"/></td>
       <td class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" /></td>
       <td class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${a.policy}"/></td>
       <td class="In1-td-bottom">&nbsp;${a.birthCert}</td>
     </tr>
</c:forEach>
<c:if test="${fn:length(childs1)<6}">
<c:forEach begin="0" end="${6-(fn:length(childs1))-1}">
     <tr>
       <td height="25" class="In1-td-rightbottom">&nbsp;</td>
       <td class="In1-td-rightbottom">&nbsp;</td>
       <td class="In1-td-rightbottom">&nbsp;</td>
       <td class="In1-td-rightbottom">&nbsp;</td>
       <td class="In1-td-bottom">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
     <tr>
       <td height="26" colspan="5" align="center" valign="middle" class="In1-td-bottom title_black">收养子女情况登记</td>
       </tr>
     <tr>
       <td height="26" align="center" valign="middle" class="In1-td-rightbottom">姓名</td>
       <td align="center" valign="middle" class="In1-td-rightbottom">性别</td>
       <td align="center" valign="middle" class="In1-td-rightbottom">收养时间</td>
       <td align="center" valign="middle" class="In1-td-rightbottom">政策内外</td>
       <td align="center" valign="middle" class="In1-td-bottom">收养证号</td>
     </tr>
<c:forEach var="a" items="${childs2}">
     <tr>
       <td height="25" class="In1-td-rightbottom">&nbsp;${a.nameh}</td>
       <td class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${a.sex}"/></td>
       <td class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${a.adoptDate}" pattern="yyyy-MM-dd" /></td>
       <td class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${a.policy}"/></td>
       <td class="In1-td-bottom">&nbsp;${a.adoptCept}</td>
     </tr>
</c:forEach>
<c:if test="${fn:length(childs2)<2}">
<c:set var="tmpRows" value="${2-(fn:length(childs2))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="25" class="<tagsold:getCss columns="5" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
   </table></td></tr></table>
</div>
</form>

<div style="font-size:14px;margin-top:5px;margin-left:263px">第二面</div>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
  .limitedwidth {width:543px;height:372px;}
  .In1-table1 {  border: 2px #000000 solid; font-size:12px}
  .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px; font-size:12px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .title_black { font-size: 14px;font-weight: bold;font-family: "宋体";}
  .none { font-size:12px}
 -->
 </style>
<div style="margin-left:5px;">
<table border="0" cellspacing="0" cellpadding="0"  class="limitedwidth">
<tr><td>

<table border="0" cellspacing="0" cellpadding="0">
<tr>
  <td width="255" height="372" valign="top" class="In1-table1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="22" colspan="3" align="center" valign="middle" class="In1-td-bottom title_black">婚育学校学习情况记录</td>
      </tr>
    <tr>
      <td width="33%" height="22" align="center" valign="middle" class="In1-td-rightbottom">学习时间</td>
      <td width="33%" align="center" valign="middle" class="In1-td-rightbottom">学习内容</td>
      <td width="33%" align="center" valign="middle" class="In1-td-bottom">学习地点</td>
    </tr>
<c:forEach var="a" items="${wfps}">
    <tr>
      <td height="22" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${a.eduDate}" pattern="yyyy-MM-dd" /></td>
      <td class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${a.eduType}"/></td>
      <td class="In1-td-bottom">&nbsp;${a.eduAddress}</td>
    </tr>
</c:forEach>
<c:if test="${fn:length(wfps)<4}">
<c:forEach begin="0" end="${4-(fn:length(wfps))-1}">
    <tr>
      <td height="22" class="In1-td-rightbottom">&nbsp;</td>
      <td class="In1-td-rightbottom">&nbsp;</td>
      <td class="In1-td-bottom">&nbsp;</td>
    </tr>
</c:forEach>
</c:if>
  </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="22" align="center" valign="middle" class="title_black In1-td-bottom">一孩生育服务情况记录</td>
      </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="36" height="110" align="center" valign="middle" class="In1-td-rightbottom">一孩<br/>生育<br/>登记<br/>部门<br/>意见</td>
        <td width="224" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="88" valign="middle" class="In1-td-bottom">&nbsp;${fcr.deptOpt}</td>
          </tr>
          <tr>
            <td height="22" align="right" class="In1-td-bottom">经办人：${fcr.agent}&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="40" align="center" valign="middle" class="In1-td-rightbottom">生育<br/>合同</td>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="63" height="20" align="center" valign="middle" class="In1-td-rightbottom">时间</td>
            <td class="In1-td-bottom">&nbsp;<fmt:formatDate value="${fcr.dateh}" pattern="yyyy-MM-dd" /></td>
          </tr>
          <tr>
            <td width="63" height="20" align="center" valign="middle" class="In1-td-rightbottom">编号</td>
            <td class="In1-td-bottom">&nbsp;${fcr.code}</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="22" colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="110" height="25" align="center" valign="middle" class="In1-td-rightbottom">一孩出生预产期</td>
            <td class="In1-td-bottom">&nbsp;<fmt:formatDate value="${fcr.edd}" pattern="yyyy-MM-dd" /></td>
            </tr>
          </table></td>
      </tr>
      <tr>
        <td height="43" align="center" valign="middle" class="In1-td-right">备<br/>注</td>
        <td>&nbsp;${fcr.remark}</td>
      </tr>
    </table></td></tr></table> 
</td>
<td width="33">&nbsp;</td>
 <td width="255" height="372" valign="top" class="In1-table1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
     <td height="24" align="center" valign="middle" class="title_black In1-td-bottom">二孩生育服务情况记录</td>
   </tr>
 </table>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td width="43" height="84" align="center" valign="middle" class="In1-td-rightbottom">二孩<br/>生育<br/>申请</td>
       <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td width="76" height="18" align="center" valign="middle" class="In1-td-rightbottom">申请时间</td>
           <td class="In1-td-bottom">&nbsp;<fmt:formatDate value="${ba.dateh}" pattern="yyyy-MM-dd" /></td>
         </tr>
         <tr>
           <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td width="38" height="48" align="center" valign="middle" class="In1-td-rightbottom">申请<br/>理由</td>
               <td class="In1-td-bottom">&nbsp;${ba.cond}</td>
             </tr>
           </table></td>
           </tr>
         <tr>
           <td height="18" align="center" valign="middle" class="In1-td-rightbottom">申请编号</td>
           <td class="In1-td-bottom">&nbsp;${ba.code}</td>
         </tr>
       </table></td>
       </tr>
   </table>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td width="43" height="110" align="center" valign="middle" class="In1-td-rightbottom">二孩<br/>生育<br/>登记<br/>部门<br/>意见</td>
       <td colspan="2" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="88" valign="middle" class="In1-td-bottom">&nbsp;${ba.birth2Check.deptOpt}</td>
          </tr>
          <tr>
            <td height="22" align="right" class="In1-td-bottom">经办人：${ba.birth2Check.checkor}&nbsp;</td>
          </tr>
        </table></td>
       </tr>
     <tr>
       <td rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">生育<br/>合同</td>
       <td width="63" height="20" align="center" class="In1-td-rightbottom">时间</td>
       <td width="126" class="In1-td-bottom">&nbsp;<fmt:formatDate value="${ba.birth2Check.dateh}" pattern="yyyy-MM-dd" /></td>
     </tr>
     <tr>
       <td width="63" height="20" align="center" class="In1-td-rightbottom">编号</td>
       <td class="In1-td-bottom">&nbsp;${ba.birth2Check.code}</td>
     </tr>
     <tr>
       <td height="22" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">取环时间</td>
       <td class="In1-td-bottom">&nbsp;<fmt:formatDate value="${ba.birth2Check.noContraceptDdate}" pattern="yyyy-MM-dd" /></td>
     </tr>
     <tr>
       <td height="22" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">二孩出生计划</td>
       <td class="In1-td-bottom">&nbsp;<fmt:formatDate value="${ba.birth2Check.edd}" pattern="yyyy-MM-dd" /></td>
     </tr>
     <tr>
       <td height="70" align="center" valign="middle" class="In1-td-right">备<br/>注</td>
       <td colspan="2">&nbsp;${ba.birth2Check.remark}</td>
       </tr>
   </table></td></tr></table>
</div>
</form>

<div style="font-size:14px;margin-top:5px;margin-left:263px">第三面</div>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
  .limitedwidth {width:543px;height:372px;}
  .In1-table1 {  border: 2px #000000 solid; font-size:12px}
  .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px; font-size:12px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .title_black { font-size: 14px;font-weight: bold;font-family: "宋体";}
  .none { font-size:12px}
 -->
 </style>
<div style="margin-left:5px;">
<table border="0" cellspacing="0" cellpadding="0"  class="limitedwidth">
<tr><td>

<table border="0" cellspacing="0" cellpadding="0">
<tr>
  <td width="255" height="372" valign="top" class="In1-table1">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="22" align="center" valign="middle" class="title_black In1-td-bottom">避孕节育知情选择情况记录</td>
      </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%" height="22" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">措施种类</td>
        <td width="33%" align="center" valign="middle" class="In1-td-rightbottom">手术时间</td>
        <td width="33%" align="center" valign="middle" class="In1-td-bottom">手术医生</td>
      </tr>
      <tr>
        <td height="22" colspan="2" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${wcs[0].method}"/></td>
        <td class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${wcs[0].opsDate}" pattern="yyyy-MM-dd" /></td>
        <td class="In1-td-bottom">&nbsp;${wcs[0].doctor}</td>
      </tr>
      <tr>
        <td width="15" height="71" align="center" valign="middle" class="In1-td-rightbottom">备<br/>注</td>
        <td width="50" class="In1-td-rightbottom">&nbsp;</td>
        <td colspan="2" class="In1-td-bottom">&nbsp;</td>
        </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%" height="22" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">措施种类</td>
        <td width="33%" align="center" valign="middle" class="In1-td-rightbottom">手术时间</td>
        <td width="33%" align="center" valign="middle" class="In1-td-bottom">手术医生</td>
      </tr>
      <tr>
        <td height="22" colspan="2" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${wcs[1].method}"/></td>
        <td class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${wcs[1].opsDate}" pattern="yyyy-MM-dd" /></td>
        <td class="In1-td-bottom">&nbsp;${wcs[1].doctor}</td>
      </tr>
      <tr>
        <td width="15" height="71" align="center" valign="middle" class="In1-td-rightbottom">备<br/>注</td>
        <td width="50" class="In1-td-rightbottom">&nbsp;</td>
        <td colspan="2" class="In1-td-bottom">&nbsp;</td>
        </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%" height="22" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">措施种类</td>
        <td width="33%" align="center" valign="middle" class="In1-td-rightbottom">手术时间</td>
        <td width="33%" align="center" valign="middle" class="In1-td-bottom">手术医生</td>
      </tr>
      <tr>
        <td height="22" colspan="2" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${wcs[2].method}"/></td>
        <td class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${wcs[2].opsDate}" pattern="yyyy-MM-dd" /></td>
        <td class="In1-td-bottom">&nbsp;${wcs[2].doctor}</td>
      </tr>
      <tr>
        <td width="15" height="72" align="center" valign="middle" class="In1-td-right">备<br/>注</td>
        <td width="50" class="In1-td-right">&nbsp;</td>
        <td colspan="2">&nbsp;</td>
        </tr>
    </table>
    </td></tr></table> 
</td>
<td width="33">&nbsp;</td>
 <td width="255" height="372" valign="top" class="In1-table1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
     <td height="24" align="center" valign="middle" class="title_black In1-td-bottom">计划生育奖励优待情况记录</td>
   </tr>
 </table>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td width="15%" height="24" align="center" valign="middle" class="In1-td-rightbottom">项目</td>
       <td width="25%" align="center" valign="middle" class="In1-td-rightbottom">办理时间</td>
       <td width="45%" align="center" valign="middle" class="In1-td-rightbottom">内容</td>
       <td width="15%" align="center" valign="middle" class="In1-td-bottom">经办人</td>
     </tr>
     <tr>
       <td height="82" align="center" valign="middle" class="In1-td-rightbottom">独生<br/>子女<br/>优待</td>
       <td class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${was1.awardDate}" pattern="yyyy-MM-dd" /></td>
       <td class="In1-td-rightbottom">&nbsp;${was1.awardContent}</td>
       <td class="In1-td-bottom">&nbsp;${was1.agent}</td>
     </tr>
     <tr>
       <td height="82" align="center" valign="middle" class="In1-td-rightbottom">农村<br/>养老<br/>保险</td>
       <td class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${was2.awardDate}" pattern="yyyy-MM-dd" /></td>
       <td class="In1-td-rightbottom">&nbsp;${was2.awardContent}</td>
       <td class="In1-td-bottom">&nbsp;${was2.agent}</td>
     </tr>
     <tr>
       <td height="159" align="center" valign="middle" class="In1-td-right">其他<br/>优待<br/>奖励</td>
       <td class="In1-td-right">&nbsp;<fmt:formatDate value="${was3.awardDate}" pattern="yyyy-MM-dd" /></td>
       <td class="In1-td-right">&nbsp;${was3.awardContent}</td>
       <td>&nbsp;${was3.agent}</td>
     </tr>
   </table></td></tr></table>
</div>
</form>

<div style="font-size:14px;margin-top:5px;margin-left:263px">第四面</div>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
  .limitedwidth {width:543px;height:372px;}
  .In1-table1 {  border: 2px #000000 solid; font-size:12px}
  .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px; font-size:12px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .title_black { font-size: 14px;font-weight: bold;font-family: "宋体";}
  .none { font-size:12px}
 -->
 </style>
<div style="margin-left:5px;">
<table border="0" cellspacing="0" cellpadding="0"  class="limitedwidth">
<tr><td>

<table border="0" cellspacing="0" cellpadding="0">
<tr>
  <td width="255" height="372" valign="top" class="In1-table1">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="22" align="center" valign="middle" class="title_black In1-td-bottom">征收社会抚养费情况记录</td>
      </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="39" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="33" height="42" align="center" valign="middle" class="In1-td-rightbottom">征收<br/>理由</td>
            <td class="In1-td-bottom">&nbsp;${wsu.cause}</td>
          </tr>
        </table></td>
        </tr>
      
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="25%" height="22" align="center" valign="middle" class="In1-td-rightbottom">征收机关</td>
        <td colspan="3" align="center" valign="middle" class="In1-td-bottom">&nbsp;${wsu.lodOrg}</td>
        </tr>
      <tr>
        <td height="22" align="center" valign="middle" class="In1-td-rightbottom">决定书编号</td>
        <td width="25%" class="In1-td-rightbottom">&nbsp;${wsu.lodCode}</td>
        <td width="25%" align="center" valign="middle" class="In1-td-rightbottom">经办人</td>
        <td width="25%" class="In1-td-bottom">&nbsp;${wsu.lodCharger}</td>
      </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="22" colspan="2" align="center" valign="middle" class="In1-td-bottom">(<tags:js.yes.no.getValue value="${wsu.isInstallment}"/>)签订分期付款保证书</td>
        </tr>
      <tr>
        <td width="60" height="40" align="center" valign="middle" class="In1-td-rightbottom">应交金额<br/>(大写)</td>
        <td width="192" class="In1-td-bottom">&nbsp;${wsu.totalMoneyStr}</td>
        </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="25%" height="22" align="center" valign="middle" class="In1-td-rightbottom">时间</td>
        <td width="25%" align="center" valign="middle" class="In1-td-rightbottom">金额(元)</td>
        <td width="25%" align="center" valign="middle" class="In1-td-rightbottom">收据号码</td>
        <td width="25%" align="center" valign="middle" class="In1-td-bottom">收款人</td>
      </tr>
<c:forEach var="a" items="${wsu.detailList}" varStatus="b">
      <tr>
        <td width="25%" height="22" class="<tagsold:getCss columns="4" columnIndex="0" rows="8" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" /></td>
        <td width="25%" class="<tagsold:getCss columns="4" columnIndex="1" rows="8" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${a.factMoney}" type="currency" pattern="0.00"/></td>
        <td width="25%" class="<tagsold:getCss columns="4" columnIndex="2" rows="8" rowIndex="${b.index}"/>">&nbsp;${a.voucherCode}</td>
        <td width="25%" class="<tagsold:getCss columns="4" columnIndex="3" rows="8" rowIndex="${b.index}"/>">&nbsp;${a.charger}</td>
      </tr>
</c:forEach>
<c:if test="${fn:length(wsu.detailList)<8}">
<c:set var="tmpRows" value="${8-(fn:length(wsu.detailList))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="22" class="<tagsold:getCss columns="4" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="4" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="4" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="4" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
    </table></td></tr></table> 
</td>
<td width="33">&nbsp;</td>
 <td width="255" height="372" valign="top" class="In1-table1">
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td width="190" height="24" align="center" valign="middle" class="In1-td-rightbottom title_black">查环查孕服务情况记录</td>
       <td align="center" valign="middle" class="In1-td-bottom">检查人</td>
       </tr>

<c:forEach var="a" items="${dcos}" varStatus="b">
     <tr>
       <td height="44" valign="middle" class="<tagsold:getCss columns="2" columnIndex="0" rows="8" rowIndex="${b.index}"/>">&nbsp;${a.year}年第${a.seq}轮&nbsp;<tags:js.dict.getValue value="${a.dcResult1}"/>&nbsp;<tags:js.dict.getValue value="${a.dcResult2}"/><br/>双查时间：<fmt:formatDate value="${a.dcDate}" pattern="yyyy-MM-dd" /></td>
       <td align="center" valign="middle" class="<tagsold:getCss columns="2" columnIndex="1" rows="8" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
<c:if test="${fn:length(dcos)<8}">
<c:set var="tmpRows" value="${8-(fn:length(dcos))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="43" class="<tagsold:getCss columns="2" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="2" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
   </table></td></tr></table>
</div>
</form>

<div style="font-size:14px;margin-top:5px;margin-left:263px">第六面</div>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
  .limitedwidth {width:543px;height:372px; font-size:12px}
  .In1-table1 {  border: 2px #000000 solid; font-size:12px}
  .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px; font-size:12px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .title_black { font-size: 14px;font-weight: bold;font-family: "宋体";}
  .none { font-size:12px}
 -->
 </style>
<div style="margin-left:5px;">
<table border="0" cellspacing="0" cellpadding="0"  class="limitedwidth">
<tr><td>

<table border="0" cellspacing="0" cellpadding="0">
<tr>
  <td width="255" height="372" valign="top" class="In1-table1">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="22" colspan="3" align="center" valign="middle" class="title_black In1-td-bottom">查病服务情况记录</td>
        </tr>
      <tr>
        <td height="22" align="center" valign="middle" class="In1-td-rightbottom">检查<br/>时间</td>
        <td align="center" valign="middle" class="In1-td-rightbottom">检查处理结果</td>
        <td align="center" valign="middle" class="In1-td-bottom">医生<br/>签名</td>
      </tr>
      <tr>
        <td height="63" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;</td>
        <td valign="middle" class="In1-td-rightbottom">&nbsp;</td>
        <td align="center" valign="middle" class="In1-td-bottom">&nbsp;</td>
      </tr>
      <tr>
        <td height="63" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;</td>
        <td valign="middle" class="In1-td-rightbottom">&nbsp;</td>
        <td align="center" valign="middle" class="In1-td-bottom">&nbsp;</td>
      </tr>
      <tr>
        <td height="63" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;</td>
        <td valign="middle" class="In1-td-rightbottom">&nbsp;</td>
        <td align="center" valign="middle" class="In1-td-bottom">&nbsp;</td>
      </tr>
      <tr>
        <td height="63" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;</td>
        <td valign="middle" class="In1-td-rightbottom">&nbsp;</td>
        <td align="center" valign="middle" class="In1-td-bottom">&nbsp;</td>
      </tr>
      <tr>
        <td height="63" align="center" valign="middle" class="In1-td-right">&nbsp;</td>
        <td valign="middle" class="In1-td-right">&nbsp;</td>
        <td align="center" valign="middle">&nbsp;</td>
      </tr>
    </table></td></tr></table> 
</td>
<td width="33">&nbsp;</td>
 <td width="255" height="372" valign="top" class="In1-table1">
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td height="22" align="center" valign="middle" class="In1-td-bottom title_black">特殊情况记录</td>
       </tr>
     <tr>
       <td height="93" valign="middle">&nbsp;</td>
       </tr>
     <tr>
       <td height="22" align="right" valign="middle" class="In1-td-bottom">记录人：XXX&nbsp;&nbsp;</td>
       </tr>
     <tr>
       <td height="93" valign="middle">&nbsp;</td>
       </tr>
     <tr>
       <td height="22" align="right" valign="middle" class="In1-td-bottom">记录人：XXX&nbsp;&nbsp;</td>
       </tr>
     <tr>
       <td height="93" valign="middle">&nbsp;</td>
       </tr>
     <tr>
       <td height="22" align="right" valign="middle" class="none">记录人：XXX&nbsp;&nbsp;</td>
       </tr>
   </table></td></tr></table>
</div>
</form>

<div style="font-size:14px;margin-top:5px;margin-left:263px">第七面</div>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
  .limitedwidth {width:543px;height:372px;}
  .In1-table1 {  border: 2px #000000 solid; font-size:12px}
  .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px; font-size:12px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px; font-size:12px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-size:12px}
  .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-size:12px}
  .title_black { font-size: 14px;font-weight: bold;font-family: "宋体";}
  .none { font-size:12px}
 -->
 </style>
<div style="margin-left:5px;">
<table width="252" height="372"  border="0" cellspacing="0" cellpadding="0" class="In1-table1">
     <tr>
       <td height="22" align="center" valign="middle" class="title_black In1-td-bottom">查验记录</td>
       </tr>
<c:forEach var="a" items="${bccs}" varStatus="b">
     <tr>
       <td height="22" valign="middle" class="<tagsold:getCss columns="1" columnIndex="0" rows="10" rowIndex="${b.index}"/>">&nbsp;内容：${a.content}&nbsp;日期：<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" />&nbsp;经办人：${a.agent}</td>
     </tr>
</c:forEach>
<c:if test="${fn:length(bccs)<10}">
<c:set var="tmpRows" value="${10-(fn:length(bccs))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="22" class="<tagsold:getCss columns="1" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
   </table>
</div>
</form>

