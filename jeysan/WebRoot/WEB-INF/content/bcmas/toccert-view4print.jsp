<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/print/Export.jsp" %>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
  .limitedwidth {height: 285mm;width: 190mm;}
  .In1-table1 {  border: 2px #000000 solid;width:432px;height:388px}
  .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px}
  .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px}
  .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px}
  .title_black { font-size: 18px;font-weight: bold;font-family: "宋体";}
  .STYLE1 { border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-weight: bold; }
 -->
 </style>
<div style="margin:5px;">
<table border="0" cellspacing="0" cellpadding="0"  class="In1-table1">
<tr>
  <td width="58" height="110" align="center" valign="middle" class="In1-td-rightbottom">孩<br/><br/>子</td>
  <td align="left" valign="top" class="In1-td-bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="60" height="37" align="center" valign="middle" class="In1-td-rightbottom">姓名</td>
      <td colspan="3" valign="middle" class="In1-td-rightbottom">&nbsp;${children.nameh}</td>
      <td width="106" rowspan="3" align="center" valign="middle"><img width="104" height="108" src="${ctx}/${children.photo}" /></td>
    </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-rightbottom">性别</td>
      <td width="70" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${children.sex}"/></td>
      <td width="60" align="center" class="In1-td-rightbottom">民族</td>
      <td valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${children.native}"/></td>
      </tr>
    <tr>
      <td height="37" align="center" valign="middle" class="In1-td-right">出生</td>
      <td colspan="3" valign="middle" class="In1-td-right">&nbsp;<fmt:formatDate value="${children.birthday}" pattern="yyyy年MM月dd日"/></td>
      </tr>
  </table></td>
</tr>
<tr>
  <td height="65" align="center" valign="middle" class="In1-td-rightbottom">父<br/>亲</td>
  <td class="In1-td-bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="32" align="center" valign="middle" class="In1-td-rightbottom">姓&nbsp;名</td>
      <td valign="middle" class="In1-td-bottom">&nbsp;${person.sex==1?person.nameh:spouse.nameh}</td>
    </tr>
    <tr>
      <td width="90" height="32" align="center" valign="middle" class="In1-td-right">工作单位</td>
      <td valign="middle">&nbsp;${person.sex==1?person.company:spouse.company}</td>
    </tr>
  </table></td>
</tr>
<tr>
  <td height="65" align="center" valign="middle" class="In1-td-rightbottom">母<br/>亲</td>
  <td align="left" valign="top" class="In1-td-bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="32" align="center" valign="middle" class="In1-td-rightbottom">姓&nbsp;名</td>
      <td valign="middle" class="In1-td-bottom">&nbsp;${person.sex==2?person.nameh:spouse.nameh}</td>
    </tr>
    <tr>
      <td width="90" height="32" align="center" valign="middle" class="In1-td-right">工作单位</td>
      <td valign="middle">&nbsp;${person.sex==2?person.personBasic.company:spouse.company}</td>
    </tr>
  </table></td>
</tr>
<tr>
  <td height="78" align="center" valign="middle" class="In1-td-rightbottom">发<br/>证<br/>机<br/>关</td>
  <td valign="middle" class="In1-td-bottom">&nbsp;${issOrg}</td>
</tr>
<tr>
  <td height="30" align="center" valign="middle" class="In1-td-rightbottom">日期</td>
  <td valign="middle" class="In1-td-bottom">&nbsp;<fmt:formatDate value="${issDate}" pattern="yyyy年MM月dd日"/></td>
</tr>
<tr>
  <td height="30" align="center" valign="middle" class="In1-td-right">编号</td>
  <td valign="middle">&nbsp;${certCode}</td>
</tr>
</table>
</div>
</form>