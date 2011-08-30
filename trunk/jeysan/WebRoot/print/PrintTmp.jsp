<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page import="java.util.*"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="com.kingtrend.commons.util.DateUtil"%>
<%@page import="com.kingtrend.commons.page.PageSupport"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/print/Export.jsp"%>

<%!
	 List ToMapList(List list,String[] property){
		  List result = new ArrayList();
		  for(Object o : list){
			  
			  result.add(converseObjToMap(o, property));
			  
		  }
		  return result;
	}
 Map converseObjToMap(Object obj,String[] property){
	 
	Map map = null;
	try {
		Class clazz = obj.getClass();
		  map = new HashMap();
		  for(int i = 0; i < property.length; i++){
			  if(property[i].indexOf("_") == -1){
				  if(property[i].indexOf(".") != -1){
					  String[] tmp = property[i].split("\\.");
					  Method get = null;
					 // try{
					  	get = clazz.getMethod("get"+StringUtils.capitalise(tmp[0]));
					    Object tmp2 = get.invoke(obj);
						Method get2 = tmp2.getClass().getMethod("get"+StringUtils.capitalise(tmp[1]));
						map.put(property[i], get2.invoke(tmp2));
					//  }catch(Exception e){
					//	get = clazz.getMethod("get"+StringUtils.capitalise(property[i]));  
					//	map.put(property[i], get.invoke(obj));
					//  }
					
				  }else{
					  Method get = clazz.getMethod("get"+StringUtils.capitalise(property[i]));
					  Class type = get.getReturnType();
					  Object result = get.invoke(obj);
					  if(type.getName() == "java.util.Date" && result != null) 
						  map.put(property[i], DateUtil.convertDateToString((Date)result, "yyyy-MM-dd"));
					  else
						  map.put(property[i], result);
					}
			  }else{
				  String pro = property[i].substring(0,property[i].indexOf("_"));
				  if(map.get(pro) == null){
					  Method get = clazz.getMethod("get"+StringUtils.capitalise(pro));
					  Object result = get.invoke(obj);
					  map.put(property[i],result);
				  }else{
				 	 map.put(property[i],map.get(pro));
				  }
			  }
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	  
	  return map;
}
%>
<%
String[] propertys = (String[])request.getAttribute("propertys");;
PageSupport result = (PageSupport)request.getAttribute("result");
List list = ToMapList(result.getItems(), propertys);
request.setAttribute("list",list);
%>
<c:forEach var="i" begin="1" end="${fn:length(list)%25 == 0?fn:length(list)/25:fn:length(list)/25+1}">
 <form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
       <!--
     .limitedwidth {height: 297mm;width: 190mm;}
     .In1-table1 {  border: 2px #000000 solid;font-size:12;width: 190mm;}
     .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px}
     .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px}
     .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px}
     .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px}
     .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px}
     .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px}
     .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px}
     .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px}
     .title_black {
         font-size: 18px;
         font-weight: bold;
        font-family: "宋体";
     }
     .STYLE1 {border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px; font-weight: bold; }
      -->
 </style>
<div align="center">
  <table border="0" cellspacing="0" cellpadding="0"  class="limitedwidth">
 <tr>
    <td colspan="3" valign="top"><table width="100%">

  <tr><td colspan="2">&nbsp;</td>
    <td height="24" align="center" class="title_black">&nbsp;${title }</td>
  <td  colspan="2" class="title_black">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td class="In1-td-top">&nbsp;</td>
    <td  colspan="2">&nbsp;</td>
  </tr>
   </table>
  <table border="0" cellpadding="0" cellspacing="0" class="In1-table1" align="center">

    <tr>
     <c:forEach var="head" items="${texts}" varStatus="status" >
       <td height="30" align="center" valign="middle" class="<kt:getCssForPrint index1="${status.index}" index2="${fn:length(texts)-1}" defaultCss="In1-td-rightbottom" replaceCss="In1-td-bottom"/>"><p>&nbsp;${head}</p></td>
     </c:forEach>
    </tr>
     <c:forEach var="map" items="${list}" varStatus="status" begin="${(i-1)*25}" end="${i*25-1}">
    <tr>
    	<c:forEach var="property" items="${propertys}">
      <td  height="30" align="center" valign="middle"  class="<kt:getCssForPrint index1="${status.index}" index2="${fn:length(propertys)-1}" defaultCss="In1-td-rightbottom" replaceCss="In1-td-right"/>"><p>&nbsp;
     <c:set var="flag" value="false"></c:set>
      <c:if test="${not empty dicts}">
      	<c:forEach var="dict" items="${dicts}">
      		<c:if test="${dict == property}">
      			<kt:dictionary value="${map[property]}"></kt:dictionary>
      			<c:set var="flag" value="true"></c:set>
      		</c:if>
      	</c:forEach>
      </c:if>
      <c:if test="${not empty employs}">
      		<c:forEach var="employ" items="${employs}">
      		<c:if test="${employ == property && !fn:contains(property, '_')}">
      			<kt:getItemNameDefKt type="2"  value="${map[property]}"></kt:getItemNameDefKt>
      			<c:set var="flag" value="true"></c:set>
      		</c:if>
      		<c:if test="${employ == property && fn:contains(property, '_')}">
      			<kt:getItemNameDefKt type="2"  value="${map[property]}" property="${fn:split(property,'_')[1]}"></kt:getItemNameDefKt>
      			<c:set var="flag" value="true"></c:set>
      		</c:if>
      	</c:forEach>
      </c:if>
      <c:if test="${not empty departs}">
      		<c:forEach var="depart" items="${departs}">
      		<c:if test="${depart == property && !fn:contains(property, '_')}">
      			<kt:getItemNameDefKt type="1"  value="${map[property]}"></kt:getItemNameDefKt>
      			<c:set var="flag" value="true"></c:set>
      		</c:if>
      		<c:if test="${depart == property && fn:contains(property, '_')}">
      			<kt:getItemNameDefKt type="1"  value="${map[property]}" property="${fn:split(property,'_')[1]}"></kt:getItemNameDefKt>
      			<c:set var="flag" value="true"></c:set>
      		</c:if>
      	</c:forEach>
      </c:if>
      <c:if test="${not empty epts}">
      		<c:forEach var="ept" items="${epts}">
      		<c:if test="${ept == property && !fn:contains(property, '_')}">
      			<kt:getItemNameDefKt type="3"  value="${map[property]}"></kt:getItemNameDefKt>
      			<c:set var="flag" value="true"></c:set>
      		</c:if>
      		<c:if test="${ept == property && fn:contains(property, '_')}">
      			<kt:getItemNameDefKt type="3"  value="${map[property]}" property="${fn:split(property,'_')[1]}"></kt:getItemNameDefKt>
      			<c:set var="flag" value="true"></c:set>
      		</c:if>
      	</c:forEach>
      </c:if>
	  <c:if test="${!flag}">
	  		 ${map[property]}
	  </c:if>   
      </p></td>
        </c:forEach>
    </tr>
    </c:forEach>
  </table>
   </td>
 </tr>
  <tr>
    <td colspan="3" valign="top">&nbsp;</td>
  </tr>

  <tr>
    <td colspan="3" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr><jsp:useBean id="date" class="java.util.Date"/>
        <td width="10%" align="center" height="20">编制日期：</td>
        <td width="9%" align="left"><fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/> </td>
        <td width="10%" align="center">编制者：</td>
        <td width="8%" >${SESSION_FROM_CACHE_ORG_OSS_CODE}</td>
        <td width="10%" align="center">编制单位：</td>
        <td width="10%" >${SESSION_FROM_CACHE_ORG_NAME}</td>
        <td width="10%" align="center">审核单位：</td>
        <td width="13%" class="In1-td-bottom">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
   <tr><td colspan="3" height="40"></td></tr>
</table><hr clear=all style='page-break-before:always;width: 190mm' align="center">
</div>
</form>
</c:forEach>
