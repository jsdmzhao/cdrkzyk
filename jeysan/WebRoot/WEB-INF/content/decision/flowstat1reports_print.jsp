<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.commons.beanutils.BeanUtils"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/print/Export.jsp" %>
<c:set var="datas" value="${results}"/>
<c:set var="n" value="25"/><!-- 每页显示条数 -->
<c:set var="c" value="${fn:length(datas)%n == 0?(fn:length(datas)/n):((fn:length(datas)-fn:length(datas)%n)/n+1)}"/><!-- 共有页数 -->
<c:forEach var="i" begin="1" end="${c}"><!-- 每页循环 -->
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
<c:if test="${param.pager_type==null||param.pager_type=='A4'}">
  .limitedwidth {height: 285mm;width: 190mm;}
  .In1-table1 {  border: 2px #000000 solid;font-size:12;width: 190mm;}
</c:if>
<c:if test="${param.pager_type=='A3'}">
  .limitedwidth {height: 285mm;width: 410mm;}
  .In1-table1 {  border: 2px #000000 solid;font-size:12;width: 410mm;}
</c:if>
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
<center>
<div style="margin:auto;">
	<table border="0" cellspacing="0" cellpadding="0"  class="limitedwidth">
 		<tr><td colspan="3" valign="top">
 			<table width="100%">
 				<tr><td colspan="2">&nbsp;</td>
    				<td height="24" align="center" class="title_black">&nbsp;${param.title}</td>
 					 <td colspan="2" class="title_black">&nbsp;</td></tr>
				<tr><td colspan="2">&nbsp;</td>
				    <td class="In1-td-top">&nbsp;</td>
				    <td  colspan="2">&nbsp;</td></tr></table>
			 <table border="0" cellpadding="0" cellspacing="0" class="In1-table1" align="center">
<tr>
    <td height="30" rowspan="4" align="center" valign="middle" class="In1-td-rightbottom">序号</td>
    <td height="30" rowspan="4" align="center" valign="middle" class="In1-td-rightbottom">单位</td>
    <td height="30" colspan="13" align="center" valign="middle" class="In1-td-rightbottom">出生</td>
    <td height="30" colspan="13" align="center" valign="middle" class="In1-td-bottom">计划生育手术</td>
  </tr>
  <tr>
    <td height="30" colspan="3" align="center" valign="middle" class="In1-td-rightbottom">一孩</td>
    <td  height="30"colspan="4" align="center" valign="middle" class="In1-td-rightbottom">二孩</td>
    <td  height="30"colspan="3" align="center" valign="middle" class="In1-td-rightbottom">三孩及以上</td>
    <td  height="30"rowspan="3" align="center" valign="middle" class="In1-td-rightbottom">合计</td>
    <td  height="30"rowspan="3" align="center" valign="middle" class="In1-td-rightbottom">与去年同期相比(+,-)</td>
    <td  height="30"rowspan="3" align="center" valign="middle" class="In1-td-rightbottom">政策生育率(%)</td>
    <td  height="30"colspan="5" align="center" valign="middle" class="In1-td-rightbottom">结扎</td>
    <td  height="30"colspan="2" align="center" valign="middle" class="In1-td-rightbottom">放环(花)</td>
    <td  height="30"colspan="3" align="center" valign="middle" class="In1-td-rightbottom">补救措施</td>
    <td  height="30"rowspan="3" align="center" valign="middle" class="In1-td-rightbottom">皮下埋植</td>
    <td  height="30"rowspan="3" align="center" valign="middle" class="In1-td-rightbottom">合计</td>
    <td  height="30"rowspan="3" align="center" valign="middle" class="In1-td-bottom">与去年同期相比(+,-)</td>
  </tr>
  <tr>
    <td height="30" rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">人数</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">%</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">其中政策内人数</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">人数</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">%</td>
    <td  height="30"height="30" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">其中政策内</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">人数</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">%</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">其中政策内人数</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">男结扎</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">女结扎</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">小计</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">其中二孩结扎</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">其中纯二女扎</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">小计</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">其中一孩上环</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">补救措施一</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">补救措施二</td>
    <td  height="30"rowspan="2" align="center" valign="middle" class="In1-td-rightbottom">小计</td>
  </tr>
  <tr>
    <td height="30" align="center" valign="middle" class="In1-td-rightbottom">人数</td>
    <td  height="30"align="center" valign="middle" class="In1-td-rightbottom">占二孩%</td>
  </tr>
<c:set var="index2" value="${i==c?(fn:length(datas)-1):(i*n-1)}"/>
<c:forEach var="data" items="${datas}" varStatus="status" begin="${(i-1)*n}" end="${index2}">
<tr>
<td height="30" align="center" valign="middle" class="${status.index==index2?'In1-td-right':'In1-td-rightbottom'}">
<p>&nbsp;${status.index+1}</p>
</td>
	<c:forEach var="head" items="${heads}" varStatus="b">
		<td height="30" align="center" valign="middle"  class="<tagsold:getCss columns="${fn:length(heads)}" columnIndex="${b.index}" rows="${index2+1}" rowIndex="${status.index}"/>">
	    	<p>&nbsp;<tags:js.class.getProperty obj="${data}" property="${head.b}" type="${head.c}"/></p>
		</td>
	</c:forEach>
</tr>
</c:forEach>
  			</table></td></tr>
  			
 		<tr><td colspan="3" valign="top">&nbsp;</td></tr>
 		
 		<tr><td colspan="3" valign="top">
 			<table width="100%" border="0" cellpadding="0" cellspacing="0">
     			 <tr><jsp:useBean id="date" class="java.util.Date"/>
			        <td width="10%" align="center" height="20">编制日期：</td>
			        <td width="9%" align="left"><fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/> </td>
			        <td width="10%" align="center">编制者：</td>
			        <td width="8%" >${_js_user.userName}</td>
			        <td width="10%" align="center">编制单位：</td>
			        <td width="10%" >高新区计生局</td>
			        <td width="10%" align="center">审核单位：</td>
			        <td width="13%" class="In1-td-bottom">&nbsp;</td></tr></table></td></tr>
			        
		<tr><td colspan="3" height="40"></td></tr></table>
		
<c:if test="${param.pager_type==null||param.pager_type=='A4'}">
<hr clear=all style='page-break-before:always;width: 190mm' align="center">
</c:if>
<c:if test="${param.pager_type=='A3'}">
<hr clear=all style='page-break-before:always;width: 410mm' align="center">
</c:if>

</div>
</center>
</form>
</c:forEach>