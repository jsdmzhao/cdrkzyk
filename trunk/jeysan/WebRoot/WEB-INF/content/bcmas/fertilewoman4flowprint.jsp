<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/print/Export.jsp" %>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
	table tr td {font-size:12px}
  .limitedwidth {width:977px;height:610px;}
  .In1-table1 {  border: 2px #000000 solid;}
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
<table border="0" cellpadding="0" cellspacing="0" class="limitedwidth">
  		<tr>
  		  <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
  		    <tr>
  		      <td width="529" height="591" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
  		        <tr>
  		          <td height="30" colspan="2" align="center" valign="middle" class="title_black">流动人口信息卡</td>
	            </tr>
  		        <tr>
  		          <td width="110" height="24">流动人口编号：</td>
  		          <td>&nbsp;${model.code}</td>
	            </tr>
	          </table>
  		        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
  		          <tr>
  		            <td height="535" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
  		              <tr>
  		                <td width="15%" height="40" align="center">建卡日期</td>
  		                <td width="35%" class="In1-td-right">&nbsp;<fmt:formatDate value="${model.createDate}" pattern="yyyy-MM-dd"/></td>
  		                <td width="50%">&nbsp;&nbsp;育龄妇女户籍地编码</td>
	                  </tr>
  		              <tr>
  		                <td height="60" align="center" class="In1-td-bottom">流入地</td>
  		                <td height="60" class="In1-td-rightbottom">&nbsp;${pi.inAddress}</td>
  		                <td class="In1-td-bottom">&nbsp;${model.person.personBasic.domicileCode}</td>
	                  </tr>
	                </table>
  		              <table width="100%" border="0" cellspacing="0" cellpadding="0">
  		                <tr>
  		                  <td height="25" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">姓名</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">出生日期</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">身份证号码</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">持证情况</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">验证日期</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">结婚日期</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">流入日期</td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">居住地类型</td>
	                    </tr>
  		                <tr>
  		                  <td height="25" align="center" valign="middle" class="In1-td-rightbottom">本人</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${model.nameh}</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${model.person.personBasic.birthday}" pattern="yyyy-MM-dd"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${model.person.code}</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${model.person.personBasic.haveStatus}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${model.person.personBasic.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${pi.inDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">&nbsp;<tags:js.dict.getValue value="${model.person.personBasic.addressType}"/></td>
	                    </tr>
  		                <tr>
  		                  <td height="25" align="center" valign="middle" class="In1-td-rightbottom">配偶</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${spouse.nameh}</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${spouse.birthday}" pattern="yyyy-MM-dd"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${spouse.code}</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${spouse.haveStatus}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${model.person.personBasic.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${pi.spouseInDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">&nbsp;<tags:js.dict.getValue value="${spouse.addressType}"/></td>
	                    </tr>
                    </table>
  		              <table width="100%" border="0" cellspacing="0" cellpadding="0">
  		                <tr>
  		                  <td width="16%" height="40" align="center" valign="middle" class="In1-td-rightbottom">流动原因</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${pi.inCause}</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">居住地编号</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${model.person.personBasic.addressCode}</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">婚姻状况</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-bottom">&nbsp;<tags:js.dict.getValue value="${model.person.personBasic.marryStatus}"/></td>
	                    </tr>
                    </table>
  		              <table width="100%" border="0" cellspacing="0" cellpadding="0">
  		                <tr>
  		                  <td width="16%" height="40" align="center" valign="middle" class="In1-td-rightbottom">居住地详细地址</td>
  		                  <td colspan="5" valign="middle" class="In1-td-bottom">&nbsp;${model.person.personBasic.address}</td>
	                    </tr>
  		                <tr>
  		                  <td height="25" align="center" valign="middle" class="In1-td-rightbottom">户籍地邮编</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${model.person.personBasic.domicileZipCode}</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">居住地电话</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${model.person.personBasic.tel}</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">计生证明号</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-bottom">&nbsp;${bc.certCode}</td>
	                    </tr>
  		                <tr>
  		                  <td height="60" align="center" valign="middle" class="In1-td-rightbottom">计生证有效期</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<c:if test="${not empty bc.validPeroid}">至<fmt:formatDate value="${bc.validPeroid}" pattern="yyyy-MM-dd"/>截止</c:if></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">工作单位</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-bottom">&nbsp;${model.person.personBasic.company}</td>
	                    </tr>
                    </table>
  		              <table width="100%" border="0" cellspacing="0" cellpadding="0">
  		                <tr>
  		                  <td height="45" colspan="7" align="center" valign="middle" class="In1-td-bottom title_black">社会抚养费</td>
	                    </tr>
  		                <tr>
  		                  <td height="25" align="center" valign="middle" class="In1-td-rightbottom">征收原因</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">应交金额</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">已交金额</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">本次缴交金额</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">交款次数</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">交款日期</td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">收款人</td>
	                    </tr>
<c:forEach var="a" items="${wsu.detailList}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="25" align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;${wsu.cause}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${wsu.totalMoney}" type="currency" pattern="￥.00"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${wsu.yetMoney}" type="currency" pattern="￥.00"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${a.factMoney}" type="currency" pattern="￥.00"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.counth}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="5" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="6" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.charger}</td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(wsu.detailList)<5}">
<c:set var="tmpRows" value="${5-(fn:length(wsu.detailList))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="25" class="<tagsold:getCss columns="7" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="5" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="6" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                    </table></td>
	              </tr>
              </table></td><td width="20">&nbsp;</td><td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="25" align="center" valign="middle" class="title_black">孕产动态</td>
                </tr>
              </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
                  <tr>
                    <td height="20" align="center" valign="middle" class="In1-td-rightbottom">现孕状况</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">怀孕日期</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">预产期</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">孕产结果</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">孕产日期</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">手术地点</td>
                    <td align="center" valign="middle" class="In1-td-bottom">变化原因</td>
                  </tr>
<c:forEach var="a" items="${wms}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="20" align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.currentConceptStatus}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.conceptDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.edd}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.matenalResult}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.endDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="5" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.hospital}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="6" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.changeCause}</td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(wms)<5}">
<c:set var="tmpRows" value="${5-(fn:length(wms))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="20" class="<tagsold:getCss columns="7" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="5" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="6" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="22" align="center" valign="middle" class="title_black">避孕动态</td>
                </tr>
              </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
                  <tr>
                    <td width="20%" height="20" align="center" valign="middle" class="In1-td-rightbottom">避孕节育措施</td>
                    <td width="20%" align="center" valign="middle" class="In1-td-rightbottom">手术日期</td>
                    <td width="20%" align="center" valign="middle" class="In1-td-rightbottom">手术地点</td>
                    <td width="20%" align="center" valign="middle" class="In1-td-rightbottom">统计类型</td>
                    <td width="20%" align="center" valign="middle" class="In1-td-bottom">未避孕原因</td>
                  </tr>

                  <c:forEach var="a" items="${wcs}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="20" align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.method}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.hospital}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.noCause}</td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(wcs)<5}">
<c:set var="tmpRows" value="${5-(fn:length(wcs))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="20" class="<tagsold:getCss columns="5" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="22" align="center" valign="middle" class="title_black">子女信息</td>
                </tr>
              </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
                  <tr>
                    <td height="20" align="center" valign="middle" class="In1-td-rightbottom">姓名</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">出生日期</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">性别</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">孩次</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">政策内外</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">出生地点</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">出生证号</td>
                    <td align="center" valign="middle" class="In1-td-bottom">血缘关系</td>
                  </tr>


                  <c:forEach var="a" items="${childs}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="20" align="center" valign="middle" class="<tagsold:getCss columns="8" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.nameh}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="8" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="8" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.sex}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="8" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.childIndex}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="8" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.policy}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="8" columnIndex="5" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.birthAddress}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="8" columnIndex="6" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.birthCert}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="8" columnIndex="7" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.kinship}"/></td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(childs)<5}">
<c:set var="tmpRows" value="${5-(fn:length(childs))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="20" class="<tagsold:getCss columns="8" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="8" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="8" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="8" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="8" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="8" columnIndex="5" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="8" columnIndex="6" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="8" columnIndex="7" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                </table>
                
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="22" align="center" valign="middle" class="title_black">行政处罚</td>
                </tr>
              </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
                  <tr>
                    <td width="20%" height="20" align="center" valign="middle" class="In1-td-rightbottom">处罚原因</td>
                    <td width="20%" align="center" valign="middle" class="In1-td-rightbottom">处罚金额</td>
                    <td width="20%" align="center" valign="middle" class="In1-td-rightbottom">处罚次数</td>
                    <td width="20%" align="center" valign="middle" class="In1-td-rightbottom">处罚日期</td>
                    <td width="20%" align="center" valign="middle" class="In1-td-bottom">经办人</td>
                  </tr>

                  <c:forEach var="a" items="${wps}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="20" align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.punishCause}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${a.moneyh}" type="currency" pattern="￥.00"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.count}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.punishDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="5" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.agent}</td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(childs)<5}">
<c:set var="tmpRows" value="${5-(fn:length(childs))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="20" class="<tagsold:getCss columns="5" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="5" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                </table>
                </td>
	        </tr>
  		    <tr>
  		      <td height="22" colspan="3">&nbsp;备注</td>
	        </tr>
      </table></td></tr>	
    </table>
</div>